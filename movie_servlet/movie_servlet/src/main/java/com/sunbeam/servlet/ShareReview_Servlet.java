package com.sunbeam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.daos.MovieDao;
import com.sunbeam.daos.MovieDaoImpl;
import com.sunbeam.daos.ReviewDao;
import com.sunbeam.daos.ReviewDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.Movies;
import com.sunbeam.pojos.Reviews;
import com.sunbeam.pojos.Users;

@WebServlet("/shareReview")
public class ShareReview_Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String revid = req.getParameter("id");
		HttpSession session = req.getSession();
		Users u = (Users) session.getAttribute("curUser");

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Share review</title>");
		out.println("</head>");
		out.println("<body>");
		out.println(
				"	<div align='center' style='height: 400px; width: 400px ; background-color:pink;align-content: center;margin-left: 600px;margin-top: 100px'>\r\n");

		out.println("<h3>Share Review </h3><br></br><br></br>");
		try (ReviewDao redao = new ReviewDaoImpl()) {
			UserDao udao = new UserDaoImpl();
			List<Users> ulist = new ArrayList<Users>();
			ulist = udao.findAll();
			List<Reviews> rlist = redao.findByUserId(u.getId());
			out.printf("<form method='POST' action='shareReview' >\r\n" + "");

			out.printf(
					"Review Id :<input type='number' name='Review_id' value='%S' readonly='readonly' title='You Cannot Change'/><br><br>",
					Integer.parseInt(revid));
			out.println("<h5>Share With :</h5>");
			out.println("<select name='User'>");
			for (Users user : ulist) {
				out.printf("<option value=" + user.getId() + ">%s</option>", user.getFirst_name());
			}
			out.println("</select><br><br></br></br>");
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
		String Uid = req.getParameter("User");
		String Rid = req.getParameter("Review_id");

		try(ReviewDao rdao=new ReviewDaoImpl()) {
			int cnt=rdao.shareReview(Integer.parseInt(Rid),Integer.parseInt(Uid));
			if(cnt==1)
			{
			  resp.sendRedirect("movielist?type=my");	
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
