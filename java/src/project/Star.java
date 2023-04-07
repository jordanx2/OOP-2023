package project;

import ddf.minim.analysis.FFT;
import processing.core.PApplet;
import processing.core.PVector;

interface actions{
    public void render();
    public float calculateFFT();
}

public abstract class Star implements actions{
    private int size;
    private PVector v;
    private int color; 
    private int id;
    FFT fft;
    PApplet p;    

    
    public Star(int size, PVector v, int color, int id, PApplet p, FFT fft) {
        this.size = size;
        this.v = v;
        this.color = color;
        this.id = id;
        this.p = p;
        this.fft = fft;
    }

    // Getters and Setters
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
}
