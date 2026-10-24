/**
 * 
 */
package com.architectcorner.ai.simulation.event.processing;

/**
 * @author bhagvan.kommadi
 *
 */
public enum EventType {
	ACTION("Print","Output"),
	DISPLAY("Content","Image");
	
	private final String behavior;
	/**
	 * @return the behavior
	 */
	public String getBehavior() {
		return behavior;
	}
	/**
	 * @return the entity
	 */
	public String getEntity() {
		return entity;
	}
	private final String entity;
	EventType(String behavior,String entity )
	{
		this.behavior = behavior;
		this.entity = entity;
	}
	

}
