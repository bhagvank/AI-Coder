import java.util.List;
import org.archcorner.chartreuse.dal.dao.ExchangebillDAO;
import org.archcorner.chartreuse.pojo.Exchangebill;

public class ExchangebillBusinessDelegate{ 


private ExchangebillDAO exchangebillDAO ;

public int getHighestId()
 {
  exchangebillDAO = new ExchangebillDAO();
   int id=exchangebillDAO.getHighestId();
   return id;
 } 

public void insertExchangebill(Exchangebill exchangebill)
 {
  exchangebillDAO = new ExchangebillDAO();
  exchangebillDAO.insertExchangebill(exchangebill);
 } 

public void updateExchangebill(Exchangebill exchangebill)
 {
  exchangebillDAO = new ExchangebillDAO();
  exchangebillDAO.updateExchangebill(exchangebill);
 } 

public void deleteExchangebill(Exchangebill exchangebill)
 {
  exchangebillDAO = new ExchangebillDAO();
  exchangebillDAO.deleteExchangebill(exchangebill);
 } 

public Exchangebill  getExchangebillById(int exchangebillId)
 {
  exchangebillDAO = new ExchangebillDAO();
  Exchangebill exchangebill= exchangebillDAO.getExchangebillById(exchangebillId);
 return exchangebill;
 } 

public Exchangebill  getExchangebill(String exchangebillName)
 {
  exchangebillDAO = new ExchangebillDAO();
  Exchangebill exchangebill= exchangebillDAO.getExchangebill(exchangebillName);
 return exchangebill;
 } 

public List<Exchangebill>  getAll( )
 {
  exchangebillDAO = new ExchangebillDAO();
   List<Exchangebill>  exchangebills = exchangebillDAO.getExchangebills( );
 return exchangebills;
 } 

} 

