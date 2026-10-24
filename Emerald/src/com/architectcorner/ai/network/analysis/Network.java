/**
 * 
 */
package com.architectcorner.ai.network.analysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author bhagvan.kommadi
 *
 */
public class Network {

	private List<String> entityNames;
	/**
	 * @return the entityNames
	 */
	public List<String> getEntityNames() {
		return entityNames;
	}
	/**
	 * @param entityNames the entityNames to set
	 */
	public void setEntityNames(List<String> entityNames) {
		this.entityNames = entityNames;
	}
	/**
	 * @return the entityTypes
	 */
	public List<String> getEntityTypes() {
		return entityTypes;
	}
	/**
	 * @param entityTypes the entityTypes to set
	 */
	public void setEntityTypes(List<String> entityTypes) {
		this.entityTypes = entityTypes;
	}
	/**
	 * @return the entityList
	 */
	public HashMap<String, List<String>> getEntityList() {
		return entityList;
	}
	/**
	 * @param entityList the entityList to set
	 */
	public void setEntityList(HashMap<String, List<String>> entityList) {
		this.entityList = entityList;
	}
	private List<String> entityTypes;
	private HashMap<String,List<String>> entityList;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Network network = new Network();
		
		List<String> entityNames = new ArrayList();
		entityNames.add("Person");
		entityNames.add("Place");
		entityNames.add("Product");
		entityNames.add("Company");
		entityNames.add("Country");
		entityNames.add("State");
		
		network.setEntityNames(entityNames);
		
		HashMap<String,List<String>> entityList = new HashMap();
		
		List<String> persons = new ArrayList();
		persons.add("John Smith");
		persons.add("Donald Trump");
		persons.add("Hillary Clinton");
		
		List<String> places = new ArrayList();
		places.add("Atlanta");
		places.add("Washington D.C.");
		places.add("Chicago");
		
		
		entityList.put("Person", persons);
		entityList.put("Place", places);
		
		network.setEntityList(entityList);
		
		
	}

}
