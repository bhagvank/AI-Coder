/**
 * 
 */
package com.architectcorner.ai.neuralnetwork.hopfield;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author bhagvan.kommadi
 *
 */
public class HopField {
	
	private Float temperatureStorage;

	private HashMap<String,Float> weights;
	/**
	 * @return the weights
	 */
	public HashMap<String,Float> getWeights() {
		return weights;
	}
	/**
	 * @param weights the weights to set
	 */
	public void setWeights(HashMap<String,Float> weights) {
		this.weights = weights;
	}
	/**
	 * @return the inputs
	 */
	public List<String> getInputs() {
		return inputs;
	}
	/**
	 * @param inputs the inputs to set
	 */
	public void setInputs(List<String> inputs) {
		this.inputs = inputs;
	}
	/**
	 * @return the storage
	 */
	public List<String> getStorage() {
		return storage;
	}
	/**
	 * @param storage the storage to set
	 */
	public void setStorage(List<String> storage) {
		this.storage = storage;
	}
	private List<String> inputs;
	private List<String> storage;
	
	
	public Float deltaEnergy(List<String> inputData)
	{
		Float temp = new Float(0.0f);
		
		for(String input: inputData)
		{
		  Float weight = weights.get(input);
		  
		  if(weight != null)
		  {
		  
		   temp = temp + (weight*1.0f);
		  }
		  else
		  {
			  temp = temp + 1.0f;
		  }
		}
		
		return (2.0f *temp)-temperatureStorage;
		
	}
	public void train()
	{
        Float temp = new Float(0.0f);
		
		for(String input: storage)
		{
		  Float weight = weights.get(input);
		  
		  temp = temp + (weight*1.0f);
		}
		
		temperatureStorage = temp;
		
		System.out.println(temperatureStorage);
	}
	
	public void recall(List<String> input)
	{
		for(String sentence: input)
		{
			StringTokenizer tokenizer = new StringTokenizer(sentence," ");
			
		    while(tokenizer.hasMoreElements())
		    {
			   String token = (String) tokenizer.nextElement();
			   
			   System.out.println(token);
			   
				for(String traindata:storage)
				{
					String caseIgToken = token.toLowerCase();
					
					String caseIgTrain = traindata.toLowerCase();
					
				  if(caseIgToken.contains(caseIgTrain))
				  {
					  System.out.println("This sentence is aggressive "+sentence);
				  }
				}
		    }
		}
		
	   Float energy = 	deltaEnergy(input);
	   
	   System.out.println(energy);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		List<String> training = new ArrayList();
		
		training.add("shit");
		training.add("crap");
		training.add("hole");
		training.add("axe");
		training.add("lick");
		HopField hopField = new HopField();
		hopField.setStorage(training);
		
		HashMap<String,Float> weights = new HashMap();
		
		weights.put("shit", new Float(-3.0f));
		weights.put("crap", new Float(-2.0f));
		weights.put("hole",new Float(-1.0f));
		weights.put("axe",new Float(-1.0f));
		weights.put("lick",new Float(-2.0f));
		
		hopField.setWeights(weights);
		
		hopField.train();
		
		List<String> inputs = new ArrayList();
		inputs.add("shit, this is bad");
		
		hopField.recall(inputs);
		
	}

}
