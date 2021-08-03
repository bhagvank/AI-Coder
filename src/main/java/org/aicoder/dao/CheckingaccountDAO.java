package org.aicoder.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Checkingaccount;
import org.archcorner.chartreuse.util.JDBCManager;

public class CheckingaccountDAO{ 


private String highestIDSQL = "SELECT MAX(CHECKINGACCOUNTID) AS MAXCHECKINGACCOUNTID FROM CHECKINGACCOUNT";
private String selectSQL = "SELECT * FROM CHECKINGACCOUNT WHERE CHECKINGACCOUNTNAME=?";
private String selectIdSQL = "SELECT * FROM CHECKINGACCOUNT WHERE CHECKINGACCOUNTID=?";
private String insertSQL = "INSERT INTO CHECKINGACCOUNT(CHECKINGACCOUNTID,CHECKINGACCOUNTNAME,CHECKINGACCOUNTADDRESS,CHECKINGACCOUNTCITY,CHECKINGACCOUNTSTATE,CHECKINGACCOUNTCOUNTRY,CHECKINGACCOUNTZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE CHECKINGACCOUNT SET CHECKINGACCOUNTNAME=?,CHECKINGACCOUNTADDRESS=?,CHECKINGACCOUNTCITY=?,CHECKINGACCOUNTSTATE=?,CHECKINGACCOUNTCOUNTRY=?,CHECKINGACCOUNTZIPCODE=? WHERE CHECKINGACCOUNTID=?";
private String deleteSQL = "DELETE FROM CHECKINGACCOUNT WHERE CHECKINGACCOUNTID=?";
private String selectAllSQL = "SELECT * FROM CHECKINGACCOUNT";

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
    highestId = resultSet.getInt("MAXCHECKINGACCOUNTID");
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

public Checkingaccount getCheckingaccountById(int checkingaccountid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Checkingaccount checkingaccount = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, checkingaccountid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("checkingaccountid");
      String checkingaccountname = resultSet.getString("CHECKINGACCOUNTNAME");
      String checkingaccountaddress = resultSet.getString("CHECKINGACCOUNTADDRESS");
      String checkingaccountcity = resultSet.getString("CHECKINGACCOUNTCITY");
      String checkingaccountstate = resultSet.getString("CHECKINGACCOUNTSTATE");
      String checkingaccountcountry = resultSet.getString("CHECKINGACCOUNTCOUNTRY");
      String checkingaccountzipcode = resultSet.getString("CHECKINGACCOUNTZIPCODE");
      checkingaccount = new Checkingaccount();
      checkingaccount.setCheckingaccountId(id);
      checkingaccount.setCheckingaccountName(checkingaccountname);
      checkingaccount.setCheckingaccountAddress(checkingaccountaddress);
      checkingaccount.setCheckingaccountCity(checkingaccountcity);
      checkingaccount.setCheckingaccountState(checkingaccountstate);
      checkingaccount.setCheckingaccountCountry(checkingaccountcountry);
      checkingaccount.setCheckingaccountZipCode(checkingaccountzipcode);
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
  return checkingaccount;
 }

public Checkingaccount getCheckingaccount(String checkingaccountname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Checkingaccount checkingaccount = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, checkingaccountname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("CheckingaccountId");
      checkingaccountname = resultSet.getString("CHECKINGACCOUNTNAME");
      String checkingaccountaddress = resultSet.getString("CHECKINGACCOUNTADDRESS");
      String checkingaccountcity = resultSet.getString("CHECKINGACCOUNTCITY");
      String checkingaccountstate = resultSet.getString("CHECKINGACCOUNTSTATE");
      String checkingaccountcountry = resultSet.getString("CHECKINGACCOUNTCOUNTRY");
      String checkingaccountzipcode = resultSet.getString("CHECKINGACCOUNTZIPCODE");
      checkingaccount = new Checkingaccount();
      checkingaccount.setCheckingaccountId(id);
      checkingaccount.setCheckingaccountName(checkingaccountname);
      checkingaccount.setCheckingaccountAddress(checkingaccountaddress);
      checkingaccount.setCheckingaccountCity(checkingaccountcity);
      checkingaccount.setCheckingaccountState(checkingaccountstate);
      checkingaccount.setCheckingaccountCountry(checkingaccountcountry);
      checkingaccount.setCheckingaccountZipCode(checkingaccountzipcode);
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
  return checkingaccount;
 }

public void deleteCheckingaccount(Checkingaccount checkingaccount)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, checkingaccount.getCheckingaccountId());
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

public void insertCheckingaccount(Checkingaccount checkingaccount)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,checkingaccount.getCheckingaccountName());
    preparedStatement.setString(3,checkingaccount.getCheckingaccountAddress());
    preparedStatement.setString(4,checkingaccount.getCheckingaccountCity());
    preparedStatement.setString(5,checkingaccount.getCheckingaccountState());
    preparedStatement.setString(6,checkingaccount.getCheckingaccountCountry());
    preparedStatement.setString(7,checkingaccount.getCheckingaccountZipCode());
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

public void updateCheckingaccount(Checkingaccount checkingaccount)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,checkingaccount.getCheckingaccountName());
    preparedStatement.setString(2,checkingaccount.getCheckingaccountAddress());
    preparedStatement.setString(3,checkingaccount.getCheckingaccountCity());
    preparedStatement.setString(4,checkingaccount.getCheckingaccountState());
    preparedStatement.setString(5,checkingaccount.getCheckingaccountCountry());
    preparedStatement.setString(6,checkingaccount.getCheckingaccountZipCode());
    preparedStatement.setInt(7, checkingaccount.getCheckingaccountId());
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

public List<Checkingaccount> getCheckingaccounts( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Checkingaccount> checkingaccountList = new ArrayList<Checkingaccount>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("CHECKINGACCOUNTID");
      String checkingaccountname = resultSet.getString("CHECKINGACCOUNTNAME");
      String checkingaccountaddress = resultSet.getString("CHECKINGACCOUNTADDRESS");
      String checkingaccountcity = resultSet.getString("CHECKINGACCOUNTCITY");
      String checkingaccountstate = resultSet.getString("CHECKINGACCOUNTSTATE");
      String checkingaccountcountry = resultSet.getString("CHECKINGACCOUNTCOUNTRY");
      String checkingaccountzipcode = resultSet.getString("CHECKINGACCOUNTZIPCODE");
      Checkingaccount checkingaccount = new Checkingaccount();
      checkingaccount.setCheckingaccountId(id);
      checkingaccount.setCheckingaccountName(checkingaccountname);
      checkingaccount.setCheckingaccountAddress(checkingaccountaddress);
      checkingaccount.setCheckingaccountCity(checkingaccountcity);
      checkingaccount.setCheckingaccountState(checkingaccountstate);
      checkingaccount.setCheckingaccountCountry(checkingaccountcountry);
      checkingaccount.setCheckingaccountZipCode(checkingaccountzipcode);
       checkingaccountList.add(checkingaccount);
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
  return checkingaccountList;
 }

public static void main( String[] args ) {
}

} 

