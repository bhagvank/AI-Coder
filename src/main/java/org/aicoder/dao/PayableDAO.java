package org.aicoder.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Payable;
import org.archcorner.chartreuse.util.JDBCManager;

public class PayableDAO{ 


private String highestIDSQL = "SELECT MAX(PAYABLEID) AS MAXPAYABLEID FROM PAYABLE";
private String selectSQL = "SELECT * FROM PAYABLE WHERE PAYABLENAME=?";
private String selectIdSQL = "SELECT * FROM PAYABLE WHERE PAYABLEID=?";
private String insertSQL = "INSERT INTO PAYABLE(PAYABLEID,PAYABLENAME,PAYABLEADDRESS,PAYABLECITY,PAYABLESTATE,PAYABLECOUNTRY,PAYABLEZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE PAYABLE SET PAYABLENAME=?,PAYABLEADDRESS=?,PAYABLECITY=?,PAYABLESTATE=?,PAYABLECOUNTRY=?,PAYABLEZIPCODE=? WHERE PAYABLEID=?";
private String deleteSQL = "DELETE FROM PAYABLE WHERE PAYABLEID=?";
private String selectAllSQL = "SELECT * FROM PAYABLE";

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
    highestId = resultSet.getInt("MAXPAYABLEID");
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

public Payable getPayableById(int payableid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Payable payable = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, payableid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("payableid");
      String payablename = resultSet.getString("PAYABLENAME");
      String payableaddress = resultSet.getString("PAYABLEADDRESS");
      String payablecity = resultSet.getString("PAYABLECITY");
      String payablestate = resultSet.getString("PAYABLESTATE");
      String payablecountry = resultSet.getString("PAYABLECOUNTRY");
      String payablezipcode = resultSet.getString("PAYABLEZIPCODE");
      payable = new Payable();
      payable.setPayableId(id);
      payable.setPayableName(payablename);
      payable.setPayableAddress(payableaddress);
      payable.setPayableCity(payablecity);
      payable.setPayableState(payablestate);
      payable.setPayableCountry(payablecountry);
      payable.setPayableZipCode(payablezipcode);
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
  return payable;
 }

public Payable getPayable(String payablename)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Payable payable = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, payablename);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("PayableId");
      payablename = resultSet.getString("PAYABLENAME");
      String payableaddress = resultSet.getString("PAYABLEADDRESS");
      String payablecity = resultSet.getString("PAYABLECITY");
      String payablestate = resultSet.getString("PAYABLESTATE");
      String payablecountry = resultSet.getString("PAYABLECOUNTRY");
      String payablezipcode = resultSet.getString("PAYABLEZIPCODE");
      payable = new Payable();
      payable.setPayableId(id);
      payable.setPayableName(payablename);
      payable.setPayableAddress(payableaddress);
      payable.setPayableCity(payablecity);
      payable.setPayableState(payablestate);
      payable.setPayableCountry(payablecountry);
      payable.setPayableZipCode(payablezipcode);
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
  return payable;
 }

public void deletePayable(Payable payable)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, payable.getPayableId());
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

public void insertPayable(Payable payable)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,payable.getPayableName());
    preparedStatement.setString(3,payable.getPayableAddress());
    preparedStatement.setString(4,payable.getPayableCity());
    preparedStatement.setString(5,payable.getPayableState());
    preparedStatement.setString(6,payable.getPayableCountry());
    preparedStatement.setString(7,payable.getPayableZipCode());
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

public void updatePayable(Payable payable)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,payable.getPayableName());
    preparedStatement.setString(2,payable.getPayableAddress());
    preparedStatement.setString(3,payable.getPayableCity());
    preparedStatement.setString(4,payable.getPayableState());
    preparedStatement.setString(5,payable.getPayableCountry());
    preparedStatement.setString(6,payable.getPayableZipCode());
    preparedStatement.setInt(7, payable.getPayableId());
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

public List<Payable> getPayables( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Payable> payableList = new ArrayList<Payable>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("PAYABLEID");
      String payablename = resultSet.getString("PAYABLENAME");
      String payableaddress = resultSet.getString("PAYABLEADDRESS");
      String payablecity = resultSet.getString("PAYABLECITY");
      String payablestate = resultSet.getString("PAYABLESTATE");
      String payablecountry = resultSet.getString("PAYABLECOUNTRY");
      String payablezipcode = resultSet.getString("PAYABLEZIPCODE");
      Payable payable = new Payable();
      payable.setPayableId(id);
      payable.setPayableName(payablename);
      payable.setPayableAddress(payableaddress);
      payable.setPayableCity(payablecity);
      payable.setPayableState(payablestate);
      payable.setPayableCountry(payablecountry);
      payable.setPayableZipCode(payablezipcode);
       payableList.add(payable);
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
  return payableList;
 }

public static void main( String[] args ) {
}

} 

