import java.util.List;
import org.archcorner.chartreuse.dal.dao.AttendingDAO;
import org.archcorner.chartreuse.pojo.Attending;

public class AttendingBusinessDelegate{ 


private AttendingDAO attendingDAO ;

public int getHighestId()
 {
  attendingDAO = new AttendingDAO();
   int id=attendingDAO.getHighestId();
   return id;
 } 

public void insertAttending(Attending attending)
 {
  attendingDAO = new AttendingDAO();
  attendingDAO.insertAttending(attending);
 } 

public void updateAttending(Attending attending)
 {
  attendingDAO = new AttendingDAO();
  attendingDAO.updateAttending(attending);
 } 

public void deleteAttending(Attending attending)
 {
  attendingDAO = new AttendingDAO();
  attendingDAO.deleteAttending(attending);
 } 

public Attending  getAttendingById(int attendingId)
 {
  attendingDAO = new AttendingDAO();
  Attending attending= attendingDAO.getAttendingById(attendingId);
 return attending;
 } 

public Attending  getAttending(String attendingName)
 {
  attendingDAO = new AttendingDAO();
  Attending attending= attendingDAO.getAttending(attendingName);
 return attending;
 } 

public List<Attending>  getAll( )
 {
  attendingDAO = new AttendingDAO();
   List<Attending>  attendings = attendingDAO.getAttendings( );
 return attendings;
 } 

} 

