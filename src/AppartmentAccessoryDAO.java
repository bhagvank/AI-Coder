import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.AppartmentAccessory;
import org.archcorner.chartreuse.util.JDBCManager;

public class AppartmentAccessoryDAO{ 


private String highestIDSQL = "SELECT MAX(APPARTMENTACCESSORYID) AS MAXAPPARTMENTACCESSORYID FROM APPARTMENTACCESSORY";
private String selectSQL = "SELECT * FROM APPARTMENTACCESSORY WHERE APPARTMENTACCESSORYNAME=?";
private String selectIdSQL = "SELECT * FROM APPARTMENTACCESSORY WHERE APPARTMENTACCESSORYID=?";
private String insertSQL = "INSERT INTO APPARTMENTACCESSORY(APPARTMENTACCESSORYID,APPARTMENTACCESSORYNAME,APPARTMENTACCESSORYADDRESS,APPARTMENTACCESSORYCITY,APPARTMENTACCESSORYSTATE,APPARTMENTACCESSORYCOUNTRY,APPARTMENTACCESSORYZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE APPARTMENTACCESSORY SET APPARTMENTACCESSORYNAME=?,APPARTMENTACCESSORYADDRESS=?,APPARTMENTACCESSORYCITY=?,APPARTMENTACCESSORYSTATE=?,APPARTMENTACCESSORYCOUNTRY=?,APPARTMENTACCESSORYZIPCODE=? WHERE APPARTMENTACCESSORYID=?";
private String deleteSQL = "DELETE FROM APPARTMENTACCESSORY WHERE APPARTMENTACCESSORYID=?";
private String selectAllSQL = "SELECT * FROM APPARTMENTACCESSORY";

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
    highestId = resultSet.getInt("MAXAPPARTMENTACCESSORYID");
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

public AppartmentAccessory getAppartmentAccessoryById(int appartmentaccessoryid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   AppartmentAccessory appartmentaccessory = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, appartmentaccessoryid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("appartmentaccessoryid");
      String appartmentaccessoryname = resultSet.getString("APPARTMENTACCESSORYNAME");
      String appartmentaccessoryaddress = resultSet.getString("APPARTMENTACCESSORYADDRESS");
      String appartmentaccessorycity = resultSet.getString("APPARTMENTACCESSORYCITY");
      String appartmentaccessorystate = resultSet.getString("APPARTMENTACCESSORYSTATE");
      String appartmentaccessorycountry = resultSet.getString("APPARTMENTACCESSORYCOUNTRY");
      String appartmentaccessoryzipcode = resultSet.getString("APPARTMENTACCESSORYZIPCODE");
      appartmentaccessory = new AppartmentAccessory();
      appartmentaccessory.setAppartmentAccessoryId(id);
      appartmentaccessory.setAppartmentAccessoryName(appartmentaccessoryname);
      appartmentaccessory.setAppartmentAccessoryAddress(appartmentaccessoryaddress);
      appartmentaccessory.setAppartmentAccessoryCity(appartmentaccessorycity);
      appartmentaccessory.setAppartmentAccessoryState(appartmentaccessorystate);
      appartmentaccessory.setAppartmentAccessoryCountry(appartmentaccessorycountry);
      appartmentaccessory.setAppartmentAccessoryZipCode(appartmentaccessoryzipcode);
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
  return appartmentaccessory;
 }

public AppartmentAccessory getAppartmentAccessory(String appartmentaccessoryname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   AppartmentAccessory appartmentaccessory = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, appartmentaccessoryname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("AppartmentAccessoryId");
      appartmentaccessoryname = resultSet.getString("APPARTMENTACCESSORYNAME");
      String appartmentaccessoryaddress = resultSet.getString("APPARTMENTACCESSORYADDRESS");
      String appartmentaccessorycity = resultSet.getString("APPARTMENTACCESSORYCITY");
      String appartmentaccessorystate = resultSet.getString("APPARTMENTACCESSORYSTATE");
      String appartmentaccessorycountry = resultSet.getString("APPARTMENTACCESSORYCOUNTRY");
      String appartmentaccessoryzipcode = resultSet.getString("APPARTMENTACCESSORYZIPCODE");
      appartmentaccessory = new AppartmentAccessory();
      appartmentaccessory.setAppartmentAccessoryId(id);
      appartmentaccessory.setAppartmentAccessoryName(appartmentaccessoryname);
      appartmentaccessory.setAppartmentAccessoryAddress(appartmentaccessoryaddress);
      appartmentaccessory.setAppartmentAccessoryCity(appartmentaccessorycity);
      appartmentaccessory.setAppartmentAccessoryState(appartmentaccessorystate);
      appartmentaccessory.setAppartmentAccessoryCountry(appartmentaccessorycountry);
      appartmentaccessory.setAppartmentAccessoryZipCode(appartmentaccessoryzipcode);
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
  return appartmentaccessory;
 }

public void deleteAppartmentAccessory(AppartmentAccessory appartmentaccessory)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, appartmentaccessory.getAppartmentAccessoryId());
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

public void insertAppartmentAccessory(AppartmentAccessory appartmentaccessory)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,appartmentaccessory.getAppartmentAccessoryName());
    preparedStatement.setString(3,appartmentaccessory.getAppartmentAccessoryAddress());
    preparedStatement.setString(4,appartmentaccessory.getAppartmentAccessoryCity());
    preparedStatement.setString(5,appartmentaccessory.getAppartmentAccessoryState());
    preparedStatement.setString(6,appartmentaccessory.getAppartmentAccessoryCountry());
    preparedStatement.setString(7,appartmentaccessory.getAppartmentAccessoryZipCode());
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

public void updateAppartmentAccessory(AppartmentAccessory appartmentaccessory)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,appartmentaccessory.getAppartmentAccessoryName());
    preparedStatement.setString(2,appartmentaccessory.getAppartmentAccessoryAddress());
    preparedStatement.setString(3,appartmentaccessory.getAppartmentAccessoryCity());
    preparedStatement.setString(4,appartmentaccessory.getAppartmentAccessoryState());
    preparedStatement.setString(5,appartmentaccessory.getAppartmentAccessoryCountry());
    preparedStatement.setString(6,appartmentaccessory.getAppartmentAccessoryZipCode());
    preparedStatement.setInt(7, appartmentaccessory.getAppartmentAccessoryId());
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

public List<AppartmentAccessory> getAppartmentAccessorys( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<AppartmentAccessory> appartmentaccessoryList = new ArrayList<AppartmentAccessory>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("APPARTMENTACCESSORYID");
      String appartmentaccessoryname = resultSet.getString("APPARTMENTACCESSORYNAME");
      String appartmentaccessoryaddress = resultSet.getString("APPARTMENTACCESSORYADDRESS");
      String appartmentaccessorycity = resultSet.getString("APPARTMENTACCESSORYCITY");
      String appartmentaccessorystate = resultSet.getString("APPARTMENTACCESSORYSTATE");
      String appartmentaccessorycountry = resultSet.getString("APPARTMENTACCESSORYCOUNTRY");
      String appartmentaccessoryzipcode = resultSet.getString("APPARTMENTACCESSORYZIPCODE");
      AppartmentAccessory appartmentaccessory = new AppartmentAccessory();
      appartmentaccessory.setAppartmentAccessoryId(id);
      appartmentaccessory.setAppartmentAccessoryName(appartmentaccessoryname);
      appartmentaccessory.setAppartmentAccessoryAddress(appartmentaccessoryaddress);
      appartmentaccessory.setAppartmentAccessoryCity(appartmentaccessorycity);
      appartmentaccessory.setAppartmentAccessoryState(appartmentaccessorystate);
      appartmentaccessory.setAppartmentAccessoryCountry(appartmentaccessorycountry);
      appartmentaccessory.setAppartmentAccessoryZipCode(appartmentaccessoryzipcode);
       appartmentaccessoryList.add(appartmentaccessory);
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
  return appartmentaccessoryList;
 }

public static void main( String[] args ) {
}

} 

