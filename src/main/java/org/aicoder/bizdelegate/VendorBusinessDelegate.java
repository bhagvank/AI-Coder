package org.aicoder.bizdelegate;
import java.util.List;
import org.archcorner.chartreuse.dal.dao.VendorDAO;
import org.archcorner.chartreuse.pojo.Vendor;

public class VendorBusinessDelegate{ 


private VendorDAO vendorDAO ;

public int getHighestId()
 {
  vendorDAO = new VendorDAO();
   int id=vendorDAO.getHighestId();
   return id;
 } 

public void insertVendor(Vendor vendor)
 {
  vendorDAO = new VendorDAO();
  vendorDAO.insertVendor(vendor);
 } 

public void updateVendor(Vendor vendor)
 {
  vendorDAO = new VendorDAO();
  vendorDAO.updateVendor(vendor);
 } 

public void deleteVendor(Vendor vendor)
 {
  vendorDAO = new VendorDAO();
  vendorDAO.deleteVendor(vendor);
 } 

public Vendor  getVendorById(int vendorId)
 {
  vendorDAO = new VendorDAO();
  Vendor vendor= vendorDAO.getVendorById(vendorId);
 return vendor;
 } 

public Vendor  getVendor(String vendorName)
 {
  vendorDAO = new VendorDAO();
  Vendor vendor= vendorDAO.getVendor(vendorName);
 return vendor;
 } 

public List<Vendor>  getAll( )
 {
  vendorDAO = new VendorDAO();
   List<Vendor>  vendors = vendorDAO.getVendors( );
 return vendors;
 } 

} 

