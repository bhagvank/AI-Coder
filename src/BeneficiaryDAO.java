import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Beneficiary;
import org.archcorner.chartreuse.util.JDBCManager;

public class BeneficiaryDAO{ 


private String highestIDSQL = "SELECT MAX(BENEFICIARYID) AS MAXBENEFICIARYID FROM BENEFICIARY";
private String selectSQL = "SELECT * FROM BENEFICIARY WHERE BENEFICIARYNAME=?";
private String selectIdSQL = "SELECT * FROM BENEFICIARY WHERE BENEFICIARYID=?";
private String insertSQL = "INSERT INTO BENEFICIARY(BENEFICIARYID,BENEFICIARYNAME,BENEFICIARYADDRESS,BENEFICIARYCITY,BENEFICIARYSTATE,BENEFICIARYCOUNTRY,BENEFICIARYZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE BENEFICIARY SET BENEFICIARYNAME=?,BENEFICIARYADDRESS=?,BENEFICIARYCITY=?,BENEFICIARYSTATE=?,BENEFICIARYCOUNTRY=?,BENEFICIARYZIPCODE=? WHERE BENEFICIARYID=?";
private String deleteSQL = "DELETE FROM BENEFICIARY WHERE BENEFICIARYID=?";
private String selectAllSQL = "SELECT * FROM BENEFICIARY";

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
    highestId = resultSet.getInt("MAXBENEFICIARYID");
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

public Beneficiary getBeneficiaryById(int beneficiaryid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Beneficiary beneficiary = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, beneficiaryid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("beneficiaryid");
      String beneficiaryname = resultSet.getString("BENEFICIARYNAME");
      String beneficiaryaddress = resultSet.getString("BENEFICIARYADDRESS");
      String beneficiarycity = resultSet.getString("BENEFICIARYCITY");
      String beneficiarystate = resultSet.getString("BENEFICIARYSTATE");
      String beneficiarycountry = resultSet.getString("BENEFICIARYCOUNTRY");
      String beneficiaryzipcode = resultSet.getString("BENEFICIARYZIPCODE");
      beneficiary = new Beneficiary();
      beneficiary.setBeneficiaryId(id);
      beneficiary.setBeneficiaryName(beneficiaryname);
      beneficiary.setBeneficiaryAddress(beneficiaryaddress);
      beneficiary.setBeneficiaryCity(beneficiarycity);
      beneficiary.setBeneficiaryState(beneficiarystate);
      beneficiary.setBeneficiaryCountry(beneficiarycountry);
      beneficiary.setBeneficiaryZipCode(beneficiaryzipcode);
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
  return beneficiary;
 }

public Beneficiary getBeneficiary(String beneficiaryname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Beneficiary beneficiary = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, beneficiaryname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("BeneficiaryId");
      beneficiaryname = resultSet.getString("BENEFICIARYNAME");
      String beneficiaryaddress = resultSet.getString("BENEFICIARYADDRESS");
      String beneficiarycity = resultSet.getString("BENEFICIARYCITY");
      String beneficiarystate = resultSet.getString("BENEFICIARYSTATE");
      String beneficiarycountry = resultSet.getString("BENEFICIARYCOUNTRY");
      String beneficiaryzipcode = resultSet.getString("BENEFICIARYZIPCODE");
      beneficiary = new Beneficiary();
      beneficiary.setBeneficiaryId(id);
      beneficiary.setBeneficiaryName(beneficiaryname);
      beneficiary.setBeneficiaryAddress(beneficiaryaddress);
      beneficiary.setBeneficiaryCity(beneficiarycity);
      beneficiary.setBeneficiaryState(beneficiarystate);
      beneficiary.setBeneficiaryCountry(beneficiarycountry);
      beneficiary.setBeneficiaryZipCode(beneficiaryzipcode);
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
  return beneficiary;
 }

public void deleteBeneficiary(Beneficiary beneficiary)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, beneficiary.getBeneficiaryId());
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

public void insertBeneficiary(Beneficiary beneficiary)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,beneficiary.getBeneficiaryName());
    preparedStatement.setString(3,beneficiary.getBeneficiaryAddress());
    preparedStatement.setString(4,beneficiary.getBeneficiaryCity());
    preparedStatement.setString(5,beneficiary.getBeneficiaryState());
    preparedStatement.setString(6,beneficiary.getBeneficiaryCountry());
    preparedStatement.setString(7,beneficiary.getBeneficiaryZipCode());
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

public void updateBeneficiary(Beneficiary beneficiary)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,beneficiary.getBeneficiaryName());
    preparedStatement.setString(2,beneficiary.getBeneficiaryAddress());
    preparedStatement.setString(3,beneficiary.getBeneficiaryCity());
    preparedStatement.setString(4,beneficiary.getBeneficiaryState());
    preparedStatement.setString(5,beneficiary.getBeneficiaryCountry());
    preparedStatement.setString(6,beneficiary.getBeneficiaryZipCode());
    preparedStatement.setInt(7, beneficiary.getBeneficiaryId());
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

public List<Beneficiary> getBeneficiarys( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Beneficiary> beneficiaryList = new ArrayList<Beneficiary>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("BENEFICIARYID");
      String beneficiaryname = resultSet.getString("BENEFICIARYNAME");
      String beneficiaryaddress = resultSet.getString("BENEFICIARYADDRESS");
      String beneficiarycity = resultSet.getString("BENEFICIARYCITY");
      String beneficiarystate = resultSet.getString("BENEFICIARYSTATE");
      String beneficiarycountry = resultSet.getString("BENEFICIARYCOUNTRY");
      String beneficiaryzipcode = resultSet.getString("BENEFICIARYZIPCODE");
      Beneficiary beneficiary = new Beneficiary();
      beneficiary.setBeneficiaryId(id);
      beneficiary.setBeneficiaryName(beneficiaryname);
      beneficiary.setBeneficiaryAddress(beneficiaryaddress);
      beneficiary.setBeneficiaryCity(beneficiarycity);
      beneficiary.setBeneficiaryState(beneficiarystate);
      beneficiary.setBeneficiaryCountry(beneficiarycountry);
      beneficiary.setBeneficiaryZipCode(beneficiaryzipcode);
       beneficiaryList.add(beneficiary);
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
  return beneficiaryList;
 }

public static void main( String[] args ) {
}

} 

