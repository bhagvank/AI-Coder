/**
 * 
 */
package com.architectcorner.ai.platform.businessdelegate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.architectcorner.ai.machinelearning.dataservices.NoSqlMapper;
import com.architectcorner.ai.platform.util.JDBCManager;
import com.mongodb.MongoClient;
/**
 * @author bhagvan.kommadi
 *
 */
public class BigDataDelegate {

	
	public void insertRecord(String database, String collection,Map<String,String> record)
	{
       MongoClient mongoClient = JDBCManager.getNoSqlConnection();
		
		NoSqlMapper mapper = new NoSqlMapper();
		mapper.setMongoClient(mongoClient);
		mapper.insertRecord(database, collection, record);
		mongoClient.close();
	}
	public void updateRecord(String database,String collection, Map<String,String> filters,Map<String,String> newValues)
	{
       MongoClient mongoClient = JDBCManager.getNoSqlConnection();
		
		NoSqlMapper mapper = new NoSqlMapper();
		mapper.setMongoClient(mongoClient);
		mapper.updateRecord(database, collection, filters, newValues);
		
		mongoClient.close();
	}
	
	public List<Map<String,String>> getRecord(String database, String collection,Map<String,String> fieldValues,List<String> fields)
	{
       MongoClient mongoClient = JDBCManager.getNoSqlConnection();
		
		NoSqlMapper mapper = new NoSqlMapper();
		mapper.setMongoClient(mongoClient);
		List<Map<String,String>> records = mapper.getQueryRecords(database, collection, fieldValues, fields);
		mongoClient.close();
		
		return records;
	}
	public List<Map<String,String>> getRecords(String database,String collection,List<String> fields)
	{
		 MongoClient mongoClient = JDBCManager.getNoSqlConnection();
			
			NoSqlMapper mapper = new NoSqlMapper();
			mapper.setMongoClient(mongoClient);
			List<Map<String,String>> records = mapper.getRecords(database, collection,fields);
			
			mongoClient.close();
			
			return records;
	}
	public void storeData(String database,List<List<String>> data, List<String> header,String fileName)
	{
        MongoClient mongoClient = JDBCManager.getNoSqlConnection();
		
		//MongoDatabase db =  mongoClient.getDatabase("CustomerChurn");
		
		NoSqlMapper mapper = new NoSqlMapper();
		mapper.setMongoClient(mongoClient);
		
		
		String collection = fileName;
		
		
		
		for(int j=1; j< data.size(); j++ )
		{
			List<String> row = data.get(j);
			
			Map<String,String> record = new HashMap();
			
			for(int i=0; i< header.size(); i++)
			{
				record.put(header.get(i), row.get(i));
				
			}
			mapper.insertRecord(database, collection, record);
		}
		//record.put("name", "Tom Hardy");
		//record.put("id", "23456");
		//record.put("zipcode", value)
		mongoClient.close();
		
		
	}
	public void deleteRecord(String database,String collection, String expression,String rhsValue,String field)
	{
        MongoClient mongoClient = JDBCManager.getNoSqlConnection();
		
		NoSqlMapper mapper = new NoSqlMapper();
		mapper.setMongoClient(mongoClient);
		mapper.deleteRecord(database, collection, expression, rhsValue, field);
		
		mongoClient.close();
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BigDataDelegate bigDataDelegate = new BigDataDelegate();
		
		//bigDataDelegate.storeData(data, header, fileName);
	}

}
