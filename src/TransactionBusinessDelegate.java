import java.util.List;
import org.archcorner.chartreuse.dal.dao.TransactionDAO;
import org.archcorner.chartreuse.pojo.Transaction;

public class TransactionBusinessDelegate{ 


private TransactionDAO transactionDAO ;

public int getHighestId()
 {
  transactionDAO = new TransactionDAO();
   int id=transactionDAO.getHighestId();
   return id;
 } 

public void insertTransaction(Transaction transaction)
 {
  transactionDAO = new TransactionDAO();
  transactionDAO.insertTransaction(transaction);
 } 

public void updateTransaction(Transaction transaction)
 {
  transactionDAO = new TransactionDAO();
  transactionDAO.updateTransaction(transaction);
 } 

public void deleteTransaction(Transaction transaction)
 {
  transactionDAO = new TransactionDAO();
  transactionDAO.deleteTransaction(transaction);
 } 

public Transaction  getTransactionById(int transactionId)
 {
  transactionDAO = new TransactionDAO();
  Transaction transaction= transactionDAO.getTransactionById(transactionId);
 return transaction;
 } 

public Transaction  getTransaction(String transactionName)
 {
  transactionDAO = new TransactionDAO();
  Transaction transaction= transactionDAO.getTransaction(transactionName);
 return transaction;
 } 

public List<Transaction>  getAll( )
 {
  transactionDAO = new TransactionDAO();
   List<Transaction>  transactions = transactionDAO.getTransactions( );
 return transactions;
 } 

} 

