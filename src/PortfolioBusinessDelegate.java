import java.util.List;
import org.archcorner.chartreuse.dal.dao.PortfolioDAO;
import org.archcorner.chartreuse.pojo.Portfolio;

public class PortfolioBusinessDelegate{ 


private PortfolioDAO portfolioDAO ;

public int getHighestId()
 {
  portfolioDAO = new PortfolioDAO();
   int id=portfolioDAO.getHighestId();
   return id;
 } 

public void insertPortfolio(Portfolio portfolio)
 {
  portfolioDAO = new PortfolioDAO();
  portfolioDAO.insertPortfolio(portfolio);
 } 

public void updatePortfolio(Portfolio portfolio)
 {
  portfolioDAO = new PortfolioDAO();
  portfolioDAO.updatePortfolio(portfolio);
 } 

public void deletePortfolio(Portfolio portfolio)
 {
  portfolioDAO = new PortfolioDAO();
  portfolioDAO.deletePortfolio(portfolio);
 } 

public Portfolio  getPortfolioById(int portfolioId)
 {
  portfolioDAO = new PortfolioDAO();
  Portfolio portfolio= portfolioDAO.getPortfolioById(portfolioId);
 return portfolio;
 } 

public Portfolio  getPortfolio(String portfolioName)
 {
  portfolioDAO = new PortfolioDAO();
  Portfolio portfolio= portfolioDAO.getPortfolio(portfolioName);
 return portfolio;
 } 

public List<Portfolio>  getAll( )
 {
  portfolioDAO = new PortfolioDAO();
   List<Portfolio>  portfolios = portfolioDAO.getPortfolios( );
 return portfolios;
 } 

} 

