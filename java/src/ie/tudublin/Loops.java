package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet {

	boolean jump = false;
	boolean start = false;
	int increment = 0;
	int squareW;
	int center;
	int startPos;
	int mode = 0;
	int drawing = 1;

	public void settings() {
		size(800, 800);
	}

	public void setup() {
		noStroke();
		colorMode(HSB, 360, 100, 100);
		squareW = width / 3;
		startPos = (width / 2) + increment;
		center = (startPos + (squareW / 2)) - 10;
		increment = squareW / 3;
	}



	public void keyPressed() {
		mode = key - '0';
		switch(mode){
			case 1: 
				drawing = 1;
				break;
			case 2:
				drawing = 2;
				break;
			
			case 3: 
				drawing = 3;
				break;
		}


	}

	public void draw() {
		background(0);
		switch(drawing){
			case 1: 
				example1();
				break;
			case 2:
				drawRainbow();
				break;
			
			case 3: 
				sideWaysRec();
				break;
			
		}
		
	}

	public void example1(){
		if(hitCenter()){
			start = true;
		}

		if(start){
			rect(startPos, 10, squareW, height - 40);	
			if(hitCenter()){
				if(jump){
					center += increment;
					startPos += increment;
					jump = false;
				} else{
					center -= increment;
					startPos -= increment;
					jump = true;
				}
	
			}
		} else{
			rect(startPos, 10, squareW, height - 40);	
		}
	}

	public boolean hitCenter(){
		if((mouseY - (height / 2)) < 20 && (center - mouseX) > 0 && (center - mouseX) < 20){
			return true;
		}

		return false;
	}
	
	public void drawRainbow(){
		int steps = 10;
		float stepSize = 360 / steps;
	  
		for(int i = 0; i < steps; i++){
			int hue = (int)(stepSize * i);
			fill(hue, 255, 255);
		  	rect(i * width/steps, 0, width/steps, height);
		}
	}

	public void sideWaysRec(){
		int numRect = 10;
		int rectSize = width /  numRect;
		for(int i = 0; i < numRect; i++){
			fill((i * numRect), 255, 255);
			rect(i * rectSize, i * rectSize, rectSize, rectSize);
		}
	}
	
}
