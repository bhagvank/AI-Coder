package org.aicoder.bizdelegate;
import java.util.List;
import org.archcorner.chartreuse.dal.dao.CurrentacountDAO;
import org.archcorner.chartreuse.pojo.Currentacount;

public class CurrentacountBusinessDelegate{ 


private CurrentacountDAO currentacountDAO ;

public int getHighestId()
 {
  currentacountDAO = new CurrentacountDAO();
   int id=currentacountDAO.getHighestId();
   return id;
 } 

public void insertCurrentacount(Currentacount currentacount)
 {
  currentacountDAO = new CurrentacountDAO();
  currentacountDAO.insertCurrentacount(currentacount);
 } 

public void updateCurrentacount(Currentacount currentacount)
 {
  currentacountDAO = new CurrentacountDAO();
  currentacountDAO.updateCurrentacount(currentacount);
 } 

public void deleteCurrentacount(Currentacount currentacount)
 {
  currentacountDAO = new CurrentacountDAO();
  currentacountDAO.deleteCurrentacount(currentacount);
 } 

public Currentacount  getCurrentacountById(int currentacountId)
 {
  currentacountDAO = new CurrentacountDAO();
  Currentacount currentacount= currentacountDAO.getCurrentacountById(currentacountId);
 return currentacount;
 } 

public Currentacount  getCurrentacount(String currentacountName)
 {
  currentacountDAO = new CurrentacountDAO();
  Currentacount currentacount= currentacountDAO.getCurrentacount(currentacountName);
 return currentacount;
 } 

public List<Currentacount>  getAll( )
 {
  currentacountDAO = new CurrentacountDAO();
   List<Currentacount>  currentacounts = currentacountDAO.getCurrentacounts( );
 return currentacounts;
 } 

} 

