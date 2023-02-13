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
		size(1200, displayHeight - 100);
	}

	public void setup() {
		// fill(0, 255, 255);
		// stroke(255, 0, 0);
		// strokeWeight(5);
		noStroke();
		colorMode(HSB);
		squareW = width / 3;
		startPos = (width / 2) + increment;
		center = (startPos + (squareW / 2)) - 10;
		increment = squareW / 3;
		// frameRate(2);
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
		}


	}

	public void draw() {
		background(0);
		switch(drawing){
			case 1: 
				example1();
				break;
			case 2:
				example2();
				break;
		}
		
	}

	private void example2() {
		colorMode(HSB);
		int rectWidth = 100;
		for(int x = 0; x < width - rectWidth; x+=rectWidth){
			fill(255, 0, 0);
			rect(x, 0, rectWidth, height);	
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
}
