package org.aicoder.bizdelegate;
import java.util.List;
import org.archcorner.chartreuse.dal.dao.CreditcardaccountDAO;
import org.archcorner.chartreuse.pojo.Creditcardaccount;

public class CreditcardaccountBusinessDelegate{ 


private CreditcardaccountDAO creditcardaccountDAO ;

public int getHighestId()
 {
  creditcardaccountDAO = new CreditcardaccountDAO();
   int id=creditcardaccountDAO.getHighestId();
   return id;
 } 

public void insertCreditcardaccount(Creditcardaccount creditcardaccount)
 {
  creditcardaccountDAO = new CreditcardaccountDAO();
  creditcardaccountDAO.insertCreditcardaccount(creditcardaccount);
 } 

public void updateCreditcardaccount(Creditcardaccount creditcardaccount)
 {
  creditcardaccountDAO = new CreditcardaccountDAO();
  creditcardaccountDAO.updateCreditcardaccount(creditcardaccount);
 } 

public void deleteCreditcardaccount(Creditcardaccount creditcardaccount)
 {
  creditcardaccountDAO = new CreditcardaccountDAO();
  creditcardaccountDAO.deleteCreditcardaccount(creditcardaccount);
 } 

public Creditcardaccount  getCreditcardaccountById(int creditcardaccountId)
 {
  creditcardaccountDAO = new CreditcardaccountDAO();
  Creditcardaccount creditcardaccount= creditcardaccountDAO.getCreditcardaccountById(creditcardaccountId);
 return creditcardaccount;
 } 

public Creditcardaccount  getCreditcardaccount(String creditcardaccountName)
 {
  creditcardaccountDAO = new CreditcardaccountDAO();
  Creditcardaccount creditcardaccount= creditcardaccountDAO.getCreditcardaccount(creditcardaccountName);
 return creditcardaccount;
 } 

public List<Creditcardaccount>  getAll( )
 {
  creditcardaccountDAO = new CreditcardaccountDAO();
   List<Creditcardaccount>  creditcardaccounts = creditcardaccountDAO.getCreditcardaccounts( );
 return creditcardaccounts;
 } 

} 

