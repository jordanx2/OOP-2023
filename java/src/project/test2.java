package project;

import processing.core.PApplet;
import processing.core.PVector;

public class test2 extends PApplet{


    public void settings(){
        size(800, 800);
    }
    
    public void setup() {
        background(0);
    }

    public void mouseReleased(){
        PVector one = new PVector(mouseX, mouseY);
        PVector two = new PVector(mouseX - 100, mouseY + 100);
        PVector three = new PVector(mouseX + 100, mouseY + 200);
        triangle(one.x, one.y, two.x, two.y, three.x, three.y);
    }
    
    public void draw() {
        fill(255);
        
    }
    
       
    
    
    
    
}
