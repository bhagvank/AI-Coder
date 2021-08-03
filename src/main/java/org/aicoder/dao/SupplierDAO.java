package org.aicoder.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Supplier;
import org.archcorner.chartreuse.util.JDBCManager;

public class SupplierDAO{ 


private String highestIDSQL = "SELECT MAX(SUPPLIERID) AS MAXSUPPLIERID FROM SUPPLIER";
private String selectSQL = "SELECT * FROM SUPPLIER WHERE SUPPLIERNAME=?";
private String selectIdSQL = "SELECT * FROM SUPPLIER WHERE SUPPLIERID=?";
private String insertSQL = "INSERT INTO SUPPLIER(SUPPLIERID,SUPPLIERNAME,SUPPLIERADDRESS,SUPPLIERCITY,SUPPLIERSTATE,SUPPLIERCOUNTRY,SUPPLIERZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE SUPPLIER SET SUPPLIERNAME=?,SUPPLIERADDRESS=?,SUPPLIERCITY=?,SUPPLIERSTATE=?,SUPPLIERCOUNTRY=?,SUPPLIERZIPCODE=? WHERE SUPPLIERID=?";
private String deleteSQL = "DELETE FROM SUPPLIER WHERE SUPPLIERID=?";
private String selectAllSQL = "SELECT * FROM SUPPLIER";

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
    highestId = resultSet.getInt("MAXSUPPLIERID");
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

public Supplier getSupplierById(int supplierid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Supplier supplier = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, supplierid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("supplierid");
      String suppliername = resultSet.getString("SUPPLIERNAME");
      String supplieraddress = resultSet.getString("SUPPLIERADDRESS");
      String suppliercity = resultSet.getString("SUPPLIERCITY");
      String supplierstate = resultSet.getString("SUPPLIERSTATE");
      String suppliercountry = resultSet.getString("SUPPLIERCOUNTRY");
      String supplierzipcode = resultSet.getString("SUPPLIERZIPCODE");
      supplier = new Supplier();
      supplier.setSupplierId(id);
      supplier.setSupplierName(suppliername);
      supplier.setSupplierAddress(supplieraddress);
      supplier.setSupplierCity(suppliercity);
      supplier.setSupplierState(supplierstate);
      supplier.setSupplierCountry(suppliercountry);
      supplier.setSupplierZipCode(supplierzipcode);
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
  return supplier;
 }

public Supplier getSupplier(String suppliername)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Supplier supplier = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, suppliername);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("SupplierId");
      suppliername = resultSet.getString("SUPPLIERNAME");
      String supplieraddress = resultSet.getString("SUPPLIERADDRESS");
      String suppliercity = resultSet.getString("SUPPLIERCITY");
      String supplierstate = resultSet.getString("SUPPLIERSTATE");
      String suppliercountry = resultSet.getString("SUPPLIERCOUNTRY");
      String supplierzipcode = resultSet.getString("SUPPLIERZIPCODE");
      supplier = new Supplier();
      supplier.setSupplierId(id);
      supplier.setSupplierName(suppliername);
      supplier.setSupplierAddress(supplieraddress);
      supplier.setSupplierCity(suppliercity);
      supplier.setSupplierState(supplierstate);
      supplier.setSupplierCountry(suppliercountry);
      supplier.setSupplierZipCode(supplierzipcode);
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
  return supplier;
 }

public void deleteSupplier(Supplier supplier)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, supplier.getSupplierId());
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

public void insertSupplier(Supplier supplier)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,supplier.getSupplierName());
    preparedStatement.setString(3,supplier.getSupplierAddress());
    preparedStatement.setString(4,supplier.getSupplierCity());
    preparedStatement.setString(5,supplier.getSupplierState());
    preparedStatement.setString(6,supplier.getSupplierCountry());
    preparedStatement.setString(7,supplier.getSupplierZipCode());
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

public void updateSupplier(Supplier supplier)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,supplier.getSupplierName());
    preparedStatement.setString(2,supplier.getSupplierAddress());
    preparedStatement.setString(3,supplier.getSupplierCity());
    preparedStatement.setString(4,supplier.getSupplierState());
    preparedStatement.setString(5,supplier.getSupplierCountry());
    preparedStatement.setString(6,supplier.getSupplierZipCode());
    preparedStatement.setInt(7, supplier.getSupplierId());
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

public List<Supplier> getSuppliers( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Supplier> supplierList = new ArrayList<Supplier>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("SUPPLIERID");
      String suppliername = resultSet.getString("SUPPLIERNAME");
      String supplieraddress = resultSet.getString("SUPPLIERADDRESS");
      String suppliercity = resultSet.getString("SUPPLIERCITY");
      String supplierstate = resultSet.getString("SUPPLIERSTATE");
      String suppliercountry = resultSet.getString("SUPPLIERCOUNTRY");
      String supplierzipcode = resultSet.getString("SUPPLIERZIPCODE");
      Supplier supplier = new Supplier();
      supplier.setSupplierId(id);
      supplier.setSupplierName(suppliername);
      supplier.setSupplierAddress(supplieraddress);
      supplier.setSupplierCity(suppliercity);
      supplier.setSupplierState(supplierstate);
      supplier.setSupplierCountry(suppliercountry);
      supplier.setSupplierZipCode(supplierzipcode);
       supplierList.add(supplier);
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
  return supplierList;
 }

public static void main( String[] args ) {
}

} 

