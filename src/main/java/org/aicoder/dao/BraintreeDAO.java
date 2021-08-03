package org.aicoder.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Braintree;
import org.archcorner.chartreuse.util.JDBCManager;

public class BraintreeDAO{ 


private String highestIDSQL = "SELECT MAX(BRAINTREEID) AS MAXBRAINTREEID FROM BRAINTREE";
private String selectSQL = "SELECT * FROM BRAINTREE WHERE BRAINTREENAME=?";
private String selectIdSQL = "SELECT * FROM BRAINTREE WHERE BRAINTREEID=?";
private String insertSQL = "INSERT INTO BRAINTREE(BRAINTREEID,BRAINTREENAME,BRAINTREEADDRESS,BRAINTREECITY,BRAINTREESTATE,BRAINTREECOUNTRY,BRAINTREEZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE BRAINTREE SET BRAINTREENAME=?,BRAINTREEADDRESS=?,BRAINTREECITY=?,BRAINTREESTATE=?,BRAINTREECOUNTRY=?,BRAINTREEZIPCODE=? WHERE BRAINTREEID=?";
private String deleteSQL = "DELETE FROM BRAINTREE WHERE BRAINTREEID=?";
private String selectAllSQL = "SELECT * FROM BRAINTREE";

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
    highestId = resultSet.getInt("MAXBRAINTREEID");
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

public Braintree getBraintreeById(int braintreeid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Braintree braintree = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, braintreeid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("braintreeid");
      String braintreename = resultSet.getString("BRAINTREENAME");
      String braintreeaddress = resultSet.getString("BRAINTREEADDRESS");
      String braintreecity = resultSet.getString("BRAINTREECITY");
      String braintreestate = resultSet.getString("BRAINTREESTATE");
      String braintreecountry = resultSet.getString("BRAINTREECOUNTRY");
      String braintreezipcode = resultSet.getString("BRAINTREEZIPCODE");
      braintree = new Braintree();
      braintree.setBraintreeId(id);
      braintree.setBraintreeName(braintreename);
      braintree.setBraintreeAddress(braintreeaddress);
      braintree.setBraintreeCity(braintreecity);
      braintree.setBraintreeState(braintreestate);
      braintree.setBraintreeCountry(braintreecountry);
      braintree.setBraintreeZipCode(braintreezipcode);
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
  return braintree;
 }

public Braintree getBraintree(String braintreename)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Braintree braintree = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, braintreename);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("BraintreeId");
      braintreename = resultSet.getString("BRAINTREENAME");
      String braintreeaddress = resultSet.getString("BRAINTREEADDRESS");
      String braintreecity = resultSet.getString("BRAINTREECITY");
      String braintreestate = resultSet.getString("BRAINTREESTATE");
      String braintreecountry = resultSet.getString("BRAINTREECOUNTRY");
      String braintreezipcode = resultSet.getString("BRAINTREEZIPCODE");
      braintree = new Braintree();
      braintree.setBraintreeId(id);
      braintree.setBraintreeName(braintreename);
      braintree.setBraintreeAddress(braintreeaddress);
      braintree.setBraintreeCity(braintreecity);
      braintree.setBraintreeState(braintreestate);
      braintree.setBraintreeCountry(braintreecountry);
      braintree.setBraintreeZipCode(braintreezipcode);
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
  return braintree;
 }

public void deleteBraintree(Braintree braintree)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, braintree.getBraintreeId());
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

public void insertBraintree(Braintree braintree)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,braintree.getBraintreeName());
    preparedStatement.setString(3,braintree.getBraintreeAddress());
    preparedStatement.setString(4,braintree.getBraintreeCity());
    preparedStatement.setString(5,braintree.getBraintreeState());
    preparedStatement.setString(6,braintree.getBraintreeCountry());
    preparedStatement.setString(7,braintree.getBraintreeZipCode());
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

public void updateBraintree(Braintree braintree)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,braintree.getBraintreeName());
    preparedStatement.setString(2,braintree.getBraintreeAddress());
    preparedStatement.setString(3,braintree.getBraintreeCity());
    preparedStatement.setString(4,braintree.getBraintreeState());
    preparedStatement.setString(5,braintree.getBraintreeCountry());
    preparedStatement.setString(6,braintree.getBraintreeZipCode());
    preparedStatement.setInt(7, braintree.getBraintreeId());
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

public List<Braintree> getBraintrees( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Braintree> braintreeList = new ArrayList<Braintree>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("BRAINTREEID");
      String braintreename = resultSet.getString("BRAINTREENAME");
      String braintreeaddress = resultSet.getString("BRAINTREEADDRESS");
      String braintreecity = resultSet.getString("BRAINTREECITY");
      String braintreestate = resultSet.getString("BRAINTREESTATE");
      String braintreecountry = resultSet.getString("BRAINTREECOUNTRY");
      String braintreezipcode = resultSet.getString("BRAINTREEZIPCODE");
      Braintree braintree = new Braintree();
      braintree.setBraintreeId(id);
      braintree.setBraintreeName(braintreename);
      braintree.setBraintreeAddress(braintreeaddress);
      braintree.setBraintreeCity(braintreecity);
      braintree.setBraintreeState(braintreestate);
      braintree.setBraintreeCountry(braintreecountry);
      braintree.setBraintreeZipCode(braintreezipcode);
       braintreeList.add(braintree);
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
  return braintreeList;
 }

public static void main( String[] args ) {
}

} 

