package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class Lines extends PApplet{
	float squareSize = 15f;
	int padding = 10;
	int amplitude = 0;
	float frequency = 0f;

	ArrayList<Square> squares = new ArrayList<>();

	public void settings()
	{
		size(1040, 560);
	}

	public void setup() {
		frameRate(1);
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
		frequency++;
		amplitude++;
	}

	public void drawSquare(float x, float y){
		int sineY = (int) (amplitude * sin(frequency * x  * 0.05f));
		if(x + sineY < height / 2){
			stroke(255,255,255);
		} else{
			stroke(255);
		}
		square(x, y + sineY, squareSize);
	}
}
