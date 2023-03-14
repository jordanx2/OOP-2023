package project;

import java.util.ArrayList;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import processing.core.PApplet;

public class MainSketch extends PApplet
{

    Minim minim;
    AudioPlayer ap;
    AudioBuffer ab;
    int w;
    int h;
    FFT fft;
    float[] lerpedBuffer;
    float lerpedAmp;
    float amp = 0;
    float r = 310;
    ArrayList<Stars> stars = new ArrayList<>();
    float[] spectrum;

	public void settings()
	{
		size(displayWidth, displayHeight);
	}

	public void setup() {
        noFill();
        smooth();
        stroke(255);
		colorMode(RGB);
		background(0);
        minim = new Minim(this);
        // ai = minim.getLineIn(Minim.MONO, 1024, 44100, 16);
        ap = minim.loadFile("fadeaway.mp3", 1024);
        ab = ap.mix;
        ap.play();
        fft = new FFT(1024, 44100);
        w = width / 2;
        h = height / 2;
        lerpedBuffer = new float[width];

        for(int i = 1; i < fft.specSize(); i++){
            stars.add(new Stars(3, random(10, width - 10), random(10, height - 10),  color(random(255), random(255), 255), this));
        }

        spectrum = fft.getSpectrumReal();
	}

    public void keyPressed(){
        if(ap.isPlaying()){
            ap.pause();
        }

        else if(ap.position() == ap.length()){
            ap.rewind();
            ap.play();
        } 
        else{
            ap.play();
        }
    }

    public void draw(){
        background(0);
        fft.forward(ab); 
        amp = 0;

        for(Stars star: stars){
            star.render();
        }

        for(int i = 0; i < fft.specSize() - 1; i++){
            lerpedBuffer[i] = lerp(lerpedBuffer[i], fft.getBand(i), 0.07f);
            amp += lerpedBuffer[i];
            stars.get(i).burst();
        }

        outwardsSpikes(amp);    
        drawOutterCircle(amp); 
        drawInnerCircle(); 

    
        
        // circle(w, h, map(amp, 0, fft.specSize() / 2, 0, 310));
        // System.out.println(map(amp, 0, fft.specSize(), 0, 310));

        // amp /= fft.specSize() / 2;
        // float d = abs(amp) * 2.0f;
        // ellipse(w, h, 2, 2);


    }

    public void outwardsSpikes(float amp){
        float xCord, yCord, angle = 0;
        float strokeV = 0;
        for(int i = 0; i < fft.specSize(); i+=10){
            angle = radians(i);
			xCord = w + sin(angle) * (amp / 3);
			yCord = h + cos(angle) * (amp / 3);

            strokeV = pow(map(i, 15, fft.specSize(), 0, 1), 2) * 255;

            stroke(0, strokeV, strokeV);
            line(w, h, xCord, yCord);
        }
        
    }

    public void drawOutterCircle(float amp){
        noStroke();
        float mapped = map(amp, 0, ab.size(), 0, 255);
        int blue = color(0, 0, mapped);
        int brightBlue = color(0, mapped, mapped);

        fill(lerpColor(blue, brightBlue, 0.06f));    

        circle(w, h, r);
        fill(0);
    }

    public void drawInnerCircle(){
        fill(10, 0, 10);
        circle(w, h, r - 20);
    }
}


