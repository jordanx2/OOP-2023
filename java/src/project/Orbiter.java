package project;

import ddf.minim.analysis.FFT;
import processing.core.PApplet;
import processing.core.PVector;

public class Orbiter extends Star {
    private int celestialDistance;
    private float velocity;
    private float angle;
    private float x1, y1;
    float[] lerpedBuffer;

    public Orbiter(int size, PVector v, int color, int id, PApplet p, FFT fft) {
        super(size, v, color, id, p, fft);
        this.celestialDistance = 50;
        this.velocity = (id % 2 == 0) ? -0.01f : 0.01f;
        this.angle = p.random(0, PApplet.TWO_PI);
        this.x1 = this.y1 = 0;
        this.lerpedBuffer = new float[p.width];

    }

    @Override
    public void render() {
        float mappedValue = PApplet.map(PApplet.constrain(highhats(), -1, 1), -1, 1, 0, 100);
        orbit(PApplet.lerp(0f, mappedValue, 0.5f));

        
    }

    @Override
    public float calculateFFT(){
        float avgAmp = Float.MAX_VALUE;
        for(int i = 0; i < fft.specSize() / 2; i++){
            lerpedBuffer[i] = PApplet.lerp(lerpedBuffer[i], fft.getBand(i), 0.07f);
            avgAmp += lerpedBuffer[i];
            if(lerpedBuffer[i] < avgAmp){
                avgAmp = lerpedBuffer[i];
            }
        }
    
        return avgAmp;
    }

    public float highhats() {
        int numBands = 8;
        float[] spectrum = fft.getSpectrumReal();
        float[] highHatBands = new float[numBands];
      
        // Calculate frequency range for high-hats
        float highHatMinFreq = 2000; // Minimum frequency for high-hats
        float highHatMaxFreq = 10000; // Maximum frequency for high-hats
      
        float binWidth = 44100 / spectrum.length; // Width of each frequency bin in Hz
        int startIndex = Math.round(highHatMinFreq / binWidth);
        int endIndex = Math.round(highHatMaxFreq / binWidth);
        
        // Ensure startIndex and endIndex are within bounds
        startIndex = Math.max(startIndex, 0);
        endIndex = Math.min(endIndex, spectrum.length - 1);
        
        // Calculate magnitude for each frequency band
        float bandWidth = (endIndex - startIndex) / numBands;
        for (int i = 0; i < numBands; i++) {
          float bandStartIndex = startIndex + i * bandWidth;
          float bandEndIndex = bandStartIndex + bandWidth;
          float bandMagnitude = 0;
          for (int j = (int) bandStartIndex; j < bandEndIndex; j++) {
            bandMagnitude += spectrum[j];
          }
          highHatBands[i] = bandMagnitude;
        }
      
        // Normalize the magnitude values
        float max = Float.MIN_VALUE;
        for (float n : highHatBands) {
          if (n > max) {
            max = n;
          }
        }
        for (int i = 0; i < numBands; i++) {
          highHatBands[i] /= max;
        }

        // Calculate the average of the normalized magnitudes of each high-hat band
        float sum = 0;
        for (float n : highHatBands) {
        sum += n;
        }
        float avg = sum / numBands;

        return avg;

      }
      
    

    public void orbit(float amp){
        // System.out.println(amp);
        p.stroke(255);
        p.pushMatrix();
        x1 = PApplet.sin(angle) * (amp + celestialDistance);
        y1 = PApplet.cos(angle) * (amp + celestialDistance);
        System.out.println(x1);
        p.translate(getV().x, getV().y);
        angle += velocity;
        p.fill(getColor());
        p.circle(x1, y1, 10);
        p.line(x1, y1, 0, 0);
        p.popMatrix();
    }

    
}
