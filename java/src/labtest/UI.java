package labtest;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class UI extends PApplet

{	
    ArrayList<Colour> colours = new ArrayList<>();
    ArrayList<Resistor> resistors = new ArrayList<>();

    public void separate(int value)
	{
		int hundreds = (value / 100);
		int tens = (value - (hundreds * 100)) / 10;
		int ones = value - ((hundreds * 100)  + (tens * 10));
		print(hundreds + ",");
		print(tens + ",");
		println(ones);
	}

    public void loadColours(){
        Table table = loadTable("colors.csv", "header");

        for(TableRow tr : table.rows()){
            colours.add(new Colour(tr));
        }
    }

    public void printColours(){
        for(Colour c : colours){
            System.out.println(c);
        }
    }

    public Colour findColour(int value){
        for(Colour c : colours){
            if(c.value == value){
                return c;
            }
        }

        return null;
    }

    public void loadResistors(){
        Table table = loadTable("resistors.csv", "header");
        for(TableRow tr : table.rows()){
            int value = tr.getInt("value");
            int hundreds = (value / 100);
            int tens = (value - (hundreds * 100)) / 10;
            int ones = value - ((hundreds * 100)  + (tens * 10));   
            resistors.add(new Resistor(value, ones, tens, hundreds, this));
        }
    }

	public void settings()
	{
		size(500, 800);
	}

	public void setup() 
	{
        stroke(0);
        noFill();
        loadResistors();
        loadColours();
        textSize(16);
	}
	
	public void draw()
	{		
        float gap = (height / resistors.size()) * 0.7f;
        translate((width / 2) - 50, gap);
        for(int i = 0; i < resistors.size(); i++){
            resistors.get(i).render(i * gap);
            fill(0);
            textAlign(LEFT);
            text(resistors.get(i).value, 200, i * gap + 50);
            noFill();
        }	

        
	}
}
