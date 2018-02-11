
/**
 * This is a selection state. It invokes Reception State if the selection is made or the Process State 
 * if the balance is enough to process the drink.
 * 
 * @author Danish Bangash
 */
public class SelectionState extends State
{
    /**
     * Constructor for objects of class SelectionState. Sets balance to a zero.
     */
    public SelectionState()
    {
       balance = 0;
       name = "SelectionState";
    }
    /**
    * Implementation of the method changeState It passes the selected drink to another state.
    */
    private String changeState(Drink drink, VendingMachine machine)
    {
        if(balance >= drink.getPrice())
        {
          String output = display(drink, machine);
          machine.setState( new DetectionState(this, drink, machine));
          return output;
        }
        else
        {
          String output = display(drink, machine);
          machine.setState( new ReceptionState(this));
          return output;
        }
    }
    /**
    * After selection is made, changes the state of the Vending Machine. 
    */
    public String makeSelection(Drink drink, VendingMachine machine)
    {   
         String output = changeState(drink, machine);
         return output;
    }
    /**
    * Increases the balance according to inserted amount. 
    * Also prints the current amount.
    */
    public String insertMoney(double amountInserted, Drink drink, VendingMachine machine)
    {
         balance += amountInserted;
         return "Amount Inserted: " + balance;
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
    * Invokes new Selection State and displays refunded amount.
    */
    public String refund(VendingMachine machine)
    {
         machine.setState(new SelectionState());
         return "" + balance + " dkk is refunded."; 
    }
    /**
     * The method which return the name of the State
     */
    public String getName()
    {
        return name;
    }
}