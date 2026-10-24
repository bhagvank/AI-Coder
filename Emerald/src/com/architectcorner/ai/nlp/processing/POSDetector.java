package com.architectcorner.ai.nlp.processing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class POSDetector {

	private List<String> names;
	/**
	 * @return the names
	 */
	public List<String> getNames() {
		return names;
	}

	/**
	 * @param names the names to set
	 */
	public void setNames(List<String> names) {
		this.names = names;
	}

	/**
	 * @return the types
	 */
	public List<String> getTypes() {
		return types;
	}

	/**
	 * @param types the types to set
	 */
	public void setTypes(List<String> types) {
		this.types = types;
	}

	/**
	 * @return the posInstances
	 */
	public HashMap<String, List<String>> getPosInstances() {
		return posInstances;
	}

	/**
	 * @param posInstances the posInstances to set
	 */
	public void setPosInstances(HashMap<String, List<String>> posInstances) {
		this.posInstances = posInstances;
	}

	private List<String> types;
	private HashMap<String,List<String>> posInstances;
	
	public static void main(String[] args)
	{
		POSDetector detector = new POSDetector();
		
		List<String> types = new ArrayList();
		
		types.add("Noun");
		types.add("Verb");
		types.add("Adjective");
		types.add("Adverb");
		types.add("Preposition");
		types.add("Noun");
		
		detector.setTypes(types);
		
		List<String> nouns = new ArrayList();
		nouns.add("John Smith");
		nouns.add("Cow");
		nouns.add("Chair");
		
		List<String> verbs = new ArrayList();
		verbs.add("did");
		verbs.add("spoke");
		verbs.add("wrote");
		
		
	    HashMap<String,List<String>> posInstances = new HashMap();
	    posInstances.put("Noun", nouns);
	    posInstances.put("Verb", verbs);
	    
	    detector.setPosInstances(posInstances);
	    
	    
		
	}
	
}
