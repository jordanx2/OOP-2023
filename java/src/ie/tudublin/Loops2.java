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
		blueSquareGrid();
	}	

	public void blueSquareGrid(){
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
