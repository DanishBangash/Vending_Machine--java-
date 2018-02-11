import java.lang.*;
import java.util.HashMap;

/**
 * The Vending Machine class is the environment of the programme and has a State for the 
 * finite state machine and a Graphical User Interface with the MVC (Model-View-Controller) Design.
 * 
 * @author Danish Bangash
 * @version 1.0
 */
public class VendingMachine
{
    /**
     * Field which stores the state of the VendingMachine
     */
    private State state;
    /**
     * Field which stores the drink that is going to be bought by the user
     */
    private Drink drink;
    /**
     * Field which stores the Graphical User Interface of the VendingMachine
     */
    private UserInterface gui;
    /**
     * Field which stores the HashMap with String and Drink object parameters
     */
    private HashMap<String,Drink> map;
    
    /**
     * The constructor of the VendingMachine:
     * Creates the Graphical User Interface and passes this VendingMachine object.
     * Initialize the state with the Selection State.
     * Initialize the HashMap and fill it with the corresponding name and drink object.
     */
    public VendingMachine()
    {
       state = new SelectionState(); 
       drink = null;
       map = new HashMap<String, Drink>();
       map = fillMap();
       gui = new UserInterface(this); 
    }
    /**
     * Fills the HashMap with the Drink Objects and return the HashMap
     */
    public HashMap<String,Drink> fillMap()
    {
        map.put("coffee", new Coffee());
        map.put("tea", new Tea());
        map.put("water", new Water());
        map.put("cola", new Cola());
        map.put("chocolate", new Chocolate());       
        return map;
    }    
    /**
     * The method which sets the state into a new state
     */
    public void setState(State state)
    {
        this.state = state;
    }
    /**
     * The method which takes a selection String from the Graphical User Interface
     * and makes the selection upon this String which creates a new Drink object using the HashMap
     */
    public String makeSelection(String selection)
    {      
           drink = map.get(selection);
           String output = state.makeSelection(drink, this);
           return output;
    }
    /**
     * The method which takes the amount parameter and increases the balance by that amount
     * and returns the output from the state's method
     */
    public String insertMoney(double amount)
    {
       String output = state.insertMoney(amount,drink, this);   
       return output;
    }
    /**
     * This method is called if the user request for refund 
     * and it returns the output from the state's method
     */
    public String refund()
    {
       String output = state.refund(this);
       return output;
    }
    /**
     * The method which allows the user to take away the drink
     * and returns the output from the state's method
     */
    public String takeAway()
    {
       String output = state.takeAway(drink, this);
       return output;
    }
    /**
     * The method which returns the Drink
     */
    public Drink getDrink()
    {
       return drink;    
    }
    /**
     * The method which returns the State
     */
    public State getState()
    {
       return state;
    }
}
