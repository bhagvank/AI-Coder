/**
 * 
 */
package org.archcorner.chartreuse.businessdelegate;

/**
 * @author bhagvan.kommadi
 *
 */
import java.util.List;
import org.archcorner.chartreuse.dal.dao.PartnerDAO;
import org.archcorner.chartreuse.pojo.Partner;

public class PartnerBusinessDelegate{ 

private PartnerDAO partnerDAO ;

public int getHighestId()
 {
  partnerDAO = new PartnerDAO();
   int id=partnerDAO.getHighestId();
   return id;
 } 

public void insertPartner(Partner partner)
 {
  partnerDAO = new PartnerDAO();
  partnerDAO.insertPartner(partner);
 } 

public void updatePartner(Partner partner)
 {
  partnerDAO = new PartnerDAO();
  partnerDAO.updatePartner(partner);
 } 

public void deletePartner(Partner partner)
 {
  partnerDAO = new PartnerDAO();
  partnerDAO.deletePartner(partner);
 } 

public Partner  getPartnerById(int partnerId)
 {
  partnerDAO = new PartnerDAO();
  Partner partner= partnerDAO.getPartnerById(partnerId);
 return partner;
 } 

public Partner  getPartner(String partnerName)
 {
  partnerDAO = new PartnerDAO();
  Partner partner= partnerDAO.getPartner(partnerName);
 return partner;
 } 

public List<Partner>  getAll( )
 {
  partnerDAO = new PartnerDAO();
   List<Partner>  partners = partnerDAO.getPartners( );
 return partners;
 } 

public static void main(String[] args)
{
	PartnerBusinessDelegate businessDelegate = new PartnerBusinessDelegate();
	 int partnerId = businessDelegate.getHighestId();
	 
	 Partner partner = new Partner();
	 partner.setPartnerId(partnerId);
	 partner.setPartnerName("MentorGraphics");
	 partner.setPartnerAddress("San Francisco");
	 partner.setPartnerCity("San Franscisco");
	 partner.setPartnerState("California");
	 partner.setPartnerCountry("USA");
	 
	 
	 businessDelegate.insertPartner(partner);
	 
	 Partner insertedPartner = businessDelegate.getPartner("MentorGraphics");
	 insertedPartner.setPartnerCity("Chicago");
	 insertedPartner.setPartnerState("Illinois");
	 
	 businessDelegate.updatePartner(insertedPartner);
	 
	 Partner partnerData = businessDelegate.getPartner("MentorGraphics");
	 System.out.println(partnerData.getPartnerId());
	 System.out.println(partnerData.getPartnerCity());
	 System.out.println(partnerData.getPartnerCountry());
	 
	 businessDelegate.deletePartner(partnerData);
}
} 


