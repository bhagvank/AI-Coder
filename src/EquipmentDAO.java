import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Equipment;
import org.archcorner.chartreuse.util.JDBCManager;

public class EquipmentDAO{ 


private String highestIDSQL = "SELECT MAX(EQUIPMENTID) AS MAXEQUIPMENTID FROM EQUIPMENT";
private String selectSQL = "SELECT * FROM EQUIPMENT WHERE EQUIPMENTNAME=?";
private String selectIdSQL = "SELECT * FROM EQUIPMENT WHERE EQUIPMENTID=?";
private String insertSQL = "INSERT INTO EQUIPMENT(EQUIPMENTID,EQUIPMENTNAME,EQUIPMENTADDRESS,EQUIPMENTCITY,EQUIPMENTSTATE,EQUIPMENTCOUNTRY,EQUIPMENTZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE EQUIPMENT SET EQUIPMENTNAME=?,EQUIPMENTADDRESS=?,EQUIPMENTCITY=?,EQUIPMENTSTATE=?,EQUIPMENTCOUNTRY=?,EQUIPMENTZIPCODE=? WHERE EQUIPMENTID=?";
private String deleteSQL = "DELETE FROM EQUIPMENT WHERE EQUIPMENTID=?";
private String selectAllSQL = "SELECT * FROM EQUIPMENT";

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
    highestId = resultSet.getInt("MAXEQUIPMENTID");
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

public Equipment getEquipmentById(int equipmentid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Equipment equipment = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, equipmentid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("equipmentid");
      String equipmentname = resultSet.getString("EQUIPMENTNAME");
      String equipmentaddress = resultSet.getString("EQUIPMENTADDRESS");
      String equipmentcity = resultSet.getString("EQUIPMENTCITY");
      String equipmentstate = resultSet.getString("EQUIPMENTSTATE");
      String equipmentcountry = resultSet.getString("EQUIPMENTCOUNTRY");
      String equipmentzipcode = resultSet.getString("EQUIPMENTZIPCODE");
      equipment = new Equipment();
      equipment.setEquipmentId(id);
      equipment.setEquipmentName(equipmentname);
      equipment.setEquipmentAddress(equipmentaddress);
      equipment.setEquipmentCity(equipmentcity);
      equipment.setEquipmentState(equipmentstate);
      equipment.setEquipmentCountry(equipmentcountry);
      equipment.setEquipmentZipCode(equipmentzipcode);
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
  return equipment;
 }

public Equipment getEquipment(String equipmentname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Equipment equipment = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, equipmentname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("EquipmentId");
      equipmentname = resultSet.getString("EQUIPMENTNAME");
      String equipmentaddress = resultSet.getString("EQUIPMENTADDRESS");
      String equipmentcity = resultSet.getString("EQUIPMENTCITY");
      String equipmentstate = resultSet.getString("EQUIPMENTSTATE");
      String equipmentcountry = resultSet.getString("EQUIPMENTCOUNTRY");
      String equipmentzipcode = resultSet.getString("EQUIPMENTZIPCODE");
      equipment = new Equipment();
      equipment.setEquipmentId(id);
      equipment.setEquipmentName(equipmentname);
      equipment.setEquipmentAddress(equipmentaddress);
      equipment.setEquipmentCity(equipmentcity);
      equipment.setEquipmentState(equipmentstate);
      equipment.setEquipmentCountry(equipmentcountry);
      equipment.setEquipmentZipCode(equipmentzipcode);
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
  return equipment;
 }

public void deleteEquipment(Equipment equipment)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, equipment.getEquipmentId());
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

public void insertEquipment(Equipment equipment)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,equipment.getEquipmentName());
    preparedStatement.setString(3,equipment.getEquipmentAddress());
    preparedStatement.setString(4,equipment.getEquipmentCity());
    preparedStatement.setString(5,equipment.getEquipmentState());
    preparedStatement.setString(6,equipment.getEquipmentCountry());
    preparedStatement.setString(7,equipment.getEquipmentZipCode());
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

public void updateEquipment(Equipment equipment)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,equipment.getEquipmentName());
    preparedStatement.setString(2,equipment.getEquipmentAddress());
    preparedStatement.setString(3,equipment.getEquipmentCity());
    preparedStatement.setString(4,equipment.getEquipmentState());
    preparedStatement.setString(5,equipment.getEquipmentCountry());
    preparedStatement.setString(6,equipment.getEquipmentZipCode());
    preparedStatement.setInt(7, equipment.getEquipmentId());
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

public List<Equipment> getEquipments( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Equipment> equipmentList = new ArrayList<Equipment>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("EQUIPMENTID");
      String equipmentname = resultSet.getString("EQUIPMENTNAME");
      String equipmentaddress = resultSet.getString("EQUIPMENTADDRESS");
      String equipmentcity = resultSet.getString("EQUIPMENTCITY");
      String equipmentstate = resultSet.getString("EQUIPMENTSTATE");
      String equipmentcountry = resultSet.getString("EQUIPMENTCOUNTRY");
      String equipmentzipcode = resultSet.getString("EQUIPMENTZIPCODE");
      Equipment equipment = new Equipment();
      equipment.setEquipmentId(id);
      equipment.setEquipmentName(equipmentname);
      equipment.setEquipmentAddress(equipmentaddress);
      equipment.setEquipmentCity(equipmentcity);
      equipment.setEquipmentState(equipmentstate);
      equipment.setEquipmentCountry(equipmentcountry);
      equipment.setEquipmentZipCode(equipmentzipcode);
       equipmentList.add(equipment);
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
  return equipmentList;
 }

public static void main( String[] args ) {
}

} 

