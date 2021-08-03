package org.aicoder.bizdelegate;
import java.util.List;
import org.archcorner.chartreuse.dal.dao.PayableDAO;
import org.archcorner.chartreuse.pojo.Payable;

public class PayableBusinessDelegate{ 


private PayableDAO payableDAO ;

public int getHighestId()
 {
  payableDAO = new PayableDAO();
   int id=payableDAO.getHighestId();
   return id;
 } 

public void insertPayable(Payable payable)
 {
  payableDAO = new PayableDAO();
  payableDAO.insertPayable(payable);
 } 

public void updatePayable(Payable payable)
 {
  payableDAO = new PayableDAO();
  payableDAO.updatePayable(payable);
 } 

public void deletePayable(Payable payable)
 {
  payableDAO = new PayableDAO();
  payableDAO.deletePayable(payable);
 } 

public Payable  getPayableById(int payableId)
 {
  payableDAO = new PayableDAO();
  Payable payable= payableDAO.getPayableById(payableId);
 return payable;
 } 

public Payable  getPayable(String payableName)
 {
  payableDAO = new PayableDAO();
  Payable payable= payableDAO.getPayable(payableName);
 return payable;
 } 

public List<Payable>  getAll( )
 {
  payableDAO = new PayableDAO();
   List<Payable>  payables = payableDAO.getPayables( );
 return payables;
 } 

} 

