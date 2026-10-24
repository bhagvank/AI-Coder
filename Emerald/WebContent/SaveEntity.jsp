<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
    <%@ page import="com.architectcorner.ai.platform.businessdelegate.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String entityName = request.getParameter("entityName");


BigDataDelegate bigDataDelegate = new BigDataDelegate();

List<String> fields = new ArrayList();
fields.add("Fieldname");
fields.add("FieldType");

List<Map<String,String>> entities = bigDataDelegate.getRecords("DAAS", entityName+"Type", fields);

//check if the entity exists

//bigDataDelegate.insertRecord("DAAS", "Entities", record);

Map<String,String> fieldMap = new HashMap();

for(Map<String,String> entity:entities)
{
	
	String fieldName = entity.get("Fieldname");
	String fieldValue = request.getParameter(fieldName);
	//String fieldType = request.getParameter("fieldS"+i);

	fieldMap.put(fieldName,fieldValue);
	
	
	//check if the field Exists
	
}

bigDataDelegate.insertRecord("DAAS", entityName, fieldMap);

response.sendRedirect("Entities.jsp");
%>
</body>
</html>