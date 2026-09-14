/**
 * 
 */
package org.archcorner.chartreuse.businessdelegate;

/**
 * @author bhagvan.kommadi
 *
 */
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

 public static void main(String[] args)
 {
	 VendorBusinessDelegate businessDelegate = new VendorBusinessDelegate();
	 int vendorId = businessDelegate.getHighestId();
	 
	 Vendor vendor = new Vendor();
	 vendor.setVendorId(vendorId);
	 vendor.setVendorName("MentorGraphics");
	 vendor.setVendorAddress("San Francisco");
	 vendor.setVendorCity("San Franscisco");
	 vendor.setVendorState("California");
	 vendor.setVendorCountry("USA");
	 
	 
	 businessDelegate.insertVendor(vendor);
	 
	 Vendor insertedVendor = businessDelegate.getVendor("MentorGraphics");
	 insertedVendor.setVendorCity("Chicago");
	 insertedVendor.setVendorState("Illinois");
	 
	 businessDelegate.updateVendor(insertedVendor);
	 
	 Vendor vendorData = businessDelegate.getVendor("MentorGraphics");
	 System.out.println(vendorData.getVendorId());
	 System.out.println(vendorData.getVendorCity());
	 System.out.println(vendorData.getVendorCountry());
	 
	 businessDelegate.deleteVendor(vendorData);
 }
} 


