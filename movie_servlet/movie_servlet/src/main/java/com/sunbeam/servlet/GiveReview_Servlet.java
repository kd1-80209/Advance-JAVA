package com.sunbeam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.daos.MovieDao;
import com.sunbeam.daos.MovieDaoImpl;
import com.sunbeam.daos.ReviewDao;
import com.sunbeam.daos.ReviewDaoImpl;
import com.sunbeam.pojos.Movies;
import com.sunbeam.pojos.Reviews;
import com.sunbeam.pojos.Users;

@WebServlet("/giveReview")
public class GiveReview_Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Add review</title>");
		out.println("</head>");
		out.println("<body>");
		out.println(
				"	<div align='center' style='height: 400px; width: 400px ; background-color:pink;align-content: center;margin-left: 600px;margin-top: 100px'>\r\n");

		out.println("<h3>Give Review </h3><br></br><br></br>");
		out.println("<form method='POST' action='giveReview' >\r\n" + "");
		out.println("<select name='movies'>");
		try(MovieDao moviedao=new MovieDaoImpl())
		{
		List<Movies> movieslist=moviedao.findAll();

		for(Movies movies:movieslist)
		{
		out.printf("<option value="+movies.getId()+">%s</option>",movies.getTitle());
		}
		out.println("</select><br>");
		
		out.println("Rating :<input type='number' name='rating' required='required'><br><br> \r\n" + "");
		out.println(
				"Review:<input type='text' style='height: 50px; width: 300px' name='review' required='required'><br><br> \r\n"
						+ "");
		out.println("<input type='submit' value='Submit Review'>\r\n" + "");

		out.println("</form>");
		out.println("</div>");

		out.println("</body>");
		out.println("</html>");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new ServletException(e);
			
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		Users u = (Users) session.getAttribute("curUser");

		String movie = req.getParameter("movies");
		String rating = req.getParameter("rating");
		String review = req.getParameter("review");
		System.out.println("m id" + movie);
		System.out.println(rating);
		System.out.println(review);

		try (ReviewDao redao = new ReviewDaoImpl()) {
						
			int cnt = redao.save(new Reviews(0,Integer.parseInt(movie) , review , Integer.parseInt(rating), u.getId()));
			if (cnt == 1) {
				resp.sendRedirect("movielist?type=my");
			} else {
				resp.setContentType("text/html");
				PrintWriter out = resp.getWriter();

				out.println("<html>");
				out.println("<head>");
				out.println("<title>Review Failed Failed</title>");
				out.println("</head>");
				out.println("<body>");

				out.println("<h5>Try Again</h5>");
				out.println("<a href='giveReview'>Add Review Again</a>");

				out.println("</body>");
				out.println("</html>");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

	}

}
