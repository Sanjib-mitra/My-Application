package com.Library.Servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Library.dao.LibrarianDao;

//import com.javatpoint.dao.LibrarianDao;
@WebServlet("/LibrarianLogin")
public class LibrarianLogin extends HttpServlet {
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
		out.println("<h2>Librarian Section</h2>");
		
		out.println("</head>");
		out.println("<body>");
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		if(LibrarianDao.authenticate(email, password)){
			HttpSession session=request.getSession();
			session.setAttribute("email",email);
			
			request.getRequestDispatcher("navlibrarian.html").include(request, response);
		
		}else{
			request.getRequestDispatcher("navhome.html").include(request, response);
			
			out.println("<h3>Username or password error</h3>");
			request.getRequestDispatcher("librarianloginform.html").include(request, response);
			request.getRequestDispatcher("addlibrarianform.html").include(request, response);
		//request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}
	}
}
