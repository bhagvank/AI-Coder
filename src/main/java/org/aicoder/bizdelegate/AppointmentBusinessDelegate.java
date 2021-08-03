package org.aicoder.bizdelegate;
import java.util.List;
import org.archcorner.chartreuse.dal.dao.AppointmentDAO;
import org.archcorner.chartreuse.pojo.Appointment;

public class AppointmentBusinessDelegate{ 


private AppointmentDAO appointmentDAO ;

public int getHighestId()
 {
  appointmentDAO = new AppointmentDAO();
   int id=appointmentDAO.getHighestId();
   return id;
 } 

public void insertAppointment(Appointment appointment)
 {
  appointmentDAO = new AppointmentDAO();
  appointmentDAO.insertAppointment(appointment);
 } 

public void updateAppointment(Appointment appointment)
 {
  appointmentDAO = new AppointmentDAO();
  appointmentDAO.updateAppointment(appointment);
 } 

public void deleteAppointment(Appointment appointment)
 {
  appointmentDAO = new AppointmentDAO();
  appointmentDAO.deleteAppointment(appointment);
 } 

public Appointment  getAppointmentById(int appointmentId)
 {
  appointmentDAO = new AppointmentDAO();
  Appointment appointment= appointmentDAO.getAppointmentById(appointmentId);
 return appointment;
 } 

public Appointment  getAppointment(String appointmentName)
 {
  appointmentDAO = new AppointmentDAO();
  Appointment appointment= appointmentDAO.getAppointment(appointmentName);
 return appointment;
 } 

public List<Appointment>  getAll( )
 {
  appointmentDAO = new AppointmentDAO();
   List<Appointment>  appointments = appointmentDAO.getAppointments( );
 return appointments;
 } 

} 

