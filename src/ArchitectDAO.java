import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Architect;
import org.archcorner.chartreuse.util.JDBCManager;

public class ArchitectDAO{ 


private String highestIDSQL = "SELECT MAX(ARCHITECTID) AS MAXARCHITECTID FROM ARCHITECT";
private String selectSQL = "SELECT * FROM ARCHITECT WHERE ARCHITECTNAME=?";
private String selectIdSQL = "SELECT * FROM ARCHITECT WHERE ARCHITECTID=?";
private String insertSQL = "INSERT INTO ARCHITECT(ARCHITECTID,ARCHITECTNAME,ARCHITECTADDRESS,ARCHITECTCITY,ARCHITECTSTATE,ARCHITECTCOUNTRY,ARCHITECTZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE ARCHITECT SET ARCHITECTNAME=?,ARCHITECTADDRESS=?,ARCHITECTCITY=?,ARCHITECTSTATE=?,ARCHITECTCOUNTRY=?,ARCHITECTZIPCODE=? WHERE ARCHITECTID=?";
private String deleteSQL = "DELETE FROM ARCHITECT WHERE ARCHITECTID=?";
private String selectAllSQL = "SELECT * FROM ARCHITECT";

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
    highestId = resultSet.getInt("MAXARCHITECTID");
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

public Architect getArchitectById(int architectid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Architect architect = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, architectid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("architectid");
      String architectname = resultSet.getString("ARCHITECTNAME");
      String architectaddress = resultSet.getString("ARCHITECTADDRESS");
      String architectcity = resultSet.getString("ARCHITECTCITY");
      String architectstate = resultSet.getString("ARCHITECTSTATE");
      String architectcountry = resultSet.getString("ARCHITECTCOUNTRY");
      String architectzipcode = resultSet.getString("ARCHITECTZIPCODE");
      architect = new Architect();
      architect.setArchitectId(id);
      architect.setArchitectName(architectname);
      architect.setArchitectAddress(architectaddress);
      architect.setArchitectCity(architectcity);
      architect.setArchitectState(architectstate);
      architect.setArchitectCountry(architectcountry);
      architect.setArchitectZipCode(architectzipcode);
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
  return architect;
 }

public Architect getArchitect(String architectname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Architect architect = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, architectname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("ArchitectId");
      architectname = resultSet.getString("ARCHITECTNAME");
      String architectaddress = resultSet.getString("ARCHITECTADDRESS");
      String architectcity = resultSet.getString("ARCHITECTCITY");
      String architectstate = resultSet.getString("ARCHITECTSTATE");
      String architectcountry = resultSet.getString("ARCHITECTCOUNTRY");
      String architectzipcode = resultSet.getString("ARCHITECTZIPCODE");
      architect = new Architect();
      architect.setArchitectId(id);
      architect.setArchitectName(architectname);
      architect.setArchitectAddress(architectaddress);
      architect.setArchitectCity(architectcity);
      architect.setArchitectState(architectstate);
      architect.setArchitectCountry(architectcountry);
      architect.setArchitectZipCode(architectzipcode);
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
  return architect;
 }

public void deleteArchitect(Architect architect)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, architect.getArchitectId());
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

public void insertArchitect(Architect architect)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,architect.getArchitectName());
    preparedStatement.setString(3,architect.getArchitectAddress());
    preparedStatement.setString(4,architect.getArchitectCity());
    preparedStatement.setString(5,architect.getArchitectState());
    preparedStatement.setString(6,architect.getArchitectCountry());
    preparedStatement.setString(7,architect.getArchitectZipCode());
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

public void updateArchitect(Architect architect)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,architect.getArchitectName());
    preparedStatement.setString(2,architect.getArchitectAddress());
    preparedStatement.setString(3,architect.getArchitectCity());
    preparedStatement.setString(4,architect.getArchitectState());
    preparedStatement.setString(5,architect.getArchitectCountry());
    preparedStatement.setString(6,architect.getArchitectZipCode());
    preparedStatement.setInt(7, architect.getArchitectId());
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

public List<Architect> getArchitects( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Architect> architectList = new ArrayList<Architect>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("ARCHITECTID");
      String architectname = resultSet.getString("ARCHITECTNAME");
      String architectaddress = resultSet.getString("ARCHITECTADDRESS");
      String architectcity = resultSet.getString("ARCHITECTCITY");
      String architectstate = resultSet.getString("ARCHITECTSTATE");
      String architectcountry = resultSet.getString("ARCHITECTCOUNTRY");
      String architectzipcode = resultSet.getString("ARCHITECTZIPCODE");
      Architect architect = new Architect();
      architect.setArchitectId(id);
      architect.setArchitectName(architectname);
      architect.setArchitectAddress(architectaddress);
      architect.setArchitectCity(architectcity);
      architect.setArchitectState(architectstate);
      architect.setArchitectCountry(architectcountry);
      architect.setArchitectZipCode(architectzipcode);
       architectList.add(architect);
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
  return architectList;
 }

public static void main( String[] args ) {
}

} 

