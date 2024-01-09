package com.sunbeam.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sunbeam.pojos.Movies;
import com.sunbeam.Utils.*;

public class MovieDaoImpl  implements MovieDao {
	private Connection con;

	
	
	public MovieDaoImpl() {
		try {
			this.con = DbUtil.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Movies> findAll() throws Exception {
		List<Movies> list = new ArrayList<>();
		String sql = "SELECT * FROM movies";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					int id = rs.getInt("id");
					String title = rs.getString("title");
					Date modified = DateUtil.sqlToUtilDate(rs.getDate("rel_date"));
					Movies m = new Movies(id, title, modified);
					list.add(m);
				}
			} // rs.close();
		} // stmt.close();
		return list;
	}

	@Override
	public Movies findById(int id) throws Exception {

		String sql = "SELECT * FROM movies WHERE id=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			try(ResultSet rs = stmt.executeQuery()) {
				if(rs.next()) {
					id = rs.getInt("id");
					String title = rs.getString("title");
					Date modified = DateUtil.sqlToUtilDate(rs.getDate("rel_date"));
					Movies m = new Movies(id, title, modified);
					return m;
				}
			} // rs.close();
		} // stmt.close();
		return null;
	}

	@Override
	public void close() throws Exception {
		con.close();
		
	}

}
