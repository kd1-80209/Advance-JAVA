package com.sunbeam.pojos;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Users {
	private int id;
	private String first_name;
	private String last_name;
	private String email;
	private String password;
	private String phone_no;
	private Date birth_date;

	public Users() {
		super();
	}

	public Users(int id, String first_name, String last_name, String email, String password, String phone_no,
			Date birth_date) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
		this.phone_no = phone_no;
		this.birth_date = birth_date;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public Date getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}

	
	@Override
	public String toString() {
		return "Users [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
				+ ", password=" + password + ", phone_no=" + phone_no + ", birth_date=" + birth_date
				+  "]";
	}

	
	
}
