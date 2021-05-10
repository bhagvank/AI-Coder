import java.util.List;
import org.archcorner.chartreuse.dal.dao.ClubDAO;
import org.archcorner.chartreuse.pojo.Club;

public class ClubBusinessDelegate{ 


private ClubDAO clubDAO ;

public int getHighestId()
 {
  clubDAO = new ClubDAO();
   int id=clubDAO.getHighestId();
   return id;
 } 

public void insertClub(Club club)
 {
  clubDAO = new ClubDAO();
  clubDAO.insertClub(club);
 } 

public void updateClub(Club club)
 {
  clubDAO = new ClubDAO();
  clubDAO.updateClub(club);
 } 

public void deleteClub(Club club)
 {
  clubDAO = new ClubDAO();
  clubDAO.deleteClub(club);
 } 

public Club  getClubById(int clubId)
 {
  clubDAO = new ClubDAO();
  Club club= clubDAO.getClubById(clubId);
 return club;
 } 

public Club  getClub(String clubName)
 {
  clubDAO = new ClubDAO();
  Club club= clubDAO.getClub(clubName);
 return club;
 } 

public List<Club>  getAll( )
 {
  clubDAO = new ClubDAO();
   List<Club>  clubs = clubDAO.getClubs( );
 return clubs;
 } 

} 

