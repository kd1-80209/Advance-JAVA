package com.sunbeam.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sunbeam.Utils.DateUtil;
import com.sunbeam.Utils.DbUtil;
import com.sunbeam.pojos.Users;

public class UserDaoImpl  implements UserDao {
	private Connection con;

	public UserDaoImpl() {
		try {
			this.con = DbUtil.getConnection();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int save(Users u) throws Exception {
		String sql = "INSERT INTO users(id, first_name, last_name, email, mobile, birth, password) VALUES(default, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, u.getFirst_name());
			stmt.setString(2, u.getLast_name());
			stmt.setString(3, u.getEmail());
			stmt.setString(4, u.getPhone_no());
			stmt.setDate(5, DateUtil.utilToSqlDate(u.getBirth_date()));
			stmt.setString(6, u.getPassword());
			int count = stmt.executeUpdate();
			return count;
		} // stmt.close();
	}

	@Override
	public int update(Users u) throws Exception {

		String sql = "UPDATE users SET first_name=?, last_name=?, mobile=?, birth=? WHERE id=?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, u.getFirst_name());
			stmt.setString(2, u.getLast_name());
			stmt.setString(3, u.getEmail());
			stmt.setDate(4, DateUtil.utilToSqlDate(u.getBirth_date()));
			stmt.setInt(5, u.getId());
			int count = stmt.executeUpdate();
			return count;
		} // stmt.close();
	}

	@Override
	public int updatePassword(int userId, String newPassword) throws Exception {
		String sql = "UPDATE users SET password=? WHERE id=?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, newPassword);

			stmt.setInt(2, userId);
			int count = stmt.executeUpdate();
			return count;
		} // stmt.close();
	}

	@Override
	public Users findByEmail(String email) throws Exception {
		String sql = "SELECT * FROM users WHERE email=?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, email);
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					int id = rs.getInt("id");
					String fname = rs.getString("first_name");
					String lname = rs.getString("last_name");
					String password = rs.getString("password");
					email = rs.getString("email");
					String mobile = rs.getString("mobile");
					Date uDate = DateUtil.sqlToUtilDate(rs.getDate("birth"));
					System.out.println(password);
					return new Users(id, fname, lname, email, password, mobile, uDate);
				}
			} // rs.close();
		} // stmt.close();
		return null;
	}

	@Override
	public List<Users> findAll() throws Exception {
		List<Users> list = new ArrayList<Users>();
		String sql = "SELECT * FROM users";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					int id = rs.getInt("id");
					String fname = rs.getString("first_name");
					String lname = rs.getString("last_name");
					String password = rs.getString("password");
					String email = rs.getString("email");
					String mobile = rs.getString("mobile");
					Date uDate = DateUtil.sqlToUtilDate(rs.getDate("birth"));
					Users u = new Users(id, fname, lname, email, password, mobile, uDate);
					list.add(u);
				}
			} // rs.close();
		} // stmt.close();
		return list;
	}

	@Override
	public void close() throws Exception {
         con.close();		
	}

	

}
