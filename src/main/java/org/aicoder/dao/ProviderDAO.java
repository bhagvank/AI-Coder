package org.aicoder.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Provider;
import org.archcorner.chartreuse.util.JDBCManager;

public class ProviderDAO{ 


private String highestIDSQL = "SELECT MAX(PROVIDERID) AS MAXPROVIDERID FROM PROVIDER";
private String selectSQL = "SELECT * FROM PROVIDER WHERE PROVIDERNAME=?";
private String selectIdSQL = "SELECT * FROM PROVIDER WHERE PROVIDERID=?";
private String insertSQL = "INSERT INTO PROVIDER(PROVIDERID,PROVIDERNAME,PROVIDERADDRESS,PROVIDERCITY,PROVIDERSTATE,PROVIDERCOUNTRY,PROVIDERZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE PROVIDER SET PROVIDERNAME=?,PROVIDERADDRESS=?,PROVIDERCITY=?,PROVIDERSTATE=?,PROVIDERCOUNTRY=?,PROVIDERZIPCODE=? WHERE PROVIDERID=?";
private String deleteSQL = "DELETE FROM PROVIDER WHERE PROVIDERID=?";
private String selectAllSQL = "SELECT * FROM PROVIDER";

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
    highestId = resultSet.getInt("MAXPROVIDERID");
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

public Provider getProviderById(int providerid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Provider provider = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, providerid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("providerid");
      String providername = resultSet.getString("PROVIDERNAME");
      String provideraddress = resultSet.getString("PROVIDERADDRESS");
      String providercity = resultSet.getString("PROVIDERCITY");
      String providerstate = resultSet.getString("PROVIDERSTATE");
      String providercountry = resultSet.getString("PROVIDERCOUNTRY");
      String providerzipcode = resultSet.getString("PROVIDERZIPCODE");
      provider = new Provider();
      provider.setProviderId(id);
      provider.setProviderName(providername);
      provider.setProviderAddress(provideraddress);
      provider.setProviderCity(providercity);
      provider.setProviderState(providerstate);
      provider.setProviderCountry(providercountry);
      provider.setProviderZipCode(providerzipcode);
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
  return provider;
 }

public Provider getProvider(String providername)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Provider provider = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, providername);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("ProviderId");
      providername = resultSet.getString("PROVIDERNAME");
      String provideraddress = resultSet.getString("PROVIDERADDRESS");
      String providercity = resultSet.getString("PROVIDERCITY");
      String providerstate = resultSet.getString("PROVIDERSTATE");
      String providercountry = resultSet.getString("PROVIDERCOUNTRY");
      String providerzipcode = resultSet.getString("PROVIDERZIPCODE");
      provider = new Provider();
      provider.setProviderId(id);
      provider.setProviderName(providername);
      provider.setProviderAddress(provideraddress);
      provider.setProviderCity(providercity);
      provider.setProviderState(providerstate);
      provider.setProviderCountry(providercountry);
      provider.setProviderZipCode(providerzipcode);
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
  return provider;
 }

public void deleteProvider(Provider provider)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, provider.getProviderId());
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

public void insertProvider(Provider provider)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,provider.getProviderName());
    preparedStatement.setString(3,provider.getProviderAddress());
    preparedStatement.setString(4,provider.getProviderCity());
    preparedStatement.setString(5,provider.getProviderState());
    preparedStatement.setString(6,provider.getProviderCountry());
    preparedStatement.setString(7,provider.getProviderZipCode());
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

public void updateProvider(Provider provider)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,provider.getProviderName());
    preparedStatement.setString(2,provider.getProviderAddress());
    preparedStatement.setString(3,provider.getProviderCity());
    preparedStatement.setString(4,provider.getProviderState());
    preparedStatement.setString(5,provider.getProviderCountry());
    preparedStatement.setString(6,provider.getProviderZipCode());
    preparedStatement.setInt(7, provider.getProviderId());
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

public List<Provider> getProviders( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Provider> providerList = new ArrayList<Provider>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("PROVIDERID");
      String providername = resultSet.getString("PROVIDERNAME");
      String provideraddress = resultSet.getString("PROVIDERADDRESS");
      String providercity = resultSet.getString("PROVIDERCITY");
      String providerstate = resultSet.getString("PROVIDERSTATE");
      String providercountry = resultSet.getString("PROVIDERCOUNTRY");
      String providerzipcode = resultSet.getString("PROVIDERZIPCODE");
      Provider provider = new Provider();
      provider.setProviderId(id);
      provider.setProviderName(providername);
      provider.setProviderAddress(provideraddress);
      provider.setProviderCity(providercity);
      provider.setProviderState(providerstate);
      provider.setProviderCountry(providercountry);
      provider.setProviderZipCode(providerzipcode);
       providerList.add(provider);
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
  return providerList;
 }

public static void main( String[] args ) {
}

} 

