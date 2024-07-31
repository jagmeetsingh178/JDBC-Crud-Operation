package com.jsp.jdbc_callable_crud.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class GetCustmorByIdController
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
		
		CallableStatement callableStatement = connection.prepareCall("call getCustomerById(?)");
		
		callableStatement.setInt(1, 1000);
		ResultSet resultSet = callableStatement.executeQuery();
		
		resultSet.next();
		
		System.out.println(resultSet.getInt("id"));
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
}
}
