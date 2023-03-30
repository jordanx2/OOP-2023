package project;

import processing.core.PApplet;
import processing.core.PVector;

public class test2 extends PApplet{

    PVector p0, p1, p2;

    public void settings(){
        size(800, 800);
    }
    
    public void setup() {
        // background(0);
        noStroke();
        p0 = new PVector(0, 300);
        p1 = new PVector(300, 0);
        p2 = new PVector(600, 300);

    }
    
    public void draw() {
        background(0);
        stroke(255);
        strokeWeight(4);
        // noFill();
        // stroke(255, 102, 0);
        // line(340, 80, 40, 40);
        // line(360, 360, 60, 320);
        // stroke(0, 0, 0);
        // fill(255);
        // bezier(340, 80, 40, 40, 360, 360, mouseX, mouseY);
        
        // fill(255, 0, 0);
        // circle(340, 80, 20);

        // fill(0, 255,  0);
        // circle(40, 40, 20);

        // fill(0, 0, 255);
        // circle(360, 360, 20);

        // fill(125,125,125);
        // circle(60, 320, 20);
        // p0.x = mouseX;
        // p0.y = mouseY;

        float delta = 0.05f;
        // for (float t = 0; t <= 1.00001; t += delta) {
        //   float x1 = lerp(p0.x, p1.x, t);
        //   float y1 = lerp(p0.y, p1.y, t);
        //   float x2 = lerp(p0.x, p2.x, t);
        //   float y2 = lerp(p0.y, p2.y, t);
        //   stroke(t * 360, 255, 255);
        //   line(x1, y1, x2, y2);
        //   float x = lerp(x1, x2, t);
        //   float y = lerp(y1, y2, t);;
        // }
        quad(189, 18, 216, 18, 216, 360, 144, 360);

        
    }

  
    
}