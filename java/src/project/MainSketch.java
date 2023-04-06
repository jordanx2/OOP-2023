package project;

import java.util.ArrayList;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import processing.core.PApplet;
import processing.core.PVector;



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

    ArrayList<Star> entities = new ArrayList<>();


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

        // CURRENTLY MUTED
        ap.mute();

        fft = new FFT(1024, 44100);
        lerpedBuffer = new float[width];

        int gap = 100;
        int count;
        for(int w = gap; w < width - gap; w+=gap){
            count = 0;
            for(int h = gap; h < height - gap; h+=gap){
                if(random(0f, 1f) > .6f && count < 3){
                    entities.add(new Celestial(10, new PVector(w, h), color(random(255), 255, 255), h + w, this));
                    count++;
                }
            }
        }

         // TEST
        // entities.add(new Celestial(10, new PVector(width / 2, height / 2), color(random(255), 255, 255), 3, this));

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


        for(Star s : entities){
            s.render(amp);
        }

        
        element.render(amp, ab.size());

        wave.render();
    }


}