import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Appointment;
import org.archcorner.chartreuse.util.JDBCManager;

public class AppointmentDAO{ 


private String highestIDSQL = "SELECT MAX(APPOINTMENTID) AS MAXAPPOINTMENTID FROM APPOINTMENT";
private String selectSQL = "SELECT * FROM APPOINTMENT WHERE APPOINTMENTNAME=?";
private String selectIdSQL = "SELECT * FROM APPOINTMENT WHERE APPOINTMENTID=?";
private String insertSQL = "INSERT INTO APPOINTMENT(APPOINTMENTID,APPOINTMENTNAME,APPOINTMENTADDRESS,APPOINTMENTCITY,APPOINTMENTSTATE,APPOINTMENTCOUNTRY,APPOINTMENTZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE APPOINTMENT SET APPOINTMENTNAME=?,APPOINTMENTADDRESS=?,APPOINTMENTCITY=?,APPOINTMENTSTATE=?,APPOINTMENTCOUNTRY=?,APPOINTMENTZIPCODE=? WHERE APPOINTMENTID=?";
private String deleteSQL = "DELETE FROM APPOINTMENT WHERE APPOINTMENTID=?";
private String selectAllSQL = "SELECT * FROM APPOINTMENT";

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
    highestId = resultSet.getInt("MAXAPPOINTMENTID");
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

public Appointment getAppointmentById(int appointmentid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Appointment appointment = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, appointmentid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("appointmentid");
      String appointmentname = resultSet.getString("APPOINTMENTNAME");
      String appointmentaddress = resultSet.getString("APPOINTMENTADDRESS");
      String appointmentcity = resultSet.getString("APPOINTMENTCITY");
      String appointmentstate = resultSet.getString("APPOINTMENTSTATE");
      String appointmentcountry = resultSet.getString("APPOINTMENTCOUNTRY");
      String appointmentzipcode = resultSet.getString("APPOINTMENTZIPCODE");
      appointment = new Appointment();
      appointment.setAppointmentId(id);
      appointment.setAppointmentName(appointmentname);
      appointment.setAppointmentAddress(appointmentaddress);
      appointment.setAppointmentCity(appointmentcity);
      appointment.setAppointmentState(appointmentstate);
      appointment.setAppointmentCountry(appointmentcountry);
      appointment.setAppointmentZipCode(appointmentzipcode);
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
  return appointment;
 }

public Appointment getAppointment(String appointmentname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Appointment appointment = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, appointmentname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("AppointmentId");
      appointmentname = resultSet.getString("APPOINTMENTNAME");
      String appointmentaddress = resultSet.getString("APPOINTMENTADDRESS");
      String appointmentcity = resultSet.getString("APPOINTMENTCITY");
      String appointmentstate = resultSet.getString("APPOINTMENTSTATE");
      String appointmentcountry = resultSet.getString("APPOINTMENTCOUNTRY");
      String appointmentzipcode = resultSet.getString("APPOINTMENTZIPCODE");
      appointment = new Appointment();
      appointment.setAppointmentId(id);
      appointment.setAppointmentName(appointmentname);
      appointment.setAppointmentAddress(appointmentaddress);
      appointment.setAppointmentCity(appointmentcity);
      appointment.setAppointmentState(appointmentstate);
      appointment.setAppointmentCountry(appointmentcountry);
      appointment.setAppointmentZipCode(appointmentzipcode);
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
  return appointment;
 }

public void deleteAppointment(Appointment appointment)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, appointment.getAppointmentId());
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

public void insertAppointment(Appointment appointment)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,appointment.getAppointmentName());
    preparedStatement.setString(3,appointment.getAppointmentAddress());
    preparedStatement.setString(4,appointment.getAppointmentCity());
    preparedStatement.setString(5,appointment.getAppointmentState());
    preparedStatement.setString(6,appointment.getAppointmentCountry());
    preparedStatement.setString(7,appointment.getAppointmentZipCode());
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

public void updateAppointment(Appointment appointment)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,appointment.getAppointmentName());
    preparedStatement.setString(2,appointment.getAppointmentAddress());
    preparedStatement.setString(3,appointment.getAppointmentCity());
    preparedStatement.setString(4,appointment.getAppointmentState());
    preparedStatement.setString(5,appointment.getAppointmentCountry());
    preparedStatement.setString(6,appointment.getAppointmentZipCode());
    preparedStatement.setInt(7, appointment.getAppointmentId());
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

public List<Appointment> getAppointments( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Appointment> appointmentList = new ArrayList<Appointment>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("APPOINTMENTID");
      String appointmentname = resultSet.getString("APPOINTMENTNAME");
      String appointmentaddress = resultSet.getString("APPOINTMENTADDRESS");
      String appointmentcity = resultSet.getString("APPOINTMENTCITY");
      String appointmentstate = resultSet.getString("APPOINTMENTSTATE");
      String appointmentcountry = resultSet.getString("APPOINTMENTCOUNTRY");
      String appointmentzipcode = resultSet.getString("APPOINTMENTZIPCODE");
      Appointment appointment = new Appointment();
      appointment.setAppointmentId(id);
      appointment.setAppointmentName(appointmentname);
      appointment.setAppointmentAddress(appointmentaddress);
      appointment.setAppointmentCity(appointmentcity);
      appointment.setAppointmentState(appointmentstate);
      appointment.setAppointmentCountry(appointmentcountry);
      appointment.setAppointmentZipCode(appointmentzipcode);
       appointmentList.add(appointment);
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
  return appointmentList;
 }

public static void main( String[] args ) {
}

} 

