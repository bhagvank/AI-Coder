import java.util.List;
import org.archcorner.chartreuse.dal.dao.ClaimDAO;
import org.archcorner.chartreuse.pojo.Claim;

public class ClaimBusinessDelegate{ 


private ClaimDAO claimDAO ;

public int getHighestId()
 {
  claimDAO = new ClaimDAO();
   int id=claimDAO.getHighestId();
   return id;
 } 

public void insertClaim(Claim claim)
 {
  claimDAO = new ClaimDAO();
  claimDAO.insertClaim(claim);
 } 

public void updateClaim(Claim claim)
 {
  claimDAO = new ClaimDAO();
  claimDAO.updateClaim(claim);
 } 

public void deleteClaim(Claim claim)
 {
  claimDAO = new ClaimDAO();
  claimDAO.deleteClaim(claim);
 } 

public Claim  getClaimById(int claimId)
 {
  claimDAO = new ClaimDAO();
  Claim claim= claimDAO.getClaimById(claimId);
 return claim;
 } 

public Claim  getClaim(String claimName)
 {
  claimDAO = new ClaimDAO();
  Claim claim= claimDAO.getClaim(claimName);
 return claim;
 } 

public List<Claim>  getAll( )
 {
  claimDAO = new ClaimDAO();
   List<Claim>  claims = claimDAO.getClaims( );
 return claims;
 } 

} 

