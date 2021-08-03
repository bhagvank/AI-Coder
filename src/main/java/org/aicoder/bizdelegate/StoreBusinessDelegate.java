package org.aicoder.bizdelegate;
import java.util.List;
import org.archcorner.chartreuse.dal.dao.StoreDAO;
import org.archcorner.chartreuse.pojo.Store;

public class StoreBusinessDelegate{ 


private StoreDAO storeDAO ;

public int getHighestId()
 {
  storeDAO = new StoreDAO();
   int id=storeDAO.getHighestId();
   return id;
 } 

public void insertStore(Store store)
 {
  storeDAO = new StoreDAO();
  storeDAO.insertStore(store);
 } 

public void updateStore(Store store)
 {
  storeDAO = new StoreDAO();
  storeDAO.updateStore(store);
 } 

public void deleteStore(Store store)
 {
  storeDAO = new StoreDAO();
  storeDAO.deleteStore(store);
 } 

public Store  getStoreById(int storeId)
 {
  storeDAO = new StoreDAO();
  Store store= storeDAO.getStoreById(storeId);
 return store;
 } 

public Store  getStore(String storeName)
 {
  storeDAO = new StoreDAO();
  Store store= storeDAO.getStore(storeName);
 return store;
 } 

public List<Store>  getAll( )
 {
  storeDAO = new StoreDAO();
   List<Store>  stores = storeDAO.getStores( );
 return stores;
 } 

} 

