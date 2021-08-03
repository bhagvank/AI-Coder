package org.aicoder.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Position;
import org.archcorner.chartreuse.util.JDBCManager;

public class PositionDAO{ 


private String highestIDSQL = "SELECT MAX(POSITIONID) AS MAXPOSITIONID FROM POSITION";
private String selectSQL = "SELECT * FROM POSITION WHERE POSITIONNAME=?";
private String selectIdSQL = "SELECT * FROM POSITION WHERE POSITIONID=?";
private String insertSQL = "INSERT INTO POSITION(POSITIONID,POSITIONNAME,POSITIONADDRESS,POSITIONCITY,POSITIONSTATE,POSITIONCOUNTRY,POSITIONZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE POSITION SET POSITIONNAME=?,POSITIONADDRESS=?,POSITIONCITY=?,POSITIONSTATE=?,POSITIONCOUNTRY=?,POSITIONZIPCODE=? WHERE POSITIONID=?";
private String deleteSQL = "DELETE FROM POSITION WHERE POSITIONID=?";
private String selectAllSQL = "SELECT * FROM POSITION";

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
    highestId = resultSet.getInt("MAXPOSITIONID");
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

public Position getPositionById(int positionid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Position position = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, positionid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("positionid");
      String positionname = resultSet.getString("POSITIONNAME");
      String positionaddress = resultSet.getString("POSITIONADDRESS");
      String positioncity = resultSet.getString("POSITIONCITY");
      String positionstate = resultSet.getString("POSITIONSTATE");
      String positioncountry = resultSet.getString("POSITIONCOUNTRY");
      String positionzipcode = resultSet.getString("POSITIONZIPCODE");
      position = new Position();
      position.setPositionId(id);
      position.setPositionName(positionname);
      position.setPositionAddress(positionaddress);
      position.setPositionCity(positioncity);
      position.setPositionState(positionstate);
      position.setPositionCountry(positioncountry);
      position.setPositionZipCode(positionzipcode);
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
  return position;
 }

public Position getPosition(String positionname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Position position = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, positionname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("PositionId");
      positionname = resultSet.getString("POSITIONNAME");
      String positionaddress = resultSet.getString("POSITIONADDRESS");
      String positioncity = resultSet.getString("POSITIONCITY");
      String positionstate = resultSet.getString("POSITIONSTATE");
      String positioncountry = resultSet.getString("POSITIONCOUNTRY");
      String positionzipcode = resultSet.getString("POSITIONZIPCODE");
      position = new Position();
      position.setPositionId(id);
      position.setPositionName(positionname);
      position.setPositionAddress(positionaddress);
      position.setPositionCity(positioncity);
      position.setPositionState(positionstate);
      position.setPositionCountry(positioncountry);
      position.setPositionZipCode(positionzipcode);
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
  return position;
 }

public void deletePosition(Position position)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, position.getPositionId());
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

public void insertPosition(Position position)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,position.getPositionName());
    preparedStatement.setString(3,position.getPositionAddress());
    preparedStatement.setString(4,position.getPositionCity());
    preparedStatement.setString(5,position.getPositionState());
    preparedStatement.setString(6,position.getPositionCountry());
    preparedStatement.setString(7,position.getPositionZipCode());
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

public void updatePosition(Position position)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,position.getPositionName());
    preparedStatement.setString(2,position.getPositionAddress());
    preparedStatement.setString(3,position.getPositionCity());
    preparedStatement.setString(4,position.getPositionState());
    preparedStatement.setString(5,position.getPositionCountry());
    preparedStatement.setString(6,position.getPositionZipCode());
    preparedStatement.setInt(7, position.getPositionId());
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

public List<Position> getPositions( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Position> positionList = new ArrayList<Position>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("POSITIONID");
      String positionname = resultSet.getString("POSITIONNAME");
      String positionaddress = resultSet.getString("POSITIONADDRESS");
      String positioncity = resultSet.getString("POSITIONCITY");
      String positionstate = resultSet.getString("POSITIONSTATE");
      String positioncountry = resultSet.getString("POSITIONCOUNTRY");
      String positionzipcode = resultSet.getString("POSITIONZIPCODE");
      Position position = new Position();
      position.setPositionId(id);
      position.setPositionName(positionname);
      position.setPositionAddress(positionaddress);
      position.setPositionCity(positioncity);
      position.setPositionState(positionstate);
      position.setPositionCountry(positioncountry);
      position.setPositionZipCode(positionzipcode);
       positionList.add(position);
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
  return positionList;
 }

public static void main( String[] args ) {
}

} 

