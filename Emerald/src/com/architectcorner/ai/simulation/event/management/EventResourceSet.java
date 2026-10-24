/**
 * 
 */
package com.architectcorner.ai.simulation.event.management;

import java.util.List;

/**
 * @author bhagvan.kommadi
 *
 */
public class EventResourceSet extends EventResource{

	private List<EventResource> eventResources;

	/**
	 * @return the eventResources
	 */
	public List<EventResource> getEventResources() {
		return eventResources;
	}

	/**
	 * @param eventResources the eventResources to set
	 */
	public void setEventResources(List<EventResource> eventResources) {
		this.eventResources = eventResources;
	}
}
