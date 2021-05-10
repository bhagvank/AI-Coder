import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Corporation;
import org.archcorner.chartreuse.util.JDBCManager;

public class CorporationDAO{ 


private String highestIDSQL = "SELECT MAX(CORPORATIONID) AS MAXCORPORATIONID FROM CORPORATION";
private String selectSQL = "SELECT * FROM CORPORATION WHERE CORPORATIONNAME=?";
private String selectIdSQL = "SELECT * FROM CORPORATION WHERE CORPORATIONID=?";
private String insertSQL = "INSERT INTO CORPORATION(CORPORATIONID,CORPORATIONNAME,CORPORATIONADDRESS,CORPORATIONCITY,CORPORATIONSTATE,CORPORATIONCOUNTRY,CORPORATIONZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE CORPORATION SET CORPORATIONNAME=?,CORPORATIONADDRESS=?,CORPORATIONCITY=?,CORPORATIONSTATE=?,CORPORATIONCOUNTRY=?,CORPORATIONZIPCODE=? WHERE CORPORATIONID=?";
private String deleteSQL = "DELETE FROM CORPORATION WHERE CORPORATIONID=?";
private String selectAllSQL = "SELECT * FROM CORPORATION";

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
    highestId = resultSet.getInt("MAXCORPORATIONID");
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

public Corporation getCorporationById(int corporationid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Corporation corporation = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, corporationid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("corporationid");
      String corporationname = resultSet.getString("CORPORATIONNAME");
      String corporationaddress = resultSet.getString("CORPORATIONADDRESS");
      String corporationcity = resultSet.getString("CORPORATIONCITY");
      String corporationstate = resultSet.getString("CORPORATIONSTATE");
      String corporationcountry = resultSet.getString("CORPORATIONCOUNTRY");
      String corporationzipcode = resultSet.getString("CORPORATIONZIPCODE");
      corporation = new Corporation();
      corporation.setCorporationId(id);
      corporation.setCorporationName(corporationname);
      corporation.setCorporationAddress(corporationaddress);
      corporation.setCorporationCity(corporationcity);
      corporation.setCorporationState(corporationstate);
      corporation.setCorporationCountry(corporationcountry);
      corporation.setCorporationZipCode(corporationzipcode);
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
  return corporation;
 }

public Corporation getCorporation(String corporationname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Corporation corporation = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, corporationname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("CorporationId");
      corporationname = resultSet.getString("CORPORATIONNAME");
      String corporationaddress = resultSet.getString("CORPORATIONADDRESS");
      String corporationcity = resultSet.getString("CORPORATIONCITY");
      String corporationstate = resultSet.getString("CORPORATIONSTATE");
      String corporationcountry = resultSet.getString("CORPORATIONCOUNTRY");
      String corporationzipcode = resultSet.getString("CORPORATIONZIPCODE");
      corporation = new Corporation();
      corporation.setCorporationId(id);
      corporation.setCorporationName(corporationname);
      corporation.setCorporationAddress(corporationaddress);
      corporation.setCorporationCity(corporationcity);
      corporation.setCorporationState(corporationstate);
      corporation.setCorporationCountry(corporationcountry);
      corporation.setCorporationZipCode(corporationzipcode);
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
  return corporation;
 }

public void deleteCorporation(Corporation corporation)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, corporation.getCorporationId());
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

public void insertCorporation(Corporation corporation)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,corporation.getCorporationName());
    preparedStatement.setString(3,corporation.getCorporationAddress());
    preparedStatement.setString(4,corporation.getCorporationCity());
    preparedStatement.setString(5,corporation.getCorporationState());
    preparedStatement.setString(6,corporation.getCorporationCountry());
    preparedStatement.setString(7,corporation.getCorporationZipCode());
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

public void updateCorporation(Corporation corporation)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,corporation.getCorporationName());
    preparedStatement.setString(2,corporation.getCorporationAddress());
    preparedStatement.setString(3,corporation.getCorporationCity());
    preparedStatement.setString(4,corporation.getCorporationState());
    preparedStatement.setString(5,corporation.getCorporationCountry());
    preparedStatement.setString(6,corporation.getCorporationZipCode());
    preparedStatement.setInt(7, corporation.getCorporationId());
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

public List<Corporation> getCorporations( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Corporation> corporationList = new ArrayList<Corporation>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("CORPORATIONID");
      String corporationname = resultSet.getString("CORPORATIONNAME");
      String corporationaddress = resultSet.getString("CORPORATIONADDRESS");
      String corporationcity = resultSet.getString("CORPORATIONCITY");
      String corporationstate = resultSet.getString("CORPORATIONSTATE");
      String corporationcountry = resultSet.getString("CORPORATIONCOUNTRY");
      String corporationzipcode = resultSet.getString("CORPORATIONZIPCODE");
      Corporation corporation = new Corporation();
      corporation.setCorporationId(id);
      corporation.setCorporationName(corporationname);
      corporation.setCorporationAddress(corporationaddress);
      corporation.setCorporationCity(corporationcity);
      corporation.setCorporationState(corporationstate);
      corporation.setCorporationCountry(corporationcountry);
      corporation.setCorporationZipCode(corporationzipcode);
       corporationList.add(corporation);
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
  return corporationList;
 }

public static void main( String[] args ) {
}

} 

