
/**
 * Abstract class Drink - an Abstract class which represents the simple Drink object
 * 
 * @author Danish Bangash
 * @version 1.0
 */
public abstract class Drink
{
    /**
     * Field that stores the name of the drink
     */
    protected String name;
    /**
     * Field that stores the price of the drink
     */
    protected double price;
    /**
     * Field that stores the time of the drink
     */
    protected int time;
    /**
     * The method which returns the price of the drink
     */
    abstract public double getPrice();
    /**
     * The method which returns the required time of the drink to get ready
     */
    abstract public int getTime();
    /**
     * The method which returns the name of the drink
     */
    abstract public String getName();
}
