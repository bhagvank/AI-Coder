/**
 * 
 */
package com.architectcorner.ai.platform.esb;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 * @author bhagvan_kommadi
 *
 */
public class DataValidator {

	private List<String> monthList = new ArrayList<String>();
	/**
	 * 
	 */
	public DataValidator() {
		// TODO Auto-generated constructor stub
	}
	
	public void init()
	{
		monthList.add("JAN");
		monthList.add("FEB");
		monthList.add("MAR");
		monthList.add("APR");
		monthList.add("MAY");
		monthList.add("JUN");
		monthList.add("JUL");
		monthList.add("AUG");
		monthList.add("SEP");
		monthList.add("OCT");
		monthList.add("NOV");
		monthList.add("DEC");
	}

	public List<String> validateData(String dataValue,String type)
	{
		List<String> errorMessage = null;
		
		if(type.contentEquals("year"))
		{
			if(dataValue.length() == 4 || dataValue.length() ==2)
			{
				for(int i=0; i < dataValue.length(); i++)
				{
					char charValue = dataValue.charAt(i);
					
					if(Character.isDigit(charValue))
					{
						
					}
					else
					{
						errorMessage = new ArrayList<String>();
						errorMessage.add(charValue +"is not an integer");
								
					}
					//Integer.
				}
			}
		}
		else if(type.contentEquals("month"))
		{
			if(dataValue.length() == 2 || dataValue.length() ==1)
			{
				for(int i=0; i < dataValue.length(); i++)
				{
					char charValue = dataValue.charAt(i);
					
					if(Character.isDigit(charValue))
					{
						
					}
					else
					{
						if(errorMessage == null)
						{
						 errorMessage = new ArrayList<String>();
						 errorMessage.add(charValue +"is not an integer");
						}
						else
						{
						 errorMessage.add(charValue +"is not an integer");
								
						}
					}
					//Integer.
				}
			}
			else if(dataValue.length() == 3)
			{
				for(String month: monthList)
				{
					if(month.equalsIgnoreCase(dataValue))
					{
						
					}
					else
					{
						if(errorMessage == null)
						{
							errorMessage = new ArrayList();
							errorMessage.add(dataValue +"is not a month");
						}
						else
						{
							errorMessage.add(dataValue +"is not a month");
						}
					}
				}
			}
		}
		else if(type.contentEquals("day"))
		{
			if(dataValue.length() == 2 || dataValue.length() ==1)
			{
				for(int i=0; i < dataValue.length(); i++)
				{
					char charValue = dataValue.charAt(i);
					
					if(Character.isDigit(charValue))
					{
						
					}
					else
					{
						if(errorMessage == null)
						{
						 errorMessage = new ArrayList<String>();
						 errorMessage.add(charValue +"is not a day");
						}
						else
						{
						 errorMessage.add(charValue +"is not a day");
								
						}
					}
					//Integer.
				}
			}
			else
			{
				if(errorMessage == null)
				{
				 errorMessage = new ArrayList<String>();
				 errorMessage.add(dataValue +"is not a day");
				}
				else
				{
				 errorMessage.add(dataValue +"is not a day");	
				}
			}
		}
		else if(type.contentEquals("date"))
		{
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
			try
			{
			 dateFormat.parse(dataValue);
			}
			catch(ParseException exception)
			{
				if(errorMessage == null)
				{
				 errorMessage = new ArrayList<String>();
				 errorMessage.add(dataValue +"is not a date");	
				}
				else
				{
				 errorMessage.add(dataValue +"is not a date");	
				}
			}
			 
		}
		else if(type.contentEquals("number"))
		{
			for(int i=0; i < dataValue.length(); i++)
			{
				char charValue = dataValue.charAt(i);
				
				if(Character.isDigit(charValue))
				{
					
				}
				else
				{
					if(errorMessage == null)
					{
					 errorMessage = new ArrayList();
					 errorMessage.add(charValue +"is not a number");
					}
					else
					{
					 errorMessage.add(charValue +"is not a number");
							
					}
				}
				//Integer.
			}
		}
		else if(type.contentEquals("email"))
		{
			//TBD
		}
			
		//System.out.println(errorMessage.toString());
		
		return errorMessage;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
