package org.aicoder.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Employee;
import org.archcorner.chartreuse.util.JDBCManager;

public class EmployeeDAO{ 


private String highestIDSQL = "SELECT MAX(EMPLOYEEID) AS MAXEMPLOYEEID FROM EMPLOYEE";
private String selectSQL = "SELECT * FROM EMPLOYEE WHERE EMPLOYEENAME=?";
private String selectIdSQL = "SELECT * FROM EMPLOYEE WHERE EMPLOYEEID=?";
private String insertSQL = "INSERT INTO EMPLOYEE(EMPLOYEEID,EMPLOYEENAME,EMPLOYEEADDRESS,EMPLOYEECITY,EMPLOYEESTATE,EMPLOYEECOUNTRY,EMPLOYEEZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE EMPLOYEE SET EMPLOYEENAME=?,EMPLOYEEADDRESS=?,EMPLOYEECITY=?,EMPLOYEESTATE=?,EMPLOYEECOUNTRY=?,EMPLOYEEZIPCODE=? WHERE EMPLOYEEID=?";
private String deleteSQL = "DELETE FROM EMPLOYEE WHERE EMPLOYEEID=?";
private String selectAllSQL = "SELECT * FROM EMPLOYEE";

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
    highestId = resultSet.getInt("MAXEMPLOYEEID");
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

public Employee getEmployeeById(int employeeid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Employee employee = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, employeeid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("employeeid");
      String employeename = resultSet.getString("EMPLOYEENAME");
      String employeeaddress = resultSet.getString("EMPLOYEEADDRESS");
      String employeecity = resultSet.getString("EMPLOYEECITY");
      String employeestate = resultSet.getString("EMPLOYEESTATE");
      String employeecountry = resultSet.getString("EMPLOYEECOUNTRY");
      String employeezipcode = resultSet.getString("EMPLOYEEZIPCODE");
      employee = new Employee();
      employee.setEmployeeId(id);
      employee.setEmployeeName(employeename);
      employee.setEmployeeAddress(employeeaddress);
      employee.setEmployeeCity(employeecity);
      employee.setEmployeeState(employeestate);
      employee.setEmployeeCountry(employeecountry);
      employee.setEmployeeZipCode(employeezipcode);
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
  return employee;
 }

public Employee getEmployee(String employeename)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Employee employee = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, employeename);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("EmployeeId");
      employeename = resultSet.getString("EMPLOYEENAME");
      String employeeaddress = resultSet.getString("EMPLOYEEADDRESS");
      String employeecity = resultSet.getString("EMPLOYEECITY");
      String employeestate = resultSet.getString("EMPLOYEESTATE");
      String employeecountry = resultSet.getString("EMPLOYEECOUNTRY");
      String employeezipcode = resultSet.getString("EMPLOYEEZIPCODE");
      employee = new Employee();
      employee.setEmployeeId(id);
      employee.setEmployeeName(employeename);
      employee.setEmployeeAddress(employeeaddress);
      employee.setEmployeeCity(employeecity);
      employee.setEmployeeState(employeestate);
      employee.setEmployeeCountry(employeecountry);
      employee.setEmployeeZipCode(employeezipcode);
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
  return employee;
 }

public void deleteEmployee(Employee employee)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, employee.getEmployeeId());
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

public void insertEmployee(Employee employee)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,employee.getEmployeeName());
    preparedStatement.setString(3,employee.getEmployeeAddress());
    preparedStatement.setString(4,employee.getEmployeeCity());
    preparedStatement.setString(5,employee.getEmployeeState());
    preparedStatement.setString(6,employee.getEmployeeCountry());
    preparedStatement.setString(7,employee.getEmployeeZipCode());
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

public void updateEmployee(Employee employee)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,employee.getEmployeeName());
    preparedStatement.setString(2,employee.getEmployeeAddress());
    preparedStatement.setString(3,employee.getEmployeeCity());
    preparedStatement.setString(4,employee.getEmployeeState());
    preparedStatement.setString(5,employee.getEmployeeCountry());
    preparedStatement.setString(6,employee.getEmployeeZipCode());
    preparedStatement.setInt(7, employee.getEmployeeId());
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

public List<Employee> getEmployees( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Employee> employeeList = new ArrayList<Employee>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("EMPLOYEEID");
      String employeename = resultSet.getString("EMPLOYEENAME");
      String employeeaddress = resultSet.getString("EMPLOYEEADDRESS");
      String employeecity = resultSet.getString("EMPLOYEECITY");
      String employeestate = resultSet.getString("EMPLOYEESTATE");
      String employeecountry = resultSet.getString("EMPLOYEECOUNTRY");
      String employeezipcode = resultSet.getString("EMPLOYEEZIPCODE");
      Employee employee = new Employee();
      employee.setEmployeeId(id);
      employee.setEmployeeName(employeename);
      employee.setEmployeeAddress(employeeaddress);
      employee.setEmployeeCity(employeecity);
      employee.setEmployeeState(employeestate);
      employee.setEmployeeCountry(employeecountry);
      employee.setEmployeeZipCode(employeezipcode);
       employeeList.add(employee);
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
  return employeeList;
 }

public static void main( String[] args ) {
}

} 

