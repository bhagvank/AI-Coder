package com.architectcorner.ai.simulatedannealing.processing;

import java.util.Random;

public class SimulatedAnnealingManager {

	Random random = new Random();
	
	public double getProbabilityAcceptance(double oldEnergy, double newEnergy, double currentTemperature,double targetLoss)
	{
		if(newEnergy < oldEnergy && newEnergy < targetLoss)
		{
			return 1.0;
		}
		return Math.exp((oldEnergy-newEnergy)/currentTemperature);
	}
	
	public int getRandomNonZero(int bound)
	{
		int output = random.nextInt(bound);
		
		while(output ==0)
		{
			output = random.nextInt(bound);
		}
		return output;
	}
	public static void main(String[] args)
	{
		 SimulatedAnnealingManager manager = new SimulatedAnnealingManager();
		 Random random = new Random();
		 double temp = 10000;
		 double coolingRate = 0.003;
	     
		 int tradingLot = 10;
		 
		 int orderQuantity = 112;
		 
		 int pricePerLot = 200;
		 
		 int cost = 2000;
		 
		 double neighbourEnergy = 0;
		 
		 double targetLoss =0;
		 
		 double currentEnergy = 0;
		 
		 double best = currentEnergy;
		 
		 double bestTradingLot=0.0;
		 
		 int newTradingLot;
		 
		 while(temp > 1)
		 {
			 currentEnergy = cost-((orderQuantity/tradingLot)*pricePerLot);
			 
			 System.out.println(currentEnergy);
			 
			 newTradingLot = manager.getRandomNonZero(20);
			 
			 //System.out.println(tradingLot);
			 
			 neighbourEnergy = cost-((orderQuantity/tradingLot)*pricePerLot);
			 System.out.println(neighbourEnergy);
			 
			 double probability = manager.getProbabilityAcceptance(currentEnergy, neighbourEnergy, temp,targetLoss);
			 
			 if(probability > random.nextDouble())
			 {
				tradingLot = newTradingLot; 
			 }
			 
			 if(currentEnergy < best)
			 {
				 best = currentEnergy;
				 bestTradingLot = tradingLot;
			 }
			 temp = temp*(1-coolingRate);
		 }
		 
		 System.out.println(bestTradingLot);
		 
		 System.out.println(best);
		 
	}
}
