package com.sunbeam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.Utils.DateUtil;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.Users;

@WebServlet("/SignIn")
public class SignIn_Servlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String email = req.getParameter("email");
		String pass = req.getParameter("password");
		String mob = req.getParameter("mobno");
		String date = req.getParameter("bdate");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
		
		System.out.println("fname ;"+fname);
		System.out.println("lname ;"+lname);
    	System.out.println("fname ;"+email);
		System.out.println("fname ;"+pass);
		System.out.println("fname ;"+mob);

		

		try {
			Date udate=sdf.parse(date);
			System.out.println("fname ;"+udate);

			UserDao userdao = new UserDaoImpl();
			int cnt = userdao.save(new Users(0, fname, lname, email, pass, mob, udate));
			System.out.println(cnt);
			if (cnt == 1) {
				resp.setContentType("text/html");
				PrintWriter out = resp.getWriter();

				out.println("<html>");
				out.println("<head>");
				out.println("<title>Sign In Successfully</title>");
				out.println("</head>");
				out.println("<body>");
                         
				out.println("<h5>Welcome To MyWebsite</h5>");
                  resp.sendRedirect("index.html");
				out.println("</body>");
				out.println("</html>");
			} else {
				resp.setContentType("text/html");
				PrintWriter out = resp.getWriter();

				out.println("<html>");
				out.println("<head>");
				out.println("<title>Sign In Failed</title>");
				out.println("</head>");
				out.println("<body>");
                
				out.println("<h5>Try Again....!</h5>");
				out.println("<a href='Register.html'>Sign In</a>");

				out.println("</body>");
				out.println("</html>");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

	}

}
