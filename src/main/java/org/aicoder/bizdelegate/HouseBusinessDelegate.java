package org.aicoder.bizdelegate;
import java.util.List;
import org.archcorner.chartreuse.dal.dao.HouseDAO;
import org.archcorner.chartreuse.pojo.House;

public class HouseBusinessDelegate{ 


private HouseDAO houseDAO ;

public int getHighestId()
 {
  houseDAO = new HouseDAO();
   int id=houseDAO.getHighestId();
   return id;
 } 

public void insertHouse(House house)
 {
  houseDAO = new HouseDAO();
  houseDAO.insertHouse(house);
 } 

public void updateHouse(House house)
 {
  houseDAO = new HouseDAO();
  houseDAO.updateHouse(house);
 } 

public void deleteHouse(House house)
 {
  houseDAO = new HouseDAO();
  houseDAO.deleteHouse(house);
 } 

public House  getHouseById(int houseId)
 {
  houseDAO = new HouseDAO();
  House house= houseDAO.getHouseById(houseId);
 return house;
 } 

public House  getHouse(String houseName)
 {
  houseDAO = new HouseDAO();
  House house= houseDAO.getHouse(houseName);
 return house;
 } 

public List<House>  getAll( )
 {
  houseDAO = new HouseDAO();
   List<House>  houses = houseDAO.getHouses( );
 return houses;
 } 

} 

