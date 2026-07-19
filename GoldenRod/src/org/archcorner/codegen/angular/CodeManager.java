/**
 * 
 */
package org.archcorner.codegen.angular;

import java.io.File;
import java.io.PrintWriter;

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
	
	public void createHTML(String path,String className)
	{
		try
		{
		 File file = new File(path+"/"+className+".html");	
		 writer = new PrintWriter(file);
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
	}
	/*
	public void createHTML(String className)
	{
		try
		{
		 writer = new PrintWriter(className+".html", "UTF-8");
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
	
	public String openHTMLCode(String appName)
	{
		String code = "<!DOCTYPE html> \n";
		
		code = code + "<html ng-app=\""+appName+"\"> \n"; 
		
		return code;
	}
	
	public String closeHTMLCode()
	{
		String code = "</html>";
	   return 	code;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
