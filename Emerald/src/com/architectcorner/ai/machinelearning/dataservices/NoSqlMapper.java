/**
 * 
 */
package com.architectcorner.ai.machinelearning.dataservices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.architectcorner.ai.platform.util.JDBCManager;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

/**
 * @author bhagvan.kommadi
 *
 */
public class NoSqlMapper {

	private MongoClient mongoClient;
	
	/**
	 * @return the mongoClient
	 */
	public MongoClient getMongoClient() {
		return mongoClient;
	}
	/**
	 * @param mongoClient the mongoClient to set
	 */
	public void setMongoClient(MongoClient mongoClient) {
		this.mongoClient = mongoClient;
	}
	public List<Map<String,String>> getQueryRecords(String database,String collection,Map<String,String> whereQuery,List<String> fields)
	{
		List<Map<String,String>> results = new ArrayList();
		MongoDatabase db =  mongoClient.getDatabase(database);
		MongoCollection dbCollection  = db.getCollection(collection);
		
		BasicDBObject query = new BasicDBObject();
		Iterator<String> keyIterator = whereQuery.keySet().iterator();
		
		while(keyIterator.hasNext())
		{
			String key = keyIterator.next();
			String value = whereQuery.get(key);
			
			if(key.contentEquals("_id"))
			{
				
				ObjectId oid = new ObjectId(value);
				query.put(key, oid);
			}
			else
			{	
		       query.put(key, value);
			}
		}
		//System.out.println(query);
		FindIterable<Document> records = dbCollection.find(query);
		
        MongoCursor<Document> cursor = records.iterator();
        
        try
        {
        	while(cursor.hasNext())
        	{
        		Document document = cursor.next();
        		
        		Set<String> keySet = document.keySet();
        		
        		
        		Iterator<String> keys = keySet.iterator();
        		
        		Map<String,String> record = new HashMap();
        		
        		while(keys.hasNext())
        		{
        			Object key = keys.next();
        			
        			if(fields.contains(key.toString()))
        			{
        			 Object value = document.get(key);
        			
        			// System.out.println("key="+key+" value="+value);
        			
        		    record.put(key.toString(), value.toString());
        			}
        			
        		}
        		
        		results.add(record);
        	}
        }
        finally
        {
        	cursor.close();
        }
        
        return results;
	}
	public List<Map<String,String>> getRecords(String database,String collection,List<String> fields)
	{
		List<Map<String,String>> results = new ArrayList();
		MongoDatabase db =  mongoClient.getDatabase(database);
		MongoCollection dbCollection  = db.getCollection(collection);
		
		FindIterable<Document> records = dbCollection.find();
		
        MongoCursor<Document> cursor = records.iterator();
        
        try
        {
        	while(cursor.hasNext())
        	{
        		Document document = cursor.next();
        		
        		Set<String> keySet = document.keySet();
        		
        		
        		Iterator<String> keys = keySet.iterator();
        		
        		Map<String,String> record = new HashMap();
        		
        		while(keys.hasNext())
        		{
        			Object key = keys.next();
        			
        			if(fields.contains(key.toString()))
        			{
        			 Object value = document.get(key);
        			
        			//System.out.println("key="+key+" value="+value);
        			
        		    record.put(key.toString(), value.toString());
        			}
        			
        		}
        		
        		results.add(record);
        	}
        }
        finally
        {
        	cursor.close();
        }
        
        return results;
	}
	public List<Map<String,String>> getRecordsFromMultipleCollection(String database,List<String> collection)
	{
		List<Map<String,String>> records = new ArrayList();
		//MongoCollection dbCollection  = db.getCollection("Customer");
		
		return records;
	}
	 
	public void updateRecord(String database,String collection, Map<String,String> filters,Map<String,String> newValues)
	{
		MongoDatabase db =  mongoClient.getDatabase(database);
		
        MongoCollection dbCollection  = db.getCollection(collection);
        
       
        Document document = null;
        
       Set<String> keySet = filters.keySet();
		
		Iterator<String> iterator = keySet.iterator();
		
		int i=0;
		while(iterator.hasNext())
		{
			String key = iterator.next();
			//System.out.println(key);
			//System.out.println(filters.get(key));
			String value = filters.get(key);
		
			if(i==0)
			{
				if(key.contentEquals("_id"))
				{
					
					ObjectId oid = new ObjectId(value);
					document = new Document(key,oid);
				}
				else
				{
			        document = new Document(key,value);	
				}
			}
			else
			{
				if(key.contentEquals("_id"))
				{
					
					ObjectId oid = new ObjectId(value);
	    		document.append(key, oid);
				}
				else
				{
					document.append(key, value);
				}
			}
			i++;
		}
		  Bson filter = document;
		
		  Document newDocument = null;
	        
	       Set<String> newKeySet = newValues.keySet();
			
			Iterator<String> newIterator = newKeySet.iterator();
			
			int j=0;
			while(newIterator.hasNext())
			{
				String key = newIterator.next();
				
				System.out.println(key);
				System.out.println(newValues.get(key));
				
				if(j == 0)
				{
					newDocument = new Document(key,newValues.get(key));
				}
				else
				{
				  newDocument.append(key, newValues.get(key));
				}
				j++;
			}
		  Bson newValue = newDocument;
		  
		  Bson updateOperationDocument = new Document("$set", newValue);
		  System.out.println(filter);
		  System.out.println(updateOperationDocument);
		
		  
		  dbCollection.updateMany(filter, updateOperationDocument);

	}
	public void deleteRecord(String database,String collection, String expression,String rhsValue,String field)
	{
		MongoDatabase db =  mongoClient.getDatabase(database);
		
        MongoCollection dbCollection  = db.getCollection(collection);
        
        
        Bson condition;
        
        if(field.contentEquals("_id"))
		{
			
			ObjectId oid = new ObjectId(rhsValue);
			condition = new Document(expression,oid);
		}
		else
		{
	        condition = new Document(expression,rhsValue);	
		}
       
		//  Bson condition = new Document(expression,rhsValue);
		
		  
		  Bson filter = new Document(field,condition);
		  
		  System.out.println(filter);
		
		  dbCollection.deleteMany(filter);

	}
	public void insertRecord(String database,String collection, Map<String,String> record)
	{
		MongoDatabase db =  mongoClient.getDatabase(database);
		
        MongoCollection dbCollection  = db.getCollection(collection);
        
		Document document = new Document(collection, database);
				
		Set<String> keySet = record.keySet();
		
		Iterator<String> iterator = keySet.iterator();
		
		while(iterator.hasNext())
		{
			String key = iterator.next();
			
			document.append(key, record.get(key));

		}
		dbCollection.insertOne(document);
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        MongoClient mongoClient = JDBCManager.getNoSqlConnection();
		
		//MongoDatabase db =  mongoClient.getDatabase("CustomerChurn");
		
		NoSqlMapper mapper = new NoSqlMapper();
		mapper.setMongoClient(mongoClient);
		
		
		String database = "CustomerChurn";
		String collection = "Customer";
		
		List<String> fields = new ArrayList<String>();
		fields.add("name");
		fields.add("id");
		
		List<Map<String,String>> results = mapper.getRecords(database, collection,fields);
		
		
		for(Map<String,String> map: results)
		{
			Set<String> keys = map.keySet();
			Iterator<String> iterator = keys.iterator();
			
			while(iterator.hasNext())
			{
				String key = iterator.next();
				System.out.println(key+" value= "+map.get(key));
			}
		}
		
		
		Map<String,String> record = new HashMap();
		record.put("name", "Tom Hardy");
		record.put("id", "23456");
		//record.put("zipcode", value)
		
		mapper.insertRecord(database, collection, record);
		
		 results = mapper.getRecords(database, collection,fields);
		 
		 
		 Map<String,String> filter = new HashMap();
		 filter.put("id", "23456");
		 
		 Map<String,String> newValue = new HashMap();
		 newValue.put("name", "Thomas Hardy");
		 
		 mapper.updateRecord(database, collection, filter, newValue);
		 //mapper.deleteRecord(database, collection, "$eq", "23456", "id");
		 results = mapper.getRecords(database, collection,fields);
			
			
			for(Map<String,String> map: results)
			{
				Set<String> keys = map.keySet();
				Iterator<String> iterator = keys.iterator();
				
				while(iterator.hasNext())
				{
					String key = iterator.next();
					System.out.println(key+" value= "+map.get(key));
				}
			}
		 
		mongoClient.close();
	}

}
