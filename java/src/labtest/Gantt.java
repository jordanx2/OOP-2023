package labtest;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class Gantt extends PApplet
{	
    ArrayList<Task> tasks;
	float h;
	float startY, startX;
	float gap;
	
	public void settings()
	{
		size(800, 600);
	}

	public void printTasks()
	{
		startX = 50;
		startY = 100;
        h = height / tasks.size() * 0.8f;
		for(int i = 0; i < tasks.size(); i++){
			colorMode(RGB);
			fill(255);
			textAlign(CENTER);
            text(tasks.get(i).getTask(), startX, startY + (h * i));
			startX *= 3;
			startX += ((tasks.get(i).getStart() - 1) * gap);
			float endX = (tasks.get(i).getEnd() - tasks.get(i).getStart()) * gap;
			colorMode(HSB);
			fill(map(i, 0, tasks.size(), 0, 255), 255, 255);
			rect(startX, startY + (h * i), endX, 25);

			tasks.get(i).setStartX(startX);
			tasks.get(i).setEndX(startX + endX);
			tasks.get(i).setyPos(startY + (h * i));
		
			startX = 50;
        }

	}

	public void loadTasks()
	{
        tasks = new ArrayList<>();
		Table table = loadTable("tasks.csv", "header");
        for(TableRow tr : table.rows()){
            tasks.add(new Task(tr));
        }
	}

	public void printGrid(){
		textSize(14);
		int count = 0;
		startY = startY / 3;
		startX *= 3;
		gap = (width / 30) * 0.8f;
		float i = startX;
		while(count < 30){
			textAlign(CENTER, CENTER);
			text(++count, i, startY);
			line(i, startY + 20, i, height - startY);
			i += gap;
		}
	}
	
	Task current;
	boolean changeStart;
	public void mousePressed()
	{
		float x = mouseX;
		float y = mouseY;

		for(int i = 0; i < tasks.size(); i++){
			Task t = tasks.get(i);

			// end
			if(dist(x, y, t.getEndX(), t.getyPos()) < 20){
				current = t;
				changeStart = false;
			}

			// start
			if(dist(x, y, t.getStartX(), t.getyPos()) < 20){
				current = t;
				changeStart = true;
			}
		}

		// current = null;
	}

	public void mouseReleased(){
		current = null;
	}

	public void mouseDragged()
	{
		if(current == null){
			return;
		}

		if(changeStart){
			// current.setStart(mouseX);
			
		}else{
			// current.setEnd(mouseX);
			

		}
	}

	
	
	public void setup() 
	{
		background(0);
		textSize(16);
		fill(255);
		stroke(255);
		startY = 100;
		startX = 50;
        loadTasks();
	}

	
	public void draw()
	{			
		background(0);
		printGrid();
		printTasks();
	}
}
