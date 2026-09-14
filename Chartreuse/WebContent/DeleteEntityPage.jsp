<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="org.archcorner.chartreuse.metadata.*"%>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete Entity</title>
</head>
<body>
<%
 Enumeration<String> parameterNames =  request.getParameterNames();

 List<String> fields = new ArrayList<String>();
 List<String> values = new ArrayList<String>(); 
 String entityName = null;
 String formno = null;
 String entityId = null;
 
 while(parameterNames.hasMoreElements())
 {
	
	 String parameterName = parameterNames.nextElement();
	 
	 if(parameterName.equals("formName"))
	 {
		 entityName = request.getParameter(parameterName);
	 }
	 else if(parameterName.equals("formno"))
	 {
		 formno = request.getParameter(parameterName);
	 }
	 else if(parameterName.equals("submit"))
	 {
		 
	 }
	 else if(parameterName.equals("entityId"))
	 {
		 entityId = request.getParameter(parameterName);
	 }
	 else
	 {
	   fields.add(parameterName);
	   values.add(request.getParameter(parameterName));
	   out.println(parameterName);
	 } 
	 
 }

 List<String> fieldTypes = new ArrayList<String>();
 for(String field:fields)
 {
   fieldTypes.add("String");
 }
 MetadataManager metadataManager = new MetadataManager();
 metadataManager.deleteEntityValue(entityName, entityId,fields, values, fieldTypes);
 
response.sendRedirect("ListView.jsp?viewno="+formno);
 
%>

</body>
</html>