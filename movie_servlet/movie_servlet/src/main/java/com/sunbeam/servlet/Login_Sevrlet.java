package com.sunbeam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;
import com.sunbeam.daos.ReviewDao;
import com.sunbeam.daos.ReviewDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.Reviews;
import com.sunbeam.pojos.Users;

@WebServlet("/login")
public class Login_Sevrlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		try {
			UserDao userdao = new UserDaoImpl();
			Users u = userdao.findByEmail(email);
					
			System.out.println("user" + u);
			System.out.println("email:" + email);
			System.out.println("pass new:" + u.getPassword());
			HttpSession Session=req.getSession();
			if (u.getPassword().equals(password)) {
         
				System.out.println("inside login");
				resp.sendRedirect("movielist");
                Session.setAttribute("curUser",u);			

			} else {
				resp.setContentType("text/html");
				PrintWriter out = resp.getWriter();

				out.println("<html>");
				out.println("<head>");
				out.println("<title>Login Failed</title>");
				out.println("</head>");
				out.println("<body>");

				out.println("<h5>Invalid email or password</h5>");
				out.println("<a href='index.html'>Login Again</a>");

				out.println("</body>");
				out.println("</html>");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

	}

}
