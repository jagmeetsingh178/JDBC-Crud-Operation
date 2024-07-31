package com.jsp.jdbc_callable_crud.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class UpdateCustmorNameById 
{
	public static void main(String[] args) {
		//Step-1 load/register Driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		//Step-2 Create Connection
		String url="jdbc:mysql://localhost:3306/jdbc-a3";
		String username="root";
		String password="jaggi@74041313";
		
		Connection connection = DriverManager.getConnection(url, username, password);
		
		CallableStatement callableStatement = connection.prepareCall("call updateCustomerName(?,?)");
		callableStatement.setInt(1, 1000);
		callableStatement.setString(2, "jot");
		
		int result = callableStatement.executeUpdate();
		
		  if (result > 0) {
              System.out.println("Customer name updated successfully.");
          } else {
              System.out.println("No customer found with the given ID.");
          }
		  
		  callableStatement.close();
		  connection.close();
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
}
}
