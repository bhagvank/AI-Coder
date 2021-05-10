import java.util.List;
import org.archcorner.chartreuse.dal.dao.InsuranceproviderDAO;
import org.archcorner.chartreuse.pojo.Insuranceprovider;

public class InsuranceproviderBusinessDelegate{ 


private InsuranceproviderDAO insuranceproviderDAO ;

public int getHighestId()
 {
  insuranceproviderDAO = new InsuranceproviderDAO();
   int id=insuranceproviderDAO.getHighestId();
   return id;
 } 

public void insertInsuranceprovider(Insuranceprovider insuranceprovider)
 {
  insuranceproviderDAO = new InsuranceproviderDAO();
  insuranceproviderDAO.insertInsuranceprovider(insuranceprovider);
 } 

public void updateInsuranceprovider(Insuranceprovider insuranceprovider)
 {
  insuranceproviderDAO = new InsuranceproviderDAO();
  insuranceproviderDAO.updateInsuranceprovider(insuranceprovider);
 } 

public void deleteInsuranceprovider(Insuranceprovider insuranceprovider)
 {
  insuranceproviderDAO = new InsuranceproviderDAO();
  insuranceproviderDAO.deleteInsuranceprovider(insuranceprovider);
 } 

public Insuranceprovider  getInsuranceproviderById(int insuranceproviderId)
 {
  insuranceproviderDAO = new InsuranceproviderDAO();
  Insuranceprovider insuranceprovider= insuranceproviderDAO.getInsuranceproviderById(insuranceproviderId);
 return insuranceprovider;
 } 

public Insuranceprovider  getInsuranceprovider(String insuranceproviderName)
 {
  insuranceproviderDAO = new InsuranceproviderDAO();
  Insuranceprovider insuranceprovider= insuranceproviderDAO.getInsuranceprovider(insuranceproviderName);
 return insuranceprovider;
 } 

public List<Insuranceprovider>  getAll( )
 {
  insuranceproviderDAO = new InsuranceproviderDAO();
   List<Insuranceprovider>  insuranceproviders = insuranceproviderDAO.getInsuranceproviders( );
 return insuranceproviders;
 } 

} 

