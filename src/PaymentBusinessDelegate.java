import java.util.List;
import org.archcorner.chartreuse.dal.dao.PaymentDAO;
import org.archcorner.chartreuse.pojo.Payment;

public class PaymentBusinessDelegate{ 


private PaymentDAO paymentDAO ;

public int getHighestId()
 {
  paymentDAO = new PaymentDAO();
   int id=paymentDAO.getHighestId();
   return id;
 } 

public void insertPayment(Payment payment)
 {
  paymentDAO = new PaymentDAO();
  paymentDAO.insertPayment(payment);
 } 

public void updatePayment(Payment payment)
 {
  paymentDAO = new PaymentDAO();
  paymentDAO.updatePayment(payment);
 } 

public void deletePayment(Payment payment)
 {
  paymentDAO = new PaymentDAO();
  paymentDAO.deletePayment(payment);
 } 

public Payment  getPaymentById(int paymentId)
 {
  paymentDAO = new PaymentDAO();
  Payment payment= paymentDAO.getPaymentById(paymentId);
 return payment;
 } 

public Payment  getPayment(String paymentName)
 {
  paymentDAO = new PaymentDAO();
  Payment payment= paymentDAO.getPayment(paymentName);
 return payment;
 } 

public List<Payment>  getAll( )
 {
  paymentDAO = new PaymentDAO();
   List<Payment>  payments = paymentDAO.getPayments( );
 return payments;
 } 

} 

