package ie.tudublin;

import processing.core.PApplet;

public class Circle extends PApplet{
	int rad = 80;
    float angle = 0;

	float xpos;
	float ypos;

	float xspeed = 0.8f;
	float yspeed = 0.2f;

	// Left to right
	int xdirection = -1;
	// Top to Bottom
	int ydirection = -1;

    int color = color(random(50, 255), 255, 255);

    public Circle(){}
}
