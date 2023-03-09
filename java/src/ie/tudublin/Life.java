package ie.tudublin;

import processing.core.PApplet;

public class Life extends PApplet
{
	boolean pause;
	boolean drawPattern;
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
		drawPattern = false;
	}

	public void keyPressed(){
		int mode = key - '0';
		if(keyCode == 32){
			if(!pause){
				pause = true;
				return;
			} 
			pause = false;
		}


		switch(mode){
			case 1: 
				board.randomise();
				break;
			
			case 2:
				board.clearBoard(); 
				break;

			case 3: 
				if(!drawPattern){
					background(0);
					pause = true;
					drawPattern = true;
				}else{
					pause = false;
					drawPattern = false;
				}

				break;
			
		}
	}

	public void draw()
	{	
		if(!pause){
			background(0);
			board.render();
			board.applyRules();
		}

		if(drawPattern){
			fill(0, 255, 0);
			square(mouseX, mouseY, board.cellWidth);
			board.registerPattern(mouseX, mouseY);
		}
		
	}
}
