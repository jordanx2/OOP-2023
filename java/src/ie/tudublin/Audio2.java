package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import processing.core.PApplet;

public class Audio2 extends PApplet {
    Minim m;
    AudioInput ai;
    AudioPlayer ap;
    AudioBuffer ab;

    FFT fft;

    public void settings(){
        size(1024, 800);
    }

    public void setup(){
        m = new Minim(this);
        ai = m.getLineIn(Minim.MONO, width, 44100, 16);
        ab = ai.mix;
        lerpedBuffer = new float[width];
        fft = new FFT(width, 44100);
    }

    float[] lerpedBuffer; 
    public void draw(){
        background(0);
        colorMode(HSB);
        stroke(255);
        float half = height / 2;
        for(int i = 0; i < ab.size(); i++){
            stroke(map(i, 0, ab.size(), 0, 255), 255, 255);
            lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.05f);
            float f = abs(lerpedBuffer[i] * half * 2.0f);
            line(i, half + f, i, half- f);
        }

        fft.forward(ab);
        stroke(255);

        int heightIndex = 0;

        for(int i = 0; i < fft.specSize() / 2; i++){
            line(i * 2.0f, height, i * 2.0f, height - fft.getBand(i) * 5.0f);
            if(fft.getBand(i) > fft.getBand(heightIndex)){
                heightIndex = i;
            }
        }

        fill(255);
        float freq = fft.indexToFreq(heightIndex);
        textSize(20);
        text("Freq: " + freq, 10, 50);

        float y = map(freq, 1000, 2500, height, 0);
        lerpedY = lerp(lerpedY, y, 0.1f);
        circle(200, y, 50);
        circle(200, lerpedY, 200);

        // println(map(5, 0, 10, 1000, 2000));
        // println(map1(5, 0, 10, 1000, 2000));
        
    }

    float lerpedY;
    float map1(float a, float b, float c, float d, float e){
        float range1 = c - b;
        float range2 = e - d;
        float howFar = a- b;
        return d + (howFar / range1) * range2;
        // return (c - a) / c * (e - d) + d;
        
    }
}
