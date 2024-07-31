package com.jspider.jdbc_simple_crud_operation.voterid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertVoterIdRecord 
{
	public static void main(String[] args) {
		
		//Step 1 Load \ Register Driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Step 2 Create Connection
			String url = "jdbc:mysql://localhost:3306/jdbc-a3";
			String username = "root";
			String password = "jaggi@74041313";
			
			Connection connection = DriverManager.getConnection(url, username, password);
			
			//Step-3 Create Statement
			Statement statement =connection.createStatement();
			
			//Step-4 Execute Query
			//String insertQuery = "insert into voterid(id,name,dob,address,Fname,gender)values(101,'jagmeet','2002-08-17','Yamunanagar','jaswant','male')";
			//String insertQuery1 = "insert into voterid(id,name,dob,address,Fname,gender)values(102,'Harkirat','2003-01-17','Yamunanagar','Bhupinder singh','male')";
			//String insertQuery2 = "insert into voterid(id,name,dob,address,Fname,gender)values(103,'Jot','2002-07-20','Yamunanagar','Ramesh Kumar','male')";
			//String insertQuery3 = "insert into voterid(id,name,dob,address,Fname,gender)values(104,'Daljeet','2002-12-02','Yamunanagar','Tarsem Singh','male')";
			String insertQuery4 = "insert into voterid(id,name,dob,address,Fname,gender)values(10412,'Kulwinder','2003-05-07','Yamunanagar','Manjeet Singh','Male')";
			//statement.execute(insertQuery);
			//statement.execute(insertQuery1);
			//statement.execute(insertQuery2);
			//statement.execute(insertQuery3);
			statement.execute(insertQuery4);
			
			System.out.println("Record Stored Successfully");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Record Not Stored");
		}
		
	}
}
