package project;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;

public class Celestial extends Star {
    
    private ArrayList<Orbiter> orbiters;

    public Celestial(int size, PVector v, int color, int id, PApplet p) {
        super(size, v, color, id, p);
        this.orbiters = new ArrayList<>();
    }

    @Override
    public void render(float amp) {
        rotate(amp);
    }

    private void rotate(float amp){
        p.pushMatrix();
        p.fill(getColor());
        
        p.rectMode(PApplet.CENTER);
        p.translate(getV().x, getV().y);
        p.rotate((float) (p.frameCount * 0.01f));
        
        double increase = Math.sqrt(Double.parseDouble(String.valueOf(amp)));
        p.rect(0, 0, (float)increase, (float)increase);
        p.popMatrix();
    }

}
