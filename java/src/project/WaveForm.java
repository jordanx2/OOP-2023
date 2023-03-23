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
        this.speed = 4f;
        this.location = waveLocation.BOTTOM;
    }

    int x2 = 0;
    int y2 = 50;
    int boundY = 100;
    int boundX = 100;
    public void render(){
        p.stroke(255);
        p.translate(vector.x, vector.y);
        // Left
        if(vector.y != (p.height - boundY) && vector.x == 0){
            vector.y += speed;
            y2 = 0;
            x2 = 50;
            location = waveLocation.LEFT;
        } 

        // Bottom
        if(vector.y == (p.height - boundY) && vector.x < (p.width - 50)){
            vector.x += speed;
            y2 = 50;
            x2 = 0;
            location = waveLocation.BOTTOM;
        }

        // Right
        if(vector.y >= 0 && vector.x >= (p.width - 50)){
            vector.y -= speed;
            y2 = 0;
            x2 = 50;
            location = waveLocation.RIGHT;
        }

        // Top
        if(vector.y == 0 && vector.x >= 0){
            vector.x -= speed;
            y2 = 50;
            x2 = 0;
            location = waveLocation.TOP;
        }
        
        // p.line(0f, 0f, x2, y2);
          
        drawWave(x2, y2);

    }

    private void drawWave(float xC, float yC){
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
                    p.line(xC + i, yC + lerpedValue, xC + i, yC);                    
                    break;

                case BOTTOM:
                    p.line(xC + i, yC - lerpedValue - 50, xC + i, yC);                    
                    break; 

                case LEFT:
                    p.line(xC + lerpedValue, yC + i, 0, i);
                    break;

                case RIGHT:
                    p.line(xC - lerpedValue - 50, yC + i, xC, yC + i);
                    break;

            }
        }
        p.noStroke();
    }
}
