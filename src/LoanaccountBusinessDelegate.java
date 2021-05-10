import java.util.List;
import org.archcorner.chartreuse.dal.dao.LoanaccountDAO;
import org.archcorner.chartreuse.pojo.Loanaccount;

public class LoanaccountBusinessDelegate{ 


private LoanaccountDAO loanaccountDAO ;

public int getHighestId()
 {
  loanaccountDAO = new LoanaccountDAO();
   int id=loanaccountDAO.getHighestId();
   return id;
 } 

public void insertLoanaccount(Loanaccount loanaccount)
 {
  loanaccountDAO = new LoanaccountDAO();
  loanaccountDAO.insertLoanaccount(loanaccount);
 } 

public void updateLoanaccount(Loanaccount loanaccount)
 {
  loanaccountDAO = new LoanaccountDAO();
  loanaccountDAO.updateLoanaccount(loanaccount);
 } 

public void deleteLoanaccount(Loanaccount loanaccount)
 {
  loanaccountDAO = new LoanaccountDAO();
  loanaccountDAO.deleteLoanaccount(loanaccount);
 } 

public Loanaccount  getLoanaccountById(int loanaccountId)
 {
  loanaccountDAO = new LoanaccountDAO();
  Loanaccount loanaccount= loanaccountDAO.getLoanaccountById(loanaccountId);
 return loanaccount;
 } 

public Loanaccount  getLoanaccount(String loanaccountName)
 {
  loanaccountDAO = new LoanaccountDAO();
  Loanaccount loanaccount= loanaccountDAO.getLoanaccount(loanaccountName);
 return loanaccount;
 } 

public List<Loanaccount>  getAll( )
 {
  loanaccountDAO = new LoanaccountDAO();
   List<Loanaccount>  loanaccounts = loanaccountDAO.getLoanaccounts( );
 return loanaccounts;
 } 

} 

