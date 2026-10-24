/**
 * 
 */
package com.architectcorner.ai.simulation.manager;

import java.util.ArrayList;
import java.util.List;

import com.architectcorner.ai.simulation.event.management.EventEntity;
import com.architectcorner.ai.simulation.event.management.EventResource;
import com.architectcorner.ai.simulation.event.processing.Event;
import com.architectcorner.ai.simulation.event.processing.EventType;

/**
 * @author bhagvan.kommadi
 *
 */
public class SimulationManager {

	private List<Event> events;
	
	private List<EventEntity> eventEntities;
	
	/**
	 * @return the eventEntities
	 */
	public List<EventEntity> getEventEntities() {
		return eventEntities;
	}


	/**
	 * @param eventEntities the eventEntities to set
	 */
	public void setEventEntities(List<EventEntity> eventEntities) {
		this.eventEntities = eventEntities;
	}


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
	private List<EventResource> eventResources;
	
	/**
	 * @return the events
	 */
	public List<Event> getEvents() {
		return events;
	}


	/**
	 * @param events the events to set
	 */
	public void setEvents(List<Event> events) {
		this.events = events;
	}


	 public void start()
	 {
		 int i=0;
		 for(Event event: events)
		 {
			 
			 System.out.println(event.getDescription());
			 event.setTime(String.valueOf(System.currentTimeMillis()));
			 System.out.println("Processing event for :"+event.getTime());
			 
			 EventEntity entity = eventEntities.get(i);
			 EventResource resource = eventResources.get(i);
			 
			 if(entity != null)
			 {
			   System.out.println(eventEntities.get(i).getEntityName());
			 }
			 else
			 {
				 System.out.println("No Entity");
			 }
			 if(resource != null)
			 {
			   System.out.println(eventResources.get(i).getEventResourceName());
			 }
			 else
			 {
				 System.out.println("No Resource");
			 }
			 try
			 {
			  Thread.sleep(event.getDuration());
			 }
			 catch(Exception exception)
			 {
				 Thread.currentThread().interrupt();
			 }
			 
			 i++;
		 }
	 }
	 
	 public void processEvents()
	 {
		 
	 }
	 
	 public void stop()
	 {
		 
	 }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SimulationManager manager = new SimulationManager();
		
		
		EventEntity entity = new EventEntity();
		entity.setEntityName("Passenger1");
		entity.setEntityType("Human");
		
		EventResource resource = new EventResource();
		resource.setEventResourceName("Bus");
		resource.setEventResourceType("Transport");
		
		List<EventEntity> entities = new ArrayList();
		List<Event> events = new ArrayList();
		List<EventResource> resources = new ArrayList();
		
		Event event1 = new Event();
		event1.setName("PassengerEntry");
		event1.setDescription("Passenger enters the bus station");
		event1.setType(EventType.ACTION.toString());
		event1.setDuration(40);
		entities.add(entity);
		resources.add(null);
		
		Event event2 = new Event();
		event2.setName("BusEntry");
		event2.setDescription("Bus enters the station");
		event2.setType(EventType.ACTION.toString());
		event2.setDuration(30);
		entities.add(null);
		resources.add(resource);
		
		Event event3 = new Event();
		event3.setName("PassengerIntoBus");
		event3.setDescription("Passenger Enters into the Bus");
		event3.setType(EventType.ACTION.toString());
		event3.setDuration(50);
		entities.add(entity);
		resources.add(resource);
		
		Event event4 = new Event();
		event4.setName("PassengerBusMove");
		event4.setDescription("Bus Starts to Destination");
		event4.setType(EventType.ACTION.toString());
		event4.setDuration(60);
		entities.add(entity);
		resources.add(resource);
		
		events.add(event1);
		events.add(event2);
		events.add(event3);
		events.add(event4);
		
		
		manager.setEvents(events);
		manager.setEventEntities(entities);
		manager.setEventResources(resources);
		
		manager.start();

	}

}
