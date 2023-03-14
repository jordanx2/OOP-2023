package project;

import processing.core.PApplet;

public class Stars {
    private int size;
    private float x;
    private float y;
    private int color;
    private PApplet p;

    public Stars(int size, float x, float y, int color, PApplet p) {
        this.size = size;
        this.x = x;
        this.y = y;
        this.color = color;
        this.p = p;
    }

    public void render(){
        p.fill(this.color);
        p.circle(this.x, this.y, this.size);
    }

    public void burst(){
        if(this.size > 3){
            // setSize(3);
        } else{
            setSize(getSize() + 3);
        }
    }

    public int getSize() {
        return size;
    }


    public void setSize(int size) {
        this.size = size;
    }


    public float getX() {
        return x;
    }


    public void setX(float x) {
        this.x = x;
    }


    public float getY() {
        return y;
    }


    public void setY(float y) {
        this.y = y;
    }


    public int getColor() {
        return color;
    }


    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Stars [size=" + size + ", x=" + x + ", y=" + y + ", color=" + color + "]";
    }

}
