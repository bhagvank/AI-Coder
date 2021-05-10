import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Invoice;
import org.archcorner.chartreuse.util.JDBCManager;

public class InvoiceDAO{ 


private String highestIDSQL = "SELECT MAX(INVOICEID) AS MAXINVOICEID FROM INVOICE";
private String selectSQL = "SELECT * FROM INVOICE WHERE INVOICENAME=?";
private String selectIdSQL = "SELECT * FROM INVOICE WHERE INVOICEID=?";
private String insertSQL = "INSERT INTO INVOICE(INVOICEID,INVOICENAME,INVOICEADDRESS,INVOICECITY,INVOICESTATE,INVOICECOUNTRY,INVOICEZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE INVOICE SET INVOICENAME=?,INVOICEADDRESS=?,INVOICECITY=?,INVOICESTATE=?,INVOICECOUNTRY=?,INVOICEZIPCODE=? WHERE INVOICEID=?";
private String deleteSQL = "DELETE FROM INVOICE WHERE INVOICEID=?";
private String selectAllSQL = "SELECT * FROM INVOICE";

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
    highestId = resultSet.getInt("MAXINVOICEID");
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

public Invoice getInvoiceById(int invoiceid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Invoice invoice = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, invoiceid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("invoiceid");
      String invoicename = resultSet.getString("INVOICENAME");
      String invoiceaddress = resultSet.getString("INVOICEADDRESS");
      String invoicecity = resultSet.getString("INVOICECITY");
      String invoicestate = resultSet.getString("INVOICESTATE");
      String invoicecountry = resultSet.getString("INVOICECOUNTRY");
      String invoicezipcode = resultSet.getString("INVOICEZIPCODE");
      invoice = new Invoice();
      invoice.setInvoiceId(id);
      invoice.setInvoiceName(invoicename);
      invoice.setInvoiceAddress(invoiceaddress);
      invoice.setInvoiceCity(invoicecity);
      invoice.setInvoiceState(invoicestate);
      invoice.setInvoiceCountry(invoicecountry);
      invoice.setInvoiceZipCode(invoicezipcode);
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
  return invoice;
 }

public Invoice getInvoice(String invoicename)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Invoice invoice = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, invoicename);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("InvoiceId");
      invoicename = resultSet.getString("INVOICENAME");
      String invoiceaddress = resultSet.getString("INVOICEADDRESS");
      String invoicecity = resultSet.getString("INVOICECITY");
      String invoicestate = resultSet.getString("INVOICESTATE");
      String invoicecountry = resultSet.getString("INVOICECOUNTRY");
      String invoicezipcode = resultSet.getString("INVOICEZIPCODE");
      invoice = new Invoice();
      invoice.setInvoiceId(id);
      invoice.setInvoiceName(invoicename);
      invoice.setInvoiceAddress(invoiceaddress);
      invoice.setInvoiceCity(invoicecity);
      invoice.setInvoiceState(invoicestate);
      invoice.setInvoiceCountry(invoicecountry);
      invoice.setInvoiceZipCode(invoicezipcode);
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
  return invoice;
 }

public void deleteInvoice(Invoice invoice)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, invoice.getInvoiceId());
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

public void insertInvoice(Invoice invoice)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,invoice.getInvoiceName());
    preparedStatement.setString(3,invoice.getInvoiceAddress());
    preparedStatement.setString(4,invoice.getInvoiceCity());
    preparedStatement.setString(5,invoice.getInvoiceState());
    preparedStatement.setString(6,invoice.getInvoiceCountry());
    preparedStatement.setString(7,invoice.getInvoiceZipCode());
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

public void updateInvoice(Invoice invoice)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,invoice.getInvoiceName());
    preparedStatement.setString(2,invoice.getInvoiceAddress());
    preparedStatement.setString(3,invoice.getInvoiceCity());
    preparedStatement.setString(4,invoice.getInvoiceState());
    preparedStatement.setString(5,invoice.getInvoiceCountry());
    preparedStatement.setString(6,invoice.getInvoiceZipCode());
    preparedStatement.setInt(7, invoice.getInvoiceId());
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

public List<Invoice> getInvoices( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Invoice> invoiceList = new ArrayList<Invoice>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("INVOICEID");
      String invoicename = resultSet.getString("INVOICENAME");
      String invoiceaddress = resultSet.getString("INVOICEADDRESS");
      String invoicecity = resultSet.getString("INVOICECITY");
      String invoicestate = resultSet.getString("INVOICESTATE");
      String invoicecountry = resultSet.getString("INVOICECOUNTRY");
      String invoicezipcode = resultSet.getString("INVOICEZIPCODE");
      Invoice invoice = new Invoice();
      invoice.setInvoiceId(id);
      invoice.setInvoiceName(invoicename);
      invoice.setInvoiceAddress(invoiceaddress);
      invoice.setInvoiceCity(invoicecity);
      invoice.setInvoiceState(invoicestate);
      invoice.setInvoiceCountry(invoicecountry);
      invoice.setInvoiceZipCode(invoicezipcode);
       invoiceList.add(invoice);
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
  return invoiceList;
 }

public static void main( String[] args ) {
}

} 

