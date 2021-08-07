package com.example.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.controller.ReimbursementController;
import com.example.controller.LoginController;
import com.example.controller.SignOutController;
import com.example.controller.SessionController;
import com.fasterxml.jackson.core.JsonProcessingException;

public class ServletJSONHelper {

	public static void process(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException{
		System.out.println("In the ServletJSONHelper with URI: " + req.getRequestURI());
		switch(req.getRequestURI()) {
			case "/P1ERS/api/login"://change URI
				LoginController.login(req, res);
				break;
			case "/P1ERS/api/logout"://change URI
				SignOutController.logout(req, res);
				break;
			case "/P1ERS/api/reimbursement"://change URI
				ReimbursementController.handleReimb(req, res);
				break;
			case "/P1ERS/api/session"://change URI
				SessionController.getSession(req, res);
				break;
		}
	}
	
}
