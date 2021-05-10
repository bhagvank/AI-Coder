import java.util.List;
import org.archcorner.chartreuse.dal.dao.ProviderDAO;
import org.archcorner.chartreuse.pojo.Provider;

public class ProviderBusinessDelegate{ 


private ProviderDAO providerDAO ;

public int getHighestId()
 {
  providerDAO = new ProviderDAO();
   int id=providerDAO.getHighestId();
   return id;
 } 

public void insertProvider(Provider provider)
 {
  providerDAO = new ProviderDAO();
  providerDAO.insertProvider(provider);
 } 

public void updateProvider(Provider provider)
 {
  providerDAO = new ProviderDAO();
  providerDAO.updateProvider(provider);
 } 

public void deleteProvider(Provider provider)
 {
  providerDAO = new ProviderDAO();
  providerDAO.deleteProvider(provider);
 } 

public Provider  getProviderById(int providerId)
 {
  providerDAO = new ProviderDAO();
  Provider provider= providerDAO.getProviderById(providerId);
 return provider;
 } 

public Provider  getProvider(String providerName)
 {
  providerDAO = new ProviderDAO();
  Provider provider= providerDAO.getProvider(providerName);
 return provider;
 } 

public List<Provider>  getAll( )
 {
  providerDAO = new ProviderDAO();
   List<Provider>  providers = providerDAO.getProviders( );
 return providers;
 } 

} 

