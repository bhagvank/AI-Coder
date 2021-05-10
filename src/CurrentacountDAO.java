import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Currentacount;
import org.archcorner.chartreuse.util.JDBCManager;

public class CurrentacountDAO{ 


private String highestIDSQL = "SELECT MAX(CURRENTACOUNTID) AS MAXCURRENTACOUNTID FROM CURRENTACOUNT";
private String selectSQL = "SELECT * FROM CURRENTACOUNT WHERE CURRENTACOUNTNAME=?";
private String selectIdSQL = "SELECT * FROM CURRENTACOUNT WHERE CURRENTACOUNTID=?";
private String insertSQL = "INSERT INTO CURRENTACOUNT(CURRENTACOUNTID,CURRENTACOUNTNAME,CURRENTACOUNTADDRESS,CURRENTACOUNTCITY,CURRENTACOUNTSTATE,CURRENTACOUNTCOUNTRY,CURRENTACOUNTZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE CURRENTACOUNT SET CURRENTACOUNTNAME=?,CURRENTACOUNTADDRESS=?,CURRENTACOUNTCITY=?,CURRENTACOUNTSTATE=?,CURRENTACOUNTCOUNTRY=?,CURRENTACOUNTZIPCODE=? WHERE CURRENTACOUNTID=?";
private String deleteSQL = "DELETE FROM CURRENTACOUNT WHERE CURRENTACOUNTID=?";
private String selectAllSQL = "SELECT * FROM CURRENTACOUNT";

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
    highestId = resultSet.getInt("MAXCURRENTACOUNTID");
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

public Currentacount getCurrentacountById(int currentacountid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Currentacount currentacount = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, currentacountid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("currentacountid");
      String currentacountname = resultSet.getString("CURRENTACOUNTNAME");
      String currentacountaddress = resultSet.getString("CURRENTACOUNTADDRESS");
      String currentacountcity = resultSet.getString("CURRENTACOUNTCITY");
      String currentacountstate = resultSet.getString("CURRENTACOUNTSTATE");
      String currentacountcountry = resultSet.getString("CURRENTACOUNTCOUNTRY");
      String currentacountzipcode = resultSet.getString("CURRENTACOUNTZIPCODE");
      currentacount = new Currentacount();
      currentacount.setCurrentacountId(id);
      currentacount.setCurrentacountName(currentacountname);
      currentacount.setCurrentacountAddress(currentacountaddress);
      currentacount.setCurrentacountCity(currentacountcity);
      currentacount.setCurrentacountState(currentacountstate);
      currentacount.setCurrentacountCountry(currentacountcountry);
      currentacount.setCurrentacountZipCode(currentacountzipcode);
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
  return currentacount;
 }

public Currentacount getCurrentacount(String currentacountname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Currentacount currentacount = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, currentacountname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("CurrentacountId");
      currentacountname = resultSet.getString("CURRENTACOUNTNAME");
      String currentacountaddress = resultSet.getString("CURRENTACOUNTADDRESS");
      String currentacountcity = resultSet.getString("CURRENTACOUNTCITY");
      String currentacountstate = resultSet.getString("CURRENTACOUNTSTATE");
      String currentacountcountry = resultSet.getString("CURRENTACOUNTCOUNTRY");
      String currentacountzipcode = resultSet.getString("CURRENTACOUNTZIPCODE");
      currentacount = new Currentacount();
      currentacount.setCurrentacountId(id);
      currentacount.setCurrentacountName(currentacountname);
      currentacount.setCurrentacountAddress(currentacountaddress);
      currentacount.setCurrentacountCity(currentacountcity);
      currentacount.setCurrentacountState(currentacountstate);
      currentacount.setCurrentacountCountry(currentacountcountry);
      currentacount.setCurrentacountZipCode(currentacountzipcode);
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
  return currentacount;
 }

public void deleteCurrentacount(Currentacount currentacount)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, currentacount.getCurrentacountId());
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

public void insertCurrentacount(Currentacount currentacount)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,currentacount.getCurrentacountName());
    preparedStatement.setString(3,currentacount.getCurrentacountAddress());
    preparedStatement.setString(4,currentacount.getCurrentacountCity());
    preparedStatement.setString(5,currentacount.getCurrentacountState());
    preparedStatement.setString(6,currentacount.getCurrentacountCountry());
    preparedStatement.setString(7,currentacount.getCurrentacountZipCode());
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

public void updateCurrentacount(Currentacount currentacount)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,currentacount.getCurrentacountName());
    preparedStatement.setString(2,currentacount.getCurrentacountAddress());
    preparedStatement.setString(3,currentacount.getCurrentacountCity());
    preparedStatement.setString(4,currentacount.getCurrentacountState());
    preparedStatement.setString(5,currentacount.getCurrentacountCountry());
    preparedStatement.setString(6,currentacount.getCurrentacountZipCode());
    preparedStatement.setInt(7, currentacount.getCurrentacountId());
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

public List<Currentacount> getCurrentacounts( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Currentacount> currentacountList = new ArrayList<Currentacount>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("CURRENTACOUNTID");
      String currentacountname = resultSet.getString("CURRENTACOUNTNAME");
      String currentacountaddress = resultSet.getString("CURRENTACOUNTADDRESS");
      String currentacountcity = resultSet.getString("CURRENTACOUNTCITY");
      String currentacountstate = resultSet.getString("CURRENTACOUNTSTATE");
      String currentacountcountry = resultSet.getString("CURRENTACOUNTCOUNTRY");
      String currentacountzipcode = resultSet.getString("CURRENTACOUNTZIPCODE");
      Currentacount currentacount = new Currentacount();
      currentacount.setCurrentacountId(id);
      currentacount.setCurrentacountName(currentacountname);
      currentacount.setCurrentacountAddress(currentacountaddress);
      currentacount.setCurrentacountCity(currentacountcity);
      currentacount.setCurrentacountState(currentacountstate);
      currentacount.setCurrentacountCountry(currentacountcountry);
      currentacount.setCurrentacountZipCode(currentacountzipcode);
       currentacountList.add(currentacount);
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
  return currentacountList;
 }

public static void main( String[] args ) {
}

} 

