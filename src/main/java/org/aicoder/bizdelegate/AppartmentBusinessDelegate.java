package org.aicoder.bizdelegate;
import java.util.List;
import org.archcorner.chartreuse.dal.dao.AppartmentDAO;
import org.archcorner.chartreuse.pojo.Appartment;

public class AppartmentBusinessDelegate{ 


private AppartmentDAO appartmentDAO ;

public int getHighestId()
 {
  appartmentDAO = new AppartmentDAO();
   int id=appartmentDAO.getHighestId();
   return id;
 } 

public void insertAppartment(Appartment appartment)
 {
  appartmentDAO = new AppartmentDAO();
  appartmentDAO.insertAppartment(appartment);
 } 

public void updateAppartment(Appartment appartment)
 {
  appartmentDAO = new AppartmentDAO();
  appartmentDAO.updateAppartment(appartment);
 } 

public void deleteAppartment(Appartment appartment)
 {
  appartmentDAO = new AppartmentDAO();
  appartmentDAO.deleteAppartment(appartment);
 } 

public Appartment  getAppartmentById(int appartmentId)
 {
  appartmentDAO = new AppartmentDAO();
  Appartment appartment= appartmentDAO.getAppartmentById(appartmentId);
 return appartment;
 } 

public Appartment  getAppartment(String appartmentName)
 {
  appartmentDAO = new AppartmentDAO();
  Appartment appartment= appartmentDAO.getAppartment(appartmentName);
 return appartment;
 } 

public List<Appartment>  getAll( )
 {
  appartmentDAO = new AppartmentDAO();
   List<Appartment>  appartments = appartmentDAO.getAppartments( );
 return appartments;
 } 

} 

