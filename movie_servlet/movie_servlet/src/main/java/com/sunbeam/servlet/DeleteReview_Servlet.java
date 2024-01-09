package com.sunbeam.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.ReviewDao;
import com.sunbeam.daos.ReviewDaoImpl;

@WebServlet("/DeleteReview")
public class DeleteReview_Servlet extends HttpServlet{
 @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String id=req.getParameter("id");
      System.out.println(id);
	 try(ReviewDao re=new ReviewDaoImpl()) {
		int cnt= re.deleteById(Integer.parseInt(id));
		if(cnt==1){
			resp.sendRedirect("movielist?type=my");
		}
		
	} catch (Exception e) {
		// TODO: handle exception
	}
}
}
