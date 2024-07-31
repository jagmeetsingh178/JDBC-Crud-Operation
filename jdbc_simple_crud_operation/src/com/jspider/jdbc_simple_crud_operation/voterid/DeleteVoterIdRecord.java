package com.jspider.jdbc_simple_crud_operation.voterid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteVoterIdRecord {
	public static void main(String[] args) {
		Connection connection = null;
		
		//Step 1 Load\ Register Driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			//Step 2 Create Connection
			String url = "jdbc:mysql://localhost:3306/jdbc-a3";
			String username = "root";
			String password = "jaggi@74041313";
			connection = DriverManager.getConnection(url, username, password);
			
			
			//Step 3 Create State
			Statement statement = connection.createStatement();
			
			//Step 4 Execute Query
			String DeleteProductQuery = "delete from voterid where id=104";
		int a =	statement.executeUpdate(DeleteProductQuery);
			
			if(a==1) {
				System.out.println("Data Deleted Successfully");
			}
			else
			{
				System.out.println("Data Not Deleted");
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Record Not Deleted");
		}
		finally {
			try {
				connection.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
