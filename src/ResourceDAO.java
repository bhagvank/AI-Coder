import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Resource;
import org.archcorner.chartreuse.util.JDBCManager;

public class ResourceDAO{ 


private String highestIDSQL = "SELECT MAX(RESOURCEID) AS MAXRESOURCEID FROM RESOURCE";
private String selectSQL = "SELECT * FROM RESOURCE WHERE RESOURCENAME=?";
private String selectIdSQL = "SELECT * FROM RESOURCE WHERE RESOURCEID=?";
private String insertSQL = "INSERT INTO RESOURCE(RESOURCEID,RESOURCENAME,RESOURCEADDRESS,RESOURCECITY,RESOURCESTATE,RESOURCECOUNTRY,RESOURCEZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE RESOURCE SET RESOURCENAME=?,RESOURCEADDRESS=?,RESOURCECITY=?,RESOURCESTATE=?,RESOURCECOUNTRY=?,RESOURCEZIPCODE=? WHERE RESOURCEID=?";
private String deleteSQL = "DELETE FROM RESOURCE WHERE RESOURCEID=?";
private String selectAllSQL = "SELECT * FROM RESOURCE";

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
    highestId = resultSet.getInt("MAXRESOURCEID");
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

public Resource getResourceById(int resourceid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Resource resource = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, resourceid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("resourceid");
      String resourcename = resultSet.getString("RESOURCENAME");
      String resourceaddress = resultSet.getString("RESOURCEADDRESS");
      String resourcecity = resultSet.getString("RESOURCECITY");
      String resourcestate = resultSet.getString("RESOURCESTATE");
      String resourcecountry = resultSet.getString("RESOURCECOUNTRY");
      String resourcezipcode = resultSet.getString("RESOURCEZIPCODE");
      resource = new Resource();
      resource.setResourceId(id);
      resource.setResourceName(resourcename);
      resource.setResourceAddress(resourceaddress);
      resource.setResourceCity(resourcecity);
      resource.setResourceState(resourcestate);
      resource.setResourceCountry(resourcecountry);
      resource.setResourceZipCode(resourcezipcode);
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
  return resource;
 }

public Resource getResource(String resourcename)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Resource resource = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, resourcename);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("ResourceId");
      resourcename = resultSet.getString("RESOURCENAME");
      String resourceaddress = resultSet.getString("RESOURCEADDRESS");
      String resourcecity = resultSet.getString("RESOURCECITY");
      String resourcestate = resultSet.getString("RESOURCESTATE");
      String resourcecountry = resultSet.getString("RESOURCECOUNTRY");
      String resourcezipcode = resultSet.getString("RESOURCEZIPCODE");
      resource = new Resource();
      resource.setResourceId(id);
      resource.setResourceName(resourcename);
      resource.setResourceAddress(resourceaddress);
      resource.setResourceCity(resourcecity);
      resource.setResourceState(resourcestate);
      resource.setResourceCountry(resourcecountry);
      resource.setResourceZipCode(resourcezipcode);
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
  return resource;
 }

public void deleteResource(Resource resource)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, resource.getResourceId());
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

public void insertResource(Resource resource)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,resource.getResourceName());
    preparedStatement.setString(3,resource.getResourceAddress());
    preparedStatement.setString(4,resource.getResourceCity());
    preparedStatement.setString(5,resource.getResourceState());
    preparedStatement.setString(6,resource.getResourceCountry());
    preparedStatement.setString(7,resource.getResourceZipCode());
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

public void updateResource(Resource resource)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,resource.getResourceName());
    preparedStatement.setString(2,resource.getResourceAddress());
    preparedStatement.setString(3,resource.getResourceCity());
    preparedStatement.setString(4,resource.getResourceState());
    preparedStatement.setString(5,resource.getResourceCountry());
    preparedStatement.setString(6,resource.getResourceZipCode());
    preparedStatement.setInt(7, resource.getResourceId());
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

public List<Resource> getResources( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Resource> resourceList = new ArrayList<Resource>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("RESOURCEID");
      String resourcename = resultSet.getString("RESOURCENAME");
      String resourceaddress = resultSet.getString("RESOURCEADDRESS");
      String resourcecity = resultSet.getString("RESOURCECITY");
      String resourcestate = resultSet.getString("RESOURCESTATE");
      String resourcecountry = resultSet.getString("RESOURCECOUNTRY");
      String resourcezipcode = resultSet.getString("RESOURCEZIPCODE");
      Resource resource = new Resource();
      resource.setResourceId(id);
      resource.setResourceName(resourcename);
      resource.setResourceAddress(resourceaddress);
      resource.setResourceCity(resourcecity);
      resource.setResourceState(resourcestate);
      resource.setResourceCountry(resourcecountry);
      resource.setResourceZipCode(resourcezipcode);
       resourceList.add(resource);
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
  return resourceList;
 }

public static void main( String[] args ) {
}

} 

