package com.Library.Servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Library.beans.LibrarianBean;
import com.Library.dao.LibrarianDao;

//import com.javatpoint.beans.LibrarianBean;
//import com.javatpoint.dao.LibrarianDao;
@WebServlet("/AddLibrarian")
public class AddLibrarian extends HttpServlet {
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
		out.println("<title>Add Librarian</title>");
		
		out.println("</head>");
		out.println("<body>");
		//boolean flag=false;
		request.getRequestDispatcher("adminarea.html").include(request, response);
		out.println("<div class='container'>");
		String id1=request.getParameter("id");
		int id=Integer.parseInt(id1);
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String smobile=request.getParameter("mobile");
		long mobile=Long.parseLong(smobile);
		
		LibrarianBean bean=new LibrarianBean(id,name, email, password, mobile);
		
		LibrarianDao.save(bean);
		out.print("<h4>Librarian added successfully</h4>");
		
		request.getRequestDispatcher("addlibrarianform.html").include(request, response);
		
		
		out.println("</div>");
		
		out.close();
	}

}
