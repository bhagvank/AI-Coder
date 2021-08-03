package org.aicoder.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Area;
import org.archcorner.chartreuse.util.JDBCManager;

public class AreaDAO{ 


private String highestIDSQL = "SELECT MAX(AREAID) AS MAXAREAID FROM AREA";
private String selectSQL = "SELECT * FROM AREA WHERE AREANAME=?";
private String selectIdSQL = "SELECT * FROM AREA WHERE AREAID=?";
private String insertSQL = "INSERT INTO AREA(AREAID,AREANAME,AREAADDRESS,AREACITY,AREASTATE,AREACOUNTRY,AREAZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE AREA SET AREANAME=?,AREAADDRESS=?,AREACITY=?,AREASTATE=?,AREACOUNTRY=?,AREAZIPCODE=? WHERE AREAID=?";
private String deleteSQL = "DELETE FROM AREA WHERE AREAID=?";
private String selectAllSQL = "SELECT * FROM AREA";

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
    highestId = resultSet.getInt("MAXAREAID");
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

public Area getAreaById(int areaid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Area area = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, areaid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("areaid");
      String areaname = resultSet.getString("AREANAME");
      String areaaddress = resultSet.getString("AREAADDRESS");
      String areacity = resultSet.getString("AREACITY");
      String areastate = resultSet.getString("AREASTATE");
      String areacountry = resultSet.getString("AREACOUNTRY");
      String areazipcode = resultSet.getString("AREAZIPCODE");
      area = new Area();
      area.setAreaId(id);
      area.setAreaName(areaname);
      area.setAreaAddress(areaaddress);
      area.setAreaCity(areacity);
      area.setAreaState(areastate);
      area.setAreaCountry(areacountry);
      area.setAreaZipCode(areazipcode);
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
  return area;
 }

public Area getArea(String areaname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Area area = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, areaname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("AreaId");
      areaname = resultSet.getString("AREANAME");
      String areaaddress = resultSet.getString("AREAADDRESS");
      String areacity = resultSet.getString("AREACITY");
      String areastate = resultSet.getString("AREASTATE");
      String areacountry = resultSet.getString("AREACOUNTRY");
      String areazipcode = resultSet.getString("AREAZIPCODE");
      area = new Area();
      area.setAreaId(id);
      area.setAreaName(areaname);
      area.setAreaAddress(areaaddress);
      area.setAreaCity(areacity);
      area.setAreaState(areastate);
      area.setAreaCountry(areacountry);
      area.setAreaZipCode(areazipcode);
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
  return area;
 }

public void deleteArea(Area area)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, area.getAreaId());
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

public void insertArea(Area area)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,area.getAreaName());
    preparedStatement.setString(3,area.getAreaAddress());
    preparedStatement.setString(4,area.getAreaCity());
    preparedStatement.setString(5,area.getAreaState());
    preparedStatement.setString(6,area.getAreaCountry());
    preparedStatement.setString(7,area.getAreaZipCode());
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

public void updateArea(Area area)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,area.getAreaName());
    preparedStatement.setString(2,area.getAreaAddress());
    preparedStatement.setString(3,area.getAreaCity());
    preparedStatement.setString(4,area.getAreaState());
    preparedStatement.setString(5,area.getAreaCountry());
    preparedStatement.setString(6,area.getAreaZipCode());
    preparedStatement.setInt(7, area.getAreaId());
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

public List<Area> getAreas( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Area> areaList = new ArrayList<Area>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("AREAID");
      String areaname = resultSet.getString("AREANAME");
      String areaaddress = resultSet.getString("AREAADDRESS");
      String areacity = resultSet.getString("AREACITY");
      String areastate = resultSet.getString("AREASTATE");
      String areacountry = resultSet.getString("AREACOUNTRY");
      String areazipcode = resultSet.getString("AREAZIPCODE");
      Area area = new Area();
      area.setAreaId(id);
      area.setAreaName(areaname);
      area.setAreaAddress(areaaddress);
      area.setAreaCity(areacity);
      area.setAreaState(areastate);
      area.setAreaCountry(areacountry);
      area.setAreaZipCode(areazipcode);
       areaList.add(area);
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
  return areaList;
 }

public static void main( String[] args ) {
}

} 

