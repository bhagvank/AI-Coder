import java.util.List;
import org.archcorner.chartreuse.dal.dao.ClinicDAO;
import org.archcorner.chartreuse.pojo.Clinic;

public class ClinicBusinessDelegate{ 


private ClinicDAO clinicDAO ;

public int getHighestId()
 {
  clinicDAO = new ClinicDAO();
   int id=clinicDAO.getHighestId();
   return id;
 } 

public void insertClinic(Clinic clinic)
 {
  clinicDAO = new ClinicDAO();
  clinicDAO.insertClinic(clinic);
 } 

public void updateClinic(Clinic clinic)
 {
  clinicDAO = new ClinicDAO();
  clinicDAO.updateClinic(clinic);
 } 

public void deleteClinic(Clinic clinic)
 {
  clinicDAO = new ClinicDAO();
  clinicDAO.deleteClinic(clinic);
 } 

public Clinic  getClinicById(int clinicId)
 {
  clinicDAO = new ClinicDAO();
  Clinic clinic= clinicDAO.getClinicById(clinicId);
 return clinic;
 } 

public Clinic  getClinic(String clinicName)
 {
  clinicDAO = new ClinicDAO();
  Clinic clinic= clinicDAO.getClinic(clinicName);
 return clinic;
 } 

public List<Clinic>  getAll( )
 {
  clinicDAO = new ClinicDAO();
   List<Clinic>  clinics = clinicDAO.getClinics( );
 return clinics;
 } 

} 

