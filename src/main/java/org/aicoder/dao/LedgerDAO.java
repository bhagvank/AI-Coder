package org.aicoder.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Ledger;
import org.archcorner.chartreuse.util.JDBCManager;

public class LedgerDAO{ 


private String highestIDSQL = "SELECT MAX(LEDGERID) AS MAXLEDGERID FROM LEDGER";
private String selectSQL = "SELECT * FROM LEDGER WHERE LEDGERNAME=?";
private String selectIdSQL = "SELECT * FROM LEDGER WHERE LEDGERID=?";
private String insertSQL = "INSERT INTO LEDGER(LEDGERID,LEDGERNAME,LEDGERADDRESS,LEDGERCITY,LEDGERSTATE,LEDGERCOUNTRY,LEDGERZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE LEDGER SET LEDGERNAME=?,LEDGERADDRESS=?,LEDGERCITY=?,LEDGERSTATE=?,LEDGERCOUNTRY=?,LEDGERZIPCODE=? WHERE LEDGERID=?";
private String deleteSQL = "DELETE FROM LEDGER WHERE LEDGERID=?";
private String selectAllSQL = "SELECT * FROM LEDGER";

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
    highestId = resultSet.getInt("MAXLEDGERID");
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

public Ledger getLedgerById(int ledgerid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Ledger ledger = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, ledgerid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("ledgerid");
      String ledgername = resultSet.getString("LEDGERNAME");
      String ledgeraddress = resultSet.getString("LEDGERADDRESS");
      String ledgercity = resultSet.getString("LEDGERCITY");
      String ledgerstate = resultSet.getString("LEDGERSTATE");
      String ledgercountry = resultSet.getString("LEDGERCOUNTRY");
      String ledgerzipcode = resultSet.getString("LEDGERZIPCODE");
      ledger = new Ledger();
      ledger.setLedgerId(id);
      ledger.setLedgerName(ledgername);
      ledger.setLedgerAddress(ledgeraddress);
      ledger.setLedgerCity(ledgercity);
      ledger.setLedgerState(ledgerstate);
      ledger.setLedgerCountry(ledgercountry);
      ledger.setLedgerZipCode(ledgerzipcode);
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
  return ledger;
 }

public Ledger getLedger(String ledgername)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Ledger ledger = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, ledgername);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("LedgerId");
      ledgername = resultSet.getString("LEDGERNAME");
      String ledgeraddress = resultSet.getString("LEDGERADDRESS");
      String ledgercity = resultSet.getString("LEDGERCITY");
      String ledgerstate = resultSet.getString("LEDGERSTATE");
      String ledgercountry = resultSet.getString("LEDGERCOUNTRY");
      String ledgerzipcode = resultSet.getString("LEDGERZIPCODE");
      ledger = new Ledger();
      ledger.setLedgerId(id);
      ledger.setLedgerName(ledgername);
      ledger.setLedgerAddress(ledgeraddress);
      ledger.setLedgerCity(ledgercity);
      ledger.setLedgerState(ledgerstate);
      ledger.setLedgerCountry(ledgercountry);
      ledger.setLedgerZipCode(ledgerzipcode);
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
  return ledger;
 }

public void deleteLedger(Ledger ledger)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, ledger.getLedgerId());
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

public void insertLedger(Ledger ledger)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,ledger.getLedgerName());
    preparedStatement.setString(3,ledger.getLedgerAddress());
    preparedStatement.setString(4,ledger.getLedgerCity());
    preparedStatement.setString(5,ledger.getLedgerState());
    preparedStatement.setString(6,ledger.getLedgerCountry());
    preparedStatement.setString(7,ledger.getLedgerZipCode());
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

public void updateLedger(Ledger ledger)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,ledger.getLedgerName());
    preparedStatement.setString(2,ledger.getLedgerAddress());
    preparedStatement.setString(3,ledger.getLedgerCity());
    preparedStatement.setString(4,ledger.getLedgerState());
    preparedStatement.setString(5,ledger.getLedgerCountry());
    preparedStatement.setString(6,ledger.getLedgerZipCode());
    preparedStatement.setInt(7, ledger.getLedgerId());
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

public List<Ledger> getLedgers( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Ledger> ledgerList = new ArrayList<Ledger>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("LEDGERID");
      String ledgername = resultSet.getString("LEDGERNAME");
      String ledgeraddress = resultSet.getString("LEDGERADDRESS");
      String ledgercity = resultSet.getString("LEDGERCITY");
      String ledgerstate = resultSet.getString("LEDGERSTATE");
      String ledgercountry = resultSet.getString("LEDGERCOUNTRY");
      String ledgerzipcode = resultSet.getString("LEDGERZIPCODE");
      Ledger ledger = new Ledger();
      ledger.setLedgerId(id);
      ledger.setLedgerName(ledgername);
      ledger.setLedgerAddress(ledgeraddress);
      ledger.setLedgerCity(ledgercity);
      ledger.setLedgerState(ledgerstate);
      ledger.setLedgerCountry(ledgercountry);
      ledger.setLedgerZipCode(ledgerzipcode);
       ledgerList.add(ledger);
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
  return ledgerList;
 }

public static void main( String[] args ) {
}

} 

