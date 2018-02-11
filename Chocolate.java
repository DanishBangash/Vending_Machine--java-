
/**
 * A Subclass of the drink
 * 
 * @author Danish Bangash 
 * @version 1.0
 */
public class Chocolate extends Drink
{   
    /**
     * The method used to initialize the fields in the constructor
     */
    private void initialize()
    {
        name = "Chocolate";
        price = 10.0;
        time = 3;
    }
    /**
     * The Constructor of the method
     */
    public Chocolate()
    {
        initialize();
    }
    /**
     * The method that returns the price of the drink
     */
    public double getPrice()
    {
        return price;
    }
    /**
     * The method that returns the time of the drink
     */
    public int getTime()
    {
        return time;
    }
    /**
     * The method that returns the name of the drink
     */
    public String getName()
    {
       return name;    
    }
}