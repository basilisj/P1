package com.example.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignOutController {

	public static void logout(HttpServletRequest req, HttpServletResponse res) throws IOException {
		//Log the user out by deleting their session
		req.getSession().invalidate();
		res.setStatus(200);
		res.getWriter().println("User logged out");
	}
}
