package com.sunbeam.beans;

import com.sunbeam.daos.ReviewDao;
import com.sunbeam.daos.ReviewDaoImpl;

public class ShareBean {
	private int rid;
	private int uid;
	boolean status;

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public ShareBean() {
		super();
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public void share() {
		status = false;
		try (ReviewDao rev = new ReviewDaoImpl()) {
			int cnt = rev.shareReview(uid, rid);
			if (cnt == 2) {
				status = true;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
