/**
 * 
 */
package org.archcorner.chartreuse.esb;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author bhagvan_kommadi
 *
 */
public class CsvParser {

	/**
	 * 
	 */
	public CsvParser() {
		// TODO Auto-generated constructor stub
	}
	
	public List<List<String>> parse(BufferedReader reader)
	{
		List<List<String>> csvContent = new ArrayList();
		String line = "";
		
		try
		{
			String data = null;
			
			do
			{
				
				data = reader.readLine();
			}while(!(data.toLowerCase().contains("content-type")));
			
			
			while((line = reader.readLine()) != null)
			{
				if(line.startsWith("--"))
				{
					continue;
				}
				
				if(! (line.toLowerCase().contains("webkitformboundary")))
				{
					if(!line.toLowerCase().contains("content-disposition"))
					{
					
						 String[] csvLine = line.split(",");
						
						List<String> lineContent = null;
						
						for(int i=0; i< csvLine.length; i++)
						{
							if(!csvLine[i].equalsIgnoreCase("Submit") && !csvLine[i].isEmpty())
							{
						     if(lineContent != null)
						     {
							  lineContent.add(csvLine[i]);
						     }
						     else
						     {
						    	 lineContent = new ArrayList();
						    	 lineContent.add(csvLine[i]);
						     }
							}
						}
						
						//System.out.println("line ends");
						if(lineContent != null)
						{
						 csvContent.add(lineContent);
						}
					}
				}
			}
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		
		return csvContent;
		
		
	}
	
	public List<List<String>> parse(String fileName)
	{
		List<List<String>> csvContent = new ArrayList();
		BufferedReader bufferedReader = null;
		String line = "";
		
		try
		{
			bufferedReader = new BufferedReader(new FileReader(fileName));
			
			while((line = bufferedReader.readLine()) != null)
			{
				String[] csvLine = line.split(",");
				
				List<String> lineContent = new ArrayList();
				
				for(int i=0; i< csvLine.length; i++)
				{
					System.out.println(csvLine[i]);
					lineContent.add(csvLine[i]);
				}
				
				
				csvContent.add(lineContent);
			}
			
			System.out.println("line ends");
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		
		return csvContent;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String fileName = "/Users/bhagvan_kommadi/Desktop/BigData/healthcare/Big_Cities_Health_Data_Inventory.csv";
		
		CsvParser csvParser = new CsvParser();
		List<List<String>> content = csvParser.parse(fileName);
		
		int i=0;
		for(List<String> line: content)
		{
			System.out.println("line number "+ i);
			for(String column: line)
			{	
			 System.out.println(column);
			}
			i++;
		}
		
	}

}
