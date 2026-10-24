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
public class Product {

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
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}
	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}
	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**
	 * @return the attributes
	 */
	public List<String> getAttributes() {
		return attributes;
	}
	/**
	 * @param attributes the attributes to set
	 */
	public void setAttributes(List<String> attributes) {
		this.attributes = attributes;
	}
	/**
	 * @return the attributeValues
	 */
	public Map<String, String> getAttributeValues() {
		return attributeValues;
	}
	/**
	 * @param attributeValues the attributeValues to set
	 */
	public void setAttributeValues(Map<String, String> attributeValues) {
		this.attributeValues = attributeValues;
	}
	private String id;
	private String brand;
	private String model;
	
	private List<String> attributes;
	private Map<String,String> attributeValues;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
