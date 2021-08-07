package com.example.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.ReimbursementDaoHib;
import com.example.dao.UsersDao;
import com.example.dao.UsersDaoHib;
import com.example.model.Reimbursement;
import com.example.model.ReimbursementStatus;
import com.example.model.ReimbursementType;
import com.example.model.Users;
import com.example.services.ReimbursementServices;
import com.example.services.UserServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class ReimbursementController {

	private static ReimbursementDaoHib rDao = new ReimbursementDaoHib();
	private static UsersDaoHib uDao = new UsersDaoHib();
	private static UserServices uServ = new UserServices(uDao);
	private static ReimbursementServices rServ = new ReimbursementServices(rDao, uDao);
	
	
	public static void handleReimb(HttpServletRequest req, HttpServletResponse res) throws IOException, JsonProcessingException{
		if(req.getMethod().equals("GET")) {
			List<Reimbursement> reimb = rServ.selectAllReimb();
			System.out.println(reimb);
			res.addHeader("Access-Control-Allow-Origin", "*");
			res.setHeader("Access-Control-Allow-Methods", "GET");
			res.getWriter().write(new ObjectMapper().writeValueAsString(reimb));
			
		}
		else {//To read in stringified JSON data is a bit more complicated,
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
			
			
			
			int amount = Integer.parseInt(parsedObj.get("amount").asText());
			String des = parsedObj.get("des").asText();
			String username = parsedObj.get("username").asText(); 
			Users u = uServ.getUserByUsername(username);
			ReimbursementType type = rServ.selectByType();
			ReimbursementStatus status = rServ.selectByStatus();
			rServ.createReim(amount, des, u, status, type);
			
			ObjectNode ret = mapper.createObjectNode();
			ret.put("message", "successfully submitted a new reimbursment");
			res.addHeader("Access-Control-Allow-Origin", "*");
			res.setHeader("Access-Control-Allow-Methods", "POST");
			res.getWriter().write(new ObjectMapper().writeValueAsString(ret));
		}
	}
	

		
	}

