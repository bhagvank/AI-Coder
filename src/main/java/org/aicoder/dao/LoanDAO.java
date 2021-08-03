package org.aicoder.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Loan;
import org.archcorner.chartreuse.util.JDBCManager;

public class LoanDAO{ 


private String highestIDSQL = "SELECT MAX(LOANID) AS MAXLOANID FROM LOAN";
private String selectSQL = "SELECT * FROM LOAN WHERE LOANNAME=?";
private String selectIdSQL = "SELECT * FROM LOAN WHERE LOANID=?";
private String insertSQL = "INSERT INTO LOAN(LOANID,LOANNAME,LOANADDRESS,LOANCITY,LOANSTATE,LOANCOUNTRY,LOANZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE LOAN SET LOANNAME=?,LOANADDRESS=?,LOANCITY=?,LOANSTATE=?,LOANCOUNTRY=?,LOANZIPCODE=? WHERE LOANID=?";
private String deleteSQL = "DELETE FROM LOAN WHERE LOANID=?";
private String selectAllSQL = "SELECT * FROM LOAN";

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
    highestId = resultSet.getInt("MAXLOANID");
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

public Loan getLoanById(int loanid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Loan loan = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, loanid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("loanid");
      String loanname = resultSet.getString("LOANNAME");
      String loanaddress = resultSet.getString("LOANADDRESS");
      String loancity = resultSet.getString("LOANCITY");
      String loanstate = resultSet.getString("LOANSTATE");
      String loancountry = resultSet.getString("LOANCOUNTRY");
      String loanzipcode = resultSet.getString("LOANZIPCODE");
      loan = new Loan();
      loan.setLoanId(id);
      loan.setLoanName(loanname);
      loan.setLoanAddress(loanaddress);
      loan.setLoanCity(loancity);
      loan.setLoanState(loanstate);
      loan.setLoanCountry(loancountry);
      loan.setLoanZipCode(loanzipcode);
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
  return loan;
 }

public Loan getLoan(String loanname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Loan loan = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, loanname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("LoanId");
      loanname = resultSet.getString("LOANNAME");
      String loanaddress = resultSet.getString("LOANADDRESS");
      String loancity = resultSet.getString("LOANCITY");
      String loanstate = resultSet.getString("LOANSTATE");
      String loancountry = resultSet.getString("LOANCOUNTRY");
      String loanzipcode = resultSet.getString("LOANZIPCODE");
      loan = new Loan();
      loan.setLoanId(id);
      loan.setLoanName(loanname);
      loan.setLoanAddress(loanaddress);
      loan.setLoanCity(loancity);
      loan.setLoanState(loanstate);
      loan.setLoanCountry(loancountry);
      loan.setLoanZipCode(loanzipcode);
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
  return loan;
 }

public void deleteLoan(Loan loan)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, loan.getLoanId());
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

public void insertLoan(Loan loan)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,loan.getLoanName());
    preparedStatement.setString(3,loan.getLoanAddress());
    preparedStatement.setString(4,loan.getLoanCity());
    preparedStatement.setString(5,loan.getLoanState());
    preparedStatement.setString(6,loan.getLoanCountry());
    preparedStatement.setString(7,loan.getLoanZipCode());
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

public void updateLoan(Loan loan)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,loan.getLoanName());
    preparedStatement.setString(2,loan.getLoanAddress());
    preparedStatement.setString(3,loan.getLoanCity());
    preparedStatement.setString(4,loan.getLoanState());
    preparedStatement.setString(5,loan.getLoanCountry());
    preparedStatement.setString(6,loan.getLoanZipCode());
    preparedStatement.setInt(7, loan.getLoanId());
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

public List<Loan> getLoans( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Loan> loanList = new ArrayList<Loan>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("LOANID");
      String loanname = resultSet.getString("LOANNAME");
      String loanaddress = resultSet.getString("LOANADDRESS");
      String loancity = resultSet.getString("LOANCITY");
      String loanstate = resultSet.getString("LOANSTATE");
      String loancountry = resultSet.getString("LOANCOUNTRY");
      String loanzipcode = resultSet.getString("LOANZIPCODE");
      Loan loan = new Loan();
      loan.setLoanId(id);
      loan.setLoanName(loanname);
      loan.setLoanAddress(loanaddress);
      loan.setLoanCity(loancity);
      loan.setLoanState(loanstate);
      loan.setLoanCountry(loancountry);
      loan.setLoanZipCode(loanzipcode);
       loanList.add(loan);
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
  return loanList;
 }

public static void main( String[] args ) {
}

} 

