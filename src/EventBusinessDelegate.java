import java.util.List;
import org.archcorner.chartreuse.dal.dao.EventDAO;
import org.archcorner.chartreuse.pojo.Event;

public class EventBusinessDelegate{ 


private EventDAO eventDAO ;

public int getHighestId()
 {
  eventDAO = new EventDAO();
   int id=eventDAO.getHighestId();
   return id;
 } 

public void insertEvent(Event event)
 {
  eventDAO = new EventDAO();
  eventDAO.insertEvent(event);
 } 

public void updateEvent(Event event)
 {
  eventDAO = new EventDAO();
  eventDAO.updateEvent(event);
 } 

public void deleteEvent(Event event)
 {
  eventDAO = new EventDAO();
  eventDAO.deleteEvent(event);
 } 

public Event  getEventById(int eventId)
 {
  eventDAO = new EventDAO();
  Event event= eventDAO.getEventById(eventId);
 return event;
 } 

public Event  getEvent(String eventName)
 {
  eventDAO = new EventDAO();
  Event event= eventDAO.getEvent(eventName);
 return event;
 } 

public List<Event>  getAll( )
 {
  eventDAO = new EventDAO();
   List<Event>  events = eventDAO.getEvents( );
 return events;
 } 

} 

