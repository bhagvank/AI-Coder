import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Creditcardaccount;
import org.archcorner.chartreuse.util.JDBCManager;

public class CreditcardaccountDAO{ 


private String highestIDSQL = "SELECT MAX(CREDITCARDACCOUNTID) AS MAXCREDITCARDACCOUNTID FROM CREDITCARDACCOUNT";
private String selectSQL = "SELECT * FROM CREDITCARDACCOUNT WHERE CREDITCARDACCOUNTNAME=?";
private String selectIdSQL = "SELECT * FROM CREDITCARDACCOUNT WHERE CREDITCARDACCOUNTID=?";
private String insertSQL = "INSERT INTO CREDITCARDACCOUNT(CREDITCARDACCOUNTID,CREDITCARDACCOUNTNAME,CREDITCARDACCOUNTADDRESS,CREDITCARDACCOUNTCITY,CREDITCARDACCOUNTSTATE,CREDITCARDACCOUNTCOUNTRY,CREDITCARDACCOUNTZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE CREDITCARDACCOUNT SET CREDITCARDACCOUNTNAME=?,CREDITCARDACCOUNTADDRESS=?,CREDITCARDACCOUNTCITY=?,CREDITCARDACCOUNTSTATE=?,CREDITCARDACCOUNTCOUNTRY=?,CREDITCARDACCOUNTZIPCODE=? WHERE CREDITCARDACCOUNTID=?";
private String deleteSQL = "DELETE FROM CREDITCARDACCOUNT WHERE CREDITCARDACCOUNTID=?";
private String selectAllSQL = "SELECT * FROM CREDITCARDACCOUNT";

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
    highestId = resultSet.getInt("MAXCREDITCARDACCOUNTID");
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

public Creditcardaccount getCreditcardaccountById(int creditcardaccountid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Creditcardaccount creditcardaccount = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, creditcardaccountid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("creditcardaccountid");
      String creditcardaccountname = resultSet.getString("CREDITCARDACCOUNTNAME");
      String creditcardaccountaddress = resultSet.getString("CREDITCARDACCOUNTADDRESS");
      String creditcardaccountcity = resultSet.getString("CREDITCARDACCOUNTCITY");
      String creditcardaccountstate = resultSet.getString("CREDITCARDACCOUNTSTATE");
      String creditcardaccountcountry = resultSet.getString("CREDITCARDACCOUNTCOUNTRY");
      String creditcardaccountzipcode = resultSet.getString("CREDITCARDACCOUNTZIPCODE");
      creditcardaccount = new Creditcardaccount();
      creditcardaccount.setCreditcardaccountId(id);
      creditcardaccount.setCreditcardaccountName(creditcardaccountname);
      creditcardaccount.setCreditcardaccountAddress(creditcardaccountaddress);
      creditcardaccount.setCreditcardaccountCity(creditcardaccountcity);
      creditcardaccount.setCreditcardaccountState(creditcardaccountstate);
      creditcardaccount.setCreditcardaccountCountry(creditcardaccountcountry);
      creditcardaccount.setCreditcardaccountZipCode(creditcardaccountzipcode);
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
  return creditcardaccount;
 }

public Creditcardaccount getCreditcardaccount(String creditcardaccountname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Creditcardaccount creditcardaccount = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, creditcardaccountname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("CreditcardaccountId");
      creditcardaccountname = resultSet.getString("CREDITCARDACCOUNTNAME");
      String creditcardaccountaddress = resultSet.getString("CREDITCARDACCOUNTADDRESS");
      String creditcardaccountcity = resultSet.getString("CREDITCARDACCOUNTCITY");
      String creditcardaccountstate = resultSet.getString("CREDITCARDACCOUNTSTATE");
      String creditcardaccountcountry = resultSet.getString("CREDITCARDACCOUNTCOUNTRY");
      String creditcardaccountzipcode = resultSet.getString("CREDITCARDACCOUNTZIPCODE");
      creditcardaccount = new Creditcardaccount();
      creditcardaccount.setCreditcardaccountId(id);
      creditcardaccount.setCreditcardaccountName(creditcardaccountname);
      creditcardaccount.setCreditcardaccountAddress(creditcardaccountaddress);
      creditcardaccount.setCreditcardaccountCity(creditcardaccountcity);
      creditcardaccount.setCreditcardaccountState(creditcardaccountstate);
      creditcardaccount.setCreditcardaccountCountry(creditcardaccountcountry);
      creditcardaccount.setCreditcardaccountZipCode(creditcardaccountzipcode);
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
  return creditcardaccount;
 }

public void deleteCreditcardaccount(Creditcardaccount creditcardaccount)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, creditcardaccount.getCreditcardaccountId());
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

public void insertCreditcardaccount(Creditcardaccount creditcardaccount)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,creditcardaccount.getCreditcardaccountName());
    preparedStatement.setString(3,creditcardaccount.getCreditcardaccountAddress());
    preparedStatement.setString(4,creditcardaccount.getCreditcardaccountCity());
    preparedStatement.setString(5,creditcardaccount.getCreditcardaccountState());
    preparedStatement.setString(6,creditcardaccount.getCreditcardaccountCountry());
    preparedStatement.setString(7,creditcardaccount.getCreditcardaccountZipCode());
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

public void updateCreditcardaccount(Creditcardaccount creditcardaccount)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,creditcardaccount.getCreditcardaccountName());
    preparedStatement.setString(2,creditcardaccount.getCreditcardaccountAddress());
    preparedStatement.setString(3,creditcardaccount.getCreditcardaccountCity());
    preparedStatement.setString(4,creditcardaccount.getCreditcardaccountState());
    preparedStatement.setString(5,creditcardaccount.getCreditcardaccountCountry());
    preparedStatement.setString(6,creditcardaccount.getCreditcardaccountZipCode());
    preparedStatement.setInt(7, creditcardaccount.getCreditcardaccountId());
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

public List<Creditcardaccount> getCreditcardaccounts( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Creditcardaccount> creditcardaccountList = new ArrayList<Creditcardaccount>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("CREDITCARDACCOUNTID");
      String creditcardaccountname = resultSet.getString("CREDITCARDACCOUNTNAME");
      String creditcardaccountaddress = resultSet.getString("CREDITCARDACCOUNTADDRESS");
      String creditcardaccountcity = resultSet.getString("CREDITCARDACCOUNTCITY");
      String creditcardaccountstate = resultSet.getString("CREDITCARDACCOUNTSTATE");
      String creditcardaccountcountry = resultSet.getString("CREDITCARDACCOUNTCOUNTRY");
      String creditcardaccountzipcode = resultSet.getString("CREDITCARDACCOUNTZIPCODE");
      Creditcardaccount creditcardaccount = new Creditcardaccount();
      creditcardaccount.setCreditcardaccountId(id);
      creditcardaccount.setCreditcardaccountName(creditcardaccountname);
      creditcardaccount.setCreditcardaccountAddress(creditcardaccountaddress);
      creditcardaccount.setCreditcardaccountCity(creditcardaccountcity);
      creditcardaccount.setCreditcardaccountState(creditcardaccountstate);
      creditcardaccount.setCreditcardaccountCountry(creditcardaccountcountry);
      creditcardaccount.setCreditcardaccountZipCode(creditcardaccountzipcode);
       creditcardaccountList.add(creditcardaccount);
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
  return creditcardaccountList;
 }

public static void main( String[] args ) {
}

} 

