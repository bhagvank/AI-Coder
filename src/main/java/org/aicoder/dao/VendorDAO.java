package org.aicoder.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Vendor;
import org.archcorner.chartreuse.util.JDBCManager;

public class VendorDAO{ 


private String highestIDSQL = "SELECT MAX(VENDORID) AS MAXVENDORID FROM VENDOR";
private String selectSQL = "SELECT * FROM VENDOR WHERE VENDORNAME=?";
private String selectIdSQL = "SELECT * FROM VENDOR WHERE VENDORID=?";
private String insertSQL = "INSERT INTO VENDOR(VENDORID,VENDORNAME,VENDORADDRESS,VENDORCITY,VENDORSTATE,VENDORCOUNTRY,VENDORZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE VENDOR SET VENDORNAME=?,VENDORADDRESS=?,VENDORCITY=?,VENDORSTATE=?,VENDORCOUNTRY=?,VENDORZIPCODE=? WHERE VENDORID=?";
private String deleteSQL = "DELETE FROM VENDOR WHERE VENDORID=?";
private String selectAllSQL = "SELECT * FROM VENDOR";

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
    highestId = resultSet.getInt("MAXVENDORID");
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

public Vendor getVendorById(int vendorid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Vendor vendor = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, vendorid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("vendorid");
      String vendorname = resultSet.getString("VENDORNAME");
      String vendoraddress = resultSet.getString("VENDORADDRESS");
      String vendorcity = resultSet.getString("VENDORCITY");
      String vendorstate = resultSet.getString("VENDORSTATE");
      String vendorcountry = resultSet.getString("VENDORCOUNTRY");
      String vendorzipcode = resultSet.getString("VENDORZIPCODE");
      vendor = new Vendor();
      vendor.setVendorId(id);
      vendor.setVendorName(vendorname);
      vendor.setVendorAddress(vendoraddress);
      vendor.setVendorCity(vendorcity);
      vendor.setVendorState(vendorstate);
      vendor.setVendorCountry(vendorcountry);
      vendor.setVendorZipCode(vendorzipcode);
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
  return vendor;
 }

public Vendor getVendor(String vendorname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Vendor vendor = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, vendorname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("VendorId");
      vendorname = resultSet.getString("VENDORNAME");
      String vendoraddress = resultSet.getString("VENDORADDRESS");
      String vendorcity = resultSet.getString("VENDORCITY");
      String vendorstate = resultSet.getString("VENDORSTATE");
      String vendorcountry = resultSet.getString("VENDORCOUNTRY");
      String vendorzipcode = resultSet.getString("VENDORZIPCODE");
      vendor = new Vendor();
      vendor.setVendorId(id);
      vendor.setVendorName(vendorname);
      vendor.setVendorAddress(vendoraddress);
      vendor.setVendorCity(vendorcity);
      vendor.setVendorState(vendorstate);
      vendor.setVendorCountry(vendorcountry);
      vendor.setVendorZipCode(vendorzipcode);
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
  return vendor;
 }

public void deleteVendor(Vendor vendor)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, vendor.getVendorId());
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

public void insertVendor(Vendor vendor)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,vendor.getVendorName());
    preparedStatement.setString(3,vendor.getVendorAddress());
    preparedStatement.setString(4,vendor.getVendorCity());
    preparedStatement.setString(5,vendor.getVendorState());
    preparedStatement.setString(6,vendor.getVendorCountry());
    preparedStatement.setString(7,vendor.getVendorZipCode());
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

public void updateVendor(Vendor vendor)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,vendor.getVendorName());
    preparedStatement.setString(2,vendor.getVendorAddress());
    preparedStatement.setString(3,vendor.getVendorCity());
    preparedStatement.setString(4,vendor.getVendorState());
    preparedStatement.setString(5,vendor.getVendorCountry());
    preparedStatement.setString(6,vendor.getVendorZipCode());
    preparedStatement.setInt(7, vendor.getVendorId());
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

public List<Vendor> getVendors( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Vendor> vendorList = new ArrayList<Vendor>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("VENDORID");
      String vendorname = resultSet.getString("VENDORNAME");
      String vendoraddress = resultSet.getString("VENDORADDRESS");
      String vendorcity = resultSet.getString("VENDORCITY");
      String vendorstate = resultSet.getString("VENDORSTATE");
      String vendorcountry = resultSet.getString("VENDORCOUNTRY");
      String vendorzipcode = resultSet.getString("VENDORZIPCODE");
      Vendor vendor = new Vendor();
      vendor.setVendorId(id);
      vendor.setVendorName(vendorname);
      vendor.setVendorAddress(vendoraddress);
      vendor.setVendorCity(vendorcity);
      vendor.setVendorState(vendorstate);
      vendor.setVendorCountry(vendorcountry);
      vendor.setVendorZipCode(vendorzipcode);
       vendorList.add(vendor);
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
  return vendorList;
 }

public static void main( String[] args ) {
}

} 

