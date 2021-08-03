package org.aicoder.bizdelegate;
import java.util.List;
import org.archcorner.chartreuse.dal.dao.EntitlementDAO;
import org.archcorner.chartreuse.pojo.Entitlement;

public class EntitlementBusinessDelegate{ 


private EntitlementDAO entitlementDAO ;

public int getHighestId()
 {
  entitlementDAO = new EntitlementDAO();
   int id=entitlementDAO.getHighestId();
   return id;
 } 

public void insertEntitlement(Entitlement entitlement)
 {
  entitlementDAO = new EntitlementDAO();
  entitlementDAO.insertEntitlement(entitlement);
 } 

public void updateEntitlement(Entitlement entitlement)
 {
  entitlementDAO = new EntitlementDAO();
  entitlementDAO.updateEntitlement(entitlement);
 } 

public void deleteEntitlement(Entitlement entitlement)
 {
  entitlementDAO = new EntitlementDAO();
  entitlementDAO.deleteEntitlement(entitlement);
 } 

public Entitlement  getEntitlementById(int entitlementId)
 {
  entitlementDAO = new EntitlementDAO();
  Entitlement entitlement= entitlementDAO.getEntitlementById(entitlementId);
 return entitlement;
 } 

public Entitlement  getEntitlement(String entitlementName)
 {
  entitlementDAO = new EntitlementDAO();
  Entitlement entitlement= entitlementDAO.getEntitlement(entitlementName);
 return entitlement;
 } 

public List<Entitlement>  getAll( )
 {
  entitlementDAO = new EntitlementDAO();
   List<Entitlement>  entitlements = entitlementDAO.getEntitlements( );
 return entitlements;
 } 

} 

