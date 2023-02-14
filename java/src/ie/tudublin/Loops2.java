package ie.tudublin;

import processing.core.PApplet;

public class Loops2 extends PApplet {

	public void settings() {
		size(800, 800);
	}

	public void setup() {
		noStroke();
		colorMode(HSB, 125, 100, 100);
		
	}

	public void draw() {
		background(0);
		textGrid();
	}	

	public void textGrid(){
		stroke(35, 255, 255);
		int num = 10;
		int border = 75;
		for(int i = 0; i < num; i++){
			line(0 + border, 0 + border, 0 + border, height - border);
		}	
	}
	
}
