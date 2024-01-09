package com.sunbeam.beans;

import java.util.List;

import com.sunbeam.daos.MovieDao;
import com.sunbeam.daos.MovieDaoImpl;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.Movies;
import com.sunbeam.pojos.Users;

public class GetAllMovie {
	List<Movies> mlist;
	List<Users> ulist;
	
	

	public List<Users> getUlist() {
		return ulist;
	}

	public void setUlist(List<Users> ulist) {
		this.ulist = ulist;
	}

	public List<Movies> getMlist() {
		return mlist;
	}

	public void setMlist(List<Movies> mlist) {
		this.mlist = mlist;
	}
	
	public void allMovies() 
	{
		try(MovieDao moviedao=new MovieDaoImpl()) {
			mlist=moviedao.findAll();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void allUser() 
	{
		try(UserDaoImpl udao=new UserDaoImpl()) {
			ulist=udao.findAll();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
 
}
