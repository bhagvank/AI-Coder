import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Clinic;
import org.archcorner.chartreuse.util.JDBCManager;

public class ClinicDAO{ 


private String highestIDSQL = "SELECT MAX(CLINICID) AS MAXCLINICID FROM CLINIC";
private String selectSQL = "SELECT * FROM CLINIC WHERE CLINICNAME=?";
private String selectIdSQL = "SELECT * FROM CLINIC WHERE CLINICID=?";
private String insertSQL = "INSERT INTO CLINIC(CLINICID,CLINICNAME,CLINICADDRESS,CLINICCITY,CLINICSTATE,CLINICCOUNTRY,CLINICZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE CLINIC SET CLINICNAME=?,CLINICADDRESS=?,CLINICCITY=?,CLINICSTATE=?,CLINICCOUNTRY=?,CLINICZIPCODE=? WHERE CLINICID=?";
private String deleteSQL = "DELETE FROM CLINIC WHERE CLINICID=?";
private String selectAllSQL = "SELECT * FROM CLINIC";

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
    highestId = resultSet.getInt("MAXCLINICID");
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

public Clinic getClinicById(int clinicid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Clinic clinic = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, clinicid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("clinicid");
      String clinicname = resultSet.getString("CLINICNAME");
      String clinicaddress = resultSet.getString("CLINICADDRESS");
      String cliniccity = resultSet.getString("CLINICCITY");
      String clinicstate = resultSet.getString("CLINICSTATE");
      String cliniccountry = resultSet.getString("CLINICCOUNTRY");
      String cliniczipcode = resultSet.getString("CLINICZIPCODE");
      clinic = new Clinic();
      clinic.setClinicId(id);
      clinic.setClinicName(clinicname);
      clinic.setClinicAddress(clinicaddress);
      clinic.setClinicCity(cliniccity);
      clinic.setClinicState(clinicstate);
      clinic.setClinicCountry(cliniccountry);
      clinic.setClinicZipCode(cliniczipcode);
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
  return clinic;
 }

public Clinic getClinic(String clinicname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Clinic clinic = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, clinicname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("ClinicId");
      clinicname = resultSet.getString("CLINICNAME");
      String clinicaddress = resultSet.getString("CLINICADDRESS");
      String cliniccity = resultSet.getString("CLINICCITY");
      String clinicstate = resultSet.getString("CLINICSTATE");
      String cliniccountry = resultSet.getString("CLINICCOUNTRY");
      String cliniczipcode = resultSet.getString("CLINICZIPCODE");
      clinic = new Clinic();
      clinic.setClinicId(id);
      clinic.setClinicName(clinicname);
      clinic.setClinicAddress(clinicaddress);
      clinic.setClinicCity(cliniccity);
      clinic.setClinicState(clinicstate);
      clinic.setClinicCountry(cliniccountry);
      clinic.setClinicZipCode(cliniczipcode);
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
  return clinic;
 }

public void deleteClinic(Clinic clinic)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, clinic.getClinicId());
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

public void insertClinic(Clinic clinic)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,clinic.getClinicName());
    preparedStatement.setString(3,clinic.getClinicAddress());
    preparedStatement.setString(4,clinic.getClinicCity());
    preparedStatement.setString(5,clinic.getClinicState());
    preparedStatement.setString(6,clinic.getClinicCountry());
    preparedStatement.setString(7,clinic.getClinicZipCode());
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

public void updateClinic(Clinic clinic)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,clinic.getClinicName());
    preparedStatement.setString(2,clinic.getClinicAddress());
    preparedStatement.setString(3,clinic.getClinicCity());
    preparedStatement.setString(4,clinic.getClinicState());
    preparedStatement.setString(5,clinic.getClinicCountry());
    preparedStatement.setString(6,clinic.getClinicZipCode());
    preparedStatement.setInt(7, clinic.getClinicId());
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

public List<Clinic> getClinics( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Clinic> clinicList = new ArrayList<Clinic>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("CLINICID");
      String clinicname = resultSet.getString("CLINICNAME");
      String clinicaddress = resultSet.getString("CLINICADDRESS");
      String cliniccity = resultSet.getString("CLINICCITY");
      String clinicstate = resultSet.getString("CLINICSTATE");
      String cliniccountry = resultSet.getString("CLINICCOUNTRY");
      String cliniczipcode = resultSet.getString("CLINICZIPCODE");
      Clinic clinic = new Clinic();
      clinic.setClinicId(id);
      clinic.setClinicName(clinicname);
      clinic.setClinicAddress(clinicaddress);
      clinic.setClinicCity(cliniccity);
      clinic.setClinicState(clinicstate);
      clinic.setClinicCountry(cliniccountry);
      clinic.setClinicZipCode(cliniczipcode);
       clinicList.add(clinic);
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
  return clinicList;
 }

public static void main( String[] args ) {
}

} 

