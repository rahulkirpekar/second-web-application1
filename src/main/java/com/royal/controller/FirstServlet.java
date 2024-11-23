package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Java class--->Servlet---[tomcat]---[lib]----[servlet-api.jar]
public class FirstServlet extends HttpServlet
{
	static int visterCounter = 0;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		visterCounter++;
		PrintWriter out = response.getWriter();
		
//		out.print("Hello World");
		
		String clientIp = request.getRemoteAddr();
		
//		out.print("Client Ip : " + clientIp);
		
//		System.out.println("clientIp : " + clientIp);
//		System.out.println("visterCounter : " + );
		
		System.out.println(clientIp + " : " + visterCounter);
		System.out.println("getServletContext().getRealPath(\"\") : " + getServletContext().getRealPath(""));
		
	}
}
