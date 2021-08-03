package org.aicoder.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Liability;
import org.archcorner.chartreuse.util.JDBCManager;

public class LiabilityDAO{ 


private String highestIDSQL = "SELECT MAX(LIABILITYID) AS MAXLIABILITYID FROM LIABILITY";
private String selectSQL = "SELECT * FROM LIABILITY WHERE LIABILITYNAME=?";
private String selectIdSQL = "SELECT * FROM LIABILITY WHERE LIABILITYID=?";
private String insertSQL = "INSERT INTO LIABILITY(LIABILITYID,LIABILITYNAME,LIABILITYADDRESS,LIABILITYCITY,LIABILITYSTATE,LIABILITYCOUNTRY,LIABILITYZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE LIABILITY SET LIABILITYNAME=?,LIABILITYADDRESS=?,LIABILITYCITY=?,LIABILITYSTATE=?,LIABILITYCOUNTRY=?,LIABILITYZIPCODE=? WHERE LIABILITYID=?";
private String deleteSQL = "DELETE FROM LIABILITY WHERE LIABILITYID=?";
private String selectAllSQL = "SELECT * FROM LIABILITY";

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
    highestId = resultSet.getInt("MAXLIABILITYID");
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

public Liability getLiabilityById(int liabilityid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Liability liability = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, liabilityid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("liabilityid");
      String liabilityname = resultSet.getString("LIABILITYNAME");
      String liabilityaddress = resultSet.getString("LIABILITYADDRESS");
      String liabilitycity = resultSet.getString("LIABILITYCITY");
      String liabilitystate = resultSet.getString("LIABILITYSTATE");
      String liabilitycountry = resultSet.getString("LIABILITYCOUNTRY");
      String liabilityzipcode = resultSet.getString("LIABILITYZIPCODE");
      liability = new Liability();
      liability.setLiabilityId(id);
      liability.setLiabilityName(liabilityname);
      liability.setLiabilityAddress(liabilityaddress);
      liability.setLiabilityCity(liabilitycity);
      liability.setLiabilityState(liabilitystate);
      liability.setLiabilityCountry(liabilitycountry);
      liability.setLiabilityZipCode(liabilityzipcode);
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
  return liability;
 }

public Liability getLiability(String liabilityname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Liability liability = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, liabilityname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("LiabilityId");
      liabilityname = resultSet.getString("LIABILITYNAME");
      String liabilityaddress = resultSet.getString("LIABILITYADDRESS");
      String liabilitycity = resultSet.getString("LIABILITYCITY");
      String liabilitystate = resultSet.getString("LIABILITYSTATE");
      String liabilitycountry = resultSet.getString("LIABILITYCOUNTRY");
      String liabilityzipcode = resultSet.getString("LIABILITYZIPCODE");
      liability = new Liability();
      liability.setLiabilityId(id);
      liability.setLiabilityName(liabilityname);
      liability.setLiabilityAddress(liabilityaddress);
      liability.setLiabilityCity(liabilitycity);
      liability.setLiabilityState(liabilitystate);
      liability.setLiabilityCountry(liabilitycountry);
      liability.setLiabilityZipCode(liabilityzipcode);
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
  return liability;
 }

public void deleteLiability(Liability liability)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, liability.getLiabilityId());
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

public void insertLiability(Liability liability)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,liability.getLiabilityName());
    preparedStatement.setString(3,liability.getLiabilityAddress());
    preparedStatement.setString(4,liability.getLiabilityCity());
    preparedStatement.setString(5,liability.getLiabilityState());
    preparedStatement.setString(6,liability.getLiabilityCountry());
    preparedStatement.setString(7,liability.getLiabilityZipCode());
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

public void updateLiability(Liability liability)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,liability.getLiabilityName());
    preparedStatement.setString(2,liability.getLiabilityAddress());
    preparedStatement.setString(3,liability.getLiabilityCity());
    preparedStatement.setString(4,liability.getLiabilityState());
    preparedStatement.setString(5,liability.getLiabilityCountry());
    preparedStatement.setString(6,liability.getLiabilityZipCode());
    preparedStatement.setInt(7, liability.getLiabilityId());
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

public List<Liability> getLiabilitys( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Liability> liabilityList = new ArrayList<Liability>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("LIABILITYID");
      String liabilityname = resultSet.getString("LIABILITYNAME");
      String liabilityaddress = resultSet.getString("LIABILITYADDRESS");
      String liabilitycity = resultSet.getString("LIABILITYCITY");
      String liabilitystate = resultSet.getString("LIABILITYSTATE");
      String liabilitycountry = resultSet.getString("LIABILITYCOUNTRY");
      String liabilityzipcode = resultSet.getString("LIABILITYZIPCODE");
      Liability liability = new Liability();
      liability.setLiabilityId(id);
      liability.setLiabilityName(liabilityname);
      liability.setLiabilityAddress(liabilityaddress);
      liability.setLiabilityCity(liabilitycity);
      liability.setLiabilityState(liabilitystate);
      liability.setLiabilityCountry(liabilitycountry);
      liability.setLiabilityZipCode(liabilityzipcode);
       liabilityList.add(liability);
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
  return liabilityList;
 }

public static void main( String[] args ) {
}

} 

