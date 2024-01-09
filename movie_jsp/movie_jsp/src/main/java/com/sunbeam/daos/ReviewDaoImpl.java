package com.sunbeam.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sunbeam.pojos.Reviews;
import com.sunbeam.pojos.Users;
import com.sunbeam.pojos.Movies;
import com.sunbeam.Utils.*;

public class ReviewDaoImpl implements ReviewDao {
	private Connection con;

	public ReviewDaoImpl() {
		try {
			this.con = DbUtil.getConnection();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Override
	public int save(Reviews r) throws Exception {
		String sql = "INSERT INTO reviews(id, movie_id, review, rating, user_id, modified) VALUES(default, ?, ?, ?, ?, now())";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, r.getMovie_id());
			stmt.setString(2, r.getReview());
			stmt.setInt(3, r.getRating());
			stmt.setInt(4, r.getUser_id());
			int count = stmt.executeUpdate();
			return count;
		} // stmt.close();
	}

	@Override
	public int update(Reviews r) throws Exception {
		String sql = "UPDATE reviews SET movie_id=?, review=?, rating=?, user_id=?, modified=now() WHERE id=?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, r.getMovie_id());
			stmt.setString(2, r.getReview());
			stmt.setInt(3, r.getRating());
			stmt.setInt(4, r.getUser_id());
			stmt.setInt(5, r.getId());
			int count = stmt.executeUpdate();
			return count;
		} // stmt.close();
	}

	@Override
	public List<Reviews> findAll() throws Exception {
		List<Reviews> list = new ArrayList<Reviews>();
		String sql = "SELECT * FROM reviews ORDER BY modified DESC";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					int id = rs.getInt("id");
					int movieId = rs.getInt("movie_id");
					String review = rs.getString("review");
					int rating = rs.getInt("rating");
					int userId = rs.getInt("user_id");
					Timestamp modified = rs.getTimestamp("modified");
					Reviews r = new Reviews(id, movieId, review, rating, userId, modified);
					list.add(r);
				}
			} // rs.close();
		} // stmt.close();
		return list;
	}

	@Override
	public List<Reviews> findByUserId(int userId) throws Exception {
		List<Reviews> list = new ArrayList<Reviews>();
		String sql = "SELECT * FROM reviews WHERE user_id=? ORDER BY modified DESC";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, userId);
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					int id = rs.getInt("id");
					int movieId = rs.getInt("movie_id");
					String review = rs.getString("review");
					int rating = rs.getInt("rating");
					int usrId = rs.getInt("user_id");
					Timestamp modified = rs.getTimestamp("modified");
					Reviews r = new Reviews(id, movieId, review, rating, userId, modified);
					list.add(r);
				}
			} // rs.close();
		} // stmt.close();
		return list;
	}

	@Override
	public List<Reviews> getSharedWithUser(int userId) throws Exception {
		List<Reviews> list = new ArrayList<Reviews>();
		String sql = "SELECT r.* FROM reviews r INNER JOIN shares s ON r.id=s.review_id WHERE s.user_id=? ORDER BY modified DESC";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, userId);
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					int id = rs.getInt("id");
					int movieId = rs.getInt("movie_id");
					String review = rs.getString("review");
					int rating = rs.getInt("rating");
					int usrId = rs.getInt("user_id");
					Timestamp modified = rs.getTimestamp("modified");
					Reviews r = new Reviews(id, movieId, review, usrId, rating, modified);
					list.add(r);
				}
			} // rs.close();
		} // stmt.close();
		return list;
	}

	@Override
	public Reviews findById(int id) throws Exception {
		String sql = "SELECT * FROM reviews WHERE id=?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					id = rs.getInt("id");
					int movieId = rs.getInt("movie_id");
					String review = rs.getString("review");
					int rating = rs.getInt("rating");
					int usrId = rs.getInt("user_id");
					Timestamp modified = rs.getTimestamp("modified");
					Reviews r = new Reviews(id, movieId, review, rating, usrId, modified);
					return r;
				}
			} // rs.close();
		} // stmt.close();
		return null;
	}

	@Override
	public int deleteById(int reviewId) throws Exception {
		String sql = "DELETE FROM reviews WHERE id=?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, reviewId);
			int count = stmt.executeUpdate();
			return count;
		}
	}

	@Override
	public int shareReview(int reviewId, int userId) throws Exception {
		String sql = "INSERT INTO shares(review_id, user_id) VALUES (?, ?)";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, reviewId);
			stmt.setInt(2, userId);
			int count = stmt.executeUpdate();
			return count;
		} catch (SQLIntegrityConstraintViolationException e) {
			// do nothing
		}
		return 0;
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
