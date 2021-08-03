package org.aicoder.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Warehouse;
import org.archcorner.chartreuse.util.JDBCManager;

public class WarehouseDAO{ 


private String highestIDSQL = "SELECT MAX(WAREHOUSEID) AS MAXWAREHOUSEID FROM WAREHOUSE";
private String selectSQL = "SELECT * FROM WAREHOUSE WHERE WAREHOUSENAME=?";
private String selectIdSQL = "SELECT * FROM WAREHOUSE WHERE WAREHOUSEID=?";
private String insertSQL = "INSERT INTO WAREHOUSE(WAREHOUSEID,WAREHOUSENAME,WAREHOUSEADDRESS,WAREHOUSECITY,WAREHOUSESTATE,WAREHOUSECOUNTRY,WAREHOUSEZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE WAREHOUSE SET WAREHOUSENAME=?,WAREHOUSEADDRESS=?,WAREHOUSECITY=?,WAREHOUSESTATE=?,WAREHOUSECOUNTRY=?,WAREHOUSEZIPCODE=? WHERE WAREHOUSEID=?";
private String deleteSQL = "DELETE FROM WAREHOUSE WHERE WAREHOUSEID=?";
private String selectAllSQL = "SELECT * FROM WAREHOUSE";

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
    highestId = resultSet.getInt("MAXWAREHOUSEID");
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

public Warehouse getWarehouseById(int warehouseid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Warehouse warehouse = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, warehouseid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("warehouseid");
      String warehousename = resultSet.getString("WAREHOUSENAME");
      String warehouseaddress = resultSet.getString("WAREHOUSEADDRESS");
      String warehousecity = resultSet.getString("WAREHOUSECITY");
      String warehousestate = resultSet.getString("WAREHOUSESTATE");
      String warehousecountry = resultSet.getString("WAREHOUSECOUNTRY");
      String warehousezipcode = resultSet.getString("WAREHOUSEZIPCODE");
      warehouse = new Warehouse();
      warehouse.setWarehouseId(id);
      warehouse.setWarehouseName(warehousename);
      warehouse.setWarehouseAddress(warehouseaddress);
      warehouse.setWarehouseCity(warehousecity);
      warehouse.setWarehouseState(warehousestate);
      warehouse.setWarehouseCountry(warehousecountry);
      warehouse.setWarehouseZipCode(warehousezipcode);
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
  return warehouse;
 }

public Warehouse getWarehouse(String warehousename)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Warehouse warehouse = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, warehousename);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("WarehouseId");
      warehousename = resultSet.getString("WAREHOUSENAME");
      String warehouseaddress = resultSet.getString("WAREHOUSEADDRESS");
      String warehousecity = resultSet.getString("WAREHOUSECITY");
      String warehousestate = resultSet.getString("WAREHOUSESTATE");
      String warehousecountry = resultSet.getString("WAREHOUSECOUNTRY");
      String warehousezipcode = resultSet.getString("WAREHOUSEZIPCODE");
      warehouse = new Warehouse();
      warehouse.setWarehouseId(id);
      warehouse.setWarehouseName(warehousename);
      warehouse.setWarehouseAddress(warehouseaddress);
      warehouse.setWarehouseCity(warehousecity);
      warehouse.setWarehouseState(warehousestate);
      warehouse.setWarehouseCountry(warehousecountry);
      warehouse.setWarehouseZipCode(warehousezipcode);
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
  return warehouse;
 }

public void deleteWarehouse(Warehouse warehouse)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, warehouse.getWarehouseId());
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

public void insertWarehouse(Warehouse warehouse)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,warehouse.getWarehouseName());
    preparedStatement.setString(3,warehouse.getWarehouseAddress());
    preparedStatement.setString(4,warehouse.getWarehouseCity());
    preparedStatement.setString(5,warehouse.getWarehouseState());
    preparedStatement.setString(6,warehouse.getWarehouseCountry());
    preparedStatement.setString(7,warehouse.getWarehouseZipCode());
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

public void updateWarehouse(Warehouse warehouse)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,warehouse.getWarehouseName());
    preparedStatement.setString(2,warehouse.getWarehouseAddress());
    preparedStatement.setString(3,warehouse.getWarehouseCity());
    preparedStatement.setString(4,warehouse.getWarehouseState());
    preparedStatement.setString(5,warehouse.getWarehouseCountry());
    preparedStatement.setString(6,warehouse.getWarehouseZipCode());
    preparedStatement.setInt(7, warehouse.getWarehouseId());
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

public List<Warehouse> getWarehouses( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Warehouse> warehouseList = new ArrayList<Warehouse>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("WAREHOUSEID");
      String warehousename = resultSet.getString("WAREHOUSENAME");
      String warehouseaddress = resultSet.getString("WAREHOUSEADDRESS");
      String warehousecity = resultSet.getString("WAREHOUSECITY");
      String warehousestate = resultSet.getString("WAREHOUSESTATE");
      String warehousecountry = resultSet.getString("WAREHOUSECOUNTRY");
      String warehousezipcode = resultSet.getString("WAREHOUSEZIPCODE");
      Warehouse warehouse = new Warehouse();
      warehouse.setWarehouseId(id);
      warehouse.setWarehouseName(warehousename);
      warehouse.setWarehouseAddress(warehouseaddress);
      warehouse.setWarehouseCity(warehousecity);
      warehouse.setWarehouseState(warehousestate);
      warehouse.setWarehouseCountry(warehousecountry);
      warehouse.setWarehouseZipCode(warehousezipcode);
       warehouseList.add(warehouse);
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
  return warehouseList;
 }

public static void main( String[] args ) {
}

} 

