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
			
			case 4 :
				drawing = 4;
				break;

			case 5: 
			 	drawing = 5;
				break;

			case 6: 
				drawing = 6;
				break;

			case 7: 
				drawing = 7;
				break;

			case 8:
				drawing = 8;
				break;
			
			case 9: 
				drawing = 9;
				break;
		}


	}

	public void draw() {
		background(0);
		noStroke();
		fill(255, 0, 255);
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

			case 4: 
				rectDrawing();
				break;

			case 5: 
				loopEllipse();
				break;

			case 6: 
				ellipseLine();
				break;
			
			case 7: 
				ellipseGrid();
				break;

			case 8:
				textGrid();
				break;

			case 9: 
				blueSquareGrid();
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
		colorMode(HSB, 360, 100, 100);
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

	public void rectDrawing(){
		int numRect = 10;
		int rectSize = width /  numRect;
		
		for(int i = 0; i < numRect; i++){
			fill((i * numRect), 255, 255);
			rect(i * rectSize, i * rectSize, rectSize, rectSize);
			rect((rectSize * (numRect - i - 1)), i * rectSize, rectSize, rectSize);
		}
	}

	public void loopEllipse(){
		for(int i = 270; i > 0; i-=30){
			fill(i, 255, 255);
			ellipse(400, 400, i, i);
		}
	}

	public void ellipseLine(){
		int border = 40;
		int numCircles= 10;
		int w = width / numCircles;

		for(int i = 0; i < numCircles; i++){
			fill(i * numCircles , 255, 255);
			ellipse(w * i + border, w, w, w);
		}
	}

	public void ellipseGrid(){
		colorMode(HSB, 125, 100, 100);
		int border = 40;
		int numCircles= 10;
		int circleWidth = width / numCircles;
		for(int i = 0; i < numCircles; i++){
			for(int j = 0; j < numCircles; j++){
				fill(i * j, 255, 255);
				ellipse(i * circleWidth + border, j * circleWidth + border, circleWidth, circleWidth);
			}
		}
	}

	public void textGrid(){
		colorMode(HSB, 125, 100, 100);
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

	public void blueSquareGrid(){
		colorMode(HSB, 125, 100, 100);
		int light = color(80, 255, 255);
		int dark = color(80, 255, 30);
		int count = 20;
		int sSize = width / 20;
		int current = light;

		for(int i = 0; i < count; i++){
			if(checkCurrent(current, dark)){
				current = light;
			} else{
				current = dark;
			}

			for(int j = 0; j < count; j++){
				if(checkCurrent(current, dark)){
					current = light;
				} else{
					current = dark;
				}
				fill(current);
				square(i * sSize, j * sSize, sSize);
			}
		}
	}

	public boolean checkCurrent(int current, int c){
		if(current == c){
			return true;
		}

		return false;
	}
	
}
