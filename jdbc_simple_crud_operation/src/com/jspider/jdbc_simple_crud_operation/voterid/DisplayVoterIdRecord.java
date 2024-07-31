	 package com.jspider.jdbc_simple_crud_operation.voterid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplayVoterIdRecord 
{
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
					String DisplayVoterIdRecord = "select * from voterid";
					ResultSet rs = statement.executeQuery(DisplayVoterIdRecord);
					
					while(rs.next())
					{
						int id = rs.getInt("id");
						String name = rs.getString("name");
						String dob = rs.getString("dob");
						String address = rs.getString("address");
						String Fname = rs.getString("Fname");
						String gender = rs.getString("gender");
						
						System.out.println("Id is : "+id);
						System.out.println("Name is : "+name);
						System.out.println("Date of Birthday is :"+dob);
						System.out.println("Address is : "+address);
						System.out.println("Father Name is "+Fname);
						System.out.println("Gender is "+gender);
						System.out.println("======================");
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
