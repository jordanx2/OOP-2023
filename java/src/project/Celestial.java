package project;

import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PVector;

public class Celestial extends Star {
    
    private ArrayList<Orbiter> orbiters;

    public Celestial(int size, PVector v, int color, int id, PApplet p) {
        super(size, v, color, id, p);
        this.orbiters = new ArrayList<>();
        for(int i = 1; i < p.random(3, 12); i++){
            int c = p.color(p.random(255), 255, p.random(255));
            orbiters.add(new Orbiter(10, new PVector(this.getV().x, this.getV().y), c, (int)p.random(1, 1000), p));
        }
    }

    @Override
    public void render(float amp) {
        rotate(amp);

        for(Orbiter o: orbiters){
            o.render(amp);
        }
    }

    private void rotate(float amp){
        p.strokeWeight(1);
        p.pushMatrix();
        p.fill(getColor());
        
        p.rectMode(PApplet.CENTER);
        p.translate(getV().x, getV().y);
        p.rotate((float) (p.frameCount * 0.01f));
        
        double increase = Math.sqrt(Double.parseDouble(String.valueOf(amp)));
        p.rect(0, 0, (float)increase + getSize(), (float)increase + getSize());
        p.popMatrix();
    }
}
