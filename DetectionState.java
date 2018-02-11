
/**
 * Detection State class. Waits for the drink to be taken away.
 * 
 * @author Danish Bangash,
 * @version 1.0
 */
public class DetectionState extends State
{
    /**
     * Constructor of the DetectionState. 
     */
    public DetectionState(State state, Drink drink, VendingMachine machine)
    {
        this(state.balance);
    }

    /**
     * Constructor of the DetectionState. Initiazlizes the current balance.
     */
    public DetectionState(double balance)
    {
        this.balance = balance;
        name = "DetectionState";
    } 

    /**
     * Invokes new Selection State. If the current balance is equal to a drink price, 
     * writes friendly message. Otherwise writes refunded amount.
     */
    public String takeAway(Drink drink, VendingMachine machine)
    {
        if(balance == drink.getPrice())
        {         
            machine.setState( new SelectionState() );
            return "Thank you! Enjoy your drink :)";
        }
        else
        {       
            machine.setState( new SelectionState() );
            return "Thank you! " + (balance - drink.getPrice()) + " dkk is refunded";
        }
    }

    /**
     * The method which return the name of the State
     */
    public String getName()
    {
        return name;
    }
}
