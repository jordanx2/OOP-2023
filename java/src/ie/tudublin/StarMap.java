package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class StarMap extends PApplet
{
	ArrayList <Star> stars = new ArrayList<>();
	Star test;

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		colorMode(HSB);
		background(0);
		smooth();

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

	public void plotStars(){
		
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
		}
		plotStars();
	}
		
	public void draw()
	{	
		strokeWeight(2);		

		drawGrid();
	}
}
