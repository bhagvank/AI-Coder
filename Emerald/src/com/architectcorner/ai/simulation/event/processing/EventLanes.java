/**
 * 
 */
package com.architectcorner.ai.simulation.event.processing;

import java.util.List;

/**
 * @author bhagvan.kommadi
 *
 */
public class EventLanes extends Event {

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
