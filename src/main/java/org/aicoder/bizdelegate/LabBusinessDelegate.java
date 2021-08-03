package org.aicoder.bizdelegate;
import java.util.List;
import org.archcorner.chartreuse.dal.dao.LabDAO;
import org.archcorner.chartreuse.pojo.Lab;

public class LabBusinessDelegate{ 


private LabDAO labDAO ;

public int getHighestId()
 {
  labDAO = new LabDAO();
   int id=labDAO.getHighestId();
   return id;
 } 

public void insertLab(Lab lab)
 {
  labDAO = new LabDAO();
  labDAO.insertLab(lab);
 } 

public void updateLab(Lab lab)
 {
  labDAO = new LabDAO();
  labDAO.updateLab(lab);
 } 

public void deleteLab(Lab lab)
 {
  labDAO = new LabDAO();
  labDAO.deleteLab(lab);
 } 

public Lab  getLabById(int labId)
 {
  labDAO = new LabDAO();
  Lab lab= labDAO.getLabById(labId);
 return lab;
 } 

public Lab  getLab(String labName)
 {
  labDAO = new LabDAO();
  Lab lab= labDAO.getLab(labName);
 return lab;
 } 

public List<Lab>  getAll( )
 {
  labDAO = new LabDAO();
   List<Lab>  labs = labDAO.getLabs( );
 return labs;
 } 

} 

