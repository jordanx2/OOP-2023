package ie.tudublin;

public class Cat {
    private String name;
    private int numLives;

    public Cat(String name)
    {
        this.name = name;
        this.numLives = 9;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getNumLives()
    {
        return this.numLives;
    }

    public void kill()
    {
        if(this.numLives > 0)
        {   
            this.numLives -= 1;
            System.out.println("Ouch!");
        } else{
            System.out.println("Dead");
        }
    }
    
}   // End class
