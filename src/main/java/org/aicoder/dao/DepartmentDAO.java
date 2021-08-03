package org.aicoder.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Department;
import org.archcorner.chartreuse.util.JDBCManager;

public class DepartmentDAO{ 


private String highestIDSQL = "SELECT MAX(DEPARTMENTID) AS MAXDEPARTMENTID FROM DEPARTMENT";
private String selectSQL = "SELECT * FROM DEPARTMENT WHERE DEPARTMENTNAME=?";
private String selectIdSQL = "SELECT * FROM DEPARTMENT WHERE DEPARTMENTID=?";
private String insertSQL = "INSERT INTO DEPARTMENT(DEPARTMENTID,DEPARTMENTNAME,DEPARTMENTADDRESS,DEPARTMENTCITY,DEPARTMENTSTATE,DEPARTMENTCOUNTRY,DEPARTMENTZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE DEPARTMENT SET DEPARTMENTNAME=?,DEPARTMENTADDRESS=?,DEPARTMENTCITY=?,DEPARTMENTSTATE=?,DEPARTMENTCOUNTRY=?,DEPARTMENTZIPCODE=? WHERE DEPARTMENTID=?";
private String deleteSQL = "DELETE FROM DEPARTMENT WHERE DEPARTMENTID=?";
private String selectAllSQL = "SELECT * FROM DEPARTMENT";

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
    highestId = resultSet.getInt("MAXDEPARTMENTID");
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

public Department getDepartmentById(int departmentid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Department department = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, departmentid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("departmentid");
      String departmentname = resultSet.getString("DEPARTMENTNAME");
      String departmentaddress = resultSet.getString("DEPARTMENTADDRESS");
      String departmentcity = resultSet.getString("DEPARTMENTCITY");
      String departmentstate = resultSet.getString("DEPARTMENTSTATE");
      String departmentcountry = resultSet.getString("DEPARTMENTCOUNTRY");
      String departmentzipcode = resultSet.getString("DEPARTMENTZIPCODE");
      department = new Department();
      department.setDepartmentId(id);
      department.setDepartmentName(departmentname);
      department.setDepartmentAddress(departmentaddress);
      department.setDepartmentCity(departmentcity);
      department.setDepartmentState(departmentstate);
      department.setDepartmentCountry(departmentcountry);
      department.setDepartmentZipCode(departmentzipcode);
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
  return department;
 }

public Department getDepartment(String departmentname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Department department = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, departmentname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("DepartmentId");
      departmentname = resultSet.getString("DEPARTMENTNAME");
      String departmentaddress = resultSet.getString("DEPARTMENTADDRESS");
      String departmentcity = resultSet.getString("DEPARTMENTCITY");
      String departmentstate = resultSet.getString("DEPARTMENTSTATE");
      String departmentcountry = resultSet.getString("DEPARTMENTCOUNTRY");
      String departmentzipcode = resultSet.getString("DEPARTMENTZIPCODE");
      department = new Department();
      department.setDepartmentId(id);
      department.setDepartmentName(departmentname);
      department.setDepartmentAddress(departmentaddress);
      department.setDepartmentCity(departmentcity);
      department.setDepartmentState(departmentstate);
      department.setDepartmentCountry(departmentcountry);
      department.setDepartmentZipCode(departmentzipcode);
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
  return department;
 }

public void deleteDepartment(Department department)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, department.getDepartmentId());
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

public void insertDepartment(Department department)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,department.getDepartmentName());
    preparedStatement.setString(3,department.getDepartmentAddress());
    preparedStatement.setString(4,department.getDepartmentCity());
    preparedStatement.setString(5,department.getDepartmentState());
    preparedStatement.setString(6,department.getDepartmentCountry());
    preparedStatement.setString(7,department.getDepartmentZipCode());
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

public void updateDepartment(Department department)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,department.getDepartmentName());
    preparedStatement.setString(2,department.getDepartmentAddress());
    preparedStatement.setString(3,department.getDepartmentCity());
    preparedStatement.setString(4,department.getDepartmentState());
    preparedStatement.setString(5,department.getDepartmentCountry());
    preparedStatement.setString(6,department.getDepartmentZipCode());
    preparedStatement.setInt(7, department.getDepartmentId());
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

public List<Department> getDepartments( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Department> departmentList = new ArrayList<Department>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("DEPARTMENTID");
      String departmentname = resultSet.getString("DEPARTMENTNAME");
      String departmentaddress = resultSet.getString("DEPARTMENTADDRESS");
      String departmentcity = resultSet.getString("DEPARTMENTCITY");
      String departmentstate = resultSet.getString("DEPARTMENTSTATE");
      String departmentcountry = resultSet.getString("DEPARTMENTCOUNTRY");
      String departmentzipcode = resultSet.getString("DEPARTMENTZIPCODE");
      Department department = new Department();
      department.setDepartmentId(id);
      department.setDepartmentName(departmentname);
      department.setDepartmentAddress(departmentaddress);
      department.setDepartmentCity(departmentcity);
      department.setDepartmentState(departmentstate);
      department.setDepartmentCountry(departmentcountry);
      department.setDepartmentZipCode(departmentzipcode);
       departmentList.add(department);
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
  return departmentList;
 }

public static void main( String[] args ) {
}

} 

