package project;

import java.util.ArrayList;

import ddf.minim.analysis.FFT;
import processing.core.PApplet;
import processing.core.PVector;

public class Celestial extends Star {
    
    private ArrayList<Orbiter> orbiters;
    private float velocity;
    float[] lerpedBuffer;

    public Celestial(int size, PVector v, int color, int id, PApplet p, FFT fft) {
        super(size, v, color, id, p, fft);
        this.orbiters = new ArrayList<>();
        for(int i = 1; i < p.random(3, 12); i++){
            int c = p.color(p.random(255), 255, p.random(255));
            orbiters.add(new Orbiter(10, new PVector(this.getV().x, this.getV().y), c, (int)p.random(1, 1000), p, fft));
        }
        this.velocity = (id % 2 == 0) ? -0.01f : 0.01f;
        this.lerpedBuffer = new float[p.width];
    }

    @Override
    public void render() {
        rotate(calculateFFT());

        for(Orbiter o: orbiters){
            o.render();
        }
    }

    private void rotate(float amp){
        p.strokeWeight(1);
        p.pushMatrix();
        p.fill(getColor());
        
        p.rectMode(PApplet.CENTER);
        p.translate(getV().x, getV().y);
        p.rotate((float) (p.frameCount * velocity));
        
        double increase = Math.sqrt(Double.parseDouble(String.valueOf(amp)));
        p.rect(0, 0, (float)increase + getSize(), (float)increase + getSize());
        p.popMatrix();
    }

    @Override
    public float calculateFFT() {
        float amp = 0;
        for(int i = 0; i < fft.specSize() / 2; i++){
            lerpedBuffer[i] = PApplet.lerp(lerpedBuffer[i], fft.getBand(i), 0.07f);
            amp += lerpedBuffer[i];
        }
        return amp;
    }
}
