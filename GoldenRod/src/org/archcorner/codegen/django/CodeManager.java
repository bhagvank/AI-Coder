/**
 * 
 */
package org.archcorner.codegen.django;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author bhagvan.kommadi
 *
 */
public class CodeManager {

	private PrintWriter writer;
	

	public void createFile(String path,String fileName)
	{
		try
		{
		 File file = new File(path+"/"+fileName+".py");	
		 
		 FileOutputStream  outputStream = new FileOutputStream(file);
		 writer = new PrintWriter(outputStream,true);
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
	}
	
    public String executeCommands(List<String> commands)
    {
    	
    	StringBuffer buffer = new StringBuffer();
    	for(String command: commands)
    	{
    		String output = executeRuntime(command);
    		buffer.append(output);
    	}
    	
    	
    	return buffer.toString();
    	/*
    	
    	StringBuffer runTimeOutput = new StringBuffer();
    	
    	ProcessBuilder builder = new ProcessBuilder(commands);
    	
    	
    	
    	try
		{
    		File output = new File("/Users/bhagvan.kommadi/Desktop/Turbizo/output.txt");
    		
    		
			
			builder.redirectOutput(output);
			
			builder.redirectErrorStream(true);
			
            Process process = builder.start();
			
			process.waitFor();
			
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
    	
    	return runTimeOutput.toString();
    	
    	*/
    	
    }
    
    private void printFile(File file)
    {
    	
    	try
    	{
    	   FileReader reader = new FileReader(file);
    	   BufferedReader bufferedReader = new BufferedReader(reader);
    	   
    	   String line;
    	   while((line = bufferedReader.readLine()) != null)
    	   {
    		   System.out.println(line);
    	   }
    	   
    	   bufferedReader.close();
    	   reader.close();
    	}
    	catch(Exception exception)
    	{
    		
    	}
    }
    
	public String executeRuntime(String runtimeCall)
	{
		StringBuffer runTimeOutput = new StringBuffer();
		
		Process process;
		System.out.println(runtimeCall);
		try
		{
			process = Runtime.getRuntime().exec(runtimeCall);
			process.waitFor();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String lineOutput = "";
			
			while((lineOutput = bufferedReader.readLine()) != null)
			{
				runTimeOutput.append(lineOutput+"\n");
			
			}
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		
		return runTimeOutput.toString();
	}
	
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
	/*
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
	*/
	//lowerCamelCase
	public String getLowerCaseName(String name)
	{
		String first  = String.valueOf(name.charAt(0)).toUpperCase();
		String methodName =first+ name.substring(1);
		
		return methodName;
	}
	/*
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
	
	*/
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       System.out.println("Hello Golden Rod");
       /*
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
       
       */
       CodeManager manager = new CodeManager();
       
       //String runTimeMessage = manager.executeRuntime("ping -c 3 google.com");
       
      //String runTimeCommands = "cd /Users/bhagvan.kommadi/Documents/AIPredict/GoldenRod/mysite";
       //String runTimeCommands = "mkdir generated"+System.currentTimeMillis();
       //String runTimeCommands = "/Library/Frameworks/Python.framework/Versions/3.6/bin/django-admin startproject mysite";
       
       
      // String runTimeCommands = "/Library/Frameworks/Python.framework/Versions/3.6/bin/python3 /Users/bhagvan.kommadi/Documents/AIPredict/GoldenRod/mysite/manage.py startapp polls";
       String runTimeCommands = "mv polls mysite";
       String runTimeMessage = manager.executeRuntime(runTimeCommands);
       System.out.println(runTimeMessage);
       
       
      // List<String> commands = new ArrayList();
       
      /* commands.add("ping -c 3 google.com");
       commands.add("ifconfig");
       commands.add("pwd");
       commands.add("ls");
       */
         //commands.add("cd /users/bhagvan.kommadi/desktop/django");
        // commands.add("mkdir generated"+System.currentTimeMillis());
        // commands.add("django-admin startproject mysite");
         
       //String runTimeMessages = manager.executeCommands(commands);
       
       //System.out.println(runTimeMessages);
       
	}

}
