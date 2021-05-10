import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Entitlement;
import org.archcorner.chartreuse.util.JDBCManager;

public class EntitlementDAO{ 


private String highestIDSQL = "SELECT MAX(ENTITLEMENTID) AS MAXENTITLEMENTID FROM ENTITLEMENT";
private String selectSQL = "SELECT * FROM ENTITLEMENT WHERE ENTITLEMENTNAME=?";
private String selectIdSQL = "SELECT * FROM ENTITLEMENT WHERE ENTITLEMENTID=?";
private String insertSQL = "INSERT INTO ENTITLEMENT(ENTITLEMENTID,ENTITLEMENTNAME,ENTITLEMENTADDRESS,ENTITLEMENTCITY,ENTITLEMENTSTATE,ENTITLEMENTCOUNTRY,ENTITLEMENTZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE ENTITLEMENT SET ENTITLEMENTNAME=?,ENTITLEMENTADDRESS=?,ENTITLEMENTCITY=?,ENTITLEMENTSTATE=?,ENTITLEMENTCOUNTRY=?,ENTITLEMENTZIPCODE=? WHERE ENTITLEMENTID=?";
private String deleteSQL = "DELETE FROM ENTITLEMENT WHERE ENTITLEMENTID=?";
private String selectAllSQL = "SELECT * FROM ENTITLEMENT";

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
    highestId = resultSet.getInt("MAXENTITLEMENTID");
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

public Entitlement getEntitlementById(int entitlementid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Entitlement entitlement = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, entitlementid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("entitlementid");
      String entitlementname = resultSet.getString("ENTITLEMENTNAME");
      String entitlementaddress = resultSet.getString("ENTITLEMENTADDRESS");
      String entitlementcity = resultSet.getString("ENTITLEMENTCITY");
      String entitlementstate = resultSet.getString("ENTITLEMENTSTATE");
      String entitlementcountry = resultSet.getString("ENTITLEMENTCOUNTRY");
      String entitlementzipcode = resultSet.getString("ENTITLEMENTZIPCODE");
      entitlement = new Entitlement();
      entitlement.setEntitlementId(id);
      entitlement.setEntitlementName(entitlementname);
      entitlement.setEntitlementAddress(entitlementaddress);
      entitlement.setEntitlementCity(entitlementcity);
      entitlement.setEntitlementState(entitlementstate);
      entitlement.setEntitlementCountry(entitlementcountry);
      entitlement.setEntitlementZipCode(entitlementzipcode);
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
  return entitlement;
 }

public Entitlement getEntitlement(String entitlementname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Entitlement entitlement = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, entitlementname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("EntitlementId");
      entitlementname = resultSet.getString("ENTITLEMENTNAME");
      String entitlementaddress = resultSet.getString("ENTITLEMENTADDRESS");
      String entitlementcity = resultSet.getString("ENTITLEMENTCITY");
      String entitlementstate = resultSet.getString("ENTITLEMENTSTATE");
      String entitlementcountry = resultSet.getString("ENTITLEMENTCOUNTRY");
      String entitlementzipcode = resultSet.getString("ENTITLEMENTZIPCODE");
      entitlement = new Entitlement();
      entitlement.setEntitlementId(id);
      entitlement.setEntitlementName(entitlementname);
      entitlement.setEntitlementAddress(entitlementaddress);
      entitlement.setEntitlementCity(entitlementcity);
      entitlement.setEntitlementState(entitlementstate);
      entitlement.setEntitlementCountry(entitlementcountry);
      entitlement.setEntitlementZipCode(entitlementzipcode);
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
  return entitlement;
 }

public void deleteEntitlement(Entitlement entitlement)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, entitlement.getEntitlementId());
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

public void insertEntitlement(Entitlement entitlement)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,entitlement.getEntitlementName());
    preparedStatement.setString(3,entitlement.getEntitlementAddress());
    preparedStatement.setString(4,entitlement.getEntitlementCity());
    preparedStatement.setString(5,entitlement.getEntitlementState());
    preparedStatement.setString(6,entitlement.getEntitlementCountry());
    preparedStatement.setString(7,entitlement.getEntitlementZipCode());
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

public void updateEntitlement(Entitlement entitlement)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,entitlement.getEntitlementName());
    preparedStatement.setString(2,entitlement.getEntitlementAddress());
    preparedStatement.setString(3,entitlement.getEntitlementCity());
    preparedStatement.setString(4,entitlement.getEntitlementState());
    preparedStatement.setString(5,entitlement.getEntitlementCountry());
    preparedStatement.setString(6,entitlement.getEntitlementZipCode());
    preparedStatement.setInt(7, entitlement.getEntitlementId());
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

public List<Entitlement> getEntitlements( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Entitlement> entitlementList = new ArrayList<Entitlement>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("ENTITLEMENTID");
      String entitlementname = resultSet.getString("ENTITLEMENTNAME");
      String entitlementaddress = resultSet.getString("ENTITLEMENTADDRESS");
      String entitlementcity = resultSet.getString("ENTITLEMENTCITY");
      String entitlementstate = resultSet.getString("ENTITLEMENTSTATE");
      String entitlementcountry = resultSet.getString("ENTITLEMENTCOUNTRY");
      String entitlementzipcode = resultSet.getString("ENTITLEMENTZIPCODE");
      Entitlement entitlement = new Entitlement();
      entitlement.setEntitlementId(id);
      entitlement.setEntitlementName(entitlementname);
      entitlement.setEntitlementAddress(entitlementaddress);
      entitlement.setEntitlementCity(entitlementcity);
      entitlement.setEntitlementState(entitlementstate);
      entitlement.setEntitlementCountry(entitlementcountry);
      entitlement.setEntitlementZipCode(entitlementzipcode);
       entitlementList.add(entitlement);
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
  return entitlementList;
 }

public static void main( String[] args ) {
}

} 

