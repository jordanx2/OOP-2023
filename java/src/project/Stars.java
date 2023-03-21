package project;

import processing.core.PApplet;
import processing.core.PVector;

public class Stars {
    private int size;
    PVector v;
    private int color;
    private PApplet p;
    private boolean clockWise;

    public Stars(int size, float x, float y, int color, PApplet p, boolean clockWise) {
        this.size = size;
        this.v = new PVector();
        this.v.x = x;
        this.v.y = y;
        this.color = color;
        this.p = p;
        this.clockWise = clockWise;
    }

    public void render(float amp){
        p.noStroke();
        rotateSquares(amp);

    }


    private void rotateSquares(float amp){
        p.pushMatrix();
        p.fill(this.color);
        p.rectMode(PApplet.CENTER);
        p.translate(this.v.x, this.v.y);
        if(this.clockWise){
            p.rotate((float) (p.frameCount * 0.01f));
        } else{
            p.rotate((float) (p.frameCount * -0.01f));
        }
        
        float increase = (amp / this.size) / 3;
        // System.out.println(increase );
        p.rect(0, 0, increase, increase);
        p.popMatrix();
    }

}
