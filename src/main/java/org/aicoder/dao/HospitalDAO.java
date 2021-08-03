package org.aicoder.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Hospital;
import org.archcorner.chartreuse.util.JDBCManager;

public class HospitalDAO{ 


private String highestIDSQL = "SELECT MAX(HOSPITALID) AS MAXHOSPITALID FROM HOSPITAL";
private String selectSQL = "SELECT * FROM HOSPITAL WHERE HOSPITALNAME=?";
private String selectIdSQL = "SELECT * FROM HOSPITAL WHERE HOSPITALID=?";
private String insertSQL = "INSERT INTO HOSPITAL(HOSPITALID,HOSPITALNAME,HOSPITALADDRESS,HOSPITALCITY,HOSPITALSTATE,HOSPITALCOUNTRY,HOSPITALZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE HOSPITAL SET HOSPITALNAME=?,HOSPITALADDRESS=?,HOSPITALCITY=?,HOSPITALSTATE=?,HOSPITALCOUNTRY=?,HOSPITALZIPCODE=? WHERE HOSPITALID=?";
private String deleteSQL = "DELETE FROM HOSPITAL WHERE HOSPITALID=?";
private String selectAllSQL = "SELECT * FROM HOSPITAL";

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
    highestId = resultSet.getInt("MAXHOSPITALID");
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

public Hospital getHospitalById(int hospitalid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Hospital hospital = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, hospitalid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("hospitalid");
      String hospitalname = resultSet.getString("HOSPITALNAME");
      String hospitaladdress = resultSet.getString("HOSPITALADDRESS");
      String hospitalcity = resultSet.getString("HOSPITALCITY");
      String hospitalstate = resultSet.getString("HOSPITALSTATE");
      String hospitalcountry = resultSet.getString("HOSPITALCOUNTRY");
      String hospitalzipcode = resultSet.getString("HOSPITALZIPCODE");
      hospital = new Hospital();
      hospital.setHospitalId(id);
      hospital.setHospitalName(hospitalname);
      hospital.setHospitalAddress(hospitaladdress);
      hospital.setHospitalCity(hospitalcity);
      hospital.setHospitalState(hospitalstate);
      hospital.setHospitalCountry(hospitalcountry);
      hospital.setHospitalZipCode(hospitalzipcode);
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
  return hospital;
 }

public Hospital getHospital(String hospitalname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Hospital hospital = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, hospitalname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("HospitalId");
      hospitalname = resultSet.getString("HOSPITALNAME");
      String hospitaladdress = resultSet.getString("HOSPITALADDRESS");
      String hospitalcity = resultSet.getString("HOSPITALCITY");
      String hospitalstate = resultSet.getString("HOSPITALSTATE");
      String hospitalcountry = resultSet.getString("HOSPITALCOUNTRY");
      String hospitalzipcode = resultSet.getString("HOSPITALZIPCODE");
      hospital = new Hospital();
      hospital.setHospitalId(id);
      hospital.setHospitalName(hospitalname);
      hospital.setHospitalAddress(hospitaladdress);
      hospital.setHospitalCity(hospitalcity);
      hospital.setHospitalState(hospitalstate);
      hospital.setHospitalCountry(hospitalcountry);
      hospital.setHospitalZipCode(hospitalzipcode);
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
  return hospital;
 }

public void deleteHospital(Hospital hospital)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, hospital.getHospitalId());
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

public void insertHospital(Hospital hospital)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,hospital.getHospitalName());
    preparedStatement.setString(3,hospital.getHospitalAddress());
    preparedStatement.setString(4,hospital.getHospitalCity());
    preparedStatement.setString(5,hospital.getHospitalState());
    preparedStatement.setString(6,hospital.getHospitalCountry());
    preparedStatement.setString(7,hospital.getHospitalZipCode());
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

public void updateHospital(Hospital hospital)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,hospital.getHospitalName());
    preparedStatement.setString(2,hospital.getHospitalAddress());
    preparedStatement.setString(3,hospital.getHospitalCity());
    preparedStatement.setString(4,hospital.getHospitalState());
    preparedStatement.setString(5,hospital.getHospitalCountry());
    preparedStatement.setString(6,hospital.getHospitalZipCode());
    preparedStatement.setInt(7, hospital.getHospitalId());
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

public List<Hospital> getHospitals( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Hospital> hospitalList = new ArrayList<Hospital>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("HOSPITALID");
      String hospitalname = resultSet.getString("HOSPITALNAME");
      String hospitaladdress = resultSet.getString("HOSPITALADDRESS");
      String hospitalcity = resultSet.getString("HOSPITALCITY");
      String hospitalstate = resultSet.getString("HOSPITALSTATE");
      String hospitalcountry = resultSet.getString("HOSPITALCOUNTRY");
      String hospitalzipcode = resultSet.getString("HOSPITALZIPCODE");
      Hospital hospital = new Hospital();
      hospital.setHospitalId(id);
      hospital.setHospitalName(hospitalname);
      hospital.setHospitalAddress(hospitaladdress);
      hospital.setHospitalCity(hospitalcity);
      hospital.setHospitalState(hospitalstate);
      hospital.setHospitalCountry(hospitalcountry);
      hospital.setHospitalZipCode(hospitalzipcode);
       hospitalList.add(hospital);
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
  return hospitalList;
 }

public static void main( String[] args ) {
}

} 

