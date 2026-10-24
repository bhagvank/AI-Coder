/**
 * 
 */
package com.architectcorner.ai.mediaresponse.manager;

import java.util.List;
import java.util.Map;

/**
 * @author bhagvan.kommadi
 *
 */
public class MediaContent {
	
	
	private Map<String,List<String>> foundArticles;
	
	/**
	 * @return the foundArticles
	 */
	public Map<String, List<String>> getFoundArticles() {
		return foundArticles;
	}

	/**
	 * @param foundArticles the foundArticles to set
	 */
	public void setFoundArticles(Map<String, List<String>> foundArticles) {
		this.foundArticles = foundArticles;
	}

	private String content;
	
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the networkEntities
	 */
	public Map<String, List<String>> getNetworkEntities() {
		return networkEntities;
	}

	/**
	 * @param networkEntities the networkEntities to set
	 */
	public void setNetworkEntities(Map<String, List<String>> networkEntities) {
		this.networkEntities = networkEntities;
	}

	/**
	 * @return the posDetectInstances
	 */
	public Map<String, List<String>> getPosDetectInstances() {
		return posDetectInstances;
	}

	/**
	 * @param posDetectInstances the posDetectInstances to set
	 */
	public void setPosDetectInstances(Map<String, List<String>> posDetectInstances) {
		this.posDetectInstances = posDetectInstances;
	}

	private Map<String, List<String>> networkEntities;
	
	private Map<String,List<String>> posDetectInstances;

}
