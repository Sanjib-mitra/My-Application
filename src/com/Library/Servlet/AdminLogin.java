package com.Library.Servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Admin Section</title>");
		
		out.println("</head>");
		out.println("<body>");
		//out.print("<h2>WELCOME ADMIN<h2>");
		out.println("</body>");
		out.println("</html>");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		if(email.equals("admin@globallibrary.com")&&password.equals("admin123")){
			HttpSession session=request.getSession();
			session.setAttribute("admin","true");
			
			request.getRequestDispatcher("adminarea.html").include(request, response);
		}
			else{
			
				out.println("<h3>Username or password error</h3>");
				request.getRequestDispatcher("adminloginform.html").include(request, response);
			
			}

		out.close();
	}
	
}
