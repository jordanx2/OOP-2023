package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class SineWave extends PApplet{
	float squareSize = 10;
	int padding = 10;
	float time = 0;
	float speed = 0.05f;

	// Used to display the vertical size of the wave
	int amplitude = 450;

	// Used to calculate the horizontal position of the wave
	float frequency;
	float freq = 5.5f;

	/*
	 * position of the sine wave along the x-axis
	 * increasing or decreasing this value affects the speed of the animation
	 */
	float phase;

	//  Sine function used to calculate the vertical position of the wave
	int sineY;

	// Colors used to create the fading effect on the wave
	int startColor = color(random(255), 255, 255);
	int endColor = color(random(255), 255, 255);

	ArrayList<Square> squares = new ArrayList<>();

	public void settings()
	{
		// fullScreen();
		size(1040, 560);
	}

	public void setup() {
		frameRate(50);
		strokeWeight(5);
		stroke(255, 255, 255);
		fill(0);
		colorMode(HSB);
	}
	
	public void draw()
	{	
		// Repeatingly draw the background as black
		background(0);
		for(int x = padding; x < width; x+= (squareSize + 10)){
			for(int y = padding; y < height; y+= (squareSize + 10)){
				drawSquare(x, y);
			}
		}
		time += 0.01;
		if(time > 1){
			time = 0;
			startColor = color(random(255), 255, 255);
			endColor = color(random(255), 255, 255);
			// amplitude += 5;
			// freq -= 2f;
			// if(freq == 0){
			// 	freq = 25f;
			// }	
			// System.out.println(freq);
		}
		
	}

	public void drawSquare(float x, float y){
		phase = frameCount * speed;

		frequency = 0.05f / freq;
		sineY = (int) (amplitude * sin(frequency * x  + phase));

		// LerpColor -> used to blend two colors based upon a specific amount of time 
		stroke(lerpColor(startColor, endColor, time));
		square(x, y + sineY, squareSize);
	}




}
