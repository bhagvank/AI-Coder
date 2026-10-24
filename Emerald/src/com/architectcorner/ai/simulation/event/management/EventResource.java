/**
 * 
 */
package com.architectcorner.ai.simulation.event.management;

/**
 * @author bhagvan.kommadi
 *
 */
public class EventResource {

	 /**
	 * @return the eventResourceName
	 */
	public String getEventResourceName() {
		return eventResourceName;
	}
	/**
	 * @param eventResourceName the eventResourceName to set
	 */
	public void setEventResourceName(String eventResourceName) {
		this.eventResourceName = eventResourceName;
	}
	/**
	 * @return the eventResourceType
	 */
	public String getEventResourceType() {
		return eventResourceType;
	}
	/**
	 * @param eventResourceType the eventResourceType to set
	 */
	public void setEventResourceType(String eventResourceType) {
		this.eventResourceType = eventResourceType;
	}
	private String eventResourceName;
	 private String eventResourceType;
	 
}
