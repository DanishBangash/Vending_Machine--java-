
/**
 * This is shared abstract class State, all the states inherit from this class.
 * Class implements methods used in states, each method corresponds to a specific state. 
 * All the implementation of the methods are in inhereted states.
 * 
 * @author Danish Bangash
 */
public abstract class State
{
    protected double balance ;
    protected String name ;
    
    public String makeSelection(Drink drink, VendingMachine machine){return "";}
    public String insertMoney(double amountInserted,Drink drink, VendingMachine machine){return "";}
    public String display(Drink drink, VendingMachine machine){return "";}
    public String refund(VendingMachine machine){return "";}
    public String takeAway(Drink drink, VendingMachine machine){return "";}
    public String getName(){return "";}
}