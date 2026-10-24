/**
 * 
 */
package com.architectcorner.ai.machinelearning.datascience;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author bhagvan_kommadi
 *
 */
public class LinearRegression {

	/**
	 * 
	 */
	public LinearRegression() {
		// TODO Auto-generated constructor stub
	}

	public List<Double> getLinearFitFromStringValues(List<List<String>> rows)
	{
		int maxRows = rows.size();
		double[]  xValues = new double[maxRows-1];
		double[]  yValues = new double[maxRows-1];
		
		for(int i=0; i < maxRows; i++)
		{
			if(i==0)
			{
				
			}
			else
			{
			 List<String> columns = rows.get(i);
			 xValues[i-1] = Double.parseDouble(columns.get(0));
			 yValues[i-1] = Double.parseDouble(columns.get(1));
			}
		}
		
		List<Double> fitCoefficients = getLinearFit(xValues,yValues);
		
		return fitCoefficients;
		
		
	}
	public List<Double> getLinearFit(double[] xValues, double[] yValues)
	{
		List<Double> fitCoefficients = new ArrayList<Double>();

		 int MaxRows = xValues.length;
		 double xSum =0.0;
		 double ySum =0.0;
		 
		 double xSumSquare = 0.0;
		 
		 for(int i=0; i< MaxRows; i++)
		 {
		      xSum = xSum +xValues[i];
		      ySum = ySum +yValues[i];
		      xSumSquare = xSumSquare + xValues[i]*xValues[i];
		 }
		 
		 double xAvg = xSum/MaxRows;
		 double yAvg = ySum/MaxRows;
		 
		 double xVariance = 0.0;
		 double yVariance = 0.0;
		 
		 double xyVariance = 0.0;
		 
		 for(int i=0; i < MaxRows; i++)
		 {
			 xVariance = xVariance + ((xValues[i]-xAvg)*(xValues[i]-xAvg));
			 yVariance = yVariance + ((yValues[i]-yAvg)*(yValues[i]-yAvg));
			 xyVariance = xyVariance +((xValues[i]-xAvg)*(yValues[i]-yAvg));
		 }
		 
		 double beta1 = xyVariance/xVariance;
		 double beta0 = yAvg-(beta1*xAvg);

		 System.out.println("y= " +beta1 + " *x+"+ beta0);

		 Double coeff1 = new Double(beta1);
		 Double coeff2 = new Double(beta0);
		 
		 fitCoefficients.add(coeff1);
		 fitCoefficients.add(coeff2);
		 
		return fitCoefficients;
	}
	
	public List<Double> getLeastSumSquaresFitFromStringValues(List<List<String>> rows)
	{
		int maxRows = rows.size();
		double[]  xValues = new double[maxRows-1];
		double[]  yValues = new double[maxRows-1];
		
		for(int i=0; i < maxRows-1; i++)
		{
			if(i==0)
			{
				
			}
			else
			{
			 List<String> columns = rows.get(i);
			 xValues[i] = Double.parseDouble(columns.get(0));
			 yValues[i] = Double.parseDouble(columns.get(1));
			}
		}
		
		List<Double> fitCoefficients = getLeastSumSquaresFit(xValues,yValues);
		
		return fitCoefficients;
		
		
	}
	
	public List<Double> getLeastSumSquaresFit(double[] xValues,double[] yValues)
	{
		
		List<Double> fitCoefficients = new ArrayList<Double>();
		
		int MaxRows = xValues.length;
		 
		 
		 LinearRegression regression = new LinearRegression();
		 List<Double> linearFitCoefficients = regression.getLinearFit(xValues, yValues);
		 
		 
	//	 System.out.println("y ="+linearFitCoefficients.get(0)+"x+"+linearFitCoefficients.get(1));
		 
		 double xSum =0.0;
		 double ySum =0.0;
         double xSumSquare = 0.0;
		 
		 for(int i=0; i< MaxRows; i++)
		 {
		     xSum = xSum +xValues[i];
		      ySum = ySum +yValues[i]; 
		      xSumSquare = xSumSquare + xValues[i]*xValues[i];
		 }
		 
		 double beta1 = linearFitCoefficients.get(0);
		 double beta0 = linearFitCoefficients.get(1);
		 
				 int df = MaxRows -2;
		 double residualsum = 0.0;
		 double regressionsum = 0.0;
		 
		 double xAvg = xSum/MaxRows;
		 double yAvg = ySum/MaxRows;
		 
		 double xVariance = 0.0;
		 double yVariance = 0.0;
		 
		 
        double xyVariance = 0.0;
		 
		 for(int i=0; i < MaxRows; i++)
		 {
			 xVariance = xVariance + ((xValues[i]-xAvg)*(xValues[i]-xAvg));
			 yVariance = yVariance + ((yValues[i]-yAvg)*(yValues[i]-yAvg));
			 xyVariance = xyVariance +((xValues[i]-xAvg)*(yValues[i]-yAvg));
		 }
		 
		 for(int i=0; i< MaxRows; i++)
		 {
			double fit = (beta1*xValues[i])+beta0;
			residualsum = residualsum +((fit-yValues[i])*(fit-yValues[i]));
			regressionsum = regressionsum + ((fit-yAvg)*(fit-yAvg));
		 }
		 
		 double R2 = regressionsum/yVariance;
		 double svar = residualsum/df;
		 double svar1 = svar/xVariance;
		 double svar0 = svar/(MaxRows + (xAvg*xAvg*svar1));
		 
		 /*System.out.println("svar1 ="+svar1);
		 System.out.println("svar0 ="+svar0);
		 
		System.out.println("R^2 ="+R2 );
		System.out.println("std error of beta1 = "+ Math.sqrt(svar1));
		System.out.println("std error of beta0 ="+ Math.sqrt(svar0));
		svar0 = (svar*xSumSquare)/(MaxRows*xVariance);
		System.out.println("std error of beta_0="+ Math.sqrt(svar0));
		System.out.println("SSTO =" + yVariance);
		System.out.println("SSE  ="+residualsum);
		System.out.println("SSR ="+regressionsum);*/
		
		double stderrorBeta1 = Math.sqrt(svar1);
		double stderrorBeta0 = Math.sqrt(svar0);
		double ssto = yVariance;
		double sse = residualsum;
		double ssr = regressionsum;
		
	
		Double leastSumSquareCoeff1 = new Double(svar);
		Double leastSumSquareCoeff2 = new Double(svar1);
		Double leastSumSquareCoeff3 = new Double(svar0);
		Double leastSumSquareCoeff4 = new Double(R2);
		Double leastSumSquareCoeff5 = new Double(stderrorBeta1);
		Double leastSumSquareCoeff6 = new Double(stderrorBeta0);
		Double leastSumSquareCoeff7 = new Double(ssto);
		Double leastSumSquareCoeff8 = new Double(sse);
		Double leastSumSquareCoeff9 = new Double(ssr);
		
		
		fitCoefficients.add(leastSumSquareCoeff1);
		fitCoefficients.add(leastSumSquareCoeff2);
		fitCoefficients.add(leastSumSquareCoeff3);
		fitCoefficients.add(leastSumSquareCoeff4);
		fitCoefficients.add(leastSumSquareCoeff5);
		fitCoefficients.add(leastSumSquareCoeff6);
		fitCoefficients.add(leastSumSquareCoeff7);
		fitCoefficients.add(leastSumSquareCoeff8);
		fitCoefficients.add(leastSumSquareCoeff9);
		
		return fitCoefficients;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 int MaxRows = 1000;
		 double[] xValues = new double[MaxRows];
		 double[] yValues = new double[MaxRows];
		 
		 
		 Random random = new Random();
		 
		 int rand1 = 5;
		 int rand2 = 2;
		 for(int i=0; i< MaxRows; i++)
		 {
			 xValues[i] = 1.0 +i*2;
			 
			 yValues[i] = (xValues[i]*(2+random.nextInt(rand2))) + (3+random.nextInt(rand1));
			 
		 }
		 
		 
		 LinearRegression regression = new LinearRegression();
		 List<Double> fitCoefficients = regression.getLinearFit(xValues, yValues);
		 
		 
		 System.out.println("y ="+fitCoefficients.get(0)+"x+"+fitCoefficients.get(1));
		 
		List<Double> sumSquareFitCoefficients = regression.getLeastSumSquaresFit(xValues, yValues);
		
		double svar = sumSquareFitCoefficients.get(0);
		double svar1 = sumSquareFitCoefficients.get(1);
		double svar0 = sumSquareFitCoefficients.get(2);
		double R2 = sumSquareFitCoefficients.get(3);
		double stderrorbeta1 = sumSquareFitCoefficients.get(4);
		double stderrorbeta0 = sumSquareFitCoefficients.get(5);
		double ssto = sumSquareFitCoefficients.get(6);
		double sse = sumSquareFitCoefficients.get(7);
		double ssr = sumSquareFitCoefficients.get(8);
		
		 System.out.println("svar ="+svar);
		 System.out.println("svar1 ="+svar1);
		 System.out.println("svar0 ="+svar0);
		 
		System.out.println("R^2 ="+R2 );
		System.out.println("std error of beta1 = "+ stderrorbeta1);
		System.out.println("std error of beta0 ="+ stderrorbeta0);
		//svar0 = (svar*xSumSquare)/(MaxRows*xVariance);
		//System.out.println("std error of beta_0="+ Math.sqrt(svar0));
		
		System.out.println("SSTO =" + ssto);
		System.out.println("SSE  ="+sse);
		System.out.println("SSR ="+ssr);
	}

}
