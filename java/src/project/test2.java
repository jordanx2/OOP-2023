package project;

import processing.core.PApplet;

public class test2 extends PApplet{


    public void settings(){
        size(800, 800);
    }
    
    public void setup() {
        background(0);
        fill(random(255), random(255), random(255));
    }
    
    float angle = 0;
    float x = 50;
    float y = 50;
    float v = 4f;
    int x2 = 50;
    int y2 = 0;
    public void draw() {
        background(0);

        // Were redefing were the origin is
        translate(x, y);
        // rotate(angle);
        // rectMode(CENTER);
        // rect(0, 0, 50, 50);
        stroke(255);
        line(0, 0, x2, y2);
        angle += .05;

        // Left
        if(y <= height - 50 && x == 50){
            y += v;
            y2 = 0;
            // x2 = 50;
            x2 += 2;
        } 

        // Bottom
        if(y > (height - 50) && x <= width - 50){
            x += v;
            y2 = 50;
            x2 = 0;
        }


        // Right
        if(y >= 50 && x > width - 50){
            y -= v;
            y2 = 0;
            x2 = 50;
        }

        // Top
        if(y == 50 && x >= 50){
            x -= v;
            y2 = 50;
            x2 = 0;
        }
        
    }
    
}