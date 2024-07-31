package com.jspider.jdbc_simple_crud_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateProductController 
{
public static void main(String[] args) {
		
	Connection connection =null;		//To Close The Connection Accessible 
	
		//Step-1 load/register Driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		//Step-2 Create Connection
		String url="jdbc:mysql://localhost:3306/jdbc-a3";
		String username="root";
		String password="jaggi@74041313";
		
		 connection = DriverManager.getConnection(url, username, password);
		
		//Step 3 Create Statement
		Statement statement = connection.createStatement();
		
		//Step 4 Execute Query
		String updateProductColorQuery ="update product set id=423 where id=23";
		
		//This Method will return 0 or 1
		int a = statement.executeUpdate(updateProductColorQuery);
		
			if(a==1) {
				System.out.println("Data Update");
			}
			else
			{
				System.out.println("Given Primary Key is Not Present in Table");
			}
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
