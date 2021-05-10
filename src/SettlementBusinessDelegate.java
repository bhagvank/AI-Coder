import java.util.List;
import org.archcorner.chartreuse.dal.dao.SettlementDAO;
import org.archcorner.chartreuse.pojo.Settlement;

public class SettlementBusinessDelegate{ 


private SettlementDAO settlementDAO ;

public int getHighestId()
 {
  settlementDAO = new SettlementDAO();
   int id=settlementDAO.getHighestId();
   return id;
 } 

public void insertSettlement(Settlement settlement)
 {
  settlementDAO = new SettlementDAO();
  settlementDAO.insertSettlement(settlement);
 } 

public void updateSettlement(Settlement settlement)
 {
  settlementDAO = new SettlementDAO();
  settlementDAO.updateSettlement(settlement);
 } 

public void deleteSettlement(Settlement settlement)
 {
  settlementDAO = new SettlementDAO();
  settlementDAO.deleteSettlement(settlement);
 } 

public Settlement  getSettlementById(int settlementId)
 {
  settlementDAO = new SettlementDAO();
  Settlement settlement= settlementDAO.getSettlementById(settlementId);
 return settlement;
 } 

public Settlement  getSettlement(String settlementName)
 {
  settlementDAO = new SettlementDAO();
  Settlement settlement= settlementDAO.getSettlement(settlementName);
 return settlement;
 } 

public List<Settlement>  getAll( )
 {
  settlementDAO = new SettlementDAO();
   List<Settlement>  settlements = settlementDAO.getSettlements( );
 return settlements;
 } 

} 

