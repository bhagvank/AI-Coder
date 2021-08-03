package org.aicoder.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Club;
import org.archcorner.chartreuse.util.JDBCManager;

public class ClubDAO{ 


private String highestIDSQL = "SELECT MAX(CLUBID) AS MAXCLUBID FROM CLUB";
private String selectSQL = "SELECT * FROM CLUB WHERE CLUBNAME=?";
private String selectIdSQL = "SELECT * FROM CLUB WHERE CLUBID=?";
private String insertSQL = "INSERT INTO CLUB(CLUBID,CLUBNAME,CLUBADDRESS,CLUBCITY,CLUBSTATE,CLUBCOUNTRY,CLUBZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE CLUB SET CLUBNAME=?,CLUBADDRESS=?,CLUBCITY=?,CLUBSTATE=?,CLUBCOUNTRY=?,CLUBZIPCODE=? WHERE CLUBID=?";
private String deleteSQL = "DELETE FROM CLUB WHERE CLUBID=?";
private String selectAllSQL = "SELECT * FROM CLUB";

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
    highestId = resultSet.getInt("MAXCLUBID");
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

public Club getClubById(int clubid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Club club = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, clubid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("clubid");
      String clubname = resultSet.getString("CLUBNAME");
      String clubaddress = resultSet.getString("CLUBADDRESS");
      String clubcity = resultSet.getString("CLUBCITY");
      String clubstate = resultSet.getString("CLUBSTATE");
      String clubcountry = resultSet.getString("CLUBCOUNTRY");
      String clubzipcode = resultSet.getString("CLUBZIPCODE");
      club = new Club();
      club.setClubId(id);
      club.setClubName(clubname);
      club.setClubAddress(clubaddress);
      club.setClubCity(clubcity);
      club.setClubState(clubstate);
      club.setClubCountry(clubcountry);
      club.setClubZipCode(clubzipcode);
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
  return club;
 }

public Club getClub(String clubname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Club club = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, clubname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("ClubId");
      clubname = resultSet.getString("CLUBNAME");
      String clubaddress = resultSet.getString("CLUBADDRESS");
      String clubcity = resultSet.getString("CLUBCITY");
      String clubstate = resultSet.getString("CLUBSTATE");
      String clubcountry = resultSet.getString("CLUBCOUNTRY");
      String clubzipcode = resultSet.getString("CLUBZIPCODE");
      club = new Club();
      club.setClubId(id);
      club.setClubName(clubname);
      club.setClubAddress(clubaddress);
      club.setClubCity(clubcity);
      club.setClubState(clubstate);
      club.setClubCountry(clubcountry);
      club.setClubZipCode(clubzipcode);
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
  return club;
 }

public void deleteClub(Club club)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, club.getClubId());
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

public void insertClub(Club club)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,club.getClubName());
    preparedStatement.setString(3,club.getClubAddress());
    preparedStatement.setString(4,club.getClubCity());
    preparedStatement.setString(5,club.getClubState());
    preparedStatement.setString(6,club.getClubCountry());
    preparedStatement.setString(7,club.getClubZipCode());
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

public void updateClub(Club club)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,club.getClubName());
    preparedStatement.setString(2,club.getClubAddress());
    preparedStatement.setString(3,club.getClubCity());
    preparedStatement.setString(4,club.getClubState());
    preparedStatement.setString(5,club.getClubCountry());
    preparedStatement.setString(6,club.getClubZipCode());
    preparedStatement.setInt(7, club.getClubId());
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

public List<Club> getClubs( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Club> clubList = new ArrayList<Club>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("CLUBID");
      String clubname = resultSet.getString("CLUBNAME");
      String clubaddress = resultSet.getString("CLUBADDRESS");
      String clubcity = resultSet.getString("CLUBCITY");
      String clubstate = resultSet.getString("CLUBSTATE");
      String clubcountry = resultSet.getString("CLUBCOUNTRY");
      String clubzipcode = resultSet.getString("CLUBZIPCODE");
      Club club = new Club();
      club.setClubId(id);
      club.setClubName(clubname);
      club.setClubAddress(clubaddress);
      club.setClubCity(clubcity);
      club.setClubState(clubstate);
      club.setClubCountry(clubcountry);
      club.setClubZipCode(clubzipcode);
       clubList.add(club);
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
  return clubList;
 }

public static void main( String[] args ) {
}

} 

