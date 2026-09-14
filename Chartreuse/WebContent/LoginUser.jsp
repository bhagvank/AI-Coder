<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="org.archcorner.chartreuse.businessdelegate.*" %>
    <%@ page import="org.archcorner.chartreuse.pojo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
 String username = request.getParameter("username");
 String password = request.getParameter("password");
 
 
 UserBusinessDelegate userBusinessDelegate = new UserBusinessDelegate();
 User user = userBusinessDelegate.getUser(username);

 
 if(user.getUserName().contentEquals(username))
 {
	 if(user.getPassword().contentEquals(password))
	 {
		 response.sendRedirect("index.jsp");
	 }
	 else
	 {
		 response.sendRedirect("Login.jsp");
	 }
 }
 else
 {
	response.sendRedirect("Login.jsp");
 }
%>
</body>
</html>