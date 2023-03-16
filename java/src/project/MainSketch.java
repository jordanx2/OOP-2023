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
    FFT fft;
    float[] lerpedBuffer;
    float lerpedAmp;
    float amp = 0;
    ArrayList<Stars> stars = new ArrayList<>();
    CenterElement element;

	public void settings()
	{
		size(displayWidth, displayHeight);
	}

	public void setup() {
        noFill();
        smooth();
		colorMode(RGB);
		background(0);
        minim = new Minim(this);
        // ai = minim.getLineIn(Minim.MONO, 1024, 44100, 16);
        ap = minim.loadFile("fadeaway.mp3", 1024);
        ab = ap.mix;
        ap.play();

        fft = new FFT(1024, 44100);
        lerpedBuffer = new float[width];

        for(int i = 1; i < fft.specSize(); i++){
            stars.add(new Stars(3, random(10, width - 10), random(10, height - 10),  color(random(255), random(255), 255), this));
        }

        element = new CenterElement(this, fft);
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

        
        element.render(amp, ab.size());
    }
}


