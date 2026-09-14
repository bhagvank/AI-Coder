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

import org.archcorner.chartreuse.pojo.Customer;
import org.archcorner.chartreuse.util.JDBCManager;

/**
 * @author bhagvan_kommadi
 *
 */
public class CustomerDAO {

	/**
	 * 
	 */
	public CustomerDAO() {
		// TODO Auto-generated constructor stub
	}

	
    private String selectAllSQL = "SELECT * FROM CUSTOMER";
    
	private String selectSQL="SELECT * FROM CUSTOMER WHERE CUSTOMERNAME=?";
	
	private String selectIdSQL = "SELECT * FROM CUSTOMER WHERE CUSTOMERID=?";
	
	private String highestIDSQL = "SELECT MAX(CUSTOMERID) AS MAXCUSTOMERID FROM CUSTOMER";
	
	private String insertSQL = "INSERT INTO CUSTOMER(CUSTOMERID,CUSTOMERNAME,STREETADDRESS,STATE,COUNTRY,ZIPCODE,CONTACTNO,CITY) VALUES(?,?,?,?,?,?,?,?)";
	
	private String updateSQL = "UPDATE CUSTOMER SET CUSTOMERNAME=?,STREETADDRESS=?,STATE=?,COUNTRY=?,ZIPCODE=?,CONTACTNO=?,CITY=? WHERE CUSTOMERID=?";
	
	private String deleteSQL = "DELETE FROM CUSTOMER WHERE CUSTOMERID=?";
	
	public void deleteCustomer(Customer customer)
	{
		Connection connection = JDBCManager.getConnection();
		PreparedStatement preparedStatement = null;
		try
		{
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, customer.getCustomerId());
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
	
	public void insertCustomer(Customer customer)
	{
		Connection connection = JDBCManager.getConnection();
		PreparedStatement preparedStatement = null;
		try
		{
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, getHighestId()+1);
			preparedStatement.setString(2, customer.getCustomerName());
			preparedStatement.setString(3, customer.getStreetAddress());
			preparedStatement.setString(4, customer.getState());
			preparedStatement.setString(5, customer.getCountry());
			preparedStatement.setString(6, customer.getZipCode());
			preparedStatement.setString(7, customer.getContactNo());
			preparedStatement.setString(8, customer.getCity());
			
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
				highestId = resultSet.getInt("MAXCUSTOMERID");
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
	public void updateCustomer(Customer customer)
	{
		Connection connection = JDBCManager.getConnection();
		PreparedStatement preparedStatement = null;
		try
		{
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setString(1, customer.getCustomerName());
			preparedStatement.setString(2, customer.getStreetAddress());
			preparedStatement.setString(3, customer.getState());
			preparedStatement.setString(4, customer.getCountry());
			preparedStatement.setString(5, customer.getZipCode());
			preparedStatement.setString(6, customer.getContactNo());
			preparedStatement.setString(7, customer.getCity());
			preparedStatement.setInt(8, customer.getCustomerId());
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
	public Customer getCustomerById(int customerId)
	{
		Connection connection = JDBCManager.getConnection();
		PreparedStatement preparedStatement = null;
		Customer customer = null;
		try
		{
			preparedStatement = connection.prepareStatement(selectIdSQL);
			preparedStatement.setInt(1, customerId);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				int id =resultSet.getInt("customerid");
				String customerName = resultSet.getString("customername");
				String streetAddress = resultSet.getString("streetaddress");
				String city = resultSet.getString("city");
				String state = resultSet.getString("state");
				String country = resultSet.getString("country");
				String zipCode = resultSet.getString("zipcode");
				String contactNo = resultSet.getString("contactno");
				
				customer = new Customer();
				customer.setCustomerId(id);
				customer.setCustomerName(customerName);
				customer.setStreetAddress(streetAddress);
				customer.setCity(city);
				customer.setState(state);
				customer.setCountry(country);
				customer.setZipCode(zipCode);
				customer.setContactNo(contactNo);
				
				
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
		
		return customer;
	}
	public Customer getCustomer(String customerName)
	{
		Connection connection = JDBCManager.getConnection();
		PreparedStatement preparedStatement = null;
		
		Customer customer = null;
		try
		{
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, customerName);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				int id =resultSet.getInt("customerid");
				String streetAddress = resultSet.getString("streetaddress");
				String city = resultSet.getString("city");
				String state = resultSet.getString("state");
				String country = resultSet.getString("country");
				String zipCode = resultSet.getString("zipcode");
				String contactNo = resultSet.getString("contactno");
				
				customer = new Customer();
				customer.setCustomerId(id);
				customer.setCustomerName(customerName);
				customer.setStreetAddress(streetAddress);
				customer.setCity(city);
				customer.setState(state);
				customer.setCountry(country);
				customer.setZipCode(zipCode);
				customer.setContactNo(contactNo);
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
		return customer;
	}
	public List<Customer> getCustomers()
	{
		Connection connection = JDBCManager.getConnection();
		Statement statement = null;
		List<Customer> customerList = new ArrayList<Customer>();
		try
		{
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(selectAllSQL);
			while(resultSet.next())
			{
				int id =resultSet.getInt("customerid");
				String customerName = resultSet.getString("customername");
				String streetAddress = resultSet.getString("streetaddress");
				String city = resultSet.getString("city");
				String state = resultSet.getString("state");
				String country = resultSet.getString("country");
				String zipCode = resultSet.getString("zipcode");
				String contactNo = resultSet.getString("contactno");
				
				Customer customer = new Customer();
				customer.setCustomerId(id);
				customer.setCustomerName(customerName);
				customer.setStreetAddress(streetAddress);
				customer.setCity(city);
				customer.setState(state);
				customer.setCountry(country);
				customer.setZipCode(zipCode);
				customer.setContactNo(contactNo);
				
				customerList.add(customer);
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
		return customerList;
	}

}
