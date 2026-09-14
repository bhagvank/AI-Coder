/**
 * 
 */
package org.archcorner.chartreuse.businessservices;

import java.util.List;
import java.util.StringTokenizer;

import org.archcorner.chartreuse.dal.dao.DisasterDAO;
import org.archcorner.chartreuse.pojo.Disaster;

/**
 * @author bhagvan_kommadi
 *
 */
public class DisasterService {

	/**
	 * 
	 */
	public DisasterService() {
		// TODO Auto-generated constructor stub
	}
	
	public void insertDisaster(String disasterProperties)
	{
		StringTokenizer stringTokenizer = new StringTokenizer(disasterProperties,"@@");
		
		Disaster disaster = new Disaster();
		//disaster.setDisasterId(Integer.parseInt(stringTokenizer.nextToken()));
		disaster.setDisasterName(stringTokenizer.nextToken());
		disaster.setLocationName(stringTokenizer.nextToken());
		disaster.setEventDescription(stringTokenizer.nextToken());
		disaster.setContactNo(stringTokenizer.nextToken());
		disaster.setReporterName(stringTokenizer.nextToken());
		
		DisasterDAO disasterDAO = new DisasterDAO();
		disasterDAO.insertDisaster(disaster);
	}
	
	public void updateDisaster(String disasterProperties)
	{
		StringTokenizer stringTokenizer = new StringTokenizer(disasterProperties,"@@");
		
		Disaster disaster = new Disaster();
		disaster.setDisasterId(Integer.parseInt(stringTokenizer.nextToken()));
		disaster.setDisasterName(stringTokenizer.nextToken());
		disaster.setLocationName(stringTokenizer.nextToken());
		disaster.setEventDescription(stringTokenizer.nextToken());
		disaster.setContactNo(stringTokenizer.nextToken());
		disaster.setReporterName(stringTokenizer.nextToken());
				
		DisasterDAO disasterDAO = new DisasterDAO();
		disasterDAO.updateDisaster(disaster);
	}
	
	public Disaster getDisasterById(int disasterId)
	{
		DisasterDAO disasterDAO = new DisasterDAO();
		 return disasterDAO.getDisasterById(disasterId);
	}
	public Disaster getDisaster(String disasterName)
	{
		DisasterDAO disasterDAO = new DisasterDAO();
		return disasterDAO.getDisaster(disasterName);
	}
	
	public Disaster[] getAll()
	{
		DisasterDAO disasterDAO = new DisasterDAO();
		
		List<Disaster> disasterList = disasterDAO.getDisasters();
		 
		Disaster[] disasters = new Disaster[disasterList.size()];
		return disasterList.toArray(disasters);
	}
	
	public void deleteDisaster(String disasterProperties)
	{
		StringTokenizer stringTokenizer = new StringTokenizer(disasterProperties, "@@");
		Disaster disaster = new Disaster();
		disaster.setDisasterId(Integer.parseInt(stringTokenizer.nextToken()));
		disaster.setDisasterName(stringTokenizer.nextToken());
		disaster.setLocationName(stringTokenizer.nextToken());
		disaster.setEventDescription(stringTokenizer.nextToken());
		disaster.setContactNo(stringTokenizer.nextToken());
		disaster.setReporterName(stringTokenizer.nextToken());
		DisasterDAO disasterDAO = new DisasterDAO();
		disasterDAO.deleteDisaster(disaster);
	}
	
	public int getHighestId()
	{
		DisasterDAO disasterDAO = new DisasterDAO();
		return disasterDAO.getHighestId();
	}

}
