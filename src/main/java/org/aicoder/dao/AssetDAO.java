package org.aicoder.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Asset;
import org.archcorner.chartreuse.util.JDBCManager;

public class AssetDAO{ 


private String highestIDSQL = "SELECT MAX(ASSETID) AS MAXASSETID FROM ASSET";
private String selectSQL = "SELECT * FROM ASSET WHERE ASSETNAME=?";
private String selectIdSQL = "SELECT * FROM ASSET WHERE ASSETID=?";
private String insertSQL = "INSERT INTO ASSET(ASSETID,ASSETNAME,ASSETADDRESS,ASSETCITY,ASSETSTATE,ASSETCOUNTRY,ASSETZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE ASSET SET ASSETNAME=?,ASSETADDRESS=?,ASSETCITY=?,ASSETSTATE=?,ASSETCOUNTRY=?,ASSETZIPCODE=? WHERE ASSETID=?";
private String deleteSQL = "DELETE FROM ASSET WHERE ASSETID=?";
private String selectAllSQL = "SELECT * FROM ASSET";

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
    highestId = resultSet.getInt("MAXASSETID");
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

public Asset getAssetById(int assetid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Asset asset = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, assetid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("assetid");
      String assetname = resultSet.getString("ASSETNAME");
      String assetaddress = resultSet.getString("ASSETADDRESS");
      String assetcity = resultSet.getString("ASSETCITY");
      String assetstate = resultSet.getString("ASSETSTATE");
      String assetcountry = resultSet.getString("ASSETCOUNTRY");
      String assetzipcode = resultSet.getString("ASSETZIPCODE");
      asset = new Asset();
      asset.setAssetId(id);
      asset.setAssetName(assetname);
      asset.setAssetAddress(assetaddress);
      asset.setAssetCity(assetcity);
      asset.setAssetState(assetstate);
      asset.setAssetCountry(assetcountry);
      asset.setAssetZipCode(assetzipcode);
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
  return asset;
 }

public Asset getAsset(String assetname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Asset asset = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, assetname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("AssetId");
      assetname = resultSet.getString("ASSETNAME");
      String assetaddress = resultSet.getString("ASSETADDRESS");
      String assetcity = resultSet.getString("ASSETCITY");
      String assetstate = resultSet.getString("ASSETSTATE");
      String assetcountry = resultSet.getString("ASSETCOUNTRY");
      String assetzipcode = resultSet.getString("ASSETZIPCODE");
      asset = new Asset();
      asset.setAssetId(id);
      asset.setAssetName(assetname);
      asset.setAssetAddress(assetaddress);
      asset.setAssetCity(assetcity);
      asset.setAssetState(assetstate);
      asset.setAssetCountry(assetcountry);
      asset.setAssetZipCode(assetzipcode);
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
  return asset;
 }

public void deleteAsset(Asset asset)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, asset.getAssetId());
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

public void insertAsset(Asset asset)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,asset.getAssetName());
    preparedStatement.setString(3,asset.getAssetAddress());
    preparedStatement.setString(4,asset.getAssetCity());
    preparedStatement.setString(5,asset.getAssetState());
    preparedStatement.setString(6,asset.getAssetCountry());
    preparedStatement.setString(7,asset.getAssetZipCode());
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

public void updateAsset(Asset asset)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,asset.getAssetName());
    preparedStatement.setString(2,asset.getAssetAddress());
    preparedStatement.setString(3,asset.getAssetCity());
    preparedStatement.setString(4,asset.getAssetState());
    preparedStatement.setString(5,asset.getAssetCountry());
    preparedStatement.setString(6,asset.getAssetZipCode());
    preparedStatement.setInt(7, asset.getAssetId());
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

public List<Asset> getAssets( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Asset> assetList = new ArrayList<Asset>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("ASSETID");
      String assetname = resultSet.getString("ASSETNAME");
      String assetaddress = resultSet.getString("ASSETADDRESS");
      String assetcity = resultSet.getString("ASSETCITY");
      String assetstate = resultSet.getString("ASSETSTATE");
      String assetcountry = resultSet.getString("ASSETCOUNTRY");
      String assetzipcode = resultSet.getString("ASSETZIPCODE");
      Asset asset = new Asset();
      asset.setAssetId(id);
      asset.setAssetName(assetname);
      asset.setAssetAddress(assetaddress);
      asset.setAssetCity(assetcity);
      asset.setAssetState(assetstate);
      asset.setAssetCountry(assetcountry);
      asset.setAssetZipCode(assetzipcode);
       assetList.add(asset);
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
  return assetList;
 }

public static void main( String[] args ) {
}

} 

