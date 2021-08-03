package org.aicoder.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Coverage;
import org.archcorner.chartreuse.util.JDBCManager;

public class CoverageDAO{ 


private String highestIDSQL = "SELECT MAX(COVERAGEID) AS MAXCOVERAGEID FROM COVERAGE";
private String selectSQL = "SELECT * FROM COVERAGE WHERE COVERAGENAME=?";
private String selectIdSQL = "SELECT * FROM COVERAGE WHERE COVERAGEID=?";
private String insertSQL = "INSERT INTO COVERAGE(COVERAGEID,COVERAGENAME,COVERAGEADDRESS,COVERAGECITY,COVERAGESTATE,COVERAGECOUNTRY,COVERAGEZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE COVERAGE SET COVERAGENAME=?,COVERAGEADDRESS=?,COVERAGECITY=?,COVERAGESTATE=?,COVERAGECOUNTRY=?,COVERAGEZIPCODE=? WHERE COVERAGEID=?";
private String deleteSQL = "DELETE FROM COVERAGE WHERE COVERAGEID=?";
private String selectAllSQL = "SELECT * FROM COVERAGE";

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
    highestId = resultSet.getInt("MAXCOVERAGEID");
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

public Coverage getCoverageById(int coverageid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Coverage coverage = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, coverageid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("coverageid");
      String coveragename = resultSet.getString("COVERAGENAME");
      String coverageaddress = resultSet.getString("COVERAGEADDRESS");
      String coveragecity = resultSet.getString("COVERAGECITY");
      String coveragestate = resultSet.getString("COVERAGESTATE");
      String coveragecountry = resultSet.getString("COVERAGECOUNTRY");
      String coveragezipcode = resultSet.getString("COVERAGEZIPCODE");
      coverage = new Coverage();
      coverage.setCoverageId(id);
      coverage.setCoverageName(coveragename);
      coverage.setCoverageAddress(coverageaddress);
      coverage.setCoverageCity(coveragecity);
      coverage.setCoverageState(coveragestate);
      coverage.setCoverageCountry(coveragecountry);
      coverage.setCoverageZipCode(coveragezipcode);
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
  return coverage;
 }

public Coverage getCoverage(String coveragename)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Coverage coverage = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, coveragename);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("CoverageId");
      coveragename = resultSet.getString("COVERAGENAME");
      String coverageaddress = resultSet.getString("COVERAGEADDRESS");
      String coveragecity = resultSet.getString("COVERAGECITY");
      String coveragestate = resultSet.getString("COVERAGESTATE");
      String coveragecountry = resultSet.getString("COVERAGECOUNTRY");
      String coveragezipcode = resultSet.getString("COVERAGEZIPCODE");
      coverage = new Coverage();
      coverage.setCoverageId(id);
      coverage.setCoverageName(coveragename);
      coverage.setCoverageAddress(coverageaddress);
      coverage.setCoverageCity(coveragecity);
      coverage.setCoverageState(coveragestate);
      coverage.setCoverageCountry(coveragecountry);
      coverage.setCoverageZipCode(coveragezipcode);
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
  return coverage;
 }

public void deleteCoverage(Coverage coverage)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, coverage.getCoverageId());
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

public void insertCoverage(Coverage coverage)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,coverage.getCoverageName());
    preparedStatement.setString(3,coverage.getCoverageAddress());
    preparedStatement.setString(4,coverage.getCoverageCity());
    preparedStatement.setString(5,coverage.getCoverageState());
    preparedStatement.setString(6,coverage.getCoverageCountry());
    preparedStatement.setString(7,coverage.getCoverageZipCode());
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

public void updateCoverage(Coverage coverage)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,coverage.getCoverageName());
    preparedStatement.setString(2,coverage.getCoverageAddress());
    preparedStatement.setString(3,coverage.getCoverageCity());
    preparedStatement.setString(4,coverage.getCoverageState());
    preparedStatement.setString(5,coverage.getCoverageCountry());
    preparedStatement.setString(6,coverage.getCoverageZipCode());
    preparedStatement.setInt(7, coverage.getCoverageId());
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

public List<Coverage> getCoverages( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Coverage> coverageList = new ArrayList<Coverage>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("COVERAGEID");
      String coveragename = resultSet.getString("COVERAGENAME");
      String coverageaddress = resultSet.getString("COVERAGEADDRESS");
      String coveragecity = resultSet.getString("COVERAGECITY");
      String coveragestate = resultSet.getString("COVERAGESTATE");
      String coveragecountry = resultSet.getString("COVERAGECOUNTRY");
      String coveragezipcode = resultSet.getString("COVERAGEZIPCODE");
      Coverage coverage = new Coverage();
      coverage.setCoverageId(id);
      coverage.setCoverageName(coveragename);
      coverage.setCoverageAddress(coverageaddress);
      coverage.setCoverageCity(coveragecity);
      coverage.setCoverageState(coveragestate);
      coverage.setCoverageCountry(coveragecountry);
      coverage.setCoverageZipCode(coveragezipcode);
       coverageList.add(coverage);
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
  return coverageList;
 }

public static void main( String[] args ) {
}

} 

