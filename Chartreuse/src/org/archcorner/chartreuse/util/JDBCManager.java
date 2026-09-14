/**
 * 
 */
package org.archcorner.chartreuse.util;

import java.sql.Connection;
import java.sql.DriverManager;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * @author bhagvan_kommadi
 *
 */
public class JDBCManager {

	private static final String JDBC_MYSQL_URL = "jdbc:mysql://localhost:3306/belfort";
	//private static final String JDBC_MYSQL_URL = "jdbc:mysql://127.10.46.2:3306/belfort";
	private static final String JDBC_DRIVER_CLASS = "com.mysql.jdbc.Driver";
	
	private static final String NO_SQL_HOST= "localhost";
	private static final int PORT = 27017;
	
	public static Connection getConnection()
	{
		Connection connection = null;
		try
		{
			Class.forName(JDBC_DRIVER_CLASS);
		}
		catch(Exception exception)
		{
			
		}
		try
		{
			//String user = "admin5RsCmsi";
			//String password = "Hz6sqv3GhtTA";
			String user = "root";
			String password = "root";
			connection = DriverManager.getConnection(JDBC_MYSQL_URL,user,password);
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		
		return connection;
	}
	
	public static void closeConnection(Connection connection)
	{
		try
		{
			connection.close();
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		
	}
	
	public static MongoClient getNoSqlConnection()
	{
		MongoClient mongoClient = new MongoClient(NO_SQL_HOST,PORT);
		
		return mongoClient;
	}
	
	public static void closeNoSqlConnection(MongoClient mongoClient)
	{
		mongoClient.close();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
        
		
		
		
	}

}
