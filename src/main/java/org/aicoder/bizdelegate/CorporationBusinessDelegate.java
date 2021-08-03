package org.aicoder.bizdelegate;
import java.util.List;
import org.archcorner.chartreuse.dal.dao.CorporationDAO;
import org.archcorner.chartreuse.pojo.Corporation;

public class CorporationBusinessDelegate{ 


private CorporationDAO corporationDAO ;

public int getHighestId()
 {
  corporationDAO = new CorporationDAO();
   int id=corporationDAO.getHighestId();
   return id;
 } 

public void insertCorporation(Corporation corporation)
 {
  corporationDAO = new CorporationDAO();
  corporationDAO.insertCorporation(corporation);
 } 

public void updateCorporation(Corporation corporation)
 {
  corporationDAO = new CorporationDAO();
  corporationDAO.updateCorporation(corporation);
 } 

public void deleteCorporation(Corporation corporation)
 {
  corporationDAO = new CorporationDAO();
  corporationDAO.deleteCorporation(corporation);
 } 

public Corporation  getCorporationById(int corporationId)
 {
  corporationDAO = new CorporationDAO();
  Corporation corporation= corporationDAO.getCorporationById(corporationId);
 return corporation;
 } 

public Corporation  getCorporation(String corporationName)
 {
  corporationDAO = new CorporationDAO();
  Corporation corporation= corporationDAO.getCorporation(corporationName);
 return corporation;
 } 

public List<Corporation>  getAll( )
 {
  corporationDAO = new CorporationDAO();
   List<Corporation>  corporations = corporationDAO.getCorporations( );
 return corporations;
 } 

} 

