/**
 * 
 */
package org.archcorner.codegen.java;

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
		 File file = new File(path+"/"+className+".java");	
		 writer = new PrintWriter(file);
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
	}
	
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
	
	public String openClassCode(ClassTemplate classTemplate)
	{
		 String className = classTemplate.getName();
		String code = "public class "+className+"{ \n";
		
		return code;
	}
	
	public String closeClassCode(ClassTemplate classTemplate)
	{
		String code ="}\n";
		return code;
	}
	public String closeMethodCode(MethodTemplate methodTemplate)
	{
		String code ="}\n";
		return code;
	}
	public String getMemberCode(MemberTemplate memberTemplate)
	{
		String code ="";
		if(memberTemplate.getValue() != null)
		{
		  code = code+"private "+memberTemplate.getType() + " "+memberTemplate.getName()+" = \""+memberTemplate.getValue()+"\";"+"\n";
		}
		else
		{
			code = code+"private "+memberTemplate.getType() + " "+memberTemplate.getName()+" ;\n";
		}
		return code;
	}
	
	public String getMemberGetterCode(MemberTemplate memberTemplate)
	{
		
		String first  = String.valueOf( memberTemplate.getName().charAt(0)).toUpperCase();
		String methodName =first+ memberTemplate.getName().substring(1);
		MethodTemplate method = createMethodTemplate("get"+methodName, memberTemplate.getType(), null,"public");
		
		String code =  getMethodCode(method)+"\n";
		
		code = code + "return "+memberTemplate.getName()+";\n";
		
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
		
		
		
		code = code + "this."+memberName+"="+ memberName+";\n";
		
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
		    	   parameterCode = parameterCode + template.getType()+" "+template.getName()+" ";
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
		  method = methodTemplate.getAccess() +" "+methodTemplate.getType()+" "+methodTemplate.getReturnType() +" "+methodTemplate.getName() +"( "+parameterCode +") {";
		}
		else
		{
			 method = methodTemplate.getAccess()+" "+methodTemplate.getReturnType() +" "+methodTemplate.getName() +"( "+parameterCode +") {";
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
       
       MemberTemplate memberTemplate = manager.createMemberTemplate("firstName", "String", "john");
       
       
       manager.createFolder("java");
	    
	    manager.createClass("java", className);
	    
       String code = manager.openClassCode(classTemplate);
       manager.writeCode(code);
       
       String member = manager.getMemberCode(memberTemplate);
       manager.writeCode(member);
       
       String firstNameGetMethod = manager.getMemberGetterCode(memberTemplate);
 
       manager.writeCode(firstNameGetMethod);
       
       String firstNameSetMethod = manager.getMemberSetterCode(memberTemplate);
       
       manager.writeCode(firstNameSetMethod);
       
       
       String method = manager.getMainMethodCode();
       
       manager.writeCode(method);
       manager.writeCode(manager.closeClassCode(classTemplate));
       manager.closeClass();
	}

}
