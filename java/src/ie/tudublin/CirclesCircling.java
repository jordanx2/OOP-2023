package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class CirclesCircling extends PApplet{
	private ArrayList<Circle> circles = new ArrayList<>();
	private int outterCircleRadius = 50;

	public void settings()
	{
		size(1040, 560);
	}

	public void setup() {
		for(int i = 0; i < 45; i++ ){
			Circle circle = new Circle();
			circle.angle = circle.rad + i;
		
			circles.add(circle);
			fill(circle.color);
		}


		frameRate(25);
		ellipseMode(RADIUS);
		colorMode(HSB);
		noStroke();
		fill(random(50, 255), 255, 255);
		
	}
	
	public void draw()
	{	
		background(0);

		for (Circle circle : circles) {
			circle.xpos = width / 2 + cos(circle.angle) * outterCircleRadius*2;
			circle.ypos = height / 2 + sin(circle.angle) * outterCircleRadius*2;
			circle.angle += 0.1;

			ellipse(circle.xpos, circle.ypos, circle.rad, circle.rad);			
		}

	}
}
