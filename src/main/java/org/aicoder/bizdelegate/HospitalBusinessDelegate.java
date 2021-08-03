package org.aicoder.bizdelegate;
import java.util.List;
import org.archcorner.chartreuse.dal.dao.HospitalDAO;
import org.archcorner.chartreuse.pojo.Hospital;

public class HospitalBusinessDelegate{ 


private HospitalDAO hospitalDAO ;

public int getHighestId()
 {
  hospitalDAO = new HospitalDAO();
   int id=hospitalDAO.getHighestId();
   return id;
 } 

public void insertHospital(Hospital hospital)
 {
  hospitalDAO = new HospitalDAO();
  hospitalDAO.insertHospital(hospital);
 } 

public void updateHospital(Hospital hospital)
 {
  hospitalDAO = new HospitalDAO();
  hospitalDAO.updateHospital(hospital);
 } 

public void deleteHospital(Hospital hospital)
 {
  hospitalDAO = new HospitalDAO();
  hospitalDAO.deleteHospital(hospital);
 } 

public Hospital  getHospitalById(int hospitalId)
 {
  hospitalDAO = new HospitalDAO();
  Hospital hospital= hospitalDAO.getHospitalById(hospitalId);
 return hospital;
 } 

public Hospital  getHospital(String hospitalName)
 {
  hospitalDAO = new HospitalDAO();
  Hospital hospital= hospitalDAO.getHospital(hospitalName);
 return hospital;
 } 

public List<Hospital>  getAll( )
 {
  hospitalDAO = new HospitalDAO();
   List<Hospital>  hospitals = hospitalDAO.getHospitals( );
 return hospitals;
 } 

} 

