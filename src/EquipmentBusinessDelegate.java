import java.util.List;
import org.archcorner.chartreuse.dal.dao.EquipmentDAO;
import org.archcorner.chartreuse.pojo.Equipment;

public class EquipmentBusinessDelegate{ 


private EquipmentDAO equipmentDAO ;

public int getHighestId()
 {
  equipmentDAO = new EquipmentDAO();
   int id=equipmentDAO.getHighestId();
   return id;
 } 

public void insertEquipment(Equipment equipment)
 {
  equipmentDAO = new EquipmentDAO();
  equipmentDAO.insertEquipment(equipment);
 } 

public void updateEquipment(Equipment equipment)
 {
  equipmentDAO = new EquipmentDAO();
  equipmentDAO.updateEquipment(equipment);
 } 

public void deleteEquipment(Equipment equipment)
 {
  equipmentDAO = new EquipmentDAO();
  equipmentDAO.deleteEquipment(equipment);
 } 

public Equipment  getEquipmentById(int equipmentId)
 {
  equipmentDAO = new EquipmentDAO();
  Equipment equipment= equipmentDAO.getEquipmentById(equipmentId);
 return equipment;
 } 

public Equipment  getEquipment(String equipmentName)
 {
  equipmentDAO = new EquipmentDAO();
  Equipment equipment= equipmentDAO.getEquipment(equipmentName);
 return equipment;
 } 

public List<Equipment>  getAll( )
 {
  equipmentDAO = new EquipmentDAO();
   List<Equipment>  equipments = equipmentDAO.getEquipments( );
 return equipments;
 } 

} 

