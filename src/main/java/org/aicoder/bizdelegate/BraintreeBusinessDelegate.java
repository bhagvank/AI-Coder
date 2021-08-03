package org.aicoder.bizdelegate;
import java.util.List;
import org.archcorner.chartreuse.dal.dao.BraintreeDAO;
import org.archcorner.chartreuse.pojo.Braintree;

public class BraintreeBusinessDelegate{ 


private BraintreeDAO braintreeDAO ;

public int getHighestId()
 {
  braintreeDAO = new BraintreeDAO();
   int id=braintreeDAO.getHighestId();
   return id;
 } 

public void insertBraintree(Braintree braintree)
 {
  braintreeDAO = new BraintreeDAO();
  braintreeDAO.insertBraintree(braintree);
 } 

public void updateBraintree(Braintree braintree)
 {
  braintreeDAO = new BraintreeDAO();
  braintreeDAO.updateBraintree(braintree);
 } 

public void deleteBraintree(Braintree braintree)
 {
  braintreeDAO = new BraintreeDAO();
  braintreeDAO.deleteBraintree(braintree);
 } 

public Braintree  getBraintreeById(int braintreeId)
 {
  braintreeDAO = new BraintreeDAO();
  Braintree braintree= braintreeDAO.getBraintreeById(braintreeId);
 return braintree;
 } 

public Braintree  getBraintree(String braintreeName)
 {
  braintreeDAO = new BraintreeDAO();
  Braintree braintree= braintreeDAO.getBraintree(braintreeName);
 return braintree;
 } 

public List<Braintree>  getAll( )
 {
  braintreeDAO = new BraintreeDAO();
   List<Braintree>  braintrees = braintreeDAO.getBraintrees( );
 return braintrees;
 } 

} 

