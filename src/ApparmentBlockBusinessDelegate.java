import java.util.List;
import org.archcorner.chartreuse.dal.dao.ApparmentBlockDAO;
import org.archcorner.chartreuse.pojo.ApparmentBlock;

public class ApparmentBlockBusinessDelegate{ 


private ApparmentBlockDAO apparmentblockDAO ;

public int getHighestId()
 {
  apparmentblockDAO = new ApparmentBlockDAO();
   int id=apparmentblockDAO.getHighestId();
   return id;
 } 

public void insertApparmentBlock(ApparmentBlock apparmentblock)
 {
  apparmentblockDAO = new ApparmentBlockDAO();
  apparmentblockDAO.insertApparmentBlock(apparmentblock);
 } 

public void updateApparmentBlock(ApparmentBlock apparmentblock)
 {
  apparmentblockDAO = new ApparmentBlockDAO();
  apparmentblockDAO.updateApparmentBlock(apparmentblock);
 } 

public void deleteApparmentBlock(ApparmentBlock apparmentblock)
 {
  apparmentblockDAO = new ApparmentBlockDAO();
  apparmentblockDAO.deleteApparmentBlock(apparmentblock);
 } 

public ApparmentBlock  getApparmentBlockById(int apparmentblockId)
 {
  apparmentblockDAO = new ApparmentBlockDAO();
  ApparmentBlock apparmentblock= apparmentblockDAO.getApparmentBlockById(apparmentblockId);
 return apparmentblock;
 } 

public ApparmentBlock  getApparmentBlock(String apparmentblockName)
 {
  apparmentblockDAO = new ApparmentBlockDAO();
  ApparmentBlock apparmentblock= apparmentblockDAO.getApparmentBlock(apparmentblockName);
 return apparmentblock;
 } 

public List<ApparmentBlock>  getAll( )
 {
  apparmentblockDAO = new ApparmentBlockDAO();
   List<ApparmentBlock>  apparmentblocks = apparmentblockDAO.getApparmentBlocks( );
 return apparmentblocks;
 } 

} 

