package org.aicoder.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Attachment;
import org.archcorner.chartreuse.util.JDBCManager;

public class AttachmentDAO{ 


private String highestIDSQL = "SELECT MAX(ATTACHMENTID) AS MAXATTACHMENTID FROM ATTACHMENT";
private String selectSQL = "SELECT * FROM ATTACHMENT WHERE ATTACHMENTNAME=?";
private String selectIdSQL = "SELECT * FROM ATTACHMENT WHERE ATTACHMENTID=?";
private String insertSQL = "INSERT INTO ATTACHMENT(ATTACHMENTID,ATTACHMENTNAME,ATTACHMENTADDRESS,ATTACHMENTCITY,ATTACHMENTSTATE,ATTACHMENTCOUNTRY,ATTACHMENTZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE ATTACHMENT SET ATTACHMENTNAME=?,ATTACHMENTADDRESS=?,ATTACHMENTCITY=?,ATTACHMENTSTATE=?,ATTACHMENTCOUNTRY=?,ATTACHMENTZIPCODE=? WHERE ATTACHMENTID=?";
private String deleteSQL = "DELETE FROM ATTACHMENT WHERE ATTACHMENTID=?";
private String selectAllSQL = "SELECT * FROM ATTACHMENT";

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
    highestId = resultSet.getInt("MAXATTACHMENTID");
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

public Attachment getAttachmentById(int attachmentid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Attachment attachment = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, attachmentid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("attachmentid");
      String attachmentname = resultSet.getString("ATTACHMENTNAME");
      String attachmentaddress = resultSet.getString("ATTACHMENTADDRESS");
      String attachmentcity = resultSet.getString("ATTACHMENTCITY");
      String attachmentstate = resultSet.getString("ATTACHMENTSTATE");
      String attachmentcountry = resultSet.getString("ATTACHMENTCOUNTRY");
      String attachmentzipcode = resultSet.getString("ATTACHMENTZIPCODE");
      attachment = new Attachment();
      attachment.setAttachmentId(id);
      attachment.setAttachmentName(attachmentname);
      attachment.setAttachmentAddress(attachmentaddress);
      attachment.setAttachmentCity(attachmentcity);
      attachment.setAttachmentState(attachmentstate);
      attachment.setAttachmentCountry(attachmentcountry);
      attachment.setAttachmentZipCode(attachmentzipcode);
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
  return attachment;
 }

public Attachment getAttachment(String attachmentname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Attachment attachment = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, attachmentname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("AttachmentId");
      attachmentname = resultSet.getString("ATTACHMENTNAME");
      String attachmentaddress = resultSet.getString("ATTACHMENTADDRESS");
      String attachmentcity = resultSet.getString("ATTACHMENTCITY");
      String attachmentstate = resultSet.getString("ATTACHMENTSTATE");
      String attachmentcountry = resultSet.getString("ATTACHMENTCOUNTRY");
      String attachmentzipcode = resultSet.getString("ATTACHMENTZIPCODE");
      attachment = new Attachment();
      attachment.setAttachmentId(id);
      attachment.setAttachmentName(attachmentname);
      attachment.setAttachmentAddress(attachmentaddress);
      attachment.setAttachmentCity(attachmentcity);
      attachment.setAttachmentState(attachmentstate);
      attachment.setAttachmentCountry(attachmentcountry);
      attachment.setAttachmentZipCode(attachmentzipcode);
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
  return attachment;
 }

public void deleteAttachment(Attachment attachment)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, attachment.getAttachmentId());
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

public void insertAttachment(Attachment attachment)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,attachment.getAttachmentName());
    preparedStatement.setString(3,attachment.getAttachmentAddress());
    preparedStatement.setString(4,attachment.getAttachmentCity());
    preparedStatement.setString(5,attachment.getAttachmentState());
    preparedStatement.setString(6,attachment.getAttachmentCountry());
    preparedStatement.setString(7,attachment.getAttachmentZipCode());
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

public void updateAttachment(Attachment attachment)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,attachment.getAttachmentName());
    preparedStatement.setString(2,attachment.getAttachmentAddress());
    preparedStatement.setString(3,attachment.getAttachmentCity());
    preparedStatement.setString(4,attachment.getAttachmentState());
    preparedStatement.setString(5,attachment.getAttachmentCountry());
    preparedStatement.setString(6,attachment.getAttachmentZipCode());
    preparedStatement.setInt(7, attachment.getAttachmentId());
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

public List<Attachment> getAttachments( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Attachment> attachmentList = new ArrayList<Attachment>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("ATTACHMENTID");
      String attachmentname = resultSet.getString("ATTACHMENTNAME");
      String attachmentaddress = resultSet.getString("ATTACHMENTADDRESS");
      String attachmentcity = resultSet.getString("ATTACHMENTCITY");
      String attachmentstate = resultSet.getString("ATTACHMENTSTATE");
      String attachmentcountry = resultSet.getString("ATTACHMENTCOUNTRY");
      String attachmentzipcode = resultSet.getString("ATTACHMENTZIPCODE");
      Attachment attachment = new Attachment();
      attachment.setAttachmentId(id);
      attachment.setAttachmentName(attachmentname);
      attachment.setAttachmentAddress(attachmentaddress);
      attachment.setAttachmentCity(attachmentcity);
      attachment.setAttachmentState(attachmentstate);
      attachment.setAttachmentCountry(attachmentcountry);
      attachment.setAttachmentZipCode(attachmentzipcode);
       attachmentList.add(attachment);
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
  return attachmentList;
 }

public static void main( String[] args ) {
}

} 

