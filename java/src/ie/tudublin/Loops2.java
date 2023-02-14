package ie.tudublin;

import processing.core.PApplet;

public class Loops2 extends PApplet {

	public void settings() {
		size(800, 800);
	}

	public void setup() {
		noStroke();
		colorMode(HSB, 360, 100, 100);
	}

	public void draw() {
		background(0);
		rectDrawing();
	}	

	public void rectDrawing(){
		int numRect = 10;
		int rectSize = width /  numRect;
		
		// int middleX = (width - 150) / 2;
		// int middleY = (height - 75) / 2;

		// // 	middle square - top
		// fill(146, 255, 255);
		// rect(middleX, middleY - 100, 150, 75);

		// // 	middle square - bottom
		// fill(171, 75, 255);
		// rect(middleX, middleY + 100, 150, 75);

		// for(int i = 0; i < numRect; i++){
		// 	fill((i * numRect), 255, 255);
		// 	rect(i * rectSize, i * rectSize, rectSize, rectSize);
		// }

		for(int i = 0; i < numRect; i++){
			fill((i * numRect), 255, 255);
			rect(i * rectSize, i * rectSize, rectSize, rectSize);
		}

		rect(0, (rectSize * 10), rectSize, rectSize);

	}

	

	
}
