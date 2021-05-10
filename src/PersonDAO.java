import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Person;
import org.archcorner.chartreuse.util.JDBCManager;

public class PersonDAO{ 


private String highestIDSQL = "SELECT MAX(PERSONID) AS MAXPERSONID FROM PERSON";
private String selectSQL = "SELECT * FROM PERSON WHERE PERSONNAME=?";
private String selectIdSQL = "SELECT * FROM PERSON WHERE PERSONID=?";
private String insertSQL = "INSERT INTO PERSON(PERSONID,PERSONNAME,PERSONADDRESS,PERSONCITY,PERSONSTATE,PERSONCOUNTRY,PERSONZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE PERSON SET PERSONNAME=?,PERSONADDRESS=?,PERSONCITY=?,PERSONSTATE=?,PERSONCOUNTRY=?,PERSONZIPCODE=? WHERE PERSONID=?";
private String deleteSQL = "DELETE FROM PERSON WHERE PERSONID=?";
private String selectAllSQL = "SELECT * FROM PERSON";

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
    highestId = resultSet.getInt("MAXPERSONID");
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

public Person getPersonById(int personid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Person person = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, personid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("personid");
      String personname = resultSet.getString("PERSONNAME");
      String personaddress = resultSet.getString("PERSONADDRESS");
      String personcity = resultSet.getString("PERSONCITY");
      String personstate = resultSet.getString("PERSONSTATE");
      String personcountry = resultSet.getString("PERSONCOUNTRY");
      String personzipcode = resultSet.getString("PERSONZIPCODE");
      person = new Person();
      person.setPersonId(id);
      person.setPersonName(personname);
      person.setPersonAddress(personaddress);
      person.setPersonCity(personcity);
      person.setPersonState(personstate);
      person.setPersonCountry(personcountry);
      person.setPersonZipCode(personzipcode);
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
  return person;
 }

public Person getPerson(String personname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Person person = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, personname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("PersonId");
      personname = resultSet.getString("PERSONNAME");
      String personaddress = resultSet.getString("PERSONADDRESS");
      String personcity = resultSet.getString("PERSONCITY");
      String personstate = resultSet.getString("PERSONSTATE");
      String personcountry = resultSet.getString("PERSONCOUNTRY");
      String personzipcode = resultSet.getString("PERSONZIPCODE");
      person = new Person();
      person.setPersonId(id);
      person.setPersonName(personname);
      person.setPersonAddress(personaddress);
      person.setPersonCity(personcity);
      person.setPersonState(personstate);
      person.setPersonCountry(personcountry);
      person.setPersonZipCode(personzipcode);
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
  return person;
 }

public void deletePerson(Person person)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, person.getPersonId());
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

public void insertPerson(Person person)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,person.getPersonName());
    preparedStatement.setString(3,person.getPersonAddress());
    preparedStatement.setString(4,person.getPersonCity());
    preparedStatement.setString(5,person.getPersonState());
    preparedStatement.setString(6,person.getPersonCountry());
    preparedStatement.setString(7,person.getPersonZipCode());
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

public void updatePerson(Person person)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,person.getPersonName());
    preparedStatement.setString(2,person.getPersonAddress());
    preparedStatement.setString(3,person.getPersonCity());
    preparedStatement.setString(4,person.getPersonState());
    preparedStatement.setString(5,person.getPersonCountry());
    preparedStatement.setString(6,person.getPersonZipCode());
    preparedStatement.setInt(7, person.getPersonId());
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

public List<Person> getPersons( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Person> personList = new ArrayList<Person>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("PERSONID");
      String personname = resultSet.getString("PERSONNAME");
      String personaddress = resultSet.getString("PERSONADDRESS");
      String personcity = resultSet.getString("PERSONCITY");
      String personstate = resultSet.getString("PERSONSTATE");
      String personcountry = resultSet.getString("PERSONCOUNTRY");
      String personzipcode = resultSet.getString("PERSONZIPCODE");
      Person person = new Person();
      person.setPersonId(id);
      person.setPersonName(personname);
      person.setPersonAddress(personaddress);
      person.setPersonCity(personcity);
      person.setPersonState(personstate);
      person.setPersonCountry(personcountry);
      person.setPersonZipCode(personzipcode);
       personList.add(person);
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
  return personList;
 }

public static void main( String[] args ) {
}

} 

