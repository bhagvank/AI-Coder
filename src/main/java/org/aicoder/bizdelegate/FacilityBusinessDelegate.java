package org.aicoder.bizdelegate;
import java.util.List;
import org.archcorner.chartreuse.dal.dao.FacilityDAO;
import org.archcorner.chartreuse.pojo.Facility;

public class FacilityBusinessDelegate{ 


private FacilityDAO facilityDAO ;

public int getHighestId()
 {
  facilityDAO = new FacilityDAO();
   int id=facilityDAO.getHighestId();
   return id;
 } 

public void insertFacility(Facility facility)
 {
  facilityDAO = new FacilityDAO();
  facilityDAO.insertFacility(facility);
 } 

public void updateFacility(Facility facility)
 {
  facilityDAO = new FacilityDAO();
  facilityDAO.updateFacility(facility);
 } 

public void deleteFacility(Facility facility)
 {
  facilityDAO = new FacilityDAO();
  facilityDAO.deleteFacility(facility);
 } 

public Facility  getFacilityById(int facilityId)
 {
  facilityDAO = new FacilityDAO();
  Facility facility= facilityDAO.getFacilityById(facilityId);
 return facility;
 } 

public Facility  getFacility(String facilityName)
 {
  facilityDAO = new FacilityDAO();
  Facility facility= facilityDAO.getFacility(facilityName);
 return facility;
 } 

public List<Facility>  getAll( )
 {
  facilityDAO = new FacilityDAO();
   List<Facility>  facilitys = facilityDAO.getFacilitys( );
 return facilitys;
 } 

} 

