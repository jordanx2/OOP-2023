package ie.tudublin;

import processing.core.PApplet;

public class Loops2 extends PApplet {

	public void settings() {
		size(800, 800);
	}

	public void setup() {
		noStroke();
		colorMode(RGB);
	}

	public void draw() {
		background(0);
		polygon();
	}	

	public void polygon(){
		circle(100, 100, 100);
	}
		
	
}
