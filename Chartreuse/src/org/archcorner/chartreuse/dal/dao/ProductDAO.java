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

import org.archcorner.chartreuse.pojo.Product;
import org.archcorner.chartreuse.util.JDBCManager;

/**
 * @author bhagvan_kommadi
 *
 */
public class ProductDAO {

	
    private String selectAllSQL = "SELECT * FROM PRODUCT";
    
	private String selectSQL="SELECT * FROM PRODUCT WHERE PRODUCTNAME=?";
	
	private String selectIdSQL = "SELECT * FROM PRODUCT WHERE PRODUCTID=?";
	
	private String highestIDSQL = "SELECT MAX(PRODUCTID) AS MAXPRODUCTID FROM PRODUCT";
	
	private String insertSQL = "INSERT INTO PRODUCT(PRODUCTID,PRODUCTNAME,PRODUCTMODEL,DESCRIPTION) VALUES(?,?,?,?)";
	
	private String updateSQL = "UPDATE PRODUCT SET PRODUCTNAME=?,PRODUCTMODEL=?,DESCRIPTION=? WHERE PRODUCTID=?";
	
	private String deleteSQL = "DELETE FROM PRODUCT WHERE PRODUCTID=?";
	
	public void deleteProduct(Product product)
	{
		Connection connection = JDBCManager.getConnection();
		PreparedStatement preparedStatement = null;
		try
		{
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, product.getProductId());
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
	
	public void insertProduct(Product product)
	{
		Connection connection = JDBCManager.getConnection();
		PreparedStatement preparedStatement = null;
		try
		{
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, getHighestId()+1);
			preparedStatement.setString(2, product.getProductName());
			preparedStatement.setString(3, product.getProductModel());
			preparedStatement.setString(4, product.getDescription());
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
				highestId = resultSet.getInt("MAXPRODUCTID");
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
	public void updateProduct(Product product)
	{
		Connection connection = JDBCManager.getConnection();
		PreparedStatement preparedStatement = null;
		try
		{
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setString(1, product.getProductName());
			preparedStatement.setString(2, product.getProductModel());
			preparedStatement.setString(3, product.getDescription());
			preparedStatement.setInt(4, product.getProductId());
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
	public Product getProductById(int productId)
	{
		Connection connection = JDBCManager.getConnection();
		PreparedStatement preparedStatement = null;
		Product product = null;
		try
		{
			preparedStatement = connection.prepareStatement(selectIdSQL);
			preparedStatement.setInt(1, productId);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				int id =resultSet.getInt("productid");
				String productName = resultSet.getString("productname");
				String productModel = resultSet.getString("productmodel");
				String description = resultSet.getString("description");
				
				
				product = new Product();
				product.setProductId(id);
				product.setProductName(productName);
				product.setProductModel(productModel);
				product.setDescription(description);
				
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
		
		return product;
	}
	public Product getProduct(String productName)
	{
		Connection connection = JDBCManager.getConnection();
		PreparedStatement preparedStatement = null;
		
		Product product = null;
		try
		{
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, productName);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				int id =resultSet.getInt("productid");
				//String productName = resultSet.getString("productname");
				String productModel = resultSet.getString("productmodel");
				String description = resultSet.getString("description");
				
				
				product = new Product();
				product.setProductId(id);
				product.setProductName(productName);
				product.setProductModel(productModel);
				product.setDescription(description);
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
		return product;
	}
	public List<Product> getProducts()
	{
		Connection connection = JDBCManager.getConnection();
		Statement statement = null;
		List<Product> productList = new ArrayList<Product>();
		try
		{
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(selectAllSQL);
			while(resultSet.next())
			{
				int id =resultSet.getInt("productid");
				String productName = resultSet.getString("productname");
				String productModel = resultSet.getString("productmodel");
				String description = resultSet.getString("description");
				
				
				Product product = new Product();
				product.setProductId(id);
				product.setProductName(productName);
				product.setProductModel(productModel);
				product.setDescription(description);
				
				productList.add(product);
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
		return productList;
	}

}
