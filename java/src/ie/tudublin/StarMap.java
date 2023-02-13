package ie.tudublin;

import processing.core.PApplet;

public class StarMap extends PApplet
{
	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		colorMode(HSB);
		background(0);
		stroke(255);
		strokeWeight(2);	
		smooth();
		
	}

	public void drawGrid(){
		float border = 50f;

		// determines the number of lines to be drawn
		int count = 10;

		// Defines the gaps between all of the lines
		float gap = (width - (border * 2.0f)) / count;

		for(int i = -5; i <= 5; i++){	
			float x =  border + (gap * (i + 5));

			/*
			 * Here is an explaintation of the parameters: 
			 * 	the parameters are basically x1, y1, x2, y2
			 * 	x1, y1 
			 * 	-> draws from the current x position to the top of sketch, current position + up
			 	x2, y2
				-> draws from the current x position to the bottom of the sketch, current position + down 
			 */
			// verticle line
			line(border, x, width - border, x);

			// horizontal
			line(x, border, x, height - border);
			
		}
	}



	public void drawGrid2(){
		
	}

		
	public void draw()
	{	
		drawGrid();	
	}
}
