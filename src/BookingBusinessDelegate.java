import java.util.List;
import org.archcorner.chartreuse.dal.dao.BookingDAO;
import org.archcorner.chartreuse.pojo.Booking;

public class BookingBusinessDelegate{ 


private BookingDAO bookingDAO ;

public int getHighestId()
 {
  bookingDAO = new BookingDAO();
   int id=bookingDAO.getHighestId();
   return id;
 } 

public void insertBooking(Booking booking)
 {
  bookingDAO = new BookingDAO();
  bookingDAO.insertBooking(booking);
 } 

public void updateBooking(Booking booking)
 {
  bookingDAO = new BookingDAO();
  bookingDAO.updateBooking(booking);
 } 

public void deleteBooking(Booking booking)
 {
  bookingDAO = new BookingDAO();
  bookingDAO.deleteBooking(booking);
 } 

public Booking  getBookingById(int bookingId)
 {
  bookingDAO = new BookingDAO();
  Booking booking= bookingDAO.getBookingById(bookingId);
 return booking;
 } 

public Booking  getBooking(String bookingName)
 {
  bookingDAO = new BookingDAO();
  Booking booking= bookingDAO.getBooking(bookingName);
 return booking;
 } 

public List<Booking>  getAll( )
 {
  bookingDAO = new BookingDAO();
   List<Booking>  bookings = bookingDAO.getBookings( );
 return bookings;
 } 

} 

