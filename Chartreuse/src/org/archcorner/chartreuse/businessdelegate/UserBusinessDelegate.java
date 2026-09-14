/**
 * 
 */
package org.archcorner.chartreuse.businessdelegate;

import java.util.List;

import org.archcorner.chartreuse.dal.dao.UserDAO;
import org.archcorner.chartreuse.pojo.User;

/**
 * @author bhagvan_kommadi
 *
 */
public class UserBusinessDelegate {

	/**
	 * 
	 */
	public UserBusinessDelegate() {
		// TODO Auto-generated constructor stub
	}

	public void insertUser(User user)
	{
		UserDAO userDAO = new UserDAO();
		userDAO.insertUser(user);
	}
	
	public void updateUser(User user)
	{
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
	
	public List<User> getAll()
	{
		UserDAO userDAO = new UserDAO();
		return userDAO.getUsers();
	}
	
	public void deleteUser(User user)
	{
		UserDAO userDAO = new UserDAO();
		userDAO.deleteUser(user);
	}
	
	public int getHighestId()
	{
		UserDAO userDAO = new UserDAO();
		return userDAO.getHighestId();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		UserBusinessDelegate businessDelegate = new UserBusinessDelegate();
		System.out.println(businessDelegate.getHighestId());
	}

}
