import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Loanaccount;
import org.archcorner.chartreuse.util.JDBCManager;

public class LoanaccountDAO{ 


private String highestIDSQL = "SELECT MAX(LOANACCOUNTID) AS MAXLOANACCOUNTID FROM LOANACCOUNT";
private String selectSQL = "SELECT * FROM LOANACCOUNT WHERE LOANACCOUNTNAME=?";
private String selectIdSQL = "SELECT * FROM LOANACCOUNT WHERE LOANACCOUNTID=?";
private String insertSQL = "INSERT INTO LOANACCOUNT(LOANACCOUNTID,LOANACCOUNTNAME,LOANACCOUNTADDRESS,LOANACCOUNTCITY,LOANACCOUNTSTATE,LOANACCOUNTCOUNTRY,LOANACCOUNTZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE LOANACCOUNT SET LOANACCOUNTNAME=?,LOANACCOUNTADDRESS=?,LOANACCOUNTCITY=?,LOANACCOUNTSTATE=?,LOANACCOUNTCOUNTRY=?,LOANACCOUNTZIPCODE=? WHERE LOANACCOUNTID=?";
private String deleteSQL = "DELETE FROM LOANACCOUNT WHERE LOANACCOUNTID=?";
private String selectAllSQL = "SELECT * FROM LOANACCOUNT";

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
    highestId = resultSet.getInt("MAXLOANACCOUNTID");
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

public Loanaccount getLoanaccountById(int loanaccountid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Loanaccount loanaccount = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, loanaccountid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("loanaccountid");
      String loanaccountname = resultSet.getString("LOANACCOUNTNAME");
      String loanaccountaddress = resultSet.getString("LOANACCOUNTADDRESS");
      String loanaccountcity = resultSet.getString("LOANACCOUNTCITY");
      String loanaccountstate = resultSet.getString("LOANACCOUNTSTATE");
      String loanaccountcountry = resultSet.getString("LOANACCOUNTCOUNTRY");
      String loanaccountzipcode = resultSet.getString("LOANACCOUNTZIPCODE");
      loanaccount = new Loanaccount();
      loanaccount.setLoanaccountId(id);
      loanaccount.setLoanaccountName(loanaccountname);
      loanaccount.setLoanaccountAddress(loanaccountaddress);
      loanaccount.setLoanaccountCity(loanaccountcity);
      loanaccount.setLoanaccountState(loanaccountstate);
      loanaccount.setLoanaccountCountry(loanaccountcountry);
      loanaccount.setLoanaccountZipCode(loanaccountzipcode);
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
  return loanaccount;
 }

public Loanaccount getLoanaccount(String loanaccountname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Loanaccount loanaccount = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, loanaccountname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("LoanaccountId");
      loanaccountname = resultSet.getString("LOANACCOUNTNAME");
      String loanaccountaddress = resultSet.getString("LOANACCOUNTADDRESS");
      String loanaccountcity = resultSet.getString("LOANACCOUNTCITY");
      String loanaccountstate = resultSet.getString("LOANACCOUNTSTATE");
      String loanaccountcountry = resultSet.getString("LOANACCOUNTCOUNTRY");
      String loanaccountzipcode = resultSet.getString("LOANACCOUNTZIPCODE");
      loanaccount = new Loanaccount();
      loanaccount.setLoanaccountId(id);
      loanaccount.setLoanaccountName(loanaccountname);
      loanaccount.setLoanaccountAddress(loanaccountaddress);
      loanaccount.setLoanaccountCity(loanaccountcity);
      loanaccount.setLoanaccountState(loanaccountstate);
      loanaccount.setLoanaccountCountry(loanaccountcountry);
      loanaccount.setLoanaccountZipCode(loanaccountzipcode);
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
  return loanaccount;
 }

public void deleteLoanaccount(Loanaccount loanaccount)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, loanaccount.getLoanaccountId());
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

public void insertLoanaccount(Loanaccount loanaccount)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,loanaccount.getLoanaccountName());
    preparedStatement.setString(3,loanaccount.getLoanaccountAddress());
    preparedStatement.setString(4,loanaccount.getLoanaccountCity());
    preparedStatement.setString(5,loanaccount.getLoanaccountState());
    preparedStatement.setString(6,loanaccount.getLoanaccountCountry());
    preparedStatement.setString(7,loanaccount.getLoanaccountZipCode());
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

public void updateLoanaccount(Loanaccount loanaccount)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,loanaccount.getLoanaccountName());
    preparedStatement.setString(2,loanaccount.getLoanaccountAddress());
    preparedStatement.setString(3,loanaccount.getLoanaccountCity());
    preparedStatement.setString(4,loanaccount.getLoanaccountState());
    preparedStatement.setString(5,loanaccount.getLoanaccountCountry());
    preparedStatement.setString(6,loanaccount.getLoanaccountZipCode());
    preparedStatement.setInt(7, loanaccount.getLoanaccountId());
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

public List<Loanaccount> getLoanaccounts( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Loanaccount> loanaccountList = new ArrayList<Loanaccount>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("LOANACCOUNTID");
      String loanaccountname = resultSet.getString("LOANACCOUNTNAME");
      String loanaccountaddress = resultSet.getString("LOANACCOUNTADDRESS");
      String loanaccountcity = resultSet.getString("LOANACCOUNTCITY");
      String loanaccountstate = resultSet.getString("LOANACCOUNTSTATE");
      String loanaccountcountry = resultSet.getString("LOANACCOUNTCOUNTRY");
      String loanaccountzipcode = resultSet.getString("LOANACCOUNTZIPCODE");
      Loanaccount loanaccount = new Loanaccount();
      loanaccount.setLoanaccountId(id);
      loanaccount.setLoanaccountName(loanaccountname);
      loanaccount.setLoanaccountAddress(loanaccountaddress);
      loanaccount.setLoanaccountCity(loanaccountcity);
      loanaccount.setLoanaccountState(loanaccountstate);
      loanaccount.setLoanaccountCountry(loanaccountcountry);
      loanaccount.setLoanaccountZipCode(loanaccountzipcode);
       loanaccountList.add(loanaccount);
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
  return loanaccountList;
 }

public static void main( String[] args ) {
}

} 

