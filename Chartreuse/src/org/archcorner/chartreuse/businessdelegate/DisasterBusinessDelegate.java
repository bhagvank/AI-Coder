/**
 * 
 */
package org.archcorner.chartreuse.businessdelegate;

import java.util.List;

import org.archcorner.chartreuse.dal.dao.DisasterDAO;
import org.archcorner.chartreuse.pojo.Disaster;

/**
 * @author bhagvan_kommadi
 *
 */
public class DisasterBusinessDelegate {

	/**
	 * 
	 */
	public DisasterBusinessDelegate() {
		// TODO Auto-generated constructor stub
	}

	public void insertDisaster(Disaster disaster)
	{
		DisasterDAO disasterDAO = new DisasterDAO();
		disasterDAO.insertDisaster(disaster);
	}
	
	public void updateDisaster(Disaster disaster)
	{
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
	
	public List<Disaster> getAll()
	{
		DisasterDAO disasterDAO = new DisasterDAO();
		return disasterDAO.getDisasters();
	}
	
	public void deleteDisaster(Disaster disaster)
	{
		DisasterDAO disasterDAO = new DisasterDAO();
		disasterDAO.deleteDisaster(disaster);
	}
	
	public int getHighestId()
	{
		DisasterDAO disasterDAO = new DisasterDAO();
		return disasterDAO.getHighestId();
	}

}
