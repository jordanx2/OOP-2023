package ie.tudublin;

import processing.core.PApplet;

public class HelloProcessing extends PApplet
{

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		// colorMode(HSB);
		background(0);

	}
	
	public void draw()
	{	
		stroke(255);
		line(10,10,100,100); // x1, y1, x2, y2
		circle(300, 250, 70); // cx, cy, d
		fill(0, 250, 0);
		rect(110, 300, 20, 100); // tlx, tly,  w, h
		stroke(127);
		fill(0, 0, 250);
		noStroke();
		noFill();
		strokeWeight(1);
		triangle(40, 90, 300, 20, 80, 70);
		triangle(X, Y, X, Y, X, Y);
		fill(0, 0, 250);
	}
}
