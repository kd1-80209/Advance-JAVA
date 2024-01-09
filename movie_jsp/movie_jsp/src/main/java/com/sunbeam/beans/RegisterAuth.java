package com.sunbeam.beans;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.catalina.User;

import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.Users;

public class RegisterAuth {
	String first_name;
	String last_name;
	String email;
	String password;
	String phone_no;
	String birth_date;
	boolean status;

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public RegisterAuth() {
		super();
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

	public String getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}

	public void register() {
		status = false;
		try (UserDaoImpl udao = new UserDaoImpl()) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = sdf.parse(birth_date);
			int cnt = udao.save(new Users(0, first_name, last_name, email, password, phone_no, date));
			if (cnt == 1) {
				status = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
