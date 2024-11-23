package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SeventhServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		
		ServletContext context = getServletContext();
		
		PrintWriter out = response.getWriter();
		
		Enumeration<String> paramNames = context.getInitParameterNames();
		
		while(paramNames.hasMoreElements()) 
		{
			String paramName = paramNames.nextElement();
			
			String paramValue = context.getInitParameter(paramName);
			
			out.println(paramName + " : " + paramValue+"<br>");
		}
		
//		String lang2 = context.getInitParameter("lang2");
//		String lang3 = context.getInitParameter("lang3");
		
//		out.println("lang2 : " + lang2+"<br>");
//		out.println("lang3 : " + lang3+"<br>");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}
