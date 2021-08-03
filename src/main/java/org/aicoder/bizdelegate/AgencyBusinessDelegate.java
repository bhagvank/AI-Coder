package org.aicoder.bizdelegate;
import java.util.List;
import org.archcorner.chartreuse.dal.dao.AgencyDAO;
import org.archcorner.chartreuse.pojo.Agency;

public class AgencyBusinessDelegate{ 


private AgencyDAO agencyDAO ;

public int getHighestId()
 {
  agencyDAO = new AgencyDAO();
   int id=agencyDAO.getHighestId();
   return id;
 } 

public void insertAgency(Agency agency)
 {
  agencyDAO = new AgencyDAO();
  agencyDAO.insertAgency(agency);
 } 

public void updateAgency(Agency agency)
 {
  agencyDAO = new AgencyDAO();
  agencyDAO.updateAgency(agency);
 } 

public void deleteAgency(Agency agency)
 {
  agencyDAO = new AgencyDAO();
  agencyDAO.deleteAgency(agency);
 } 

public Agency  getAgencyById(int agencyId)
 {
  agencyDAO = new AgencyDAO();
  Agency agency= agencyDAO.getAgencyById(agencyId);
 return agency;
 } 

public Agency  getAgency(String agencyName)
 {
  agencyDAO = new AgencyDAO();
  Agency agency= agencyDAO.getAgency(agencyName);
 return agency;
 } 

public List<Agency>  getAll( )
 {
  agencyDAO = new AgencyDAO();
   List<Agency>  agencys = agencyDAO.getAgencys( );
 return agencys;
 } 

} 

