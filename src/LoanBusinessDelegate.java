import java.util.List;
import org.archcorner.chartreuse.dal.dao.LoanDAO;
import org.archcorner.chartreuse.pojo.Loan;

public class LoanBusinessDelegate{ 


private LoanDAO loanDAO ;

public int getHighestId()
 {
  loanDAO = new LoanDAO();
   int id=loanDAO.getHighestId();
   return id;
 } 

public void insertLoan(Loan loan)
 {
  loanDAO = new LoanDAO();
  loanDAO.insertLoan(loan);
 } 

public void updateLoan(Loan loan)
 {
  loanDAO = new LoanDAO();
  loanDAO.updateLoan(loan);
 } 

public void deleteLoan(Loan loan)
 {
  loanDAO = new LoanDAO();
  loanDAO.deleteLoan(loan);
 } 

public Loan  getLoanById(int loanId)
 {
  loanDAO = new LoanDAO();
  Loan loan= loanDAO.getLoanById(loanId);
 return loan;
 } 

public Loan  getLoan(String loanName)
 {
  loanDAO = new LoanDAO();
  Loan loan= loanDAO.getLoan(loanName);
 return loan;
 } 

public List<Loan>  getAll( )
 {
  loanDAO = new LoanDAO();
   List<Loan>  loans = loanDAO.getLoans( );
 return loans;
 } 

} 

