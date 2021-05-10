import java.util.List;
import org.archcorner.chartreuse.dal.dao.InvoiceDAO;
import org.archcorner.chartreuse.pojo.Invoice;

public class InvoiceBusinessDelegate{ 


private InvoiceDAO invoiceDAO ;

public int getHighestId()
 {
  invoiceDAO = new InvoiceDAO();
   int id=invoiceDAO.getHighestId();
   return id;
 } 

public void insertInvoice(Invoice invoice)
 {
  invoiceDAO = new InvoiceDAO();
  invoiceDAO.insertInvoice(invoice);
 } 

public void updateInvoice(Invoice invoice)
 {
  invoiceDAO = new InvoiceDAO();
  invoiceDAO.updateInvoice(invoice);
 } 

public void deleteInvoice(Invoice invoice)
 {
  invoiceDAO = new InvoiceDAO();
  invoiceDAO.deleteInvoice(invoice);
 } 

public Invoice  getInvoiceById(int invoiceId)
 {
  invoiceDAO = new InvoiceDAO();
  Invoice invoice= invoiceDAO.getInvoiceById(invoiceId);
 return invoice;
 } 

public Invoice  getInvoice(String invoiceName)
 {
  invoiceDAO = new InvoiceDAO();
  Invoice invoice= invoiceDAO.getInvoice(invoiceName);
 return invoice;
 } 

public List<Invoice>  getAll( )
 {
  invoiceDAO = new InvoiceDAO();
   List<Invoice>  invoices = invoiceDAO.getInvoices( );
 return invoices;
 } 

} 

