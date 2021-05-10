import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Event;
import org.archcorner.chartreuse.util.JDBCManager;

public class EventDAO{ 


private String highestIDSQL = "SELECT MAX(EVENTID) AS MAXEVENTID FROM EVENT";
private String selectSQL = "SELECT * FROM EVENT WHERE EVENTNAME=?";
private String selectIdSQL = "SELECT * FROM EVENT WHERE EVENTID=?";
private String insertSQL = "INSERT INTO EVENT(EVENTID,EVENTNAME,EVENTADDRESS,EVENTCITY,EVENTSTATE,EVENTCOUNTRY,EVENTZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE EVENT SET EVENTNAME=?,EVENTADDRESS=?,EVENTCITY=?,EVENTSTATE=?,EVENTCOUNTRY=?,EVENTZIPCODE=? WHERE EVENTID=?";
private String deleteSQL = "DELETE FROM EVENT WHERE EVENTID=?";
private String selectAllSQL = "SELECT * FROM EVENT";

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
    highestId = resultSet.getInt("MAXEVENTID");
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

public Event getEventById(int eventid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Event event = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, eventid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("eventid");
      String eventname = resultSet.getString("EVENTNAME");
      String eventaddress = resultSet.getString("EVENTADDRESS");
      String eventcity = resultSet.getString("EVENTCITY");
      String eventstate = resultSet.getString("EVENTSTATE");
      String eventcountry = resultSet.getString("EVENTCOUNTRY");
      String eventzipcode = resultSet.getString("EVENTZIPCODE");
      event = new Event();
      event.setEventId(id);
      event.setEventName(eventname);
      event.setEventAddress(eventaddress);
      event.setEventCity(eventcity);
      event.setEventState(eventstate);
      event.setEventCountry(eventcountry);
      event.setEventZipCode(eventzipcode);
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
  return event;
 }

public Event getEvent(String eventname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Event event = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, eventname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("EventId");
      eventname = resultSet.getString("EVENTNAME");
      String eventaddress = resultSet.getString("EVENTADDRESS");
      String eventcity = resultSet.getString("EVENTCITY");
      String eventstate = resultSet.getString("EVENTSTATE");
      String eventcountry = resultSet.getString("EVENTCOUNTRY");
      String eventzipcode = resultSet.getString("EVENTZIPCODE");
      event = new Event();
      event.setEventId(id);
      event.setEventName(eventname);
      event.setEventAddress(eventaddress);
      event.setEventCity(eventcity);
      event.setEventState(eventstate);
      event.setEventCountry(eventcountry);
      event.setEventZipCode(eventzipcode);
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
  return event;
 }

public void deleteEvent(Event event)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, event.getEventId());
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

public void insertEvent(Event event)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,event.getEventName());
    preparedStatement.setString(3,event.getEventAddress());
    preparedStatement.setString(4,event.getEventCity());
    preparedStatement.setString(5,event.getEventState());
    preparedStatement.setString(6,event.getEventCountry());
    preparedStatement.setString(7,event.getEventZipCode());
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

public void updateEvent(Event event)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,event.getEventName());
    preparedStatement.setString(2,event.getEventAddress());
    preparedStatement.setString(3,event.getEventCity());
    preparedStatement.setString(4,event.getEventState());
    preparedStatement.setString(5,event.getEventCountry());
    preparedStatement.setString(6,event.getEventZipCode());
    preparedStatement.setInt(7, event.getEventId());
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

public List<Event> getEvents( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Event> eventList = new ArrayList<Event>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("EVENTID");
      String eventname = resultSet.getString("EVENTNAME");
      String eventaddress = resultSet.getString("EVENTADDRESS");
      String eventcity = resultSet.getString("EVENTCITY");
      String eventstate = resultSet.getString("EVENTSTATE");
      String eventcountry = resultSet.getString("EVENTCOUNTRY");
      String eventzipcode = resultSet.getString("EVENTZIPCODE");
      Event event = new Event();
      event.setEventId(id);
      event.setEventName(eventname);
      event.setEventAddress(eventaddress);
      event.setEventCity(eventcity);
      event.setEventState(eventstate);
      event.setEventCountry(eventcountry);
      event.setEventZipCode(eventzipcode);
       eventList.add(event);
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
  return eventList;
 }

public static void main( String[] args ) {
}

} 

