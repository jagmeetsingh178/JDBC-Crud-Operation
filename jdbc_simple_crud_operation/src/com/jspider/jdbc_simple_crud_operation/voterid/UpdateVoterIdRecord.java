package com.jspider.jdbc_simple_crud_operation.voterid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateVoterIdRecord {
public static void main(String[] args) {
		
	Connection connection = null;
		//Step 1 Load \ Register Driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Step 2 Create Connection
			String url = "jdbc:mysql://localhost:3306/jdbc-a3";
			String username = "root";
			String password = "jaggi@74041313";
			
			 connection = DriverManager.getConnection(url, username, password);
			
			//Step-3 Create Statement
			Statement statement =connection.createStatement();
			
			//Step-4 Execute Query
			String UpdateQuery = "update voterid set id=101 where id=100";
			int a = statement.executeUpdate(UpdateQuery);
			
			if(a==1)
			{
				System.out.println("Update Record Successfully");
			}
			else {
				System.out.println("Update Record Not Successfully");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
