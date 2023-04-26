package labtest;

import processing.data.TableRow;

public class Colour {
    private int colour;
    public int r;
    public int g;
    public int b;
    public int value;

    public Colour(int colour, int r, int g, int b, int value) {
        this.colour = colour;
        this.r = r;
        this.g = g;
        this.b = b;
        this.value = value;
    }

    public Colour(TableRow tr){
        this.colour = tr.getInt("colour");
        this.r = tr.getInt("r");
        this.g = tr.getInt("g");
        this.b = tr.getInt("b");
        this.value = tr.getInt("value");
    }

    @Override
    public String toString() {
        return "Colour [colour=" + colour + ", r=" + r + ", g=" + g + ", b=" + b + ", value=" + value + "]";
    }

    public int getColour() {
        return colour;
    }
    public void setColour(int colour) {
        this.colour = colour;
    }

    
}
