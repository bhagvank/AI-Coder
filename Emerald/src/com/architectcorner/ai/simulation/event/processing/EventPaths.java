/**
 * 
 */
package com.architectcorner.ai.simulation.event.processing;

import java.util.List;

/**
 * @author bhagvan.kommadi
 *
 */
public class EventPaths extends Event {

	private List<EventPath> eventPathList;

	/**
	 * @return the eventPathList
	 */
	public List<EventPath> getEventPathList() {
		return eventPathList;
	}

	/**
	 * @param eventPathList the eventPathList to set
	 */
	public void setEventPathList(List<EventPath> eventPathList) {
		this.eventPathList = eventPathList;
	}
	
}
