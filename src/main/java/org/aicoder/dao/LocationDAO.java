package org.aicoder.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Location;
import org.archcorner.chartreuse.util.JDBCManager;

public class LocationDAO{ 


private String highestIDSQL = "SELECT MAX(LOCATIONID) AS MAXLOCATIONID FROM LOCATION";
private String selectSQL = "SELECT * FROM LOCATION WHERE LOCATIONNAME=?";
private String selectIdSQL = "SELECT * FROM LOCATION WHERE LOCATIONID=?";
private String insertSQL = "INSERT INTO LOCATION(LOCATIONID,LOCATIONNAME,LOCATIONADDRESS,LOCATIONCITY,LOCATIONSTATE,LOCATIONCOUNTRY,LOCATIONZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE LOCATION SET LOCATIONNAME=?,LOCATIONADDRESS=?,LOCATIONCITY=?,LOCATIONSTATE=?,LOCATIONCOUNTRY=?,LOCATIONZIPCODE=? WHERE LOCATIONID=?";
private String deleteSQL = "DELETE FROM LOCATION WHERE LOCATIONID=?";
private String selectAllSQL = "SELECT * FROM LOCATION";

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
    highestId = resultSet.getInt("MAXLOCATIONID");
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

public Location getLocationById(int locationid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Location location = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, locationid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("locationid");
      String locationname = resultSet.getString("LOCATIONNAME");
      String locationaddress = resultSet.getString("LOCATIONADDRESS");
      String locationcity = resultSet.getString("LOCATIONCITY");
      String locationstate = resultSet.getString("LOCATIONSTATE");
      String locationcountry = resultSet.getString("LOCATIONCOUNTRY");
      String locationzipcode = resultSet.getString("LOCATIONZIPCODE");
      location = new Location();
      location.setLocationId(id);
      location.setLocationName(locationname);
      location.setLocationAddress(locationaddress);
      location.setLocationCity(locationcity);
      location.setLocationState(locationstate);
      location.setLocationCountry(locationcountry);
      location.setLocationZipCode(locationzipcode);
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
  return location;
 }

public Location getLocation(String locationname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Location location = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, locationname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("LocationId");
      locationname = resultSet.getString("LOCATIONNAME");
      String locationaddress = resultSet.getString("LOCATIONADDRESS");
      String locationcity = resultSet.getString("LOCATIONCITY");
      String locationstate = resultSet.getString("LOCATIONSTATE");
      String locationcountry = resultSet.getString("LOCATIONCOUNTRY");
      String locationzipcode = resultSet.getString("LOCATIONZIPCODE");
      location = new Location();
      location.setLocationId(id);
      location.setLocationName(locationname);
      location.setLocationAddress(locationaddress);
      location.setLocationCity(locationcity);
      location.setLocationState(locationstate);
      location.setLocationCountry(locationcountry);
      location.setLocationZipCode(locationzipcode);
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
  return location;
 }

public void deleteLocation(Location location)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, location.getLocationId());
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

public void insertLocation(Location location)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,location.getLocationName());
    preparedStatement.setString(3,location.getLocationAddress());
    preparedStatement.setString(4,location.getLocationCity());
    preparedStatement.setString(5,location.getLocationState());
    preparedStatement.setString(6,location.getLocationCountry());
    preparedStatement.setString(7,location.getLocationZipCode());
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

public void updateLocation(Location location)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,location.getLocationName());
    preparedStatement.setString(2,location.getLocationAddress());
    preparedStatement.setString(3,location.getLocationCity());
    preparedStatement.setString(4,location.getLocationState());
    preparedStatement.setString(5,location.getLocationCountry());
    preparedStatement.setString(6,location.getLocationZipCode());
    preparedStatement.setInt(7, location.getLocationId());
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

public List<Location> getLocations( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Location> locationList = new ArrayList<Location>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("LOCATIONID");
      String locationname = resultSet.getString("LOCATIONNAME");
      String locationaddress = resultSet.getString("LOCATIONADDRESS");
      String locationcity = resultSet.getString("LOCATIONCITY");
      String locationstate = resultSet.getString("LOCATIONSTATE");
      String locationcountry = resultSet.getString("LOCATIONCOUNTRY");
      String locationzipcode = resultSet.getString("LOCATIONZIPCODE");
      Location location = new Location();
      location.setLocationId(id);
      location.setLocationName(locationname);
      location.setLocationAddress(locationaddress);
      location.setLocationCity(locationcity);
      location.setLocationState(locationstate);
      location.setLocationCountry(locationcountry);
      location.setLocationZipCode(locationzipcode);
       locationList.add(location);
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
  return locationList;
 }

public static void main( String[] args ) {
}

} 

