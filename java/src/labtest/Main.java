package labtest;

public class Main
{	

	public void helloProcessing()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new UI());
	}
	
	public static void main(String[] args)
	{
		Main main = new Main();
		main.helloProcessing();		
	}
}
