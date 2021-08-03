package org.aicoder.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Glaccount;
import org.archcorner.chartreuse.util.JDBCManager;

public class GlaccountDAO{ 


private String highestIDSQL = "SELECT MAX(GLACCOUNTID) AS MAXGLACCOUNTID FROM GLACCOUNT";
private String selectSQL = "SELECT * FROM GLACCOUNT WHERE GLACCOUNTNAME=?";
private String selectIdSQL = "SELECT * FROM GLACCOUNT WHERE GLACCOUNTID=?";
private String insertSQL = "INSERT INTO GLACCOUNT(GLACCOUNTID,GLACCOUNTNAME,GLACCOUNTADDRESS,GLACCOUNTCITY,GLACCOUNTSTATE,GLACCOUNTCOUNTRY,GLACCOUNTZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE GLACCOUNT SET GLACCOUNTNAME=?,GLACCOUNTADDRESS=?,GLACCOUNTCITY=?,GLACCOUNTSTATE=?,GLACCOUNTCOUNTRY=?,GLACCOUNTZIPCODE=? WHERE GLACCOUNTID=?";
private String deleteSQL = "DELETE FROM GLACCOUNT WHERE GLACCOUNTID=?";
private String selectAllSQL = "SELECT * FROM GLACCOUNT";

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
    highestId = resultSet.getInt("MAXGLACCOUNTID");
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

public Glaccount getGlaccountById(int glaccountid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Glaccount glaccount = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, glaccountid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("glaccountid");
      String glaccountname = resultSet.getString("GLACCOUNTNAME");
      String glaccountaddress = resultSet.getString("GLACCOUNTADDRESS");
      String glaccountcity = resultSet.getString("GLACCOUNTCITY");
      String glaccountstate = resultSet.getString("GLACCOUNTSTATE");
      String glaccountcountry = resultSet.getString("GLACCOUNTCOUNTRY");
      String glaccountzipcode = resultSet.getString("GLACCOUNTZIPCODE");
      glaccount = new Glaccount();
      glaccount.setGlaccountId(id);
      glaccount.setGlaccountName(glaccountname);
      glaccount.setGlaccountAddress(glaccountaddress);
      glaccount.setGlaccountCity(glaccountcity);
      glaccount.setGlaccountState(glaccountstate);
      glaccount.setGlaccountCountry(glaccountcountry);
      glaccount.setGlaccountZipCode(glaccountzipcode);
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
  return glaccount;
 }

public Glaccount getGlaccount(String glaccountname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Glaccount glaccount = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, glaccountname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("GlaccountId");
      glaccountname = resultSet.getString("GLACCOUNTNAME");
      String glaccountaddress = resultSet.getString("GLACCOUNTADDRESS");
      String glaccountcity = resultSet.getString("GLACCOUNTCITY");
      String glaccountstate = resultSet.getString("GLACCOUNTSTATE");
      String glaccountcountry = resultSet.getString("GLACCOUNTCOUNTRY");
      String glaccountzipcode = resultSet.getString("GLACCOUNTZIPCODE");
      glaccount = new Glaccount();
      glaccount.setGlaccountId(id);
      glaccount.setGlaccountName(glaccountname);
      glaccount.setGlaccountAddress(glaccountaddress);
      glaccount.setGlaccountCity(glaccountcity);
      glaccount.setGlaccountState(glaccountstate);
      glaccount.setGlaccountCountry(glaccountcountry);
      glaccount.setGlaccountZipCode(glaccountzipcode);
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
  return glaccount;
 }

public void deleteGlaccount(Glaccount glaccount)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, glaccount.getGlaccountId());
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

public void insertGlaccount(Glaccount glaccount)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,glaccount.getGlaccountName());
    preparedStatement.setString(3,glaccount.getGlaccountAddress());
    preparedStatement.setString(4,glaccount.getGlaccountCity());
    preparedStatement.setString(5,glaccount.getGlaccountState());
    preparedStatement.setString(6,glaccount.getGlaccountCountry());
    preparedStatement.setString(7,glaccount.getGlaccountZipCode());
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

public void updateGlaccount(Glaccount glaccount)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,glaccount.getGlaccountName());
    preparedStatement.setString(2,glaccount.getGlaccountAddress());
    preparedStatement.setString(3,glaccount.getGlaccountCity());
    preparedStatement.setString(4,glaccount.getGlaccountState());
    preparedStatement.setString(5,glaccount.getGlaccountCountry());
    preparedStatement.setString(6,glaccount.getGlaccountZipCode());
    preparedStatement.setInt(7, glaccount.getGlaccountId());
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

public List<Glaccount> getGlaccounts( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Glaccount> glaccountList = new ArrayList<Glaccount>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("GLACCOUNTID");
      String glaccountname = resultSet.getString("GLACCOUNTNAME");
      String glaccountaddress = resultSet.getString("GLACCOUNTADDRESS");
      String glaccountcity = resultSet.getString("GLACCOUNTCITY");
      String glaccountstate = resultSet.getString("GLACCOUNTSTATE");
      String glaccountcountry = resultSet.getString("GLACCOUNTCOUNTRY");
      String glaccountzipcode = resultSet.getString("GLACCOUNTZIPCODE");
      Glaccount glaccount = new Glaccount();
      glaccount.setGlaccountId(id);
      glaccount.setGlaccountName(glaccountname);
      glaccount.setGlaccountAddress(glaccountaddress);
      glaccount.setGlaccountCity(glaccountcity);
      glaccount.setGlaccountState(glaccountstate);
      glaccount.setGlaccountCountry(glaccountcountry);
      glaccount.setGlaccountZipCode(glaccountzipcode);
       glaccountList.add(glaccount);
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
  return glaccountList;
 }

public static void main( String[] args ) {
}

} 

