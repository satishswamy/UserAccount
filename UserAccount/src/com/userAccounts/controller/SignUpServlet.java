package com.userAccounts.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.userAccounts.db.*;

public class SignUpServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("userId");
		String password = req.getParameter("password");
		
		DBSignUp dbSignUp = new DBSignUp();
		boolean result = dbSignUp.DbAccess(userId, password);
		if (result) { System.out.println("Account Created");
			resp.sendRedirect("success.html"); 
			}
		else { System.out.println("Account creation Failed");
			resp.sendRedirect("failed.html"); 
			}
	}

}
