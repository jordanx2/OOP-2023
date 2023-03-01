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

    float[] lerpedBuffer; 
    float lerpedY;

    PitchSpeller speller;
    int frequency;

    public void settings(){
        size(1024, 800);
    }

    public void setup(){
        colorMode(HSB);
        noStroke();
        textSize(16);
        m = new Minim(this);
        // ai = m.getLineIn(Minim.MONO, width, 44100, 16);
        // ab = ai.mix;
        ap = m.loadFile("scale.wav", 1024);
        ab = ap.mix;
        ap.loop();


        lerpedBuffer = new float[width];
        fft = new FFT(width, 44100);
        speller = new PitchSpeller();
    }

    public void draw(){
        background(0);
        fft.forward(ab);
        frequency = 0;

        for(int i = 1; i < fft.specSize() / 2; i++){
            stroke(map(i, 0, ab.size(), 0, 255), 255, 255);
            lerpedBuffer[i] = lerp(lerpedBuffer[i], fft.getBand(i) , 0.05f);
            float f = abs(lerpedBuffer[i] * 2.0f);

            circle((width / 2) - 100, height / 2, f);
            circle((width / 2) + 100, height / 2,f);

            if(fft.getBand(i) > frequency ){
                frequency = i;
            }
        }

        fill(255);
        text("frequency: " + fft.indexToFreq(frequency), 25, 25);
        text("note: " + speller.spell(fft.indexToFreq(frequency)), 25, 75); 
    }

    void classCode(){
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

        // circle(200, y, 50);
        circle(200, lerpedY, 200);
    }
}
