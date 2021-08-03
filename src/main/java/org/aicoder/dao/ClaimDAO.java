package org.aicoder.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Claim;
import org.archcorner.chartreuse.util.JDBCManager;

public class ClaimDAO{ 


private String highestIDSQL = "SELECT MAX(CLAIMID) AS MAXCLAIMID FROM CLAIM";
private String selectSQL = "SELECT * FROM CLAIM WHERE CLAIMNAME=?";
private String selectIdSQL = "SELECT * FROM CLAIM WHERE CLAIMID=?";
private String insertSQL = "INSERT INTO CLAIM(CLAIMID,CLAIMNAME,CLAIMADDRESS,CLAIMCITY,CLAIMSTATE,CLAIMCOUNTRY,CLAIMZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE CLAIM SET CLAIMNAME=?,CLAIMADDRESS=?,CLAIMCITY=?,CLAIMSTATE=?,CLAIMCOUNTRY=?,CLAIMZIPCODE=? WHERE CLAIMID=?";
private String deleteSQL = "DELETE FROM CLAIM WHERE CLAIMID=?";
private String selectAllSQL = "SELECT * FROM CLAIM";

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
    highestId = resultSet.getInt("MAXCLAIMID");
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

public Claim getClaimById(int claimid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Claim claim = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, claimid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("claimid");
      String claimname = resultSet.getString("CLAIMNAME");
      String claimaddress = resultSet.getString("CLAIMADDRESS");
      String claimcity = resultSet.getString("CLAIMCITY");
      String claimstate = resultSet.getString("CLAIMSTATE");
      String claimcountry = resultSet.getString("CLAIMCOUNTRY");
      String claimzipcode = resultSet.getString("CLAIMZIPCODE");
      claim = new Claim();
      claim.setClaimId(id);
      claim.setClaimName(claimname);
      claim.setClaimAddress(claimaddress);
      claim.setClaimCity(claimcity);
      claim.setClaimState(claimstate);
      claim.setClaimCountry(claimcountry);
      claim.setClaimZipCode(claimzipcode);
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
  return claim;
 }

public Claim getClaim(String claimname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Claim claim = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, claimname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("ClaimId");
      claimname = resultSet.getString("CLAIMNAME");
      String claimaddress = resultSet.getString("CLAIMADDRESS");
      String claimcity = resultSet.getString("CLAIMCITY");
      String claimstate = resultSet.getString("CLAIMSTATE");
      String claimcountry = resultSet.getString("CLAIMCOUNTRY");
      String claimzipcode = resultSet.getString("CLAIMZIPCODE");
      claim = new Claim();
      claim.setClaimId(id);
      claim.setClaimName(claimname);
      claim.setClaimAddress(claimaddress);
      claim.setClaimCity(claimcity);
      claim.setClaimState(claimstate);
      claim.setClaimCountry(claimcountry);
      claim.setClaimZipCode(claimzipcode);
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
  return claim;
 }

public void deleteClaim(Claim claim)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, claim.getClaimId());
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

public void insertClaim(Claim claim)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,claim.getClaimName());
    preparedStatement.setString(3,claim.getClaimAddress());
    preparedStatement.setString(4,claim.getClaimCity());
    preparedStatement.setString(5,claim.getClaimState());
    preparedStatement.setString(6,claim.getClaimCountry());
    preparedStatement.setString(7,claim.getClaimZipCode());
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

public void updateClaim(Claim claim)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,claim.getClaimName());
    preparedStatement.setString(2,claim.getClaimAddress());
    preparedStatement.setString(3,claim.getClaimCity());
    preparedStatement.setString(4,claim.getClaimState());
    preparedStatement.setString(5,claim.getClaimCountry());
    preparedStatement.setString(6,claim.getClaimZipCode());
    preparedStatement.setInt(7, claim.getClaimId());
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

public List<Claim> getClaims( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Claim> claimList = new ArrayList<Claim>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("CLAIMID");
      String claimname = resultSet.getString("CLAIMNAME");
      String claimaddress = resultSet.getString("CLAIMADDRESS");
      String claimcity = resultSet.getString("CLAIMCITY");
      String claimstate = resultSet.getString("CLAIMSTATE");
      String claimcountry = resultSet.getString("CLAIMCOUNTRY");
      String claimzipcode = resultSet.getString("CLAIMZIPCODE");
      Claim claim = new Claim();
      claim.setClaimId(id);
      claim.setClaimName(claimname);
      claim.setClaimAddress(claimaddress);
      claim.setClaimCity(claimcity);
      claim.setClaimState(claimstate);
      claim.setClaimCountry(claimcountry);
      claim.setClaimZipCode(claimzipcode);
       claimList.add(claim);
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
  return claimList;
 }

public static void main( String[] args ) {
}

} 

