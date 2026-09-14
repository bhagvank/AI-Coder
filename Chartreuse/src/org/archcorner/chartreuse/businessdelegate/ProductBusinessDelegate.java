/**
 * 
 */
package org.archcorner.chartreuse.businessdelegate;

import java.util.List;

import org.archcorner.chartreuse.dal.dao.ProductDAO;
import org.archcorner.chartreuse.pojo.Product;

/**
 * @author bhagvan_kommadi
 *
 */
public class ProductBusinessDelegate {

	/**
	 * 
	 */
	public ProductBusinessDelegate() {
		// TODO Auto-generated constructor stub
	}


	public void insertProduct(Product product)
	{
		ProductDAO productDAO = new ProductDAO();
		productDAO.insertProduct(product);
	}
	
	public void updateProduct(Product product)
	{
		ProductDAO productDAO = new ProductDAO();
		productDAO.updateProduct(product);
	}
	
	public Product getProductById(int productId)
	{
		ProductDAO productDAO = new ProductDAO();
		 return productDAO.getProductById(productId);
	}
	public Product getProduct(String productName)
	{
		ProductDAO productDAO = new ProductDAO();
		return productDAO.getProduct(productName);
	}
	
	public List<Product> getAll()
	{
		ProductDAO productDAO = new ProductDAO();
		return productDAO.getProducts();
	}
	
	public void deleteProduct(Product product)
	{
		ProductDAO productDAO = new ProductDAO();
		productDAO.deleteProduct(product);
	}
	
	public int getHighestId()
	{
		ProductDAO productDAO = new ProductDAO();
		return productDAO.getHighestId();
	}
}
