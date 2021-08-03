package org.aicoder.bizdelegate;
import java.util.List;
import org.archcorner.chartreuse.dal.dao.LiabilityDAO;
import org.archcorner.chartreuse.pojo.Liability;

public class LiabilityBusinessDelegate{ 


private LiabilityDAO liabilityDAO ;

public int getHighestId()
 {
  liabilityDAO = new LiabilityDAO();
   int id=liabilityDAO.getHighestId();
   return id;
 } 

public void insertLiability(Liability liability)
 {
  liabilityDAO = new LiabilityDAO();
  liabilityDAO.insertLiability(liability);
 } 

public void updateLiability(Liability liability)
 {
  liabilityDAO = new LiabilityDAO();
  liabilityDAO.updateLiability(liability);
 } 

public void deleteLiability(Liability liability)
 {
  liabilityDAO = new LiabilityDAO();
  liabilityDAO.deleteLiability(liability);
 } 

public Liability  getLiabilityById(int liabilityId)
 {
  liabilityDAO = new LiabilityDAO();
  Liability liability= liabilityDAO.getLiabilityById(liabilityId);
 return liability;
 } 

public Liability  getLiability(String liabilityName)
 {
  liabilityDAO = new LiabilityDAO();
  Liability liability= liabilityDAO.getLiability(liabilityName);
 return liability;
 } 

public List<Liability>  getAll( )
 {
  liabilityDAO = new LiabilityDAO();
   List<Liability>  liabilitys = liabilityDAO.getLiabilitys( );
 return liabilitys;
 } 

} 

