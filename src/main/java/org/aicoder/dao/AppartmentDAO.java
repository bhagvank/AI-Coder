package org.aicoder.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Appartment;
import org.archcorner.chartreuse.util.JDBCManager;

public class AppartmentDAO{ 


private String highestIDSQL = "SELECT MAX(APPARTMENTID) AS MAXAPPARTMENTID FROM APPARTMENT";
private String selectSQL = "SELECT * FROM APPARTMENT WHERE APPARTMENTNAME=?";
private String selectIdSQL = "SELECT * FROM APPARTMENT WHERE APPARTMENTID=?";
private String insertSQL = "INSERT INTO APPARTMENT(APPARTMENTID,APPARTMENTNAME,APPARTMENTADDRESS,APPARTMENTCITY,APPARTMENTSTATE,APPARTMENTCOUNTRY,APPARTMENTZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE APPARTMENT SET APPARTMENTNAME=?,APPARTMENTADDRESS=?,APPARTMENTCITY=?,APPARTMENTSTATE=?,APPARTMENTCOUNTRY=?,APPARTMENTZIPCODE=? WHERE APPARTMENTID=?";
private String deleteSQL = "DELETE FROM APPARTMENT WHERE APPARTMENTID=?";
private String selectAllSQL = "SELECT * FROM APPARTMENT";

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
    highestId = resultSet.getInt("MAXAPPARTMENTID");
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

public Appartment getAppartmentById(int appartmentid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Appartment appartment = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, appartmentid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("appartmentid");
      String appartmentname = resultSet.getString("APPARTMENTNAME");
      String appartmentaddress = resultSet.getString("APPARTMENTADDRESS");
      String appartmentcity = resultSet.getString("APPARTMENTCITY");
      String appartmentstate = resultSet.getString("APPARTMENTSTATE");
      String appartmentcountry = resultSet.getString("APPARTMENTCOUNTRY");
      String appartmentzipcode = resultSet.getString("APPARTMENTZIPCODE");
      appartment = new Appartment();
      appartment.setAppartmentId(id);
      appartment.setAppartmentName(appartmentname);
      appartment.setAppartmentAddress(appartmentaddress);
      appartment.setAppartmentCity(appartmentcity);
      appartment.setAppartmentState(appartmentstate);
      appartment.setAppartmentCountry(appartmentcountry);
      appartment.setAppartmentZipCode(appartmentzipcode);
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
  return appartment;
 }

public Appartment getAppartment(String appartmentname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Appartment appartment = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, appartmentname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("AppartmentId");
      appartmentname = resultSet.getString("APPARTMENTNAME");
      String appartmentaddress = resultSet.getString("APPARTMENTADDRESS");
      String appartmentcity = resultSet.getString("APPARTMENTCITY");
      String appartmentstate = resultSet.getString("APPARTMENTSTATE");
      String appartmentcountry = resultSet.getString("APPARTMENTCOUNTRY");
      String appartmentzipcode = resultSet.getString("APPARTMENTZIPCODE");
      appartment = new Appartment();
      appartment.setAppartmentId(id);
      appartment.setAppartmentName(appartmentname);
      appartment.setAppartmentAddress(appartmentaddress);
      appartment.setAppartmentCity(appartmentcity);
      appartment.setAppartmentState(appartmentstate);
      appartment.setAppartmentCountry(appartmentcountry);
      appartment.setAppartmentZipCode(appartmentzipcode);
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
  return appartment;
 }

public void deleteAppartment(Appartment appartment)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, appartment.getAppartmentId());
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

public void insertAppartment(Appartment appartment)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,appartment.getAppartmentName());
    preparedStatement.setString(3,appartment.getAppartmentAddress());
    preparedStatement.setString(4,appartment.getAppartmentCity());
    preparedStatement.setString(5,appartment.getAppartmentState());
    preparedStatement.setString(6,appartment.getAppartmentCountry());
    preparedStatement.setString(7,appartment.getAppartmentZipCode());
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

public void updateAppartment(Appartment appartment)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,appartment.getAppartmentName());
    preparedStatement.setString(2,appartment.getAppartmentAddress());
    preparedStatement.setString(3,appartment.getAppartmentCity());
    preparedStatement.setString(4,appartment.getAppartmentState());
    preparedStatement.setString(5,appartment.getAppartmentCountry());
    preparedStatement.setString(6,appartment.getAppartmentZipCode());
    preparedStatement.setInt(7, appartment.getAppartmentId());
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

public List<Appartment> getAppartments( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Appartment> appartmentList = new ArrayList<Appartment>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("APPARTMENTID");
      String appartmentname = resultSet.getString("APPARTMENTNAME");
      String appartmentaddress = resultSet.getString("APPARTMENTADDRESS");
      String appartmentcity = resultSet.getString("APPARTMENTCITY");
      String appartmentstate = resultSet.getString("APPARTMENTSTATE");
      String appartmentcountry = resultSet.getString("APPARTMENTCOUNTRY");
      String appartmentzipcode = resultSet.getString("APPARTMENTZIPCODE");
      Appartment appartment = new Appartment();
      appartment.setAppartmentId(id);
      appartment.setAppartmentName(appartmentname);
      appartment.setAppartmentAddress(appartmentaddress);
      appartment.setAppartmentCity(appartmentcity);
      appartment.setAppartmentState(appartmentstate);
      appartment.setAppartmentCountry(appartmentcountry);
      appartment.setAppartmentZipCode(appartmentzipcode);
       appartmentList.add(appartment);
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
  return appartmentList;
 }

public static void main( String[] args ) {
}

} 

