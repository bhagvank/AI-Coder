package org.archcorner.codegen.java;

import java.util.ArrayList;
import java.util.List;



public class BusinessDelegateTemplate {
	
	private List<MemberTemplate> memberTemplates;
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

	private ClassTemplate classTemplate;
	
	private String entity;
	
	
	public String getCode()
	{
	
			String code = "";
			   CodeManager manager = new CodeManager();
		       
		       String className = classTemplate.getName();
		       
		       code = code+"import java.util.List;\n";
		       code = code+"import org.archcorner.chartreuse.dal.dao."+entity+"DAO;\n";
		       code = code+"import org.archcorner.chartreuse.pojo."+entity+";\n";
		       code = code + "\n";
		       code = code + manager.openClassCode(classTemplate);
		       code = code + "\n";
		       
		       for(MemberTemplate memberTemplate:memberTemplates)
		       {
		       
		       
		       
		         String member = manager.getMemberCode(memberTemplate);
		       
		         code = code + member;
		         
		       
		       }
		       code = code + "\n";
		      
		       code = code + getHighestIdCode();
			      
		       code = code + "\n";
		       
		       code = code + getInsertCode();
		      
		       code = code + "\n";
		       
		       code = code + getUpdateCode();
		       
		       code = code + "\n";
		       
		       code = code + getDeleteCode();
		       
		       code = code + "\n";
		       
		       code = code+ getByIdCode();
		       code = code + "\n";
		       
		       code = code + getByNameCode();
		       code = code + "\n";

		       code = code + getAllCode();
		       code = code + "\n";

		       
		       
		       code = code+ "} \n";
			   	
				
		       
		       return code;
	}
	public String getHighestIdCode()
	{
		String code = "";
		
		code = code + "public int getHighestId"+"()\n";
		code = code + " {\n";
		code = code +"  "+ entity.toLowerCase()+"DAO = new "+entity+"DAO();\n";
		code = code +"   int id="+ entity.toLowerCase()+"DAO.getHighestId"+"();\n";
		code = code +"   return id;\n";
		code = code+ " } \n";
		
		return code;
		
	}
	public String getInsertCode()
	{
		String code = "";
		
		code = code + "public void insert"+entity+"("+entity+" "+entity.toLowerCase()+")\n";
		code = code + " {\n";
		code = code +"  "+ entity.toLowerCase()+"DAO = new "+entity+"DAO();\n";
		code = code +"  "+ entity.toLowerCase()+"DAO.insert"+entity+"("+entity.toLowerCase()+");\n";
		code = code+ " } \n";
		
		return code;
		
	}
	public String getUpdateCode()
	{
		String code = "";
		
		code = code + "public void update"+entity+"("+entity+" "+entity.toLowerCase()+")\n";
		code = code + " {\n";
		code = code +"  "+ entity.toLowerCase()+"DAO = new "+entity+"DAO();\n";
		code = code +"  "+ entity.toLowerCase()+"DAO.update"+entity+"("+entity.toLowerCase()+");\n";
		code = code+ " } \n";
		
		return code;
		
	}
	public String getDeleteCode()
	{
		String code = "";
		
		code = code + "public void delete"+entity+"("+entity+" "+entity.toLowerCase()+")\n";
		code = code + " {\n";
		code = code +"  "+ entity.toLowerCase()+"DAO = new "+entity+"DAO();\n";
		code = code +"  "+ entity.toLowerCase()+"DAO.delete"+entity+"("+entity.toLowerCase()+");\n";
		code = code+ " } \n";
		
		return code;
		
		
	}
	public String getByIdCode()
	{
		String code = "";
		
		code = code + "public "+entity+"  get"+entity+"ById(int " +entity.toLowerCase()+"Id)\n";
		code = code + " {\n";
		code = code +"  "+ entity.toLowerCase()+"DAO = new "+entity+"DAO();\n";
		code = code +"  "+entity+ " "+entity.toLowerCase()+"= "+ entity.toLowerCase()+"DAO.get"+entity+"ById("+entity.toLowerCase()+"Id);\n";
        code = code +" return "+entity.toLowerCase()+";\n";
		code = code+ " } \n";
		
		return code;
	}
	
	public String getByNameCode()
	{
		String code = "";
		
		code = code + "public "+entity+"  get"+entity+"(String " +entity.toLowerCase()+"Name)\n";
		code = code + " {\n";
		code = code +"  "+ entity.toLowerCase()+"DAO = new "+entity+"DAO();\n";
		code = code +"  "+entity+ " "+entity.toLowerCase()+"= "+ entity.toLowerCase()+"DAO.get"+entity+"("+entity.toLowerCase()+"Name);\n";
        code = code +" return "+entity.toLowerCase()+";\n";
		code = code+ " } \n";
		
		return code;
	}
	public String getAllCode()
	{
		String code = "";
		
		code = code + "public List<"+entity+">  getAll( )\n";
		code = code + " {\n";
		code = code +"  "+ entity.toLowerCase()+"DAO = new "+entity+"DAO();\n";
		code = code +"   List<"+entity+ ">  "+entity.toLowerCase()+"s = "+ entity.toLowerCase()+"DAO.get"+entity+"s( );\n";
        code = code +" return "+entity.toLowerCase()+"s;\n";
		code = code+ " } \n";
		return code;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BusinessDelegateTemplate template = new BusinessDelegateTemplate();
		
		ClassTemplate classTemplate = new ClassTemplate();
		
		classTemplate.setName("CustomerBusinessDelegate");
		
		template.setClassTemplate(classTemplate);
		
		 CodeManager manager = new CodeManager();
		
		
		String className = classTemplate.getName();
		
       List<MemberTemplate> memberTemplates = new ArrayList<MemberTemplate>();
		
		
        MemberTemplate memberDAOTemplate = manager.createMemberTemplate("customerDAO", "CustomerDAO", null);
		
		memberTemplates.add(memberDAOTemplate);
	       
	    template.setMemberTemplates(memberTemplates);
	    
	    template.setEntity("Customer");
	    
	    manager.createFolder("java");
	    
	    manager.createClass("java", className);
	    
	    String code = template.getCode();
	    
	    manager.writeCode(code);
	    manager.closeClass();
	}

}
