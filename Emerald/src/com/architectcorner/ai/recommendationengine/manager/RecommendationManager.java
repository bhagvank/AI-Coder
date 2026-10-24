/**
 * 
 */
package com.architectcorner.ai.recommendationengine.manager;

import java.util.List;
import java.util.Map;

import com.architectcorner.ai.recommendationengine.entities.Product;
import com.architectcorner.ai.recommendationengine.entities.User;

/**
 * @author bhagvan.kommadi
 *
 */
public class RecommendationManager {

	private List<Product> products;
	
	/**
	 * @return the products
	 */
	public List<Product> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(List<Product> products) {
		this.products = products;
	}

	/**
	 * @return the productFeedback
	 */
	public Map<Product, List<String>> getProductFeedback() {
		return productFeedback;
	}

	/**
	 * @param productFeedback the productFeedback to set
	 */
	public void setProductFeedback(Map<Product, List<String>> productFeedback) {
		this.productFeedback = productFeedback;
	}

	/**
	 * @return the users
	 */
	public List<User> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}

	private Map<Product,List<String>> productFeedback;
	
	private List<User> users;
	
	private Map<Product,List<String>> productFeatures;
	
	/**
	 * @return the productFeatures
	 */
	public Map<Product, List<String>> getProductFeatures() {
		return productFeatures;
	}

	/**
	 * @param productFeatures the productFeatures to set
	 */
	public void setProductFeatures(Map<Product, List<String>> productFeatures) {
		this.productFeatures = productFeatures;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println("Recommendation Engine Running");
	}

}
