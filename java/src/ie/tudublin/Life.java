package ie.tudublin;

import processing.core.PApplet;

public class Life extends PApplet
{
	boolean pause;
	LifeBoard board;
	public void settings()
	{
		size(displayWidth, displayWidth);
	}

	public void setup() {
		colorMode(RGB);
		background(0);
		board = new LifeBoard(100, this);
		board.randomise();
		pause = false;
	}

	public void keyPressed(){
		if(!pause){
			pause = true;
			return;
		}

		pause = false;
	}

	public void draw()
	{	
		if(!pause){
			background(0);
			board.render();
			board.applyRules();
		}

		
	}
}
