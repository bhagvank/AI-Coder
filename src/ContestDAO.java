import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Contest;
import org.archcorner.chartreuse.util.JDBCManager;

public class ContestDAO{ 


private String highestIDSQL = "SELECT MAX(CONTESTID) AS MAXCONTESTID FROM CONTEST";
private String selectSQL = "SELECT * FROM CONTEST WHERE CONTESTNAME=?";
private String selectIdSQL = "SELECT * FROM CONTEST WHERE CONTESTID=?";
private String insertSQL = "INSERT INTO CONTEST(CONTESTID,CONTESTNAME,CONTESTADDRESS,CONTESTCITY,CONTESTSTATE,CONTESTCOUNTRY,CONTESTZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE CONTEST SET CONTESTNAME=?,CONTESTADDRESS=?,CONTESTCITY=?,CONTESTSTATE=?,CONTESTCOUNTRY=?,CONTESTZIPCODE=? WHERE CONTESTID=?";
private String deleteSQL = "DELETE FROM CONTEST WHERE CONTESTID=?";
private String selectAllSQL = "SELECT * FROM CONTEST";

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
    highestId = resultSet.getInt("MAXCONTESTID");
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

public Contest getContestById(int contestid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Contest contest = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, contestid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("contestid");
      String contestname = resultSet.getString("CONTESTNAME");
      String contestaddress = resultSet.getString("CONTESTADDRESS");
      String contestcity = resultSet.getString("CONTESTCITY");
      String conteststate = resultSet.getString("CONTESTSTATE");
      String contestcountry = resultSet.getString("CONTESTCOUNTRY");
      String contestzipcode = resultSet.getString("CONTESTZIPCODE");
      contest = new Contest();
      contest.setContestId(id);
      contest.setContestName(contestname);
      contest.setContestAddress(contestaddress);
      contest.setContestCity(contestcity);
      contest.setContestState(conteststate);
      contest.setContestCountry(contestcountry);
      contest.setContestZipCode(contestzipcode);
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
  return contest;
 }

public Contest getContest(String contestname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Contest contest = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, contestname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("ContestId");
      contestname = resultSet.getString("CONTESTNAME");
      String contestaddress = resultSet.getString("CONTESTADDRESS");
      String contestcity = resultSet.getString("CONTESTCITY");
      String conteststate = resultSet.getString("CONTESTSTATE");
      String contestcountry = resultSet.getString("CONTESTCOUNTRY");
      String contestzipcode = resultSet.getString("CONTESTZIPCODE");
      contest = new Contest();
      contest.setContestId(id);
      contest.setContestName(contestname);
      contest.setContestAddress(contestaddress);
      contest.setContestCity(contestcity);
      contest.setContestState(conteststate);
      contest.setContestCountry(contestcountry);
      contest.setContestZipCode(contestzipcode);
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
  return contest;
 }

public void deleteContest(Contest contest)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, contest.getContestId());
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

public void insertContest(Contest contest)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,contest.getContestName());
    preparedStatement.setString(3,contest.getContestAddress());
    preparedStatement.setString(4,contest.getContestCity());
    preparedStatement.setString(5,contest.getContestState());
    preparedStatement.setString(6,contest.getContestCountry());
    preparedStatement.setString(7,contest.getContestZipCode());
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

public void updateContest(Contest contest)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,contest.getContestName());
    preparedStatement.setString(2,contest.getContestAddress());
    preparedStatement.setString(3,contest.getContestCity());
    preparedStatement.setString(4,contest.getContestState());
    preparedStatement.setString(5,contest.getContestCountry());
    preparedStatement.setString(6,contest.getContestZipCode());
    preparedStatement.setInt(7, contest.getContestId());
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

public List<Contest> getContests( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Contest> contestList = new ArrayList<Contest>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("CONTESTID");
      String contestname = resultSet.getString("CONTESTNAME");
      String contestaddress = resultSet.getString("CONTESTADDRESS");
      String contestcity = resultSet.getString("CONTESTCITY");
      String conteststate = resultSet.getString("CONTESTSTATE");
      String contestcountry = resultSet.getString("CONTESTCOUNTRY");
      String contestzipcode = resultSet.getString("CONTESTZIPCODE");
      Contest contest = new Contest();
      contest.setContestId(id);
      contest.setContestName(contestname);
      contest.setContestAddress(contestaddress);
      contest.setContestCity(contestcity);
      contest.setContestState(conteststate);
      contest.setContestCountry(contestcountry);
      contest.setContestZipCode(contestzipcode);
       contestList.add(contest);
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
  return contestList;
 }

public static void main( String[] args ) {
}

} 

