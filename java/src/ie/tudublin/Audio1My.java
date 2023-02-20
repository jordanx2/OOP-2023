package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio1My extends PApplet
{

    Minim minim;
    AudioInput ai;
    AudioPlayer ap;
    AudioBuffer ab;

	public void settings()
	{
		size(1024, 500);
	}

    int frameSize = 1024;

	public void setup() {
		colorMode(HSB);
		background(0);

        minim = new Minim(this);

        ai = minim.getLineIn(Minim.MONO, frameSize, 44100, 16);
        ab = ai.mix;
        smooth();
        noFill();
        System.out.println(test());
	}
	
    float lerped = 0;
	public void draw()
	{	
        background(0);
        // stroke(255);
        float cgap = 255 / (float) ab.size();
        float half = height / 2;

        // Square waveform
        // for(int i = 0; i < ab.size(); i+=12){
        //     fill(cgap * i, 255, 255);
        //     rect(i, half, 10, ab.get(i) * half);
        // }

        float total = 0;
        for(int i = 0; i < ab.size(); i++){
            total += abs(ab.get(i));
            stroke(cgap * i, 255, 255);
        }

        float average  =  total / (float) ab.size();
        float r = average * 100;

        for(int i = 0; i < ab.size(); i+=12){
            noStroke();
            lerped = lerp(lerped, r, 0.1f);
            fill(cgap * i, 255, 255);
            rect(i, half, 10, lerped);
        }

 
	}

    public float test(){
        return lerp(10, 20, 0.5f);
    }
}

