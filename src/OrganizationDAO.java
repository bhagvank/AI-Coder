import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Organization;
import org.archcorner.chartreuse.util.JDBCManager;

public class OrganizationDAO{ 


private String highestIDSQL = "SELECT MAX(ORGANIZATIONID) AS MAXORGANIZATIONID FROM ORGANIZATION";
private String selectSQL = "SELECT * FROM ORGANIZATION WHERE ORGANIZATIONNAME=?";
private String selectIdSQL = "SELECT * FROM ORGANIZATION WHERE ORGANIZATIONID=?";
private String insertSQL = "INSERT INTO ORGANIZATION(ORGANIZATIONID,ORGANIZATIONNAME,ORGANIZATIONADDRESS,ORGANIZATIONCITY,ORGANIZATIONSTATE,ORGANIZATIONCOUNTRY,ORGANIZATIONZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE ORGANIZATION SET ORGANIZATIONNAME=?,ORGANIZATIONADDRESS=?,ORGANIZATIONCITY=?,ORGANIZATIONSTATE=?,ORGANIZATIONCOUNTRY=?,ORGANIZATIONZIPCODE=? WHERE ORGANIZATIONID=?";
private String deleteSQL = "DELETE FROM ORGANIZATION WHERE ORGANIZATIONID=?";
private String selectAllSQL = "SELECT * FROM ORGANIZATION";

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
    highestId = resultSet.getInt("MAXORGANIZATIONID");
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

public Organization getOrganizationById(int organizationid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Organization organization = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, organizationid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("organizationid");
      String organizationname = resultSet.getString("ORGANIZATIONNAME");
      String organizationaddress = resultSet.getString("ORGANIZATIONADDRESS");
      String organizationcity = resultSet.getString("ORGANIZATIONCITY");
      String organizationstate = resultSet.getString("ORGANIZATIONSTATE");
      String organizationcountry = resultSet.getString("ORGANIZATIONCOUNTRY");
      String organizationzipcode = resultSet.getString("ORGANIZATIONZIPCODE");
      organization = new Organization();
      organization.setOrganizationId(id);
      organization.setOrganizationName(organizationname);
      organization.setOrganizationAddress(organizationaddress);
      organization.setOrganizationCity(organizationcity);
      organization.setOrganizationState(organizationstate);
      organization.setOrganizationCountry(organizationcountry);
      organization.setOrganizationZipCode(organizationzipcode);
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
  return organization;
 }

public Organization getOrganization(String organizationname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Organization organization = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, organizationname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("OrganizationId");
      organizationname = resultSet.getString("ORGANIZATIONNAME");
      String organizationaddress = resultSet.getString("ORGANIZATIONADDRESS");
      String organizationcity = resultSet.getString("ORGANIZATIONCITY");
      String organizationstate = resultSet.getString("ORGANIZATIONSTATE");
      String organizationcountry = resultSet.getString("ORGANIZATIONCOUNTRY");
      String organizationzipcode = resultSet.getString("ORGANIZATIONZIPCODE");
      organization = new Organization();
      organization.setOrganizationId(id);
      organization.setOrganizationName(organizationname);
      organization.setOrganizationAddress(organizationaddress);
      organization.setOrganizationCity(organizationcity);
      organization.setOrganizationState(organizationstate);
      organization.setOrganizationCountry(organizationcountry);
      organization.setOrganizationZipCode(organizationzipcode);
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
  return organization;
 }

public void deleteOrganization(Organization organization)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, organization.getOrganizationId());
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

public void insertOrganization(Organization organization)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,organization.getOrganizationName());
    preparedStatement.setString(3,organization.getOrganizationAddress());
    preparedStatement.setString(4,organization.getOrganizationCity());
    preparedStatement.setString(5,organization.getOrganizationState());
    preparedStatement.setString(6,organization.getOrganizationCountry());
    preparedStatement.setString(7,organization.getOrganizationZipCode());
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

public void updateOrganization(Organization organization)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,organization.getOrganizationName());
    preparedStatement.setString(2,organization.getOrganizationAddress());
    preparedStatement.setString(3,organization.getOrganizationCity());
    preparedStatement.setString(4,organization.getOrganizationState());
    preparedStatement.setString(5,organization.getOrganizationCountry());
    preparedStatement.setString(6,organization.getOrganizationZipCode());
    preparedStatement.setInt(7, organization.getOrganizationId());
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

public List<Organization> getOrganizations( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Organization> organizationList = new ArrayList<Organization>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("ORGANIZATIONID");
      String organizationname = resultSet.getString("ORGANIZATIONNAME");
      String organizationaddress = resultSet.getString("ORGANIZATIONADDRESS");
      String organizationcity = resultSet.getString("ORGANIZATIONCITY");
      String organizationstate = resultSet.getString("ORGANIZATIONSTATE");
      String organizationcountry = resultSet.getString("ORGANIZATIONCOUNTRY");
      String organizationzipcode = resultSet.getString("ORGANIZATIONZIPCODE");
      Organization organization = new Organization();
      organization.setOrganizationId(id);
      organization.setOrganizationName(organizationname);
      organization.setOrganizationAddress(organizationaddress);
      organization.setOrganizationCity(organizationcity);
      organization.setOrganizationState(organizationstate);
      organization.setOrganizationCountry(organizationcountry);
      organization.setOrganizationZipCode(organizationzipcode);
       organizationList.add(organization);
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
  return organizationList;
 }

public static void main( String[] args ) {
}

} 

