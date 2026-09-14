/**
 * 
 */
package org.archcorner.chartreuse.dal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.archcorner.chartreuse.pojo.Resource;
import org.archcorner.chartreuse.util.JDBCManager;

/**
 * @author bhagvan_kommadi
 *
 */
public class ResourceDAO {

	/**
	 * 
	 */
	public ResourceDAO() {
		// TODO Auto-generated constructor stub
	}
	

    private String selectAllSQL = "SELECT * FROM RESOURCE";
    
	private String selectSQL="SELECT * FROM RESOURCE WHERE NAME=?";
	
	private String selectIdSQL = "SELECT * FROM RESOURCE WHERE RESOURCEID=?";
	
	private String highestIDSQL = "SELECT MAX(RESOURCEID) AS MAXRESOURCEID FROM RESOURCE";
	
	private String insertSQL = "INSERT INTO RESOURCE(RESOURCEID,NAME,TYPE,STARTDATE) VALUES(?,?,?,?)";
	
	private String updateSQL = "UPDATE RESOURCE SET NAME=?,TYPE=?,STARTDATE=? WHERE RESOURCEID=?";
	
	private String deleteSQL = "DELETE FROM RESOURCE WHERE RESOURCEID=?";
	
	public void deleteResource(Resource resource)
	{
		Connection connection = JDBCManager.getConnection();
		PreparedStatement preparedStatement = null;
		try
		{
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, resource.getResourceId());
			preparedStatement.executeUpdate();
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		finally
		{
			try
			{
				if(preparedStatement != null)
				{
					preparedStatement.close();
				}
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
			JDBCManager.closeConnection(connection);
		}
	}
	
	public void insertResource(Resource resource)
	{
		Connection connection = JDBCManager.getConnection();
		PreparedStatement preparedStatement = null;
		try
		{
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, getHighestId()+1);
			preparedStatement.setString(2, resource.getName());
			preparedStatement.setString(3, resource.getType());
			preparedStatement.setString(4, resource.getStartDate());
			preparedStatement.execute();
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		finally
		{
			try
			{
				if(preparedStatement != null)
				{
					preparedStatement.close();
				}
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
			JDBCManager.closeConnection(connection);
		}
	}
	
	public int getHighestId()
	{
		Connection connection = JDBCManager.getConnection();
		Statement statement = null;
		int highestId=0;
		try
		{
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(highestIDSQL);
			while(resultSet.next())
			{
				highestId = resultSet.getInt("MAXRESOURCEID");
			}
			resultSet.close();
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		finally
		{
			try
			{
				statement.close();
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
			
			JDBCManager.closeConnection(connection);
		
		}
		
		return highestId;
	}
	public void updateResource(Resource resource)
	{
		Connection connection = JDBCManager.getConnection();
		PreparedStatement preparedStatement = null;
		try
		{
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setString(1, resource.getName());
			preparedStatement.setString(2, resource.getType());
			preparedStatement.setString(3, resource.getStartDate());
			preparedStatement.setInt(4, resource.getResourceId());
			preparedStatement.executeUpdate();
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		finally
		{
			try
			{
				if(preparedStatement != null)
				{
					preparedStatement.close();
					
				}
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
			
			JDBCManager.closeConnection(connection);
		}
	}
	public Resource getResourceById(int resourceId)
	{
		Connection connection = JDBCManager.getConnection();
		PreparedStatement preparedStatement = null;
		Resource resource = null;
		try
		{
			preparedStatement = connection.prepareStatement(selectIdSQL);
			preparedStatement.setInt(1, resourceId);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				int id =resultSet.getInt("resourceid");
				String name = resultSet.getString("name");
				String type = resultSet.getString("type");
				String startdate = resultSet.getString("startdate");
				
				
				resource = new Resource();
				resource.setResourceId(id);
				resource.setName(name);
				resource.setType(type);
				resource.setStartDate(startdate);
				
			}
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		finally
		{
			try
			{
				preparedStatement.close();
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
			JDBCManager.closeConnection(connection);
		}
		
		return resource;
	}
	public Resource getResource(String name)
	{
		Connection connection = JDBCManager.getConnection();
		PreparedStatement preparedStatement = null;
		
		Resource resource = null;
		try
		{
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, name);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				int id =resultSet.getInt("resourceid");
				//String name = resultSet.getString("name");
				String type = resultSet.getString("type");
				String startdate = resultSet.getString("startdate");
				
				
				resource = new Resource();
				resource.setResourceId(id);
				resource.setName(name);
				resource.setType(type);
				resource.setStartDate(startdate);
				
			}
			
			resultSet.close();
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		finally
		{
			try
			{
				preparedStatement.close();
				
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
		}
		return resource;
	}
	public List<Resource> getResources()
	{
		Connection connection = JDBCManager.getConnection();
		Statement statement = null;
		List<Resource> resourceList = new ArrayList<Resource>();
		try
		{
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(selectAllSQL);
			while(resultSet.next())
			{
				int id =resultSet.getInt("resourceid");
				String name = resultSet.getString("name");
				String type = resultSet.getString("type");
				String startdate = resultSet.getString("startdate");
				
				
				Resource resource = new Resource();
				resource.setResourceId(id);
				resource.setName(name);
				resource.setType(type);
				resource.setStartDate(startdate);
				
				
				resourceList.add(resource);
			}
			resultSet.close();
			
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		finally
		{
			try
			{
				statement.close();
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
			JDBCManager.closeConnection(connection);
		}
		return resourceList;
	}


}
