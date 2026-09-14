/**
 * 
 */
package org.archcorner.chartreuse.businessdelegate;

import java.util.List;

import org.archcorner.chartreuse.dal.dao.ResourceDAO;
import org.archcorner.chartreuse.pojo.Resource;

/**
 * @author bhagvan_kommadi
 *
 */
public class ResourceBusinessDelegate {

	/**
	 * 
	 */
	public ResourceBusinessDelegate() {
		// TODO Auto-generated constructor stub
	}
	public void insertResource(Resource resource)
	{
		ResourceDAO resourceDAO = new ResourceDAO();
		resourceDAO.insertResource(resource);
	}
	
	public void updateResource(Resource resource)
	{
		ResourceDAO resourceDAO = new ResourceDAO();
		resourceDAO.updateResource(resource);
	}
	
	public Resource getResourceById(int resourceId)
	{
		ResourceDAO resourceDAO = new ResourceDAO();
		 return resourceDAO.getResourceById(resourceId);
	}
	public Resource getResource(String resourceName)
	{
		ResourceDAO resourceDAO = new ResourceDAO();
		return resourceDAO.getResource(resourceName);
	}
	
	public List<Resource> getAll()
	{
		ResourceDAO resourceDAO = new ResourceDAO();
		return resourceDAO.getResources();
	}
	
	public void deleteResource(Resource resource)
	{
		ResourceDAO resourceDAO = new ResourceDAO();
		resourceDAO.deleteResource(resource);
	}
	
	public int getHighestId()
	{
		ResourceDAO resourceDAO = new ResourceDAO();
		return resourceDAO.getHighestId();
	}
}
