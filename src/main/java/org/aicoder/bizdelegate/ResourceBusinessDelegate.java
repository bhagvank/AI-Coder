package org.aicoder.bizdelegate;
import java.util.List;
import org.archcorner.chartreuse.dal.dao.ResourceDAO;
import org.archcorner.chartreuse.pojo.Resource;

public class ResourceBusinessDelegate{ 


private ResourceDAO resourceDAO ;

public int getHighestId()
 {
  resourceDAO = new ResourceDAO();
   int id=resourceDAO.getHighestId();
   return id;
 } 

public void insertResource(Resource resource)
 {
  resourceDAO = new ResourceDAO();
  resourceDAO.insertResource(resource);
 } 

public void updateResource(Resource resource)
 {
  resourceDAO = new ResourceDAO();
  resourceDAO.updateResource(resource);
 } 

public void deleteResource(Resource resource)
 {
  resourceDAO = new ResourceDAO();
  resourceDAO.deleteResource(resource);
 } 

public Resource  getResourceById(int resourceId)
 {
  resourceDAO = new ResourceDAO();
  Resource resource= resourceDAO.getResourceById(resourceId);
 return resource;
 } 

public Resource  getResource(String resourceName)
 {
  resourceDAO = new ResourceDAO();
  Resource resource= resourceDAO.getResource(resourceName);
 return resource;
 } 

public List<Resource>  getAll( )
 {
  resourceDAO = new ResourceDAO();
   List<Resource>  resources = resourceDAO.getResources( );
 return resources;
 } 

} 

