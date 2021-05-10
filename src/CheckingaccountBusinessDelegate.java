import java.util.List;
import org.archcorner.chartreuse.dal.dao.CheckingaccountDAO;
import org.archcorner.chartreuse.pojo.Checkingaccount;

public class CheckingaccountBusinessDelegate{ 


private CheckingaccountDAO checkingaccountDAO ;

public int getHighestId()
 {
  checkingaccountDAO = new CheckingaccountDAO();
   int id=checkingaccountDAO.getHighestId();
   return id;
 } 

public void insertCheckingaccount(Checkingaccount checkingaccount)
 {
  checkingaccountDAO = new CheckingaccountDAO();
  checkingaccountDAO.insertCheckingaccount(checkingaccount);
 } 

public void updateCheckingaccount(Checkingaccount checkingaccount)
 {
  checkingaccountDAO = new CheckingaccountDAO();
  checkingaccountDAO.updateCheckingaccount(checkingaccount);
 } 

public void deleteCheckingaccount(Checkingaccount checkingaccount)
 {
  checkingaccountDAO = new CheckingaccountDAO();
  checkingaccountDAO.deleteCheckingaccount(checkingaccount);
 } 

public Checkingaccount  getCheckingaccountById(int checkingaccountId)
 {
  checkingaccountDAO = new CheckingaccountDAO();
  Checkingaccount checkingaccount= checkingaccountDAO.getCheckingaccountById(checkingaccountId);
 return checkingaccount;
 } 

public Checkingaccount  getCheckingaccount(String checkingaccountName)
 {
  checkingaccountDAO = new CheckingaccountDAO();
  Checkingaccount checkingaccount= checkingaccountDAO.getCheckingaccount(checkingaccountName);
 return checkingaccount;
 } 

public List<Checkingaccount>  getAll( )
 {
  checkingaccountDAO = new CheckingaccountDAO();
   List<Checkingaccount>  checkingaccounts = checkingaccountDAO.getCheckingaccounts( );
 return checkingaccounts;
 } 

} 

