package com.sunbeam.beans;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class LoginBean {

	private String email;
	private String password;
	private User user;

	public LoginBean() {

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void fetchUser() {

		try (UserDao uDao = new UserDaoImpl()) {
//			System.out.println(email);
//			System.out.println(password);
			User u = uDao.findByEmail(email);

//			System.out.println(u);

			if (u != null && u.getPassword().equals(password)) {

				this.user = u;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
