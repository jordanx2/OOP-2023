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
    WaveForm wave;

	public void settings()
	{
		size(displayWidth, displayHeight);

	}

	public void setup() {
        background(0);
        noFill();
        smooth();
		colorMode(RGB);

        minim = new Minim(this);
        // ai = minim.getLineIn(Minim.MONO, 1024, 44100, 16);
        ap = minim.loadFile("fadeaway.mp3", 1024);
        ab = ap.mix;
        ap.play();

        fft = new FFT(1024, 44100);
        lerpedBuffer = new float[width];

        for(int i = 1; i < fft.specSize() / 2; i++){
            stars.add(new Stars(10, random(50, width - 50), random(25, height - 75),  color(random(255), random(255), 255), this, (random(-1, 1) > 0.5) ? true : false));
        }

        element = new CenterElement(this, fft);
        wave = new WaveForm(this, ab);
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

        for(int i = 0; i < fft.specSize() / 2; i++){
            lerpedBuffer[i] = lerp(lerpedBuffer[i], fft.getBand(i), 0.07f);
            amp += lerpedBuffer[i];
        }

        for(Stars star : stars){
            star.render(amp);
        }

        
        element.render(amp, ab.size());

        wave.render();



        // stroke(255);
        // for(int i = 0 ; i < ab.size() ; i+=20)
        // {
        //     float c = map(i, 0, ab.size(), 0, 255);
        //     stroke(c, c, 255);
        //     float f = map(ab.get(i), -0.01f, 1f, 0, 300);
        //     float l = lerp(f, 1,  0.7f);
        //     line(l , i, 0, i); 
        // }
        // noStroke();


    }


}


