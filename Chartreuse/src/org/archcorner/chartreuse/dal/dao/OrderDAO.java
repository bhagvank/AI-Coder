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

import org.archcorner.chartreuse.pojo.Order;
import org.archcorner.chartreuse.util.JDBCManager;

/**
 * @author bhagvan_kommadi
 *
 */
public class OrderDAO {

	/**
	 * 
	 */
	public OrderDAO() {
		// TODO Auto-generated constructor stub
	}

	
    private String selectAllSQL = "SELECT * FROM CUSTOMERORDER";
    
	private String selectSQL="SELECT * FROM CUSTOMERORDER WHERE ORDERNAME=?";
	
	private String selectIdSQL = "SELECT * FROM CUSTOMERORDER WHERE ORDERID=?";
	
	private String highestIDSQL = "SELECT MAX(ORDERID) AS MAXORDERID FROM CUSTOMERORDER";
	
	private String insertSQL = "INSERT INTO CUSTOMERORDER(ORDERID,CUSTOMERNAME,PRODUCTNAME,PRODUCTMODEL,ORDERDATE,DELIVERYDATE,CONTACTNO) VALUES(?,?,?,?,?,?,?)";
	
	private String updateSQL = "UPDATE CUSTOMERORDER SET CUSTOMERNAME=?,PRODUCTNAME=?,PRODUCTMODEL=?,ORDERDATE=?,DELIVERYDATE=?,CONTACTNO=? WHERE ORDERID=?";
	
	private String deleteSQL = "DELETE FROM CUSTOMERORDER WHERE ORDERID=?";
	
	public void deleteOrder(Order order)
	{
		Connection connection = JDBCManager.getConnection();
		PreparedStatement preparedStatement = null;
		try
		{
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, order.getOrderId());
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
	
	public void insertOrder(Order order)
	{
		Connection connection = JDBCManager.getConnection();
		PreparedStatement preparedStatement = null;
		try
		{
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, getHighestId()+1);
			preparedStatement.setString(2, order.getCustomerName());
			preparedStatement.setString(3, order.getProductName());
			preparedStatement.setString(4, order.getProductModel());
			preparedStatement.setString(5, order.getOrderDate());
			preparedStatement.setString(6, order.getDeliveryDate());
			preparedStatement.setString(7, order.getContactNo());
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
				highestId = resultSet.getInt("MAXORDERID");
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
	public void updateOrder(Order order)
	{
		Connection connection = JDBCManager.getConnection();
		PreparedStatement preparedStatement = null;
		try
		{
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setString(1, order.getCustomerName());
			preparedStatement.setString(2, order.getProductName());
			preparedStatement.setString(3, order.getProductModel());
			preparedStatement.setString(4, order.getOrderDate());
			preparedStatement.setString(5, order.getDeliveryDate());
			preparedStatement.setString(6, order.getContactNo());
			preparedStatement.setInt(7, order.getOrderId());
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
	public Order getOrderById(int orderId)
	{
		Connection connection = JDBCManager.getConnection();
		PreparedStatement preparedStatement = null;
		Order order = null;
		try
		{
			preparedStatement = connection.prepareStatement(selectIdSQL);
			preparedStatement.setInt(1, orderId);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				int id =resultSet.getInt("orderid");
				String customerName = resultSet.getString("customername");
				String productName = resultSet.getString("productname");
				String productModel = resultSet.getString("productmodel");
				String orderDate = resultSet.getString("orderdate");
				String deliveryDate = resultSet.getString("deliverydate");
				String contactNo = resultSet.getString("contactno");
				
				order = new Order();
				order.setOrderId(id);
				order.setCustomerName(customerName);
				order.setProductName(productName);
				order.setProductModel(productModel);
				order.setOrderDate(orderDate);
				order.setDeliveryDate(deliveryDate);
				order.setContactNo(contactNo);
				
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
		
		return order;
	}
	public Order getOrder(String customerName)
	{
		Connection connection = JDBCManager.getConnection();
		PreparedStatement preparedStatement = null;
		
		Order order = null;
		try
		{
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, customerName);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				int id =resultSet.getInt("orderid");
				//String customerName = resultSet.getString("customername");
				String productName = resultSet.getString("productname");
				String productModel = resultSet.getString("productmodel");
				String orderDate = resultSet.getString("orderdate");
				String deliveryDate = resultSet.getString("deliverydate");
				String contactNo = resultSet.getString("contactno");
				
				order = new Order();
				order.setOrderId(id);
				order.setCustomerName(customerName);
				order.setProductName(productName);
				order.setProductModel(productModel);
				order.setOrderDate(orderDate);
				order.setDeliveryDate(deliveryDate);
				order.setContactNo(contactNo);
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
		return order;
	}
	public List<Order> getOrders()
	{
		Connection connection = JDBCManager.getConnection();
		Statement statement = null;
		List<Order> orderList = new ArrayList<Order>();
		try
		{
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(selectAllSQL);
			while(resultSet.next())
			{
				int id =resultSet.getInt("orderid");
				String customerName = resultSet.getString("customername");
				String productName = resultSet.getString("productname");
				String productModel = resultSet.getString("productmodel");
				String orderDate = resultSet.getString("orderdate");
				String deliveryDate = resultSet.getString("deliverydate");
				String contactNo = resultSet.getString("contactno");
				
				Order order = new Order();
				order.setOrderId(id);
				order.setCustomerName(customerName);
				order.setProductName(productName);
				order.setProductModel(productModel);
				order.setOrderDate(orderDate);
				order.setDeliveryDate(deliveryDate);
				order.setContactNo(contactNo);
				
				orderList.add(order);
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
		return orderList;
	}

}
