package org.aicoder.bizdelegate;
import java.util.List;
import org.archcorner.chartreuse.dal.dao.AdministrationDAO;
import org.archcorner.chartreuse.pojo.Administration;

public class AdministrationBusinessDelegate{ 


private AdministrationDAO administrationDAO ;

public int getHighestId()
 {
  administrationDAO = new AdministrationDAO();
   int id=administrationDAO.getHighestId();
   return id;
 } 

public void insertAdministration(Administration administration)
 {
  administrationDAO = new AdministrationDAO();
  administrationDAO.insertAdministration(administration);
 } 

public void updateAdministration(Administration administration)
 {
  administrationDAO = new AdministrationDAO();
  administrationDAO.updateAdministration(administration);
 } 

public void deleteAdministration(Administration administration)
 {
  administrationDAO = new AdministrationDAO();
  administrationDAO.deleteAdministration(administration);
 } 

public Administration  getAdministrationById(int administrationId)
 {
  administrationDAO = new AdministrationDAO();
  Administration administration= administrationDAO.getAdministrationById(administrationId);
 return administration;
 } 

public Administration  getAdministration(String administrationName)
 {
  administrationDAO = new AdministrationDAO();
  Administration administration= administrationDAO.getAdministration(administrationName);
 return administration;
 } 

public List<Administration>  getAll( )
 {
  administrationDAO = new AdministrationDAO();
   List<Administration>  administrations = administrationDAO.getAdministrations( );
 return administrations;
 } 

} 

