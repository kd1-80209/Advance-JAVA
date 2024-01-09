package com.sunbeam.beans;

import com.sunbeam.daos.ReviewDao;
import com.sunbeam.daos.ReviewDaoImpl;
import com.sunbeam.pojos.Reviews;

public class AddReview {
	int uid;
	int mid;
	String review;
	int rating;
	boolean status;
	
	
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public AddReview() {
	
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public void addReview()
	{
		status=false;
		try(ReviewDao revdao=new ReviewDaoImpl()) {
			System.out.println("satus :"+status);
			
			int cnt=revdao.save(new Reviews(0,mid,review,rating,uid,null));
			
			if(cnt==1){
				System.out.println(cnt);
				status=true;
				System.out.println("satus :"+status);

			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
	

}
