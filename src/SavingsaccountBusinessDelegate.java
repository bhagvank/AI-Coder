import java.util.List;
import org.archcorner.chartreuse.dal.dao.SavingsaccountDAO;
import org.archcorner.chartreuse.pojo.Savingsaccount;

public class SavingsaccountBusinessDelegate{ 


private SavingsaccountDAO savingsaccountDAO ;

public int getHighestId()
 {
  savingsaccountDAO = new SavingsaccountDAO();
   int id=savingsaccountDAO.getHighestId();
   return id;
 } 

public void insertSavingsaccount(Savingsaccount savingsaccount)
 {
  savingsaccountDAO = new SavingsaccountDAO();
  savingsaccountDAO.insertSavingsaccount(savingsaccount);
 } 

public void updateSavingsaccount(Savingsaccount savingsaccount)
 {
  savingsaccountDAO = new SavingsaccountDAO();
  savingsaccountDAO.updateSavingsaccount(savingsaccount);
 } 

public void deleteSavingsaccount(Savingsaccount savingsaccount)
 {
  savingsaccountDAO = new SavingsaccountDAO();
  savingsaccountDAO.deleteSavingsaccount(savingsaccount);
 } 

public Savingsaccount  getSavingsaccountById(int savingsaccountId)
 {
  savingsaccountDAO = new SavingsaccountDAO();
  Savingsaccount savingsaccount= savingsaccountDAO.getSavingsaccountById(savingsaccountId);
 return savingsaccount;
 } 

public Savingsaccount  getSavingsaccount(String savingsaccountName)
 {
  savingsaccountDAO = new SavingsaccountDAO();
  Savingsaccount savingsaccount= savingsaccountDAO.getSavingsaccount(savingsaccountName);
 return savingsaccount;
 } 

public List<Savingsaccount>  getAll( )
 {
  savingsaccountDAO = new SavingsaccountDAO();
   List<Savingsaccount>  savingsaccounts = savingsaccountDAO.getSavingsaccounts( );
 return savingsaccounts;
 } 

} 

