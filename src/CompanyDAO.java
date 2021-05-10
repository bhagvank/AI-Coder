import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Company;
import org.archcorner.chartreuse.util.JDBCManager;

public class CompanyDAO{ 


private String highestIDSQL = "SELECT MAX(COMPANYID) AS MAXCOMPANYID FROM COMPANY";
private String selectSQL = "SELECT * FROM COMPANY WHERE COMPANYNAME=?";
private String selectIdSQL = "SELECT * FROM COMPANY WHERE COMPANYID=?";
private String insertSQL = "INSERT INTO COMPANY(COMPANYID,COMPANYNAME,COMPANYADDRESS,COMPANYCITY,COMPANYSTATE,COMPANYCOUNTRY,COMPANYZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE COMPANY SET COMPANYNAME=?,COMPANYADDRESS=?,COMPANYCITY=?,COMPANYSTATE=?,COMPANYCOUNTRY=?,COMPANYZIPCODE=? WHERE COMPANYID=?";
private String deleteSQL = "DELETE FROM COMPANY WHERE COMPANYID=?";
private String selectAllSQL = "SELECT * FROM COMPANY";

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
    highestId = resultSet.getInt("MAXCOMPANYID");
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

public Company getCompanyById(int companyid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Company company = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, companyid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("companyid");
      String companyname = resultSet.getString("COMPANYNAME");
      String companyaddress = resultSet.getString("COMPANYADDRESS");
      String companycity = resultSet.getString("COMPANYCITY");
      String companystate = resultSet.getString("COMPANYSTATE");
      String companycountry = resultSet.getString("COMPANYCOUNTRY");
      String companyzipcode = resultSet.getString("COMPANYZIPCODE");
      company = new Company();
      company.setCompanyId(id);
      company.setCompanyName(companyname);
      company.setCompanyAddress(companyaddress);
      company.setCompanyCity(companycity);
      company.setCompanyState(companystate);
      company.setCompanyCountry(companycountry);
      company.setCompanyZipCode(companyzipcode);
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
  return company;
 }

public Company getCompany(String companyname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Company company = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, companyname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("CompanyId");
      companyname = resultSet.getString("COMPANYNAME");
      String companyaddress = resultSet.getString("COMPANYADDRESS");
      String companycity = resultSet.getString("COMPANYCITY");
      String companystate = resultSet.getString("COMPANYSTATE");
      String companycountry = resultSet.getString("COMPANYCOUNTRY");
      String companyzipcode = resultSet.getString("COMPANYZIPCODE");
      company = new Company();
      company.setCompanyId(id);
      company.setCompanyName(companyname);
      company.setCompanyAddress(companyaddress);
      company.setCompanyCity(companycity);
      company.setCompanyState(companystate);
      company.setCompanyCountry(companycountry);
      company.setCompanyZipCode(companyzipcode);
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
  return company;
 }

public void deleteCompany(Company company)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, company.getCompanyId());
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

public void insertCompany(Company company)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,company.getCompanyName());
    preparedStatement.setString(3,company.getCompanyAddress());
    preparedStatement.setString(4,company.getCompanyCity());
    preparedStatement.setString(5,company.getCompanyState());
    preparedStatement.setString(6,company.getCompanyCountry());
    preparedStatement.setString(7,company.getCompanyZipCode());
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

public void updateCompany(Company company)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,company.getCompanyName());
    preparedStatement.setString(2,company.getCompanyAddress());
    preparedStatement.setString(3,company.getCompanyCity());
    preparedStatement.setString(4,company.getCompanyState());
    preparedStatement.setString(5,company.getCompanyCountry());
    preparedStatement.setString(6,company.getCompanyZipCode());
    preparedStatement.setInt(7, company.getCompanyId());
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

public List<Company> getCompanys( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Company> companyList = new ArrayList<Company>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("COMPANYID");
      String companyname = resultSet.getString("COMPANYNAME");
      String companyaddress = resultSet.getString("COMPANYADDRESS");
      String companycity = resultSet.getString("COMPANYCITY");
      String companystate = resultSet.getString("COMPANYSTATE");
      String companycountry = resultSet.getString("COMPANYCOUNTRY");
      String companyzipcode = resultSet.getString("COMPANYZIPCODE");
      Company company = new Company();
      company.setCompanyId(id);
      company.setCompanyName(companyname);
      company.setCompanyAddress(companyaddress);
      company.setCompanyCity(companycity);
      company.setCompanyState(companystate);
      company.setCompanyCountry(companycountry);
      company.setCompanyZipCode(companyzipcode);
       companyList.add(company);
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
  return companyList;
 }

public static void main( String[] args ) {
}

} 

