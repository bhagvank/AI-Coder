import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Patient;
import org.archcorner.chartreuse.util.JDBCManager;

public class PatientDAO{ 


private String highestIDSQL = "SELECT MAX(PATIENTID) AS MAXPATIENTID FROM PATIENT";
private String selectSQL = "SELECT * FROM PATIENT WHERE PATIENTNAME=?";
private String selectIdSQL = "SELECT * FROM PATIENT WHERE PATIENTID=?";
private String insertSQL = "INSERT INTO PATIENT(PATIENTID,PATIENTNAME,PATIENTADDRESS,PATIENTCITY,PATIENTSTATE,PATIENTCOUNTRY,PATIENTZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE PATIENT SET PATIENTNAME=?,PATIENTADDRESS=?,PATIENTCITY=?,PATIENTSTATE=?,PATIENTCOUNTRY=?,PATIENTZIPCODE=? WHERE PATIENTID=?";
private String deleteSQL = "DELETE FROM PATIENT WHERE PATIENTID=?";
private String selectAllSQL = "SELECT * FROM PATIENT";

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
    highestId = resultSet.getInt("MAXPATIENTID");
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

public Patient getPatientById(int patientid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Patient patient = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, patientid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("patientid");
      String patientname = resultSet.getString("PATIENTNAME");
      String patientaddress = resultSet.getString("PATIENTADDRESS");
      String patientcity = resultSet.getString("PATIENTCITY");
      String patientstate = resultSet.getString("PATIENTSTATE");
      String patientcountry = resultSet.getString("PATIENTCOUNTRY");
      String patientzipcode = resultSet.getString("PATIENTZIPCODE");
      patient = new Patient();
      patient.setPatientId(id);
      patient.setPatientName(patientname);
      patient.setPatientAddress(patientaddress);
      patient.setPatientCity(patientcity);
      patient.setPatientState(patientstate);
      patient.setPatientCountry(patientcountry);
      patient.setPatientZipCode(patientzipcode);
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
  return patient;
 }

public Patient getPatient(String patientname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Patient patient = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, patientname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("PatientId");
      patientname = resultSet.getString("PATIENTNAME");
      String patientaddress = resultSet.getString("PATIENTADDRESS");
      String patientcity = resultSet.getString("PATIENTCITY");
      String patientstate = resultSet.getString("PATIENTSTATE");
      String patientcountry = resultSet.getString("PATIENTCOUNTRY");
      String patientzipcode = resultSet.getString("PATIENTZIPCODE");
      patient = new Patient();
      patient.setPatientId(id);
      patient.setPatientName(patientname);
      patient.setPatientAddress(patientaddress);
      patient.setPatientCity(patientcity);
      patient.setPatientState(patientstate);
      patient.setPatientCountry(patientcountry);
      patient.setPatientZipCode(patientzipcode);
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
  return patient;
 }

public void deletePatient(Patient patient)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, patient.getPatientId());
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

public void insertPatient(Patient patient)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,patient.getPatientName());
    preparedStatement.setString(3,patient.getPatientAddress());
    preparedStatement.setString(4,patient.getPatientCity());
    preparedStatement.setString(5,patient.getPatientState());
    preparedStatement.setString(6,patient.getPatientCountry());
    preparedStatement.setString(7,patient.getPatientZipCode());
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

public void updatePatient(Patient patient)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,patient.getPatientName());
    preparedStatement.setString(2,patient.getPatientAddress());
    preparedStatement.setString(3,patient.getPatientCity());
    preparedStatement.setString(4,patient.getPatientState());
    preparedStatement.setString(5,patient.getPatientCountry());
    preparedStatement.setString(6,patient.getPatientZipCode());
    preparedStatement.setInt(7, patient.getPatientId());
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

public List<Patient> getPatients( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Patient> patientList = new ArrayList<Patient>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("PATIENTID");
      String patientname = resultSet.getString("PATIENTNAME");
      String patientaddress = resultSet.getString("PATIENTADDRESS");
      String patientcity = resultSet.getString("PATIENTCITY");
      String patientstate = resultSet.getString("PATIENTSTATE");
      String patientcountry = resultSet.getString("PATIENTCOUNTRY");
      String patientzipcode = resultSet.getString("PATIENTZIPCODE");
      Patient patient = new Patient();
      patient.setPatientId(id);
      patient.setPatientName(patientname);
      patient.setPatientAddress(patientaddress);
      patient.setPatientCity(patientcity);
      patient.setPatientState(patientstate);
      patient.setPatientCountry(patientcountry);
      patient.setPatientZipCode(patientzipcode);
       patientList.add(patient);
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
  return patientList;
 }

public static void main( String[] args ) {
}

} 

