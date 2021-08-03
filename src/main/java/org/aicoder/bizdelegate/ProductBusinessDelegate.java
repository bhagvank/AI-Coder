package org.aicoder.bizdelegate;
import java.util.List;
import org.archcorner.chartreuse.dal.dao.ProductDAO;
import org.archcorner.chartreuse.pojo.Product;

public class ProductBusinessDelegate{ 


private ProductDAO productDAO ;

public int getHighestId()
 {
  productDAO = new ProductDAO();
   int id=productDAO.getHighestId();
   return id;
 } 

public void insertProduct(Product product)
 {
  productDAO = new ProductDAO();
  productDAO.insertProduct(product);
 } 

public void updateProduct(Product product)
 {
  productDAO = new ProductDAO();
  productDAO.updateProduct(product);
 } 

public void deleteProduct(Product product)
 {
  productDAO = new ProductDAO();
  productDAO.deleteProduct(product);
 } 

public Product  getProductById(int productId)
 {
  productDAO = new ProductDAO();
  Product product= productDAO.getProductById(productId);
 return product;
 } 

public Product  getProduct(String productName)
 {
  productDAO = new ProductDAO();
  Product product= productDAO.getProduct(productName);
 return product;
 } 

public List<Product>  getAll( )
 {
  productDAO = new ProductDAO();
   List<Product>  products = productDAO.getProducts( );
 return products;
 } 

} 

