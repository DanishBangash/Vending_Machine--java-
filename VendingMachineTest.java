

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class VendingMachineTest.
 *
 * @author Danish Bangash
 * @version 1.0
 */
public class VendingMachineTest
{
    /**
     * Default constructor for test class VendingMachineTest
     */
    public VendingMachineTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void SelectDrink_InsertMoney_TakeDrink()
    {
        VendingMachine vendingM1 = new VendingMachine();
        vendingM1.makeSelection("coffee");
        vendingM1.insertMoney(15);
        vendingM1.takeAway();
    }

    @Test
    public void InsertMoney_SelectDrink_TakeDrink()
    {
        VendingMachine vendingM1 = new VendingMachine();
        vendingM1.insertMoney(15);
        vendingM1.makeSelection("coffee");
        vendingM1.takeAway();
    }

    @Test
    public void InsertMoney_Refund()
    {
        VendingMachine vendingM1 = new VendingMachine();
        vendingM1.insertMoney(15);
        vendingM1.refund();
    }

    @Test
    public void SelectDrink_InsertMoney_NotEnough_Refund()
    {
        VendingMachine vendingM1 = new VendingMachine();
        vendingM1.makeSelection("coffee");
        vendingM1.insertMoney(10);
        vendingM1.refund();
    }
    
    @Test
    public void InsertMoney_SelectDrink_InsertMoney_TakeAway()
    {
        VendingMachine vendingM1 = new VendingMachine();
        vendingM1.insertMoney(5);
        vendingM1.makeSelection("coffee");
        vendingM1.insertMoney(10);
        vendingM1.takeAway();
    }
}




