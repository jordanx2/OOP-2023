package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class StarMap extends PApplet
{
	ArrayList <Star> stars = new ArrayList<>();
	boolean starsLoaded = false;
	Star test;

	public void settings()
	{
		size(800, 800);
	}

	public void setup() {
		noFill();
		colorMode(HSB);
		background(0);
		smooth();
		textSize(14);

		// Load the stars in
		loadStars();
	}

	public void loadStars(){
		Table table = loadTable("HabHYG15ly.csv", "header");
		for(TableRow r : table.rows()){
			Star s = new Star(r);
			stars.add(s);
		}
		test = stars.get(1);
	}

	public void plotStars(float border, float gap){
		int other = color(255, 255, 255);
		stroke(other);

		for(Star s : stars){
			float x = s.xG;
			float y = s.yG;
			float stepsX, stepsY = 0;
			float diameter = (float) Math.floor(s.absMag);
	
			if(x < 0){
				stepsX = 5 - Math.abs(x);
			} else{
				stepsX = 5 + Math.abs(x);
			}
	
			if(y < 0){
				stepsY = 5 - Math.abs(y);
			} else{
				stepsY = 5 + Math.abs(y);
			}
			
			ellipse((gap * stepsX + border), (gap * stepsY + border), diameter, diameter);
			text(s.displayName, (gap * stepsX + border) + diameter, (gap * stepsY + border));
		}
	}

	public void drawGrid()
	{
		stroke(255);
		float border = 50.0f;

		int count = 10;
		float gap = (width - (border * 2.0f)) / (float) count;
		for(int i = -5 ; i <= 5 ; i ++)
		{
			float x = border + (gap * (i + 5));
			line(x, border, x, height - border);
			line(border, x, width - border, x);

			// X-axis numbering
			text(i, border / 2, x);

			// Y-axis numbering
			text(i, x, border / 2);
		}

		if(!starsLoaded){
			plotStars(border, gap);
			starsLoaded = true;
		}
		
		
	}
		
	public void draw()
	{	
		// strokeWeight(2);		
		drawGrid();
	}
}
