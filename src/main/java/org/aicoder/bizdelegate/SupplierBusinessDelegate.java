package org.aicoder.bizdelegate;
import java.util.List;
import org.archcorner.chartreuse.dal.dao.SupplierDAO;
import org.archcorner.chartreuse.pojo.Supplier;

public class SupplierBusinessDelegate{ 


private SupplierDAO supplierDAO ;

public int getHighestId()
 {
  supplierDAO = new SupplierDAO();
   int id=supplierDAO.getHighestId();
   return id;
 } 

public void insertSupplier(Supplier supplier)
 {
  supplierDAO = new SupplierDAO();
  supplierDAO.insertSupplier(supplier);
 } 

public void updateSupplier(Supplier supplier)
 {
  supplierDAO = new SupplierDAO();
  supplierDAO.updateSupplier(supplier);
 } 

public void deleteSupplier(Supplier supplier)
 {
  supplierDAO = new SupplierDAO();
  supplierDAO.deleteSupplier(supplier);
 } 

public Supplier  getSupplierById(int supplierId)
 {
  supplierDAO = new SupplierDAO();
  Supplier supplier= supplierDAO.getSupplierById(supplierId);
 return supplier;
 } 

public Supplier  getSupplier(String supplierName)
 {
  supplierDAO = new SupplierDAO();
  Supplier supplier= supplierDAO.getSupplier(supplierName);
 return supplier;
 } 

public List<Supplier>  getAll( )
 {
  supplierDAO = new SupplierDAO();
   List<Supplier>  suppliers = supplierDAO.getSuppliers( );
 return suppliers;
 } 

} 

