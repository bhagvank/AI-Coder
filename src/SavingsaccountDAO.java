import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Savingsaccount;
import org.archcorner.chartreuse.util.JDBCManager;

public class SavingsaccountDAO{ 


private String highestIDSQL = "SELECT MAX(SAVINGSACCOUNTID) AS MAXSAVINGSACCOUNTID FROM SAVINGSACCOUNT";
private String selectSQL = "SELECT * FROM SAVINGSACCOUNT WHERE SAVINGSACCOUNTNAME=?";
private String selectIdSQL = "SELECT * FROM SAVINGSACCOUNT WHERE SAVINGSACCOUNTID=?";
private String insertSQL = "INSERT INTO SAVINGSACCOUNT(SAVINGSACCOUNTID,SAVINGSACCOUNTNAME,SAVINGSACCOUNTADDRESS,SAVINGSACCOUNTCITY,SAVINGSACCOUNTSTATE,SAVINGSACCOUNTCOUNTRY,SAVINGSACCOUNTZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE SAVINGSACCOUNT SET SAVINGSACCOUNTNAME=?,SAVINGSACCOUNTADDRESS=?,SAVINGSACCOUNTCITY=?,SAVINGSACCOUNTSTATE=?,SAVINGSACCOUNTCOUNTRY=?,SAVINGSACCOUNTZIPCODE=? WHERE SAVINGSACCOUNTID=?";
private String deleteSQL = "DELETE FROM SAVINGSACCOUNT WHERE SAVINGSACCOUNTID=?";
private String selectAllSQL = "SELECT * FROM SAVINGSACCOUNT";

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
    highestId = resultSet.getInt("MAXSAVINGSACCOUNTID");
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

public Savingsaccount getSavingsaccountById(int savingsaccountid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Savingsaccount savingsaccount = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, savingsaccountid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("savingsaccountid");
      String savingsaccountname = resultSet.getString("SAVINGSACCOUNTNAME");
      String savingsaccountaddress = resultSet.getString("SAVINGSACCOUNTADDRESS");
      String savingsaccountcity = resultSet.getString("SAVINGSACCOUNTCITY");
      String savingsaccountstate = resultSet.getString("SAVINGSACCOUNTSTATE");
      String savingsaccountcountry = resultSet.getString("SAVINGSACCOUNTCOUNTRY");
      String savingsaccountzipcode = resultSet.getString("SAVINGSACCOUNTZIPCODE");
      savingsaccount = new Savingsaccount();
      savingsaccount.setSavingsaccountId(id);
      savingsaccount.setSavingsaccountName(savingsaccountname);
      savingsaccount.setSavingsaccountAddress(savingsaccountaddress);
      savingsaccount.setSavingsaccountCity(savingsaccountcity);
      savingsaccount.setSavingsaccountState(savingsaccountstate);
      savingsaccount.setSavingsaccountCountry(savingsaccountcountry);
      savingsaccount.setSavingsaccountZipCode(savingsaccountzipcode);
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
  return savingsaccount;
 }

public Savingsaccount getSavingsaccount(String savingsaccountname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Savingsaccount savingsaccount = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, savingsaccountname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("SavingsaccountId");
      savingsaccountname = resultSet.getString("SAVINGSACCOUNTNAME");
      String savingsaccountaddress = resultSet.getString("SAVINGSACCOUNTADDRESS");
      String savingsaccountcity = resultSet.getString("SAVINGSACCOUNTCITY");
      String savingsaccountstate = resultSet.getString("SAVINGSACCOUNTSTATE");
      String savingsaccountcountry = resultSet.getString("SAVINGSACCOUNTCOUNTRY");
      String savingsaccountzipcode = resultSet.getString("SAVINGSACCOUNTZIPCODE");
      savingsaccount = new Savingsaccount();
      savingsaccount.setSavingsaccountId(id);
      savingsaccount.setSavingsaccountName(savingsaccountname);
      savingsaccount.setSavingsaccountAddress(savingsaccountaddress);
      savingsaccount.setSavingsaccountCity(savingsaccountcity);
      savingsaccount.setSavingsaccountState(savingsaccountstate);
      savingsaccount.setSavingsaccountCountry(savingsaccountcountry);
      savingsaccount.setSavingsaccountZipCode(savingsaccountzipcode);
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
  return savingsaccount;
 }

public void deleteSavingsaccount(Savingsaccount savingsaccount)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, savingsaccount.getSavingsaccountId());
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

public void insertSavingsaccount(Savingsaccount savingsaccount)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,savingsaccount.getSavingsaccountName());
    preparedStatement.setString(3,savingsaccount.getSavingsaccountAddress());
    preparedStatement.setString(4,savingsaccount.getSavingsaccountCity());
    preparedStatement.setString(5,savingsaccount.getSavingsaccountState());
    preparedStatement.setString(6,savingsaccount.getSavingsaccountCountry());
    preparedStatement.setString(7,savingsaccount.getSavingsaccountZipCode());
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

public void updateSavingsaccount(Savingsaccount savingsaccount)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,savingsaccount.getSavingsaccountName());
    preparedStatement.setString(2,savingsaccount.getSavingsaccountAddress());
    preparedStatement.setString(3,savingsaccount.getSavingsaccountCity());
    preparedStatement.setString(4,savingsaccount.getSavingsaccountState());
    preparedStatement.setString(5,savingsaccount.getSavingsaccountCountry());
    preparedStatement.setString(6,savingsaccount.getSavingsaccountZipCode());
    preparedStatement.setInt(7, savingsaccount.getSavingsaccountId());
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

public List<Savingsaccount> getSavingsaccounts( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Savingsaccount> savingsaccountList = new ArrayList<Savingsaccount>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("SAVINGSACCOUNTID");
      String savingsaccountname = resultSet.getString("SAVINGSACCOUNTNAME");
      String savingsaccountaddress = resultSet.getString("SAVINGSACCOUNTADDRESS");
      String savingsaccountcity = resultSet.getString("SAVINGSACCOUNTCITY");
      String savingsaccountstate = resultSet.getString("SAVINGSACCOUNTSTATE");
      String savingsaccountcountry = resultSet.getString("SAVINGSACCOUNTCOUNTRY");
      String savingsaccountzipcode = resultSet.getString("SAVINGSACCOUNTZIPCODE");
      Savingsaccount savingsaccount = new Savingsaccount();
      savingsaccount.setSavingsaccountId(id);
      savingsaccount.setSavingsaccountName(savingsaccountname);
      savingsaccount.setSavingsaccountAddress(savingsaccountaddress);
      savingsaccount.setSavingsaccountCity(savingsaccountcity);
      savingsaccount.setSavingsaccountState(savingsaccountstate);
      savingsaccount.setSavingsaccountCountry(savingsaccountcountry);
      savingsaccount.setSavingsaccountZipCode(savingsaccountzipcode);
       savingsaccountList.add(savingsaccount);
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
  return savingsaccountList;
 }

public static void main( String[] args ) {
}

} 

