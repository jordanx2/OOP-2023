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
		strokeWeight(3);

		int num = 10;
		float border = 75f;

		float gap = (width - (border * 2.0f)) / num;
		for(int i = -5; i <= 5; i++){
			float x = border + (gap * (i + 5));
			// X-axis numbering
			text(i, border / 2, x);

			// Y-axis numbering
			text(i, x, border / 2);
			line(border, x, width - border, x);
			line(x, border, x, height - border);
		}	
	}
	
}
