import java.util.List;
import org.archcorner.chartreuse.dal.dao.PractitionerDAO;
import org.archcorner.chartreuse.pojo.Practitioner;

public class PractitionerBusinessDelegate{ 


private PractitionerDAO practitionerDAO ;

public int getHighestId()
 {
  practitionerDAO = new PractitionerDAO();
   int id=practitionerDAO.getHighestId();
   return id;
 } 

public void insertPractitioner(Practitioner practitioner)
 {
  practitionerDAO = new PractitionerDAO();
  practitionerDAO.insertPractitioner(practitioner);
 } 

public void updatePractitioner(Practitioner practitioner)
 {
  practitionerDAO = new PractitionerDAO();
  practitionerDAO.updatePractitioner(practitioner);
 } 

public void deletePractitioner(Practitioner practitioner)
 {
  practitionerDAO = new PractitionerDAO();
  practitionerDAO.deletePractitioner(practitioner);
 } 

public Practitioner  getPractitionerById(int practitionerId)
 {
  practitionerDAO = new PractitionerDAO();
  Practitioner practitioner= practitionerDAO.getPractitionerById(practitionerId);
 return practitioner;
 } 

public Practitioner  getPractitioner(String practitionerName)
 {
  practitionerDAO = new PractitionerDAO();
  Practitioner practitioner= practitionerDAO.getPractitioner(practitionerName);
 return practitioner;
 } 

public List<Practitioner>  getAll( )
 {
  practitionerDAO = new PractitionerDAO();
   List<Practitioner>  practitioners = practitionerDAO.getPractitioners( );
 return practitioners;
 } 

} 

