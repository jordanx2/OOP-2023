package ie.tudublin;

import processing.core.PApplet;

public class PrimeVisual extends PApplet {
    float x;
    float y;
    int shapeSize = 16;
    int Xsize = shapeSize * 2;
    int Ysize = -1 * (shapeSize*2);
    int step = 1;
    int xTrack, yTrack = 0;
    int numElements = 1;


    public void settings(){
        // size(displayWidth, displayHeight);
        size(1040, displayHeight);
        // fullScreen();
    }

    public void setup(){
        background(0);
        noStroke();
        frameRate(25);
        x = width / 2;
        y = height / 2;
        textSize(20);
    }

    public void draw(){
        // fill(random(255), random(255), random(255));
        stroke(255);
        fill(255);
        if(isPrime(numElements)){
            circle(x, y, shapeSize);
        }
        
        if (xTrack != step){
            line(x, y, x+Xsize, y);
            xTrack++;
            x += Xsize;
        } else{
            line(x, y, x, y + Ysize);
            yTrack++;
            y += Ysize;
        }

        if((xTrack + yTrack) == (step*2)){;
            xTrack = 0;
            yTrack = 0;
            step++;
            Xsize *= -1;
            Ysize *= -1;
        }

        numElements++;

    }

    boolean isPrime(int value){
        if(value - 1 == 0) return false;

        for(int i = 2; i <= Math.sqrt(value); i++){
            if(value % i == 0){
                return false;
            }
        }
        return true;
    }

}
