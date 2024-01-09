package com.sunbeam.beans;

import com.sunbeam.daos.ReviewDao;
import com.sunbeam.daos.ReviewDaoImpl;

public class DeleteReview {
	int id;
    boolean status;
    
    
	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public DeleteReview() {
		super();
	}
	
	public void delete() 
	{
		status=false;
		try(ReviewDao rdao=new ReviewDaoImpl()) {
			int cnt=rdao.deleteById(this.id);
			if(cnt==1) 
			{
				status=true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
