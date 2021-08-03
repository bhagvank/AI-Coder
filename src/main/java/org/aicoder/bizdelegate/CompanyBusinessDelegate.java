package org.aicoder.bizdelegate;
import java.util.List;
import org.archcorner.chartreuse.dal.dao.CompanyDAO;
import org.archcorner.chartreuse.pojo.Company;

public class CompanyBusinessDelegate{ 


private CompanyDAO companyDAO ;

public int getHighestId()
 {
  companyDAO = new CompanyDAO();
   int id=companyDAO.getHighestId();
   return id;
 } 

public void insertCompany(Company company)
 {
  companyDAO = new CompanyDAO();
  companyDAO.insertCompany(company);
 } 

public void updateCompany(Company company)
 {
  companyDAO = new CompanyDAO();
  companyDAO.updateCompany(company);
 } 

public void deleteCompany(Company company)
 {
  companyDAO = new CompanyDAO();
  companyDAO.deleteCompany(company);
 } 

public Company  getCompanyById(int companyId)
 {
  companyDAO = new CompanyDAO();
  Company company= companyDAO.getCompanyById(companyId);
 return company;
 } 

public Company  getCompany(String companyName)
 {
  companyDAO = new CompanyDAO();
  Company company= companyDAO.getCompany(companyName);
 return company;
 } 

public List<Company>  getAll( )
 {
  companyDAO = new CompanyDAO();
   List<Company>  companys = companyDAO.getCompanys( );
 return companys;
 } 

} 

