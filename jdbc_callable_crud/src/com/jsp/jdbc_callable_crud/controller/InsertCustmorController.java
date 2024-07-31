package com.jsp.jdbc_callable_crud.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class InsertCustmorController {

		public static void main(String[] args) {
			
			//Step-1 load/register Driver
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
			//Step-2 Create Connection
			String url="jdbc:mysql://localhost:3306/jdbc-a3";
			String username="root";
			String password="jaggi@74041313";
			
			Connection connection = DriverManager.getConnection(url, username, password);
			
			CallableStatement callableStatement = connection.prepareCall("call insertCustmor(?,?,?,?)");
			
			callableStatement.setInt(1, 1000);
			callableStatement.setString(2, "jagmeet");
			callableStatement.setString(3, "jagmeet@gmail.com");
			callableStatement.setLong(4, 324567890);
			
			callableStatement.execute();
			
			System.out.println("Data Insert Successfully");
		}
			catch(Exception e) {
				e.printStackTrace();
			}
}
}
