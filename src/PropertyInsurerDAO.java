import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.PropertyInsurer;
import org.archcorner.chartreuse.util.JDBCManager;

public class PropertyInsurerDAO{ 


private String highestIDSQL = "SELECT MAX(PROPERTYINSURERID) AS MAXPROPERTYINSURERID FROM PROPERTYINSURER";
private String selectSQL = "SELECT * FROM PROPERTYINSURER WHERE PROPERTYINSURERNAME=?";
private String selectIdSQL = "SELECT * FROM PROPERTYINSURER WHERE PROPERTYINSURERID=?";
private String insertSQL = "INSERT INTO PROPERTYINSURER(PROPERTYINSURERID,PROPERTYINSURERNAME,PROPERTYINSURERADDRESS,PROPERTYINSURERCITY,PROPERTYINSURERSTATE,PROPERTYINSURERCOUNTRY,PROPERTYINSURERZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE PROPERTYINSURER SET PROPERTYINSURERNAME=?,PROPERTYINSURERADDRESS=?,PROPERTYINSURERCITY=?,PROPERTYINSURERSTATE=?,PROPERTYINSURERCOUNTRY=?,PROPERTYINSURERZIPCODE=? WHERE PROPERTYINSURERID=?";
private String deleteSQL = "DELETE FROM PROPERTYINSURER WHERE PROPERTYINSURERID=?";
private String selectAllSQL = "SELECT * FROM PROPERTYINSURER";

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
    highestId = resultSet.getInt("MAXPROPERTYINSURERID");
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

public PropertyInsurer getPropertyInsurerById(int propertyinsurerid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   PropertyInsurer propertyinsurer = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, propertyinsurerid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("propertyinsurerid");
      String propertyinsurername = resultSet.getString("PROPERTYINSURERNAME");
      String propertyinsureraddress = resultSet.getString("PROPERTYINSURERADDRESS");
      String propertyinsurercity = resultSet.getString("PROPERTYINSURERCITY");
      String propertyinsurerstate = resultSet.getString("PROPERTYINSURERSTATE");
      String propertyinsurercountry = resultSet.getString("PROPERTYINSURERCOUNTRY");
      String propertyinsurerzipcode = resultSet.getString("PROPERTYINSURERZIPCODE");
      propertyinsurer = new PropertyInsurer();
      propertyinsurer.setPropertyInsurerId(id);
      propertyinsurer.setPropertyInsurerName(propertyinsurername);
      propertyinsurer.setPropertyInsurerAddress(propertyinsureraddress);
      propertyinsurer.setPropertyInsurerCity(propertyinsurercity);
      propertyinsurer.setPropertyInsurerState(propertyinsurerstate);
      propertyinsurer.setPropertyInsurerCountry(propertyinsurercountry);
      propertyinsurer.setPropertyInsurerZipCode(propertyinsurerzipcode);
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
  return propertyinsurer;
 }

public PropertyInsurer getPropertyInsurer(String propertyinsurername)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   PropertyInsurer propertyinsurer = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, propertyinsurername);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("PropertyInsurerId");
      propertyinsurername = resultSet.getString("PROPERTYINSURERNAME");
      String propertyinsureraddress = resultSet.getString("PROPERTYINSURERADDRESS");
      String propertyinsurercity = resultSet.getString("PROPERTYINSURERCITY");
      String propertyinsurerstate = resultSet.getString("PROPERTYINSURERSTATE");
      String propertyinsurercountry = resultSet.getString("PROPERTYINSURERCOUNTRY");
      String propertyinsurerzipcode = resultSet.getString("PROPERTYINSURERZIPCODE");
      propertyinsurer = new PropertyInsurer();
      propertyinsurer.setPropertyInsurerId(id);
      propertyinsurer.setPropertyInsurerName(propertyinsurername);
      propertyinsurer.setPropertyInsurerAddress(propertyinsureraddress);
      propertyinsurer.setPropertyInsurerCity(propertyinsurercity);
      propertyinsurer.setPropertyInsurerState(propertyinsurerstate);
      propertyinsurer.setPropertyInsurerCountry(propertyinsurercountry);
      propertyinsurer.setPropertyInsurerZipCode(propertyinsurerzipcode);
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
  return propertyinsurer;
 }

public void deletePropertyInsurer(PropertyInsurer propertyinsurer)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, propertyinsurer.getPropertyInsurerId());
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

public void insertPropertyInsurer(PropertyInsurer propertyinsurer)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,propertyinsurer.getPropertyInsurerName());
    preparedStatement.setString(3,propertyinsurer.getPropertyInsurerAddress());
    preparedStatement.setString(4,propertyinsurer.getPropertyInsurerCity());
    preparedStatement.setString(5,propertyinsurer.getPropertyInsurerState());
    preparedStatement.setString(6,propertyinsurer.getPropertyInsurerCountry());
    preparedStatement.setString(7,propertyinsurer.getPropertyInsurerZipCode());
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

public void updatePropertyInsurer(PropertyInsurer propertyinsurer)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,propertyinsurer.getPropertyInsurerName());
    preparedStatement.setString(2,propertyinsurer.getPropertyInsurerAddress());
    preparedStatement.setString(3,propertyinsurer.getPropertyInsurerCity());
    preparedStatement.setString(4,propertyinsurer.getPropertyInsurerState());
    preparedStatement.setString(5,propertyinsurer.getPropertyInsurerCountry());
    preparedStatement.setString(6,propertyinsurer.getPropertyInsurerZipCode());
    preparedStatement.setInt(7, propertyinsurer.getPropertyInsurerId());
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

public List<PropertyInsurer> getPropertyInsurers( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<PropertyInsurer> propertyinsurerList = new ArrayList<PropertyInsurer>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("PROPERTYINSURERID");
      String propertyinsurername = resultSet.getString("PROPERTYINSURERNAME");
      String propertyinsureraddress = resultSet.getString("PROPERTYINSURERADDRESS");
      String propertyinsurercity = resultSet.getString("PROPERTYINSURERCITY");
      String propertyinsurerstate = resultSet.getString("PROPERTYINSURERSTATE");
      String propertyinsurercountry = resultSet.getString("PROPERTYINSURERCOUNTRY");
      String propertyinsurerzipcode = resultSet.getString("PROPERTYINSURERZIPCODE");
      PropertyInsurer propertyinsurer = new PropertyInsurer();
      propertyinsurer.setPropertyInsurerId(id);
      propertyinsurer.setPropertyInsurerName(propertyinsurername);
      propertyinsurer.setPropertyInsurerAddress(propertyinsureraddress);
      propertyinsurer.setPropertyInsurerCity(propertyinsurercity);
      propertyinsurer.setPropertyInsurerState(propertyinsurerstate);
      propertyinsurer.setPropertyInsurerCountry(propertyinsurercountry);
      propertyinsurer.setPropertyInsurerZipCode(propertyinsurerzipcode);
       propertyinsurerList.add(propertyinsurer);
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
  return propertyinsurerList;
 }

public static void main( String[] args ) {
}

} 

