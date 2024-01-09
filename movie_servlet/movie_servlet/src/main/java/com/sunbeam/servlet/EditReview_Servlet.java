package com.sunbeam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.MovieDao;
import com.sunbeam.daos.MovieDaoImpl;
import com.sunbeam.daos.ReviewDao;
import com.sunbeam.daos.ReviewDaoImpl;
import com.sunbeam.pojos.Movies;
import com.sunbeam.pojos.Reviews;

@WebServlet("/editReview")
public class EditReview_Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Edit review</title>");
		out.println("</head>");
		out.println("<body>");
		out.println(
				"	<div align='center' style='height: 400px; width: 400px ; background-color:pink;align-content: center;margin-left: 600px;margin-top: 100px'>\r\n");

		out.println("<h3>Edit Review </h3><br></br><br></br>");
		try (ReviewDao redao = new ReviewDaoImpl()) {
			Reviews r = redao.findById(Integer.parseInt(id));
			MovieDao mdao = new MovieDaoImpl();
			Movies m = mdao.findById(r.getMovie_id());
			out.printf("<form method='POST' action='editReview?id=%s' >\r\n" + "",r.getId());

			out.printf(
					"Movie Id:<input type='number' name='Movies_id' value='%S' readonly='readonly' title='You Cannot Change'/><br><br>",
					r.getMovie_id());
			out.printf(
					"Movie Name:<input type='text' name='movies' value='%S' readonly='readonly' title='You Cannot Change'/><br><br>",
					m.getTitle());
			out.printf("Rating :<input type='number' name='rating' value='%s' title='Edit Rating'/><br><br>",
					r.getRating());
			out.printf(
					"User Id :<input type='number' name='userId' value='%s'  readonly='readonly' title='You Cannot Change'/><br><br>",
					r.getUser_id());
			out.printf("Review:<input type='text'  name='review' value='%s'title='Edit Review'/><br><br> \r\n",
					r.getReview());
			out.println("<input type='submit' value='Submit Review'>\r\n" + "");
			out.println("</form>");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);

		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String rid = req.getParameter("id");
		String mid=req.getParameter("Movies_id");
		String rating=req.getParameter("rating");
		String review=req.getParameter("review");
		String uid=req.getParameter("userId");
           		
        System.out.println(rid);
        System.out.println(mid);
        System.out.println(rating);
        System.out.println(review);
        System.out.println(uid);

		try(ReviewDao r=new ReviewDaoImpl()) {
			int cnt=r.update(new Reviews(Integer.parseInt(rid),Integer.parseInt(mid),review,Integer.parseInt(rating),Integer.parseInt(uid),null));
			if(cnt==1)
			{
			 resp.sendRedirect("movielist?type=my");	
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
