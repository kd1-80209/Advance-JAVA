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

@WebServlet("/movielist")
public class Movie_List extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MovieDao movie = new MovieDaoImpl();
		HttpSession session = req.getSession();

		Users u = (Users) session.getAttribute("curUser");
		String reqid = req.getParameter("type");

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Movie List</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div align='center'>");
		String fname = u.getFirst_name();
		String lname = u.getLast_name();
		out.printf("<h3>Hello  %s %s.....!</h3>", fname, lname);
		out.println("<hr></hr>");

		out.println("<a href='movielist?type=All'>All Reviews |</a>\r\n");
		out.println("<a href='movielist?type=My'>My Reviews |</a>\r\n");
		out.println("<a href='movielist?type=Shared'>Shared Reviews | </a>\r\n");
		out.println("<a href='giveReview' >Add Reviews </a>\r\n");

		out.println("<hr></hr>");
		out.println("<table border='2'>");
		out.println("<thead>");
		if(reqid==null)
		out.println("<h3  align='center' style='color: red'>All_Review</he>");
		else
			out.printf("<h3 align='center' style='color: red'>%s_Review</he>",reqid);

		out.println("<th>Movie_Id</th>");
		out.println("<th>Movie_Name</th>");
		out.println("<th>Movie_Rating</th>");
		out.println("<th>Movie_Reviews</th>");

		out.println("</thead>");
		out.println("<tbody>");

		try (ReviewDao r = new ReviewDaoImpl()) {
			List<Reviews> rlist = new ArrayList<Reviews>();
			if (reqid == null || reqid.equals("All"))
				rlist = r.findAll();
			else if (reqid.equals("My"))
				rlist = r.findByUserId(u.getId());
			else if (reqid.equals("Shared"))
				rlist = r.getSharedWithUser(u.getId());

			for (Reviews rl : rlist) {
				Movies m = movie.findById(rl.getMovie_id());
				out.printf(" <tr>");
				out.printf("<td>%s</td>", m.getId());
				out.printf("<td>%s</td>", m.getTitle());
				out.printf("<td>%s</td>", rl.getRating());
				out.printf("<td>%s</td>", rl.getReview());
				if (reqid.equals("My")) {
					out.printf(
							"<td><a href='DeleteReview?id=%s'><img src='delete.jpg' alt='delete' width='24' height='24'/><a></td>",
							rl.getId());
					out.printf(
							"<td><a href='editReview?id=%s'><img src='edit.jpg' alt='delete' width='24' height='24'/><a></td>",
							rl.getId());
					out.printf(
							"<td><a href='shareReview?id=%s'><img src='share.jpg' alt='delete' width='24' height='24'/><a></td>",
							rl.getId());

				}
				out.printf(" </tr>");

			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		out.println("</tbody>");
		out.println("</table>");
		out.println("<hr></hr>");
		out.println("<a href='signout'>Sign Out </a>\r\n");
		out.println("<hr></hr>");
		out.println("</html>");
	}
}
