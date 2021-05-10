import java.util.List;
import org.archcorner.chartreuse.dal.dao.AppartmentSecurityDAO;
import org.archcorner.chartreuse.pojo.AppartmentSecurity;

public class AppartmentSecurityBusinessDelegate{ 


private AppartmentSecurityDAO appartmentsecurityDAO ;

public int getHighestId()
 {
  appartmentsecurityDAO = new AppartmentSecurityDAO();
   int id=appartmentsecurityDAO.getHighestId();
   return id;
 } 

public void insertAppartmentSecurity(AppartmentSecurity appartmentsecurity)
 {
  appartmentsecurityDAO = new AppartmentSecurityDAO();
  appartmentsecurityDAO.insertAppartmentSecurity(appartmentsecurity);
 } 

public void updateAppartmentSecurity(AppartmentSecurity appartmentsecurity)
 {
  appartmentsecurityDAO = new AppartmentSecurityDAO();
  appartmentsecurityDAO.updateAppartmentSecurity(appartmentsecurity);
 } 

public void deleteAppartmentSecurity(AppartmentSecurity appartmentsecurity)
 {
  appartmentsecurityDAO = new AppartmentSecurityDAO();
  appartmentsecurityDAO.deleteAppartmentSecurity(appartmentsecurity);
 } 

public AppartmentSecurity  getAppartmentSecurityById(int appartmentsecurityId)
 {
  appartmentsecurityDAO = new AppartmentSecurityDAO();
  AppartmentSecurity appartmentsecurity= appartmentsecurityDAO.getAppartmentSecurityById(appartmentsecurityId);
 return appartmentsecurity;
 } 

public AppartmentSecurity  getAppartmentSecurity(String appartmentsecurityName)
 {
  appartmentsecurityDAO = new AppartmentSecurityDAO();
  AppartmentSecurity appartmentsecurity= appartmentsecurityDAO.getAppartmentSecurity(appartmentsecurityName);
 return appartmentsecurity;
 } 

public List<AppartmentSecurity>  getAll( )
 {
  appartmentsecurityDAO = new AppartmentSecurityDAO();
   List<AppartmentSecurity>  appartmentsecuritys = appartmentsecurityDAO.getAppartmentSecuritys( );
 return appartmentsecuritys;
 } 

} 

