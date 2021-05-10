import java.util.List;
import org.archcorner.chartreuse.dal.dao.LocationDAO;
import org.archcorner.chartreuse.pojo.Location;

public class LocationBusinessDelegate{ 


private LocationDAO locationDAO ;

public int getHighestId()
 {
  locationDAO = new LocationDAO();
   int id=locationDAO.getHighestId();
   return id;
 } 

public void insertLocation(Location location)
 {
  locationDAO = new LocationDAO();
  locationDAO.insertLocation(location);
 } 

public void updateLocation(Location location)
 {
  locationDAO = new LocationDAO();
  locationDAO.updateLocation(location);
 } 

public void deleteLocation(Location location)
 {
  locationDAO = new LocationDAO();
  locationDAO.deleteLocation(location);
 } 

public Location  getLocationById(int locationId)
 {
  locationDAO = new LocationDAO();
  Location location= locationDAO.getLocationById(locationId);
 return location;
 } 

public Location  getLocation(String locationName)
 {
  locationDAO = new LocationDAO();
  Location location= locationDAO.getLocation(locationName);
 return location;
 } 

public List<Location>  getAll( )
 {
  locationDAO = new LocationDAO();
   List<Location>  locations = locationDAO.getLocations( );
 return locations;
 } 

} 

