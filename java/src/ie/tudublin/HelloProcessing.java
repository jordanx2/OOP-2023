package ie.tudublin;

import processing.core.PApplet;

public class HelloProcessing extends PApplet
{

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		colorMode(HSB);
		background(0);
	}
	
	public void draw()
	{	
		background(0);
		noStroke();
		fill(random(255), 255, 255);
		circle(random(width), random(height), 50);


		// All seeing eye sketch
		// noStroke();
		// fill(255, 255, 0);	
		// circle(width/2, height/2, 425); // cx, cy, d

		// fill(0, 255, 255);	
		// triangle(50, height - 50, width/2, 0, width - 50, height-50);

		// fill(200);
		// ellipse(width/2, height/2, 220, mouseY);

		// fill(0);
		// ellipse(width/2, height/2, 100, mouseY);

	}
}
