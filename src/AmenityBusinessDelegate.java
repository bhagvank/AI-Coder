import java.util.List;
import org.archcorner.chartreuse.dal.dao.AmenityDAO;
import org.archcorner.chartreuse.pojo.Amenity;

public class AmenityBusinessDelegate{ 


private AmenityDAO amenityDAO ;

public int getHighestId()
 {
  amenityDAO = new AmenityDAO();
   int id=amenityDAO.getHighestId();
   return id;
 } 

public void insertAmenity(Amenity amenity)
 {
  amenityDAO = new AmenityDAO();
  amenityDAO.insertAmenity(amenity);
 } 

public void updateAmenity(Amenity amenity)
 {
  amenityDAO = new AmenityDAO();
  amenityDAO.updateAmenity(amenity);
 } 

public void deleteAmenity(Amenity amenity)
 {
  amenityDAO = new AmenityDAO();
  amenityDAO.deleteAmenity(amenity);
 } 

public Amenity  getAmenityById(int amenityId)
 {
  amenityDAO = new AmenityDAO();
  Amenity amenity= amenityDAO.getAmenityById(amenityId);
 return amenity;
 } 

public Amenity  getAmenity(String amenityName)
 {
  amenityDAO = new AmenityDAO();
  Amenity amenity= amenityDAO.getAmenity(amenityName);
 return amenity;
 } 

public List<Amenity>  getAll( )
 {
  amenityDAO = new AmenityDAO();
   List<Amenity>  amenitys = amenityDAO.getAmenitys( );
 return amenitys;
 } 

} 

