/**
 * 
 */
package org.archcorner.chartreuse.businessservices;

import java.util.List;
import java.util.StringTokenizer;

import org.archcorner.chartreuse.dal.dao.ResourceDAO;
import org.archcorner.chartreuse.pojo.Resource;

/**
 * @author bhagvan_kommadi
 *
 */
public class ResourceService {

	/**
	 * 
	 */
	public ResourceService() {
		// TODO Auto-generated constructor stub
	}

	public void insertResource(String resourceProperties)
	{
		StringTokenizer stringTokenizer = new StringTokenizer(resourceProperties,"@@");
		
		Resource resource = new Resource();
		//resource.setResourceId(Integer.parseInt(stringTokenizer.nextToken()));
		resource.setName(stringTokenizer.nextToken());
		resource.setType(stringTokenizer.nextToken());
		resource.setStartDate(stringTokenizer.nextToken());
		
		ResourceDAO resourceDAO = new ResourceDAO();
		resourceDAO.insertResource(resource);
	}
	
	public void updateResource(String resourceProperties)
	{
		StringTokenizer stringTokenizer = new StringTokenizer(resourceProperties,"@@");
		
		Resource resource = new Resource();
		resource.setResourceId(Integer.parseInt(stringTokenizer.nextToken()));
		resource.setName(stringTokenizer.nextToken());
		resource.setType(stringTokenizer.nextToken());
		resource.setStartDate(stringTokenizer.nextToken());
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
	
	public Resource[] getAll()
	{
		ResourceDAO resourceDAO = new ResourceDAO();
		
		List<Resource> resourceList = resourceDAO.getResources();
		 
		Resource[] resources = new Resource[resourceList.size()];
		return resourceList.toArray(resources);
	}
	
	public void deleteResource(String resourceProperties)
	{
		StringTokenizer stringTokenizer = new StringTokenizer(resourceProperties, "@@");
		Resource resource = new Resource();
		resource.setResourceId(Integer.parseInt(stringTokenizer.nextToken()));
		resource.setName(stringTokenizer.nextToken());
		resource.setType(stringTokenizer.nextToken());
		resource.setStartDate(stringTokenizer.nextToken());
		
		ResourceDAO resourceDAO = new ResourceDAO();
		resourceDAO.deleteResource(resource);
	}
	
	public int getHighestId()
	{
		ResourceDAO resourceDAO = new ResourceDAO();
		return resourceDAO.getHighestId();
	}
}
