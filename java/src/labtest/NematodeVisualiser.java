package labtest;

import java.util.ArrayList;
import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet {
    ArrayList<Nematode> nema = new ArrayList<>();
    int index = 0;

    public void settings(){
        size(800, 800);
    }

    public void setup(){
        background(0);
        colorMode(RGB);
        stroke(255);
        fill(0);
        strokeWeight(2);
        textSize(14);
        loadNematodes();
    }

    public void loadNematodes(){
        Table table = loadTable("nematodes.csv", "header");
        for(TableRow t : table.rows()){
            nema.add(new Nematode(t, this));
        }
        nema.get(10).render();
    }

    public void drawArrows(){
        pushMatrix();
        translate(width / 2, height / 2);
        translate(-250, 0);
        line(0, 0, 30, -20);
        line(0, 0, 30, 20);
        line(0, 0, 80, 0);
        popMatrix();

        pushMatrix();
        translate(width / 2, height / 2);
        translate(250, 0);
        line(0, 0, -30, -20);
        line(0, 0, -30, 20);
        line(0, 0, -80, 0);
        popMatrix();
    }

    public void keyPressed(){
        if(keyCode == LEFT){
            System.out.println("hello");
            index = (index == 0) ? nema.size() - 1 : index -1;
        }

        if(keyCode == RIGHT){
            index = (index + 1) % nema.size();
        }
    }

    public void draw(){
        background(0);
        nema.get(index).render();
        drawArrows();
    }
}
