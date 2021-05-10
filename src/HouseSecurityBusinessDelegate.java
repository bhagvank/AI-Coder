import java.util.List;
import org.archcorner.chartreuse.dal.dao.HouseSecurityDAO;
import org.archcorner.chartreuse.pojo.HouseSecurity;

public class HouseSecurityBusinessDelegate{ 


private HouseSecurityDAO housesecurityDAO ;

public int getHighestId()
 {
  housesecurityDAO = new HouseSecurityDAO();
   int id=housesecurityDAO.getHighestId();
   return id;
 } 

public void insertHouseSecurity(HouseSecurity housesecurity)
 {
  housesecurityDAO = new HouseSecurityDAO();
  housesecurityDAO.insertHouseSecurity(housesecurity);
 } 

public void updateHouseSecurity(HouseSecurity housesecurity)
 {
  housesecurityDAO = new HouseSecurityDAO();
  housesecurityDAO.updateHouseSecurity(housesecurity);
 } 

public void deleteHouseSecurity(HouseSecurity housesecurity)
 {
  housesecurityDAO = new HouseSecurityDAO();
  housesecurityDAO.deleteHouseSecurity(housesecurity);
 } 

public HouseSecurity  getHouseSecurityById(int housesecurityId)
 {
  housesecurityDAO = new HouseSecurityDAO();
  HouseSecurity housesecurity= housesecurityDAO.getHouseSecurityById(housesecurityId);
 return housesecurity;
 } 

public HouseSecurity  getHouseSecurity(String housesecurityName)
 {
  housesecurityDAO = new HouseSecurityDAO();
  HouseSecurity housesecurity= housesecurityDAO.getHouseSecurity(housesecurityName);
 return housesecurity;
 } 

public List<HouseSecurity>  getAll( )
 {
  housesecurityDAO = new HouseSecurityDAO();
   List<HouseSecurity>  housesecuritys = housesecurityDAO.getHouseSecuritys( );
 return housesecuritys;
 } 

} 

