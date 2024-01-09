package com.sunbeam.beans;

import com.sunbeam.daos.ReviewDao;
import com.sunbeam.daos.ReviewDaoImpl;
import com.sunbeam.pojos.Reviews;

public class GetReviewById {
	int id;
	Reviews review;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Reviews getReview() {
		return review;
	}

	public void setReview(Reviews review) {
		this.review = review;
	}

	public GetReviewById() {
		super();
	}

	public void findById() {
		try(ReviewDao rev=new ReviewDaoImpl()) {
			review=rev.findById(id);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
