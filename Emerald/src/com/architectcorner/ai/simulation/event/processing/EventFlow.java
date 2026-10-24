/**
 * 
 */
package com.architectcorner.ai.simulation.event.processing;

import java.util.List;

import com.architectcorner.ai.simulation.event.management.EventResource;

/**
 * @author bhagvan.kommadi
 *
 */
public class EventFlow extends Event {
	
	private List<Event> eventList;

	/**
	 * @return the eventList
	 */
	public List<Event> getEventList() {
		return eventList;
	}

	/**
	 * @param eventList the eventList to set
	 */
	public void setEventList(List<Event> eventList) {
		this.eventList = eventList;
	}
	

	

}
