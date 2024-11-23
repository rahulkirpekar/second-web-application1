<?xml version="1.0" encoding="UTF-8" ?>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Introduction of Scripting Elements</title>
</head>
	<body>
		
<%-- 		<%=20+10 %> --%>
		
		<%
			for(int i=1 ; i <=10 ; i++)
			{
				out.println(10+" * " + i +" = "+ (10*i)+"<br>");	
			}
		%>
	
		<%!
			int test1()
			{
				int no1=200,no2=100;
				
				return (no1+no2);
			}
		%>
	
<%-- 		<%="Addition : " + test1()%> --%>
		<%
			out.print("Addition : " + test1());	
		
		%>
	
	</body>
</html>
