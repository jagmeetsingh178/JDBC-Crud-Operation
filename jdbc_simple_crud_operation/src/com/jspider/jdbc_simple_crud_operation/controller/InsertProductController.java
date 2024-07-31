package com.jspider.jdbc_simple_crud_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertProductController {

	public static void main(String[] args) {
		
		//Step-1 load/register Driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		//Step-2 Create Connection
		String url="jdbc:mysql://localhost:3306/jdbc-a3";
		String username="root";
		String password="jaggi@74041313";
		
		Connection connection = DriverManager.getConnection(url, username, password);
		
		//Step 3 Create Statement
		Statement statement = connection.createStatement();
		
		//Step 4 Execute Query
		String insertQuery ="insert into product(id,name,price,color) values(424,'marker','30','yellow')";
		String insertQuery1 ="insert into product(id,name,price,color) values(425,'marker','30','Green')";
		String insertQuery2 ="insert into product(id,name,price,color) values(426,'marker','30','Orange')";
		String insertQuery3 ="insert into product(id,name,price,color) values(427,'marker','25','White')";
		statement.execute(insertQuery);
		statement.execute(insertQuery1);
		statement.execute(insertQuery2);
		statement.execute(insertQuery3);
		
		
		
		System.out.println("Data Stored...");	
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("Data not Stored...");
		}
	}
	
}


