package project;

import processing.core.PApplet;
import processing.core.PVector;

public class Orbiter extends Star {
    private int celestialDistance;
    private float velocity;
    private float angle;
    private float x1, y1;

    public Orbiter(int size, PVector v, int color, int id, PApplet p) {
        super(size, v, color, id, p);
        this.celestialDistance = 50;
        this.velocity = (id % 2 == 0) ? -0.01f : 0.01f;
        this.angle = p.random(0, PApplet.TWO_PI);
        this.x1 = this.y1 = 0;
    }

    @Override
    public void render(float amp) {
        orbit(amp);
    }

    public void orbit(float amp){
        // System.out.println(amp);
        p.stroke(255);
        p.pushMatrix();
        x1 = PApplet.sin(angle) * (amp / 15);
        y1 = PApplet.cos(angle) * (amp / 15);
        p.translate(getV().x, getV().y);
        angle += velocity;
        p.fill(getColor());
        p.circle(x1, y1, 10);
        p.line(x1, y1, 0, 0);
        p.popMatrix();
    }

    
}
