import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Estate;
import org.archcorner.chartreuse.util.JDBCManager;

public class EstateDAO{ 


private String highestIDSQL = "SELECT MAX(ESTATEID) AS MAXESTATEID FROM ESTATE";
private String selectSQL = "SELECT * FROM ESTATE WHERE ESTATENAME=?";
private String selectIdSQL = "SELECT * FROM ESTATE WHERE ESTATEID=?";
private String insertSQL = "INSERT INTO ESTATE(ESTATEID,ESTATENAME,ESTATEADDRESS,ESTATECITY,ESTATESTATE,ESTATECOUNTRY,ESTATEZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE ESTATE SET ESTATENAME=?,ESTATEADDRESS=?,ESTATECITY=?,ESTATESTATE=?,ESTATECOUNTRY=?,ESTATEZIPCODE=? WHERE ESTATEID=?";
private String deleteSQL = "DELETE FROM ESTATE WHERE ESTATEID=?";
private String selectAllSQL = "SELECT * FROM ESTATE";

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
    highestId = resultSet.getInt("MAXESTATEID");
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

public Estate getEstateById(int estateid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Estate estate = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, estateid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("estateid");
      String estatename = resultSet.getString("ESTATENAME");
      String estateaddress = resultSet.getString("ESTATEADDRESS");
      String estatecity = resultSet.getString("ESTATECITY");
      String estatestate = resultSet.getString("ESTATESTATE");
      String estatecountry = resultSet.getString("ESTATECOUNTRY");
      String estatezipcode = resultSet.getString("ESTATEZIPCODE");
      estate = new Estate();
      estate.setEstateId(id);
      estate.setEstateName(estatename);
      estate.setEstateAddress(estateaddress);
      estate.setEstateCity(estatecity);
      estate.setEstateState(estatestate);
      estate.setEstateCountry(estatecountry);
      estate.setEstateZipCode(estatezipcode);
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
  return estate;
 }

public Estate getEstate(String estatename)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Estate estate = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, estatename);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("EstateId");
      estatename = resultSet.getString("ESTATENAME");
      String estateaddress = resultSet.getString("ESTATEADDRESS");
      String estatecity = resultSet.getString("ESTATECITY");
      String estatestate = resultSet.getString("ESTATESTATE");
      String estatecountry = resultSet.getString("ESTATECOUNTRY");
      String estatezipcode = resultSet.getString("ESTATEZIPCODE");
      estate = new Estate();
      estate.setEstateId(id);
      estate.setEstateName(estatename);
      estate.setEstateAddress(estateaddress);
      estate.setEstateCity(estatecity);
      estate.setEstateState(estatestate);
      estate.setEstateCountry(estatecountry);
      estate.setEstateZipCode(estatezipcode);
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
  return estate;
 }

public void deleteEstate(Estate estate)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, estate.getEstateId());
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

public void insertEstate(Estate estate)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,estate.getEstateName());
    preparedStatement.setString(3,estate.getEstateAddress());
    preparedStatement.setString(4,estate.getEstateCity());
    preparedStatement.setString(5,estate.getEstateState());
    preparedStatement.setString(6,estate.getEstateCountry());
    preparedStatement.setString(7,estate.getEstateZipCode());
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

public void updateEstate(Estate estate)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,estate.getEstateName());
    preparedStatement.setString(2,estate.getEstateAddress());
    preparedStatement.setString(3,estate.getEstateCity());
    preparedStatement.setString(4,estate.getEstateState());
    preparedStatement.setString(5,estate.getEstateCountry());
    preparedStatement.setString(6,estate.getEstateZipCode());
    preparedStatement.setInt(7, estate.getEstateId());
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

public List<Estate> getEstates( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Estate> estateList = new ArrayList<Estate>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("ESTATEID");
      String estatename = resultSet.getString("ESTATENAME");
      String estateaddress = resultSet.getString("ESTATEADDRESS");
      String estatecity = resultSet.getString("ESTATECITY");
      String estatestate = resultSet.getString("ESTATESTATE");
      String estatecountry = resultSet.getString("ESTATECOUNTRY");
      String estatezipcode = resultSet.getString("ESTATEZIPCODE");
      Estate estate = new Estate();
      estate.setEstateId(id);
      estate.setEstateName(estatename);
      estate.setEstateAddress(estateaddress);
      estate.setEstateCity(estatecity);
      estate.setEstateState(estatestate);
      estate.setEstateCountry(estatecountry);
      estate.setEstateZipCode(estatezipcode);
       estateList.add(estate);
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
  return estateList;
 }

public static void main( String[] args ) {
}

} 

