package com.jspider.jdbc_prepared_statement_crud_operation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.jspider.jdbc_prepared_statement_crud_operation.connection.StudentConnection;
import com.jspider.jdbc_prepared_statement_crud_operation.dto.Student;

public class StudentDao {
	
	PreparedStatement ps = null;
	Connection connection =StudentConnection.getStudentConnection();
	
	private final String INSERTSTUDENTQUERY = "insert into student(name, email, phone, dob, gender)values(?,?,?,?,?)";
	private final String DISPLAYSTUDENTQUERY = "select * from student";
	private final String UPDATE_STUDENT_NAME_BY_STUDENT_ID = "update student set name=? where id=?";
	private final String DELETE_STUDENT_BY_ID ="delete from student where id=?";
	private final String DISPLAY_SINGLE_STUDENT_ID = "select * from student where id =?";
	
	
	public Student saveStudentDao(Student student)
	{
		try {
			ps= connection.prepareStatement(INSERTSTUDENTQUERY);
			ps.setString(1, student.getName());
			ps.setString(2, student.getEmail());
			ps.setLong(3, student.getPhone());
			ps.setObject(4, student.getDob());
			ps.setString(5, student.getGender());
			ps.execute();
			return student;
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public Student[] displayAllStudentDao()
	{
		try {
			ps= connection.prepareStatement(DISPLAYSTUDENTQUERY);
			ResultSet rs = ps.executeQuery();
			Student[] st = new Student[10];
			int i=0;
			while(rs.next())
			{
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Long phone = rs.getLong("phone");
				LocalDate dob = rs.getDate("dob").toLocalDate();
				String gender = rs.getString("gender");
				
				
				Student student = new Student(id, name, email, phone,dob, gender);
					st[i]=student;
					i++;
			}
			return st;
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int updateStudentNameByStudentIdDao(String name, int id)
	{
		
		try {
			ps = connection.prepareStatement(UPDATE_STUDENT_NAME_BY_STUDENT_ID);
			ps.setString(1, name);
			ps.setInt(2, id);
			
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int deleteStudentByIdDao(int id)
	{
		try {
			ps = connection.prepareStatement(DELETE_STUDENT_BY_ID);
			ps.setInt(1, id);
			
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public Student getStudentByIdDao(int id)
	{
		try {
			ps = connection.prepareStatement(DISPLAY_SINGLE_STUDENT_ID);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Student student=null;
			
			while(rs.next())
			{
				int id1 = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Long phone = rs.getLong("phone");
				LocalDate dob = rs.getDate("dob").toLocalDate();
				String gender = rs.getString("gender");
				
				student = new Student(id, name, email, 0, dob, gender);
			}
			return student;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Student> saveMultipleStudentDao(List<Student> students)
	{
		try {
			ps=connection.prepareStatement(INSERTSTUDENTQUERY);
			for (Student student : students) {
			ps.setString(1, student.getName());
			ps.setString(2, student.getEmail());
			ps.setLong(3, student.getPhone());
			ps.setObject(4, student.getDob());
			ps.setString(5, student.getGender());
			ps.addBatch();
			}
			ps.executeBatch();
			return students;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
