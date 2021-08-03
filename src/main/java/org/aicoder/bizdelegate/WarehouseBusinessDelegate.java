package org.aicoder.bizdelegate;
import java.util.List;
import org.archcorner.chartreuse.dal.dao.WarehouseDAO;
import org.archcorner.chartreuse.pojo.Warehouse;

public class WarehouseBusinessDelegate{ 


private WarehouseDAO warehouseDAO ;

public int getHighestId()
 {
  warehouseDAO = new WarehouseDAO();
   int id=warehouseDAO.getHighestId();
   return id;
 } 

public void insertWarehouse(Warehouse warehouse)
 {
  warehouseDAO = new WarehouseDAO();
  warehouseDAO.insertWarehouse(warehouse);
 } 

public void updateWarehouse(Warehouse warehouse)
 {
  warehouseDAO = new WarehouseDAO();
  warehouseDAO.updateWarehouse(warehouse);
 } 

public void deleteWarehouse(Warehouse warehouse)
 {
  warehouseDAO = new WarehouseDAO();
  warehouseDAO.deleteWarehouse(warehouse);
 } 

public Warehouse  getWarehouseById(int warehouseId)
 {
  warehouseDAO = new WarehouseDAO();
  Warehouse warehouse= warehouseDAO.getWarehouseById(warehouseId);
 return warehouse;
 } 

public Warehouse  getWarehouse(String warehouseName)
 {
  warehouseDAO = new WarehouseDAO();
  Warehouse warehouse= warehouseDAO.getWarehouse(warehouseName);
 return warehouse;
 } 

public List<Warehouse>  getAll( )
 {
  warehouseDAO = new WarehouseDAO();
   List<Warehouse>  warehouses = warehouseDAO.getWarehouses( );
 return warehouses;
 } 

} 

