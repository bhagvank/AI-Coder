/**
 * 
 */
package org.archcorner.chartreuse.businessservices;

import java.util.List;
import java.util.StringTokenizer;

import org.archcorner.chartreuse.dal.dao.ProductDAO;
import org.archcorner.chartreuse.pojo.Product;

/**
 * @author bhagvan_kommadi
 *
 */
public class ProductService {

	/**
	 * 
	 */
	public ProductService() {
		// TODO Auto-generated constructor stub
	}

	public void insertProduct(String productProperties)
	{
		StringTokenizer stringTokenizer = new StringTokenizer(productProperties,"@@");
		
		Product product = new Product();
		//product.setProductId(Integer.parseInt(stringTokenizer.nextToken()));
		product.setProductName(stringTokenizer.nextToken());
		product.setProductModel(stringTokenizer.nextToken());
		product.setDescription(stringTokenizer.nextToken());
		
		ProductDAO productDAO = new ProductDAO();
		productDAO.insertProduct(product);
	}
	
	public void updateProduct(String productProperties)
	{
		StringTokenizer stringTokenizer = new StringTokenizer(productProperties,"@@");
		
		Product product = new Product();
		product.setProductId(Integer.parseInt(stringTokenizer.nextToken()));
		product.setProductName(stringTokenizer.nextToken());
		product.setProductModel(stringTokenizer.nextToken());
		product.setDescription(stringTokenizer.nextToken());
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
	
	public Product[] getAll()
	{
		ProductDAO productDAO = new ProductDAO();
		
		List<Product> productList = productDAO.getProducts();
		 
		Product[] products = new Product[productList.size()];
		return productList.toArray(products);
	}
	
	public void deleteProduct(String productProperties)
	{
		StringTokenizer stringTokenizer = new StringTokenizer(productProperties, "@@");
		Product product = new Product();
		product.setProductId(Integer.parseInt(stringTokenizer.nextToken()));
		product.setProductName(stringTokenizer.nextToken());
		product.setProductModel(stringTokenizer.nextToken());
		product.setDescription(stringTokenizer.nextToken());
		ProductDAO productDAO = new ProductDAO();
		productDAO.deleteProduct(product);
	}
	
	public int getHighestId()
	{
		ProductDAO productDAO = new ProductDAO();
		return productDAO.getHighestId();
	}
	
}
