package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class Lines extends PApplet{
	float squareSize = 10;
	int padding = 10;
	int amplitude = 250;
	// float frequency = 15f;

	float time = 0;

	ArrayList<Square> squares = new ArrayList<>();

	public void settings()
	{
		size(1040, 560);
	}

	public void setup() {
		frameRate(50);
		strokeWeight(5);
		// stroke(random(255), random(255), random(255));
		stroke(255, 255, 255);
		fill(0);
		colorMode(HSB);
	}
	
	public void draw()
	{	
		background(0);
		for(int x = padding; x < width; x+= (squareSize + 10)){
			for(int y = padding; y < height; y+= (squareSize + 10)){
				if(x < (width - squareSize) && y < (height - squareSize)){
					drawSquare(x, y);
				}		
			}
		}
		time += 0.01;
		if(time > 1){
			time = 0;
		}
		
	}

	public void drawSquare(float x, float y){
		float offset = frameCount * 0.05f;
		float frequency = 0.05f / 5.0f;
		
		int sineY = (int) (amplitude * sin(frequency * x  + offset));
		int startColor = color(random(255), 255, 255);
		int endColor = color(255, 255, random(255));
		stroke(lerpColor(startColor, endColor, time));
		square(x, y + sineY, squareSize);
	}


}
