package com.jspider.jdbc_prepared_statement_crud_operation.controller;

import java.time.LocalDate;
import java.util.*;

import com.jspider.jdbc_prepared_statement_crud_operation.dao.StudentDao;
import com.jspider.jdbc_prepared_statement_crud_operation.dto.Student;
import com.jspider.jdbc_prepared_statement_crud_operation.service.StudentService;
public class StudentController {
	public static void main(String[] args) {
		StudentDao dao = new StudentDao();
		StudentService ss = new StudentService();
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Enter Your Option");
			System.out.println("Press 1 For Insert");
			System.out.println("Press 2 For Display");
			System.out.println("Press 3 For Update");
			System.out.println("Press 4 For Delete");
			System.out.println("Press 5 For To Fetch Single Recors");
			System.out.println("Press 6 to Insert Multiple Record at a time");
			System.out.println("Press 7 to Exit");
			int input = sc.nextInt();
			sc.nextLine();
			switch(input)
			{
				case 1:{
					System.out.println("Enter the Name :"); 
					String name = sc.nextLine();
				
	
					System.out.println("Enter the Email :");
					String email = sc.next();
					
					System.out.println("Enter the Phone Number");
					long phone = sc.nextLong();
					
					System.out.println("Enter the Date-of-Birthday :");
					String dob = sc.next();
					
					System.out.println("Enter the Gender :");
					String gender = sc.next();
					Student student = new Student(name, email, phone, LocalDate.parse(dob), gender);
					
					Student student2 = ss.saveStudentService(student);
					if(student2!=null)
					{
						System.out.println("Data Stored Successfully....");
					}
					else {
						System.out.println("Data Not Stored.....");
						System.out.println("Please Check the Code.....");
						System.out.println("Please check Name Length Length should be enter within 8 character");
					}
				}
					break;
				case 2:{
					Student[] student = dao.displayAllStudentDao();
					for (Student student2 : student) {
						if(student2 != null)
						{
							System.out.println(student2);
						}
					}
				}
					break;
				case 3:{
					System.out.println("Enter Student Id to Update Student Name :");
					int id = sc.nextInt();
					
					System.out.println("Enter Student Name to Update :");
					String name  = sc.next();
					
					int value=dao.updateStudentNameByStudentIdDao(name, id);
					if(value==1)
					{
						System.out.println("Data Updated Successfully");
					}
					else {
						System.out.println("Data not Updated");
					}
				}
					break;
				case 4:{
					System.out.println("Enter the Student Id Where you have Deleted :");
					int id = sc.nextInt();
					
					int value=dao.deleteStudentByIdDao(id);
					if(value==1)
					{
						System.out.println("Data Deleted Successfully");
					}
					else {
						System.out.println("Data Not Delete");
					}
				}
					break;
				case 5:{
					System.out.println("Enter the Student id to display its record :");
					int id = sc.nextInt();
					Student student = dao.getStudentByIdDao(id);
					
					if(student !=null)
					{
						System.out.println(student);
					}
					
				}
					break;
				case 6:{
					System.out.println("How Many Student you want to add");
					int size = sc.nextInt();
					
					System.out.println("Enter the Student Details :");
					List<Student> students = new ArrayList<Student>();
					int j=1;
					for(int i=0; i<size; i++)
					{
						System.out.println("Enter the Name :"); 
						sc.nextLine();
						String name = sc.nextLine();
						
						System.out.println("Enter the Email :");
						String email = sc.next();
						
						System.out.println("Enter the Phone Number");
						long phone = sc.nextLong();
						
						System.out.println("Enter the Date-of-Birthday :");
						//YYYY-MM-DD
						String dob = sc.next();
						
						System.out.println("Enter the Gender :");
						String gender = sc.next();
					
						Student student = new Student(name, email, phone, LocalDate.parse(dob), gender);
						students.add(student);
						j++;
					}
					System.out.println("Record Save Successfully");
					dao.saveMultipleStudentDao(students);
					
				}
				break;
				case 7:{
					System.out.println("PROGRAM ENDS!!");
					return;
				}
					
				
			}
		}
	}
}
