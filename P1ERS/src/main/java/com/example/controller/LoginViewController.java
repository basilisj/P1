package com.example.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;


public class LoginViewController {

	public static String fetchLoginPage(HttpServletRequest req) throws ServletException, IOException {
		System.out.println(req.getContentType());
		System.out.println("This should return the view login.html");
		return "resources/html/login.html";
		
	}
}
