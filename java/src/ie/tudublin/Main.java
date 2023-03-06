package ie.tudublin;

public class Main
{

	public static void helloProcessing()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new HelloProcessing());
    }

	public static void loops()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Loops());
    }

	public static void bugZap()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new BugZap());
    }

	public static void starMap()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new StarMap());
    }

	public static void audio1()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Audio1());
    }
<<<<<<< HEAD

	public static void audio2()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Audio2());
    }
||||||| 33a6f60
=======

	public static void audio2()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Audio2());
    }

	public static void audio3()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Audio3());
    }

	public static void life()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Life());
    }
>>>>>>> 44b46f78b67684c08ae612f4dc0d0d719be21c5d
	
	public static void main(String[] args)
	{

<<<<<<< HEAD
		// PitchSpeller ps = new PitchSpeller();
		// System.out.println(ps.spell(330));
		// System.out.println(ps.spell(420));
		// System.out.println(ps.spell(1980));

		audio2();
		
||||||| 33a6f60
		audio1();
=======
		life();
>>>>>>> 44b46f78b67684c08ae612f4dc0d0d719be21c5d
	}
	
}