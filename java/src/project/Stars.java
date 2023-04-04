package project;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;

public class Stars {
    private int size;
    PVector v;
    private int color;
    private PApplet p;

    private boolean clockWise;
    private int id;
    private boolean isLeader;
    private ArrayList<Stars> orbitingStars;

    public Stars(int size, float x, float y, int color, PApplet p, boolean clockWise, int id) {
        this.size = size;
        this.v = new PVector();
        this.v.x = x;
        this.v.y = y;
        this.color = color;
        this.p = p;
        this.clockWise = clockWise;
        this.id = id;
        this.isLeader = isPrime(id);
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
        p.rect(0, 0, increase, increase);
        p.popMatrix();
    }

    private boolean isPrime(int i){
        for (int j = 2; j <= Math.sqrt(i); j++) {
            if (i % j == 0) {
                return false;
            }
        }

        return true;
    }




    // Getters and setters
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public PVector getV() {
        return v;
    }

    public void setV(PVector v) {
        this.v = v;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public PApplet getP() {
        return p;
    }

    public void setP(PApplet p) {
        this.p = p;
    }

    public boolean isClockWise() {
        return clockWise;
    }

    public void setClockWise(boolean clockWise) {
        this.clockWise = clockWise;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isLeader() {
        return isLeader;
    }

    public void setLeader(boolean isLeader) {
        this.isLeader = isLeader;
    }

}
