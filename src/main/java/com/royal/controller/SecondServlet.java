package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// set response type --->MIME
		
//		response.setContentType("text/html");
//		
//		PrintWriter out = response.getWriter();
//		
//		for (int i = 1; i <=10 ; i++) 
//		{
//			out.println(5+" * " + i+" = " + (5*i)+"<br>");
//		}
//		
		response.setContentType("text/html");
		
		ServletContext context = getServletContext();
		
		String lang1 = context.getInitParameter("lang1");
		String lang2 = context.getInitParameter("lang2");
		String lang3 = context.getInitParameter("lang3");
		
		PrintWriter out = response.getWriter();
		
		out.println("lang1 : " + lang1+"<br>");
		out.println("lang2 : " + lang2+"<br>");
		out.println("lang3 : " + lang3+"<br>");
	}
}
