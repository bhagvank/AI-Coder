import java.util.List;
import org.archcorner.chartreuse.dal.dao.PatientDAO;
import org.archcorner.chartreuse.pojo.Patient;

public class PatientBusinessDelegate{ 


private PatientDAO patientDAO ;

public int getHighestId()
 {
  patientDAO = new PatientDAO();
   int id=patientDAO.getHighestId();
   return id;
 } 

public void insertPatient(Patient patient)
 {
  patientDAO = new PatientDAO();
  patientDAO.insertPatient(patient);
 } 

public void updatePatient(Patient patient)
 {
  patientDAO = new PatientDAO();
  patientDAO.updatePatient(patient);
 } 

public void deletePatient(Patient patient)
 {
  patientDAO = new PatientDAO();
  patientDAO.deletePatient(patient);
 } 

public Patient  getPatientById(int patientId)
 {
  patientDAO = new PatientDAO();
  Patient patient= patientDAO.getPatientById(patientId);
 return patient;
 } 

public Patient  getPatient(String patientName)
 {
  patientDAO = new PatientDAO();
  Patient patient= patientDAO.getPatient(patientName);
 return patient;
 } 

public List<Patient>  getAll( )
 {
  patientDAO = new PatientDAO();
   List<Patient>  patients = patientDAO.getPatients( );
 return patients;
 } 

} 

