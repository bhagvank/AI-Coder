package org.aicoder.bizdelegate;
import java.util.List;
import org.archcorner.chartreuse.dal.dao.OwnerDAO;
import org.archcorner.chartreuse.pojo.Owner;

public class OwnerBusinessDelegate{ 


private OwnerDAO ownerDAO ;

public int getHighestId()
 {
  ownerDAO = new OwnerDAO();
   int id=ownerDAO.getHighestId();
   return id;
 } 

public void insertOwner(Owner owner)
 {
  ownerDAO = new OwnerDAO();
  ownerDAO.insertOwner(owner);
 } 

public void updateOwner(Owner owner)
 {
  ownerDAO = new OwnerDAO();
  ownerDAO.updateOwner(owner);
 } 

public void deleteOwner(Owner owner)
 {
  ownerDAO = new OwnerDAO();
  ownerDAO.deleteOwner(owner);
 } 

public Owner  getOwnerById(int ownerId)
 {
  ownerDAO = new OwnerDAO();
  Owner owner= ownerDAO.getOwnerById(ownerId);
 return owner;
 } 

public Owner  getOwner(String ownerName)
 {
  ownerDAO = new OwnerDAO();
  Owner owner= ownerDAO.getOwner(ownerName);
 return owner;
 } 

public List<Owner>  getAll( )
 {
  ownerDAO = new OwnerDAO();
   List<Owner>  owners = ownerDAO.getOwners( );
 return owners;
 } 

} 

