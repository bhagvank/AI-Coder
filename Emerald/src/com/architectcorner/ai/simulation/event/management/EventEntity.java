/**
 * 
 */
package com.architectcorner.ai.simulation.event.management;

/**
 * @author bhagvan.kommadi
 *
 */
public class EventEntity {
    
	private String entityName;
	/**
	 * @return the entityName
	 */
	public String getEntityName() {
		return entityName;
	}
	/**
	 * @param entityName the entityName to set
	 */
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	/**
	 * @return the entityType
	 */
	public String getEntityType() {
		return entityType;
	}
	/**
	 * @param entityType the entityType to set
	 */
	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}
	private String entityType;
}
