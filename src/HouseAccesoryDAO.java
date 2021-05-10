import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.HouseAccesory;
import org.archcorner.chartreuse.util.JDBCManager;

public class HouseAccesoryDAO{ 


private String highestIDSQL = "SELECT MAX(HOUSEACCESORYID) AS MAXHOUSEACCESORYID FROM HOUSEACCESORY";
private String selectSQL = "SELECT * FROM HOUSEACCESORY WHERE HOUSEACCESORYNAME=?";
private String selectIdSQL = "SELECT * FROM HOUSEACCESORY WHERE HOUSEACCESORYID=?";
private String insertSQL = "INSERT INTO HOUSEACCESORY(HOUSEACCESORYID,HOUSEACCESORYNAME,HOUSEACCESORYADDRESS,HOUSEACCESORYCITY,HOUSEACCESORYSTATE,HOUSEACCESORYCOUNTRY,HOUSEACCESORYZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE HOUSEACCESORY SET HOUSEACCESORYNAME=?,HOUSEACCESORYADDRESS=?,HOUSEACCESORYCITY=?,HOUSEACCESORYSTATE=?,HOUSEACCESORYCOUNTRY=?,HOUSEACCESORYZIPCODE=? WHERE HOUSEACCESORYID=?";
private String deleteSQL = "DELETE FROM HOUSEACCESORY WHERE HOUSEACCESORYID=?";
private String selectAllSQL = "SELECT * FROM HOUSEACCESORY";

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
    highestId = resultSet.getInt("MAXHOUSEACCESORYID");
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

public HouseAccesory getHouseAccesoryById(int houseaccesoryid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   HouseAccesory houseaccesory = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, houseaccesoryid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("houseaccesoryid");
      String houseaccesoryname = resultSet.getString("HOUSEACCESORYNAME");
      String houseaccesoryaddress = resultSet.getString("HOUSEACCESORYADDRESS");
      String houseaccesorycity = resultSet.getString("HOUSEACCESORYCITY");
      String houseaccesorystate = resultSet.getString("HOUSEACCESORYSTATE");
      String houseaccesorycountry = resultSet.getString("HOUSEACCESORYCOUNTRY");
      String houseaccesoryzipcode = resultSet.getString("HOUSEACCESORYZIPCODE");
      houseaccesory = new HouseAccesory();
      houseaccesory.setHouseAccesoryId(id);
      houseaccesory.setHouseAccesoryName(houseaccesoryname);
      houseaccesory.setHouseAccesoryAddress(houseaccesoryaddress);
      houseaccesory.setHouseAccesoryCity(houseaccesorycity);
      houseaccesory.setHouseAccesoryState(houseaccesorystate);
      houseaccesory.setHouseAccesoryCountry(houseaccesorycountry);
      houseaccesory.setHouseAccesoryZipCode(houseaccesoryzipcode);
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
  return houseaccesory;
 }

public HouseAccesory getHouseAccesory(String houseaccesoryname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   HouseAccesory houseaccesory = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, houseaccesoryname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("HouseAccesoryId");
      houseaccesoryname = resultSet.getString("HOUSEACCESORYNAME");
      String houseaccesoryaddress = resultSet.getString("HOUSEACCESORYADDRESS");
      String houseaccesorycity = resultSet.getString("HOUSEACCESORYCITY");
      String houseaccesorystate = resultSet.getString("HOUSEACCESORYSTATE");
      String houseaccesorycountry = resultSet.getString("HOUSEACCESORYCOUNTRY");
      String houseaccesoryzipcode = resultSet.getString("HOUSEACCESORYZIPCODE");
      houseaccesory = new HouseAccesory();
      houseaccesory.setHouseAccesoryId(id);
      houseaccesory.setHouseAccesoryName(houseaccesoryname);
      houseaccesory.setHouseAccesoryAddress(houseaccesoryaddress);
      houseaccesory.setHouseAccesoryCity(houseaccesorycity);
      houseaccesory.setHouseAccesoryState(houseaccesorystate);
      houseaccesory.setHouseAccesoryCountry(houseaccesorycountry);
      houseaccesory.setHouseAccesoryZipCode(houseaccesoryzipcode);
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
  return houseaccesory;
 }

public void deleteHouseAccesory(HouseAccesory houseaccesory)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, houseaccesory.getHouseAccesoryId());
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

public void insertHouseAccesory(HouseAccesory houseaccesory)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,houseaccesory.getHouseAccesoryName());
    preparedStatement.setString(3,houseaccesory.getHouseAccesoryAddress());
    preparedStatement.setString(4,houseaccesory.getHouseAccesoryCity());
    preparedStatement.setString(5,houseaccesory.getHouseAccesoryState());
    preparedStatement.setString(6,houseaccesory.getHouseAccesoryCountry());
    preparedStatement.setString(7,houseaccesory.getHouseAccesoryZipCode());
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

public void updateHouseAccesory(HouseAccesory houseaccesory)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,houseaccesory.getHouseAccesoryName());
    preparedStatement.setString(2,houseaccesory.getHouseAccesoryAddress());
    preparedStatement.setString(3,houseaccesory.getHouseAccesoryCity());
    preparedStatement.setString(4,houseaccesory.getHouseAccesoryState());
    preparedStatement.setString(5,houseaccesory.getHouseAccesoryCountry());
    preparedStatement.setString(6,houseaccesory.getHouseAccesoryZipCode());
    preparedStatement.setInt(7, houseaccesory.getHouseAccesoryId());
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

public List<HouseAccesory> getHouseAccesorys( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<HouseAccesory> houseaccesoryList = new ArrayList<HouseAccesory>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("HOUSEACCESORYID");
      String houseaccesoryname = resultSet.getString("HOUSEACCESORYNAME");
      String houseaccesoryaddress = resultSet.getString("HOUSEACCESORYADDRESS");
      String houseaccesorycity = resultSet.getString("HOUSEACCESORYCITY");
      String houseaccesorystate = resultSet.getString("HOUSEACCESORYSTATE");
      String houseaccesorycountry = resultSet.getString("HOUSEACCESORYCOUNTRY");
      String houseaccesoryzipcode = resultSet.getString("HOUSEACCESORYZIPCODE");
      HouseAccesory houseaccesory = new HouseAccesory();
      houseaccesory.setHouseAccesoryId(id);
      houseaccesory.setHouseAccesoryName(houseaccesoryname);
      houseaccesory.setHouseAccesoryAddress(houseaccesoryaddress);
      houseaccesory.setHouseAccesoryCity(houseaccesorycity);
      houseaccesory.setHouseAccesoryState(houseaccesorystate);
      houseaccesory.setHouseAccesoryCountry(houseaccesorycountry);
      houseaccesory.setHouseAccesoryZipCode(houseaccesoryzipcode);
       houseaccesoryList.add(houseaccesory);
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
  return houseaccesoryList;
 }

public static void main( String[] args ) {
}

} 

