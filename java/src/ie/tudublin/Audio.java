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

        // ai = minim.getLineIn(Minim.MONO, frameSize, 44100, 16);

        ap = minim.loadFile("heroplanet.mp3");
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

        float half = height / 2;

        for(int i = 0; i < ap.bufferSize(); i++){
            float radius = 300;
            float rad = radians(i);
            float xCord = sin(rad) * (width / 2) + radius;
            float yCord = cos(rad) * (height / 2) + radius;

            stroke(random(255), 255, 255);
            ellipse(width / 2, height / 2, xCord * ap.left.get(i) , yCord * ap.left.get(i) ) ;
        }
    }



	
	// public void draw()
	// {	
    //     background(0);
    //     stroke(255);

    //     float half = height / 2;
    //     float cgap = 255 / (float) ab.size();

    //     float total = 0;
    //     for(int i = 0; i < ab.size(); i++)
    //     {
    //         total += abs(ab.get(i));
    //         stroke(cgap * i, 255, 255);
    //         line(i, half, i, half + ab.get(i) * half);    
    //     }

    //     float average = total / (float) ab.size();

    //     float r = average * 200;
    //     lerpedR = lerp(lerpedR, r, 0.1f);

    //     circle(100, 200, lerpedR);
        

	// }
    // float lerpedR = 0;
}


