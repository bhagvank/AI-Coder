/**
 * 
 */
package org.archcorner.codegen.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



/**
 * @author bhagvan.kommadi
 *
 */
public class DAOTemplate {

	private List<String> pojoMembers;
	
	/**
	 * @return the pojoMembers
	 */
	public List<String> getPojoMembers() {
		return pojoMembers;
	}

	/**
	 * @param pojoMembers the pojoMembers to set
	 */
	public void setPojoMembers(List<String> pojoMembers) {
		this.pojoMembers = pojoMembers;
	}

	private List<String> entityColumns;
	
	/**
	 * @return the entityColumns
	 */
	public List<String> getEntityColumns() {
		return entityColumns;
	}

	/**
	 * @param entityColumns the entityColumns to set
	 */
	public void setEntityColumns(List<String> entityColumns) {
		this.entityColumns = entityColumns;
	}

	private String nameEntity;
	
	/**
	 * @return the nameEntity
	 */
	public String getNameEntity() {
		return nameEntity;
	}

	/**
	 * @param nameEntity the nameEntity to set
	 */
	public void setNameEntity(String nameEntity) {
		this.nameEntity = nameEntity;
	}

	/**
	 * @return the entity
	 */
	public String getEntity() {
		return entity;
	}

	/**
	 * @param entity the entity to set
	 */
	public void setEntity(String entity) {
		this.entity = entity;
	}

	private String entity;
	
	private String idEntity;
	/**
	 * @return the idEntity
	 */
	public String getIdEntity() {
		return idEntity;
	}

	/**
	 * @param idEntity the idEntity to set
	 */
	public void setIdEntity(String idEntity) {
		this.idEntity = idEntity;
	}

	private ClassTemplate classTemplate;
	/**
	 * @return the classTemplate
	 */
	public ClassTemplate getClassTemplate() {
		return classTemplate;
	}

	/**
	 * @param classTemplate the classTemplate to set
	 */
	public void setClassTemplate(ClassTemplate classTemplate) {
		this.classTemplate = classTemplate;
	}

	/**
	 * @return the memberTemplates
	 */
	public List<MemberTemplate> getMemberTemplates() {
		return memberTemplates;
	}

	/**
	 * @param memberTemplates the memberTemplates to set
	 */
	public void setMemberTemplates(List<MemberTemplate> memberTemplates) {
		this.memberTemplates = memberTemplates;
	}

	/**
	 * @return the methodTemplates
	 */
	public List<MethodTemplate> getMethodTemplates() {
		return methodTemplates;
	}

	/**
	 * @param methodTemplates the methodTemplates to set
	 */
	public void setMethodTemplates(List<MethodTemplate> methodTemplates) {
		this.methodTemplates = methodTemplates;
	}

	private List<MemberTemplate> memberTemplates;
    private List<MethodTemplate> methodTemplates;
    
    public String getCode()
	{
		String code = "";
		   CodeManager manager = new CodeManager();
	       
	       String className = classTemplate.getName();
	       
	      // manager.createClass(className);
	       code = code +"import java.sql.Connection;\n";
	       code = code +"import java.sql.PreparedStatement;\n";
	       code = code +"import java.sql.ResultSet;\n";
	       code = code +"import java.sql.Statement;\n";
	       code = code +"import java.util.ArrayList;\n";
	       code = code +"import java.util.List;\n";

	       code = code+"import org.archcorner.chartreuse.pojo."+entity+";\n";
	       code = code + "import org.archcorner.chartreuse.util.JDBCManager;\n";
	       code = code + "\n";
	       code = code + manager.openClassCode(classTemplate);
	       code = code + "\n";
	       for(MemberTemplate memberTemplate:memberTemplates)
	       {
	       
	       
	       
	         String member = manager.getMemberCode(memberTemplate);
	       
	         code = code + member;
	         
	       
	       }
	       code = code + "\n";
	       /*for(MethodTemplate methodTemplate:methodTemplates)
	       {
	    	   String method = manager.getMethodCode(methodTemplate);
	    	   
	    	   code = code+ method;
	    	   
	    	   code = code+ "} \n";
	       }*/
	       
	       String highestIdMethod = getHighestMethodCode();
	       
	       code = code+ highestIdMethod;
	       
	       code = code + "\n";
	       
	       String getIdMethod = getByIdCode();
	       
	       code = code+ getIdMethod;
	       
	       code = code + "\n";
	       
           String getNameMethod = getByNameCode();
	       
	       code = code+ getNameMethod;
	       
	       code = code + "\n";
	       
            String deleteMethod = getDeleteCode();
	       
	       code = code+ deleteMethod;
	       
	       code = code + "\n";
	       
           String insertMethod = getInsertCode();
	       
	       code = code+ insertMethod;
	       
	       code = code + "\n";
	       
           String updateMethod = getUpdateCode();
	       
	       code = code+ updateMethod;
	       
	       code = code + "\n";
	       
           String getAllMethod = getAllCode();
	       
	       code = code+ getAllMethod;
	       
	       code = code + "\n";
	       String method = manager.getMainMethodCode();
	       
	       code = code + method;
	       
	       code = code+ "} \n";
		
		return code;
	}
    
    public String getHighestMethodCode()
    {
    	String code = "public int getHighestId(){\n";
    	
    	code = code+" Connection connection = JDBCManager.getConnection();\n";
		
    	code = code+" Statement statement = null;\n";
    	
		code = code+" int highestId=0;\n";
		code = code +" try\n";
		
		code = code+" {\n";
		
		code = code+"  statement = connection.createStatement();\n";
		
		
		code = code+"  ResultSet resultSet = statement.executeQuery(highestIDSQL);\n";
		
		code = code+"  while(resultSet.next())\n";
		
		code = code+"   {\n";
		
		code=  code+"    highestId = resultSet.getInt(\"MAX"+ idEntity.toUpperCase()+ "\");\n";
		code = code+"   }\n";
		
		code = code + "  resultSet.close();\n";
		
		code = code+"  }\n";
		code = code +" catch(Exception exception)\n";
		code = code+"  {\n";
		code = code+"   exception.printStackTrace();\n";
		code = code+"  }\n";
		code = code+" finally\n";
		code = code+"  {\n";
		code = code+"  try\n";
		code = code+"   {\n";
		code = code+"     statement.close();\n";
		code = code+"   }\n";
		code = code +"  catch(Exception exception)\n";
		code = code+"   {\n";
		code = code+"    exception.printStackTrace();\n";
		code = code+"   }\n";
			
		code= code+"  JDBCManager.closeConnection(connection);\n";
		
		code = code+" }\n";
		
		code = code+" return highestId;\n";
		
		code = code+"}\n";
		
		return code;
    }
    public String getDeleteCode()
    {
    	String code = "";
    	
    	code = code +"public void delete"+ entity+"("+ entity+ " "+entity.toLowerCase()+")\n";
    	code = code+" {\n";
    	code = code+"  Connection connection = JDBCManager.getConnection();\n";
    	
    	code = code+"  PreparedStatement preparedStatement = null;\n";
    	code = code+"  try\n";
    	code = code+"   {\n";
    	code = code+"    preparedStatement = connection.prepareStatement(deleteSQL);\n";
    	code = code+"    preparedStatement.setInt(1, "+ entity.toLowerCase()+".get"+entity+"Id());\n";
    	code = code+"    preparedStatement.executeUpdate();\n";
    	code = code+"   }\n";
    	code = code+"  catch(Exception exception)\n";
    	code = code+"   {\n";
    	code = code+"    exception.printStackTrace();\n";
    	code = code+"   }\n";
    	code = code+"  finally\n";
    	code = code+"   {\n";
    	code = code+"    try\n";
    	code = code+"     {\n";
    	code = code+"      if(preparedStatement != null)\n";
    	
    	code = code+"       {\n";
    	
    	code = code+"        preparedStatement.close();\n";
    	code = code+"       }\n";
    	code = code+"     }\n";
    	code = code+"    catch(Exception exception)\n";
    	code = code+"     {\n";
    	code = code+"      exception.printStackTrace();\n";
    	code = code+"     }\n";
    	code = code+"    JDBCManager.closeConnection(connection);\n";
    	code = code+"   }\n";
    	code = code+" }\n";
    	
    	return code;
    }
    public String getUpdateCode()
    {
    	CodeManager manager = new CodeManager();
    	String code = "";
    	code = code+"public void update"+entity+"("+entity+" "+entity.toLowerCase() +")\n";
    	code = code+" {\n";
    	code = code+"  Connection connection = JDBCManager.getConnection();\n";
    	code = code+"  PreparedStatement preparedStatement = null;\n";
    	code = code+"  try\n";
    	code = code+"   {\n";
    	code = code+"    preparedStatement = connection.prepareStatement(updateSQL);\n";
    	
    	 for(int i=0; i< pojoMembers.size();i++)
     	  {
    		 int j= i+1;
    	    code = code+"    preparedStatement.setString("+j+","+entity.toLowerCase()+".get"+manager.getLowerCaseName(pojoMembers.get(i))+"());\n";
    			
     	  }
    	 int k = pojoMembers.size()+1;
    	code = code+"    preparedStatement.setInt("+k+", "+ entity.toLowerCase()+".get"+entity+"Id());\n"; 
    	code = code+"    preparedStatement.executeUpdate();\n";
    	code = code+"   }\n";
    	code = code+"  catch(Exception exception)\n";
    	code = code+"   {\n";
    	code = code+"    exception.printStackTrace();\n";
    	code = code+"   }\n";
    	code = code+"  finally\n";
    	code = code+"   {\n";
    	code = code+"    try\n";
    	code = code+"     {\n";
    	code = code+"      if(preparedStatement != null)\n";
    	code = code+"       {\n";
    	code = code+"        preparedStatement.close();\n";
    	code = code+"       }\n";
    	code = code+"     }\n";
    	code = code+"    catch(Exception exception)\n";
    	code = code+"    {\n";
    	code = code+"     exception.printStackTrace();\n";
    	code = code+"    }\n";
    	code = code+"   JDBCManager.closeConnection(connection);\n";
    	code = code+"   }\n";
    	code = code+" }\n";
    	
    	return code;
    }
    public String getInsertCode()
    {
    	CodeManager manager = new CodeManager();
    	String code = "";
    	code = code+"public void insert"+entity+"("+entity+" "+entity.toLowerCase() +")\n";
    	code = code+" {\n";
    	code = code+"  Connection connection = JDBCManager.getConnection();\n";
    	code = code+"  PreparedStatement preparedStatement = null;\n";
    	code = code+"  try\n";
    	code = code+"   {\n";
    	code = code+"    preparedStatement = connection.prepareStatement(insertSQL);\n";
    	code = code+"    preparedStatement.setInt(1, getHighestId()+1);\n";
 
    	 for(int i=0; i< pojoMembers.size();i++)
     	  {
    		 int j= i+2;
    	    code = code+"    preparedStatement.setString("+j+","+entity.toLowerCase()+".get"+manager.getLowerCaseName(pojoMembers.get(i))+"());\n";
    			
     	  }
    	 
    	code = code+"    preparedStatement.execute();\n";
    	code = code+"   }\n";
    	code = code+"  catch(Exception exception)\n";
    	code = code+"   {\n";
    	code = code+"    exception.printStackTrace();\n";
    	code = code+"   }\n";
    	code = code+"  finally\n";
    	code = code+"   {\n";
    	code = code+"    try\n";
    	code = code+"     {\n";
    	code = code+"      if(preparedStatement != null)\n";
    	code = code+"       {\n";
    	code = code+"        preparedStatement.close();\n";
    	code = code+"       }\n";
    	code = code+"     }\n";
    	code = code+"    catch(Exception exception)\n";
    	code = code+"    {\n";
    	code = code+"     exception.printStackTrace();\n";
    	code = code+"    }\n";
    	code = code+"   JDBCManager.closeConnection(connection);\n";
    	code = code+"   }\n";
    	code = code+" }\n";
    	
    	return code;
    }
    
    public String getAllCode()
    {
        String code= "";
    	
    	CodeManager manager = new CodeManager();
    	code = code+"public List<"+entity+"> get"+entity+"s( )\n";
    	code = code+" {\n";
    	code = code+"  Connection connection = JDBCManager.getConnection();\n";
    	code = code+"  PreparedStatement preparedStatement = null;\n";
    	code = code+"  List<"+ entity+ "> "+entity.toLowerCase()+"List = new ArrayList<"+entity+">();\n";
    	code = code+"   try\n";
    	code = code+"    {\n";
    	code = code+"     preparedStatement = connection.prepareStatement(selectAllSQL);\n";
    	code = code+"     ResultSet resultSet = preparedStatement.executeQuery();\n";
    			
    	code = code+"     while(resultSet.next())\n";
    	code = code+"      {\n";
    	code = code+"       int id =resultSet.getInt(\""+idEntity.toUpperCase()+"\");\n";
    	
    	for(String entityColumn:entityColumns)
    	{
    		
    	  code = code+"      String "+entityColumn.toLowerCase()+" = resultSet.getString(\""+entityColumn+"\");\n";
    	}			
    		
    	  code = code+"      "+entity+" "+entity.toLowerCase()+" = new "+entity+"();\n";
    	  
    	  code = code+"      "+entity.toLowerCase()+".set"+manager.getLowerCaseName(entity)+"Id(id);\n";
    	
    	  for(int i=0; i< pojoMembers.size();i++)
      	  {
    		  code = code+"      "+entity.toLowerCase()+".set"+manager.getLowerCaseName(pojoMembers.get(i))+"("+entityColumns.get(i).toLowerCase()+");\n";
    		  
      	  }
    	  
    	  code = code+"       "+entity.toLowerCase()+"List.add("+entity.toLowerCase()+");\n";
    	  code = code+"      }\n";
    	  code = code+"    }\n";
    	  code = code+"    catch(Exception exception)\n";
    	  code = code+"     {\n";
    	  code = code+"      exception.printStackTrace();\n";
    	  code = code+"     }\n";
    	  code = code+"    finally\n";
    	  code = code+"    {\n";
    	  code = code+"   try\n";
    	  code = code+"    {\n";
    	  code = code+"     preparedStatement.close();\n";
    	  code = code+"    }\n";
    	  code = code+"   catch(Exception exception)\n";
    	  code = code+"    {\n";
    	  code = code+"     exception.printStackTrace();\n";
    	  code = code+"   }\n";
    	  code = code+"   JDBCManager.closeConnection(connection);\n";
    	  code = code+"	}\n";
    		
    	  code = code+"  return "+ entity.toLowerCase()+"List;\n";
    	  code = code+" }\n";
    	  
    	  return code;
    }
    public String getByNameCode()
    {
        String code= "";
    	
    	CodeManager manager = new CodeManager();
    	code = code+"public "+entity+" get"+entity+"(String "+nameEntity.toLowerCase()+")\n";
    	code = code+" {\n";
    	code = code+"  Connection connection = JDBCManager.getConnection();\n";
    	code = code+"  PreparedStatement preparedStatement = null;\n";
    	code = code+"   "+ entity+ " "+entity.toLowerCase()+" = null;\n";
    	code = code+"   try\n";
    	code = code+"    {\n";
    	code = code+"     preparedStatement = connection.prepareStatement(selectSQL);\n";
    	code = code+"     preparedStatement.setString(1, "+nameEntity.toLowerCase()+");\n";
    	code = code+"     ResultSet resultSet = preparedStatement.executeQuery();\n";
    			
    	code = code+"     while(resultSet.next())\n";
    	code = code+"      {\n";
    	code = code+"       int id =resultSet.getInt(\""+idEntity+"\");\n";
    	
    	for(String entityColumn:entityColumns)
    	{
    	  if(entityColumn.equalsIgnoreCase(nameEntity))	
    	  {
    		  code = code+"      "+entityColumn.toLowerCase()+" = resultSet.getString(\""+entityColumn+"\");\n";
    	  }
    	  else
    	  {
    	      code = code+"      String "+entityColumn.toLowerCase()+" = resultSet.getString(\""+entityColumn+"\");\n";
    	  }
    	}			
    		
    	  code = code+"      "+entity.toLowerCase()+" = new "+entity+"();\n";

    	  code = code+"      "+entity.toLowerCase()+".set"+manager.getLowerCaseName(entity)+"Id(id);\n";

    	  
    	  for(int i=0; i< pojoMembers.size();i++)
      	  {
    		  code = code+"      "+entity.toLowerCase()+".set"+manager.getLowerCaseName(pojoMembers.get(i))+"("+entityColumns.get(i).toLowerCase()+");\n";
    		  
      	  }
    	  code = code+"      }\n";
    	  code = code+"    }\n";
    	  code = code+"    catch(Exception exception)\n";
    	  code = code+"     {\n";
    	  code = code+"      exception.printStackTrace();\n";
    	  code = code+"     }\n";
    	  code = code+"    finally\n";
    	  code = code+"    {\n";
    	  code = code+"   try\n";
    	  code = code+"    {\n";
    	  code = code+"     preparedStatement.close();\n";
    	  code = code+"    }\n";
    	  code = code+"   catch(Exception exception)\n";
    	  code = code+"    {\n";
    	  code = code+"     exception.printStackTrace();\n";
    	  code = code+"   }\n";
    	  code = code+"   JDBCManager.closeConnection(connection);\n";
    	  code = code+"	}\n";
    		
    	  code = code+"  return "+ entity.toLowerCase()+";\n";
    	  code = code+" }\n";
    	  
    	  return code;
    	
    }
    public String getByIdCode()
    {
    	String code= "";
    	
    	CodeManager manager = new CodeManager();
    	code = code+"public "+entity+" get"+entity+"ById(int "+idEntity.toLowerCase()+")\n";
    	code = code+" {\n";
    	code = code+"  Connection connection = JDBCManager.getConnection();\n";
    	code = code+"  PreparedStatement preparedStatement = null;\n";
    	code = code+"   "+ entity+ " "+entity.toLowerCase()+" = null;\n";
    	code = code+"   try\n";
    	code = code+"    {\n";
    	code = code+"     preparedStatement = connection.prepareStatement(selectIdSQL);\n";
    	code = code+"     preparedStatement.setInt(1, "+idEntity.toLowerCase()+");\n";
    	code = code+"     ResultSet resultSet = preparedStatement.executeQuery();\n";
    			
    	code = code+"     while(resultSet.next())\n";
    	code = code+"      {\n";
    	code = code+"       int id =resultSet.getInt(\""+idEntity.toLowerCase()+"\");\n";
    	
    	for(String entityColumn:entityColumns)
    	{
    		
    	  code = code+"      String "+entityColumn.toLowerCase()+" = resultSet.getString(\""+entityColumn+"\");\n";
    	}			
    		
    	  code = code+"      "+entity.toLowerCase()+" = new "+entity+"();\n";
    	  
    	  code = code+"      "+entity.toLowerCase()+".set"+manager.getLowerCaseName(entity)+"Id(id);\n";
    	
    	  for(int i=0; i< pojoMembers.size();i++)
      	  {
    		  code = code+"      "+entity.toLowerCase()+".set"+manager.getLowerCaseName(pojoMembers.get(i))+"("+entityColumns.get(i).toLowerCase()+");\n";
    		  
      	  }
    	  code = code+"      }\n";
    	  code = code+"    }\n";
    	  code = code+"    catch(Exception exception)\n";
    	  code = code+"     {\n";
    	  code = code+"      exception.printStackTrace();\n";
    	  code = code+"     }\n";
    	  code = code+"    finally\n";
    	  code = code+"    {\n";
    	  code = code+"   try\n";
    	  code = code+"    {\n";
    	  code = code+"     preparedStatement.close();\n";
    	  code = code+"    }\n";
    	  code = code+"   catch(Exception exception)\n";
    	  code = code+"    {\n";
    	  code = code+"     exception.printStackTrace();\n";
    	  code = code+"   }\n";
    	  code = code+"   JDBCManager.closeConnection(connection);\n";
    	  code = code+"	}\n";
    		
    	  code = code+"  return "+ entity.toLowerCase()+";\n";
    	  code = code+" }\n";
    	  
    	  return code;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	   DAOTemplate template = new DAOTemplate();
		
       CodeManager manager = new CodeManager();
		
		ClassTemplate classTemplate = manager.createClassTemplate("CustomerDAO");
		
		template.setClassTemplate(classTemplate);
		
		String entity = "Customer";
		
		template.setEntity(entity);
		
		String idEntity = "CUSTOMERID";
		
		template.setIdEntity(idEntity);
		
		String nameEntity = "CUSTOMERNAME";
		
		template.setNameEntity(nameEntity);
		
		List<String> entityColumns = new ArrayList<String>();
		entityColumns.add("CUSTOMERNAME");
		entityColumns.add("STREETADDRESS");
		entityColumns.add("STATE");
		entityColumns.add("COUNTRY");
		entityColumns.add("ZIPCODE");
		entityColumns.add("CONTACTNO");
		entityColumns.add("CITY");
		
		template.setEntityColumns(entityColumns);
		
		
		List<String> pojoMembers = new ArrayList<String>();
		pojoMembers.add("customerName");
		pojoMembers.add("streetAddress");
		pojoMembers.add("state");
		pojoMembers.add("country");
		pojoMembers.add("zipCode");
		pojoMembers.add("contactNo");
		pojoMembers.add("city");
		
		template.setPojoMembers(pojoMembers);
		
		String sqlCode = "CUSTOMERID,CUSTOMERNAME,STREETADDRESS,STATE,COUNTRY,ZIPCODE,CONTACTNO,CITY";
		
		String updateCode = "CUSTOMERNAME=?,STREETADDRESS=?,STATE=?,COUNTRY=?,ZIPCODE=?,CONTACTNO=?,CITY=?";
		
		List<MemberTemplate> memberTemplates = new ArrayList<MemberTemplate>();
		
		
        MemberTemplate memberHighestIdTemplate = manager.createMemberTemplate("highestIDSQL", "String", "SELECT MAX("+entity.toUpperCase()+"ID) AS MAX"+entity.toUpperCase()+"ID FROM "+entity.toUpperCase());
		
		memberTemplates.add(memberHighestIdTemplate);
		

        MemberTemplate memberSelectNameTemplate = manager.createMemberTemplate("selectSQL", "String", "SELECT * FROM "+entity.toUpperCase()+" WHERE "+nameEntity.toUpperCase()+"=?");
		
		memberTemplates.add(memberSelectNameTemplate);
		
		MemberTemplate memberSelectTemplate = manager.createMemberTemplate("selectIdSQL", "String", "SELECT * FROM "+entity.toUpperCase()+" WHERE "+idEntity.toLowerCase()+"=?");
		
		memberTemplates.add(memberSelectTemplate);
		
		MemberTemplate memberInsertTemplate = manager.createMemberTemplate("insertSQL", "String", "INSERT INTO "+entity.toUpperCase()+"("+sqlCode+") VALUES(?,?,?,?,?,?,?,?)");
		
		memberTemplates.add(memberInsertTemplate);
		
        MemberTemplate memberUpdateTemplate = manager.createMemberTemplate("updateSQL", "String", "UPDATE "+entity.toUpperCase()+" SET "+updateCode+" WHERE "+idEntity.toUpperCase() +"=?");
		
		memberTemplates.add(memberUpdateTemplate);
		
        MemberTemplate memberDeleteTemplate = manager.createMemberTemplate("deleteSQL", "String", "DELETE FROM "+ entity.toUpperCase()+" WHERE "+idEntity.toUpperCase()+"=?");
		
		memberTemplates.add(memberDeleteTemplate);
		
        MemberTemplate memberSelectAllTemplate = manager.createMemberTemplate("selectAllSQL", "String", "SELECT * FROM "+ entity.toUpperCase());
		
		memberTemplates.add(memberSelectAllTemplate);
		
		template.setMemberTemplates(memberTemplates);
		
		
		
		List<MethodTemplate> methodTemplates = new ArrayList<MethodTemplate>();
		
		MethodTemplate methodGetTemplate = manager.createMethodTemplate("get"+entity, entity, null, "public");
		
		ParameterTemplate parameterIdTemplate = manager.createParameterTemplate("id", "String");
	       
	       
	       List<ParameterTemplate> parameterTemplates = new ArrayList<ParameterTemplate>();
	       parameterTemplates.add(parameterIdTemplate);
	       
	       methodGetTemplate.setParameters(parameterTemplates);	
		
	       methodTemplates.add(methodGetTemplate);
	       
		MethodTemplate methodDeleteTemplate = manager.createMethodTemplate("delete"+entity, "void", null, "public");
		
		methodDeleteTemplate.setParameters(parameterTemplates);	
		
		   methodTemplates.add(methodDeleteTemplate);
		   
		MethodTemplate methodGetAllTemplate = manager.createMethodTemplate("getAll"+entity+"s", "List<"+entity+">", null, "public");
		
		  methodTemplates.add(methodGetAllTemplate);
		
		MethodTemplate methodUpdateTemplate = manager.createMethodTemplate("update"+entity, entity, null, "public");
		
		 String lowerCaseEntity = manager.getLowerCaseName(entity);
		 
		 ParameterTemplate parameterEntityTemplate = manager.createParameterTemplate(lowerCaseEntity, entity);
	       
	       
	       List<ParameterTemplate> parameterUpdateTemplates = new ArrayList<ParameterTemplate>();
	       parameterUpdateTemplates.add(parameterEntityTemplate);
	       
	       methodUpdateTemplate.setParameters(parameterUpdateTemplates);	
		
	        methodTemplates.add(methodUpdateTemplate);
	        
	        template.setMethodTemplates(methodTemplates);
		String code = template.getCode();
		      
	    String className = classTemplate.getName();
	       
	      
	    manager.createFolder("java");
	    
	    manager.createClass("java", className);
	            
	    manager.writeCode(code);
	    manager.closeClass();
	}

}
