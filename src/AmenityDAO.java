import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Amenity;
import org.archcorner.chartreuse.util.JDBCManager;

public class AmenityDAO{ 


private String highestIDSQL = "SELECT MAX(AMENITYID) AS MAXAMENITYID FROM AMENITY";
private String selectSQL = "SELECT * FROM AMENITY WHERE AMENITYNAME=?";
private String selectIdSQL = "SELECT * FROM AMENITY WHERE AMENITYID=?";
private String insertSQL = "INSERT INTO AMENITY(AMENITYID,AMENITYNAME,AMENITYADDRESS,AMENITYCITY,AMENITYSTATE,AMENITYCOUNTRY,AMENITYZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE AMENITY SET AMENITYNAME=?,AMENITYADDRESS=?,AMENITYCITY=?,AMENITYSTATE=?,AMENITYCOUNTRY=?,AMENITYZIPCODE=? WHERE AMENITYID=?";
private String deleteSQL = "DELETE FROM AMENITY WHERE AMENITYID=?";
private String selectAllSQL = "SELECT * FROM AMENITY";

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
    highestId = resultSet.getInt("MAXAMENITYID");
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

public Amenity getAmenityById(int amenityid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Amenity amenity = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, amenityid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("amenityid");
      String amenityname = resultSet.getString("AMENITYNAME");
      String amenityaddress = resultSet.getString("AMENITYADDRESS");
      String amenitycity = resultSet.getString("AMENITYCITY");
      String amenitystate = resultSet.getString("AMENITYSTATE");
      String amenitycountry = resultSet.getString("AMENITYCOUNTRY");
      String amenityzipcode = resultSet.getString("AMENITYZIPCODE");
      amenity = new Amenity();
      amenity.setAmenityId(id);
      amenity.setAmenityName(amenityname);
      amenity.setAmenityAddress(amenityaddress);
      amenity.setAmenityCity(amenitycity);
      amenity.setAmenityState(amenitystate);
      amenity.setAmenityCountry(amenitycountry);
      amenity.setAmenityZipCode(amenityzipcode);
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
  return amenity;
 }

public Amenity getAmenity(String amenityname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Amenity amenity = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, amenityname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("AmenityId");
      amenityname = resultSet.getString("AMENITYNAME");
      String amenityaddress = resultSet.getString("AMENITYADDRESS");
      String amenitycity = resultSet.getString("AMENITYCITY");
      String amenitystate = resultSet.getString("AMENITYSTATE");
      String amenitycountry = resultSet.getString("AMENITYCOUNTRY");
      String amenityzipcode = resultSet.getString("AMENITYZIPCODE");
      amenity = new Amenity();
      amenity.setAmenityId(id);
      amenity.setAmenityName(amenityname);
      amenity.setAmenityAddress(amenityaddress);
      amenity.setAmenityCity(amenitycity);
      amenity.setAmenityState(amenitystate);
      amenity.setAmenityCountry(amenitycountry);
      amenity.setAmenityZipCode(amenityzipcode);
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
  return amenity;
 }

public void deleteAmenity(Amenity amenity)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, amenity.getAmenityId());
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

public void insertAmenity(Amenity amenity)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,amenity.getAmenityName());
    preparedStatement.setString(3,amenity.getAmenityAddress());
    preparedStatement.setString(4,amenity.getAmenityCity());
    preparedStatement.setString(5,amenity.getAmenityState());
    preparedStatement.setString(6,amenity.getAmenityCountry());
    preparedStatement.setString(7,amenity.getAmenityZipCode());
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

public void updateAmenity(Amenity amenity)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,amenity.getAmenityName());
    preparedStatement.setString(2,amenity.getAmenityAddress());
    preparedStatement.setString(3,amenity.getAmenityCity());
    preparedStatement.setString(4,amenity.getAmenityState());
    preparedStatement.setString(5,amenity.getAmenityCountry());
    preparedStatement.setString(6,amenity.getAmenityZipCode());
    preparedStatement.setInt(7, amenity.getAmenityId());
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

public List<Amenity> getAmenitys( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Amenity> amenityList = new ArrayList<Amenity>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("AMENITYID");
      String amenityname = resultSet.getString("AMENITYNAME");
      String amenityaddress = resultSet.getString("AMENITYADDRESS");
      String amenitycity = resultSet.getString("AMENITYCITY");
      String amenitystate = resultSet.getString("AMENITYSTATE");
      String amenitycountry = resultSet.getString("AMENITYCOUNTRY");
      String amenityzipcode = resultSet.getString("AMENITYZIPCODE");
      Amenity amenity = new Amenity();
      amenity.setAmenityId(id);
      amenity.setAmenityName(amenityname);
      amenity.setAmenityAddress(amenityaddress);
      amenity.setAmenityCity(amenitycity);
      amenity.setAmenityState(amenitystate);
      amenity.setAmenityCountry(amenitycountry);
      amenity.setAmenityZipCode(amenityzipcode);
       amenityList.add(amenity);
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
  return amenityList;
 }

public static void main( String[] args ) {
}

} 

