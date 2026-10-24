/**
 * 
 */
package com.architectcorner.ai.neuralnetwork.backpropagation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author bhagvan.kommadi
 *
 */
public class DeepNeuralNetwork {

	
	private List<List<String>> layers;
	
	/**
	 * @return the layers
	 */
	public List<List<String>> getLayers() {
		return layers;
	}

	/**
	 * @param layers the layers to set
	 */
	public void setLayers(List<List<String>> layers) {
		this.layers = layers;
	}
	
	private HashMap<String,Float> inputWeights;
	
	/**
	 * @return the inputWeights
	 */
	public HashMap<String, Float> getInputWeights() {
		return inputWeights;
	}

	/**
	 * @param inputWeights the inputWeights to set
	 */
	public void setInputWeights(HashMap<String, Float> inputWeights) {
		this.inputWeights = inputWeights;
	}

	/**
	 * @return the outputWeights
	 */
	public HashMap<String, Float> getOutputWeights() {
		return outputWeights;
	}

	/**
	 * @param outputWeights the outputWeights to set
	 */
	public void setOutputWeights(HashMap<String, Float> outputWeights) {
		this.outputWeights = outputWeights;
	}

	private HashMap<String,Float> outputWeights;
	
	private List<String> inputTrainingData;
	
	/**
	 * @return the inputTrainingData
	 */
	public List<String> getInputTrainingData() {
		return inputTrainingData;
	}

	/**
	 * @param inputTrainingData the inputTrainingData to set
	 */
	public void setInputTrainingData(List<String> inputTrainingData) {
		this.inputTrainingData = inputTrainingData;
	}

	/**
	 * @return the outputTrainingData
	 */
	public List<String> getOutputTrainingData() {
		return outputTrainingData;
	}

	/**
	 * @param outputTrainingData the outputTrainingData to set
	 */
	public void setOutputTrainingData(List<String> outputTrainingData) {
		this.outputTrainingData = outputTrainingData;
	}
	private List<String> outputTrainingData;
	
	
	public Float calculateMomentum(List<String> input)
	{
		Float momentum = new Float(1.0f);
		Float errors = new Float(0.0f);
		
		for(String inputData: input)
		{
			for(String inputTraining:inputTrainingData)
			if(inputData.contains(inputTraining))
            {
				Float weight = inputWeights.get(inputTraining);
	            errors = errors + (weight*new Float(inputData.length()-inputTraining.length()));
            }
			else
			{
				errors = errors + new Float(inputData.length());
			}
		}
		
		//last momentum
		momentum = errors;
		
		return momentum;
	}
	public void train()
	{
		Float momentum = calculateMomentum(inputTrainingData);
		System.out.println(momentum);
	}
	
	public void forwardPass()
	{
		for(String input: inputTrainingData)
		{
			StringTokenizer tokenizer = new StringTokenizer(input);
			
			while(tokenizer.hasMoreElements())
			{
				String token = (String) tokenizer.nextElement();
				
				
				for(List<String> layer: layers)
				{
					for(String layerInput: layer)
					{
						String tokenString = token.toLowerCase();
						
						String layerInputString = layerInput.toLowerCase();
						if(tokenString.contains(layerInputString))
						{
							System.out.println(layerInput);
						}
					}
				}
			}
		}
	}
	public void recall(List<String> inputData)
	{
		for(String input: inputData)
		{
			StringTokenizer tokenizer = new StringTokenizer(input);
			
			String previousToken = "";
			while(tokenizer.hasMoreElements())
			{
				String token = (String) tokenizer.nextElement();
				
				
				for(List<String> layer: layers)
				{
					for(String layerInput: layer)
					{
						String tokenString = token.toLowerCase();
						
						String layerInputString = layerInput.toLowerCase();
						if(tokenString.contains(layerInputString))
						{
							System.out.println(previousToken + " :"+layerInput);
						}
					}
				}
				
				previousToken= token;
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DeepNeuralNetwork network = new DeepNeuralNetwork();
		
		
		//cases
		List<String> inputTraining = new ArrayList();
		inputTraining.add("901 Criminal attempt");
		inputTraining.add("902 Criminal solicitation");
		inputTraining.add("903 Criminal conspiracy");
		inputTraining.add("911(b)(3) Corrupt organizations-employee participation");
		
		network.setInputTrainingData(inputTraining);
		
		HashMap<String,Float> inputWeights = new HashMap();
		inputWeights.put("901 Criminal attempt", 10.0F);
		inputWeights.put("902 Criminal solicitation", 9.0F);
		inputWeights.put("903 Criminal conspiracy", 9.0F);
		inputWeights.put("911(b)(3) Corrupt organizations-employee participation", 8.0F);
		
		network.setInputWeights(inputWeights);
		
		
		List<String> crimeTypes = new ArrayList();
		crimeTypes.add("Assault");
		crimeTypes.add("Battery");
		crimeTypes.add("FalseImprisonment");
		crimeTypes.add("Kidnapping");
		crimeTypes.add("homicide");
		crimeTypes.add("rape");
		crimeTypes.add("sexual assault");
		crimeTypes.add("theft");
		crimeTypes.add("accident");
		crimeTypes.add("murder");
	
		List<String> location = new ArrayList();
		location.add("city");
		location.add("state");
		location.add("country");
		location.add("zipcode");
		
		
		List<String> target = new ArrayList();
		target.add("Male");
		target.add("Female");
		target.add("children");
		target.add("vehicle");
		target.add("building");
		target.add("item");
		
		//codes as a hidden layer
		List<List<String>> layers = new ArrayList();
		
		layers.add(crimeTypes);
		layers.add(location);
		layers.add(target);
		
		network.setLayers(layers);
		
		network.train();
		
		network.forwardPass();
		
		List<String> cases = new ArrayList();
		cases.add("A person was found murdered. Vehicle was left There was blood on the floor in Chicago City, Illinois State");
		
		network.recall(cases);
	}

}
