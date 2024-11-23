package com.royal.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.royal.bean.StudentBean;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertStudentServlet extends HttpServlet
{
	ArrayList<StudentBean> list = new ArrayList<StudentBean>();
	
	int rno=1;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		
		String firstName= request.getParameter("firstName");
		
		String lastName= request.getParameter("lastName");
		
		String middleName= request.getParameter("middleName");
		
		String dob= request.getParameter("dob");
		
		String gender= request.getParameter("gender");
		
		String hbs[]= request.getParameterValues("hobbies");
		
		String address= request.getParameter("address");
		
		String state= request.getParameter("state");
		
		StringBuilder hobbies = new StringBuilder();
		for (int i = 0; i < hbs.length; i++) 
		{
			if (i <hbs.length-1) 
			{
				hobbies.append(hbs[i]+",");
			}else 
			{
				hobbies.append(hbs[i]+".");
			}
		}
		
		StudentBean sbean = new StudentBean(rno++,firstName, lastName, middleName, dob, gender, hobbies.toString(), address, state);
		list.add(sbean);
		
		// data---[list]
		request.setAttribute("list", list);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("listStudent");
		rd.forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

/*
Data Sharing :-
----------------

	1) page(current page)---[this.rno=rno;]
	2) request--[servlet1 to servlet2]
		===> request.setAttribute(String key,Object value);
		===> Object value = request.getAttribute(String key);
		===> request.removeAttribute(String key);

	3) session
		===> session.setAttribute(String key,Object value);
		===> Object value = session.getAttribute(String key);
		===> session.removeAttribute(String key);
	4) application
		===> context.setAttribute(String key,Object value);
		===> Object value = context.getAttribute(String key);
		===> context.removeAttribute(String key);
		

	list---------------------->|
	servlet1---------------->servlet2---------------->servlet3
InsertStudentServlet	    ListStudentServlet
	

*/