import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Insuranceprovider;
import org.archcorner.chartreuse.util.JDBCManager;

public class InsuranceproviderDAO{ 


private String highestIDSQL = "SELECT MAX(INSURANCEPROVIDERID) AS MAXINSURANCEPROVIDERID FROM INSURANCEPROVIDER";
private String selectSQL = "SELECT * FROM INSURANCEPROVIDER WHERE INSURANCEPROVIDERNAME=?";
private String selectIdSQL = "SELECT * FROM INSURANCEPROVIDER WHERE INSURANCEPROVIDERID=?";
private String insertSQL = "INSERT INTO INSURANCEPROVIDER(INSURANCEPROVIDERID,INSURANCEPROVIDERNAME,INSURANCEPROVIDERADDRESS,INSURANCEPROVIDERCITY,INSURANCEPROVIDERSTATE,INSURANCEPROVIDERCOUNTRY,INSURANCEPROVIDERZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE INSURANCEPROVIDER SET INSURANCEPROVIDERNAME=?,INSURANCEPROVIDERADDRESS=?,INSURANCEPROVIDERCITY=?,INSURANCEPROVIDERSTATE=?,INSURANCEPROVIDERCOUNTRY=?,INSURANCEPROVIDERZIPCODE=? WHERE INSURANCEPROVIDERID=?";
private String deleteSQL = "DELETE FROM INSURANCEPROVIDER WHERE INSURANCEPROVIDERID=?";
private String selectAllSQL = "SELECT * FROM INSURANCEPROVIDER";

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
    highestId = resultSet.getInt("MAXINSURANCEPROVIDERID");
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

public Insuranceprovider getInsuranceproviderById(int insuranceproviderid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Insuranceprovider insuranceprovider = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, insuranceproviderid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("insuranceproviderid");
      String insuranceprovidername = resultSet.getString("INSURANCEPROVIDERNAME");
      String insuranceprovideraddress = resultSet.getString("INSURANCEPROVIDERADDRESS");
      String insuranceprovidercity = resultSet.getString("INSURANCEPROVIDERCITY");
      String insuranceproviderstate = resultSet.getString("INSURANCEPROVIDERSTATE");
      String insuranceprovidercountry = resultSet.getString("INSURANCEPROVIDERCOUNTRY");
      String insuranceproviderzipcode = resultSet.getString("INSURANCEPROVIDERZIPCODE");
      insuranceprovider = new Insuranceprovider();
      insuranceprovider.setInsuranceproviderId(id);
      insuranceprovider.setInsuranceproviderName(insuranceprovidername);
      insuranceprovider.setInsuranceproviderAddress(insuranceprovideraddress);
      insuranceprovider.setInsuranceproviderCity(insuranceprovidercity);
      insuranceprovider.setInsuranceproviderState(insuranceproviderstate);
      insuranceprovider.setInsuranceproviderCountry(insuranceprovidercountry);
      insuranceprovider.setInsuranceproviderZipCode(insuranceproviderzipcode);
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
  return insuranceprovider;
 }

public Insuranceprovider getInsuranceprovider(String insuranceprovidername)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Insuranceprovider insuranceprovider = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, insuranceprovidername);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("InsuranceproviderId");
      insuranceprovidername = resultSet.getString("INSURANCEPROVIDERNAME");
      String insuranceprovideraddress = resultSet.getString("INSURANCEPROVIDERADDRESS");
      String insuranceprovidercity = resultSet.getString("INSURANCEPROVIDERCITY");
      String insuranceproviderstate = resultSet.getString("INSURANCEPROVIDERSTATE");
      String insuranceprovidercountry = resultSet.getString("INSURANCEPROVIDERCOUNTRY");
      String insuranceproviderzipcode = resultSet.getString("INSURANCEPROVIDERZIPCODE");
      insuranceprovider = new Insuranceprovider();
      insuranceprovider.setInsuranceproviderId(id);
      insuranceprovider.setInsuranceproviderName(insuranceprovidername);
      insuranceprovider.setInsuranceproviderAddress(insuranceprovideraddress);
      insuranceprovider.setInsuranceproviderCity(insuranceprovidercity);
      insuranceprovider.setInsuranceproviderState(insuranceproviderstate);
      insuranceprovider.setInsuranceproviderCountry(insuranceprovidercountry);
      insuranceprovider.setInsuranceproviderZipCode(insuranceproviderzipcode);
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
  return insuranceprovider;
 }

public void deleteInsuranceprovider(Insuranceprovider insuranceprovider)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, insuranceprovider.getInsuranceproviderId());
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

public void insertInsuranceprovider(Insuranceprovider insuranceprovider)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,insuranceprovider.getInsuranceproviderName());
    preparedStatement.setString(3,insuranceprovider.getInsuranceproviderAddress());
    preparedStatement.setString(4,insuranceprovider.getInsuranceproviderCity());
    preparedStatement.setString(5,insuranceprovider.getInsuranceproviderState());
    preparedStatement.setString(6,insuranceprovider.getInsuranceproviderCountry());
    preparedStatement.setString(7,insuranceprovider.getInsuranceproviderZipCode());
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

public void updateInsuranceprovider(Insuranceprovider insuranceprovider)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,insuranceprovider.getInsuranceproviderName());
    preparedStatement.setString(2,insuranceprovider.getInsuranceproviderAddress());
    preparedStatement.setString(3,insuranceprovider.getInsuranceproviderCity());
    preparedStatement.setString(4,insuranceprovider.getInsuranceproviderState());
    preparedStatement.setString(5,insuranceprovider.getInsuranceproviderCountry());
    preparedStatement.setString(6,insuranceprovider.getInsuranceproviderZipCode());
    preparedStatement.setInt(7, insuranceprovider.getInsuranceproviderId());
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

public List<Insuranceprovider> getInsuranceproviders( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Insuranceprovider> insuranceproviderList = new ArrayList<Insuranceprovider>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("INSURANCEPROVIDERID");
      String insuranceprovidername = resultSet.getString("INSURANCEPROVIDERNAME");
      String insuranceprovideraddress = resultSet.getString("INSURANCEPROVIDERADDRESS");
      String insuranceprovidercity = resultSet.getString("INSURANCEPROVIDERCITY");
      String insuranceproviderstate = resultSet.getString("INSURANCEPROVIDERSTATE");
      String insuranceprovidercountry = resultSet.getString("INSURANCEPROVIDERCOUNTRY");
      String insuranceproviderzipcode = resultSet.getString("INSURANCEPROVIDERZIPCODE");
      Insuranceprovider insuranceprovider = new Insuranceprovider();
      insuranceprovider.setInsuranceproviderId(id);
      insuranceprovider.setInsuranceproviderName(insuranceprovidername);
      insuranceprovider.setInsuranceproviderAddress(insuranceprovideraddress);
      insuranceprovider.setInsuranceproviderCity(insuranceprovidercity);
      insuranceprovider.setInsuranceproviderState(insuranceproviderstate);
      insuranceprovider.setInsuranceproviderCountry(insuranceprovidercountry);
      insuranceprovider.setInsuranceproviderZipCode(insuranceproviderzipcode);
       insuranceproviderList.add(insuranceprovider);
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
  return insuranceproviderList;
 }

public static void main( String[] args ) {
}

} 

