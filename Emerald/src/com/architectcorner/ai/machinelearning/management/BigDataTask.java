package com.architectcorner.ai.machinelearning.management;

import java.util.List;

import com.architectcorner.ai.platform.esb.CsvParser;

public class BigDataTask implements ITask{

	public BigDataTask() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<List<String>> getTaskInput() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTaskInput(List<List<String>> taskInput) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void perform() {
		// TODO Auto-generated method stub
String fileName = "/Users/bhagvan_kommadi/Desktop/BigData/airlines/airmiles.csv";
		
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
