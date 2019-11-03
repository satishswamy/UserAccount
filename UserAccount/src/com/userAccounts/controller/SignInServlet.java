package com.userAccounts.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.userAccounts.db.*;

public class SignInServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("userId");
		String password = req.getParameter("password");

		DBSignIn dbSignIn = new DBSignIn();
		boolean result = dbSignIn.DbAccess(userId, password);
		if (result) {
			System.out.println("Account Created");
			resp.sendRedirect("welcome.html");
		} else {
			System.out.println("Account creation Failed");
			resp.sendRedirect("fail.html");
		}
	}

}
