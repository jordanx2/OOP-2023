package project;

public class Main
{

	public static void runSketch()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new MainSketch());
    }
	
	public static void main(String[] args)
	{
		runSketch();
		
	}
	
}