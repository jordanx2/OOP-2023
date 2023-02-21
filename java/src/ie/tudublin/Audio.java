package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio extends PApplet
{

    Minim minim;
    AudioPlayer ap;
    AudioBuffer ab;
    AudioInput ai;

	public void settings()
	{
		size(1024, 500);
	}

    int frameSize = 1024;

	public void setup() {
        noFill();
        stroke(255);
		colorMode(RGB);
		background(0);

        minim = new Minim(this);

        ai = minim.getLineIn(Minim.MONO, frameSize, 44100, 16);

        // ap = minim.loadFile("heroplanet.mp3");
        
        ab = ap.mix;
        smooth();

		
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

        float halfH = height / 2;
        float halfW = width / 2; 


        // for(int i = 0; i < ab.size(); i++){
        //     float radius = 300;
        //     float rad = radians(i);
        //     float xCord = sin(rad) * (width / 2);
        //     float yCord = cos(rad) * (height / 2);

        //     stroke(random(255), 255, 255);
        //     ellipse(width / 2, height / 2, xCord * ab.get(i) , yCord * ab.get(i) ) ;
        // }

		float angle = 0, xCord = 0, yCord = 0;
		float xCenter = width / 2;
		float yCenter = height / 2;
		float radius = 200;

		// 2πr == 360 degrees
		for(int i = 0; i < ab.size(); i++){
            stroke(random(255), 255, 255);
			angle = radians(i);
			xCord = xCenter + sin(angle) * radius;
			yCord = yCenter + cos(angle) * radius;
            float value = ab.get(i) * 50;
			ellipse(xCord + value, yCord + value, 2, 2);
			// line(xCenter, yCenter, xCord, yCord);
		}
    }
}


