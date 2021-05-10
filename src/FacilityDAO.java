import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Facility;
import org.archcorner.chartreuse.util.JDBCManager;

public class FacilityDAO{ 


private String highestIDSQL = "SELECT MAX(FACILITYID) AS MAXFACILITYID FROM FACILITY";
private String selectSQL = "SELECT * FROM FACILITY WHERE FACILITYNAME=?";
private String selectIdSQL = "SELECT * FROM FACILITY WHERE FACILITYID=?";
private String insertSQL = "INSERT INTO FACILITY(FACILITYID,FACILITYNAME,FACILITYADDRESS,FACILITYCITY,FACILITYSTATE,FACILITYCOUNTRY,FACILITYZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE FACILITY SET FACILITYNAME=?,FACILITYADDRESS=?,FACILITYCITY=?,FACILITYSTATE=?,FACILITYCOUNTRY=?,FACILITYZIPCODE=? WHERE FACILITYID=?";
private String deleteSQL = "DELETE FROM FACILITY WHERE FACILITYID=?";
private String selectAllSQL = "SELECT * FROM FACILITY";

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
    highestId = resultSet.getInt("MAXFACILITYID");
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

public Facility getFacilityById(int facilityid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Facility facility = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, facilityid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("facilityid");
      String facilityname = resultSet.getString("FACILITYNAME");
      String facilityaddress = resultSet.getString("FACILITYADDRESS");
      String facilitycity = resultSet.getString("FACILITYCITY");
      String facilitystate = resultSet.getString("FACILITYSTATE");
      String facilitycountry = resultSet.getString("FACILITYCOUNTRY");
      String facilityzipcode = resultSet.getString("FACILITYZIPCODE");
      facility = new Facility();
      facility.setFacilityId(id);
      facility.setFacilityName(facilityname);
      facility.setFacilityAddress(facilityaddress);
      facility.setFacilityCity(facilitycity);
      facility.setFacilityState(facilitystate);
      facility.setFacilityCountry(facilitycountry);
      facility.setFacilityZipCode(facilityzipcode);
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
  return facility;
 }

public Facility getFacility(String facilityname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Facility facility = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, facilityname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("FacilityId");
      facilityname = resultSet.getString("FACILITYNAME");
      String facilityaddress = resultSet.getString("FACILITYADDRESS");
      String facilitycity = resultSet.getString("FACILITYCITY");
      String facilitystate = resultSet.getString("FACILITYSTATE");
      String facilitycountry = resultSet.getString("FACILITYCOUNTRY");
      String facilityzipcode = resultSet.getString("FACILITYZIPCODE");
      facility = new Facility();
      facility.setFacilityId(id);
      facility.setFacilityName(facilityname);
      facility.setFacilityAddress(facilityaddress);
      facility.setFacilityCity(facilitycity);
      facility.setFacilityState(facilitystate);
      facility.setFacilityCountry(facilitycountry);
      facility.setFacilityZipCode(facilityzipcode);
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
  return facility;
 }

public void deleteFacility(Facility facility)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, facility.getFacilityId());
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

public void insertFacility(Facility facility)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,facility.getFacilityName());
    preparedStatement.setString(3,facility.getFacilityAddress());
    preparedStatement.setString(4,facility.getFacilityCity());
    preparedStatement.setString(5,facility.getFacilityState());
    preparedStatement.setString(6,facility.getFacilityCountry());
    preparedStatement.setString(7,facility.getFacilityZipCode());
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

public void updateFacility(Facility facility)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,facility.getFacilityName());
    preparedStatement.setString(2,facility.getFacilityAddress());
    preparedStatement.setString(3,facility.getFacilityCity());
    preparedStatement.setString(4,facility.getFacilityState());
    preparedStatement.setString(5,facility.getFacilityCountry());
    preparedStatement.setString(6,facility.getFacilityZipCode());
    preparedStatement.setInt(7, facility.getFacilityId());
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

public List<Facility> getFacilitys( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Facility> facilityList = new ArrayList<Facility>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("FACILITYID");
      String facilityname = resultSet.getString("FACILITYNAME");
      String facilityaddress = resultSet.getString("FACILITYADDRESS");
      String facilitycity = resultSet.getString("FACILITYCITY");
      String facilitystate = resultSet.getString("FACILITYSTATE");
      String facilitycountry = resultSet.getString("FACILITYCOUNTRY");
      String facilityzipcode = resultSet.getString("FACILITYZIPCODE");
      Facility facility = new Facility();
      facility.setFacilityId(id);
      facility.setFacilityName(facilityname);
      facility.setFacilityAddress(facilityaddress);
      facility.setFacilityCity(facilitycity);
      facility.setFacilityState(facilitystate);
      facility.setFacilityCountry(facilitycountry);
      facility.setFacilityZipCode(facilityzipcode);
       facilityList.add(facility);
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
  return facilityList;
 }

public static void main( String[] args ) {
}

} 

