package project;

import processing.core.PApplet;
import processing.core.PVector;

public class Orbiter extends Star {
    private int celestialDistance;
    private float velocity;

    public Orbiter(int size, PVector v, int color, int id, PApplet p, float velocity) {
        super(size, v, color, id, p);
        this.celestialDistance = 100;
        this.velocity = velocity;
    }

    @Override
    public void render(float amp) {
        
    }

    
}
