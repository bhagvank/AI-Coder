import java.util.List;
import org.archcorner.chartreuse.dal.dao.ArchitectDAO;
import org.archcorner.chartreuse.pojo.Architect;

public class ArchitectBusinessDelegate{ 


private ArchitectDAO architectDAO ;

public int getHighestId()
 {
  architectDAO = new ArchitectDAO();
   int id=architectDAO.getHighestId();
   return id;
 } 

public void insertArchitect(Architect architect)
 {
  architectDAO = new ArchitectDAO();
  architectDAO.insertArchitect(architect);
 } 

public void updateArchitect(Architect architect)
 {
  architectDAO = new ArchitectDAO();
  architectDAO.updateArchitect(architect);
 } 

public void deleteArchitect(Architect architect)
 {
  architectDAO = new ArchitectDAO();
  architectDAO.deleteArchitect(architect);
 } 

public Architect  getArchitectById(int architectId)
 {
  architectDAO = new ArchitectDAO();
  Architect architect= architectDAO.getArchitectById(architectId);
 return architect;
 } 

public Architect  getArchitect(String architectName)
 {
  architectDAO = new ArchitectDAO();
  Architect architect= architectDAO.getArchitect(architectName);
 return architect;
 } 

public List<Architect>  getAll( )
 {
  architectDAO = new ArchitectDAO();
   List<Architect>  architects = architectDAO.getArchitects( );
 return architects;
 } 

} 

