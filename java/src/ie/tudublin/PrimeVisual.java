package ie.tudublin;

import processing.core.PApplet;

public class PrimeVisual extends PApplet {
    // x, y position of the circle
    float x;
    float y;

    // diameter of the circle 
    int shapeSize = 16;

    // Xsize, Ysize used to increment the position of each circle
    int Xsize = shapeSize * 2;
    int Ysize = -1 * (shapeSize*2);

    // used to get the sprial effect in the sketch
    int step = 1;

    // xTrack, yTrack used to track how close they get to the step variable
    int xTrack, yTrack = 0;

    // numElements used to check prime numbers
    int numElements = 1;


    public void settings(){
        // size(displayWidth, displayHeight);
        size(1040, displayHeight);
        pixelDensity(displayDensity());
    }

    public void setup(){
        background(0);
        noStroke();
        x = width / 2;
        y = height / 2;
        stroke(255);
        fill(255);
    }

    public void draw(){
        // check if numElements is prime, if it is draw the circle
        if(isPrime(numElements)){
            circle(x, y, shapeSize);
        }
        
        // if, else block to check if the numbers of x moves is equal to the step variable
        // x direction gets drawn first, then when all the x steps have been made, y direction then gets drawn
        if (xTrack != step){
            // draw the x-axis connection lines
            line(x, y, x+Xsize, y);
            xTrack++;
            x += Xsize;
        } else{
            line(x, y, x, y + Ysize);
            yTrack++;
            y += Ysize;
        }

        if((xTrack + yTrack) == (step * 2)){;
            xTrack = 0;
            yTrack = 0;
            step++;
            Xsize *= -1;
            Ysize *= -1;
        }

        numElements++;

    }

    public boolean isPrime(int value){
        // Function returns true if a numbers is prime, false otherwise
        if(value - 1 == 0) return false;

        for(int i = 2; i <= Math.sqrt(value); i++){
            if(value % i == 0){
                return false;
            }
        }
        return true;
    }

}
