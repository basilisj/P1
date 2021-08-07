package com.example.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.example.controller.LoginViewController;

public class RequestViewHelper {

	public static String process(HttpServletRequest req) throws IOException, ServletException{
		System.out.println("In the view dispatcher process method, with URI: " +req.getRequestURI());
		switch(req.getRequestURI()) {
		case "/P1ERS/login":
			return LoginViewController.fetchLoginPage(req);
			default:
				return "/P1ERS/login";
		}
	}
}
