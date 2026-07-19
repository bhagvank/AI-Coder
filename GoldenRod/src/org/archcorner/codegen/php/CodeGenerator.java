/**
 * 
 */
package org.archcorner.codegen.php;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bhagvan.kommadi
 *
 */
public class CodeGenerator {

	/*public void generateBusinessDelegate(String entity)
	{
       BusinessDelegateTemplate template = new BusinessDelegateTemplate();
		
		ClassTemplate classTemplate = new ClassTemplate();
		
		classTemplate.setName(entity+"BusinessDelegate");
		
		template.setClassTemplate(classTemplate);
		
		 CodeManager manager = new CodeManager();
		
		
		String className = classTemplate.getName();
		
       List<MemberTemplate> memberTemplates = new ArrayList<MemberTemplate>();
		
		
        MemberTemplate memberDAOTemplate = manager.createMemberTemplate(entity.toLowerCase()+"DAO", entity+"DAO", null);
		
		memberTemplates.add(memberDAOTemplate);
	       
	    template.setMemberTemplates(memberTemplates);
	    
	    template.setEntity(entity);
	    
	    manager.createClass(className);
	    
	    String code = template.getCode();
	    
	    manager.writeCode(code);
	    manager.closeClass();
	}*/
	
	public void generateDAO(String entity, String idEntity, String nameEntity, List<String> entityColumns, List<String> pojoMembers)
	{
		 DAOTemplate template = new DAOTemplate();
			
	       CodeManager manager = new CodeManager();
			
			ClassTemplate classTemplate = manager.createClassTemplate(entity+"DAO");
			
			template.setClassTemplate(classTemplate);
			
			template.setEntity(entity);
			
			template.setIdEntity(idEntity);
			
			template.setNameEntity(nameEntity);
			
			template.setEntityColumns(entityColumns);
			
			template.setPojoMembers(pojoMembers);
			
			String sqlCode ="";
			sqlCode = sqlCode+ entity.toUpperCase()+"ID,";
			String valueCode="";
			valueCode = valueCode +"?,";
			for(int i=0; i< entityColumns.size(); i++)
			{
				if(i < entityColumns.size()-1)
				{
				 sqlCode = sqlCode +entityColumns.get(i)+",";
				 valueCode = valueCode +"?,";
				}
				else
				{
					sqlCode = sqlCode +entityColumns.get(i);
					valueCode = valueCode +"?";
				}
			}
			
			String updateCode="";
			for(int i=0; i< entityColumns.size(); i++)
			{
				if(i < entityColumns.size()-1)
				{
				  updateCode = updateCode +entityColumns.get(i)+"=?,";
				}
				else
				{
					updateCode = updateCode +entityColumns.get(i)+"=?";
				}
			}
			
			List<MemberTemplate> memberTemplates = new ArrayList<MemberTemplate>();
			
			
			MemberTemplate memberHighestIdTemplate = manager.createMemberTemplate("highestIDSQL", "String", "SELECT MAX("+entity.toUpperCase()+"ID) AS MAX"+entity.toUpperCase()+"ID FROM "+entity.toUpperCase());
				
			memberTemplates.add(memberHighestIdTemplate);
			

	        MemberTemplate memberSelectNameTemplate = manager.createMemberTemplate("selectSQL", "String", "SELECT * FROM "+entity.toUpperCase()+" WHERE "+nameEntity.toUpperCase()+"=?");
			
			memberTemplates.add(memberSelectNameTemplate);
			
			MemberTemplate memberSelectTemplate = manager.createMemberTemplate("selectIdSQL", "String", "SELECT * FROM "+entity.toUpperCase()+" WHERE "+idEntity.toUpperCase()+"=?");
			
			memberTemplates.add(memberSelectTemplate);
			
			MemberTemplate memberInsertTemplate = manager.createMemberTemplate("insertSQL", "String", "INSERT INTO "+entity.toUpperCase()+"("+sqlCode+") VALUES("+valueCode+")");
			
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
		       
		      
		    manager.createFolder("php");
		    manager.createClass("php",className);
		            
		    manager.writeCode(code);
		    manager.closeClass();
	}
	
	public void generatePojo(String entity,List<String> members, List<String> types)
	{
      PojoTemplate template = new PojoTemplate();
		
		CodeManager manager = new CodeManager();
		
		
		ClassTemplate classTemplate = manager.createClassTemplate(entity);
		
		template.setClassTemplate(classTemplate);
		
		List<MemberTemplate> memberTemplates = new ArrayList<MemberTemplate>();
		
		for(int i=0; i< members.size(); i++)
		{
			MemberTemplate memberTemplate = manager.createMemberTemplate(members.get(i), types.get(i), null);
			
			memberTemplates.add(memberTemplate);
		}
		
		template.setMemberTemplates(memberTemplates);
				
        
		String code = template.getCode();
		      
	    String className = classTemplate.getName();
	       
	      
	    manager.createFolder("php");
	    manager.createClass("php",className);
	            
	    manager.writeCode(code);
	    manager.closeClass();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        CodeGenerator generator = new CodeGenerator();
        String entity = "Partner";
        String idEntity = "PartnerId";
        String nameEntity = "PartnerName";
        
        List<String> members = new ArrayList<String>();
        members.add("partnerId");
        members.add("partnerName");
        members.add("partnerAddress");
        members.add("partnerCity");
        members.add("partnerState");
        members.add("partnerCountry");
       
        List<String> types = new ArrayList<String>();
        types.add("int");
        types.add("String");
        types.add("String");
        types.add("String");
        types.add("String");
        types.add("String");
		
        generator.generatePojo(entity,members,types);
        
        List<String> entityColumns = new ArrayList<String>();
		entityColumns.add("PARTNERNAME");
		entityColumns.add("PARTNERADDRESS");
		entityColumns.add("PARTNERCITY");
		entityColumns.add("PARTNERSTATE");
		entityColumns.add("PARTNERCOUNTRY");
		
	
		
		
		List<String> pojoMembers = new ArrayList<String>();
		pojoMembers.add("partnerName");
		pojoMembers.add("partnerAddress");
		pojoMembers.add("partnerCity");
		pojoMembers.add("partnerState");
		pojoMembers.add("partnerCountry");
		
		//String sqlCode = "PARTNERID,PARTNERNAME,PARTNERADDRESS,PARNTERCITY,PARTNERSTATE,PARTNERCOUNTRY";
		
		//String valueCode="?,?,?,?,?,?";
		
		//String updateCode = "PARTNERNAME=?,PARTNERADDRESS=?,PARTNERCITY=?,PARTNERSTATE=?,PARTNERCOUNTRY=?";
    
		generator.generateDAO(entity, idEntity, nameEntity,entityColumns,pojoMembers);
       // generator.generateBusinessDelegate(entity);
	}

}
