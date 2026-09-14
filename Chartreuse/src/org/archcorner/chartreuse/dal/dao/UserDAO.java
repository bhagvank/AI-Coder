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

import org.archcorner.chartreuse.pojo.User;
import org.archcorner.chartreuse.util.JDBCManager;

/**
 * @author bhagvan_kommadi
 *
 */
public class UserDAO 
{
	
    private String selectAllSQL = "SELECT * FROM USER";
    
	private String selectSQL="SELECT * FROM USER WHERE USERNAME=?";
	
	private String selectIdSQL = "SELECT * FROM USER WHERE USERID=?";
	
	private String highestIDSQL = "SELECT MAX(USERID) AS MAXUSERID FROM USER";
	
	private String insertSQL = "INSERT INTO USER(USERID,USERNAME,PASSWORD) VALUES(?,?,?)";
	
	private String updateSQL = "UPDATE USER SET USERNAME=?,PASSWORD=? WHERE USERID=?";
	
	private String deleteSQL = "DELETE FROM USER WHERE USERID=?";
	
	public void deleteUser(User user)
	{
		Connection connection = JDBCManager.getConnection();
		PreparedStatement preparedStatement = null;
		try
		{
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, user.getUserId());
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
	
	public void insertUser(User user)
	{
		Connection connection = JDBCManager.getConnection();
		PreparedStatement preparedStatement = null;
		try
		{
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, getHighestId()+1);
			preparedStatement.setString(2, user.getUserName());
			preparedStatement.setString(3, user.getPassword());
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
				highestId = resultSet.getInt("MAXUSERID");
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
	public void updateUser(User user)
	{
		Connection connection = JDBCManager.getConnection();
		PreparedStatement preparedStatement = null;
		try
		{
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setInt(3, user.getUserId());
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
	public User getUserById(int userId)
	{
		Connection connection = JDBCManager.getConnection();
		PreparedStatement preparedStatement = null;
		User user = null;
		try
		{
			preparedStatement = connection.prepareStatement(selectIdSQL);
			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				int id =resultSet.getInt("userid");
				String userName = resultSet.getString("username");
				String password = resultSet.getString("password");
				user = new User();
				user.setUserId(id);
				user.setUserName(userName);
				user.setPassword(password);
				
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
		
		return user;
	}
	public User getUser(String username)
	{
		Connection connection = JDBCManager.getConnection();
		PreparedStatement preparedStatement = null;
		
		User user = null;
		try
		{
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, username);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				int userId = resultSet.getInt("userid");
				String userName = resultSet.getString("username");
				String password = resultSet.getString("password");
				
				user = new User();
				user.setUserId(userId);
				user.setUserName(userName);
				user.setPassword(password);
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
		return user;
	}
	public List<User> getUsers()
	{
		Connection connection = JDBCManager.getConnection();
		Statement statement = null;
		List<User> userList = new ArrayList<User>();
		try
		{
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(selectAllSQL);
			while(resultSet.next())
			{
				int userId = resultSet.getInt("USERID");
				String userName = resultSet.getString("USERNAME");
				String password = resultSet.getString("PASSWORD");
				
				User user = new User();
				user.setUserId(userId);
				user.setUserName(userName);
				user.setPassword(password);
				
				userList.add(user);
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
		return userList;
	}
	
	
   public static void main(String[] args)
   {
	   UserDAO userDAO = new UserDAO();
	   User user = userDAO.getUser("telecom");
	   System.out.println(user.getUserId());
	   System.out.println(user.getPassword());
	   
	   System.out.println(userDAO.getHighestId());
	   
	   User newuser = new User();
	   newuser.setUserId(userDAO.getHighestId()+1);
	   newuser.setUserName("manager");
	   newuser.setPassword("manager");
	   
	   userDAO.insertUser(newuser);

	   User manager = userDAO.getUser("manager");
	   System.out.println(manager.getUserId());
	   
	   newuser.setPassword("telecom");
	   
	   userDAO.updateUser(newuser);
	   
	   User updatedUser = userDAO.getUser("manager");
	   System.out.println(updatedUser.getPassword());
	   
	   userDAO.deleteUser(updatedUser);
	   
	   System.out.println(userDAO.getHighestId());
	   
	   List<User> userList = userDAO.getUsers();
	   for(User luser: userList)
	   {
		   System.out.println(luser.getUserId());
		   System.out.println(luser.getUserName());
		   System.out.println(luser.getPassword());
	   }
   }
}
