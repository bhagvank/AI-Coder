import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Account;
import org.archcorner.chartreuse.util.JDBCManager;

public class AccountDAO{ 


private String highestIDSQL = "SELECT MAX(ACCOUNTID) AS MAXACCOUNTID FROM ACCOUNT";
private String selectSQL = "SELECT * FROM ACCOUNT WHERE ACCOUNTNAME=?";
private String selectIdSQL = "SELECT * FROM ACCOUNT WHERE ACCOUNTID=?";
private String insertSQL = "INSERT INTO ACCOUNT(ACCOUNTID,ACCOUNTNAME,ACCOUNTADDRESS,ACCOUNTCITY,ACCOUNTSTATE,ACCOUNTCOUNTRY,ACCOUNTZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE ACCOUNT SET ACCOUNTNAME=?,ACCOUNTADDRESS=?,ACCOUNTCITY=?,ACCOUNTSTATE=?,ACCOUNTCOUNTRY=?,ACCOUNTZIPCODE=? WHERE ACCOUNTID=?";
private String deleteSQL = "DELETE FROM ACCOUNT WHERE ACCOUNTID=?";
private String selectAllSQL = "SELECT * FROM ACCOUNT";

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
    highestId = resultSet.getInt("MAXACCOUNTID");
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

public Account getAccountById(int accountid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Account account = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, accountid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("accountid");
      String accountname = resultSet.getString("ACCOUNTNAME");
      String accountaddress = resultSet.getString("ACCOUNTADDRESS");
      String accountcity = resultSet.getString("ACCOUNTCITY");
      String accountstate = resultSet.getString("ACCOUNTSTATE");
      String accountcountry = resultSet.getString("ACCOUNTCOUNTRY");
      String accountzipcode = resultSet.getString("ACCOUNTZIPCODE");
      account = new Account();
      account.setAccountId(id);
      account.setAccountName(accountname);
      account.setAccountAddress(accountaddress);
      account.setAccountCity(accountcity);
      account.setAccountState(accountstate);
      account.setAccountCountry(accountcountry);
      account.setAccountZipCode(accountzipcode);
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
  return account;
 }

public Account getAccount(String accountname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Account account = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, accountname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("AccountId");
      accountname = resultSet.getString("ACCOUNTNAME");
      String accountaddress = resultSet.getString("ACCOUNTADDRESS");
      String accountcity = resultSet.getString("ACCOUNTCITY");
      String accountstate = resultSet.getString("ACCOUNTSTATE");
      String accountcountry = resultSet.getString("ACCOUNTCOUNTRY");
      String accountzipcode = resultSet.getString("ACCOUNTZIPCODE");
      account = new Account();
      account.setAccountId(id);
      account.setAccountName(accountname);
      account.setAccountAddress(accountaddress);
      account.setAccountCity(accountcity);
      account.setAccountState(accountstate);
      account.setAccountCountry(accountcountry);
      account.setAccountZipCode(accountzipcode);
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
  return account;
 }

public void deleteAccount(Account account)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, account.getAccountId());
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

public void insertAccount(Account account)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,account.getAccountName());
    preparedStatement.setString(3,account.getAccountAddress());
    preparedStatement.setString(4,account.getAccountCity());
    preparedStatement.setString(5,account.getAccountState());
    preparedStatement.setString(6,account.getAccountCountry());
    preparedStatement.setString(7,account.getAccountZipCode());
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

public void updateAccount(Account account)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,account.getAccountName());
    preparedStatement.setString(2,account.getAccountAddress());
    preparedStatement.setString(3,account.getAccountCity());
    preparedStatement.setString(4,account.getAccountState());
    preparedStatement.setString(5,account.getAccountCountry());
    preparedStatement.setString(6,account.getAccountZipCode());
    preparedStatement.setInt(7, account.getAccountId());
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

public List<Account> getAccounts( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Account> accountList = new ArrayList<Account>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("ACCOUNTID");
      String accountname = resultSet.getString("ACCOUNTNAME");
      String accountaddress = resultSet.getString("ACCOUNTADDRESS");
      String accountcity = resultSet.getString("ACCOUNTCITY");
      String accountstate = resultSet.getString("ACCOUNTSTATE");
      String accountcountry = resultSet.getString("ACCOUNTCOUNTRY");
      String accountzipcode = resultSet.getString("ACCOUNTZIPCODE");
      Account account = new Account();
      account.setAccountId(id);
      account.setAccountName(accountname);
      account.setAccountAddress(accountaddress);
      account.setAccountCity(accountcity);
      account.setAccountState(accountstate);
      account.setAccountCountry(accountcountry);
      account.setAccountZipCode(accountzipcode);
       accountList.add(account);
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
  return accountList;
 }

public static void main( String[] args ) {
}

} 

