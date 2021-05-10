import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.PropertyCasualtyInsurer;
import org.archcorner.chartreuse.util.JDBCManager;

public class PropertyCasualtyInsurerDAO{ 


private String highestIDSQL = "SELECT MAX(PROPERTYCASUALTYINSURERID) AS MAXPROPERTYCASUALTYINSURERID FROM PROPERTYCASUALTYINSURER";
private String selectSQL = "SELECT * FROM PROPERTYCASUALTYINSURER WHERE PROPERTYCASUALTYINSURERNAME=?";
private String selectIdSQL = "SELECT * FROM PROPERTYCASUALTYINSURER WHERE PROPERTYCASUALTYINSURERID=?";
private String insertSQL = "INSERT INTO PROPERTYCASUALTYINSURER(PROPERTYCASUALTYINSURERID,PROPERTYCASUALTYINSURERNAME,PROPERTYCASUALTYINSURERADDRESS,PROPERTYCASUALTYINSURERCITY,PROPERTYCASUALTYINSURERSTATE,PROPERTYCASUALTYINSURERCOUNTRY,PROPERTYCASUALTYINSURERZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE PROPERTYCASUALTYINSURER SET PROPERTYCASUALTYINSURERNAME=?,PROPERTYCASUALTYINSURERADDRESS=?,PROPERTYCASUALTYINSURERCITY=?,PROPERTYCASUALTYINSURERSTATE=?,PROPERTYCASUALTYINSURERCOUNTRY=?,PROPERTYCASUALTYINSURERZIPCODE=? WHERE PROPERTYCASUALTYINSURERID=?";
private String deleteSQL = "DELETE FROM PROPERTYCASUALTYINSURER WHERE PROPERTYCASUALTYINSURERID=?";
private String selectAllSQL = "SELECT * FROM PROPERTYCASUALTYINSURER";

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
    highestId = resultSet.getInt("MAXPROPERTYCASUALTYINSURERID");
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

public PropertyCasualtyInsurer getPropertyCasualtyInsurerById(int propertycasualtyinsurerid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   PropertyCasualtyInsurer propertycasualtyinsurer = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, propertycasualtyinsurerid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("propertycasualtyinsurerid");
      String propertycasualtyinsurername = resultSet.getString("PROPERTYCASUALTYINSURERNAME");
      String propertycasualtyinsureraddress = resultSet.getString("PROPERTYCASUALTYINSURERADDRESS");
      String propertycasualtyinsurercity = resultSet.getString("PROPERTYCASUALTYINSURERCITY");
      String propertycasualtyinsurerstate = resultSet.getString("PROPERTYCASUALTYINSURERSTATE");
      String propertycasualtyinsurercountry = resultSet.getString("PROPERTYCASUALTYINSURERCOUNTRY");
      String propertycasualtyinsurerzipcode = resultSet.getString("PROPERTYCASUALTYINSURERZIPCODE");
      propertycasualtyinsurer = new PropertyCasualtyInsurer();
      propertycasualtyinsurer.setPropertyCasualtyInsurerId(id);
      propertycasualtyinsurer.setPropertyCasualtyInsurerName(propertycasualtyinsurername);
      propertycasualtyinsurer.setPropertyCasualtyInsurerAddress(propertycasualtyinsureraddress);
      propertycasualtyinsurer.setPropertyCasualtyInsurerCity(propertycasualtyinsurercity);
      propertycasualtyinsurer.setPropertyCasualtyInsurerState(propertycasualtyinsurerstate);
      propertycasualtyinsurer.setPropertyCasualtyInsurerCountry(propertycasualtyinsurercountry);
      propertycasualtyinsurer.setPropertyCasualtyInsurerZipCode(propertycasualtyinsurerzipcode);
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
  return propertycasualtyinsurer;
 }

public PropertyCasualtyInsurer getPropertyCasualtyInsurer(String propertycasualtyinsurername)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   PropertyCasualtyInsurer propertycasualtyinsurer = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, propertycasualtyinsurername);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("PropertyCasualtyInsurerId");
      propertycasualtyinsurername = resultSet.getString("PROPERTYCASUALTYINSURERNAME");
      String propertycasualtyinsureraddress = resultSet.getString("PROPERTYCASUALTYINSURERADDRESS");
      String propertycasualtyinsurercity = resultSet.getString("PROPERTYCASUALTYINSURERCITY");
      String propertycasualtyinsurerstate = resultSet.getString("PROPERTYCASUALTYINSURERSTATE");
      String propertycasualtyinsurercountry = resultSet.getString("PROPERTYCASUALTYINSURERCOUNTRY");
      String propertycasualtyinsurerzipcode = resultSet.getString("PROPERTYCASUALTYINSURERZIPCODE");
      propertycasualtyinsurer = new PropertyCasualtyInsurer();
      propertycasualtyinsurer.setPropertyCasualtyInsurerId(id);
      propertycasualtyinsurer.setPropertyCasualtyInsurerName(propertycasualtyinsurername);
      propertycasualtyinsurer.setPropertyCasualtyInsurerAddress(propertycasualtyinsureraddress);
      propertycasualtyinsurer.setPropertyCasualtyInsurerCity(propertycasualtyinsurercity);
      propertycasualtyinsurer.setPropertyCasualtyInsurerState(propertycasualtyinsurerstate);
      propertycasualtyinsurer.setPropertyCasualtyInsurerCountry(propertycasualtyinsurercountry);
      propertycasualtyinsurer.setPropertyCasualtyInsurerZipCode(propertycasualtyinsurerzipcode);
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
  return propertycasualtyinsurer;
 }

public void deletePropertyCasualtyInsurer(PropertyCasualtyInsurer propertycasualtyinsurer)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, propertycasualtyinsurer.getPropertyCasualtyInsurerId());
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

public void insertPropertyCasualtyInsurer(PropertyCasualtyInsurer propertycasualtyinsurer)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,propertycasualtyinsurer.getPropertyCasualtyInsurerName());
    preparedStatement.setString(3,propertycasualtyinsurer.getPropertyCasualtyInsurerAddress());
    preparedStatement.setString(4,propertycasualtyinsurer.getPropertyCasualtyInsurerCity());
    preparedStatement.setString(5,propertycasualtyinsurer.getPropertyCasualtyInsurerState());
    preparedStatement.setString(6,propertycasualtyinsurer.getPropertyCasualtyInsurerCountry());
    preparedStatement.setString(7,propertycasualtyinsurer.getPropertyCasualtyInsurerZipCode());
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

public void updatePropertyCasualtyInsurer(PropertyCasualtyInsurer propertycasualtyinsurer)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,propertycasualtyinsurer.getPropertyCasualtyInsurerName());
    preparedStatement.setString(2,propertycasualtyinsurer.getPropertyCasualtyInsurerAddress());
    preparedStatement.setString(3,propertycasualtyinsurer.getPropertyCasualtyInsurerCity());
    preparedStatement.setString(4,propertycasualtyinsurer.getPropertyCasualtyInsurerState());
    preparedStatement.setString(5,propertycasualtyinsurer.getPropertyCasualtyInsurerCountry());
    preparedStatement.setString(6,propertycasualtyinsurer.getPropertyCasualtyInsurerZipCode());
    preparedStatement.setInt(7, propertycasualtyinsurer.getPropertyCasualtyInsurerId());
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

public List<PropertyCasualtyInsurer> getPropertyCasualtyInsurers( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<PropertyCasualtyInsurer> propertycasualtyinsurerList = new ArrayList<PropertyCasualtyInsurer>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("PROPERTYCASUALTYINSURERID");
      String propertycasualtyinsurername = resultSet.getString("PROPERTYCASUALTYINSURERNAME");
      String propertycasualtyinsureraddress = resultSet.getString("PROPERTYCASUALTYINSURERADDRESS");
      String propertycasualtyinsurercity = resultSet.getString("PROPERTYCASUALTYINSURERCITY");
      String propertycasualtyinsurerstate = resultSet.getString("PROPERTYCASUALTYINSURERSTATE");
      String propertycasualtyinsurercountry = resultSet.getString("PROPERTYCASUALTYINSURERCOUNTRY");
      String propertycasualtyinsurerzipcode = resultSet.getString("PROPERTYCASUALTYINSURERZIPCODE");
      PropertyCasualtyInsurer propertycasualtyinsurer = new PropertyCasualtyInsurer();
      propertycasualtyinsurer.setPropertyCasualtyInsurerId(id);
      propertycasualtyinsurer.setPropertyCasualtyInsurerName(propertycasualtyinsurername);
      propertycasualtyinsurer.setPropertyCasualtyInsurerAddress(propertycasualtyinsureraddress);
      propertycasualtyinsurer.setPropertyCasualtyInsurerCity(propertycasualtyinsurercity);
      propertycasualtyinsurer.setPropertyCasualtyInsurerState(propertycasualtyinsurerstate);
      propertycasualtyinsurer.setPropertyCasualtyInsurerCountry(propertycasualtyinsurercountry);
      propertycasualtyinsurer.setPropertyCasualtyInsurerZipCode(propertycasualtyinsurerzipcode);
       propertycasualtyinsurerList.add(propertycasualtyinsurer);
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
  return propertycasualtyinsurerList;
 }

public static void main( String[] args ) {
}

} 

