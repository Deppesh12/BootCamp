package com.cg.hcm.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity // Specifies that the class is an entity.
@Table(name="pusers") // Specifies the primary table for the annotated entity
public class Users 
{
	@Id // This annotation specifies the primary key of an entity
	@Column(name = "user_id") // This annotation enables you to customize the columns
	private int userId;
	@Column(name = "password")
	private String password;
	@Column(name="user_name")
	private String userName;
	@Column(name="email")
	private String emailId;
	@Column(name="gender")
	private String gender;
	@Column(name="age")
	private int age;
	
	// Default Constructor
	public Users() {
		super();
	}


	public Users(int userId, String password, String userName, String emailId, String gender,int age) // Constructor with parameters and initialization 
	{
		super();
		this.userId = userId;
		this.password = password;
		this.userName = userName;
		this.emailId = emailId;
		this.gender = gender;
		this.age=age;
	}

	// Setters and Getters
	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}
	
}