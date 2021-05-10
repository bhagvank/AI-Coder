import java.util.List;
import org.archcorner.chartreuse.dal.dao.AreaDAO;
import org.archcorner.chartreuse.pojo.Area;

public class AreaBusinessDelegate{ 


private AreaDAO areaDAO ;

public int getHighestId()
 {
  areaDAO = new AreaDAO();
   int id=areaDAO.getHighestId();
   return id;
 } 

public void insertArea(Area area)
 {
  areaDAO = new AreaDAO();
  areaDAO.insertArea(area);
 } 

public void updateArea(Area area)
 {
  areaDAO = new AreaDAO();
  areaDAO.updateArea(area);
 } 

public void deleteArea(Area area)
 {
  areaDAO = new AreaDAO();
  areaDAO.deleteArea(area);
 } 

public Area  getAreaById(int areaId)
 {
  areaDAO = new AreaDAO();
  Area area= areaDAO.getAreaById(areaId);
 return area;
 } 

public Area  getArea(String areaName)
 {
  areaDAO = new AreaDAO();
  Area area= areaDAO.getArea(areaName);
 return area;
 } 

public List<Area>  getAll( )
 {
  areaDAO = new AreaDAO();
   List<Area>  areas = areaDAO.getAreas( );
 return areas;
 } 

} 

