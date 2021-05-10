import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Lab;
import org.archcorner.chartreuse.util.JDBCManager;

public class LabDAO{ 


private String highestIDSQL = "SELECT MAX(LABID) AS MAXLABID FROM LAB";
private String selectSQL = "SELECT * FROM LAB WHERE LABNAME=?";
private String selectIdSQL = "SELECT * FROM LAB WHERE LABID=?";
private String insertSQL = "INSERT INTO LAB(LABID,LABNAME,LABADDRESS,LABCITY,LABSTATE,LABCOUNTRY,LABZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE LAB SET LABNAME=?,LABADDRESS=?,LABCITY=?,LABSTATE=?,LABCOUNTRY=?,LABZIPCODE=? WHERE LABID=?";
private String deleteSQL = "DELETE FROM LAB WHERE LABID=?";
private String selectAllSQL = "SELECT * FROM LAB";

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
    highestId = resultSet.getInt("MAXLABID");
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

public Lab getLabById(int labid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Lab lab = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, labid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("labid");
      String labname = resultSet.getString("LABNAME");
      String labaddress = resultSet.getString("LABADDRESS");
      String labcity = resultSet.getString("LABCITY");
      String labstate = resultSet.getString("LABSTATE");
      String labcountry = resultSet.getString("LABCOUNTRY");
      String labzipcode = resultSet.getString("LABZIPCODE");
      lab = new Lab();
      lab.setLabId(id);
      lab.setLabName(labname);
      lab.setLabAddress(labaddress);
      lab.setLabCity(labcity);
      lab.setLabState(labstate);
      lab.setLabCountry(labcountry);
      lab.setLabZipCode(labzipcode);
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
  return lab;
 }

public Lab getLab(String labname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Lab lab = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, labname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("LabId");
      labname = resultSet.getString("LABNAME");
      String labaddress = resultSet.getString("LABADDRESS");
      String labcity = resultSet.getString("LABCITY");
      String labstate = resultSet.getString("LABSTATE");
      String labcountry = resultSet.getString("LABCOUNTRY");
      String labzipcode = resultSet.getString("LABZIPCODE");
      lab = new Lab();
      lab.setLabId(id);
      lab.setLabName(labname);
      lab.setLabAddress(labaddress);
      lab.setLabCity(labcity);
      lab.setLabState(labstate);
      lab.setLabCountry(labcountry);
      lab.setLabZipCode(labzipcode);
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
  return lab;
 }

public void deleteLab(Lab lab)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, lab.getLabId());
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

public void insertLab(Lab lab)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,lab.getLabName());
    preparedStatement.setString(3,lab.getLabAddress());
    preparedStatement.setString(4,lab.getLabCity());
    preparedStatement.setString(5,lab.getLabState());
    preparedStatement.setString(6,lab.getLabCountry());
    preparedStatement.setString(7,lab.getLabZipCode());
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

public void updateLab(Lab lab)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,lab.getLabName());
    preparedStatement.setString(2,lab.getLabAddress());
    preparedStatement.setString(3,lab.getLabCity());
    preparedStatement.setString(4,lab.getLabState());
    preparedStatement.setString(5,lab.getLabCountry());
    preparedStatement.setString(6,lab.getLabZipCode());
    preparedStatement.setInt(7, lab.getLabId());
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

public List<Lab> getLabs( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Lab> labList = new ArrayList<Lab>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("LABID");
      String labname = resultSet.getString("LABNAME");
      String labaddress = resultSet.getString("LABADDRESS");
      String labcity = resultSet.getString("LABCITY");
      String labstate = resultSet.getString("LABSTATE");
      String labcountry = resultSet.getString("LABCOUNTRY");
      String labzipcode = resultSet.getString("LABZIPCODE");
      Lab lab = new Lab();
      lab.setLabId(id);
      lab.setLabName(labname);
      lab.setLabAddress(labaddress);
      lab.setLabCity(labcity);
      lab.setLabState(labstate);
      lab.setLabCountry(labcountry);
      lab.setLabZipCode(labzipcode);
       labList.add(lab);
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
  return labList;
 }

public static void main( String[] args ) {
}

} 

