package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class MovingCircle extends PApplet
{
	private ArrayList<Circle> circles = new ArrayList<>();

	public void settings()
	{
		size(1040, 560);
	}

	public void setup() {
		// noStroke(),;
		for(int i = 0; i < 1; i++ ){
			Circle circle = new Circle();

			circle.xpos = random(circle.rad, (width - circle.rad));
			circle.ypos = random(circle.rad, (height - circle.rad));
			circles.add(circle);
			fill(circle.color);
		}

		frameRate(300);
		ellipseMode(RADIUS);
		colorMode(HSB);
		noStroke();
	}
	
	public void draw()
	{	
		background(0);
		for(Circle circle : circles){
			circle.xpos = circle.xpos + (circle.xspeed * circle.xdirection);
			circle.ypos = circle.ypos + (circle.yspeed * circle.ydirection);
			
			// Left and right collision
			if(circle.xpos > width- circle.rad || circle.xpos < circle.rad){
				fill(random(50, 255), 255, 255);
				circle.xdirection *= -1;
			}
	
			if(circle.ypos > height-circle.rad || circle.ypos < circle.rad){
				fill(random(50, 255), 255, 255);
				circle.ydirection *= -1;
			}

			ellipse(circle.xpos, circle.ypos, circle.rad, circle.rad);			
			
		}

	}
}
