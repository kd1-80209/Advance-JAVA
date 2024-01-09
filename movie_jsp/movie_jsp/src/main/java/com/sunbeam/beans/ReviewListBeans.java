package com.sunbeam.beans;

import java.util.List;

import com.sunbeam.daos.MovieDao;
import com.sunbeam.daos.ReviewDao;
import com.sunbeam.daos.ReviewDaoImpl;
import com.sunbeam.pojos.Movies;
import com.sunbeam.pojos.Reviews;

public class ReviewListBeans {
	Movies moview;
	List<Reviews> reList;
	String type;
	int Uid;
	List<Movies> mlist;

	public List<Movies> getMlist() {
		return mlist;
	}

	public void setMlist(List<Movies> mlist) {
		this.mlist = mlist;
	}

	public int getUid() {
		return Uid;
	}

	public void setUid(int uid) {
		Uid = uid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Reviews> getReList() {
		return reList;
	}

	public void setReList(List<Reviews> reList) {
		this.reList = reList;
	}

	public Movies getMoview() {
		return moview;
	}

	public void setMoview(Movies moview) {
		this.moview = moview;
	}

	public void reviewList() {
		System.out.println("type :" + type);
		System.out.println("user id :" + Uid);
		if (this.type == null || type.equals("All")) {
			System.out.println("type :" + type);
			try (ReviewDao redao = new ReviewDaoImpl()) {
				reList = redao.findAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (type.equals("My")) {

			System.out.println("type :" + type);
			try (ReviewDao redao = new ReviewDaoImpl()) {
				reList = redao.findByUserId(this.Uid);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (type.equals("Shared")) {
			System.out.println("type :" + type);
			try (ReviewDao redao = new ReviewDaoImpl()) {
				reList=redao.getSharedWithUser(Uid);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	
}
