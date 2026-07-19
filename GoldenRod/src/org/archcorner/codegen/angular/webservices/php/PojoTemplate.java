/**
 * 
 */
package org.archcorner.codegen.angular.webservices.php;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bhagvan.kommadi
 *
 */
public class PojoTemplate {
	
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

	
	public String getCode()
	{
		String code = "";
		   CodeManager manager = new CodeManager();
	       
	       String className = classTemplate.getName();
	       
	      // manager.createClass(className);
	       code = code + manager.openClassCode(classTemplate);
	       
	       for(MemberTemplate memberTemplate:memberTemplates)
	       {
	       
	       
	       
	         String member = manager.getMemberCode(memberTemplate);
	       
	         code = code + member;
	         
	         String getMethod = manager.getMemberGetterCode(memberTemplate);
	 
	         code = code + getMethod;
	         
	         String setMethod = manager.getMemberSetterCode(memberTemplate);
	       
	         code = code + setMethod;
	       
	       }
	       
	       String method = manager.getMainMethodCode();
	       
	       code = code + method;
	       
	       code = code+ "} \n";
		
		return code;
	}
	
	public static void main(String[] args)
	{
		
		PojoTemplate template = new PojoTemplate();
		
		CodeManager manager = new CodeManager();
		
		/*entityColumns.add("CUSTOMERNAME");
		entityColumns.add("STREETADDRESS");
		entityColumns.add("STATE");
		entityColumns.add("COUNTRY");
		entityColumns.add("ZIPCODE");
		entityColumns.add("CONTACTNO");
		entityColumns.add("CITY");*/
		
		ClassTemplate classTemplate = manager.createClassTemplate("Customer");
		
		template.setClassTemplate(classTemplate);
		
		List<MemberTemplate> memberTemplates = new ArrayList<MemberTemplate>();
		
		MemberTemplate memberFirstTemplate = manager.createMemberTemplate("firstName", "String", "john");
		
		memberTemplates.add(memberFirstTemplate);
		
		MemberTemplate memberLastTemplate = manager.createMemberTemplate("lastName", "String", "Smith");
		
		memberTemplates.add(memberLastTemplate);
		
        MemberTemplate memberIdTemplate = manager.createMemberTemplate("customerId", "int", null);
		
		memberTemplates.add(memberIdTemplate);
        
		MemberTemplate memberNameTemplate = manager.createMemberTemplate("customerName", "String", null);
		
		memberTemplates.add(memberNameTemplate);
		
        MemberTemplate memberStreetTemplate = manager.createMemberTemplate("streetAddress", "String", null);
		
		memberTemplates.add(memberStreetTemplate); 
		
        MemberTemplate memberStateTemplate = manager.createMemberTemplate("state", "String", null);
		
		memberTemplates.add(memberStateTemplate); 
		
        MemberTemplate memberCountryTemplate = manager.createMemberTemplate("country", "String", null);
		
		memberTemplates.add(memberCountryTemplate); 
		
        MemberTemplate memberZipTemplate = manager.createMemberTemplate("zipCode", "String", null);
		
		memberTemplates.add(memberZipTemplate);
        
		MemberTemplate memberContactTemplate = manager.createMemberTemplate("contactNo", "String", null);
		
		memberTemplates.add(memberContactTemplate);
		
        MemberTemplate memberCityTemplate = manager.createMemberTemplate("city", "String", null);
		
		memberTemplates.add(memberCityTemplate);
		
		template.setMemberTemplates(memberTemplates);
		
		String code = template.getCode();
		      
	    String className = classTemplate.getName();
	         
	    String path = "angular"; 
	    manager.createFolder("angular");
	    manager.createFolder("angular/php");
	    manager.createClass("angular/php",className);
	            
	    manager.writeCode(code);
	    manager.closeClass();
	}
}
