import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Store;
import org.archcorner.chartreuse.util.JDBCManager;

public class StoreDAO{ 


private String highestIDSQL = "SELECT MAX(STOREID) AS MAXSTOREID FROM STORE";
private String selectSQL = "SELECT * FROM STORE WHERE STORENAME=?";
private String selectIdSQL = "SELECT * FROM STORE WHERE STOREID=?";
private String insertSQL = "INSERT INTO STORE(STOREID,STORENAME,STOREADDRESS,STORECITY,STORESTATE,STORECOUNTRY,STOREZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE STORE SET STORENAME=?,STOREADDRESS=?,STORECITY=?,STORESTATE=?,STORECOUNTRY=?,STOREZIPCODE=? WHERE STOREID=?";
private String deleteSQL = "DELETE FROM STORE WHERE STOREID=?";
private String selectAllSQL = "SELECT * FROM STORE";

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
    highestId = resultSet.getInt("MAXSTOREID");
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

public Store getStoreById(int storeid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Store store = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, storeid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("storeid");
      String storename = resultSet.getString("STORENAME");
      String storeaddress = resultSet.getString("STOREADDRESS");
      String storecity = resultSet.getString("STORECITY");
      String storestate = resultSet.getString("STORESTATE");
      String storecountry = resultSet.getString("STORECOUNTRY");
      String storezipcode = resultSet.getString("STOREZIPCODE");
      store = new Store();
      store.setStoreId(id);
      store.setStoreName(storename);
      store.setStoreAddress(storeaddress);
      store.setStoreCity(storecity);
      store.setStoreState(storestate);
      store.setStoreCountry(storecountry);
      store.setStoreZipCode(storezipcode);
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
  return store;
 }

public Store getStore(String storename)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Store store = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, storename);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("StoreId");
      storename = resultSet.getString("STORENAME");
      String storeaddress = resultSet.getString("STOREADDRESS");
      String storecity = resultSet.getString("STORECITY");
      String storestate = resultSet.getString("STORESTATE");
      String storecountry = resultSet.getString("STORECOUNTRY");
      String storezipcode = resultSet.getString("STOREZIPCODE");
      store = new Store();
      store.setStoreId(id);
      store.setStoreName(storename);
      store.setStoreAddress(storeaddress);
      store.setStoreCity(storecity);
      store.setStoreState(storestate);
      store.setStoreCountry(storecountry);
      store.setStoreZipCode(storezipcode);
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
  return store;
 }

public void deleteStore(Store store)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, store.getStoreId());
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

public void insertStore(Store store)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,store.getStoreName());
    preparedStatement.setString(3,store.getStoreAddress());
    preparedStatement.setString(4,store.getStoreCity());
    preparedStatement.setString(5,store.getStoreState());
    preparedStatement.setString(6,store.getStoreCountry());
    preparedStatement.setString(7,store.getStoreZipCode());
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

public void updateStore(Store store)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,store.getStoreName());
    preparedStatement.setString(2,store.getStoreAddress());
    preparedStatement.setString(3,store.getStoreCity());
    preparedStatement.setString(4,store.getStoreState());
    preparedStatement.setString(5,store.getStoreCountry());
    preparedStatement.setString(6,store.getStoreZipCode());
    preparedStatement.setInt(7, store.getStoreId());
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

public List<Store> getStores( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Store> storeList = new ArrayList<Store>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("STOREID");
      String storename = resultSet.getString("STORENAME");
      String storeaddress = resultSet.getString("STOREADDRESS");
      String storecity = resultSet.getString("STORECITY");
      String storestate = resultSet.getString("STORESTATE");
      String storecountry = resultSet.getString("STORECOUNTRY");
      String storezipcode = resultSet.getString("STOREZIPCODE");
      Store store = new Store();
      store.setStoreId(id);
      store.setStoreName(storename);
      store.setStoreAddress(storeaddress);
      store.setStoreCity(storecity);
      store.setStoreState(storestate);
      store.setStoreCountry(storecountry);
      store.setStoreZipCode(storezipcode);
       storeList.add(store);
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
  return storeList;
 }

public static void main( String[] args ) {
}

} 

