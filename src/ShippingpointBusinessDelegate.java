import java.util.List;
import org.archcorner.chartreuse.dal.dao.ShippingpointDAO;
import org.archcorner.chartreuse.pojo.Shippingpoint;

public class ShippingpointBusinessDelegate{ 


private ShippingpointDAO shippingpointDAO ;

public int getHighestId()
 {
  shippingpointDAO = new ShippingpointDAO();
   int id=shippingpointDAO.getHighestId();
   return id;
 } 

public void insertShippingpoint(Shippingpoint shippingpoint)
 {
  shippingpointDAO = new ShippingpointDAO();
  shippingpointDAO.insertShippingpoint(shippingpoint);
 } 

public void updateShippingpoint(Shippingpoint shippingpoint)
 {
  shippingpointDAO = new ShippingpointDAO();
  shippingpointDAO.updateShippingpoint(shippingpoint);
 } 

public void deleteShippingpoint(Shippingpoint shippingpoint)
 {
  shippingpointDAO = new ShippingpointDAO();
  shippingpointDAO.deleteShippingpoint(shippingpoint);
 } 

public Shippingpoint  getShippingpointById(int shippingpointId)
 {
  shippingpointDAO = new ShippingpointDAO();
  Shippingpoint shippingpoint= shippingpointDAO.getShippingpointById(shippingpointId);
 return shippingpoint;
 } 

public Shippingpoint  getShippingpoint(String shippingpointName)
 {
  shippingpointDAO = new ShippingpointDAO();
  Shippingpoint shippingpoint= shippingpointDAO.getShippingpoint(shippingpointName);
 return shippingpoint;
 } 

public List<Shippingpoint>  getAll( )
 {
  shippingpointDAO = new ShippingpointDAO();
   List<Shippingpoint>  shippingpoints = shippingpointDAO.getShippingpoints( );
 return shippingpoints;
 } 

} 

