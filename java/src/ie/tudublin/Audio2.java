package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio2 extends PApplet
{

    Minim minim;
    AudioPlayer ap;
    AudioBuffer ab;
    int w;
    int h;
    float x;


	public void settings()
	{
		size(800, 800);
	}

    int frameSize = 1024;
    float kickSize, snareSize, hatSize;
	public void setup() {
        noFill();
        stroke(255);
		colorMode(RGB);
		background(0);
        minim = new Minim(this);
        // ai = minim.getLineIn(Minim.MONO, frameSize, 44100, 16);
        ap = minim.loadFile("fadeaway.mp3");
        smooth();
        w = width / 2;
        h = height / 2;
        x = w;


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
        // float lerped = lerp(x, mouseX, 0.01f);
        // x = lerped;
        // circle(x, h, 100);

        float r = 100f;
        for(int i = 0; i < ap.bufferSize(); i++){
            background(0);
            float value = ap.mix.get(i);
            float mapped = map(value, -1, 1, w / 2, (w/ 2) + r);
            float lerped = lerp(mapped, mapped + (r*2), value);
            circle(w, h, lerped);
        }
  

    }
}


