import java.util.List;
import org.archcorner.chartreuse.dal.dao.EstateDAO;
import org.archcorner.chartreuse.pojo.Estate;

public class EstateBusinessDelegate{ 


private EstateDAO estateDAO ;

public int getHighestId()
 {
  estateDAO = new EstateDAO();
   int id=estateDAO.getHighestId();
   return id;
 } 

public void insertEstate(Estate estate)
 {
  estateDAO = new EstateDAO();
  estateDAO.insertEstate(estate);
 } 

public void updateEstate(Estate estate)
 {
  estateDAO = new EstateDAO();
  estateDAO.updateEstate(estate);
 } 

public void deleteEstate(Estate estate)
 {
  estateDAO = new EstateDAO();
  estateDAO.deleteEstate(estate);
 } 

public Estate  getEstateById(int estateId)
 {
  estateDAO = new EstateDAO();
  Estate estate= estateDAO.getEstateById(estateId);
 return estate;
 } 

public Estate  getEstate(String estateName)
 {
  estateDAO = new EstateDAO();
  Estate estate= estateDAO.getEstate(estateName);
 return estate;
 } 

public List<Estate>  getAll( )
 {
  estateDAO = new EstateDAO();
   List<Estate>  estates = estateDAO.getEstates( );
 return estates;
 } 

} 

