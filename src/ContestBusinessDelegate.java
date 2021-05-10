import java.util.List;
import org.archcorner.chartreuse.dal.dao.ContestDAO;
import org.archcorner.chartreuse.pojo.Contest;

public class ContestBusinessDelegate{ 


private ContestDAO contestDAO ;

public int getHighestId()
 {
  contestDAO = new ContestDAO();
   int id=contestDAO.getHighestId();
   return id;
 } 

public void insertContest(Contest contest)
 {
  contestDAO = new ContestDAO();
  contestDAO.insertContest(contest);
 } 

public void updateContest(Contest contest)
 {
  contestDAO = new ContestDAO();
  contestDAO.updateContest(contest);
 } 

public void deleteContest(Contest contest)
 {
  contestDAO = new ContestDAO();
  contestDAO.deleteContest(contest);
 } 

public Contest  getContestById(int contestId)
 {
  contestDAO = new ContestDAO();
  Contest contest= contestDAO.getContestById(contestId);
 return contest;
 } 

public Contest  getContest(String contestName)
 {
  contestDAO = new ContestDAO();
  Contest contest= contestDAO.getContest(contestName);
 return contest;
 } 

public List<Contest>  getAll( )
 {
  contestDAO = new ContestDAO();
   List<Contest>  contests = contestDAO.getContests( );
 return contests;
 } 

} 

