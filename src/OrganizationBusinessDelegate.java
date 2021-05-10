import java.util.List;
import org.archcorner.chartreuse.dal.dao.OrganizationDAO;
import org.archcorner.chartreuse.pojo.Organization;

public class OrganizationBusinessDelegate{ 


private OrganizationDAO organizationDAO ;

public int getHighestId()
 {
  organizationDAO = new OrganizationDAO();
   int id=organizationDAO.getHighestId();
   return id;
 } 

public void insertOrganization(Organization organization)
 {
  organizationDAO = new OrganizationDAO();
  organizationDAO.insertOrganization(organization);
 } 

public void updateOrganization(Organization organization)
 {
  organizationDAO = new OrganizationDAO();
  organizationDAO.updateOrganization(organization);
 } 

public void deleteOrganization(Organization organization)
 {
  organizationDAO = new OrganizationDAO();
  organizationDAO.deleteOrganization(organization);
 } 

public Organization  getOrganizationById(int organizationId)
 {
  organizationDAO = new OrganizationDAO();
  Organization organization= organizationDAO.getOrganizationById(organizationId);
 return organization;
 } 

public Organization  getOrganization(String organizationName)
 {
  organizationDAO = new OrganizationDAO();
  Organization organization= organizationDAO.getOrganization(organizationName);
 return organization;
 } 

public List<Organization>  getAll( )
 {
  organizationDAO = new OrganizationDAO();
   List<Organization>  organizations = organizationDAO.getOrganizations( );
 return organizations;
 } 

} 

