import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Partner;
import org.archcorner.chartreuse.util.JDBCManager;

public class PartnerDAO{ 


private String highestIDSQL = "SELECT MAX(PARTNERID) AS MAXPARTNERID FROM PARTNER";
private String selectSQL = "SELECT * FROM PARTNER WHERE PARTNERNAME=?";
private String selectIdSQL = "SELECT * FROM PARTNER WHERE PARTNERID=?";
private String insertSQL = "INSERT INTO PARTNER(PARTNERID,PARTNERNAME,PARTNERADDRESS,PARTNERCITY,PARTNERSTATE,PARTNERCOUNTRY,PARTNERZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE PARTNER SET PARTNERNAME=?,PARTNERADDRESS=?,PARTNERCITY=?,PARTNERSTATE=?,PARTNERCOUNTRY=?,PARTNERZIPCODE=? WHERE PARTNERID=?";
private String deleteSQL = "DELETE FROM PARTNER WHERE PARTNERID=?";
private String selectAllSQL = "SELECT * FROM PARTNER";

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
    highestId = resultSet.getInt("MAXPARTNERID");
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

public Partner getPartnerById(int partnerid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Partner partner = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, partnerid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("partnerid");
      String partnername = resultSet.getString("PARTNERNAME");
      String partneraddress = resultSet.getString("PARTNERADDRESS");
      String partnercity = resultSet.getString("PARTNERCITY");
      String partnerstate = resultSet.getString("PARTNERSTATE");
      String partnercountry = resultSet.getString("PARTNERCOUNTRY");
      String partnerzipcode = resultSet.getString("PARTNERZIPCODE");
      partner = new Partner();
      partner.setPartnerId(id);
      partner.setPartnerName(partnername);
      partner.setPartnerAddress(partneraddress);
      partner.setPartnerCity(partnercity);
      partner.setPartnerState(partnerstate);
      partner.setPartnerCountry(partnercountry);
      partner.setPartnerZipCode(partnerzipcode);
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
  return partner;
 }

public Partner getPartner(String partnername)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Partner partner = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, partnername);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("PartnerId");
      partnername = resultSet.getString("PARTNERNAME");
      String partneraddress = resultSet.getString("PARTNERADDRESS");
      String partnercity = resultSet.getString("PARTNERCITY");
      String partnerstate = resultSet.getString("PARTNERSTATE");
      String partnercountry = resultSet.getString("PARTNERCOUNTRY");
      String partnerzipcode = resultSet.getString("PARTNERZIPCODE");
      partner = new Partner();
      partner.setPartnerId(id);
      partner.setPartnerName(partnername);
      partner.setPartnerAddress(partneraddress);
      partner.setPartnerCity(partnercity);
      partner.setPartnerState(partnerstate);
      partner.setPartnerCountry(partnercountry);
      partner.setPartnerZipCode(partnerzipcode);
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
  return partner;
 }

public void deletePartner(Partner partner)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, partner.getPartnerId());
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

public void insertPartner(Partner partner)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,partner.getPartnerName());
    preparedStatement.setString(3,partner.getPartnerAddress());
    preparedStatement.setString(4,partner.getPartnerCity());
    preparedStatement.setString(5,partner.getPartnerState());
    preparedStatement.setString(6,partner.getPartnerCountry());
    preparedStatement.setString(7,partner.getPartnerZipCode());
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

public void updatePartner(Partner partner)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,partner.getPartnerName());
    preparedStatement.setString(2,partner.getPartnerAddress());
    preparedStatement.setString(3,partner.getPartnerCity());
    preparedStatement.setString(4,partner.getPartnerState());
    preparedStatement.setString(5,partner.getPartnerCountry());
    preparedStatement.setString(6,partner.getPartnerZipCode());
    preparedStatement.setInt(7, partner.getPartnerId());
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

public List<Partner> getPartners( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Partner> partnerList = new ArrayList<Partner>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("PARTNERID");
      String partnername = resultSet.getString("PARTNERNAME");
      String partneraddress = resultSet.getString("PARTNERADDRESS");
      String partnercity = resultSet.getString("PARTNERCITY");
      String partnerstate = resultSet.getString("PARTNERSTATE");
      String partnercountry = resultSet.getString("PARTNERCOUNTRY");
      String partnerzipcode = resultSet.getString("PARTNERZIPCODE");
      Partner partner = new Partner();
      partner.setPartnerId(id);
      partner.setPartnerName(partnername);
      partner.setPartnerAddress(partneraddress);
      partner.setPartnerCity(partnercity);
      partner.setPartnerState(partnerstate);
      partner.setPartnerCountry(partnercountry);
      partner.setPartnerZipCode(partnerzipcode);
       partnerList.add(partner);
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
  return partnerList;
 }

public static void main( String[] args ) {
}

} 

