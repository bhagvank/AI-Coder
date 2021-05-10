import java.util.List;
import org.archcorner.chartreuse.dal.dao.AccountDAO;
import org.archcorner.chartreuse.pojo.Account;

public class AccountBusinessDelegate{ 


private AccountDAO accountDAO ;

public int getHighestId()
 {
  accountDAO = new AccountDAO();
   int id=accountDAO.getHighestId();
   return id;
 } 

public void insertAccount(Account account)
 {
  accountDAO = new AccountDAO();
  accountDAO.insertAccount(account);
 } 

public void updateAccount(Account account)
 {
  accountDAO = new AccountDAO();
  accountDAO.updateAccount(account);
 } 

public void deleteAccount(Account account)
 {
  accountDAO = new AccountDAO();
  accountDAO.deleteAccount(account);
 } 

public Account  getAccountById(int accountId)
 {
  accountDAO = new AccountDAO();
  Account account= accountDAO.getAccountById(accountId);
 return account;
 } 

public Account  getAccount(String accountName)
 {
  accountDAO = new AccountDAO();
  Account account= accountDAO.getAccount(accountName);
 return account;
 } 

public List<Account>  getAll( )
 {
  accountDAO = new AccountDAO();
   List<Account>  accounts = accountDAO.getAccounts( );
 return accounts;
 } 

} 

