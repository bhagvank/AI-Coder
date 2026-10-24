<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.io.*,java.util.*" %>
    <%@ page import="com.architectcorner.ai.platform.businessdelegate.*" %>
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
 
 
 //UserBusinessDelegate userBusinessDelegate = new UserBusinessDelegate();
 //User user = userBusinessDelegate.getUser(username);
 BigDataDelegate dataDelegate = new BigDataDelegate();
		
		  List<String> fields = new ArrayList();
		  fields.add("username");
		  fields.add("password");
		  
		  Map<String,String> fieldValues = new HashMap();
		  fieldValues.put("username", username);

		  List<Map<String,String>> entities = dataDelegate.getRecord("DAAS", "User",fieldValues, fields);
		  
		  
		 Map<String,String> entity = entities.get(0);
		 
		 //out.println(entity);
		 
		 if(entity.get("password").contentEquals(password))
		 {
			 response.sendRedirect("index.jsp");	 
		 }
		 else
		 {
			 response.sendRedirect("Login.jsp");
		 } 
		  
 
 /* if(user.getUserName().contentEquals(username))
 {
	 if(user.getPassword().contentEquals(password))
	 {
		 response.sendRedirect("index.jsp");
	 }
	 else
	 { 
		 response.sendRedirect("index.jsp");
	 }
 }
 else
 {
	response.sendRedirect("Login.jsp");
 } */
%>
</body>
</html>