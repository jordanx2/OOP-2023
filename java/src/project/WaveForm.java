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
    private int x2;
    private int y2;

    public WaveForm(PApplet p, AudioBuffer ab){
        this.p = p;
        this.ab = ab;
        this.vector = new PVector(0, 0);
        this.speed = 4f;
        this.location = waveLocation.BOTTOM;
        this.x2 = 0;
        this.y2 = 50;
    }

    public void render(){
        waveTransform();
        drawWave(x2, y2);

    }

    public void waveTransform(){
        p.stroke(255);
        p.translate(vector.x, vector.y);
        // Left
        if(vector.y != (p.height - 100) && vector.x == 0){
            vector.y += speed;
            y2 = 0;
            x2 = 50;
            location = waveLocation.LEFT;
        } 

        // Bottom
        if(vector.y == (p.height - 100) && vector.x < (p.width - 50)){
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
