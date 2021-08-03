package org.aicoder.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Settlement;
import org.archcorner.chartreuse.util.JDBCManager;

public class SettlementDAO{ 


private String highestIDSQL = "SELECT MAX(SETTLEMENTID) AS MAXSETTLEMENTID FROM SETTLEMENT";
private String selectSQL = "SELECT * FROM SETTLEMENT WHERE SETTLEMENTNAME=?";
private String selectIdSQL = "SELECT * FROM SETTLEMENT WHERE SETTLEMENTID=?";
private String insertSQL = "INSERT INTO SETTLEMENT(SETTLEMENTID,SETTLEMENTNAME,SETTLEMENTADDRESS,SETTLEMENTCITY,SETTLEMENTSTATE,SETTLEMENTCOUNTRY,SETTLEMENTZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE SETTLEMENT SET SETTLEMENTNAME=?,SETTLEMENTADDRESS=?,SETTLEMENTCITY=?,SETTLEMENTSTATE=?,SETTLEMENTCOUNTRY=?,SETTLEMENTZIPCODE=? WHERE SETTLEMENTID=?";
private String deleteSQL = "DELETE FROM SETTLEMENT WHERE SETTLEMENTID=?";
private String selectAllSQL = "SELECT * FROM SETTLEMENT";

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
    highestId = resultSet.getInt("MAXSETTLEMENTID");
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

public Settlement getSettlementById(int settlementid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Settlement settlement = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, settlementid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("settlementid");
      String settlementname = resultSet.getString("SETTLEMENTNAME");
      String settlementaddress = resultSet.getString("SETTLEMENTADDRESS");
      String settlementcity = resultSet.getString("SETTLEMENTCITY");
      String settlementstate = resultSet.getString("SETTLEMENTSTATE");
      String settlementcountry = resultSet.getString("SETTLEMENTCOUNTRY");
      String settlementzipcode = resultSet.getString("SETTLEMENTZIPCODE");
      settlement = new Settlement();
      settlement.setSettlementId(id);
      settlement.setSettlementName(settlementname);
      settlement.setSettlementAddress(settlementaddress);
      settlement.setSettlementCity(settlementcity);
      settlement.setSettlementState(settlementstate);
      settlement.setSettlementCountry(settlementcountry);
      settlement.setSettlementZipCode(settlementzipcode);
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
  return settlement;
 }

public Settlement getSettlement(String settlementname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Settlement settlement = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, settlementname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("SettlementId");
      settlementname = resultSet.getString("SETTLEMENTNAME");
      String settlementaddress = resultSet.getString("SETTLEMENTADDRESS");
      String settlementcity = resultSet.getString("SETTLEMENTCITY");
      String settlementstate = resultSet.getString("SETTLEMENTSTATE");
      String settlementcountry = resultSet.getString("SETTLEMENTCOUNTRY");
      String settlementzipcode = resultSet.getString("SETTLEMENTZIPCODE");
      settlement = new Settlement();
      settlement.setSettlementId(id);
      settlement.setSettlementName(settlementname);
      settlement.setSettlementAddress(settlementaddress);
      settlement.setSettlementCity(settlementcity);
      settlement.setSettlementState(settlementstate);
      settlement.setSettlementCountry(settlementcountry);
      settlement.setSettlementZipCode(settlementzipcode);
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
  return settlement;
 }

public void deleteSettlement(Settlement settlement)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, settlement.getSettlementId());
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

public void insertSettlement(Settlement settlement)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,settlement.getSettlementName());
    preparedStatement.setString(3,settlement.getSettlementAddress());
    preparedStatement.setString(4,settlement.getSettlementCity());
    preparedStatement.setString(5,settlement.getSettlementState());
    preparedStatement.setString(6,settlement.getSettlementCountry());
    preparedStatement.setString(7,settlement.getSettlementZipCode());
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

public void updateSettlement(Settlement settlement)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,settlement.getSettlementName());
    preparedStatement.setString(2,settlement.getSettlementAddress());
    preparedStatement.setString(3,settlement.getSettlementCity());
    preparedStatement.setString(4,settlement.getSettlementState());
    preparedStatement.setString(5,settlement.getSettlementCountry());
    preparedStatement.setString(6,settlement.getSettlementZipCode());
    preparedStatement.setInt(7, settlement.getSettlementId());
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

public List<Settlement> getSettlements( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Settlement> settlementList = new ArrayList<Settlement>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("SETTLEMENTID");
      String settlementname = resultSet.getString("SETTLEMENTNAME");
      String settlementaddress = resultSet.getString("SETTLEMENTADDRESS");
      String settlementcity = resultSet.getString("SETTLEMENTCITY");
      String settlementstate = resultSet.getString("SETTLEMENTSTATE");
      String settlementcountry = resultSet.getString("SETTLEMENTCOUNTRY");
      String settlementzipcode = resultSet.getString("SETTLEMENTZIPCODE");
      Settlement settlement = new Settlement();
      settlement.setSettlementId(id);
      settlement.setSettlementName(settlementname);
      settlement.setSettlementAddress(settlementaddress);
      settlement.setSettlementCity(settlementcity);
      settlement.setSettlementState(settlementstate);
      settlement.setSettlementCountry(settlementcountry);
      settlement.setSettlementZipCode(settlementzipcode);
       settlementList.add(settlement);
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
  return settlementList;
 }

public static void main( String[] args ) {
}

} 

