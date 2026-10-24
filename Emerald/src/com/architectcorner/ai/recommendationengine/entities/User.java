/**
 * 
 */
package com.architectcorner.ai.recommendationengine.entities;

import java.util.List;
import java.util.Map;

/**
 * @author bhagvan.kommadi
 *
 */
public class User {

	private String name;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the favourites
	 */
	public List<Product> getFavourites() {
		return favourites;
	}
	/**
	 * @param favourites the favourites to set
	 */
	public void setFavourites(List<Product> favourites) {
		this.favourites = favourites;
	}
	/**
	 * @return the ratings
	 */
	public Map<Product, String> getRatings() {
		return ratings;
	}
	/**
	 * @param ratings the ratings to set
	 */
	public void setRatings(Map<Product, String> ratings) {
		this.ratings = ratings;
	}
	private String id;
	private List<Product> favourites;
	private Map<Product,String> ratings;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
