package project;

import ddf.minim.AudioBuffer;
import processing.core.PApplet;
import processing.core.PVector;

enum waveLocation{
    LEFT, RIGHT, TOP, BOTTOM
}

public class WaveForm {
    private PApplet p;
    private AudioBuffer ab;
    private PVector vector;
    private float speed;
    private waveLocation location;

    public WaveForm(PApplet p, AudioBuffer ab){
        this.p = p;
        this.ab = ab;
        this.vector = new PVector(0, 0);
        this.speed = 2;
        this.location = waveLocation.LEFT;
    }

    public void render(){

        p.translate(vector.x, vector.y);
      
        if (vector.y == p.height) {
          // moving along the bottom edge
          vector.x += speed;
        } 

        // else if (vector.x >= p.width && vector.y > 0) {
        //   // moving along the right edge
        //   vector.y -= speed;
        // }

        //  else if (vector.x >= 0 && vector.y <= 0) {
        //   // moving along the top edge
        //   vector.x -= speed;
        // } 

        else if (vector.x <= 0 && vector.y < p.height) {
          // moving along the left edge
          vector.y += speed;
        }

        if (vector.x > p.width) {
          // reached the right edge
          vector.x = p.width;
          vector.y = p.height - speed;
        } 

        else if (vector.y < 0) {
          // reached the top edge
          vector.x = p.width - speed;
          vector.y = 0;
        } 
        
        else if (vector.x < 0) {
          // reached the left edge
          vector.x = 0;
          vector.y = speed;
        }

        else if(vector.y == p.height){
            this.location = waveLocation.BOTTOM;
            vector.y = p.height;
        }
          
        drawWave();
        System.out.println("x: " + vector.x + " y: " + vector.y);

    }

    private void drawWave(){
        float color, amplitude, lerpedValue;
        p.stroke(255);
        for(int i = 0 ; i < ab.size() ; i+=20)
        {
            color = PApplet.map(i, 0, ab.size(), 0, 255);
            p.stroke(color, color, 255);

            amplitude = PApplet.map(ab.get(i), -0.01f, 1f, 0, 300);

            lerpedValue = PApplet.lerp(amplitude, 1,  0.7f);
            switch(this.location){
                case TOP:
                    break;

                case BOTTOM:
                    p.line(i , p.height - lerpedValue - 400 , i , p.height - lerpedValue - 400);  
                    break; 

                case LEFT:
                    p.line(lerpedValue , i, 0, i); 
                    // System.out.println("left");
                    break;

                case RIGHT:
                    break;

            }
        }
        p.noStroke();
    }
}
