import java.util.List;
import org.archcorner.chartreuse.dal.dao.CareteamDAO;
import org.archcorner.chartreuse.pojo.Careteam;

public class CareteamBusinessDelegate{ 


private CareteamDAO careteamDAO ;

public int getHighestId()
 {
  careteamDAO = new CareteamDAO();
   int id=careteamDAO.getHighestId();
   return id;
 } 

public void insertCareteam(Careteam careteam)
 {
  careteamDAO = new CareteamDAO();
  careteamDAO.insertCareteam(careteam);
 } 

public void updateCareteam(Careteam careteam)
 {
  careteamDAO = new CareteamDAO();
  careteamDAO.updateCareteam(careteam);
 } 

public void deleteCareteam(Careteam careteam)
 {
  careteamDAO = new CareteamDAO();
  careteamDAO.deleteCareteam(careteam);
 } 

public Careteam  getCareteamById(int careteamId)
 {
  careteamDAO = new CareteamDAO();
  Careteam careteam= careteamDAO.getCareteamById(careteamId);
 return careteam;
 } 

public Careteam  getCareteam(String careteamName)
 {
  careteamDAO = new CareteamDAO();
  Careteam careteam= careteamDAO.getCareteam(careteamName);
 return careteam;
 } 

public List<Careteam>  getAll( )
 {
  careteamDAO = new CareteamDAO();
   List<Careteam>  careteams = careteamDAO.getCareteams( );
 return careteams;
 } 

} 

