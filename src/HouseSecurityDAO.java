import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.HouseSecurity;
import org.archcorner.chartreuse.util.JDBCManager;

public class HouseSecurityDAO{ 


private String highestIDSQL = "SELECT MAX(HOUSESECURITYID) AS MAXHOUSESECURITYID FROM HOUSESECURITY";
private String selectSQL = "SELECT * FROM HOUSESECURITY WHERE HOUSESECURITYNAME=?";
private String selectIdSQL = "SELECT * FROM HOUSESECURITY WHERE HOUSESECURITYID=?";
private String insertSQL = "INSERT INTO HOUSESECURITY(HOUSESECURITYID,HOUSESECURITYNAME,HOUSESECURITYADDRESS,HOUSESECURITYCITY,HOUSESECURITYSTATE,HOUSESECURITYCOUNTRY,HOUSESECURITYZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE HOUSESECURITY SET HOUSESECURITYNAME=?,HOUSESECURITYADDRESS=?,HOUSESECURITYCITY=?,HOUSESECURITYSTATE=?,HOUSESECURITYCOUNTRY=?,HOUSESECURITYZIPCODE=? WHERE HOUSESECURITYID=?";
private String deleteSQL = "DELETE FROM HOUSESECURITY WHERE HOUSESECURITYID=?";
private String selectAllSQL = "SELECT * FROM HOUSESECURITY";

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
    highestId = resultSet.getInt("MAXHOUSESECURITYID");
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

public HouseSecurity getHouseSecurityById(int housesecurityid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   HouseSecurity housesecurity = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, housesecurityid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("housesecurityid");
      String housesecurityname = resultSet.getString("HOUSESECURITYNAME");
      String housesecurityaddress = resultSet.getString("HOUSESECURITYADDRESS");
      String housesecuritycity = resultSet.getString("HOUSESECURITYCITY");
      String housesecuritystate = resultSet.getString("HOUSESECURITYSTATE");
      String housesecuritycountry = resultSet.getString("HOUSESECURITYCOUNTRY");
      String housesecurityzipcode = resultSet.getString("HOUSESECURITYZIPCODE");
      housesecurity = new HouseSecurity();
      housesecurity.setHouseSecurityId(id);
      housesecurity.setHouseSecurityName(housesecurityname);
      housesecurity.setHouseSecurityAddress(housesecurityaddress);
      housesecurity.setHouseSecurityCity(housesecuritycity);
      housesecurity.setHouseSecurityState(housesecuritystate);
      housesecurity.setHouseSecurityCountry(housesecuritycountry);
      housesecurity.setHouseSecurityZipCode(housesecurityzipcode);
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
  return housesecurity;
 }

public HouseSecurity getHouseSecurity(String housesecurityname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   HouseSecurity housesecurity = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, housesecurityname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("HouseSecurityId");
      housesecurityname = resultSet.getString("HOUSESECURITYNAME");
      String housesecurityaddress = resultSet.getString("HOUSESECURITYADDRESS");
      String housesecuritycity = resultSet.getString("HOUSESECURITYCITY");
      String housesecuritystate = resultSet.getString("HOUSESECURITYSTATE");
      String housesecuritycountry = resultSet.getString("HOUSESECURITYCOUNTRY");
      String housesecurityzipcode = resultSet.getString("HOUSESECURITYZIPCODE");
      housesecurity = new HouseSecurity();
      housesecurity.setHouseSecurityId(id);
      housesecurity.setHouseSecurityName(housesecurityname);
      housesecurity.setHouseSecurityAddress(housesecurityaddress);
      housesecurity.setHouseSecurityCity(housesecuritycity);
      housesecurity.setHouseSecurityState(housesecuritystate);
      housesecurity.setHouseSecurityCountry(housesecuritycountry);
      housesecurity.setHouseSecurityZipCode(housesecurityzipcode);
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
  return housesecurity;
 }

public void deleteHouseSecurity(HouseSecurity housesecurity)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, housesecurity.getHouseSecurityId());
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

public void insertHouseSecurity(HouseSecurity housesecurity)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,housesecurity.getHouseSecurityName());
    preparedStatement.setString(3,housesecurity.getHouseSecurityAddress());
    preparedStatement.setString(4,housesecurity.getHouseSecurityCity());
    preparedStatement.setString(5,housesecurity.getHouseSecurityState());
    preparedStatement.setString(6,housesecurity.getHouseSecurityCountry());
    preparedStatement.setString(7,housesecurity.getHouseSecurityZipCode());
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

public void updateHouseSecurity(HouseSecurity housesecurity)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,housesecurity.getHouseSecurityName());
    preparedStatement.setString(2,housesecurity.getHouseSecurityAddress());
    preparedStatement.setString(3,housesecurity.getHouseSecurityCity());
    preparedStatement.setString(4,housesecurity.getHouseSecurityState());
    preparedStatement.setString(5,housesecurity.getHouseSecurityCountry());
    preparedStatement.setString(6,housesecurity.getHouseSecurityZipCode());
    preparedStatement.setInt(7, housesecurity.getHouseSecurityId());
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

public List<HouseSecurity> getHouseSecuritys( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<HouseSecurity> housesecurityList = new ArrayList<HouseSecurity>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("HOUSESECURITYID");
      String housesecurityname = resultSet.getString("HOUSESECURITYNAME");
      String housesecurityaddress = resultSet.getString("HOUSESECURITYADDRESS");
      String housesecuritycity = resultSet.getString("HOUSESECURITYCITY");
      String housesecuritystate = resultSet.getString("HOUSESECURITYSTATE");
      String housesecuritycountry = resultSet.getString("HOUSESECURITYCOUNTRY");
      String housesecurityzipcode = resultSet.getString("HOUSESECURITYZIPCODE");
      HouseSecurity housesecurity = new HouseSecurity();
      housesecurity.setHouseSecurityId(id);
      housesecurity.setHouseSecurityName(housesecurityname);
      housesecurity.setHouseSecurityAddress(housesecurityaddress);
      housesecurity.setHouseSecurityCity(housesecuritycity);
      housesecurity.setHouseSecurityState(housesecuritystate);
      housesecurity.setHouseSecurityCountry(housesecuritycountry);
      housesecurity.setHouseSecurityZipCode(housesecurityzipcode);
       housesecurityList.add(housesecurity);
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
  return housesecurityList;
 }

public static void main( String[] args ) {
}

} 

