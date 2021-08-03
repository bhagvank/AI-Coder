package org.aicoder.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.House;
import org.archcorner.chartreuse.util.JDBCManager;

public class HouseDAO{ 


private String highestIDSQL = "SELECT MAX(HOUSEID) AS MAXHOUSEID FROM HOUSE";
private String selectSQL = "SELECT * FROM HOUSE WHERE HOUSENAME=?";
private String selectIdSQL = "SELECT * FROM HOUSE WHERE HOUSEID=?";
private String insertSQL = "INSERT INTO HOUSE(HOUSEID,HOUSENAME,HOUSEADDRESS,HOUSECITY,HOUSESTATE,HOUSECOUNTRY,HOUSEZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE HOUSE SET HOUSENAME=?,HOUSEADDRESS=?,HOUSECITY=?,HOUSESTATE=?,HOUSECOUNTRY=?,HOUSEZIPCODE=? WHERE HOUSEID=?";
private String deleteSQL = "DELETE FROM HOUSE WHERE HOUSEID=?";
private String selectAllSQL = "SELECT * FROM HOUSE";

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
    highestId = resultSet.getInt("MAXHOUSEID");
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

public House getHouseById(int houseid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   House house = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, houseid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("houseid");
      String housename = resultSet.getString("HOUSENAME");
      String houseaddress = resultSet.getString("HOUSEADDRESS");
      String housecity = resultSet.getString("HOUSECITY");
      String housestate = resultSet.getString("HOUSESTATE");
      String housecountry = resultSet.getString("HOUSECOUNTRY");
      String housezipcode = resultSet.getString("HOUSEZIPCODE");
      house = new House();
      house.setHouseId(id);
      house.setHouseName(housename);
      house.setHouseAddress(houseaddress);
      house.setHouseCity(housecity);
      house.setHouseState(housestate);
      house.setHouseCountry(housecountry);
      house.setHouseZipCode(housezipcode);
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
  return house;
 }

public House getHouse(String housename)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   House house = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, housename);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("HouseId");
      housename = resultSet.getString("HOUSENAME");
      String houseaddress = resultSet.getString("HOUSEADDRESS");
      String housecity = resultSet.getString("HOUSECITY");
      String housestate = resultSet.getString("HOUSESTATE");
      String housecountry = resultSet.getString("HOUSECOUNTRY");
      String housezipcode = resultSet.getString("HOUSEZIPCODE");
      house = new House();
      house.setHouseId(id);
      house.setHouseName(housename);
      house.setHouseAddress(houseaddress);
      house.setHouseCity(housecity);
      house.setHouseState(housestate);
      house.setHouseCountry(housecountry);
      house.setHouseZipCode(housezipcode);
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
  return house;
 }

public void deleteHouse(House house)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, house.getHouseId());
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

public void insertHouse(House house)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,house.getHouseName());
    preparedStatement.setString(3,house.getHouseAddress());
    preparedStatement.setString(4,house.getHouseCity());
    preparedStatement.setString(5,house.getHouseState());
    preparedStatement.setString(6,house.getHouseCountry());
    preparedStatement.setString(7,house.getHouseZipCode());
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

public void updateHouse(House house)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,house.getHouseName());
    preparedStatement.setString(2,house.getHouseAddress());
    preparedStatement.setString(3,house.getHouseCity());
    preparedStatement.setString(4,house.getHouseState());
    preparedStatement.setString(5,house.getHouseCountry());
    preparedStatement.setString(6,house.getHouseZipCode());
    preparedStatement.setInt(7, house.getHouseId());
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

public List<House> getHouses( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<House> houseList = new ArrayList<House>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("HOUSEID");
      String housename = resultSet.getString("HOUSENAME");
      String houseaddress = resultSet.getString("HOUSEADDRESS");
      String housecity = resultSet.getString("HOUSECITY");
      String housestate = resultSet.getString("HOUSESTATE");
      String housecountry = resultSet.getString("HOUSECOUNTRY");
      String housezipcode = resultSet.getString("HOUSEZIPCODE");
      House house = new House();
      house.setHouseId(id);
      house.setHouseName(housename);
      house.setHouseAddress(houseaddress);
      house.setHouseCity(housecity);
      house.setHouseState(housestate);
      house.setHouseCountry(housecountry);
      house.setHouseZipCode(housezipcode);
       houseList.add(house);
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
  return houseList;
 }

public static void main( String[] args ) {
}

} 

