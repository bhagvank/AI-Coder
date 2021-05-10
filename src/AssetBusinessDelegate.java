import java.util.List;
import org.archcorner.chartreuse.dal.dao.AssetDAO;
import org.archcorner.chartreuse.pojo.Asset;

public class AssetBusinessDelegate{ 


private AssetDAO assetDAO ;

public int getHighestId()
 {
  assetDAO = new AssetDAO();
   int id=assetDAO.getHighestId();
   return id;
 } 

public void insertAsset(Asset asset)
 {
  assetDAO = new AssetDAO();
  assetDAO.insertAsset(asset);
 } 

public void updateAsset(Asset asset)
 {
  assetDAO = new AssetDAO();
  assetDAO.updateAsset(asset);
 } 

public void deleteAsset(Asset asset)
 {
  assetDAO = new AssetDAO();
  assetDAO.deleteAsset(asset);
 } 

public Asset  getAssetById(int assetId)
 {
  assetDAO = new AssetDAO();
  Asset asset= assetDAO.getAssetById(assetId);
 return asset;
 } 

public Asset  getAsset(String assetName)
 {
  assetDAO = new AssetDAO();
  Asset asset= assetDAO.getAsset(assetName);
 return asset;
 } 

public List<Asset>  getAll( )
 {
  assetDAO = new AssetDAO();
   List<Asset>  assets = assetDAO.getAssets( );
 return assets;
 } 

} 

