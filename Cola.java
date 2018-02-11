
/**
 * A Subclass of the drink
 * 
 * @author Danish Bangash
 * @version 1.0
 */
public class Cola extends Drink
{  
    /**
     * The method used to initialize the fields in the constructor
     */
    private void initialize()
    {
        name = "Cola";
        price = 18.0;
        time = 2;
    }
    /**
     * The Constructor of the method
     */
    public Cola()
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