package org.aicoder.bizdelegate;
import java.util.List;
import org.archcorner.chartreuse.dal.dao.GlaccountDAO;
import org.archcorner.chartreuse.pojo.Glaccount;

public class GlaccountBusinessDelegate{ 


private GlaccountDAO glaccountDAO ;

public int getHighestId()
 {
  glaccountDAO = new GlaccountDAO();
   int id=glaccountDAO.getHighestId();
   return id;
 } 

public void insertGlaccount(Glaccount glaccount)
 {
  glaccountDAO = new GlaccountDAO();
  glaccountDAO.insertGlaccount(glaccount);
 } 

public void updateGlaccount(Glaccount glaccount)
 {
  glaccountDAO = new GlaccountDAO();
  glaccountDAO.updateGlaccount(glaccount);
 } 

public void deleteGlaccount(Glaccount glaccount)
 {
  glaccountDAO = new GlaccountDAO();
  glaccountDAO.deleteGlaccount(glaccount);
 } 

public Glaccount  getGlaccountById(int glaccountId)
 {
  glaccountDAO = new GlaccountDAO();
  Glaccount glaccount= glaccountDAO.getGlaccountById(glaccountId);
 return glaccount;
 } 

public Glaccount  getGlaccount(String glaccountName)
 {
  glaccountDAO = new GlaccountDAO();
  Glaccount glaccount= glaccountDAO.getGlaccount(glaccountName);
 return glaccount;
 } 

public List<Glaccount>  getAll( )
 {
  glaccountDAO = new GlaccountDAO();
   List<Glaccount>  glaccounts = glaccountDAO.getGlaccounts( );
 return glaccounts;
 } 

} 

