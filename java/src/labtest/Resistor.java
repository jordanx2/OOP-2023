package labtest;

import processing.core.PApplet;

public class Resistor {
    public int value;
    public int ones;
    public int tens;
    public int hundreds;
    PApplet p;

    public Resistor(int value, int ones, int tens, int hundreds, PApplet p) {
        this.value = value;
        this.ones = ones;
        this.tens = tens;
        this.hundreds = hundreds;
        this.p = p;
    }

    int size = 100;
    int h = size / 2;
    public void render(float pos){
        p.rect(0, pos, size, size);
        p.line(size + h, pos + h, size, pos + h );
        p.line(0, pos + h, -size/2, pos + h );
    }

    
}
