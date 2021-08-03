package org.aicoder.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Product;
import org.archcorner.chartreuse.util.JDBCManager;

public class ProductDAO{ 


private String highestIDSQL = "SELECT MAX(PRODUCTID) AS MAXPRODUCTID FROM PRODUCT";
private String selectSQL = "SELECT * FROM PRODUCT WHERE PRODUCTNAME=?";
private String selectIdSQL = "SELECT * FROM PRODUCT WHERE PRODUCTID=?";
private String insertSQL = "INSERT INTO PRODUCT(PRODUCTID,PRODUCTNAME,PRODUCTADDRESS,PRODUCTCITY,PRODUCTSTATE,PRODUCTCOUNTRY,PRODUCTZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE PRODUCT SET PRODUCTNAME=?,PRODUCTADDRESS=?,PRODUCTCITY=?,PRODUCTSTATE=?,PRODUCTCOUNTRY=?,PRODUCTZIPCODE=? WHERE PRODUCTID=?";
private String deleteSQL = "DELETE FROM PRODUCT WHERE PRODUCTID=?";
private String selectAllSQL = "SELECT * FROM PRODUCT";

public int getHighestId(){
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

public Product getProductById(int productid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Product product = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, productid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("productid");
      String productname = resultSet.getString("PRODUCTNAME");
      String productaddress = resultSet.getString("PRODUCTADDRESS");
      String productcity = resultSet.getString("PRODUCTCITY");
      String productstate = resultSet.getString("PRODUCTSTATE");
      String productcountry = resultSet.getString("PRODUCTCOUNTRY");
      String productzipcode = resultSet.getString("PRODUCTZIPCODE");
      product = new Product();
      product.setProductId(id);
      product.setProductName(productname);
      product.setProductAddress(productaddress);
      product.setProductCity(productcity);
      product.setProductState(productstate);
      product.setProductCountry(productcountry);
      product.setProductZipCode(productzipcode);
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

public Product getProduct(String productname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Product product = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, productname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("ProductId");
      productname = resultSet.getString("PRODUCTNAME");
      String productaddress = resultSet.getString("PRODUCTADDRESS");
      String productcity = resultSet.getString("PRODUCTCITY");
      String productstate = resultSet.getString("PRODUCTSTATE");
      String productcountry = resultSet.getString("PRODUCTCOUNTRY");
      String productzipcode = resultSet.getString("PRODUCTZIPCODE");
      product = new Product();
      product.setProductId(id);
      product.setProductName(productname);
      product.setProductAddress(productaddress);
      product.setProductCity(productcity);
      product.setProductState(productstate);
      product.setProductCountry(productcountry);
      product.setProductZipCode(productzipcode);
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
    preparedStatement.setString(2,product.getProductName());
    preparedStatement.setString(3,product.getProductAddress());
    preparedStatement.setString(4,product.getProductCity());
    preparedStatement.setString(5,product.getProductState());
    preparedStatement.setString(6,product.getProductCountry());
    preparedStatement.setString(7,product.getProductZipCode());
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

public void updateProduct(Product product)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,product.getProductName());
    preparedStatement.setString(2,product.getProductAddress());
    preparedStatement.setString(3,product.getProductCity());
    preparedStatement.setString(4,product.getProductState());
    preparedStatement.setString(5,product.getProductCountry());
    preparedStatement.setString(6,product.getProductZipCode());
    preparedStatement.setInt(7, product.getProductId());
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

public List<Product> getProducts( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Product> productList = new ArrayList<Product>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("PRODUCTID");
      String productname = resultSet.getString("PRODUCTNAME");
      String productaddress = resultSet.getString("PRODUCTADDRESS");
      String productcity = resultSet.getString("PRODUCTCITY");
      String productstate = resultSet.getString("PRODUCTSTATE");
      String productcountry = resultSet.getString("PRODUCTCOUNTRY");
      String productzipcode = resultSet.getString("PRODUCTZIPCODE");
      Product product = new Product();
      product.setProductId(id);
      product.setProductName(productname);
      product.setProductAddress(productaddress);
      product.setProductCity(productcity);
      product.setProductState(productstate);
      product.setProductCountry(productcountry);
      product.setProductZipCode(productzipcode);
       productList.add(product);
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
  return productList;
 }

public static void main( String[] args ) {
}

} 

