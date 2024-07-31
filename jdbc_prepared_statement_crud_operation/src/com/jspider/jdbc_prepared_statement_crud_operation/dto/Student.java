package com.jspider.jdbc_prepared_statement_crud_operation.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
/**
 * @author Jagmeet Singh
 */
public class Student implements Serializable{
	
	
	
	private int id;
	private String name;
	private String email;
	private long phone;
	private LocalDate dob;
	private String gender;
		
	/**
	 * This Constructor will Display The records
	 * @param id
	 * @param name
	 * @param email
	 * @param phone
	 * @param dob
	 * @param gender
	 */
	// alt+s+a Parameterized and non Parameterized Constructor
	public Student(int id, String name, String email, long phone, LocalDate dob, String gender) {
		super();
		
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.dob = dob;
		this.gender = gender;
	}
	
	/**
	 * This Constructor will insert the records in table
	 * @param name
	 * @param email
	 * @param phone
	 * @param dob
	 * @param gender
	 */
	public Student(String name, String email, long phone, LocalDate dob, String gender) {
		super();
		
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.dob = dob;
		this.gender = gender;
	}


	//Alt+S+R to generate getter setter method
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}


	//to generate toString() alt+shift+s+s+a(Recommeded)
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", dob=" + dob + ", gender="+gender+"]";
	}
	
	//to generate hashcode() and equals Method Alt+Shift+s+h
	@Override
	public int hashCode() {
		return Objects.hash(dob, email, id, name, phone);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(dob, other.dob) && Objects.equals(email, other.email) && id == other.id
				&& Objects.equals(name, other.name) && phone == other.phone;
	}
	
	
	
	
	
	
	
	
}
