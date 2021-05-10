import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Project;
import org.archcorner.chartreuse.util.JDBCManager;

public class ProjectDAO{ 


private String highestIDSQL = "SELECT MAX(PROJECTID) AS MAXPROJECTID FROM PROJECT";
private String selectSQL = "SELECT * FROM PROJECT WHERE PROJECTNAME=?";
private String selectIdSQL = "SELECT * FROM PROJECT WHERE PROJECTID=?";
private String insertSQL = "INSERT INTO PROJECT(PROJECTID,PROJECTNAME,PROJECTADDRESS,PROJECTCITY,PROJECTSTATE,PROJECTCOUNTRY,PROJECTZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE PROJECT SET PROJECTNAME=?,PROJECTADDRESS=?,PROJECTCITY=?,PROJECTSTATE=?,PROJECTCOUNTRY=?,PROJECTZIPCODE=? WHERE PROJECTID=?";
private String deleteSQL = "DELETE FROM PROJECT WHERE PROJECTID=?";
private String selectAllSQL = "SELECT * FROM PROJECT";

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
    highestId = resultSet.getInt("MAXPROJECTID");
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

public Project getProjectById(int projectid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Project project = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, projectid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("projectid");
      String projectname = resultSet.getString("PROJECTNAME");
      String projectaddress = resultSet.getString("PROJECTADDRESS");
      String projectcity = resultSet.getString("PROJECTCITY");
      String projectstate = resultSet.getString("PROJECTSTATE");
      String projectcountry = resultSet.getString("PROJECTCOUNTRY");
      String projectzipcode = resultSet.getString("PROJECTZIPCODE");
      project = new Project();
      project.setProjectId(id);
      project.setProjectName(projectname);
      project.setProjectAddress(projectaddress);
      project.setProjectCity(projectcity);
      project.setProjectState(projectstate);
      project.setProjectCountry(projectcountry);
      project.setProjectZipCode(projectzipcode);
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
  return project;
 }

public Project getProject(String projectname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Project project = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, projectname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("ProjectId");
      projectname = resultSet.getString("PROJECTNAME");
      String projectaddress = resultSet.getString("PROJECTADDRESS");
      String projectcity = resultSet.getString("PROJECTCITY");
      String projectstate = resultSet.getString("PROJECTSTATE");
      String projectcountry = resultSet.getString("PROJECTCOUNTRY");
      String projectzipcode = resultSet.getString("PROJECTZIPCODE");
      project = new Project();
      project.setProjectId(id);
      project.setProjectName(projectname);
      project.setProjectAddress(projectaddress);
      project.setProjectCity(projectcity);
      project.setProjectState(projectstate);
      project.setProjectCountry(projectcountry);
      project.setProjectZipCode(projectzipcode);
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
  return project;
 }

public void deleteProject(Project project)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, project.getProjectId());
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

public void insertProject(Project project)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,project.getProjectName());
    preparedStatement.setString(3,project.getProjectAddress());
    preparedStatement.setString(4,project.getProjectCity());
    preparedStatement.setString(5,project.getProjectState());
    preparedStatement.setString(6,project.getProjectCountry());
    preparedStatement.setString(7,project.getProjectZipCode());
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

public void updateProject(Project project)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,project.getProjectName());
    preparedStatement.setString(2,project.getProjectAddress());
    preparedStatement.setString(3,project.getProjectCity());
    preparedStatement.setString(4,project.getProjectState());
    preparedStatement.setString(5,project.getProjectCountry());
    preparedStatement.setString(6,project.getProjectZipCode());
    preparedStatement.setInt(7, project.getProjectId());
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

public List<Project> getProjects( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Project> projectList = new ArrayList<Project>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("PROJECTID");
      String projectname = resultSet.getString("PROJECTNAME");
      String projectaddress = resultSet.getString("PROJECTADDRESS");
      String projectcity = resultSet.getString("PROJECTCITY");
      String projectstate = resultSet.getString("PROJECTSTATE");
      String projectcountry = resultSet.getString("PROJECTCOUNTRY");
      String projectzipcode = resultSet.getString("PROJECTZIPCODE");
      Project project = new Project();
      project.setProjectId(id);
      project.setProjectName(projectname);
      project.setProjectAddress(projectaddress);
      project.setProjectCity(projectcity);
      project.setProjectState(projectstate);
      project.setProjectCountry(projectcountry);
      project.setProjectZipCode(projectzipcode);
       projectList.add(project);
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
  return projectList;
 }

public static void main( String[] args ) {
}

} 

