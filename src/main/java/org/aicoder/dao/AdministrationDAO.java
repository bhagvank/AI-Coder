package org.aicoder.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Administration;
import org.archcorner.chartreuse.util.JDBCManager;

public class AdministrationDAO{ 


private String highestIDSQL = "SELECT MAX(ADMINISTRATIONID) AS MAXADMINISTRATIONID FROM ADMINISTRATION";
private String selectSQL = "SELECT * FROM ADMINISTRATION WHERE ADMINISTRATIONNAME=?";
private String selectIdSQL = "SELECT * FROM ADMINISTRATION WHERE ADMINISTRATIONID=?";
private String insertSQL = "INSERT INTO ADMINISTRATION(ADMINISTRATIONID,ADMINISTRATIONNAME,ADMINISTRATIONADDRESS,ADMINISTRATIONCITY,ADMINISTRATIONSTATE,ADMINISTRATIONCOUNTRY,ADMINISTRATIONZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE ADMINISTRATION SET ADMINISTRATIONNAME=?,ADMINISTRATIONADDRESS=?,ADMINISTRATIONCITY=?,ADMINISTRATIONSTATE=?,ADMINISTRATIONCOUNTRY=?,ADMINISTRATIONZIPCODE=? WHERE ADMINISTRATIONID=?";
private String deleteSQL = "DELETE FROM ADMINISTRATION WHERE ADMINISTRATIONID=?";
private String selectAllSQL = "SELECT * FROM ADMINISTRATION";

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
    highestId = resultSet.getInt("MAXADMINISTRATIONID");
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

public Administration getAdministrationById(int administrationid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Administration administration = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, administrationid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("administrationid");
      String administrationname = resultSet.getString("ADMINISTRATIONNAME");
      String administrationaddress = resultSet.getString("ADMINISTRATIONADDRESS");
      String administrationcity = resultSet.getString("ADMINISTRATIONCITY");
      String administrationstate = resultSet.getString("ADMINISTRATIONSTATE");
      String administrationcountry = resultSet.getString("ADMINISTRATIONCOUNTRY");
      String administrationzipcode = resultSet.getString("ADMINISTRATIONZIPCODE");
      administration = new Administration();
      administration.setAdministrationId(id);
      administration.setAdministrationName(administrationname);
      administration.setAdministrationAddress(administrationaddress);
      administration.setAdministrationCity(administrationcity);
      administration.setAdministrationState(administrationstate);
      administration.setAdministrationCountry(administrationcountry);
      administration.setAdministrationZipCode(administrationzipcode);
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
  return administration;
 }

public Administration getAdministration(String administrationname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Administration administration = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, administrationname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("AdministrationId");
      administrationname = resultSet.getString("ADMINISTRATIONNAME");
      String administrationaddress = resultSet.getString("ADMINISTRATIONADDRESS");
      String administrationcity = resultSet.getString("ADMINISTRATIONCITY");
      String administrationstate = resultSet.getString("ADMINISTRATIONSTATE");
      String administrationcountry = resultSet.getString("ADMINISTRATIONCOUNTRY");
      String administrationzipcode = resultSet.getString("ADMINISTRATIONZIPCODE");
      administration = new Administration();
      administration.setAdministrationId(id);
      administration.setAdministrationName(administrationname);
      administration.setAdministrationAddress(administrationaddress);
      administration.setAdministrationCity(administrationcity);
      administration.setAdministrationState(administrationstate);
      administration.setAdministrationCountry(administrationcountry);
      administration.setAdministrationZipCode(administrationzipcode);
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
  return administration;
 }

public void deleteAdministration(Administration administration)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, administration.getAdministrationId());
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

public void insertAdministration(Administration administration)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,administration.getAdministrationName());
    preparedStatement.setString(3,administration.getAdministrationAddress());
    preparedStatement.setString(4,administration.getAdministrationCity());
    preparedStatement.setString(5,administration.getAdministrationState());
    preparedStatement.setString(6,administration.getAdministrationCountry());
    preparedStatement.setString(7,administration.getAdministrationZipCode());
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

public void updateAdministration(Administration administration)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,administration.getAdministrationName());
    preparedStatement.setString(2,administration.getAdministrationAddress());
    preparedStatement.setString(3,administration.getAdministrationCity());
    preparedStatement.setString(4,administration.getAdministrationState());
    preparedStatement.setString(5,administration.getAdministrationCountry());
    preparedStatement.setString(6,administration.getAdministrationZipCode());
    preparedStatement.setInt(7, administration.getAdministrationId());
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

public List<Administration> getAdministrations( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Administration> administrationList = new ArrayList<Administration>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("ADMINISTRATIONID");
      String administrationname = resultSet.getString("ADMINISTRATIONNAME");
      String administrationaddress = resultSet.getString("ADMINISTRATIONADDRESS");
      String administrationcity = resultSet.getString("ADMINISTRATIONCITY");
      String administrationstate = resultSet.getString("ADMINISTRATIONSTATE");
      String administrationcountry = resultSet.getString("ADMINISTRATIONCOUNTRY");
      String administrationzipcode = resultSet.getString("ADMINISTRATIONZIPCODE");
      Administration administration = new Administration();
      administration.setAdministrationId(id);
      administration.setAdministrationName(administrationname);
      administration.setAdministrationAddress(administrationaddress);
      administration.setAdministrationCity(administrationcity);
      administration.setAdministrationState(administrationstate);
      administration.setAdministrationCountry(administrationcountry);
      administration.setAdministrationZipCode(administrationzipcode);
       administrationList.add(administration);
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
  return administrationList;
 }

public static void main( String[] args ) {
}

} 

