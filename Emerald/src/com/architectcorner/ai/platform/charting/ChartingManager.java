/**
 * 
 */
package com.architectcorner.ai.platform.charting;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.architectcorner.ai.machinelearning.datascience.LinearRegression;
import com.architectcorner.ai.platform.esb.CsvParser;
import com.sun.image.codec.jpeg.JPEGCodec;

/**
 * @author bhagvan_kommadi
 *
 */
public class ChartingManager {
   private Color[] colors = new Color[11];
	/**
	 * 
	 */
	public ChartingManager() {
		// TODO Auto-generated constructor stub
		
		
		  
	}
	
	public void init()
	{
		colors[0] = Color.BLACK;
		  colors[1] = Color.BLUE;
		  colors[2] = Color.GREEN;
		  colors[3] = Color.MAGENTA;
		  colors[4] = Color.ORANGE;
		  colors[5] = Color.PINK;
		  colors[6] = Color.RED;
		  colors[7] = Color.YELLOW;
		  colors[8] = Color.LIGHT_GRAY;
		  colors[9] = Color.CYAN;
		  colors[10] = Color.DARK_GRAY;
	}
	public BufferedImage drawPieGraph(String[] xValues,String[] yValues,String title)
	{
		BufferedImage image = new BufferedImage(400,400, BufferedImage.TYPE_BYTE_INDEXED);
		Graphics2D graphics2D = image.createGraphics();
		graphics2D.setColor(Color.WHITE);
		Dimension dimension = new Dimension(image.getWidth(),image.getHeight());
		int width = dimension.width;
		int height = dimension.height;
		graphics2D.fillRect(0, 0, width, height);
		
		
		
		Font titleFont = new Font("SansSerif",Font.BOLD,20);
		FontMetrics titleFontMetrics = graphics2D.getFontMetrics(titleFont);
		Font labelFont = new Font("SansSerif",Font.BOLD,10);
		FontMetrics labelFontMetrics = graphics2D.getFontMetrics(labelFont);
		
		int titleWidth = titleFontMetrics.stringWidth(title);
		int y = titleFontMetrics.getAscent();
		int x = (width - titleWidth)/2;
		graphics2D.setColor(Color.BLACK);
		graphics2D.setFont(titleFont);
		graphics2D.drawString(title,x,y);
		
		double minXValue =0;
		double maxXValue =0;
		for(int i=0; i < xValues.length; i++)
		{
			double value = Double.parseDouble(xValues[i]);
			if(minXValue > value)
			{
				minXValue = value;
			}
			if(maxXValue < value)
			{
				maxXValue = value;
			}
		}
		
		double minYValue =0;
		double maxYValue =0;
		double totalYValue = 0;
		
		for(int i=0; i < yValues.length; i++)
		{
			double value = Double.parseDouble(yValues[i]);
			if(minYValue > value)
			{
				minYValue = value;
			}
			if(maxYValue < value)
			{
				maxYValue = value;
			}
			
			totalYValue += value;
		}
		
		System.out.println("TotalValue "+totalYValue);
		int top = titleFontMetrics.getHeight();
		int bottom = labelFontMetrics.getHeight();
		
		System.out.println("top, bottom "+top +" "+bottom);
		//if(maxValue == minValue)
       int left = 20;
		
	    int right = 30;
	    
	    
	    int xBound = width-left-right-150;
	    int yBound = top+10;
	    
	    Rectangle rectangle = new Rectangle();
		rectangle.setBounds(left+30, top+10, width-left-right-150, height-top-bottom-150);
		
		
		
	    System.out.println("left, right "+left +" "+right);
		//if(maxValue == minValue)
		
		double xScale = ((width - left - right-20)/ xValues.length);
		double yScale = ((height - top - bottom-50)/ maxYValue);
		
		System.out.println("maxXValue, maxYValue"+maxXValue+" "+maxYValue);
		System.out.println("xScale "+xScale);
		System.out.println("yScale "+yScale);
		int x0 = left+20;
		int y0 = height -top -bottom;
		
		
		System.out.println("X0, Y0 "+x0+" "+y0);
		
		  graphics2D.drawLine(left, height - top -bottom, left, top+bottom);
		  
		  graphics2D.drawLine(left, height - top -bottom, width-left-right,height-top-bottom);
		  
		  double curvature = 0.0D;
		  int angle =0;
		  
		  
		  
		  
		  for(int i=0; i< yValues.length; i++)
		  {
			  double yValue = Double.parseDouble(yValues[i]);
			  
			  double slice =  (yValue/totalYValue);
			  
			  angle = (int) (curvature*360);
			  
			  int endAngle = (int) (slice*360);
			  
			  System.out.println("yValue slice angle endAngle "+yValue+" "+slice+" "+angle+" "+endAngle);
			  System.out.println(colors[i].toString());
			  
			  graphics2D.setColor(colors[i]);
			  
			  graphics2D.fillArc(rectangle.x, rectangle.y, rectangle.width, rectangle.height, angle, endAngle);
			  
			  int xCenter = rectangle.x+(rectangle.width/2);
			  int yCenter = rectangle.y+(rectangle.height/2);
			 
			  int labelx1 =0;
			  int labely1 =0;
			  int labelx2=0;
			  int labely2=0;
			  
			  /*int totalAngle = angle +endAngle;
			  
			  if(totalAngle < 90)
			  {
			     labelx1 = xCenter + (rectangle.width/4);
			     labely1 = yCenter -(int) ((rectangle.width/2)*Math.sin(endAngle))+10;
			  
			     labelx2 = xCenter + (rectangle.width/2)+10;
			     labely2 = yCenter -(int) ((rectangle.width/2)*Math.sin(endAngle));
			  }
			  else if(totalAngle > 90 && totalAngle < 180)
			  {
				  labelx1 = xCenter - (rectangle.width/4);
				  labely1 = yCenter -(int) ((rectangle.width/2)*Math.sin(endAngle))+10;
				  
				     labelx2 = xCenter - (rectangle.width/2)-10;
				     labely2 = yCenter -(int) ((rectangle.width/2)*Math.sin(endAngle));
			  }
			  else if(endAngle > 180 && endAngle < 270)
			  {
				  labelx1 = xCenter - (rectangle.width/4);
				  labely1 = yCenter +(int) ((rectangle.width/2)*Math.sin(endAngle-angle))+10;
				  
				     labelx2 = xCenter - (rectangle.width/2)-10;
				     labely2 = yCenter +(int) ((rectangle.width/2)*Math.sin(endAngle-angle));
			  }
			  else if(endAngle > 270 && endAngle < 360)
			  {
				  labelx1 = xCenter + (rectangle.width/4);
				  labely1 = yCenter +(int) ((rectangle.width/2)*Math.sin(endAngle-angle))+10;
				  
				     labelx2 = xCenter + (rectangle.width/2)+10;
				     labely2 = yCenter +(int) ((rectangle.width/2)*Math.sin(endAngle-angle));
			  }
			  System.out.println("xCenter yCenter"+xCenter+" "+yCenter);
			  
			 // graphics2D.drawString(xValues[i], labelx1, labely1);
			graphics2D.setColor(Color.BLACK); 
			graphics2D.setFont(labelFont);
			graphics2D.drawString(yValues[i], labelx2,labely2);*/
		

			  
			  int barWidth = 80;
			  int barHeight = 100/yValues.length;
			  
			  int legendx1 = xBound +80;
			  int legendy1 = yBound +100+i*barHeight;
			  
			  int legendx2 = xBound +100-50;
			  int legendy2 = yBound +100+i*barHeight;
			  
			  graphics2D.setColor(Color.BLACK);
			  graphics2D.setFont(labelFont);
			  graphics2D.drawString(xValues[i], legendx1, legendy1+(barHeight/2));
			  graphics2D.drawString(yValues[i], legendx1+barWidth+10, legendy1+(barHeight/2));
			  
			  graphics2D.setColor(colors[i]);
			  graphics2D.fillRect(legendx1+40,legendy1, barWidth/2, barHeight);
			  curvature += slice;
			  
		  }
		  
		  return image;
	}
	public BufferedImage drawFitLineGraph(String[] xValues, String[] yValues,String[] fitxValues,String[] fityValues,String title)
	{
		BufferedImage image = new BufferedImage(400,400, BufferedImage.TYPE_BYTE_INDEXED);
		Graphics2D graphics2D = image.createGraphics();
		graphics2D.setColor(Color.WHITE);
		Dimension dimension = new Dimension(image.getWidth(),image.getHeight());
		int width = dimension.width;
		int height = dimension.height;
		
		System.out.println("Width " +width);
		System.out.println("Height "+ height);
		graphics2D.fillRect(0, 0, width, height);
		Font titleFont = new Font("SansSerif",Font.BOLD,20);
		FontMetrics titleFontMetrics = graphics2D.getFontMetrics(titleFont);
		Font labelFont = new Font("SansSerif",Font.BOLD,10);
		FontMetrics labelFontMetrics = graphics2D.getFontMetrics(labelFont);
		
		int titleWidth = titleFontMetrics.stringWidth(title);
		int y = titleFontMetrics.getAscent();
		int x = (width - titleWidth)/2;
		graphics2D.setColor(Color.BLACK);
		graphics2D.setFont(titleFont);
		graphics2D.drawString(title,x,y);
		
		double minXValue =0;
		double maxXValue =0;
		for(int i=0; i < xValues.length; i++)
		{
			double value = Double.parseDouble(xValues[i]);
			if(minXValue > value)
			{
				minXValue = value;
			}
			if(maxXValue < value)
			{
				maxXValue = value;
			}
		}
		
		double minYValue =0;
		double maxYValue =0;
		
		for(int i=0; i < yValues.length; i++)
		{
			double value = Double.parseDouble(yValues[i]);
			if(minYValue > value)
			{
				minYValue = value;
			}
			if(maxYValue < value)
			{
				maxYValue = value;
			}
		}
		int top = titleFontMetrics.getHeight();
		int bottom = labelFontMetrics.getHeight();
		
		System.out.println("top, bottom "+top +" "+bottom);
		//if(maxValue == minValue)
       int left = 20;
		
	    int right = 30;
		
	    System.out.println("left, right "+left +" "+right);
		//if(maxValue == minValue)
		
		double xScale = ((width - left - right-20)/ xValues.length);
		double yScale = ((height - top - bottom-50)/ maxYValue);
		
		System.out.println("maxXValue, maxYValue"+maxXValue+" "+maxYValue);
		System.out.println("xScale "+xScale);
		System.out.println("yScale "+yScale);
		int x0 = left+20;
		int y0 = height -top -bottom;
		
		
		System.out.println("X0, Y0 "+x0+" "+y0);
		
		  graphics2D.drawLine(left, height - top -bottom, left, top+bottom);
		  
		  graphics2D.drawLine(left, height - top -bottom, width-left-right,height-top-bottom);
		  
		for(int i=0; i< yValues.length; i++)
		{
			int xValue2=0;
			
			if(i != yValues.length-1)
			{
			   int x1 = Integer.parseInt(xValues[i]);
			   int y1 = Integer.parseInt(yValues[i]);
			   
			   int xValue1 = x0+(int) (i*xScale);
			   int yValue1 = y0-(int) (y1*yScale);
			   
			   int x2 = Integer.parseInt(xValues[i+1]);
			   int y2 = Integer.parseInt(yValues[i+1]);
			
			   xValue2 = x0+(int) ((i+1)*xScale) ;
			   int yValue2 = y0-(int) (y2*yScale);
			   
			   //System.out.println("x1,y1,x2,y2 " + x1 +" "+y1+" "+x2+" "+y2);
			   System.out.println("x1,y1,x2,y2 " + xValue1 +" "+yValue1+" "+xValue2+" "+yValue2);
			   graphics2D.setColor(Color.BLACK); 
			   graphics2D.drawLine(xValue1, yValue1, xValue2, yValue2);
			   graphics2D.drawString(yValues[i], xValue1, yValue1);
			   graphics2D.drawString(yValues[i+1], xValue2, yValue2);
			   
			   graphics2D.drawString(xValues[i], xValue1, height-top+10);
			}
			else
			{
				xValue2 = x0+(int) (i*xScale) ;
				graphics2D.drawString(xValues[i], xValue2, height-top+10);
			}
		}
		double minfitXValue =0;
		double maxfitXValue =0;
		for(int i=0; i < fitxValues.length; i++)
		{
			double value = Double.parseDouble(fitxValues[i]);
			if(minfitXValue > value)
			{
				minfitXValue = value;
			}
			if(maxfitXValue < value)
			{
				maxfitXValue = value;
			}
		}
		
		double minfitYValue =0;
		double maxfitYValue =0;
		
		for(int i=0; i < fityValues.length; i++)
		{
			double value = Double.parseDouble(fityValues[i]);
			if(minfitYValue > value)
			{
				minfitYValue = value;
			}
			if(maxfitYValue < value)
			{
				maxfitYValue = value;
			}
		}
		//int top = titleFontMetrics.getHeight();
		//int bottom = labelFontMetrics.getHeight();
		
		//System.out.println("top, bottom "+top +" "+bottom);
		//if(maxValue == minValue)
       //int left = 20;
		
	    //int right = 30;
		
	    //System.out.println("left, right "+left +" "+right);
		//if(maxValue == minValue)
		
		//double xScale = ((width - left - right-20)/ xValues.length);
		double fityScale = ((height - top - bottom-50)/ maxfitYValue);
		
		System.out.println("maxXValue, maxFitYValue"+maxXValue+" "+maxfitYValue);
		//System.out.println("xScale "+xScale);
		//System.out.println("yScale "+yScale);
		//int x0 = left+20;
		//int y0 = height -top -bottom;
		
		
		//System.out.println("X0, Y0 "+x0+" "+y0);
		
		  //graphics2D.drawLine(left, height - top -bottom, left, top+bottom);
		  
		  //graphics2D.drawLine(left, height - top -bottom, width-left-right,height-top-bottom);
		  
		//for(int i=0; i< fityValues.length; i++)
		//{
			int xValue2=0;
			
			//if(i != fityValues.length-1)
			//{
			   int x1 = Integer.parseInt(fitxValues[0]);
			   int y1 = Integer.parseInt(fityValues[0]);
			   
			  // int xValue1 = x0+(int) (i*xScale);
			   int xValue1 = x0;
			   int yValue1 = y0-(int) (y1*fityScale);
			   
			   int x2 = Integer.parseInt(fitxValues[fityValues.length-1]);
			   int y2 = Integer.parseInt(fityValues[fityValues.length-1]);
			
			   xValue2 = x0+(int) ((fitxValues.length)*xScale) ;
			   int yValue2 = y0-(int) (y2*fityScale);
			   
			   //System.out.println("x1,y1,x2,y2 " + x1 +" "+y1+" "+x2+" "+y2);
			   //System.out.println("x1,y1,x2,y2 " + xValue1 +" "+yValue1+" "+xValue2+" "+yValue2);
			   graphics2D.setColor(Color.GREEN); 
			   graphics2D.drawLine(xValue1, yValue1, xValue2, yValue2);
			   //graphics2D.drawString(fityValues[i], xValue1, yValue1);
			   //graphics2D.drawString(fityValues[i+1], xValue2, yValue2);
			   
			   //graphics2D.drawString(xValues[i], xValue1, height-top+10);
			//}
			/*else
			{
				xValue2 = x0+(int) (i*xScale) ;
				graphics2D.drawString(xValues[i], xValue2, height-top+10);
			}*/
		//}
		return image;
	}
	
	public BufferedImage drawLineGraph(String[] xValues, String[] yValues,String title)
	{
		BufferedImage image = new BufferedImage(400,400, BufferedImage.TYPE_BYTE_INDEXED);
		Graphics2D graphics2D = image.createGraphics();
		graphics2D.setColor(Color.WHITE);
		Dimension dimension = new Dimension(image.getWidth(),image.getHeight());
		int width = dimension.width;
		int height = dimension.height;
		
		System.out.println("Width " +width);
		System.out.println("Height "+ height);
		graphics2D.fillRect(0, 0, width, height);
		Font titleFont = new Font("SansSerif",Font.BOLD,20);
		FontMetrics titleFontMetrics = graphics2D.getFontMetrics(titleFont);
		Font labelFont = new Font("SansSerif",Font.BOLD,10);
		FontMetrics labelFontMetrics = graphics2D.getFontMetrics(labelFont);
		
		int titleWidth = titleFontMetrics.stringWidth(title);
		int y = titleFontMetrics.getAscent();
		int x = (width - titleWidth)/2;
		graphics2D.setColor(Color.BLACK);
		graphics2D.setFont(titleFont);
		graphics2D.drawString(title,x,y);
		
		double minXValue =0;
		double maxXValue =0;
		for(int i=0; i < xValues.length; i++)
		{
			double value = Double.parseDouble(xValues[i]);
			if(minXValue > value)
			{
				minXValue = value;
			}
			if(maxXValue < value)
			{
				maxXValue = value;
			}
		}
		
		double minYValue =0;
		double maxYValue =0;
		
		for(int i=0; i < yValues.length; i++)
		{
			double value = Double.parseDouble(yValues[i]);
			if(minYValue > value)
			{
				minYValue = value;
			}
			if(maxYValue < value)
			{
				maxYValue = value;
			}
		}
		int top = titleFontMetrics.getHeight();
		int bottom = labelFontMetrics.getHeight();
		
		System.out.println("top, bottom "+top +" "+bottom);
		//if(maxValue == minValue)
       int left = 20;
		
	    int right = 30;
		
	    System.out.println("left, right "+left +" "+right);
		//if(maxValue == minValue)
		
		double xScale = ((width - left - right-20)/ xValues.length);
		double yScale = ((height - top - bottom-50)/ maxYValue);
		
		System.out.println("maxXValue, maxYValue"+maxXValue+" "+maxYValue);
		System.out.println("xScale "+xScale);
		System.out.println("yScale "+yScale);
		int x0 = left+20;
		int y0 = height -top -bottom;
		
		
		System.out.println("X0, Y0 "+x0+" "+y0);
		
		  graphics2D.drawLine(left, height - top -bottom, left, top+bottom);
		  
		  graphics2D.drawLine(left, height - top -bottom, width-left-right,height-top-bottom);
		  
		for(int i=0; i< yValues.length; i++)
		{
			int xValue2=0;
			
			if(i != yValues.length-1)
			{
			   int x1 = Integer.parseInt(xValues[i]);
			   int y1 = Integer.parseInt(yValues[i]);
			   
			   int xValue1 = x0+(int) (i*xScale);
			   int yValue1 = y0-(int) (y1*yScale);
			   
			   int x2 = Integer.parseInt(xValues[i+1]);
			   int y2 = Integer.parseInt(yValues[i+1]);
			
			   xValue2 = x0+(int) ((i+1)*xScale) ;
			   int yValue2 = y0-(int) (y2*yScale);
			   
			   //System.out.println("x1,y1,x2,y2 " + x1 +" "+y1+" "+x2+" "+y2);
			   System.out.println("x1,y1,x2,y2 " + xValue1 +" "+yValue1+" "+xValue2+" "+yValue2);
			   graphics2D.setColor(Color.BLACK); 
			   graphics2D.drawLine(xValue1, yValue1, xValue2, yValue2);
			   graphics2D.drawString(yValues[i], xValue1, yValue1);
			   graphics2D.drawString(yValues[i+1], xValue2, yValue2);
			   
			   graphics2D.drawString(xValues[i], xValue1, height-top+10);
			}
			else
			{
				xValue2 = x0+(int) (i*xScale) ;
				graphics2D.drawString(xValues[i], xValue2, height-top+10);
			}
		}
		
		return image;
	}
	

	
	public BufferedImage drawScaledBarGraph(String[] xValues,String[] yValues, boolean horizontal,String title)
	{
		double minYValue =0;
		double maxYValue =0;
		
		for(int i=0; i < yValues.length; i++)
		{
			double value = Double.parseDouble(yValues[i]);
			if(minYValue > value)
			{
				minYValue = value;
			}
			if(maxYValue < value)
			{
				maxYValue = value;
			}
		}
		
		BufferedImage image = new BufferedImage(500, 500, BufferedImage.TYPE_BYTE_INDEXED);
		Graphics2D graphics2D = image.createGraphics();
		graphics2D.setColor(Color.WHITE);
		Dimension dimension = new Dimension(image.getWidth(),image.getHeight());
		int width = dimension.width;
		int height = dimension.height;
		
		graphics2D.fillRect(0, 0, width, height);
		
		int barWidth = 0;
		int barHeight = 0;
		
		if(!horizontal)
		{
		  barWidth = (width-50)/yValues.length;
		}
		else
		{
			barHeight = (height-50)/yValues.length;
		}
		Font titleFont = new Font("SansSerif",Font.BOLD,20);
		FontMetrics titleFontMetrics = graphics2D.getFontMetrics(titleFont);
		Font labelFont = new Font("SansSerif",Font.BOLD,10);
		FontMetrics labelFontMetrics = graphics2D.getFontMetrics(labelFont);
		
		int titleWidth = titleFontMetrics.stringWidth(title);
		int y = titleFontMetrics.getAscent();
		int x = (width - titleWidth)/2;
		graphics2D.setColor(Color.BLACK);
		graphics2D.setFont(titleFont);
		graphics2D.drawString(title,x,y);
		
		int top = titleFontMetrics.getHeight();
		int bottom = labelFontMetrics.getHeight();
		
		
		double scale = (height - top - bottom)/ (maxYValue - minYValue);
		if(horizontal)
		{
		  y = (height - 40)/2;
		}
		else
		{
		  y = height - labelFontMetrics.getDescent();
		}
		graphics2D.setFont(labelFont);
		
		for(int i=0; i< yValues.length;i++)
		{
			int xValue =0;
			int yValue =0;
			
			if(!horizontal)
			{
			  xValue = i*barWidth +10;
			  yValue = top+50;
			}
			else
			{
				xValue = 50;
				yValue = i*barHeight +50+titleFontMetrics.getAscent();
			}
			int iYValue = Integer.parseInt(yValues[i]);
			
			if(!horizontal)
			{
			    barHeight = (int) (iYValue * scale)-40;
			}
			else
			{
				barWidth = (int) (iYValue * scale) - 40;
			}
			if(!horizontal)
			{
				if(iYValue >= 0)
				{
					yValue += (int) ((maxYValue - iYValue)*scale);
					
				}
				else
				{
					yValue += (int) (maxYValue * scale);
					barHeight = -barHeight;
				}
			}
			else
			{
				if(iYValue >= 0)
				{
					//xValue +=(int) ((maxYValue - iYValue)*scale);
					
					//yValue += i*barHeight+10;
				}
				else
				{
					//yValue += i*barHeight+10;
					//xValue += (int) (maxYValue *scale);
					barWidth = -barWidth;
				}
			}
			
		
		/*graphics2D.setColor(Color.RED);
		graphics2D.fillRect(xValue, yValue-20, barWidth-20, barHeight);
		graphics2D.setColor(Color.BLACK);
		graphics2D.drawRect(xValue,yValue-20, barWidth-20, barHeight);*/
		if(!horizontal)
		{
			graphics2D.setColor(Color.BLUE);
			graphics2D.fillRect(xValue, yValue-20, barWidth-20, barHeight);
			graphics2D.setColor(Color.BLACK);
			graphics2D.drawRect(xValue, yValue-20, barWidth-20, barHeight);
			
			graphics2D.setColor(Color.BLACK);
			graphics2D.setFont(labelFont);
			graphics2D.drawString(yValues[i],xValue,yValue-30);
			
			int labelWidth = labelFontMetrics.stringWidth(xValues[i]);
			x = (i* barWidth) + ((barWidth - labelWidth)/2);
			graphics2D.setColor(Color.BLACK);
			graphics2D.setFont(labelFont);
			graphics2D.drawString(xValues[i], x, y);
		}
		else
		{
			graphics2D.setColor(Color.BLUE);
			graphics2D.fillRect(xValue,yValue-20, barWidth-20, barHeight-20);
			graphics2D.setColor(Color.BLACK);
			graphics2D.drawRect(xValue, yValue-20, barWidth-20, barHeight-20);
			
			graphics2D.setColor(Color.BLACK);
			graphics2D.setFont(labelFont);
			graphics2D.drawString(xValues[i], xValue-30, yValue);
			
			int labelWidth = labelFontMetrics.stringWidth(xValues[i]);
			//y = (i*barWidth)+((barWidth-labelWidth)/2);
			x = xValue+barWidth-20+10;
			graphics2D.setColor(Color.BLACK);
			graphics2D.setFont(labelFont);
			//graphics2D.drawString(yValues[i], xValue, height-5);
			graphics2D.drawString(yValues[i], x, yValue);
		}
			
		
	}
		
		return image;
	}
	public BufferedImage drawBarGraph(String[] xValues,String[] yValues,boolean horizontal,String message)
	{
		BufferedImage image;
		Graphics2D graphics2D;
		
		
		
		if(horizontal)
		{
		  image = new BufferedImage(800,800,BufferedImage.TYPE_BYTE_INDEXED);
		  graphics2D = image.createGraphics();
		  graphics2D.fillRect(0, 0, 800, 800);
		  graphics2D.setColor(Color.WHITE);
		}
		else
		{
		  image = new BufferedImage(400,800, BufferedImage.TYPE_BYTE_INDEXED);
		  graphics2D = image.createGraphics();
		  graphics2D.fillRect(0, 0, 400, 800);
		  graphics2D.setColor(Color.WHITE);
		}
		
		Font font = new Font("Arial",Font.BOLD,15);
		for(int i=0; i < xValues.length; i++)
		{
			
			
			int yIntValue = Integer.parseInt(yValues[i]);
			
			if(horizontal)
			{
				graphics2D.setColor(Color.BLACK);
				graphics2D.setFont(font);	
				graphics2D.drawString(xValues[i], 20, (i*50+30));
				graphics2D.setColor(Color.BLUE);
				graphics2D.fillRect(70, (i*50+10), yIntValue, 40);
				graphics2D.setColor(Color.BLACK);
				graphics2D.setFont(font);
				graphics2D.drawString(String.valueOf(yIntValue), 180, (i*50+35));
			}
			else
			{
				
				graphics2D.setColor(Color.BLUE);
				graphics2D.fillRect((i*50+10), 700-50-yIntValue, 40, yIntValue);
				graphics2D.setColor(Color.BLACK);
				graphics2D.setFont(font);
				graphics2D.drawString(String.valueOf(yIntValue), (i*50+10), 550);
				graphics2D.setColor(Color.BLACK);
				graphics2D.setFont(font);
				graphics2D.drawString(xValues[i],(i*50+30),700);
			}
			
			
			graphics2D.setColor(Color.DARK_GRAY);
			
			Font titleFont = new Font("Arial",Font.BOLD,20);
			graphics2D.setFont(titleFont);
			graphics2D.drawString(message, 50, 750);
		
		}
		
		return image;
	}
	public BufferedImage drawText(String text)
	{
		BufferedImage image  = new BufferedImage(500,40,BufferedImage.TYPE_BYTE_INDEXED);
	    Graphics2D graphics2D = image.createGraphics();
		graphics2D.setColor(Color.WHITE);
		graphics2D.fillRect(0, 0, 500, 100);
        
		GradientPaint gradientPaint = new GradientPaint(10,5,Color.BLUE,20,10,Color.LIGHT_GRAY,true);
	    graphics2D.setPaint(gradientPaint);
	    Font font = new Font("Comic Sans MS",Font.BOLD,30);
	    graphics2D.setFont(font);
	    graphics2D.drawString(text,5,30);
	    
	    graphics2D.dispose();
	    
	    return image;
	}
	public void writeImage(String filePath,BufferedImage image)
	{
		System.out.println(filePath);
		
		// filePath="/Users/bhagvan_kommadi/Desktop/Turbizo/EarthQuakes.jpg";
		File file = new File(filePath);
		try
		{
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			
			if(!file.exists())
			{
				file.createNewFile();
			}
			
	
	    
	    JPEGCodec.createJPEGEncoder(fileOutputStream).encode(image);
	    
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
	}
	
	
	public Map<String,String> parseProperties(String fileName)
	{
		CsvParser parser = new CsvParser();
		Map<String,String> map = new HashMap();
		List<List<String>> properties = parser.parse(fileName);
		for(List<String> property: properties)
		{				
				map.put(property.get(0), property.get(1));
		
		}
		return map;
		
	}
	
	public void generateGraph(List<List<String>> values,Map<String,String> map)
	{
		String[] xValues = new String[values.size()-1];
		String[] yValues = new String[values.size()-1];
		
		int i=0;
		for(List<String> value: values)
		{
			if(i==0)
			{
				
			}
			else
			{
				
				xValues[i-1] = value.get(0);
				yValues[i-1] = value.get(1);
			}
			i++;
		}		
		BufferedImage image = null;
		if(map.get("graphtype").equals("verticalbargraph"))
		{
		  image = drawScaledBarGraph(xValues, yValues, false,map.get("graphname"));
		  
		}		
		else if(map.get("graphtype").equals("linegraph"))
		{
			image = drawLineGraph(xValues, yValues, map.get("graphname"));
		}
		else if(map.get("graphtype").equals("piegraph"))
		{
			image = drawPieGraph(xValues,yValues,map.get("graphname"));
		}
		
		writeImage(map.get("filename"), image);
		
	}
	public void generateGraph(Map<String,String> map)
	{
		CsvParser parser = new CsvParser();
		
		List<List<String>> values = parser.parse(map.get("csv"));
		
		String[] xValues = new String[4];
		String[] yValues = new String[4];
		
		int i=0;
		for(List<String> value: values)
		{
			if(i==0)
			{
				
			}
			else
			{
				
				xValues[i-1] = value.get(0);
				yValues[i-1] = value.get(1);
			}
			i++;
		}		
		BufferedImage image = null;
		if(map.get("graphtype").equals("verticalbargraph"))
		{
		  image = drawScaledBarGraph(xValues, yValues, false,map.get("graphname"));
		  
		}		
		else if(map.get("graphtype").equals("linegraph"))
		{
			image = drawLineGraph(xValues, yValues, map.get("graphname"));
		}
		else if(map.get("graphtype").equals("piegraph"))
		{
			image = drawPieGraph(xValues,yValues,map.get("graphname"));
		}
		
		writeImage(map.get("filename"), image);
	}
	
	public void generateFitGraph(Map<String,String> map)
	{
		CsvParser parser = new CsvParser();
		
		List<List<String>> values = parser.parse(map.get("csv"));
		
		String[] xValues = new String[values.size()-1];
		String[] yValues = new String[values.size()-1];
		
		double[] xrValues = new double[values.size()-1];
		double[] yrValues = new double[values.size()-1];
		
		
		String[] xRValues = new String[values.size()-1];
		String[] yRValues = new String[values.size()-1];
		
		
		
		
		int i=0;
		for(List<String> value: values)
		{
			if(i==0)
			{
				
			}
			else
			{
				
				xValues[i-1] = value.get(0);
				yValues[i-1] = value.get(1);
			}
			i++;
		}		
		
		int maxRows = i-1;
		
		
		
		for(int j=0; j< maxRows; j++)
		{
			System.out.println(xValues[j]);
		    xrValues[j] = Double.parseDouble(xValues[j]);    
		    System.out.println(yrValues[j]);
		    yrValues[j] = Double.parseDouble(yValues[j]);
		}
		
		LinearRegression regression = new LinearRegression();
		List<Double> fitCoeffs = regression.getLinearFit(xrValues, yrValues);
		for(int j=0; j< maxRows; j++)
		{
			
		    xRValues[j] = xValues[j];
		    
		    System.out.println(fitCoeffs.get(0));
		    System.out.println(fitCoeffs.get(1));
		    
		    double yValue = (xrValues[j]*fitCoeffs.get(0)) + fitCoeffs.get(1);
		    
		    
		    //double yDoubleValue = Math.floor(yValue);
		    
		   // int yIntValue = Integer.parseInt(String.valueOf(yDoubleValue));
		    
		    //TBD rounding up
		    long yIntValue = Math.round(yValue);
		    System.out.println(yIntValue);
		    yRValues[j] = String.valueOf(yIntValue);
		}
		BufferedImage image = null;
		if(map.get("graphtype").equals("verticalbargraph"))
		{
		  image = drawScaledBarGraph(xValues, yValues, false,map.get("graphname"));
		  
		}		
		else if(map.get("graphtype").equals("linegraph"))
		{
			image = drawFitLineGraph(xValues, yValues,xRValues,yRValues, map.get("graphname"));
		}
		else if(map.get("graphtype").equals("piegraph"))
		{
			image = drawPieGraph(xValues,yValues,map.get("graphname"));
		}
		
		writeImage(map.get("filename"), image);
	}
	public void generateFitGraph(List<List<String>> values,Map<String,String> map)
	{
		CsvParser parser = new CsvParser();
		
		//List<List<String>> values = parser.parse(map.get("csv"));
		
		String[] xValues = new String[values.size()-1];
		String[] yValues = new String[values.size()-1];
		
		double[] xrValues = new double[values.size()-1];
		double[] yrValues = new double[values.size()-1];
		
		
		String[] xRValues = new String[values.size()-1];
		String[] yRValues = new String[values.size()-1];
		
		
		
		
		int i=0;
		for(List<String> value: values)
		{
			if(i==0)
			{
				
			}
			else
			{
				
				xValues[i-1] = value.get(0);
				yValues[i-1] = value.get(1);
			}
			i++;
		}		
		
		int maxRows = i-1;
		
		
		
		for(int j=0; j< maxRows; j++)
		{
			System.out.println(xValues[j]);
		    xrValues[j] = Double.parseDouble(xValues[j]);    
		    System.out.println(yrValues[j]);
		    yrValues[j] = Double.parseDouble(yValues[j]);
		}
		
		LinearRegression regression = new LinearRegression();
		List<Double> fitCoeffs = regression.getLinearFit(xrValues, yrValues);
		for(int j=0; j< maxRows; j++)
		{
			
		    xRValues[j] = xValues[j];
		    
		    System.out.println(fitCoeffs.get(0));
		    System.out.println(fitCoeffs.get(1));
		    
		    double yValue = (xrValues[j]*fitCoeffs.get(0)) + fitCoeffs.get(1);
		    
		    
		    //double yDoubleValue = Math.floor(yValue);
		    
		   // int yIntValue = Integer.parseInt(String.valueOf(yDoubleValue));
		    
		    //TBD rounding up
		    long yIntValue = Math.round(yValue);
		    System.out.println(yIntValue);
		    yRValues[j] = String.valueOf(yIntValue);
		}
		BufferedImage image = null;
		if(map.get("graphtype").equals("verticalbargraph"))
		{
		  image = drawScaledBarGraph(xValues, yValues, false,map.get("graphname"));
		  
		}		
		else if(map.get("graphtype").equals("linegraph"))
		{
			image = drawFitLineGraph(xValues, yValues,xRValues,yRValues, map.get("graphname"));
		}
		else if(map.get("graphtype").equals("piegraph"))
		{
			image = drawPieGraph(xValues,yValues,map.get("graphname"));
		}
		
		writeImage(map.get("filename"), image);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChartingManager manager = new ChartingManager();
		manager.init();
		//BufferedImage image = manager.drawText("Belfort Telecom Framework");
		
		Map<String,String> properties = manager.parseProperties("/Users/bhagvan_kommadi/Desktop/Temp/properties.csv");
		manager.generateFitGraph(properties);

	}

}
