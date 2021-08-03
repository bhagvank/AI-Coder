package org.aicoder.bizdelegate;
import java.util.List;
import org.archcorner.chartreuse.dal.dao.PropertyCasualtyInsurerDAO;
import org.archcorner.chartreuse.pojo.PropertyCasualtyInsurer;

public class PropertyCasualtyInsurerBusinessDelegate{ 


private PropertyCasualtyInsurerDAO propertycasualtyinsurerDAO ;

public int getHighestId()
 {
  propertycasualtyinsurerDAO = new PropertyCasualtyInsurerDAO();
   int id=propertycasualtyinsurerDAO.getHighestId();
   return id;
 } 

public void insertPropertyCasualtyInsurer(PropertyCasualtyInsurer propertycasualtyinsurer)
 {
  propertycasualtyinsurerDAO = new PropertyCasualtyInsurerDAO();
  propertycasualtyinsurerDAO.insertPropertyCasualtyInsurer(propertycasualtyinsurer);
 } 

public void updatePropertyCasualtyInsurer(PropertyCasualtyInsurer propertycasualtyinsurer)
 {
  propertycasualtyinsurerDAO = new PropertyCasualtyInsurerDAO();
  propertycasualtyinsurerDAO.updatePropertyCasualtyInsurer(propertycasualtyinsurer);
 } 

public void deletePropertyCasualtyInsurer(PropertyCasualtyInsurer propertycasualtyinsurer)
 {
  propertycasualtyinsurerDAO = new PropertyCasualtyInsurerDAO();
  propertycasualtyinsurerDAO.deletePropertyCasualtyInsurer(propertycasualtyinsurer);
 } 

public PropertyCasualtyInsurer  getPropertyCasualtyInsurerById(int propertycasualtyinsurerId)
 {
  propertycasualtyinsurerDAO = new PropertyCasualtyInsurerDAO();
  PropertyCasualtyInsurer propertycasualtyinsurer= propertycasualtyinsurerDAO.getPropertyCasualtyInsurerById(propertycasualtyinsurerId);
 return propertycasualtyinsurer;
 } 

public PropertyCasualtyInsurer  getPropertyCasualtyInsurer(String propertycasualtyinsurerName)
 {
  propertycasualtyinsurerDAO = new PropertyCasualtyInsurerDAO();
  PropertyCasualtyInsurer propertycasualtyinsurer= propertycasualtyinsurerDAO.getPropertyCasualtyInsurer(propertycasualtyinsurerName);
 return propertycasualtyinsurer;
 } 

public List<PropertyCasualtyInsurer>  getAll( )
 {
  propertycasualtyinsurerDAO = new PropertyCasualtyInsurerDAO();
   List<PropertyCasualtyInsurer>  propertycasualtyinsurers = propertycasualtyinsurerDAO.getPropertyCasualtyInsurers( );
 return propertycasualtyinsurers;
 } 

} 

