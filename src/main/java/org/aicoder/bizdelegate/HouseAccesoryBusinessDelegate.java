package org.aicoder.bizdelegate;
import java.util.List;
import org.archcorner.chartreuse.dal.dao.HouseAccesoryDAO;
import org.archcorner.chartreuse.pojo.HouseAccesory;

public class HouseAccesoryBusinessDelegate{ 


private HouseAccesoryDAO houseaccesoryDAO ;

public int getHighestId()
 {
  houseaccesoryDAO = new HouseAccesoryDAO();
   int id=houseaccesoryDAO.getHighestId();
   return id;
 } 

public void insertHouseAccesory(HouseAccesory houseaccesory)
 {
  houseaccesoryDAO = new HouseAccesoryDAO();
  houseaccesoryDAO.insertHouseAccesory(houseaccesory);
 } 

public void updateHouseAccesory(HouseAccesory houseaccesory)
 {
  houseaccesoryDAO = new HouseAccesoryDAO();
  houseaccesoryDAO.updateHouseAccesory(houseaccesory);
 } 

public void deleteHouseAccesory(HouseAccesory houseaccesory)
 {
  houseaccesoryDAO = new HouseAccesoryDAO();
  houseaccesoryDAO.deleteHouseAccesory(houseaccesory);
 } 

public HouseAccesory  getHouseAccesoryById(int houseaccesoryId)
 {
  houseaccesoryDAO = new HouseAccesoryDAO();
  HouseAccesory houseaccesory= houseaccesoryDAO.getHouseAccesoryById(houseaccesoryId);
 return houseaccesory;
 } 

public HouseAccesory  getHouseAccesory(String houseaccesoryName)
 {
  houseaccesoryDAO = new HouseAccesoryDAO();
  HouseAccesory houseaccesory= houseaccesoryDAO.getHouseAccesory(houseaccesoryName);
 return houseaccesory;
 } 

public List<HouseAccesory>  getAll( )
 {
  houseaccesoryDAO = new HouseAccesoryDAO();
   List<HouseAccesory>  houseaccesorys = houseaccesoryDAO.getHouseAccesorys( );
 return houseaccesorys;
 } 

} 

