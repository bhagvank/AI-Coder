import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Exchangebill;
import org.archcorner.chartreuse.util.JDBCManager;

public class ExchangebillDAO{ 


private String highestIDSQL = "SELECT MAX(EXCHANGEBILLID) AS MAXEXCHANGEBILLID FROM EXCHANGEBILL";
private String selectSQL = "SELECT * FROM EXCHANGEBILL WHERE EXCHANGEBILLNAME=?";
private String selectIdSQL = "SELECT * FROM EXCHANGEBILL WHERE EXCHANGEBILLID=?";
private String insertSQL = "INSERT INTO EXCHANGEBILL(EXCHANGEBILLID,EXCHANGEBILLNAME,EXCHANGEBILLADDRESS,EXCHANGEBILLCITY,EXCHANGEBILLSTATE,EXCHANGEBILLCOUNTRY,EXCHANGEBILLZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE EXCHANGEBILL SET EXCHANGEBILLNAME=?,EXCHANGEBILLADDRESS=?,EXCHANGEBILLCITY=?,EXCHANGEBILLSTATE=?,EXCHANGEBILLCOUNTRY=?,EXCHANGEBILLZIPCODE=? WHERE EXCHANGEBILLID=?";
private String deleteSQL = "DELETE FROM EXCHANGEBILL WHERE EXCHANGEBILLID=?";
private String selectAllSQL = "SELECT * FROM EXCHANGEBILL";

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
    highestId = resultSet.getInt("MAXEXCHANGEBILLID");
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

public Exchangebill getExchangebillById(int exchangebillid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Exchangebill exchangebill = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, exchangebillid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("exchangebillid");
      String exchangebillname = resultSet.getString("EXCHANGEBILLNAME");
      String exchangebilladdress = resultSet.getString("EXCHANGEBILLADDRESS");
      String exchangebillcity = resultSet.getString("EXCHANGEBILLCITY");
      String exchangebillstate = resultSet.getString("EXCHANGEBILLSTATE");
      String exchangebillcountry = resultSet.getString("EXCHANGEBILLCOUNTRY");
      String exchangebillzipcode = resultSet.getString("EXCHANGEBILLZIPCODE");
      exchangebill = new Exchangebill();
      exchangebill.setExchangebillId(id);
      exchangebill.setExchangebillName(exchangebillname);
      exchangebill.setExchangebillAddress(exchangebilladdress);
      exchangebill.setExchangebillCity(exchangebillcity);
      exchangebill.setExchangebillState(exchangebillstate);
      exchangebill.setExchangebillCountry(exchangebillcountry);
      exchangebill.setExchangebillZipCode(exchangebillzipcode);
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
  return exchangebill;
 }

public Exchangebill getExchangebill(String exchangebillname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Exchangebill exchangebill = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, exchangebillname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("ExchangebillId");
      exchangebillname = resultSet.getString("EXCHANGEBILLNAME");
      String exchangebilladdress = resultSet.getString("EXCHANGEBILLADDRESS");
      String exchangebillcity = resultSet.getString("EXCHANGEBILLCITY");
      String exchangebillstate = resultSet.getString("EXCHANGEBILLSTATE");
      String exchangebillcountry = resultSet.getString("EXCHANGEBILLCOUNTRY");
      String exchangebillzipcode = resultSet.getString("EXCHANGEBILLZIPCODE");
      exchangebill = new Exchangebill();
      exchangebill.setExchangebillId(id);
      exchangebill.setExchangebillName(exchangebillname);
      exchangebill.setExchangebillAddress(exchangebilladdress);
      exchangebill.setExchangebillCity(exchangebillcity);
      exchangebill.setExchangebillState(exchangebillstate);
      exchangebill.setExchangebillCountry(exchangebillcountry);
      exchangebill.setExchangebillZipCode(exchangebillzipcode);
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
  return exchangebill;
 }

public void deleteExchangebill(Exchangebill exchangebill)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, exchangebill.getExchangebillId());
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

public void insertExchangebill(Exchangebill exchangebill)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,exchangebill.getExchangebillName());
    preparedStatement.setString(3,exchangebill.getExchangebillAddress());
    preparedStatement.setString(4,exchangebill.getExchangebillCity());
    preparedStatement.setString(5,exchangebill.getExchangebillState());
    preparedStatement.setString(6,exchangebill.getExchangebillCountry());
    preparedStatement.setString(7,exchangebill.getExchangebillZipCode());
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

public void updateExchangebill(Exchangebill exchangebill)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,exchangebill.getExchangebillName());
    preparedStatement.setString(2,exchangebill.getExchangebillAddress());
    preparedStatement.setString(3,exchangebill.getExchangebillCity());
    preparedStatement.setString(4,exchangebill.getExchangebillState());
    preparedStatement.setString(5,exchangebill.getExchangebillCountry());
    preparedStatement.setString(6,exchangebill.getExchangebillZipCode());
    preparedStatement.setInt(7, exchangebill.getExchangebillId());
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

public List<Exchangebill> getExchangebills( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Exchangebill> exchangebillList = new ArrayList<Exchangebill>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("EXCHANGEBILLID");
      String exchangebillname = resultSet.getString("EXCHANGEBILLNAME");
      String exchangebilladdress = resultSet.getString("EXCHANGEBILLADDRESS");
      String exchangebillcity = resultSet.getString("EXCHANGEBILLCITY");
      String exchangebillstate = resultSet.getString("EXCHANGEBILLSTATE");
      String exchangebillcountry = resultSet.getString("EXCHANGEBILLCOUNTRY");
      String exchangebillzipcode = resultSet.getString("EXCHANGEBILLZIPCODE");
      Exchangebill exchangebill = new Exchangebill();
      exchangebill.setExchangebillId(id);
      exchangebill.setExchangebillName(exchangebillname);
      exchangebill.setExchangebillAddress(exchangebilladdress);
      exchangebill.setExchangebillCity(exchangebillcity);
      exchangebill.setExchangebillState(exchangebillstate);
      exchangebill.setExchangebillCountry(exchangebillcountry);
      exchangebill.setExchangebillZipCode(exchangebillzipcode);
       exchangebillList.add(exchangebill);
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
  return exchangebillList;
 }

public static void main( String[] args ) {
}

} 

