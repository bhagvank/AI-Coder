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
String entityName = request.getParameter("entity");
String fieldNo = request.getParameter("fieldNo");
out.println(fieldNo);
int fields = Integer.parseInt(fieldNo);

BigDataDelegate bigDataDelegate = new BigDataDelegate();

Map<String,String> record = new HashMap();
record.put("EntityName",entityName);

//check if the entity exists

bigDataDelegate.insertRecord("DAAS", "Entities", record);

Map<String,String> fieldMap = new HashMap();

for(int i=0; i< fields; i++)
{
	String field = request.getParameter("field"+i);
	String fieldType = request.getParameter("fieldS"+i);

	fieldMap.put("Fieldname",field);
	fieldMap.put("FieldType",fieldType);
	
	//check if the field Exists
	bigDataDelegate.insertRecord("DAAS", entityName+"Type", fieldMap);
}

response.sendRedirect("Entities.jsp");
%>
</body>
</html>