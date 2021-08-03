package org.aicoder.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Owner;
import org.archcorner.chartreuse.util.JDBCManager;

public class OwnerDAO{ 


private String highestIDSQL = "SELECT MAX(OWNERID) AS MAXOWNERID FROM OWNER";
private String selectSQL = "SELECT * FROM OWNER WHERE OWNERNAME=?";
private String selectIdSQL = "SELECT * FROM OWNER WHERE OWNERID=?";
private String insertSQL = "INSERT INTO OWNER(OWNERID,OWNERNAME,OWNERADDRESS,OWNERCITY,OWNERSTATE,OWNERCOUNTRY,OWNERZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE OWNER SET OWNERNAME=?,OWNERADDRESS=?,OWNERCITY=?,OWNERSTATE=?,OWNERCOUNTRY=?,OWNERZIPCODE=? WHERE OWNERID=?";
private String deleteSQL = "DELETE FROM OWNER WHERE OWNERID=?";
private String selectAllSQL = "SELECT * FROM OWNER";

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
    highestId = resultSet.getInt("MAXOWNERID");
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

public Owner getOwnerById(int ownerid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Owner owner = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, ownerid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("ownerid");
      String ownername = resultSet.getString("OWNERNAME");
      String owneraddress = resultSet.getString("OWNERADDRESS");
      String ownercity = resultSet.getString("OWNERCITY");
      String ownerstate = resultSet.getString("OWNERSTATE");
      String ownercountry = resultSet.getString("OWNERCOUNTRY");
      String ownerzipcode = resultSet.getString("OWNERZIPCODE");
      owner = new Owner();
      owner.setOwnerId(id);
      owner.setOwnerName(ownername);
      owner.setOwnerAddress(owneraddress);
      owner.setOwnerCity(ownercity);
      owner.setOwnerState(ownerstate);
      owner.setOwnerCountry(ownercountry);
      owner.setOwnerZipCode(ownerzipcode);
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
  return owner;
 }

public Owner getOwner(String ownername)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Owner owner = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, ownername);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("OwnerId");
      ownername = resultSet.getString("OWNERNAME");
      String owneraddress = resultSet.getString("OWNERADDRESS");
      String ownercity = resultSet.getString("OWNERCITY");
      String ownerstate = resultSet.getString("OWNERSTATE");
      String ownercountry = resultSet.getString("OWNERCOUNTRY");
      String ownerzipcode = resultSet.getString("OWNERZIPCODE");
      owner = new Owner();
      owner.setOwnerId(id);
      owner.setOwnerName(ownername);
      owner.setOwnerAddress(owneraddress);
      owner.setOwnerCity(ownercity);
      owner.setOwnerState(ownerstate);
      owner.setOwnerCountry(ownercountry);
      owner.setOwnerZipCode(ownerzipcode);
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
  return owner;
 }

public void deleteOwner(Owner owner)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, owner.getOwnerId());
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

public void insertOwner(Owner owner)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,owner.getOwnerName());
    preparedStatement.setString(3,owner.getOwnerAddress());
    preparedStatement.setString(4,owner.getOwnerCity());
    preparedStatement.setString(5,owner.getOwnerState());
    preparedStatement.setString(6,owner.getOwnerCountry());
    preparedStatement.setString(7,owner.getOwnerZipCode());
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

public void updateOwner(Owner owner)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,owner.getOwnerName());
    preparedStatement.setString(2,owner.getOwnerAddress());
    preparedStatement.setString(3,owner.getOwnerCity());
    preparedStatement.setString(4,owner.getOwnerState());
    preparedStatement.setString(5,owner.getOwnerCountry());
    preparedStatement.setString(6,owner.getOwnerZipCode());
    preparedStatement.setInt(7, owner.getOwnerId());
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

public List<Owner> getOwners( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Owner> ownerList = new ArrayList<Owner>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("OWNERID");
      String ownername = resultSet.getString("OWNERNAME");
      String owneraddress = resultSet.getString("OWNERADDRESS");
      String ownercity = resultSet.getString("OWNERCITY");
      String ownerstate = resultSet.getString("OWNERSTATE");
      String ownercountry = resultSet.getString("OWNERCOUNTRY");
      String ownerzipcode = resultSet.getString("OWNERZIPCODE");
      Owner owner = new Owner();
      owner.setOwnerId(id);
      owner.setOwnerName(ownername);
      owner.setOwnerAddress(owneraddress);
      owner.setOwnerCity(ownercity);
      owner.setOwnerState(ownerstate);
      owner.setOwnerCountry(ownercountry);
      owner.setOwnerZipCode(ownerzipcode);
       ownerList.add(owner);
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
  return ownerList;
 }

public static void main( String[] args ) {
}

} 

