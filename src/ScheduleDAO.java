import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Schedule;
import org.archcorner.chartreuse.util.JDBCManager;

public class ScheduleDAO{ 


private String highestIDSQL = "SELECT MAX(SCHEDULEID) AS MAXSCHEDULEID FROM SCHEDULE";
private String selectSQL = "SELECT * FROM SCHEDULE WHERE SCHEDULENAME=?";
private String selectIdSQL = "SELECT * FROM SCHEDULE WHERE SCHEDULEID=?";
private String insertSQL = "INSERT INTO SCHEDULE(SCHEDULEID,SCHEDULENAME,SCHEDULEADDRESS,SCHEDULECITY,SCHEDULESTATE,SCHEDULECOUNTRY,SCHEDULEZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE SCHEDULE SET SCHEDULENAME=?,SCHEDULEADDRESS=?,SCHEDULECITY=?,SCHEDULESTATE=?,SCHEDULECOUNTRY=?,SCHEDULEZIPCODE=? WHERE SCHEDULEID=?";
private String deleteSQL = "DELETE FROM SCHEDULE WHERE SCHEDULEID=?";
private String selectAllSQL = "SELECT * FROM SCHEDULE";

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
    highestId = resultSet.getInt("MAXSCHEDULEID");
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

public Schedule getScheduleById(int scheduleid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Schedule schedule = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, scheduleid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("scheduleid");
      String schedulename = resultSet.getString("SCHEDULENAME");
      String scheduleaddress = resultSet.getString("SCHEDULEADDRESS");
      String schedulecity = resultSet.getString("SCHEDULECITY");
      String schedulestate = resultSet.getString("SCHEDULESTATE");
      String schedulecountry = resultSet.getString("SCHEDULECOUNTRY");
      String schedulezipcode = resultSet.getString("SCHEDULEZIPCODE");
      schedule = new Schedule();
      schedule.setScheduleId(id);
      schedule.setScheduleName(schedulename);
      schedule.setScheduleAddress(scheduleaddress);
      schedule.setScheduleCity(schedulecity);
      schedule.setScheduleState(schedulestate);
      schedule.setScheduleCountry(schedulecountry);
      schedule.setScheduleZipCode(schedulezipcode);
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
  return schedule;
 }

public Schedule getSchedule(String schedulename)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Schedule schedule = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, schedulename);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("ScheduleId");
      schedulename = resultSet.getString("SCHEDULENAME");
      String scheduleaddress = resultSet.getString("SCHEDULEADDRESS");
      String schedulecity = resultSet.getString("SCHEDULECITY");
      String schedulestate = resultSet.getString("SCHEDULESTATE");
      String schedulecountry = resultSet.getString("SCHEDULECOUNTRY");
      String schedulezipcode = resultSet.getString("SCHEDULEZIPCODE");
      schedule = new Schedule();
      schedule.setScheduleId(id);
      schedule.setScheduleName(schedulename);
      schedule.setScheduleAddress(scheduleaddress);
      schedule.setScheduleCity(schedulecity);
      schedule.setScheduleState(schedulestate);
      schedule.setScheduleCountry(schedulecountry);
      schedule.setScheduleZipCode(schedulezipcode);
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
  return schedule;
 }

public void deleteSchedule(Schedule schedule)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, schedule.getScheduleId());
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

public void insertSchedule(Schedule schedule)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,schedule.getScheduleName());
    preparedStatement.setString(3,schedule.getScheduleAddress());
    preparedStatement.setString(4,schedule.getScheduleCity());
    preparedStatement.setString(5,schedule.getScheduleState());
    preparedStatement.setString(6,schedule.getScheduleCountry());
    preparedStatement.setString(7,schedule.getScheduleZipCode());
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

public void updateSchedule(Schedule schedule)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,schedule.getScheduleName());
    preparedStatement.setString(2,schedule.getScheduleAddress());
    preparedStatement.setString(3,schedule.getScheduleCity());
    preparedStatement.setString(4,schedule.getScheduleState());
    preparedStatement.setString(5,schedule.getScheduleCountry());
    preparedStatement.setString(6,schedule.getScheduleZipCode());
    preparedStatement.setInt(7, schedule.getScheduleId());
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

public List<Schedule> getSchedules( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Schedule> scheduleList = new ArrayList<Schedule>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("SCHEDULEID");
      String schedulename = resultSet.getString("SCHEDULENAME");
      String scheduleaddress = resultSet.getString("SCHEDULEADDRESS");
      String schedulecity = resultSet.getString("SCHEDULECITY");
      String schedulestate = resultSet.getString("SCHEDULESTATE");
      String schedulecountry = resultSet.getString("SCHEDULECOUNTRY");
      String schedulezipcode = resultSet.getString("SCHEDULEZIPCODE");
      Schedule schedule = new Schedule();
      schedule.setScheduleId(id);
      schedule.setScheduleName(schedulename);
      schedule.setScheduleAddress(scheduleaddress);
      schedule.setScheduleCity(schedulecity);
      schedule.setScheduleState(schedulestate);
      schedule.setScheduleCountry(schedulecountry);
      schedule.setScheduleZipCode(schedulezipcode);
       scheduleList.add(schedule);
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
  return scheduleList;
 }

public static void main( String[] args ) {
}

} 

