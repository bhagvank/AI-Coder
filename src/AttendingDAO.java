import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Attending;
import org.archcorner.chartreuse.util.JDBCManager;

public class AttendingDAO{ 


private String highestIDSQL = "SELECT MAX(ATTENDINGID) AS MAXATTENDINGID FROM ATTENDING";
private String selectSQL = "SELECT * FROM ATTENDING WHERE ATTENDINGNAME=?";
private String selectIdSQL = "SELECT * FROM ATTENDING WHERE ATTENDINGID=?";
private String insertSQL = "INSERT INTO ATTENDING(ATTENDINGID,ATTENDINGNAME,ATTENDINGADDRESS,ATTENDINGCITY,ATTENDINGSTATE,ATTENDINGCOUNTRY,ATTENDINGZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE ATTENDING SET ATTENDINGNAME=?,ATTENDINGADDRESS=?,ATTENDINGCITY=?,ATTENDINGSTATE=?,ATTENDINGCOUNTRY=?,ATTENDINGZIPCODE=? WHERE ATTENDINGID=?";
private String deleteSQL = "DELETE FROM ATTENDING WHERE ATTENDINGID=?";
private String selectAllSQL = "SELECT * FROM ATTENDING";

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
    highestId = resultSet.getInt("MAXATTENDINGID");
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

public Attending getAttendingById(int attendingid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Attending attending = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, attendingid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("attendingid");
      String attendingname = resultSet.getString("ATTENDINGNAME");
      String attendingaddress = resultSet.getString("ATTENDINGADDRESS");
      String attendingcity = resultSet.getString("ATTENDINGCITY");
      String attendingstate = resultSet.getString("ATTENDINGSTATE");
      String attendingcountry = resultSet.getString("ATTENDINGCOUNTRY");
      String attendingzipcode = resultSet.getString("ATTENDINGZIPCODE");
      attending = new Attending();
      attending.setAttendingId(id);
      attending.setAttendingName(attendingname);
      attending.setAttendingAddress(attendingaddress);
      attending.setAttendingCity(attendingcity);
      attending.setAttendingState(attendingstate);
      attending.setAttendingCountry(attendingcountry);
      attending.setAttendingZipCode(attendingzipcode);
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
  return attending;
 }

public Attending getAttending(String attendingname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Attending attending = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, attendingname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("AttendingId");
      attendingname = resultSet.getString("ATTENDINGNAME");
      String attendingaddress = resultSet.getString("ATTENDINGADDRESS");
      String attendingcity = resultSet.getString("ATTENDINGCITY");
      String attendingstate = resultSet.getString("ATTENDINGSTATE");
      String attendingcountry = resultSet.getString("ATTENDINGCOUNTRY");
      String attendingzipcode = resultSet.getString("ATTENDINGZIPCODE");
      attending = new Attending();
      attending.setAttendingId(id);
      attending.setAttendingName(attendingname);
      attending.setAttendingAddress(attendingaddress);
      attending.setAttendingCity(attendingcity);
      attending.setAttendingState(attendingstate);
      attending.setAttendingCountry(attendingcountry);
      attending.setAttendingZipCode(attendingzipcode);
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
  return attending;
 }

public void deleteAttending(Attending attending)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, attending.getAttendingId());
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

public void insertAttending(Attending attending)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,attending.getAttendingName());
    preparedStatement.setString(3,attending.getAttendingAddress());
    preparedStatement.setString(4,attending.getAttendingCity());
    preparedStatement.setString(5,attending.getAttendingState());
    preparedStatement.setString(6,attending.getAttendingCountry());
    preparedStatement.setString(7,attending.getAttendingZipCode());
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

public void updateAttending(Attending attending)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,attending.getAttendingName());
    preparedStatement.setString(2,attending.getAttendingAddress());
    preparedStatement.setString(3,attending.getAttendingCity());
    preparedStatement.setString(4,attending.getAttendingState());
    preparedStatement.setString(5,attending.getAttendingCountry());
    preparedStatement.setString(6,attending.getAttendingZipCode());
    preparedStatement.setInt(7, attending.getAttendingId());
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

public List<Attending> getAttendings( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Attending> attendingList = new ArrayList<Attending>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("ATTENDINGID");
      String attendingname = resultSet.getString("ATTENDINGNAME");
      String attendingaddress = resultSet.getString("ATTENDINGADDRESS");
      String attendingcity = resultSet.getString("ATTENDINGCITY");
      String attendingstate = resultSet.getString("ATTENDINGSTATE");
      String attendingcountry = resultSet.getString("ATTENDINGCOUNTRY");
      String attendingzipcode = resultSet.getString("ATTENDINGZIPCODE");
      Attending attending = new Attending();
      attending.setAttendingId(id);
      attending.setAttendingName(attendingname);
      attending.setAttendingAddress(attendingaddress);
      attending.setAttendingCity(attendingcity);
      attending.setAttendingState(attendingstate);
      attending.setAttendingCountry(attendingcountry);
      attending.setAttendingZipCode(attendingzipcode);
       attendingList.add(attending);
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
  return attendingList;
 }

public static void main( String[] args ) {
}

} 

