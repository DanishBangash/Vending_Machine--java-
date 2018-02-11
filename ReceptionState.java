
/**
 * Reception State class. Ask for the money if the current balance is not enough to process the drink.
 * 
 * 
 * @author Danish Bangash
 * @version 1.0
 */
public class ReceptionState extends State
{
    /**
     * Constructor of the Reception state. Take a state as a parametr.
     */
    public ReceptionState(State state)
    {
        this(state.balance);
    }

    /**
     * Constructor for objects of class ReceptionState. Initiazlizes the balance.
     */
    public ReceptionState(double balance)
    {
        this.balance = balance; 
        name = "ReceptionState";
    }

    /**
     * If the current balance is enough invokes Process State. Otherwise displayes inserted amount.
     */
    public String insertMoney(double amountInserted, Drink drink, VendingMachine machine)
    {
        balance += amountInserted;
        if( balance >= drink.getPrice() )
        {
            String output = display(drink, machine);
            machine.setState( new DetectionState(this, drink, machine) );    
            return output;
        }
        else
        {
            String output = display(drink, machine);
            return "Amount Inserted: " + balance + "\n" + output;          
        }
    }

    /**
     * Invokes new Selection State, and displayes refunded amount.
     */
    public String refund(VendingMachine machine)
    {
        machine.setState(new SelectionState());
        String output = "" + balance + " dkk is refunded.";

        return output;

    }

    /**
     * Displays the current situation of the selection. If inserted amount is enough, it displays 
     * information about selection and waiting time. If the balance is not enough, it displays selection
     * and remaining amount. 
     */
    public String display(Drink drink, VendingMachine machine)
    {
        if(balance >= drink.getPrice())
            return "Selection: " + drink.getName() + "\nWait for " + drink.getTime() + " seconds";
        else
            return "Selection: " + drink.getName() + "\nRemaining Amount: "+ (drink.getPrice() - balance);
    }

    /**
     * After selection is made, changes the state of the Vending Machine. 
     */
    public String makeSelection(Drink drink, VendingMachine machine)
    {   
        if(balance == 0)
        {
            String output = display(drink, machine);
            machine.setState(new ReceptionState(this));
            return output;
        }
        else if(balance<drink.getPrice())
        {
            String output = display(drink, machine);
            return output + "\nAmount Inserted: " + balance ; 
        }
        else
        {
            String output = display(drink, machine);
            machine.setState(new DetectionState(this, drink, machine));
            return output;
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
