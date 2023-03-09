package ie.tudublin;

import processing.core.PApplet;

public class Life extends PApplet
{
	boolean pause;
	boolean drawPattern;
	boolean mouseClickedPattern;
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
		mouseClickedPattern = false;
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
				pause = true;
				drawPattern = true;
			}else{
				pause = false;
				drawPattern = false;
			}
			
			case 4: 
				if(!mouseClickedPattern){
					pause = true;
					mouseClickedPattern = true;					
				} else{
					pause = false;
					mouseClickedPattern = false;
				}
				break;

			
		}
	}
	public void mouseReleased(){
		if(mouseClickedPattern){
			board.registerPattern(mouseX, mouseY);
			board.render();
		}
	}

	public void mousePressed(){
		if(drawPattern){
			board.registerPattern(mouseX, mouseY);
			board.render();
		}
	}

	public void draw()
	{	
		if(!pause){
			background(0);
			board.render();
			board.applyRules();
		}

		// if(drawPattern){
		// 	fill(0, 255, 0);
		// 	square(mouseX, mouseY, board.cellWidth);
		// 	board.registerPattern(mouseX, mouseY);
		// }
		
	}
}
