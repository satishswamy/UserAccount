package com.userAccounts.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.io.IOException;
import java.io.PrintWriter;


public class DBSignIn {
//	boolean login;
	public boolean DbAccess(String userId , String password) {
		ResultSet result = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/userdb","root","root");
			String query = "select password from users where userid=(?)";
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1,userId);
			result = preparedStatement.executeQuery();
			result.next();
			System.out.println("Result: "+ result.getString(1));
			if(password.equals(result.getString(1))) {
				return true;
			}
			/*
			 * if(password.equals(result.getString(1))) return true else login=false;
			 */
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * if(login) return true; else
		 */
			return false;
		
	}
	

}
