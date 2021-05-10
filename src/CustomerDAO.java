import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Customer;
import org.archcorner.chartreuse.util.JDBCManager;

public class CustomerDAO{ 


private String highestIDSQL = "SELECT MAX(CUSTOMERID) AS MAXCUSTOMERID FROM CUSTOMER";
private String selectSQL = "SELECT * FROM CUSTOMER WHERE CUSTOMERNAME=?";
private String selectIdSQL = "SELECT * FROM CUSTOMER WHERE CUSTOMERID=?";
private String insertSQL = "INSERT INTO CUSTOMER(CUSTOMERID,CUSTOMERNAME,CUSTOMERADDRESS,CUSTOMERCITY,CUSTOMERSTATE,CUSTOMERCOUNTRY,CUSTOMERZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE CUSTOMER SET CUSTOMERNAME=?,CUSTOMERADDRESS=?,CUSTOMERCITY=?,CUSTOMERSTATE=?,CUSTOMERCOUNTRY=?,CUSTOMERZIPCODE=? WHERE CUSTOMERID=?";
private String deleteSQL = "DELETE FROM CUSTOMER WHERE CUSTOMERID=?";
private String selectAllSQL = "SELECT * FROM CUSTOMER";

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
    highestId = resultSet.getInt("MAXCUSTOMERID");
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

public Customer getCustomerById(int customerid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Customer customer = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, customerid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("customerid");
      String customername = resultSet.getString("CUSTOMERNAME");
      String customeraddress = resultSet.getString("CUSTOMERADDRESS");
      String customercity = resultSet.getString("CUSTOMERCITY");
      String customerstate = resultSet.getString("CUSTOMERSTATE");
      String customercountry = resultSet.getString("CUSTOMERCOUNTRY");
      String customerzipcode = resultSet.getString("CUSTOMERZIPCODE");
      customer = new Customer();
      customer.setCustomerId(id);
      customer.setCustomerName(customername);
      customer.setCustomerAddress(customeraddress);
      customer.setCustomerCity(customercity);
      customer.setCustomerState(customerstate);
      customer.setCustomerCountry(customercountry);
      customer.setCustomerZipCode(customerzipcode);
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
  return customer;
 }

public Customer getCustomer(String customername)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Customer customer = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, customername);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("CustomerId");
      customername = resultSet.getString("CUSTOMERNAME");
      String customeraddress = resultSet.getString("CUSTOMERADDRESS");
      String customercity = resultSet.getString("CUSTOMERCITY");
      String customerstate = resultSet.getString("CUSTOMERSTATE");
      String customercountry = resultSet.getString("CUSTOMERCOUNTRY");
      String customerzipcode = resultSet.getString("CUSTOMERZIPCODE");
      customer = new Customer();
      customer.setCustomerId(id);
      customer.setCustomerName(customername);
      customer.setCustomerAddress(customeraddress);
      customer.setCustomerCity(customercity);
      customer.setCustomerState(customerstate);
      customer.setCustomerCountry(customercountry);
      customer.setCustomerZipCode(customerzipcode);
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
  return customer;
 }

public void deleteCustomer(Customer customer)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, customer.getCustomerId());
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

public void insertCustomer(Customer customer)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,customer.getCustomerName());
    preparedStatement.setString(3,customer.getCustomerAddress());
    preparedStatement.setString(4,customer.getCustomerCity());
    preparedStatement.setString(5,customer.getCustomerState());
    preparedStatement.setString(6,customer.getCustomerCountry());
    preparedStatement.setString(7,customer.getCustomerZipCode());
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

public void updateCustomer(Customer customer)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,customer.getCustomerName());
    preparedStatement.setString(2,customer.getCustomerAddress());
    preparedStatement.setString(3,customer.getCustomerCity());
    preparedStatement.setString(4,customer.getCustomerState());
    preparedStatement.setString(5,customer.getCustomerCountry());
    preparedStatement.setString(6,customer.getCustomerZipCode());
    preparedStatement.setInt(7, customer.getCustomerId());
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

public List<Customer> getCustomers( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Customer> customerList = new ArrayList<Customer>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("CUSTOMERID");
      String customername = resultSet.getString("CUSTOMERNAME");
      String customeraddress = resultSet.getString("CUSTOMERADDRESS");
      String customercity = resultSet.getString("CUSTOMERCITY");
      String customerstate = resultSet.getString("CUSTOMERSTATE");
      String customercountry = resultSet.getString("CUSTOMERCOUNTRY");
      String customerzipcode = resultSet.getString("CUSTOMERZIPCODE");
      Customer customer = new Customer();
      customer.setCustomerId(id);
      customer.setCustomerName(customername);
      customer.setCustomerAddress(customeraddress);
      customer.setCustomerCity(customercity);
      customer.setCustomerState(customerstate);
      customer.setCustomerCountry(customercountry);
      customer.setCustomerZipCode(customerzipcode);
       customerList.add(customer);
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
  return customerList;
 }

public static void main( String[] args ) {
}

} 

