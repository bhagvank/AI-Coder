package org.aicoder.bizdelegate;
import java.util.List;
import org.archcorner.chartreuse.dal.dao.ScheduleDAO;
import org.archcorner.chartreuse.pojo.Schedule;

public class ScheduleBusinessDelegate{ 


private ScheduleDAO scheduleDAO ;

public int getHighestId()
 {
  scheduleDAO = new ScheduleDAO();
   int id=scheduleDAO.getHighestId();
   return id;
 } 

public void insertSchedule(Schedule schedule)
 {
  scheduleDAO = new ScheduleDAO();
  scheduleDAO.insertSchedule(schedule);
 } 

public void updateSchedule(Schedule schedule)
 {
  scheduleDAO = new ScheduleDAO();
  scheduleDAO.updateSchedule(schedule);
 } 

public void deleteSchedule(Schedule schedule)
 {
  scheduleDAO = new ScheduleDAO();
  scheduleDAO.deleteSchedule(schedule);
 } 

public Schedule  getScheduleById(int scheduleId)
 {
  scheduleDAO = new ScheduleDAO();
  Schedule schedule= scheduleDAO.getScheduleById(scheduleId);
 return schedule;
 } 

public Schedule  getSchedule(String scheduleName)
 {
  scheduleDAO = new ScheduleDAO();
  Schedule schedule= scheduleDAO.getSchedule(scheduleName);
 return schedule;
 } 

public List<Schedule>  getAll( )
 {
  scheduleDAO = new ScheduleDAO();
   List<Schedule>  schedules = scheduleDAO.getSchedules( );
 return schedules;
 } 

} 

