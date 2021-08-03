package org.aicoder.bizdelegate;
import java.util.List;
import org.archcorner.chartreuse.dal.dao.PositionDAO;
import org.archcorner.chartreuse.pojo.Position;

public class PositionBusinessDelegate{ 


private PositionDAO positionDAO ;

public int getHighestId()
 {
  positionDAO = new PositionDAO();
   int id=positionDAO.getHighestId();
   return id;
 } 

public void insertPosition(Position position)
 {
  positionDAO = new PositionDAO();
  positionDAO.insertPosition(position);
 } 

public void updatePosition(Position position)
 {
  positionDAO = new PositionDAO();
  positionDAO.updatePosition(position);
 } 

public void deletePosition(Position position)
 {
  positionDAO = new PositionDAO();
  positionDAO.deletePosition(position);
 } 

public Position  getPositionById(int positionId)
 {
  positionDAO = new PositionDAO();
  Position position= positionDAO.getPositionById(positionId);
 return position;
 } 

public Position  getPosition(String positionName)
 {
  positionDAO = new PositionDAO();
  Position position= positionDAO.getPosition(positionName);
 return position;
 } 

public List<Position>  getAll( )
 {
  positionDAO = new PositionDAO();
   List<Position>  positions = positionDAO.getPositions( );
 return positions;
 } 

} 

