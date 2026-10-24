/**
 * 
 */
package com.architectcorner.ai.geneticalgorithm.processing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author bhagvan.kommadi
 *
 */
public class Person {

	
	public static int GENECOUNT = 500;
	private List<Integer> genes;
	/**
	 * @return the genes
	 */
	public List<Integer> getGenes() {
		return genes;
	}
	/**
	 * @param genes the genes to set
	 */
	public void setGenes(List<Integer> genes) {
		this.genes = genes;
	}
	/**
	 * @return the fitnessValue
	 */
	public int getFitnessValue() {
		return fitnessValue;
	}
	/**
	 * @param fitnessValue the fitnessValue to set
	 */
	public void setFitnessValue(int fitnessValue) {
		this.fitnessValue = fitnessValue;
	}
	private int fitnessValue;
	
	public void randomize()
	{
		Random random = new Random();
		genes = new ArrayList();
		for(int i=0; i< GENECOUNT; i++)
		{
			Integer gene = new Integer(random.nextInt(2));
			genes.add(gene);
		}
	}
	
	public void mutate()
	{
		Random random = new Random();
		int i = random.nextInt(genes.size());
		int geneValue = genes.get(i);
		genes.set(i, new Integer(1-geneValue));
	}
	
	public int calculateFitness()
	{
		int fitness = 0;
		
		for(Integer gene: genes)
		{
			fitness = fitness + gene.intValue();
		}
		this.setFitnessValue(fitness);
		
		return fitness;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
