package org.aicoder.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.ApparmentBlock;
import org.archcorner.chartreuse.util.JDBCManager;

public class ApparmentBlockDAO{ 


private String highestIDSQL = "SELECT MAX(APPARMENTBLOCKID) AS MAXAPPARMENTBLOCKID FROM APPARMENTBLOCK";
private String selectSQL = "SELECT * FROM APPARMENTBLOCK WHERE APPARMENTBLOCKNAME=?";
private String selectIdSQL = "SELECT * FROM APPARMENTBLOCK WHERE APPARMENTBLOCKID=?";
private String insertSQL = "INSERT INTO APPARMENTBLOCK(APPARMENTBLOCKID,APPARMENTBLOCKNAME,APPARMENTBLOCKADDRESS,APPARMENTBLOCKCITY,APPARMENTBLOCKSTATE,APPARMENTBLOCKCOUNTRY,APPARMENTBLOCKZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE APPARMENTBLOCK SET APPARMENTBLOCKNAME=?,APPARMENTBLOCKADDRESS=?,APPARMENTBLOCKCITY=?,APPARMENTBLOCKSTATE=?,APPARMENTBLOCKCOUNTRY=?,APPARMENTBLOCKZIPCODE=? WHERE APPARMENTBLOCKID=?";
private String deleteSQL = "DELETE FROM APPARMENTBLOCK WHERE APPARMENTBLOCKID=?";
private String selectAllSQL = "SELECT * FROM APPARMENTBLOCK";

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
    highestId = resultSet.getInt("MAXAPPARMENTBLOCKID");
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

public ApparmentBlock getApparmentBlockById(int apparmentblockid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   ApparmentBlock apparmentblock = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, apparmentblockid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("apparmentblockid");
      String apparmentblockname = resultSet.getString("APPARMENTBLOCKNAME");
      String apparmentblockaddress = resultSet.getString("APPARMENTBLOCKADDRESS");
      String apparmentblockcity = resultSet.getString("APPARMENTBLOCKCITY");
      String apparmentblockstate = resultSet.getString("APPARMENTBLOCKSTATE");
      String apparmentblockcountry = resultSet.getString("APPARMENTBLOCKCOUNTRY");
      String apparmentblockzipcode = resultSet.getString("APPARMENTBLOCKZIPCODE");
      apparmentblock = new ApparmentBlock();
      apparmentblock.setApparmentBlockId(id);
      apparmentblock.setApparmentBlockName(apparmentblockname);
      apparmentblock.setApparmentBlockAddress(apparmentblockaddress);
      apparmentblock.setApparmentBlockCity(apparmentblockcity);
      apparmentblock.setApparmentBlockState(apparmentblockstate);
      apparmentblock.setApparmentBlockCountry(apparmentblockcountry);
      apparmentblock.setApparmentBlockZipCode(apparmentblockzipcode);
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
  return apparmentblock;
 }

public ApparmentBlock getApparmentBlock(String apparmentblockname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   ApparmentBlock apparmentblock = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, apparmentblockname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("ApparmentBlockId");
      apparmentblockname = resultSet.getString("APPARMENTBLOCKNAME");
      String apparmentblockaddress = resultSet.getString("APPARMENTBLOCKADDRESS");
      String apparmentblockcity = resultSet.getString("APPARMENTBLOCKCITY");
      String apparmentblockstate = resultSet.getString("APPARMENTBLOCKSTATE");
      String apparmentblockcountry = resultSet.getString("APPARMENTBLOCKCOUNTRY");
      String apparmentblockzipcode = resultSet.getString("APPARMENTBLOCKZIPCODE");
      apparmentblock = new ApparmentBlock();
      apparmentblock.setApparmentBlockId(id);
      apparmentblock.setApparmentBlockName(apparmentblockname);
      apparmentblock.setApparmentBlockAddress(apparmentblockaddress);
      apparmentblock.setApparmentBlockCity(apparmentblockcity);
      apparmentblock.setApparmentBlockState(apparmentblockstate);
      apparmentblock.setApparmentBlockCountry(apparmentblockcountry);
      apparmentblock.setApparmentBlockZipCode(apparmentblockzipcode);
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
  return apparmentblock;
 }

public void deleteApparmentBlock(ApparmentBlock apparmentblock)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, apparmentblock.getApparmentBlockId());
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

public void insertApparmentBlock(ApparmentBlock apparmentblock)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,apparmentblock.getApparmentBlockName());
    preparedStatement.setString(3,apparmentblock.getApparmentBlockAddress());
    preparedStatement.setString(4,apparmentblock.getApparmentBlockCity());
    preparedStatement.setString(5,apparmentblock.getApparmentBlockState());
    preparedStatement.setString(6,apparmentblock.getApparmentBlockCountry());
    preparedStatement.setString(7,apparmentblock.getApparmentBlockZipCode());
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

public void updateApparmentBlock(ApparmentBlock apparmentblock)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,apparmentblock.getApparmentBlockName());
    preparedStatement.setString(2,apparmentblock.getApparmentBlockAddress());
    preparedStatement.setString(3,apparmentblock.getApparmentBlockCity());
    preparedStatement.setString(4,apparmentblock.getApparmentBlockState());
    preparedStatement.setString(5,apparmentblock.getApparmentBlockCountry());
    preparedStatement.setString(6,apparmentblock.getApparmentBlockZipCode());
    preparedStatement.setInt(7, apparmentblock.getApparmentBlockId());
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

public List<ApparmentBlock> getApparmentBlocks( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<ApparmentBlock> apparmentblockList = new ArrayList<ApparmentBlock>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("APPARMENTBLOCKID");
      String apparmentblockname = resultSet.getString("APPARMENTBLOCKNAME");
      String apparmentblockaddress = resultSet.getString("APPARMENTBLOCKADDRESS");
      String apparmentblockcity = resultSet.getString("APPARMENTBLOCKCITY");
      String apparmentblockstate = resultSet.getString("APPARMENTBLOCKSTATE");
      String apparmentblockcountry = resultSet.getString("APPARMENTBLOCKCOUNTRY");
      String apparmentblockzipcode = resultSet.getString("APPARMENTBLOCKZIPCODE");
      ApparmentBlock apparmentblock = new ApparmentBlock();
      apparmentblock.setApparmentBlockId(id);
      apparmentblock.setApparmentBlockName(apparmentblockname);
      apparmentblock.setApparmentBlockAddress(apparmentblockaddress);
      apparmentblock.setApparmentBlockCity(apparmentblockcity);
      apparmentblock.setApparmentBlockState(apparmentblockstate);
      apparmentblock.setApparmentBlockCountry(apparmentblockcountry);
      apparmentblock.setApparmentBlockZipCode(apparmentblockzipcode);
       apparmentblockList.add(apparmentblock);
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
  return apparmentblockList;
 }

public static void main( String[] args ) {
}

} 

