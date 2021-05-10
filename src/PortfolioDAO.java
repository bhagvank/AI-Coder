import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Portfolio;
import org.archcorner.chartreuse.util.JDBCManager;

public class PortfolioDAO{ 


private String highestIDSQL = "SELECT MAX(PORTFOLIOID) AS MAXPORTFOLIOID FROM PORTFOLIO";
private String selectSQL = "SELECT * FROM PORTFOLIO WHERE PORTFOLIONAME=?";
private String selectIdSQL = "SELECT * FROM PORTFOLIO WHERE PORTFOLIOID=?";
private String insertSQL = "INSERT INTO PORTFOLIO(PORTFOLIOID,PORTFOLIONAME,PORTFOLIOADDRESS,PORTFOLIOCITY,PORTFOLIOSTATE,PORTFOLIOCOUNTRY,PORTFOLIOZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE PORTFOLIO SET PORTFOLIONAME=?,PORTFOLIOADDRESS=?,PORTFOLIOCITY=?,PORTFOLIOSTATE=?,PORTFOLIOCOUNTRY=?,PORTFOLIOZIPCODE=? WHERE PORTFOLIOID=?";
private String deleteSQL = "DELETE FROM PORTFOLIO WHERE PORTFOLIOID=?";
private String selectAllSQL = "SELECT * FROM PORTFOLIO";

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
    highestId = resultSet.getInt("MAXPORTFOLIOID");
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

public Portfolio getPortfolioById(int portfolioid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Portfolio portfolio = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, portfolioid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("portfolioid");
      String portfolioname = resultSet.getString("PORTFOLIONAME");
      String portfolioaddress = resultSet.getString("PORTFOLIOADDRESS");
      String portfoliocity = resultSet.getString("PORTFOLIOCITY");
      String portfoliostate = resultSet.getString("PORTFOLIOSTATE");
      String portfoliocountry = resultSet.getString("PORTFOLIOCOUNTRY");
      String portfoliozipcode = resultSet.getString("PORTFOLIOZIPCODE");
      portfolio = new Portfolio();
      portfolio.setPortfolioId(id);
      portfolio.setPortfolioName(portfolioname);
      portfolio.setPortfolioAddress(portfolioaddress);
      portfolio.setPortfolioCity(portfoliocity);
      portfolio.setPortfolioState(portfoliostate);
      portfolio.setPortfolioCountry(portfoliocountry);
      portfolio.setPortfolioZipCode(portfoliozipcode);
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
  return portfolio;
 }

public Portfolio getPortfolio(String portfolioname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Portfolio portfolio = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, portfolioname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("PortfolioId");
      portfolioname = resultSet.getString("PORTFOLIONAME");
      String portfolioaddress = resultSet.getString("PORTFOLIOADDRESS");
      String portfoliocity = resultSet.getString("PORTFOLIOCITY");
      String portfoliostate = resultSet.getString("PORTFOLIOSTATE");
      String portfoliocountry = resultSet.getString("PORTFOLIOCOUNTRY");
      String portfoliozipcode = resultSet.getString("PORTFOLIOZIPCODE");
      portfolio = new Portfolio();
      portfolio.setPortfolioId(id);
      portfolio.setPortfolioName(portfolioname);
      portfolio.setPortfolioAddress(portfolioaddress);
      portfolio.setPortfolioCity(portfoliocity);
      portfolio.setPortfolioState(portfoliostate);
      portfolio.setPortfolioCountry(portfoliocountry);
      portfolio.setPortfolioZipCode(portfoliozipcode);
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
  return portfolio;
 }

public void deletePortfolio(Portfolio portfolio)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, portfolio.getPortfolioId());
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

public void insertPortfolio(Portfolio portfolio)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,portfolio.getPortfolioName());
    preparedStatement.setString(3,portfolio.getPortfolioAddress());
    preparedStatement.setString(4,portfolio.getPortfolioCity());
    preparedStatement.setString(5,portfolio.getPortfolioState());
    preparedStatement.setString(6,portfolio.getPortfolioCountry());
    preparedStatement.setString(7,portfolio.getPortfolioZipCode());
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

public void updatePortfolio(Portfolio portfolio)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,portfolio.getPortfolioName());
    preparedStatement.setString(2,portfolio.getPortfolioAddress());
    preparedStatement.setString(3,portfolio.getPortfolioCity());
    preparedStatement.setString(4,portfolio.getPortfolioState());
    preparedStatement.setString(5,portfolio.getPortfolioCountry());
    preparedStatement.setString(6,portfolio.getPortfolioZipCode());
    preparedStatement.setInt(7, portfolio.getPortfolioId());
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

public List<Portfolio> getPortfolios( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Portfolio> portfolioList = new ArrayList<Portfolio>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("PORTFOLIOID");
      String portfolioname = resultSet.getString("PORTFOLIONAME");
      String portfolioaddress = resultSet.getString("PORTFOLIOADDRESS");
      String portfoliocity = resultSet.getString("PORTFOLIOCITY");
      String portfoliostate = resultSet.getString("PORTFOLIOSTATE");
      String portfoliocountry = resultSet.getString("PORTFOLIOCOUNTRY");
      String portfoliozipcode = resultSet.getString("PORTFOLIOZIPCODE");
      Portfolio portfolio = new Portfolio();
      portfolio.setPortfolioId(id);
      portfolio.setPortfolioName(portfolioname);
      portfolio.setPortfolioAddress(portfolioaddress);
      portfolio.setPortfolioCity(portfoliocity);
      portfolio.setPortfolioState(portfoliostate);
      portfolio.setPortfolioCountry(portfoliocountry);
      portfolio.setPortfolioZipCode(portfoliozipcode);
       portfolioList.add(portfolio);
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
  return portfolioList;
 }

public static void main( String[] args ) {
}

} 

