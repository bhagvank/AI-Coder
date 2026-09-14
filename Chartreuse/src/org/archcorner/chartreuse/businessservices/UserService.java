/**
 * 
 */
package org.archcorner.chartreuse.businessservices;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;

import org.archcorner.chartreuse.dal.dao.UserDAO;
import org.archcorner.chartreuse.pojo.User;

/**
 * @author bhagvan_kommadi
 *
 */
public class UserService {

	/**
	 * 
	 */
	public UserService() {
		// TODO Auto-generated constructor stub
	}

	

	public void insertUser(String userProperties)
	{
		StringTokenizer stringTokenizer = new StringTokenizer(userProperties,"@@");
		
		User user = new User();
		//user.setUserId(Integer.parseInt(stringTokenizer.nextToken()));
		user.setUserName(stringTokenizer.nextToken());
		user.setPassword(stringTokenizer.nextToken());
		
		UserDAO userDAO = new UserDAO();
		userDAO.insertUser(user);
	}
	
	public void updateUser(String userProperties)
	{
		StringTokenizer stringTokenizer = new StringTokenizer(userProperties,"@@");
		
		User user = new User();
		user.setUserId(Integer.parseInt(stringTokenizer.nextToken()));
		user.setUserName(stringTokenizer.nextToken());
		user.setPassword(stringTokenizer.nextToken());
		UserDAO userDAO = new UserDAO();
		userDAO.updateUser(user);
	}
	
	public User getUserById(int userId)
	{
		UserDAO userDAO = new UserDAO();
		 return userDAO.getUserById(userId);
	}
	public User getUser(String userName)
	{
		UserDAO userDAO = new UserDAO();
		return userDAO.getUser(userName);
	}
	
	public User[] getAll()
	{
		UserDAO userDAO = new UserDAO();
		
		List<User> userList = userDAO.getUsers();
		 
		User[] users = new User[userList.size()];
		return userList.toArray(users);
	}
	
	public void deleteUser(String userProperties)
	{
		StringTokenizer stringTokenizer = new StringTokenizer(userProperties, "@@");
		User user = new User();
		user.setUserId(Integer.parseInt(stringTokenizer.nextToken()));
		user.setUserName(stringTokenizer.nextToken());
		user.setPassword(stringTokenizer.nextToken());
		UserDAO userDAO = new UserDAO();
		userDAO.deleteUser(user);
	}
	
	public int getHighestId()
	{
		UserDAO userDAO = new UserDAO();
		return userDAO.getHighestId();
	}
}
