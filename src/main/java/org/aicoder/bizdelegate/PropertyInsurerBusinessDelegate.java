package org.aicoder.bizdelegate;
import java.util.List;
import org.archcorner.chartreuse.dal.dao.PropertyInsurerDAO;
import org.archcorner.chartreuse.pojo.PropertyInsurer;

public class PropertyInsurerBusinessDelegate{ 


private PropertyInsurerDAO propertyinsurerDAO ;

public int getHighestId()
 {
  propertyinsurerDAO = new PropertyInsurerDAO();
   int id=propertyinsurerDAO.getHighestId();
   return id;
 } 

public void insertPropertyInsurer(PropertyInsurer propertyinsurer)
 {
  propertyinsurerDAO = new PropertyInsurerDAO();
  propertyinsurerDAO.insertPropertyInsurer(propertyinsurer);
 } 

public void updatePropertyInsurer(PropertyInsurer propertyinsurer)
 {
  propertyinsurerDAO = new PropertyInsurerDAO();
  propertyinsurerDAO.updatePropertyInsurer(propertyinsurer);
 } 

public void deletePropertyInsurer(PropertyInsurer propertyinsurer)
 {
  propertyinsurerDAO = new PropertyInsurerDAO();
  propertyinsurerDAO.deletePropertyInsurer(propertyinsurer);
 } 

public PropertyInsurer  getPropertyInsurerById(int propertyinsurerId)
 {
  propertyinsurerDAO = new PropertyInsurerDAO();
  PropertyInsurer propertyinsurer= propertyinsurerDAO.getPropertyInsurerById(propertyinsurerId);
 return propertyinsurer;
 } 

public PropertyInsurer  getPropertyInsurer(String propertyinsurerName)
 {
  propertyinsurerDAO = new PropertyInsurerDAO();
  PropertyInsurer propertyinsurer= propertyinsurerDAO.getPropertyInsurer(propertyinsurerName);
 return propertyinsurer;
 } 

public List<PropertyInsurer>  getAll( )
 {
  propertyinsurerDAO = new PropertyInsurerDAO();
   List<PropertyInsurer>  propertyinsurers = propertyinsurerDAO.getPropertyInsurers( );
 return propertyinsurers;
 } 

} 

