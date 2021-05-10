import java.util.List;
import org.archcorner.chartreuse.dal.dao.CoverageDAO;
import org.archcorner.chartreuse.pojo.Coverage;

public class CoverageBusinessDelegate{ 


private CoverageDAO coverageDAO ;

public int getHighestId()
 {
  coverageDAO = new CoverageDAO();
   int id=coverageDAO.getHighestId();
   return id;
 } 

public void insertCoverage(Coverage coverage)
 {
  coverageDAO = new CoverageDAO();
  coverageDAO.insertCoverage(coverage);
 } 

public void updateCoverage(Coverage coverage)
 {
  coverageDAO = new CoverageDAO();
  coverageDAO.updateCoverage(coverage);
 } 

public void deleteCoverage(Coverage coverage)
 {
  coverageDAO = new CoverageDAO();
  coverageDAO.deleteCoverage(coverage);
 } 

public Coverage  getCoverageById(int coverageId)
 {
  coverageDAO = new CoverageDAO();
  Coverage coverage= coverageDAO.getCoverageById(coverageId);
 return coverage;
 } 

public Coverage  getCoverage(String coverageName)
 {
  coverageDAO = new CoverageDAO();
  Coverage coverage= coverageDAO.getCoverage(coverageName);
 return coverage;
 } 

public List<Coverage>  getAll( )
 {
  coverageDAO = new CoverageDAO();
   List<Coverage>  coverages = coverageDAO.getCoverages( );
 return coverages;
 } 

} 

