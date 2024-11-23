package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.royal.bean.StudentBean;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListStudentServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		request.removeAttribute("list");
		
		
		System.out.println("ListStudentServlet : doGet()");
//		ArrayList<StudentBean> list = (ArrayList<StudentBean>)request.getAttribute("list");
		
		
		
		
//		PrintWriter out = response.getWriter();
//		out.print("<head>												");
//		out.print("	<style>                                             ");
//		out.print("		table {                                         ");
//		out.print("		  border-collapse: collapse;                    ");
//		out.print("		  width: 100%;                                  ");
//		out.print("		}                                               ");
//		out.print("                                                     ");
//		out.print("		th, td {                                        ");
//		out.print("		  text-align: left;                             ");
//		out.print("		  padding: 8px;                                 ");
//		out.print("		}                                               ");
//		out.print("                                                     ");
//		out.print("		tr:nth-child(even){background-color: #f2f2f2}   ");
//		out.print("                                                     ");
//		out.print("		th {                                            ");
//		out.print("		  background-color: #04AA6D;                    ");
//		out.print("		  color: white;                                 ");
//		out.print("		}                                               ");
//		out.print("	</style>                                            ");
//		out.print("</head>												");
//		
//		
//		
//		out.print("<table border='1'>");
//		out.print("	<tr>					");
//		out.print("		<th>Rno</th>  ");
//		out.print("		<th>FirstName</th>  ");
//		out.print("		<th>MiddleName</th> ");
//		out.print("		<th>LastName</th>   ");
//		out.print("		<th>DOB</th>        ");
//		out.print("		<th>Gender</th>	    ");
//		out.print("		<th>Hobbies</th>    ");
//		out.print("		<th>Address</th>    ");
//		out.print("		<th>State</th>      ");
//		out.print("	</tr>                   ");
//		out.print("                         ");
//	
//		for (int i = 0; i < list.size(); i++) 
//		{
//			StudentBean s = list.get(i);
//			out.print("	<tr>                    ");
//			out.print("		<td>"+s.getRno() +"</td>  ");
//			out.print("		<td>"+s.getFirstName()+"</td>  ");
//			out.print("		<td>"+s.getMiddleName()+"</td> ");
//			out.print("		<td>"+s.getLastName()+"</td>   ");
//			out.print("		<td>"+s.getDob()+"</td>        ");
//			out.print("		<td>"+s.getGender()+"</td>	    ");
//			out.print("		<td>"+s.getHobbies()+"</td>    ");
//			out.print("		<td>"+s.getAddress()+"</td>    ");
//			out.print("		<td>"+s.getState()+"</td>      ");
//			out.print("	</tr>                   ");
//		}
//		out.print("</table>                 ");
		
		
//		request.setAttribute("list", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("thirdServlet");
		rd.forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}
