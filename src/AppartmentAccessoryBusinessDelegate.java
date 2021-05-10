import java.util.List;
import org.archcorner.chartreuse.dal.dao.AppartmentAccessoryDAO;
import org.archcorner.chartreuse.pojo.AppartmentAccessory;

public class AppartmentAccessoryBusinessDelegate{ 


private AppartmentAccessoryDAO appartmentaccessoryDAO ;

public int getHighestId()
 {
  appartmentaccessoryDAO = new AppartmentAccessoryDAO();
   int id=appartmentaccessoryDAO.getHighestId();
   return id;
 } 

public void insertAppartmentAccessory(AppartmentAccessory appartmentaccessory)
 {
  appartmentaccessoryDAO = new AppartmentAccessoryDAO();
  appartmentaccessoryDAO.insertAppartmentAccessory(appartmentaccessory);
 } 

public void updateAppartmentAccessory(AppartmentAccessory appartmentaccessory)
 {
  appartmentaccessoryDAO = new AppartmentAccessoryDAO();
  appartmentaccessoryDAO.updateAppartmentAccessory(appartmentaccessory);
 } 

public void deleteAppartmentAccessory(AppartmentAccessory appartmentaccessory)
 {
  appartmentaccessoryDAO = new AppartmentAccessoryDAO();
  appartmentaccessoryDAO.deleteAppartmentAccessory(appartmentaccessory);
 } 

public AppartmentAccessory  getAppartmentAccessoryById(int appartmentaccessoryId)
 {
  appartmentaccessoryDAO = new AppartmentAccessoryDAO();
  AppartmentAccessory appartmentaccessory= appartmentaccessoryDAO.getAppartmentAccessoryById(appartmentaccessoryId);
 return appartmentaccessory;
 } 

public AppartmentAccessory  getAppartmentAccessory(String appartmentaccessoryName)
 {
  appartmentaccessoryDAO = new AppartmentAccessoryDAO();
  AppartmentAccessory appartmentaccessory= appartmentaccessoryDAO.getAppartmentAccessory(appartmentaccessoryName);
 return appartmentaccessory;
 } 

public List<AppartmentAccessory>  getAll( )
 {
  appartmentaccessoryDAO = new AppartmentAccessoryDAO();
   List<AppartmentAccessory>  appartmentaccessorys = appartmentaccessoryDAO.getAppartmentAccessorys( );
 return appartmentaccessorys;
 } 

} 

