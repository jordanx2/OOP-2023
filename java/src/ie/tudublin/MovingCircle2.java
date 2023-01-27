package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class MovingCircle2 extends PApplet{
	private ArrayList<Circle> circles = new ArrayList<>();

	public void settings()
	{
		size(1040, 560);
	}

	public void setup() {
		for(int i = 0; i < 1; i++ ){
			Circle circle = new Circle();

			circle.xpos = random(circle.rad, (width - circle.rad));
			circle.ypos = random(circle.rad, (height - circle.rad));
			circles.add(circle);
			fill(circle.color);
		}

		// Circle circle = new Circle();
		// circle.xpos = width / 2;
		// circle.ypos = height / 2;
		// circles.add(circle);

		frameRate(25);
		ellipseMode(RADIUS);
		colorMode(HSB);
		noStroke();
		fill(random(50, 255), 255, 255);
		
	}
	
	public void draw()
	{	
		background(0);

		for(Circle circle : circles){
			circle.angle += 0.1;
			circle.xpos = width / 2 + cos(circle.angle) * circle.rad*2;
			circle.ypos = height / 2 + sin(circle.angle) * circle.rad*2;

			if(floor(circle.angle) % floor(TWO_PI) == 0 && circle.angle > 1.0f){
				fill(random(255), random(255), random(255));

			}
			ellipse(circle.xpos, circle.ypos, circle.rad, circle.rad);			
			
		}


	}
}
