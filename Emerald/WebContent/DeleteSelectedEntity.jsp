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
String entityName = request.getParameter("name");

//String searchValue = request.getParameter("searchValue");
//String fieldName = request.getParameter("fieldName");

String id = request.getParameter("_id");

//out.println(fieldName);
//out.println(searchValue);
BigDataDelegate bigDataDelegate = new BigDataDelegate();

//List<String> fields = new ArrayList();
//fields.add("Fieldname");
//fields.add("FieldType");

//List<Map<String,String>> entities = bigDataDelegate.getRecords("DAAS", entityName+"Type", fields);

//check if the entity exists

//bigDataDelegate.insertRecord("DAAS", "Entities", record);

//Map<String,String> fieldMap = new HashMap();

//for(Map<String,String> entity:entities)
//{
	
//	String field = entity.get("Fieldname");
//	String fieldValue = request.getParameter(field);
	//String fieldType = request.getParameter("fieldS"+i);

	// out.println(field);
	 //out.println(fieldValue);
//	fieldMap.put(field,fieldValue);
	
	
	//check if the field Exists
	
//}
//Map<String,String> filters = new HashMap();
//filters.put("_id", id);
bigDataDelegate.deleteRecord("DAAS", entityName,"$eq",id,"_id");

response.sendRedirect("Entities.jsp");
%>
</body>
</html>