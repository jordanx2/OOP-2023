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
			
		}


		frameRate(20);
		ellipseMode(RADIUS);
		colorMode(HSB);
		noStroke();
		
	}
	
	public void draw()
	{	
		background(0);

		for (Circle circle : circles) {
			circle.xpos = width / 2 + cos(circle.angle) * outterCircleRadius*2;
			circle.ypos = height / 2 + sin(circle.angle) * outterCircleRadius*2;
			circle.angle += 0.1;

			drawCircle(circle.xpos, circle.ypos, circle.rad, circle.rad);			
		}

	}

	public void drawCircle(float x, float y, float r, float c){
		fill(random(0, 255), random(0, 255), random(0, 255));
		ellipse(x, y, r, c);			
	}
}
