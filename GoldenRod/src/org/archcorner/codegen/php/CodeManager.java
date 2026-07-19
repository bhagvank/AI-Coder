/**
 * 
 */
package org.archcorner.codegen.php;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author bhagvan.kommadi
 *
 */
public class CodeManager {

	private PrintWriter writer;
	
	
	public void createFolder(String folderName)
	{
		File directory = new File(folderName);
		if(! directory.exists())
		{
			directory.mkdir();
		}
		
		
	}
	
	public void createClass(String path,String className)
	{
		try
		{
		 File file = new File(path+"/"+className+".php");	
		 writer = new PrintWriter(file);
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
	}
	
	/*
	public void createClass(String className)
	{
		try
		{
		 writer = new PrintWriter(className+".php", "UTF-8");
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
	}
	*/
	
	public void writeCode(String code)
	{
		writer.println(code);
		
	}
	
	public void closeClass()
	{
		writer.close();
	}
	
	public ClassTemplate createClassTemplate(String name)
	{
		ClassTemplate classTemplate = new ClassTemplate();
	       classTemplate.setName(name);
	       
	       return classTemplate;
	}
	
	public MemberTemplate createMemberTemplate(String name, String type,String value)
	{
		 MemberTemplate memberTemplate = new MemberTemplate();
	       memberTemplate.setName(name);
	       memberTemplate.setType(type);
	       memberTemplate.setValue(value);
	       
	       return memberTemplate;
	}
	
	public VariableTemplate createVariableTemplate(String name, String type,String value)
	{
		 VariableTemplate variableTemplate = new VariableTemplate();
	       variableTemplate.setName(name);
	       variableTemplate.setType(type);
	       variableTemplate.setValue(value);
	       
	       return variableTemplate;
	}
	
	public MethodTemplate createMethodTemplate(String name,String returnType,String type,String access)
	{
		MethodTemplate methodTemplate = new MethodTemplate();
	       methodTemplate.setName(name);
	       methodTemplate.setReturnType(returnType);
	       methodTemplate.setType(type);
	       methodTemplate.setAccess(access);
	       
	       return methodTemplate;
	}
	
	public ParameterTemplate createParameterTemplate(String name, String type)
	{
		ParameterTemplate parameterTemplate = new ParameterTemplate();
	       parameterTemplate.setName(name);
	       parameterTemplate.setType(type);
	       
	       return parameterTemplate;
	}
	public String openPHPCode()
	{
		String code = "<?php \n"; 
		
		return code;
	}
	public String openClassCode(ClassTemplate classTemplate)
	{
		 String className = classTemplate.getName();
		 
		String code = "\n"; 
		
		String superClassName = classTemplate.getSuperClass();
		if(superClassName == null)
		{
		  code = code +"class "+className+"\n { \n";
		}
		else
		{
			code = code +"class "+className+" extends "+ superClassName+"\n { \n";
		}
		return code;
	}
	
	public String closeClassCode(ClassTemplate classTemplate)
	{
		String code =" }\n";
		code = code+ "?>";
		return code;
	}
	public String closeMethodCode(MethodTemplate methodTemplate)
	{
		String code ="\n     }\n";
		
		return code;
	}
	public String getMemberCode(MemberTemplate memberTemplate)
	{
		String code ="";
		if(memberTemplate.getValue() != null)
		{
		  code = code+"   private " + " $_"+memberTemplate.getName()+" = \""+memberTemplate.getValue()+"\";"+"\n";
		}
		else
		{
			code = code+"   private "+ " $_"+memberTemplate.getName()+" ;\n";
		}
		return code;
	}
	public String getMethodVariableCode(MemberTemplate memberTemplate)
	{
		String code ="";
		if(memberTemplate.getValue() != null)
		{
		  code = code+memberTemplate.getName()+" = \""+memberTemplate.getValue()+"\";"+"\n";
		}
		else
		{
			code = code+memberTemplate.getName()+" ;\n";
		}
		return code;
	}
	public String getMemberGetterCode(MemberTemplate memberTemplate)
	{
		
		String first  = String.valueOf( memberTemplate.getName().charAt(0)).toUpperCase();
		String methodName =first+ memberTemplate.getName().substring(1);
		MethodTemplate method = createMethodTemplate("get"+methodName, memberTemplate.getType(), null,"public");
		
		String code =  getMethodCode(method)+"\n";
		
		code = code + "      return $this->_"+memberTemplate.getName()+";\n";
		
		code = code + closeMethodCode(method);
		
		return code;
	}
	
	//lowerCamelCase
	public String getLowerCaseName(String name)
	{
		String first  = String.valueOf(name.charAt(0)).toUpperCase();
		String methodName =first+ name.substring(1);
		
		return methodName;
	}
	public String getMemberSetterCode(MemberTemplate memberTemplate)
	{
		
		String first  = String.valueOf( memberTemplate.getName().charAt(0)).toUpperCase();
		String methodName =first+ memberTemplate.getName().substring(1);
		
		String memberName = memberTemplate.getName();
		
		ParameterTemplate parameterTemplate = createParameterTemplate(memberName, memberTemplate.getType());
	       
	       
	       List<ParameterTemplate> parameterTemplates = new ArrayList<ParameterTemplate>();
	       parameterTemplates.add(parameterTemplate);
	       
	       
	       
		MethodTemplate method = createMethodTemplate("set"+methodName, "void", null,"public");
		method.setParameters(parameterTemplates);
		
		String code =  getMethodCode(method)+"\n";
		
		
		
		code = code + "      $this->_"+memberName+" = $"+ memberName+";\n";
		
		code = code + closeMethodCode(method);
		
		return code;
	}
	
	public String getMainMethodCode()
	{
		
		MethodTemplate method = createMethodTemplate("main", "void", "static","public");
		  ParameterTemplate parameterTemplate = createParameterTemplate("args", "String[]");
	       
	       
	       List<ParameterTemplate> parameterTemplates = new ArrayList<ParameterTemplate>();
	       parameterTemplates.add(parameterTemplate);
	       
	       method.setParameters(parameterTemplates);	
		String code = getMethodCode(method)+"\n";
		
		code = code+ closeMethodCode(method);
		
		return code;
	}
	public String getParametersCode(MethodTemplate methodTemplate)
	{
		 List<ParameterTemplate> parameters = methodTemplate.getParameters();
	       String parameterCode ="";
	       
	       if(parameters != null)
	       {
		       for(ParameterTemplate template:parameters)
		       {
		    	   parameterCode = parameterCode +" $"+template.getName()+" ";
		       }
	       }
	       return parameterCode;
	}
	
	public String getMethodCode(MethodTemplate methodTemplate)
	{
		String parameterCode = getParametersCode(methodTemplate);
		
		String method ="";
		if(methodTemplate.getType() != null)
		{
		  method = "   "+methodTemplate.getAccess() +" function "+methodTemplate.getType()+" "+" "+methodTemplate.getName() +"( "+parameterCode +")  \n    {";
		}
		else
		{
			 method = "   "+methodTemplate.getAccess()+" function "+" "+methodTemplate.getName() +"( "+parameterCode +") \n     {";
		}
        return method;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       System.out.println("Hello Golden Rod");
       
       CodeManager manager = new CodeManager();
       ClassTemplate classTemplate = manager.createClassTemplate("Customer");
       
       String className = classTemplate.getName();
       
       
     MemberTemplate memberTemplate1 = manager.createMemberTemplate("customerId", "String", null);
     MemberTemplate memberTemplate2 = manager.createMemberTemplate("name", "String", null);
     MemberTemplate memberTemplate3 = manager.createMemberTemplate("streetAddress", "String", null);
     MemberTemplate memberTemplate4 = manager.createMemberTemplate("state", "String", null);
     MemberTemplate memberTemplate5 = manager.createMemberTemplate("country", "String", null);
     MemberTemplate memberTemplate6 = manager.createMemberTemplate("zipcode", "String", null);
     MemberTemplate memberTemplate7 = manager.createMemberTemplate("contactNo", "String", null);
     MemberTemplate memberTemplate8 = manager.createMemberTemplate("city", "String", null);
     
     List<MemberTemplate> members = new ArrayList<MemberTemplate>();
     
     members.add(memberTemplate1);
     members.add(memberTemplate2);
     members.add(memberTemplate3);
     members.add(memberTemplate4);
     members.add(memberTemplate5);
     members.add(memberTemplate6);
     members.add(memberTemplate7);
     members.add(memberTemplate8);
     classTemplate.setMembers(members);
     
       manager.createFolder("php");
       manager.createClass("php",className);
       
       String openCode = manager.openPHPCode();
       manager.writeCode(openCode);
       String code = manager.openClassCode(classTemplate);
       manager.writeCode(code);
       
       for(MemberTemplate memberTemplate: members)
       {
        String member = manager.getMemberCode(memberTemplate);
        manager.writeCode(member);
       
        String firstNameGetMethod = manager.getMemberGetterCode(memberTemplate);
 
        manager.writeCode(firstNameGetMethod);
       
        String firstNameSetMethod = manager.getMemberSetterCode(memberTemplate);
       
        manager.writeCode(firstNameSetMethod);
       
       }
       //String method = manager.getMainMethodCode();
       
       //MethodTemplate method = createMethodTemplate("getMaxId", "function", null,"public");
       //manager.writeCode(method);
       manager.writeCode(manager.closeClassCode(classTemplate));
        
       manager.closeClass();
	}

}
