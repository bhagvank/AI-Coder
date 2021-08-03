package org.aicoder.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Transaction;
import org.archcorner.chartreuse.util.JDBCManager;

public class TransactionDAO{ 


private String highestIDSQL = "SELECT MAX(TRANSACTIONID) AS MAXTRANSACTIONID FROM TRANSACTION";
private String selectSQL = "SELECT * FROM TRANSACTION WHERE TRANSACTIONNAME=?";
private String selectIdSQL = "SELECT * FROM TRANSACTION WHERE TRANSACTIONID=?";
private String insertSQL = "INSERT INTO TRANSACTION(TRANSACTIONID,TRANSACTIONNAME,TRANSACTIONADDRESS,TRANSACTIONCITY,TRANSACTIONSTATE,TRANSACTIONCOUNTRY,TRANSACTIONZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE TRANSACTION SET TRANSACTIONNAME=?,TRANSACTIONADDRESS=?,TRANSACTIONCITY=?,TRANSACTIONSTATE=?,TRANSACTIONCOUNTRY=?,TRANSACTIONZIPCODE=? WHERE TRANSACTIONID=?";
private String deleteSQL = "DELETE FROM TRANSACTION WHERE TRANSACTIONID=?";
private String selectAllSQL = "SELECT * FROM TRANSACTION";

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
    highestId = resultSet.getInt("MAXTRANSACTIONID");
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

public Transaction getTransactionById(int transactionid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Transaction transaction = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, transactionid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("transactionid");
      String transactionname = resultSet.getString("TRANSACTIONNAME");
      String transactionaddress = resultSet.getString("TRANSACTIONADDRESS");
      String transactioncity = resultSet.getString("TRANSACTIONCITY");
      String transactionstate = resultSet.getString("TRANSACTIONSTATE");
      String transactioncountry = resultSet.getString("TRANSACTIONCOUNTRY");
      String transactionzipcode = resultSet.getString("TRANSACTIONZIPCODE");
      transaction = new Transaction();
      transaction.setTransactionId(id);
      transaction.setTransactionName(transactionname);
      transaction.setTransactionAddress(transactionaddress);
      transaction.setTransactionCity(transactioncity);
      transaction.setTransactionState(transactionstate);
      transaction.setTransactionCountry(transactioncountry);
      transaction.setTransactionZipCode(transactionzipcode);
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
  return transaction;
 }

public Transaction getTransaction(String transactionname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Transaction transaction = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, transactionname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("TransactionId");
      transactionname = resultSet.getString("TRANSACTIONNAME");
      String transactionaddress = resultSet.getString("TRANSACTIONADDRESS");
      String transactioncity = resultSet.getString("TRANSACTIONCITY");
      String transactionstate = resultSet.getString("TRANSACTIONSTATE");
      String transactioncountry = resultSet.getString("TRANSACTIONCOUNTRY");
      String transactionzipcode = resultSet.getString("TRANSACTIONZIPCODE");
      transaction = new Transaction();
      transaction.setTransactionId(id);
      transaction.setTransactionName(transactionname);
      transaction.setTransactionAddress(transactionaddress);
      transaction.setTransactionCity(transactioncity);
      transaction.setTransactionState(transactionstate);
      transaction.setTransactionCountry(transactioncountry);
      transaction.setTransactionZipCode(transactionzipcode);
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
  return transaction;
 }

public void deleteTransaction(Transaction transaction)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, transaction.getTransactionId());
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

public void insertTransaction(Transaction transaction)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,transaction.getTransactionName());
    preparedStatement.setString(3,transaction.getTransactionAddress());
    preparedStatement.setString(4,transaction.getTransactionCity());
    preparedStatement.setString(5,transaction.getTransactionState());
    preparedStatement.setString(6,transaction.getTransactionCountry());
    preparedStatement.setString(7,transaction.getTransactionZipCode());
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

public void updateTransaction(Transaction transaction)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,transaction.getTransactionName());
    preparedStatement.setString(2,transaction.getTransactionAddress());
    preparedStatement.setString(3,transaction.getTransactionCity());
    preparedStatement.setString(4,transaction.getTransactionState());
    preparedStatement.setString(5,transaction.getTransactionCountry());
    preparedStatement.setString(6,transaction.getTransactionZipCode());
    preparedStatement.setInt(7, transaction.getTransactionId());
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

public List<Transaction> getTransactions( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Transaction> transactionList = new ArrayList<Transaction>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("TRANSACTIONID");
      String transactionname = resultSet.getString("TRANSACTIONNAME");
      String transactionaddress = resultSet.getString("TRANSACTIONADDRESS");
      String transactioncity = resultSet.getString("TRANSACTIONCITY");
      String transactionstate = resultSet.getString("TRANSACTIONSTATE");
      String transactioncountry = resultSet.getString("TRANSACTIONCOUNTRY");
      String transactionzipcode = resultSet.getString("TRANSACTIONZIPCODE");
      Transaction transaction = new Transaction();
      transaction.setTransactionId(id);
      transaction.setTransactionName(transactionname);
      transaction.setTransactionAddress(transactionaddress);
      transaction.setTransactionCity(transactioncity);
      transaction.setTransactionState(transactionstate);
      transaction.setTransactionCountry(transactioncountry);
      transaction.setTransactionZipCode(transactionzipcode);
       transactionList.add(transaction);
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
  return transactionList;
 }

public static void main( String[] args ) {
}

} 

