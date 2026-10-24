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
public class Population {

	
	public static Random random = new Random();
	private List<Person> persons;
	
	/**
	 * @return the persons
	 */
	public List<Person> getPersons() {
		return persons;
	}

	/**
	 * @param persons the persons to set
	 */
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	/**
	 * @return the totalFitnessValue
	 */
	public double getTotalFitnessValue() {
		return totalFitnessValue;
	}

	/**
	 * @param totalFitnessValue the totalFitnessValue to set
	 */
	public void setTotalFitnessValue(double totalFitnessValue) {
		this.totalFitnessValue = totalFitnessValue;
	}

	private double totalFitnessValue;
	
	private int populationSize;
	
	/**
	 * @return the populationSize
	 */
	public int getPopulationSize() {
		return populationSize;
	}

	/**
	 * @param populationSize the populationSize to set
	 */
	public void setPopulationSize(int populationSize) {
		this.populationSize = populationSize;
	}

	public void init()
	{
		persons = new ArrayList();
		
		for(int i=0; i< populationSize; i++)
		{
			Person person = new Person();
			person.randomize();
			persons.add(person);
		}
		
		calculateTotalFitnessValue();
	}
	
	public double calculateTotalFitnessValue()
	{
		double totalFitness = 0;
		
		for(Person person: persons)
		{
			totalFitness = totalFitness + person.calculateFitness();
		}
		this.totalFitnessValue = totalFitness;
		
		return totalFitness;
	}
	
	public Person selectRandomIndividual()
	{
		double rand = random.nextDouble()*this.totalFitnessValue;
		int i;
		for(i=0; i< populationSize && rand >0; ++i)
		{
			rand = rand - persons.get(i).getFitnessValue();
		}
		
		return persons.get(i-1);
	}
	
	public Person getBestPerson()
	{
		int iMax=0;
		int iMin=0;
		double currentMax = 0.0;
		double currentMin = 1.0;
		double currentVal;
		
		for(int i=0; i< persons.size();++i)
		{
			currentVal = persons.get(i).calculateFitness();
			if(currentMax < currentMin)
			{
				currentMin = currentVal;
				currentMax = currentMin;
				iMin = i;
				iMax = iMin;
			}
			
			if(currentVal > currentMax)
			{
				currentMax = currentVal;
				iMax = i;
			}
			
			if(currentVal < currentMin)
			{
				currentMin = currentVal;
				iMin =i;
			}
		}
		return persons.get(iMax);
	}
	
	public List<Person> crossOver(Person person1, Person person2)
	{
		List<Person> personList = new ArrayList();
		
		Person newPerson1 = new Person();
		newPerson1.randomize();
		Person newPerson2 = new Person();
		newPerson2.randomize();
		int randIndex = random.nextInt(Person.GENECOUNT);
		
		int i;
		
		for(i=0; i< randIndex; ++i)
		{
			newPerson1.getGenes().set(i, person1.getGenes().get(i));
			newPerson2.getGenes().set(i,person2.getGenes().get(i));
		}
		
		for(; i< Person.GENECOUNT; ++i)
		{
			newPerson1.getGenes().set(i,person2.getGenes().get(i));
			newPerson2.getGenes().set(i,person1.getGenes().get(i));
		}
		
		personList.add(newPerson1);
		personList.add(newPerson2);
		return personList;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Population population = new Population();
		population.setPopulationSize(205);
		population.init();
		
		List<Person> newPopulation = new ArrayList();
		
		List<Person> personList = new ArrayList();
		
		System.out.println(population.getTotalFitnessValue());
		System.out.println(population.getBestPerson().getFitnessValue());
		
		int count;
		for(int i=0; i< 2000; i++)
		{
			count=0;
			
			for(int j=0; j< 5; j++)
			{
				Person person = population.getBestPerson();
				newPopulation.add(person);
				count++;
			}
			
			while(count < population.getPopulationSize())
			{
				Person person1 = population.selectRandomIndividual();
				Person person2 = population.selectRandomIndividual();
				
				//System.out.println(person1);
				//System.out.println(person2);
				personList.add(person1);
				personList.add(person2);
				
				if(random.nextDouble() < 0.7)
				{
					personList = population.crossOver(person1, person2);
				}
				
				if(random.nextDouble() < 0.05)
				{
					personList.get(0).mutate();
				}
				if(random.nextDouble() < 0.05)
				{
					personList.get(1).mutate();
				}
				
				newPopulation.add(personList.get(0));
				newPopulation.add(personList.get(1));
				count = count+2;
			}
			population.setPersons(newPopulation);
			population.calculateTotalFitnessValue();
			
			System.out.println(population.getTotalFitnessValue());
			System.out.println(population.getBestPerson().getFitnessValue());
		}
		
		  Person person = population.getBestPerson();
		  
		  System.out.println(person.getGenes());
	}

}
