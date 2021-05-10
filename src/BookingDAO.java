import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Booking;
import org.archcorner.chartreuse.util.JDBCManager;

public class BookingDAO{ 


private String highestIDSQL = "SELECT MAX(BOOKINGID) AS MAXBOOKINGID FROM BOOKING";
private String selectSQL = "SELECT * FROM BOOKING WHERE BOOKINGNAME=?";
private String selectIdSQL = "SELECT * FROM BOOKING WHERE BOOKINGID=?";
private String insertSQL = "INSERT INTO BOOKING(BOOKINGID,BOOKINGNAME,BOOKINGADDRESS,BOOKINGCITY,BOOKINGSTATE,BOOKINGCOUNTRY,BOOKINGZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE BOOKING SET BOOKINGNAME=?,BOOKINGADDRESS=?,BOOKINGCITY=?,BOOKINGSTATE=?,BOOKINGCOUNTRY=?,BOOKINGZIPCODE=? WHERE BOOKINGID=?";
private String deleteSQL = "DELETE FROM BOOKING WHERE BOOKINGID=?";
private String selectAllSQL = "SELECT * FROM BOOKING";

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
    highestId = resultSet.getInt("MAXBOOKINGID");
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

public Booking getBookingById(int bookingid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Booking booking = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, bookingid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("bookingid");
      String bookingname = resultSet.getString("BOOKINGNAME");
      String bookingaddress = resultSet.getString("BOOKINGADDRESS");
      String bookingcity = resultSet.getString("BOOKINGCITY");
      String bookingstate = resultSet.getString("BOOKINGSTATE");
      String bookingcountry = resultSet.getString("BOOKINGCOUNTRY");
      String bookingzipcode = resultSet.getString("BOOKINGZIPCODE");
      booking = new Booking();
      booking.setBookingId(id);
      booking.setBookingName(bookingname);
      booking.setBookingAddress(bookingaddress);
      booking.setBookingCity(bookingcity);
      booking.setBookingState(bookingstate);
      booking.setBookingCountry(bookingcountry);
      booking.setBookingZipCode(bookingzipcode);
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
  return booking;
 }

public Booking getBooking(String bookingname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Booking booking = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, bookingname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("BookingId");
      bookingname = resultSet.getString("BOOKINGNAME");
      String bookingaddress = resultSet.getString("BOOKINGADDRESS");
      String bookingcity = resultSet.getString("BOOKINGCITY");
      String bookingstate = resultSet.getString("BOOKINGSTATE");
      String bookingcountry = resultSet.getString("BOOKINGCOUNTRY");
      String bookingzipcode = resultSet.getString("BOOKINGZIPCODE");
      booking = new Booking();
      booking.setBookingId(id);
      booking.setBookingName(bookingname);
      booking.setBookingAddress(bookingaddress);
      booking.setBookingCity(bookingcity);
      booking.setBookingState(bookingstate);
      booking.setBookingCountry(bookingcountry);
      booking.setBookingZipCode(bookingzipcode);
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
  return booking;
 }

public void deleteBooking(Booking booking)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, booking.getBookingId());
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

public void insertBooking(Booking booking)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,booking.getBookingName());
    preparedStatement.setString(3,booking.getBookingAddress());
    preparedStatement.setString(4,booking.getBookingCity());
    preparedStatement.setString(5,booking.getBookingState());
    preparedStatement.setString(6,booking.getBookingCountry());
    preparedStatement.setString(7,booking.getBookingZipCode());
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

public void updateBooking(Booking booking)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,booking.getBookingName());
    preparedStatement.setString(2,booking.getBookingAddress());
    preparedStatement.setString(3,booking.getBookingCity());
    preparedStatement.setString(4,booking.getBookingState());
    preparedStatement.setString(5,booking.getBookingCountry());
    preparedStatement.setString(6,booking.getBookingZipCode());
    preparedStatement.setInt(7, booking.getBookingId());
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

public List<Booking> getBookings( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Booking> bookingList = new ArrayList<Booking>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("BOOKINGID");
      String bookingname = resultSet.getString("BOOKINGNAME");
      String bookingaddress = resultSet.getString("BOOKINGADDRESS");
      String bookingcity = resultSet.getString("BOOKINGCITY");
      String bookingstate = resultSet.getString("BOOKINGSTATE");
      String bookingcountry = resultSet.getString("BOOKINGCOUNTRY");
      String bookingzipcode = resultSet.getString("BOOKINGZIPCODE");
      Booking booking = new Booking();
      booking.setBookingId(id);
      booking.setBookingName(bookingname);
      booking.setBookingAddress(bookingaddress);
      booking.setBookingCity(bookingcity);
      booking.setBookingState(bookingstate);
      booking.setBookingCountry(bookingcountry);
      booking.setBookingZipCode(bookingzipcode);
       bookingList.add(booking);
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
  return bookingList;
 }

public static void main( String[] args ) {
}

} 

