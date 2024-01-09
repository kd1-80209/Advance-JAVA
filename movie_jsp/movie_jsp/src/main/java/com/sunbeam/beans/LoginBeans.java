package com.sunbeam.beans;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.Users;

public class LoginBeans {
	String email;
	String password;
	boolean status;
	Users user;
	
	
	
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
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
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public void authentication()
	{
		status=false;
		try(UserDao udao=new UserDaoImpl()) {
			Users u=udao.findByEmail(email);
			System.out.println(u);
			System.out.println(password);
			if(u !=null && u.getPassword().equals(password))
			{
			   this.user=u;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	

}
