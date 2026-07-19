/**
 * 
 */
package org.archcorner.codegen.php;

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
	       code = code + manager.openPHPCode();
	       code = code +"require_once(\"DataObject.php\");\n";
	       code = code +"require_once(\""+ entity +".php\");\n";
	       code = code + "\n";
	       code = code + manager.openClassCode(classTemplate);
	       code = code + "\n";
	       if(memberTemplates != null)
	       {
	        for(MemberTemplate memberTemplate:memberTemplates)
	        {
	       
	       
	       
	          String member = manager.getMemberCode(memberTemplate);
	       
	          code = code + member;
	         
	       
	         }
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
	       
	       
	       
           
          
	       
          
	       /*
	       
           String getAllMethod = getAllCode();
	       
	       code = code+ getAllMethod;
	       
	       code = code + "\n";
	       String method = manager.getMainMethodCode();
	       
	       code = code + method;*/
	       
	      // code = code+ "} \n";
	       
           String insertMethod = getInsertCode();
	       
	       code = code+ insertMethod;
	       
	       code = code + "\n";
	       
          String updateMethod = getUpdateCode();
	       
	       code = code+ updateMethod;
	       
	       code = code + "\n"; 
	      
          String deleteMethod = getDeleteCode();
	       
	       code = code+ deleteMethod;
	       
	       code = code + "\n";
	       
          String getIdMethod = getByIdCode();
	       
	       code = code+ getIdMethod;
	       
	       code = code + "\n";
	       
	       
           String getNameMethod = getByNameCode();
	       
	       code = code+ getNameMethod;
	       
	       code = code + "\n";
	       
           String getAllMethod = getAllCode();
	       
	       code = code+ getAllMethod;
	       
	       code = code + "\n";
	       
	       code = code + manager.closeClassCode(getClassTemplate());
		
		return code;
	}
    
    public String getHighestMethodCode()
    {
    	String code = "  public function getMaxId()\n  {\n";
    	
    	code = code +"   $connection = parent::connect();\n";
	 	code = code +"   $maxIdSql = \"SELECT MAX("+ entity.toUpperCase() + "ID) AS MAX"+entity.toUpperCase()+"ID FROM "+entity.toUpperCase()+ "\";\n";
		code = code +"   $rows = $connection->query($maxIdSql);\n";
		 
		code = code+"   $maxid=0;\n";
		 
		code = code+"   if(count($rows) > 0)\n";
		code = code+"    {\n";
		code = code+"      foreach($rows as $row)\n";
		code = code+"      {\n";
		code = code+"        $maxid = $row[0];\n";	
		code = code+"      }\n";
		code = code+"    }\n";
	
		code = code+"    parent::disconnect($connection);\n";	 
		code = code+"    return $maxid;\n";	
		code = code+"  }\n";
		return code;
    }
    public String getDeleteCode()
    {
    	String code = "";
    	
    	code = code+ "public function delete"+entity+"($"+entity.toLowerCase()+")\n";
        code = code + " {\n";
        
        
        code = code +"  $connection = parent::connect();\n";
        code = code +"  $deletesql = \"DELETE FROM "+entity.toUpperCase()+ " WHERE "+entity.toUpperCase()+"ID =:"+entity.toLowerCase()+"id"+"\";\n";
	
        code = code +"  try\n";
        code = code +"   {\n";
        code = code +"     $statement = $connection->prepare($deletesql);\n";
        code = code +"     $statement->bindValue(\":"+entity.toLowerCase()+"id\",$"+entity.toLowerCase()+"->get"+entity+"Id(),PDO::PARAM_INT);\n";
        code = code +"     $statement->execute();\n";
        code = code +"     parent::disconnect($connection);\n";
        code = code +"   }\n";
        code = code +"   catch(PDOException $exception)\n";
        code = code +"    {\n";
        code = code +"        echo \"exception Message\" . $exception->getMessage();\n";
        code = code +"        parent::disconnect($connection);\n";
        code = code +"        print_r($connection->errorInfo());\n";
        code = code +"    }\n";
    	code = code+" }\n";
    	
    	return code;
    }
    public String getUpdateCode()
    {
    	CodeManager manager = new CodeManager();
    	
    	String code="  public function  update"+entity+"( $"+entity.toLowerCase()+")\n";
       
    	code = code+"   {\n";
        code = code+"     $connection = parent::connect();\n";
        
        MethodTemplate currentMethod = null;
       for( MethodTemplate methodTemplate: methodTemplates)
       {
    	   if(methodTemplate.getName().contentEquals("update"+entity))
    	   {
    		  // System.out.println(methodTemplate.getName());
    		   currentMethod = methodTemplate;
    		   break;
    	   }
       }
       
       
       List<VariableTemplate> variables = currentMethod.getVariables();
        
       for(VariableTemplate variableTemplate: variables)
       {
    	   code = code + "     $"+ variableTemplate.getName() +" = \""+variableTemplate.getValue()+"\";\n";
       }
      
        code = code+"      try\n";
        code = code+"      {\n";
        code = code+"       $statement = $connection->prepare($updateSQL);\n";
        
        code = code+"        $statement->bindValue(\":"+entity.toLowerCase()+"id\",$"+entity.toLowerCase()+"->get"+entity+"Id(),PDO::PARAM_INT);\n";
        
        for(int i=0; i< pojoMembers.size();i++)
   	  {
  		 //int j= i+2;
  	    code = code+"       $statement->bindValue(\":"+pojoMembers.get(i).toLowerCase()+"\",$"+entity.toLowerCase()+"->"+"get"+pojoMembers.get(i)+"(),PDO::PARAM_STR);\n";
  			
   	  }
        
           code = code+"       $statement->execute();\n";
           code = code+"       parent::disconnect($connection);\n";
           code = code+"      }\n";
           code = code+"      catch(PDOException $exception)\n";
           code = code+"        {\n";
           code = code+"         echo \"exception Message\" . $exception->getMessage();\n";
           code = code+"         parent::disconnect($connection);\n";
           code = code+"         print_r($connection->errorInfo());\n";
           code = code+"        }\n";
    	
    	
    	code = code+" }\n";
    	
    	return code;
    }
    public String getInsertCode()
    {
    	CodeManager manager = new CodeManager();
    	
    	String code="  public function  insert"+entity+"( $"+entity.toLowerCase()+")\n";
        code = code+"   {\n";
        code = code+"     $connection = parent::connect();\n";
        
        MethodTemplate currentMethod = null;
       for( MethodTemplate methodTemplate: methodTemplates)
       {
    	   if(methodTemplate.getName().contentEquals("insert"+entity))
    	   {
    		  // System.out.println(methodTemplate.getName());
    		   currentMethod = methodTemplate;
    		   break;
    	   }
       }
       
       
       List<VariableTemplate> variables = currentMethod.getVariables();
        
       for(VariableTemplate variableTemplate: variables)
       {
    	   code = code + "     $"+ variableTemplate.getName() +" = \""+variableTemplate.getValue()+"\";\n";
       }
      
        code = code+"      try\n";
        code = code+"      {\n";
        code = code+"       $statement = $connection->prepare($insertSQL);\n";
        
        code = code+"        $statement->bindValue(\":"+entity.toLowerCase()+"id\",$this->getMaxId()+1,PDO::PARAM_INT);\n";
        
        for(int i=0; i< pojoMembers.size();i++)
   	  {
  		 //int j= i+2;
  	    code = code+"       $statement->bindValue(\":"+pojoMembers.get(i).toLowerCase()+"\",$"+entity.toLowerCase()+"->"+"get"+pojoMembers.get(i)+"(),PDO::PARAM_STR);\n";
  			
   	  }
        /*
           $statement->bindValue(":userid",$this->getMaxUserId()+1,PDO::PARAM_INT);
           $statement->bindValue(":username",$user->getUserName(),PDO::PARAM_STR);
           $statement->bindValue(":password",$user->getPassword(),PDO::PARAM_STR);
*/
           code = code+"       $statement->execute();\n";
           code = code+"       parent::disconnect($connection);\n";
           code = code+"      }\n";
           code = code+"      catch(PDOException $exception)\n";
           code = code+"        {\n";
           code = code+"         echo \"exception Message\" . $exception->getMessage();\n";
           code = code+"         parent::disconnect($connection);\n";
           code = code+"         print_r($connection->errorInfo());\n";
           code = code+"        }\n";
          
           code = code+" }\n";
    	
    	return code;
    }
    
    public String getAllCode()
    {
        String code= "";
    	
    	CodeManager manager = new CodeManager();
    	code=code +"public function get"+entity+"s()\n";
    	code=code +" {\n";
    	code=code +"   $connection = parent::connect();\n";
    	code=code +"     $selectSQL = \"SELECT * FROM "+entity.toUpperCase()+"\";\n";
    	code=code +"     $rows = $connection->query($selectSQL);\n";
    	code=code +"     $"+entity.toLowerCase()+"s = array();\n";
    	code=code +"     foreach($rows as $row)\n";
    	code=code +"      {\n";
    	code = code+"       $"+entity.toLowerCase()+" = new "+entity+"();\n";
    	code = code+"       $"+entity.toLowerCase()+"->set"+entity+"id($row[0]);\n";
        for(int i=0; i< pojoMembers.size();i++)
   	    {
  		  int j= i+1;
  	      code = code+"       $"+entity.toLowerCase()+"->set"+pojoMembers.get(i)+"($row["+j+"]);\n";
  			
   	    }
    	/*
	            $user = new User();
	            $user->setUserId($row[0]);
	            $user->setUserName($row[1]);
	            $user->setPassword($row[2]);
	
	            $users[] = $user;
	            */
        
        code = code+"       $"+entity.toLowerCase()+"s[] = $"+entity.toLowerCase()+";\n";
	    code=code +"   }\n";
	    code=code +"     parent::disconnect($connection);\n";
	    code=code +"     return $"+entity.toLowerCase()+"s;\n";
        
    	  code = code+" }\n";
    	  
    	  return code;
    }
    public String getByNameCode()
    {
        String code= "";
    	
    	CodeManager manager = new CodeManager();
    	code = code+"public function check"+entity+"Exists($"+entity.toLowerCase()+")\n";
    	code = code+"{\n";
    	code = code+"     $connection = parent::connect();\n";
    	code = code+"     $selectSQL = \"SELECT * FROM "+entity.toUpperCase()+" WHERE "+entity.toUpperCase()+"NAME=:"+entity.toLowerCase()+"name\";\n";
			 
    	code = code+"	 $"+entity.toLowerCase()+" = \"\";\n";
    	code = code+"	 try\n";
    	code = code+"	 {\n";
    	code = code+"	  $statement = $connection->prepare($selectSQL);\n";
    	code = code+"     $statement->bindValue(\":name\",$"+entity.toLowerCase()+"->get"+entity+"Name(),PDO::PARAM_INT);\n";
		     
    	code = code+"     $statement->execute();\n";
    	code = code+"	 $row = $statement->fetch();\n";
    	
    	code = code+"       $"+entity.toLowerCase()+" = new "+entity+"();\n";
        //code = code+"        $statement->bindValue(\":"+entity.toLowerCase()+"id\",$this->getMaxId()+1,PDO::PARAM_INT);\n";
    	code = code+"       $"+entity.toLowerCase()+"->set"+entity+"id($row[0]);\n";
        for(int i=0; i< pojoMembers.size();i++)
   	    {
  		  int j= i+1;
  	      code = code+"       $"+entity.toLowerCase()+"->set"+pojoMembers.get(i)+"($row["+j+"]);\n";
  			
   	    }
        /*
              $user = new User();
	        
	           
	            $user->setUserId($row[0]);
	            $user->setUserName($row[1]);
	            $user->setPassword($row[2]);
	    */
        code = code+"      parent::disconnect($connection);\n";
	    code = code+"	 }\n";
	    code = code+"	catch(PDOException $exception)\n";
	    code = code+"    {\n";
	    code = code+"        echo \"exception Message\" . $exception->getMessage();\n";
	    code = code+"        parent::disconnect($connection);\n";
	    code = code+"       print_r($connection->errorInfo());\n";
	    code = code+"    }\n";
	    code = code+"     return $"+entity.toLowerCase()+";\n";
			
		
    	  code = code+" }\n";
    	  
    	  return code;
    	
    }
    public String getByIdCode()
    {
    	String code= "";
    	
    	CodeManager manager = new CodeManager();
    	code = code+"public function get"+entity+"($"+entity.toLowerCase()+"id)\n";
    	code = code+" {\n";
    	code = code+"	$connection = parent::connect();\n";
    	code = code+"   $selectSQL = \"SELECT * FROM "+entity.toUpperCase()+" WHERE "+entity.toUpperCase()+"ID=:"+entity.toLowerCase()+"id\";\n";
			 
    	code = code+"	$"+entity.toLowerCase()+" = \"\";\n";
    	code = code+"	 try\n";
    	code = code+"	  {\n";
    	code = code+"	    $statement = $connection->prepare($selectSQL);\n";
    	code = code+"       $statement->bindValue(\":"+entity.toLowerCase()+"id\",$"+entity.toLowerCase()+"id,PDO::PARAM_INT);\n";
		     
    	code = code+"       $statement->execute();\n";
    	code = code+"	    $row = $statement->fetch();\n";
    	code = code+"       $"+entity.toLowerCase()+" = new "+entity+"();\n";
        //code = code+"        $statement->bindValue(\":"+entity.toLowerCase()+"id\",$this->getMaxId()+1,PDO::PARAM_INT);\n";
    	code = code+"       $"+entity.toLowerCase()+"->set"+entity+"id($row[0]);\n";
        for(int i=0; i< pojoMembers.size();i++)
   	    {
  		  int j= i+1;
  	      code = code+"       $"+entity.toLowerCase()+"->set"+pojoMembers.get(i)+"($row["+j+"]);\n";
  			
   	    }
	        
	        /*   
	            $user->setUserId($row[0]);
	            $user->setUserName($row[1]);
	            $user->setPassword($row[2]);*/
	
	    code = code+"      parent::disconnect($connection);\n";
	    code = code+"	 }\n";
	    code = code+"	catch(PDOException $exception)\n";
	    code = code+"    {\n";
	    code = code+"        echo \"exception Message\" . $exception->getMessage();\n";
	    code = code+"        parent::disconnect($connection);\n";
	    code = code+"       print_r($connection->errorInfo());\n";
	    code = code+"    }\n";
	    code = code+"     return $"+entity.toLowerCase()+";\n";
			
			
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
		
		ClassTemplate classTemplate = manager.createClassTemplate("CustomerPDO");
		classTemplate.setSuperClass("DataObject");
		
		template.setClassTemplate(classTemplate);
		
		String entity = "Customer";
		
		template.setEntity(entity);
		
		String idEntity = "CUSTOMERID";
		
		template.setIdEntity(idEntity);
		
		String nameEntity = "CUSTOMERNAME";
		
		template.setNameEntity(nameEntity);
		
		List<String> entityColumns = new ArrayList<String>();
		entityColumns.add("CUSTOMERNAME");
		entityColumns.add("CITY");
		entityColumns.add("STATE");
		entityColumns.add("ZIPCODE");
		entityColumns.add("CONTACTNO");
		entityColumns.add("STREETADDRESS");
		entityColumns.add("COUNTRY");
		
	
		
		template.setEntityColumns(entityColumns);
		
		
		List<String> pojoMembers = new ArrayList<String>();
		pojoMembers.add("Name");
		pojoMembers.add("City");
		pojoMembers.add("State");
		pojoMembers.add("ZipCode");
		pojoMembers.add("ContactNo");
		pojoMembers.add("StreetAddress");
		pojoMembers.add("Country");
		
		template.setPojoMembers(pojoMembers);
		
		String sqlCode = "CUSTOMERID,CUSTOMERNAME,STREETADDRESS,STATE,COUNTRY,ZIPCODE,CONTACTNO,CITY";
		
		String valuesCode=":customerid,:name,:streetaddress,:state,:country,:zipcode,:contactno,:city";
		String updateCode = "CUSTOMERNAME=:name,STREETADDRESS=:streetaddress,STATE=:state,COUNTRY=:country,ZIPCODE=:zipcode,CONTACTNO=:contactno,CITY=:city";
		
		List<MemberTemplate> memberTemplates = new ArrayList<MemberTemplate>();
		
		/*		
        MemberTemplate memberHighestIdTemplate = manager.createMemberTemplate("highestIDSQL", "String", "SELECT MAX("+entity.toUpperCase()+"ID) AS MAX"+entity.toUpperCase()+"ID FROM "+entity.toUpperCase());
		
		memberTemplates.add(memberHighestIdTemplate);
		

        MemberTemplate memberSelectNameTemplate = manager.createMemberTemplate("selectSQL", "String", "SELECT * FROM "+entity.toUpperCase()+" WHERE "+nameEntity.toUpperCase()+"=?");
		
		memberTemplates.add(memberSelectNameTemplate);
		
		
		MemberTemplate memberSelectTemplate = manager.createMemberTemplate("selectIdSQL", "String", "SELECT * FROM "+entity.toUpperCase()+" WHERE "+idEntity.toLowerCase()+"=?");
		
		memberTemplates.add(memberSelectTemplate);
		*/
		
		VariableTemplate variableInsertTemplate = manager.createVariableTemplate("insertSQL", "String", "INSERT INTO "+entity.toUpperCase()+"("+sqlCode+") VALUES("+valuesCode+")");
		
		//memberTemplates.add(memberInsertTemplate);
		/*
        MemberTemplate memberUpdateTemplate = manager.createMemberTemplate("updateSQL", "String", "UPDATE "+entity.toUpperCase()+" SET "+updateCode+" WHERE "+idEntity.toUpperCase() +"=?");
		
		memberTemplates.add(memberUpdateTemplate);
		
        MemberTemplate memberDeleteTemplate = manager.createMemberTemplate("deleteSQL", "String", "DELETE FROM "+ entity.toUpperCase()+" WHERE "+idEntity.toUpperCase()+"=?");
		
		memberTemplates.add(memberDeleteTemplate);
		
        MemberTemplate memberSelectAllTemplate = manager.createMemberTemplate("selectAllSQL", "String", "SELECT * FROM "+ entity.toUpperCase());
		
		memberTemplates.add(memberSelectAllTemplate);
		
		template.setMemberTemplates(memberTemplates);
		*/
		List<MethodTemplate> methodTemplates = new ArrayList<MethodTemplate>();
		
		MethodTemplate methodInsertTemplate = manager.createMethodTemplate("insert"+entity, entity, null, "public");
		List<VariableTemplate> variables = new ArrayList<VariableTemplate>();
		variables.add(variableInsertTemplate);
		
		methodInsertTemplate.setVariables(variables);
		
		/*
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
		  */
		
		MethodTemplate methodUpdateTemplate = manager.createMethodTemplate("update"+entity, entity, null, "public");
		
		VariableTemplate variableUpdateTemplate = manager.createVariableTemplate("updateSQL", "String", "UPDATE "+entity.toUpperCase()+" SET "+updateCode+" WHERE "+idEntity.toUpperCase() +"=:"+idEntity.toLowerCase());
		
		List<VariableTemplate> updateVariables = new ArrayList<VariableTemplate>();
		updateVariables.add(variableUpdateTemplate);
		
		methodUpdateTemplate.setVariables(updateVariables);
		
		
		 methodTemplates.add(methodUpdateTemplate);
	        
	        methodTemplates.add(methodInsertTemplate);
	        
	        template.setMethodTemplates(methodTemplates); 
		String code = template.getCode();
		      
	    String className = classTemplate.getName();
	       
	      
	    manager.createFolder("php");
	    manager.createClass("php",className);
	            
	   manager.writeCode(code);
	    manager.closeClass();
	}

}
