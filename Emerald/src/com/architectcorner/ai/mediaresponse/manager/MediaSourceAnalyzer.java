/**
 * 
 */
package com.architectcorner.ai.mediaresponse.manager;

import com.architectcorner.ai.network.analysis.Network;
import com.architectcorner.ai.nlp.processing.POSDetector;
import com.sun.syndication.feed.synd.SyndContent;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * @author bhagvan_kommadi
 *
 */
public class MediaSourceAnalyzer {
	
    private Network network;
    /**
	 * @return the network
	 */
	public Network getNetwork() {
		return network;
	}

	/**
	 * @param network the network to set
	 */
	public void setNetwork(Network network) {
		this.network = network;
	}

	/**
	 * @return the detector
	 */
	public POSDetector getDetector() {
		return detector;
	}

	/**
	 * @param detector the detector to set
	 */
	public void setDetector(POSDetector detector) {
		this.detector = detector;
	}

	private POSDetector detector;
	
	public HashMap<String,List<String>> checkForNetwork(String content)
	{
		 HashMap<String,List<String>> entityList =  network.getEntityList();
		 
		 HashMap<String,List<String>> networkEntitiesList = new HashMap();
   	  
   	  Set<String> keySet = entityList.keySet();
   	  
   	  for(String key: keySet)
   	  {
   		 List<String> entities = entityList.get(key);
   		 
   		
   		 
   		 for(String entity: entities)
   		 {
   			 String entityStr = entity.toLowerCase();
   			 
   			 String contentStr = content.toLowerCase();
   			 
   			 if(contentStr.contains(entityStr))
   			 {
   				 System.out.println("Type is: " + key);
   				 
   				 List<String> networkEntities = networkEntitiesList.get(key);
   				 
   				 if(networkEntities == null)
   				 {
   					 networkEntities = new ArrayList();
   					 networkEntities.add(entity);
   					 networkEntitiesList.put(entity, networkEntities);
   					 
   				 }
   				 else
   				 {
   					 networkEntities.add(entity);
   				 }
   			 }
   		 }
   	  }
   	  
   	  return networkEntitiesList;
	}
	
	public HashMap<String,List<String>> detectPOS(String content)
	{
		 HashMap<String,List<String>> posInstanceList =  detector.getPosInstances();
         Set<String> keys = posInstanceList.keySet();
   	  
         HashMap<String,List<String>> posTypeInstanceList = new HashMap();
   	  for(String key: keys)
   	  {
   		 List<String> posInstances = posInstanceList.get(key);
   		 
   		 for(String posInstance: posInstances)
   		 {
   			String entityStr = posInstance.toLowerCase();
  			 
  			 String contentStr = content.toLowerCase();
  			 
  			List<String> posTypeInstances = posTypeInstanceList.get(key);
  			 
   			 if(contentStr.contains(posInstance))
   			 {
   				 if(posTypeInstances == null)
   				 {
   				    posTypeInstances = new ArrayList();
					 posTypeInstances.add(posInstance);
					 posTypeInstanceList.put(key, posTypeInstances);
					 System.out.println("PosInstance is of Type: " + key);
					 
   				 }
   		        else
		        {
   		           posTypeInstances.add(posInstance);
		        }
   			 }
   		 }
   	  }
   	  
   	  return posTypeInstanceList;
	}
    
    public MediaContent analyze(String url,String[] keywords)
    {
    	
       MediaContent mediaContent = new MediaContent();
       
       Map<String,List<String>> foundContent = new HashMap();
        try
        {
        
            URL feedUrl = new URL(url);
        SyndFeedInput input = new SyndFeedInput();
                SyndFeed feed = input.build(new XmlReader(feedUrl));
                
                List entryList = feed.getEntries();

               // System.out.println(feed);
                for(int i=0; i< entryList.size();i++)
                {
                    SyndEntry entry = (SyndEntry) entryList.get(i);
                    
                 // System.out.println("Title" + entry.getTitle());
                    //System.out.println("URI " + entry.getUri());
                   // System.out.println(entry.getContents());
              
                 //   System.out.println(entry);
                    
                    
                    List<SyndContent> syndContentList = entry.getContents();
                    
                    if(syndContentList.isEmpty())
                    {
                         SyndContent syndContent = entry.getDescription();	
                         
                         //System.out.println(syndContent);
                         
                         
                         if(syndContent != null)
                         {
                           String content = syndContent.getValue();
                        

	                         if(content == null || content.isEmpty())
	                         {
	                        	 System.out.println(content);
	                        	 content = entry.getTitle();
	                        	 
	                        	 //System.out.println(content);
	                        	 
	                        	 // Person, Place, Company analysis
	                        	 HashMap<String,List<String>> networkEntities =  checkForNetwork(content);
	                        	 
	                        	 mediaContent.setNetworkEntities(networkEntities);
	                        	 
	                        	 HashMap<String,List<String>> posInstances = detectPOS(content);
	                        	 
	                        	 mediaContent.setPosDetectInstances(posInstances);
	                        	 
	                        	 //POS Detector
	                        	  
	                        	 
	                         }
	                     	
	                         for(int j=0; j< keywords.length; j++)
	                         {
	                         	
	                            HashMap<String,List<String>> networkEntities =  checkForNetwork(content);
	                        	 
	                        	 mediaContent.setNetworkEntities(networkEntities);
	                        	 
	                        	 HashMap<String,List<String>> posInstances = detectPOS(content);
	                        	 
	                        	 mediaContent.setPosDetectInstances(posInstances);
	                        	 
	                        	 //System.out.println(content);
	                        	 
	                         	if(content.contains(keywords[j]))
	                         	{
	                         		List<String> keyWordContent = foundContent.get(keywords[j]);
	                         		
	                         		if(keyWordContent == null)
	                         		{
	                         			keyWordContent = new ArrayList<String>();
	                         			keyWordContent.add(content);
	                         			foundContent.put(keywords[j],keyWordContent);
	                         			
	                         			//System.out.println(content);
	                         		}
	                         		else
	                         		{
	                         		   keyWordContent.add(content);
	                         		   
	                         		   foundContent.put(keywords[j],keyWordContent);
	                         		  //System.out.println(content);
	                         		   
	                         		   
	                         		}
	                         		
	                         				
	                         	}
	                         }
                         }
                    }
                    else
                    {
	                    for(SyndContent syndContent:syndContentList)
	                    {
	                    	String content = syndContent.getValue();
	                    	
	                    	//System.out.println(content);
	                    	
	                    	/*if(content == null||content.isEmpty())
	                    	{
	                    		content = syndContent.
	                    	}*/
	                    	
                             HashMap<String,List<String>> networkEntities =  checkForNetwork(content);
                        	 
                        	 mediaContent.setNetworkEntities(networkEntities);
                        	 
                        	 HashMap<String,List<String>> posInstances = detectPOS(content);
                        	 
                        	 mediaContent.setPosDetectInstances(posInstances);
	                    for(int j=0; j< keywords.length; j++)
	                    {
	                    	String keyword = keywords[j];
	                    	
	                    	if(keyword.contains("&"))
	                    	{
	                    		keyword.replace("&", "&amp;");
	                    	}
	                    	
	                    	if(content.contains(keyword))
	                    	{
	                    		List<String> keyWordContent = foundContent.get(keywords[j]);
	                    		
	                    		if(keyWordContent == null)
	                    		{
	                    			keyWordContent = new ArrayList<String>();
	                    			keyWordContent.add(content);
	                    			foundContent.put(keywords[j],keyWordContent);
	                    			
	                    			//System.out.println(content);
	                    		}
	                    		else
	                    		{
	                    		   keyWordContent.add(content);
	                    		   
	                    		   foundContent.put(keywords[j],keyWordContent);
	                    		  //System.out.println(content);
	                    		   
	                    		   
	                    		}
	                    		
	                    				
	                    	}
	                    }
	                    }
	                     //List<SyndEntry> syndEntryList = entry.getContents();
	                     
	                    /* for(SyndEntry syndEntry: syndEntryList)
	                     {
	                    	 
	                    	      //syndEntry.toString();
	                     }*/
                    }   
                }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        
       /* for(String foundStr:foundContent)
        {
        	//System.out.println(foundStr);
        }*/
        
        mediaContent.setFoundArticles(foundContent);
        return mediaContent;
    }
}
