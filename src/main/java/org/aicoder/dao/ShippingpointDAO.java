package org.aicoder.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Shippingpoint;
import org.archcorner.chartreuse.util.JDBCManager;

public class ShippingpointDAO{ 


private String highestIDSQL = "SELECT MAX(SHIPPINGPOINTID) AS MAXSHIPPINGPOINTID FROM SHIPPINGPOINT";
private String selectSQL = "SELECT * FROM SHIPPINGPOINT WHERE SHIPPINGPOINTNAME=?";
private String selectIdSQL = "SELECT * FROM SHIPPINGPOINT WHERE SHIPPINGPOINTID=?";
private String insertSQL = "INSERT INTO SHIPPINGPOINT(SHIPPINGPOINTID,SHIPPINGPOINTNAME,SHIPPINGPOINTADDRESS,SHIPPINGPOINTCITY,SHIPPINGPOINTSTATE,SHIPPINGPOINTCOUNTRY,SHIPPINGPOINTZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE SHIPPINGPOINT SET SHIPPINGPOINTNAME=?,SHIPPINGPOINTADDRESS=?,SHIPPINGPOINTCITY=?,SHIPPINGPOINTSTATE=?,SHIPPINGPOINTCOUNTRY=?,SHIPPINGPOINTZIPCODE=? WHERE SHIPPINGPOINTID=?";
private String deleteSQL = "DELETE FROM SHIPPINGPOINT WHERE SHIPPINGPOINTID=?";
private String selectAllSQL = "SELECT * FROM SHIPPINGPOINT";

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
    highestId = resultSet.getInt("MAXSHIPPINGPOINTID");
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

public Shippingpoint getShippingpointById(int shippingpointid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Shippingpoint shippingpoint = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, shippingpointid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("shippingpointid");
      String shippingpointname = resultSet.getString("SHIPPINGPOINTNAME");
      String shippingpointaddress = resultSet.getString("SHIPPINGPOINTADDRESS");
      String shippingpointcity = resultSet.getString("SHIPPINGPOINTCITY");
      String shippingpointstate = resultSet.getString("SHIPPINGPOINTSTATE");
      String shippingpointcountry = resultSet.getString("SHIPPINGPOINTCOUNTRY");
      String shippingpointzipcode = resultSet.getString("SHIPPINGPOINTZIPCODE");
      shippingpoint = new Shippingpoint();
      shippingpoint.setShippingpointId(id);
      shippingpoint.setShippingpointName(shippingpointname);
      shippingpoint.setShippingpointAddress(shippingpointaddress);
      shippingpoint.setShippingpointCity(shippingpointcity);
      shippingpoint.setShippingpointState(shippingpointstate);
      shippingpoint.setShippingpointCountry(shippingpointcountry);
      shippingpoint.setShippingpointZipCode(shippingpointzipcode);
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
  return shippingpoint;
 }

public Shippingpoint getShippingpoint(String shippingpointname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Shippingpoint shippingpoint = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, shippingpointname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("ShippingpointId");
      shippingpointname = resultSet.getString("SHIPPINGPOINTNAME");
      String shippingpointaddress = resultSet.getString("SHIPPINGPOINTADDRESS");
      String shippingpointcity = resultSet.getString("SHIPPINGPOINTCITY");
      String shippingpointstate = resultSet.getString("SHIPPINGPOINTSTATE");
      String shippingpointcountry = resultSet.getString("SHIPPINGPOINTCOUNTRY");
      String shippingpointzipcode = resultSet.getString("SHIPPINGPOINTZIPCODE");
      shippingpoint = new Shippingpoint();
      shippingpoint.setShippingpointId(id);
      shippingpoint.setShippingpointName(shippingpointname);
      shippingpoint.setShippingpointAddress(shippingpointaddress);
      shippingpoint.setShippingpointCity(shippingpointcity);
      shippingpoint.setShippingpointState(shippingpointstate);
      shippingpoint.setShippingpointCountry(shippingpointcountry);
      shippingpoint.setShippingpointZipCode(shippingpointzipcode);
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
  return shippingpoint;
 }

public void deleteShippingpoint(Shippingpoint shippingpoint)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, shippingpoint.getShippingpointId());
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

public void insertShippingpoint(Shippingpoint shippingpoint)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,shippingpoint.getShippingpointName());
    preparedStatement.setString(3,shippingpoint.getShippingpointAddress());
    preparedStatement.setString(4,shippingpoint.getShippingpointCity());
    preparedStatement.setString(5,shippingpoint.getShippingpointState());
    preparedStatement.setString(6,shippingpoint.getShippingpointCountry());
    preparedStatement.setString(7,shippingpoint.getShippingpointZipCode());
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

public void updateShippingpoint(Shippingpoint shippingpoint)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,shippingpoint.getShippingpointName());
    preparedStatement.setString(2,shippingpoint.getShippingpointAddress());
    preparedStatement.setString(3,shippingpoint.getShippingpointCity());
    preparedStatement.setString(4,shippingpoint.getShippingpointState());
    preparedStatement.setString(5,shippingpoint.getShippingpointCountry());
    preparedStatement.setString(6,shippingpoint.getShippingpointZipCode());
    preparedStatement.setInt(7, shippingpoint.getShippingpointId());
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

public List<Shippingpoint> getShippingpoints( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Shippingpoint> shippingpointList = new ArrayList<Shippingpoint>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("SHIPPINGPOINTID");
      String shippingpointname = resultSet.getString("SHIPPINGPOINTNAME");
      String shippingpointaddress = resultSet.getString("SHIPPINGPOINTADDRESS");
      String shippingpointcity = resultSet.getString("SHIPPINGPOINTCITY");
      String shippingpointstate = resultSet.getString("SHIPPINGPOINTSTATE");
      String shippingpointcountry = resultSet.getString("SHIPPINGPOINTCOUNTRY");
      String shippingpointzipcode = resultSet.getString("SHIPPINGPOINTZIPCODE");
      Shippingpoint shippingpoint = new Shippingpoint();
      shippingpoint.setShippingpointId(id);
      shippingpoint.setShippingpointName(shippingpointname);
      shippingpoint.setShippingpointAddress(shippingpointaddress);
      shippingpoint.setShippingpointCity(shippingpointcity);
      shippingpoint.setShippingpointState(shippingpointstate);
      shippingpoint.setShippingpointCountry(shippingpointcountry);
      shippingpoint.setShippingpointZipCode(shippingpointzipcode);
       shippingpointList.add(shippingpoint);
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
  return shippingpointList;
 }

public static void main( String[] args ) {
}

} 

