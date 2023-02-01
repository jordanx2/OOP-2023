package ie.tudublin;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class BugZap extends PApplet
{
	float playerX, playerY, playerWidth;
	float bugX, bugY, bugWidth;
	int playerSpeed = 30;
	int bugSpeed = 30;
	int score = 0;
	float bugStartPoint;
	boolean drawSplash = true;
	PImage img, bug, bgSpace;

	public void settings(){
		// pixelDensity(displayDensity());
		size(880, displayHeight- 75);
	}

	public void setup(){
		stroke(255, 0, 0);
		strokeWeight(5);
		fill(255);

		playerX = width / 2;
		playerY = height - 10;
		playerWidth = 60;

		bugWidth = 50;
		bugX = random(100, width - 100);
		bugStartPoint = bugX;
		bugY = 25;

		PFont font = createFont("ComicSansMS-Bold", 23);
		textFont(font);

		img = loadImage("/Users/Workspaces/OOP-2023/java/src/ie/tudublin/space-invaders.png");
		bug = loadImage("/Users/Workspaces/OOP-2023/java/src/ie/tudublin/alien.png");
		bgSpace = loadImage("/Users/Workspaces/OOP-2023/java/src/ie/tudublin/space.jpg");
		bgSpace.resize(width, height);
		background(bgSpace);
	}

	public void draw(){
		background(bgSpace);
		fill(255);
		if(drawSplash){
			drawSplashScreen();
		}

		if(!checkEndGame(playerY, bugY)){
			checkEndGame(playerY, bugY);
			drawPlayer(playerX, playerY, playerWidth);
			drawBug(bugX, bugY, bugWidth);
	
			textSize(30);
			text("score: " + score, 20, 35);
		}
	}

	public void drawSplashScreen(){
		// splash screen
		text("Hello", width / 2, height / 2);	
		drawSplash = false;
	}

	public void drawPlayer(float x, float y, float w){
		// beginShape();
		// // Bottom line
		// line(x - w, y, x + w, y);
		
		// // Left column
		// line(x - w, y, x - w, y - 10);

		// // Right column
		// line(x + w, y, x + w, y - 10);

		// // Top line
		// line(x - w, y - 10, x + w, y - 10);
		// endShape();

		image(img, x, y - 75, playerWidth, playerWidth);

	}


	public void drawBug(float x, float y, float w){
		// beginShape();
		// // top 
		// triangle(x, y, x - w, y + w, x + w, y + w);

		// // left
		// triangle(x - w, y + w, x - w, (y + w) + 10, x + (w / 4), y + w);

		// // right
		// triangle(x + w, y + w, x + 10,  (y + w) + 10, x + (w / 4), y + w );
		// endShape();

		image(bug, x, y, bugWidth, bugWidth);
		if((frameCount) % bugSpeed == 0){
			bugX = random(bugStartPoint, bugStartPoint + 100); 
			bugY += 50;
		}
	}

	public void resetBug(){
		bugSpeed--;
		bugX = random(100, width - 100);
		bugStartPoint = bugX;
		bugY = 25;
	}

	public void fire(float x, float y){
		// draw the firing line
		float playerCenter = (playerWidth / 2);
		line(x + playerCenter, y - playerWidth,  x + playerCenter, 0);
		
		float playerPos = Math.round((x + playerCenter) / 10) * 10;  
		float bugPos = Math.round(bugX / 10) * 10; 
		// println("p: " + playerPos + ", b: " + bugPos);
		if((playerPos - bugPos) > 0){
			checkCollision((playerPos - bugPos));

		} else{
			checkCollision((bugPos - playerPos));
		}
	}

	public boolean checkCollision(float pos){
		if(pos > bugWidth){
			return false;
		}
		fill(255, 0, 0);
		score++;
		resetBug();

		return true;
	}	

	public boolean checkEndGame(float playerYPos, float bugYPos){
		// round both positions to the nearest 100 and check for end game
		if(Math.round(bugYPos / 100) * 100 == Math.round(playerYPos / 100) * 100){
			background(0);
			text("GAME OVER\nSCORE: " + score, width / 2, height / 2);	
			textAlign(CENTER);
			fill(255, 0, 0);
			return true;
		}

		return false;
	}

	public void keyPressed(){
		switch(keyCode){
			case LEFT: 
				if(playerX > playerWidth){
					playerX -= playerSpeed;
				}
				break;

			case RIGHT: 
				if(playerX < width - playerWidth - 50){
					playerX += playerSpeed;
				}
				break;

			case ' ': 
				fire(playerX, playerY);
				break;

			default: 
				break;
		}
	}

}
	

