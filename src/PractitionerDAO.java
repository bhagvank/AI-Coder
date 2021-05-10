import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Practitioner;
import org.archcorner.chartreuse.util.JDBCManager;

public class PractitionerDAO{ 


private String highestIDSQL = "SELECT MAX(PRACTITIONERID) AS MAXPRACTITIONERID FROM PRACTITIONER";
private String selectSQL = "SELECT * FROM PRACTITIONER WHERE PRACTITIONERNAME=?";
private String selectIdSQL = "SELECT * FROM PRACTITIONER WHERE PRACTITIONERID=?";
private String insertSQL = "INSERT INTO PRACTITIONER(PRACTITIONERID,PRACTITIONERNAME,PRACTITIONERADDRESS,PRACTITIONERCITY,PRACTITIONERSTATE,PRACTITIONERCOUNTRY,PRACTITIONERZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE PRACTITIONER SET PRACTITIONERNAME=?,PRACTITIONERADDRESS=?,PRACTITIONERCITY=?,PRACTITIONERSTATE=?,PRACTITIONERCOUNTRY=?,PRACTITIONERZIPCODE=? WHERE PRACTITIONERID=?";
private String deleteSQL = "DELETE FROM PRACTITIONER WHERE PRACTITIONERID=?";
private String selectAllSQL = "SELECT * FROM PRACTITIONER";

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
    highestId = resultSet.getInt("MAXPRACTITIONERID");
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

public Practitioner getPractitionerById(int practitionerid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Practitioner practitioner = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, practitionerid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("practitionerid");
      String practitionername = resultSet.getString("PRACTITIONERNAME");
      String practitioneraddress = resultSet.getString("PRACTITIONERADDRESS");
      String practitionercity = resultSet.getString("PRACTITIONERCITY");
      String practitionerstate = resultSet.getString("PRACTITIONERSTATE");
      String practitionercountry = resultSet.getString("PRACTITIONERCOUNTRY");
      String practitionerzipcode = resultSet.getString("PRACTITIONERZIPCODE");
      practitioner = new Practitioner();
      practitioner.setPractitionerId(id);
      practitioner.setPractitionerName(practitionername);
      practitioner.setPractitionerAddress(practitioneraddress);
      practitioner.setPractitionerCity(practitionercity);
      practitioner.setPractitionerState(practitionerstate);
      practitioner.setPractitionerCountry(practitionercountry);
      practitioner.setPractitionerZipCode(practitionerzipcode);
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
  return practitioner;
 }

public Practitioner getPractitioner(String practitionername)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Practitioner practitioner = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, practitionername);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("PractitionerId");
      practitionername = resultSet.getString("PRACTITIONERNAME");
      String practitioneraddress = resultSet.getString("PRACTITIONERADDRESS");
      String practitionercity = resultSet.getString("PRACTITIONERCITY");
      String practitionerstate = resultSet.getString("PRACTITIONERSTATE");
      String practitionercountry = resultSet.getString("PRACTITIONERCOUNTRY");
      String practitionerzipcode = resultSet.getString("PRACTITIONERZIPCODE");
      practitioner = new Practitioner();
      practitioner.setPractitionerId(id);
      practitioner.setPractitionerName(practitionername);
      practitioner.setPractitionerAddress(practitioneraddress);
      practitioner.setPractitionerCity(practitionercity);
      practitioner.setPractitionerState(practitionerstate);
      practitioner.setPractitionerCountry(practitionercountry);
      practitioner.setPractitionerZipCode(practitionerzipcode);
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
  return practitioner;
 }

public void deletePractitioner(Practitioner practitioner)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, practitioner.getPractitionerId());
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

public void insertPractitioner(Practitioner practitioner)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,practitioner.getPractitionerName());
    preparedStatement.setString(3,practitioner.getPractitionerAddress());
    preparedStatement.setString(4,practitioner.getPractitionerCity());
    preparedStatement.setString(5,practitioner.getPractitionerState());
    preparedStatement.setString(6,practitioner.getPractitionerCountry());
    preparedStatement.setString(7,practitioner.getPractitionerZipCode());
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

public void updatePractitioner(Practitioner practitioner)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,practitioner.getPractitionerName());
    preparedStatement.setString(2,practitioner.getPractitionerAddress());
    preparedStatement.setString(3,practitioner.getPractitionerCity());
    preparedStatement.setString(4,practitioner.getPractitionerState());
    preparedStatement.setString(5,practitioner.getPractitionerCountry());
    preparedStatement.setString(6,practitioner.getPractitionerZipCode());
    preparedStatement.setInt(7, practitioner.getPractitionerId());
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

public List<Practitioner> getPractitioners( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Practitioner> practitionerList = new ArrayList<Practitioner>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("PRACTITIONERID");
      String practitionername = resultSet.getString("PRACTITIONERNAME");
      String practitioneraddress = resultSet.getString("PRACTITIONERADDRESS");
      String practitionercity = resultSet.getString("PRACTITIONERCITY");
      String practitionerstate = resultSet.getString("PRACTITIONERSTATE");
      String practitionercountry = resultSet.getString("PRACTITIONERCOUNTRY");
      String practitionerzipcode = resultSet.getString("PRACTITIONERZIPCODE");
      Practitioner practitioner = new Practitioner();
      practitioner.setPractitionerId(id);
      practitioner.setPractitionerName(practitionername);
      practitioner.setPractitionerAddress(practitioneraddress);
      practitioner.setPractitionerCity(practitionercity);
      practitioner.setPractitionerState(practitionerstate);
      practitioner.setPractitionerCountry(practitionercountry);
      practitioner.setPractitionerZipCode(practitionerzipcode);
       practitionerList.add(practitioner);
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
  return practitionerList;
 }

public static void main( String[] args ) {
}

} 

