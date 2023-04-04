package project;

import ddf.minim.AudioBuffer;
import processing.core.PApplet;
import processing.core.PConstants;
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
        this.speed = 6f;
        this.location = waveLocation.LEFT;
    }

    public void render(){
        waveTransform();
        drawWave();

    }

    public void waveTransform(){
        p.stroke(255);
        p.translate(vector.x, vector.y);
        switch(location){
            case LEFT: 
                vector.y += speed;
                if(vector.y >= p.height){   
                    vector.x = ab.size() * -1;
                    vector.y = p.height - 100;
                    location = waveLocation.BOTTOM;
                } 
                break;

            case BOTTOM:
                vector.x += speed;
                if(vector.x >= p.width){
                    location = waveLocation.RIGHT;
                }
                break;

            case RIGHT:
                vector.y -= speed;
                if(vector.y == (ab.size() * -1)){
                    location = waveLocation.TOP;
                    vector.y = 0;
                }
                break;

            case TOP: 
                vector.x -= speed;
                if(vector.x == (ab.size() * -1)){
                    location = waveLocation.LEFT;
                    vector.x = 0;
                    vector.y = (ab.size() * -1);
                }
                break;
        }
        // System.out.println("x: " + vector.x + "y: " + vector.y);
    }

    private void drawWave(){
        float xC = 0;
        float yC = 0;
        float color, amplitude, lerpedValue;
        p.stroke(255);
        p.colorMode(PConstants.HSB);
        int j = 1;
        for(int i = 0 ; i < ab.size() ; i+=20)
        {
            color = PApplet.map(i, 0, ab.size(), 0, 255);
            p.stroke(color , 255, 255);

            amplitude = PApplet.map(ab.get(i), -0.01f, 1f, 0, 300);

            lerpedValue = PApplet.lerp(amplitude, 1,  0.7f);
            
            switch(location){
                case TOP:
                    yC = 0;
                    p.line(xC + i, yC + lerpedValue + 50, xC + i, yC);                    
                    waveTipShape(xC + i, yC + lerpedValue + 50, (j % 3 == 0) ? true : false);               
                    break;

                case BOTTOM:
                    yC = 50;
                    xC = 0;
                    p.line(xC + i, yC - lerpedValue - 50, xC + i, yC);     
                    waveTipShape(xC + i, yC - lerpedValue - 50, (j % 3 == 0) ? true : false);               
                    break; 

                case LEFT:
                    xC = 50;
                    yC = 0;
                    p.fill(i * lerpedValue, 255, 255);
                    p.line(xC + lerpedValue, yC + i, 0, i);
                    waveTipShape(xC + lerpedValue, yC + i, (j % 2 == 0) ? true : false);
                    break;

                case RIGHT:
                    p.line(xC - lerpedValue - 50, yC + i, xC, yC + i);
                    waveTipShape(xC - lerpedValue - 50, yC + i, (j % 2 == 0) ? true : false);               
                    break;

            }

            // Keep track of the shape change of the tips of the waveform
            j++;
        }
        p.noStroke();
        p.colorMode(PConstants.RGB);
    }

    public void waveTipShape(float x, float y, boolean changeShape){
        float size = 8;
        switch(location){
            case LEFT:
                if(!changeShape){
                    p.circle(x, y, size);
                    changeShape = true;
                } else{
                    p.square(x, y, size);
                    changeShape = false;
                }
                break;

            case BOTTOM:
                if(!changeShape){
                    p.circle(x, y, size);
                    changeShape = true;
                } else{
                    p.square(x, y, size);
                    changeShape = false;
                }
                break;

            case RIGHT:
                if(!changeShape){
                    p.circle(x, y, size);
                    changeShape = true;
                } else{
                    p.square(x, y, size);
                    changeShape = false;
                }
                break;
            case TOP:
                if(!changeShape){
                    p.circle(x, y, size);
                    changeShape = true;
                } else{
                    p.square(x, y, size);
                    changeShape = false;
                }
                break;
        }
    }
}
