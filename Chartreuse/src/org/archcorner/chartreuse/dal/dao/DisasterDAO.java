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

import org.archcorner.chartreuse.pojo.Disaster;
import org.archcorner.chartreuse.util.JDBCManager;

/**
 * @author bhagvan_kommadi
 *
 */
public class DisasterDAO 
{

	
    private String selectAllSQL = "SELECT * FROM DISASTER";
    
	private String selectSQL="SELECT * FROM DISASTER WHERE DISASTERNAME=?";
	
	private String selectIdSQL = "SELECT * FROM DISASTER WHERE DISASTERID=?";
	
	private String highestIDSQL = "SELECT MAX(DISASTERID) AS MAXDISASTERID FROM DISASTER";
	
	private String insertSQL = "INSERT INTO DISASTER(DISASTERID,DISASTERNAME,LOCATIONNAME,EVENTDESCRIPTION,CONTACTNO,REPORTERNAME) VALUES(?,?,?,?,?,?)";
	
	private String updateSQL = "UPDATE DISASTER SET DISASTERNAME=?,LOCATIONNAME=?,EVENTDESCRIPTION=?,CONTACTNO=?,REPORTERNAME=? WHERE DISASTERID=?";
	
	private String deleteSQL = "DELETE FROM DISASTER WHERE DISASTERID=?";
	
	public void deleteDisaster(Disaster disaster)
	{
		Connection connection = JDBCManager.getConnection();
		PreparedStatement preparedStatement = null;
		try
		{
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, disaster.getDisasterId());
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
	
	public void insertDisaster(Disaster disaster)
	{
		Connection connection = JDBCManager.getConnection();
		PreparedStatement preparedStatement = null;
		try
		{
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, getHighestId()+1);
			preparedStatement.setString(2, disaster.getDisasterName());
			preparedStatement.setString(3, disaster.getLocationName());
			preparedStatement.setString(4, disaster.getEventDescription());
			preparedStatement.setString(5, disaster.getContactNo());
			preparedStatement.setString(6, disaster.getReporterName());
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
				highestId = resultSet.getInt("MAXDISASTERID");
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
	public void updateDisaster(Disaster disaster)
	{
		Connection connection = JDBCManager.getConnection();
		PreparedStatement preparedStatement = null;
		try
		{
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setString(1, disaster.getDisasterName());
			preparedStatement.setString(2, disaster.getLocationName());
			preparedStatement.setString(3, disaster.getEventDescription());
			preparedStatement.setString(4, disaster.getContactNo());
			preparedStatement.setString(5, disaster.getReporterName());
			preparedStatement.setInt(6, disaster.getDisasterId());
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
	public Disaster getDisasterById(int disasterId)
	{
		Connection connection = JDBCManager.getConnection();
		PreparedStatement preparedStatement = null;
		Disaster disaster = null;
		try
		{
			preparedStatement = connection.prepareStatement(selectIdSQL);
			preparedStatement.setInt(1, disasterId);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				int id =resultSet.getInt("disasterid");
				String disasterName = resultSet.getString("disastername");
				String locationName = resultSet.getString("locationname");
				String eventDescription = resultSet.getString("eventdescription");
				String contactNo = resultSet.getString("contactno");
				String reporterName = resultSet.getString("reporterName");
				
				disaster = new Disaster();
				disaster.setDisasterId(id);
				disaster.setDisasterName(disasterName);
				disaster.setLocationName(locationName);
				disaster.setEventDescription(eventDescription);
				disaster.setContactNo(contactNo);
				disaster.setReporterName(reporterName);
				
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
		
		return disaster;
	}
	public Disaster getDisaster(String disasterName)
	{
		Connection connection = JDBCManager.getConnection();
		PreparedStatement preparedStatement = null;
		
		Disaster disaster = null;
		try
		{
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, disasterName);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				int id =resultSet.getInt("disasterid");
				//disasterName = resultSet.getString("disastername");
				String locationName = resultSet.getString("locationname");
				String eventDescription = resultSet.getString("eventdescription");
				String contactNo = resultSet.getString("contactno");
				String reporterName = resultSet.getString("reporterName");
				
				disaster = new Disaster();
				disaster.setDisasterId(id);
				disaster.setDisasterName(disasterName);
				disaster.setLocationName(locationName);
				disaster.setEventDescription(eventDescription);
				disaster.setContactNo(contactNo);
				disaster.setReporterName(reporterName);
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
		return disaster;
	}
	public List<Disaster> getDisasters()
	{
		Connection connection = JDBCManager.getConnection();
		Statement statement = null;
		List<Disaster> disasterList = new ArrayList<Disaster>();
		try
		{
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(selectAllSQL);
			while(resultSet.next())
			{
				int id =resultSet.getInt("disasterid");
				String disasterName = resultSet.getString("disastername");
				String locationName = resultSet.getString("locationname");
				String eventDescription = resultSet.getString("eventdescription");
				String contactNo = resultSet.getString("contactno");
				String reporterName = resultSet.getString("reporterName");
				
				Disaster disaster = new Disaster();
				disaster.setDisasterId(id);
				disaster.setDisasterName(disasterName);
				disaster.setLocationName(locationName);
				disaster.setEventDescription(eventDescription);
				disaster.setContactNo(contactNo);
				disaster.setReporterName(reporterName);
				
				disasterList.add(disaster);
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
		return disasterList;
	}
}
