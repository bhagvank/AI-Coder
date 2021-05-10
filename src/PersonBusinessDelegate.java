import java.util.List;
import org.archcorner.chartreuse.dal.dao.PersonDAO;
import org.archcorner.chartreuse.pojo.Person;

public class PersonBusinessDelegate{ 


private PersonDAO personDAO ;

public int getHighestId()
 {
  personDAO = new PersonDAO();
   int id=personDAO.getHighestId();
   return id;
 } 

public void insertPerson(Person person)
 {
  personDAO = new PersonDAO();
  personDAO.insertPerson(person);
 } 

public void updatePerson(Person person)
 {
  personDAO = new PersonDAO();
  personDAO.updatePerson(person);
 } 

public void deletePerson(Person person)
 {
  personDAO = new PersonDAO();
  personDAO.deletePerson(person);
 } 

public Person  getPersonById(int personId)
 {
  personDAO = new PersonDAO();
  Person person= personDAO.getPersonById(personId);
 return person;
 } 

public Person  getPerson(String personName)
 {
  personDAO = new PersonDAO();
  Person person= personDAO.getPerson(personName);
 return person;
 } 

public List<Person>  getAll( )
 {
  personDAO = new PersonDAO();
   List<Person>  persons = personDAO.getPersons( );
 return persons;
 } 

} 

