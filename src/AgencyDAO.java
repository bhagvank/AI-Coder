import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Agency;
import org.archcorner.chartreuse.util.JDBCManager;

public class AgencyDAO{ 


private String highestIDSQL = "SELECT MAX(AGENCYID) AS MAXAGENCYID FROM AGENCY";
private String selectSQL = "SELECT * FROM AGENCY WHERE AGENCYNAME=?";
private String selectIdSQL = "SELECT * FROM AGENCY WHERE AGENCYID=?";
private String insertSQL = "INSERT INTO AGENCY(AGENCYID,AGENCYNAME,AGENCYADDRESS,AGENCYCITY,AGENCYSTATE,AGENCYCOUNTRY,AGENCYZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE AGENCY SET AGENCYNAME=?,AGENCYADDRESS=?,AGENCYCITY=?,AGENCYSTATE=?,AGENCYCOUNTRY=?,AGENCYZIPCODE=? WHERE AGENCYID=?";
private String deleteSQL = "DELETE FROM AGENCY WHERE AGENCYID=?";
private String selectAllSQL = "SELECT * FROM AGENCY";

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
    highestId = resultSet.getInt("MAXAGENCYID");
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

public Agency getAgencyById(int agencyid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Agency agency = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, agencyid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("agencyid");
      String agencyname = resultSet.getString("AGENCYNAME");
      String agencyaddress = resultSet.getString("AGENCYADDRESS");
      String agencycity = resultSet.getString("AGENCYCITY");
      String agencystate = resultSet.getString("AGENCYSTATE");
      String agencycountry = resultSet.getString("AGENCYCOUNTRY");
      String agencyzipcode = resultSet.getString("AGENCYZIPCODE");
      agency = new Agency();
      agency.setAgencyId(id);
      agency.setAgencyName(agencyname);
      agency.setAgencyAddress(agencyaddress);
      agency.setAgencyCity(agencycity);
      agency.setAgencyState(agencystate);
      agency.setAgencyCountry(agencycountry);
      agency.setAgencyZipCode(agencyzipcode);
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
  return agency;
 }

public Agency getAgency(String agencyname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Agency agency = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, agencyname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("AgencyId");
      agencyname = resultSet.getString("AGENCYNAME");
      String agencyaddress = resultSet.getString("AGENCYADDRESS");
      String agencycity = resultSet.getString("AGENCYCITY");
      String agencystate = resultSet.getString("AGENCYSTATE");
      String agencycountry = resultSet.getString("AGENCYCOUNTRY");
      String agencyzipcode = resultSet.getString("AGENCYZIPCODE");
      agency = new Agency();
      agency.setAgencyId(id);
      agency.setAgencyName(agencyname);
      agency.setAgencyAddress(agencyaddress);
      agency.setAgencyCity(agencycity);
      agency.setAgencyState(agencystate);
      agency.setAgencyCountry(agencycountry);
      agency.setAgencyZipCode(agencyzipcode);
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
  return agency;
 }

public void deleteAgency(Agency agency)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, agency.getAgencyId());
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

public void insertAgency(Agency agency)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,agency.getAgencyName());
    preparedStatement.setString(3,agency.getAgencyAddress());
    preparedStatement.setString(4,agency.getAgencyCity());
    preparedStatement.setString(5,agency.getAgencyState());
    preparedStatement.setString(6,agency.getAgencyCountry());
    preparedStatement.setString(7,agency.getAgencyZipCode());
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

public void updateAgency(Agency agency)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,agency.getAgencyName());
    preparedStatement.setString(2,agency.getAgencyAddress());
    preparedStatement.setString(3,agency.getAgencyCity());
    preparedStatement.setString(4,agency.getAgencyState());
    preparedStatement.setString(5,agency.getAgencyCountry());
    preparedStatement.setString(6,agency.getAgencyZipCode());
    preparedStatement.setInt(7, agency.getAgencyId());
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

public List<Agency> getAgencys( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Agency> agencyList = new ArrayList<Agency>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("AGENCYID");
      String agencyname = resultSet.getString("AGENCYNAME");
      String agencyaddress = resultSet.getString("AGENCYADDRESS");
      String agencycity = resultSet.getString("AGENCYCITY");
      String agencystate = resultSet.getString("AGENCYSTATE");
      String agencycountry = resultSet.getString("AGENCYCOUNTRY");
      String agencyzipcode = resultSet.getString("AGENCYZIPCODE");
      Agency agency = new Agency();
      agency.setAgencyId(id);
      agency.setAgencyName(agencyname);
      agency.setAgencyAddress(agencyaddress);
      agency.setAgencyCity(agencycity);
      agency.setAgencyState(agencystate);
      agency.setAgencyCountry(agencycountry);
      agency.setAgencyZipCode(agencyzipcode);
       agencyList.add(agency);
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
  return agencyList;
 }

public static void main( String[] args ) {
}

} 

