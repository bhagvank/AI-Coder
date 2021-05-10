import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Careteam;
import org.archcorner.chartreuse.util.JDBCManager;

public class CareteamDAO{ 


private String highestIDSQL = "SELECT MAX(CARETEAMID) AS MAXCARETEAMID FROM CARETEAM";
private String selectSQL = "SELECT * FROM CARETEAM WHERE CARETEAMNAME=?";
private String selectIdSQL = "SELECT * FROM CARETEAM WHERE CARETEAMID=?";
private String insertSQL = "INSERT INTO CARETEAM(CARETEAMID,CARETEAMNAME,CARETEAMADDRESS,CARETEAMCITY,CARETEAMSTATE,CARETEAMCOUNTRY,CARETEAMZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE CARETEAM SET CARETEAMNAME=?,CARETEAMADDRESS=?,CARETEAMCITY=?,CARETEAMSTATE=?,CARETEAMCOUNTRY=?,CARETEAMZIPCODE=? WHERE CARETEAMID=?";
private String deleteSQL = "DELETE FROM CARETEAM WHERE CARETEAMID=?";
private String selectAllSQL = "SELECT * FROM CARETEAM";

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
    highestId = resultSet.getInt("MAXCARETEAMID");
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

public Careteam getCareteamById(int careteamid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Careteam careteam = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, careteamid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("careteamid");
      String careteamname = resultSet.getString("CARETEAMNAME");
      String careteamaddress = resultSet.getString("CARETEAMADDRESS");
      String careteamcity = resultSet.getString("CARETEAMCITY");
      String careteamstate = resultSet.getString("CARETEAMSTATE");
      String careteamcountry = resultSet.getString("CARETEAMCOUNTRY");
      String careteamzipcode = resultSet.getString("CARETEAMZIPCODE");
      careteam = new Careteam();
      careteam.setCareteamId(id);
      careteam.setCareteamName(careteamname);
      careteam.setCareteamAddress(careteamaddress);
      careteam.setCareteamCity(careteamcity);
      careteam.setCareteamState(careteamstate);
      careteam.setCareteamCountry(careteamcountry);
      careteam.setCareteamZipCode(careteamzipcode);
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
  return careteam;
 }

public Careteam getCareteam(String careteamname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Careteam careteam = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, careteamname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("CareteamId");
      careteamname = resultSet.getString("CARETEAMNAME");
      String careteamaddress = resultSet.getString("CARETEAMADDRESS");
      String careteamcity = resultSet.getString("CARETEAMCITY");
      String careteamstate = resultSet.getString("CARETEAMSTATE");
      String careteamcountry = resultSet.getString("CARETEAMCOUNTRY");
      String careteamzipcode = resultSet.getString("CARETEAMZIPCODE");
      careteam = new Careteam();
      careteam.setCareteamId(id);
      careteam.setCareteamName(careteamname);
      careteam.setCareteamAddress(careteamaddress);
      careteam.setCareteamCity(careteamcity);
      careteam.setCareteamState(careteamstate);
      careteam.setCareteamCountry(careteamcountry);
      careteam.setCareteamZipCode(careteamzipcode);
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
  return careteam;
 }

public void deleteCareteam(Careteam careteam)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, careteam.getCareteamId());
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

public void insertCareteam(Careteam careteam)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,careteam.getCareteamName());
    preparedStatement.setString(3,careteam.getCareteamAddress());
    preparedStatement.setString(4,careteam.getCareteamCity());
    preparedStatement.setString(5,careteam.getCareteamState());
    preparedStatement.setString(6,careteam.getCareteamCountry());
    preparedStatement.setString(7,careteam.getCareteamZipCode());
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

public void updateCareteam(Careteam careteam)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,careteam.getCareteamName());
    preparedStatement.setString(2,careteam.getCareteamAddress());
    preparedStatement.setString(3,careteam.getCareteamCity());
    preparedStatement.setString(4,careteam.getCareteamState());
    preparedStatement.setString(5,careteam.getCareteamCountry());
    preparedStatement.setString(6,careteam.getCareteamZipCode());
    preparedStatement.setInt(7, careteam.getCareteamId());
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

public List<Careteam> getCareteams( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Careteam> careteamList = new ArrayList<Careteam>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("CARETEAMID");
      String careteamname = resultSet.getString("CARETEAMNAME");
      String careteamaddress = resultSet.getString("CARETEAMADDRESS");
      String careteamcity = resultSet.getString("CARETEAMCITY");
      String careteamstate = resultSet.getString("CARETEAMSTATE");
      String careteamcountry = resultSet.getString("CARETEAMCOUNTRY");
      String careteamzipcode = resultSet.getString("CARETEAMZIPCODE");
      Careteam careteam = new Careteam();
      careteam.setCareteamId(id);
      careteam.setCareteamName(careteamname);
      careteam.setCareteamAddress(careteamaddress);
      careteam.setCareteamCity(careteamcity);
      careteam.setCareteamState(careteamstate);
      careteam.setCareteamCountry(careteamcountry);
      careteam.setCareteamZipCode(careteamzipcode);
       careteamList.add(careteam);
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
  return careteamList;
 }

public static void main( String[] args ) {
}

} 

