package com.sunbeam.beans;

import com.sunbeam.daos.ReviewDao;
import com.sunbeam.daos.ReviewDaoImpl;
import com.sunbeam.pojos.Reviews;

public class EditReview {
	private int mid;
	private int rid;
	private int rating;
	private String review;
	private int uid;
	boolean status;

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public EditReview() {
		super();
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public void editReview() {
		status=false;
		Reviews r=new Reviews(rid, mid, review, rating, uid, null);
		System.out.println(r);
		try (ReviewDao rdao = new ReviewDaoImpl()) {
			int cnt = rdao.update(r);
			if (cnt == 1) {
				status=true;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
