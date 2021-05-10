import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Payment;
import org.archcorner.chartreuse.util.JDBCManager;

public class PaymentDAO{ 


private String highestIDSQL = "SELECT MAX(PAYMENTID) AS MAXPAYMENTID FROM PAYMENT";
private String selectSQL = "SELECT * FROM PAYMENT WHERE PAYMENTNAME=?";
private String selectIdSQL = "SELECT * FROM PAYMENT WHERE PAYMENTID=?";
private String insertSQL = "INSERT INTO PAYMENT(PAYMENTID,PAYMENTNAME,PAYMENTADDRESS,PAYMENTCITY,PAYMENTSTATE,PAYMENTCOUNTRY,PAYMENTZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE PAYMENT SET PAYMENTNAME=?,PAYMENTADDRESS=?,PAYMENTCITY=?,PAYMENTSTATE=?,PAYMENTCOUNTRY=?,PAYMENTZIPCODE=? WHERE PAYMENTID=?";
private String deleteSQL = "DELETE FROM PAYMENT WHERE PAYMENTID=?";
private String selectAllSQL = "SELECT * FROM PAYMENT";

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
    highestId = resultSet.getInt("MAXPAYMENTID");
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

public Payment getPaymentById(int paymentid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Payment payment = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, paymentid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("paymentid");
      String paymentname = resultSet.getString("PAYMENTNAME");
      String paymentaddress = resultSet.getString("PAYMENTADDRESS");
      String paymentcity = resultSet.getString("PAYMENTCITY");
      String paymentstate = resultSet.getString("PAYMENTSTATE");
      String paymentcountry = resultSet.getString("PAYMENTCOUNTRY");
      String paymentzipcode = resultSet.getString("PAYMENTZIPCODE");
      payment = new Payment();
      payment.setPaymentId(id);
      payment.setPaymentName(paymentname);
      payment.setPaymentAddress(paymentaddress);
      payment.setPaymentCity(paymentcity);
      payment.setPaymentState(paymentstate);
      payment.setPaymentCountry(paymentcountry);
      payment.setPaymentZipCode(paymentzipcode);
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
  return payment;
 }

public Payment getPayment(String paymentname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Payment payment = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, paymentname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("PaymentId");
      paymentname = resultSet.getString("PAYMENTNAME");
      String paymentaddress = resultSet.getString("PAYMENTADDRESS");
      String paymentcity = resultSet.getString("PAYMENTCITY");
      String paymentstate = resultSet.getString("PAYMENTSTATE");
      String paymentcountry = resultSet.getString("PAYMENTCOUNTRY");
      String paymentzipcode = resultSet.getString("PAYMENTZIPCODE");
      payment = new Payment();
      payment.setPaymentId(id);
      payment.setPaymentName(paymentname);
      payment.setPaymentAddress(paymentaddress);
      payment.setPaymentCity(paymentcity);
      payment.setPaymentState(paymentstate);
      payment.setPaymentCountry(paymentcountry);
      payment.setPaymentZipCode(paymentzipcode);
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
  return payment;
 }

public void deletePayment(Payment payment)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, payment.getPaymentId());
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

public void insertPayment(Payment payment)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,payment.getPaymentName());
    preparedStatement.setString(3,payment.getPaymentAddress());
    preparedStatement.setString(4,payment.getPaymentCity());
    preparedStatement.setString(5,payment.getPaymentState());
    preparedStatement.setString(6,payment.getPaymentCountry());
    preparedStatement.setString(7,payment.getPaymentZipCode());
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

public void updatePayment(Payment payment)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,payment.getPaymentName());
    preparedStatement.setString(2,payment.getPaymentAddress());
    preparedStatement.setString(3,payment.getPaymentCity());
    preparedStatement.setString(4,payment.getPaymentState());
    preparedStatement.setString(5,payment.getPaymentCountry());
    preparedStatement.setString(6,payment.getPaymentZipCode());
    preparedStatement.setInt(7, payment.getPaymentId());
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

public List<Payment> getPayments( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Payment> paymentList = new ArrayList<Payment>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("PAYMENTID");
      String paymentname = resultSet.getString("PAYMENTNAME");
      String paymentaddress = resultSet.getString("PAYMENTADDRESS");
      String paymentcity = resultSet.getString("PAYMENTCITY");
      String paymentstate = resultSet.getString("PAYMENTSTATE");
      String paymentcountry = resultSet.getString("PAYMENTCOUNTRY");
      String paymentzipcode = resultSet.getString("PAYMENTZIPCODE");
      Payment payment = new Payment();
      payment.setPaymentId(id);
      payment.setPaymentName(paymentname);
      payment.setPaymentAddress(paymentaddress);
      payment.setPaymentCity(paymentcity);
      payment.setPaymentState(paymentstate);
      payment.setPaymentCountry(paymentcountry);
      payment.setPaymentZipCode(paymentzipcode);
       paymentList.add(payment);
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
  return paymentList;
 }

public static void main( String[] args ) {
}

} 

