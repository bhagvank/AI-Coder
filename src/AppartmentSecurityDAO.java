import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.AppartmentSecurity;
import org.archcorner.chartreuse.util.JDBCManager;

public class AppartmentSecurityDAO{ 


private String highestIDSQL = "SELECT MAX(APPARTMENTSECURITYID) AS MAXAPPARTMENTSECURITYID FROM APPARTMENTSECURITY";
private String selectSQL = "SELECT * FROM APPARTMENTSECURITY WHERE APPARTMENTSECURITYNAME=?";
private String selectIdSQL = "SELECT * FROM APPARTMENTSECURITY WHERE APPARTMENTSECURITYID=?";
private String insertSQL = "INSERT INTO APPARTMENTSECURITY(APPARTMENTSECURITYID,APPARTMENTSECURITYNAME,APPARTMENTSECURITYADDRESS,APPARTMENTSECURITYCITY,APPARTMENTSECURITYSTATE,APPARTMENTSECURITYCOUNTRY,APPARTMENTSECURITYZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE APPARTMENTSECURITY SET APPARTMENTSECURITYNAME=?,APPARTMENTSECURITYADDRESS=?,APPARTMENTSECURITYCITY=?,APPARTMENTSECURITYSTATE=?,APPARTMENTSECURITYCOUNTRY=?,APPARTMENTSECURITYZIPCODE=? WHERE APPARTMENTSECURITYID=?";
private String deleteSQL = "DELETE FROM APPARTMENTSECURITY WHERE APPARTMENTSECURITYID=?";
private String selectAllSQL = "SELECT * FROM APPARTMENTSECURITY";

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
    highestId = resultSet.getInt("MAXAPPARTMENTSECURITYID");
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

public AppartmentSecurity getAppartmentSecurityById(int appartmentsecurityid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   AppartmentSecurity appartmentsecurity = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, appartmentsecurityid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("appartmentsecurityid");
      String appartmentsecurityname = resultSet.getString("APPARTMENTSECURITYNAME");
      String appartmentsecurityaddress = resultSet.getString("APPARTMENTSECURITYADDRESS");
      String appartmentsecuritycity = resultSet.getString("APPARTMENTSECURITYCITY");
      String appartmentsecuritystate = resultSet.getString("APPARTMENTSECURITYSTATE");
      String appartmentsecuritycountry = resultSet.getString("APPARTMENTSECURITYCOUNTRY");
      String appartmentsecurityzipcode = resultSet.getString("APPARTMENTSECURITYZIPCODE");
      appartmentsecurity = new AppartmentSecurity();
      appartmentsecurity.setAppartmentSecurityId(id);
      appartmentsecurity.setAppartmentSecurityName(appartmentsecurityname);
      appartmentsecurity.setAppartmentSecurityAddress(appartmentsecurityaddress);
      appartmentsecurity.setAppartmentSecurityCity(appartmentsecuritycity);
      appartmentsecurity.setAppartmentSecurityState(appartmentsecuritystate);
      appartmentsecurity.setAppartmentSecurityCountry(appartmentsecuritycountry);
      appartmentsecurity.setAppartmentSecurityZipCode(appartmentsecurityzipcode);
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
  return appartmentsecurity;
 }

public AppartmentSecurity getAppartmentSecurity(String appartmentsecurityname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   AppartmentSecurity appartmentsecurity = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, appartmentsecurityname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("AppartmentSecurityId");
      appartmentsecurityname = resultSet.getString("APPARTMENTSECURITYNAME");
      String appartmentsecurityaddress = resultSet.getString("APPARTMENTSECURITYADDRESS");
      String appartmentsecuritycity = resultSet.getString("APPARTMENTSECURITYCITY");
      String appartmentsecuritystate = resultSet.getString("APPARTMENTSECURITYSTATE");
      String appartmentsecuritycountry = resultSet.getString("APPARTMENTSECURITYCOUNTRY");
      String appartmentsecurityzipcode = resultSet.getString("APPARTMENTSECURITYZIPCODE");
      appartmentsecurity = new AppartmentSecurity();
      appartmentsecurity.setAppartmentSecurityId(id);
      appartmentsecurity.setAppartmentSecurityName(appartmentsecurityname);
      appartmentsecurity.setAppartmentSecurityAddress(appartmentsecurityaddress);
      appartmentsecurity.setAppartmentSecurityCity(appartmentsecuritycity);
      appartmentsecurity.setAppartmentSecurityState(appartmentsecuritystate);
      appartmentsecurity.setAppartmentSecurityCountry(appartmentsecuritycountry);
      appartmentsecurity.setAppartmentSecurityZipCode(appartmentsecurityzipcode);
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
  return appartmentsecurity;
 }

public void deleteAppartmentSecurity(AppartmentSecurity appartmentsecurity)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, appartmentsecurity.getAppartmentSecurityId());
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

public void insertAppartmentSecurity(AppartmentSecurity appartmentsecurity)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,appartmentsecurity.getAppartmentSecurityName());
    preparedStatement.setString(3,appartmentsecurity.getAppartmentSecurityAddress());
    preparedStatement.setString(4,appartmentsecurity.getAppartmentSecurityCity());
    preparedStatement.setString(5,appartmentsecurity.getAppartmentSecurityState());
    preparedStatement.setString(6,appartmentsecurity.getAppartmentSecurityCountry());
    preparedStatement.setString(7,appartmentsecurity.getAppartmentSecurityZipCode());
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

public void updateAppartmentSecurity(AppartmentSecurity appartmentsecurity)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,appartmentsecurity.getAppartmentSecurityName());
    preparedStatement.setString(2,appartmentsecurity.getAppartmentSecurityAddress());
    preparedStatement.setString(3,appartmentsecurity.getAppartmentSecurityCity());
    preparedStatement.setString(4,appartmentsecurity.getAppartmentSecurityState());
    preparedStatement.setString(5,appartmentsecurity.getAppartmentSecurityCountry());
    preparedStatement.setString(6,appartmentsecurity.getAppartmentSecurityZipCode());
    preparedStatement.setInt(7, appartmentsecurity.getAppartmentSecurityId());
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

public List<AppartmentSecurity> getAppartmentSecuritys( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<AppartmentSecurity> appartmentsecurityList = new ArrayList<AppartmentSecurity>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("APPARTMENTSECURITYID");
      String appartmentsecurityname = resultSet.getString("APPARTMENTSECURITYNAME");
      String appartmentsecurityaddress = resultSet.getString("APPARTMENTSECURITYADDRESS");
      String appartmentsecuritycity = resultSet.getString("APPARTMENTSECURITYCITY");
      String appartmentsecuritystate = resultSet.getString("APPARTMENTSECURITYSTATE");
      String appartmentsecuritycountry = resultSet.getString("APPARTMENTSECURITYCOUNTRY");
      String appartmentsecurityzipcode = resultSet.getString("APPARTMENTSECURITYZIPCODE");
      AppartmentSecurity appartmentsecurity = new AppartmentSecurity();
      appartmentsecurity.setAppartmentSecurityId(id);
      appartmentsecurity.setAppartmentSecurityName(appartmentsecurityname);
      appartmentsecurity.setAppartmentSecurityAddress(appartmentsecurityaddress);
      appartmentsecurity.setAppartmentSecurityCity(appartmentsecuritycity);
      appartmentsecurity.setAppartmentSecurityState(appartmentsecuritystate);
      appartmentsecurity.setAppartmentSecurityCountry(appartmentsecuritycountry);
      appartmentsecurity.setAppartmentSecurityZipCode(appartmentsecurityzipcode);
       appartmentsecurityList.add(appartmentsecurity);
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
  return appartmentsecurityList;
 }

public static void main( String[] args ) {
}

} 

