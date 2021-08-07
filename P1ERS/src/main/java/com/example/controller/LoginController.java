package com.example.controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.UsersDao;
import com.example.dao.UsersDaoHib;
import com.example.model.Users;
import com.example.services.UserServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoginController {

	private static UsersDao uDao = new UsersDaoHib();
	private static UserServices uServ = new UserServices(uDao);
	
public static void login(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException{
		
		//To read in stringified JSON data is a bit more complicated,
		StringBuilder buffer = new StringBuilder();
		BufferedReader reader = req.getReader();
		
		String line;
		while((line = reader.readLine()) != null) {
			buffer.append(line);
			buffer.append(System.lineSeparator());
		}
		String data = buffer.toString();
		System.out.println(data);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode parsedObj = mapper.readTree(data);
		
		String username = parsedObj.get("username").asText();
		String password = parsedObj.get("password").asText();
		
		try {
			System.out.println("In the login attempt");
			Users u = uServ.signIn(username, password);
			System.out.println(u);
			//We will keep track of if the user is logged in by storing their id in the session
			req.getSession().setAttribute("id", u.getUserId());
			res.setStatus(HttpServletResponse.SC_OK);
			res.addHeader("Access-Control-Allow-Origin", "*");
			res.setHeader("Access-Control-Allow-Methods", "POST");
			res.getWriter().write(new ObjectMapper().writeValueAsString(u));
		}
		catch(Exception e) {
			e.printStackTrace();
			res.setStatus(HttpServletResponse.SC_FORBIDDEN);
			res.getWriter().println("Username or password incorrect");
		}
	}
}