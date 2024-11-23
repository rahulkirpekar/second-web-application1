package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FourthServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = 	response.getWriter();
		
		ServletContext context = getServletContext();
		
		out.print("<h3>FourthServlet</h3> : </br>" );
		Enumeration<String> paramNames = context.getInitParameterNames();
		
		while(paramNames.hasMoreElements()) 
		{
			String paramName = 	paramNames.nextElement();
			
			String paramValue = context.getInitParameter(paramName);
			
			out.print("<b>"+paramName+"</b> : " +paramValue+"</br>" );
		}
		
//		response.setContentType("text/html");
//		PrintWriter out = 	response.getWriter();
//		ServletContext context = getServletContext();
//		String lang1 = context.getInitParameter("lang1");
//		String lang2 = context.getInitParameter("lang2");
//		String lang3 = context.getInitParameter("lang3");
//		out.print("<h3>FourthServlet</h3> : </br>" );
//		out.print("<b>lang1</b> : " +lang1+"</br>" );
//		out.print("<b>lang2</b> : " +lang2+"</br>" );
//		out.print("<b>lang3</b> : " +lang3+"</br>" );
		
//		ServletConfig config = getServletConfig();
//		
//		PrintWriter out = 	response.getWriter();
//		out.print("<h3>"+config.getServletName()+"</h3> : </br>" );
//		
//		Enumeration<String>parameterNames = config.getInitParameterNames();
//		
//		while(parameterNames.hasMoreElements()) 
//		{
//			String parameterName = parameterNames.nextElement();
//			
//			String parameterValue = config.getInitParameter(parameterName);
//
//			out.print("<b>"+parameterName+"</b> : " +parameterValue+"</br>" );
//		}
		
		
		
		
//		String URLNAME = config.getInitParameter("URLNAME");
//		String DRIVERCLASS = config.getInitParameter("DRIVERCLASS");
//		String USERNAME = config.getInitParameter("USERNAME");
//		String PASSWORD = config.getInitParameter("PASSWORD");
		
//		PrintWriter out = 	response.getWriter();
//		
//		out.print("<h3>FourthServlet</h3> : </br>" );
//
//		out.print("<b>URLNAME</b> : " +URLNAME+"</br>" );
//		out.print("<b>DRIVERCLASS</b> : " +DRIVERCLASS+"</br>" );
//		out.print("<b>USERNAME</b> : " +USERNAME+"</br>" );
//		out.print("<b>PASSWORD</b> : " +PASSWORD+"</br>" );
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}