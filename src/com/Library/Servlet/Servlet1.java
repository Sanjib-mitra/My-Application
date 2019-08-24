package com.Library.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {

	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException{
		res.setContentType("text/html");
		PrintWriter writer=res.getWriter();
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		//HttpSession session=req.getSession();
		//session.setAttribute(name, "name");
		//session.setAttribute(password, "password");
		writer.print("Welcome:"+name);
	}
}
