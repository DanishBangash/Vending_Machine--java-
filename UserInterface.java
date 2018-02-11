import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Color;
import java.net.URL;
/**
 * Write a description of class UserInterface here.
 * 
 * @author Danish Bangash
 * @version 1.0
 */
public class UserInterface
{
    // Controller of the GUI
    private VendingMachine machine;
    // Frame of the GUI
    private JFrame frame;
    // Panels of the Frame
    private JPanel selectionPanel;
    private JPanel functionPanel;
    private JPanel insertionPanel;
    private JPanel outputPanel;
    // Logo and Screen of the Frame
    private JLabel logoLabel;
    private JTextArea outputLabel;
    // Buttons of the Frame
    private JButton selectTeaButton;
    private JButton selectCoffeeButton;
    private JButton selectWaterButton;
    private JButton selectColaButton;
    private JButton selectChocoButton;
    private JButton insert1dkkButton;
    private JButton insert2dkkButton;
    private JButton insert5dkkButton;
    private JButton insert10dkkButton;
    private JButton insert20dkkButton;
    private JButton refundButton;
    private JButton takeAwayButton;
    // Output String
    private String output;

    /**
     * Constructor for objects of class UserInterface
     * It takes the VendingMachine as a parameter
     * and creates the Frame
     */
    public UserInterface(VendingMachine machine)
    {
        this.machine = machine; 
        makeFrame();
        frame.setResizable(false);
        frame.setVisible(true);      
    }

    /**
     * The method which creates the Frame and all interface components
     */
    private void makeFrame()
    {
        frame = new JFrame("Push Vending 2.3");
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = (JPanel)frame.getContentPane();
        contentPane.setLayout(new BorderLayout(8, 8));
        contentPane.setBorder(new EmptyBorder( 10, 10, 10, 10));
        contentPane.setBackground(new Color(0,0,0)); // Sets the background to Black

        // Create all the Panels
        makePanels();
        
        // Add the BorderLayout Component to corresponding places
        contentPane.add(outputPanel, BorderLayout.CENTER);
        contentPane.add(logoLabel, BorderLayout.NORTH);
        contentPane.add(selectionPanel, BorderLayout.EAST);
        contentPane.add(functionPanel, BorderLayout.SOUTH);
        contentPane.add(insertionPanel, BorderLayout.WEST);
    }

    public void makePanels()
    {
        // Output Panel
        outputPanel = new JPanel();    
        
        outputLabel = new JTextArea("Welcome to Push Vending 2.3!!");
        outputLabel.setEditable(false);  
        outputLabel.setCursor(null);  
        outputLabel.setOpaque(false);  
        outputLabel.setFocusable(false);
        outputLabel.setFont(new Font("TimesNewRoman", Font.BOLD, 18));
        outputLabel.setForeground(Color.white);
        
        outputPanel.setBackground(new Color(128,128,128));
        outputPanel.add(outputLabel);
        
        // Create the logoLabel with the logo picture
        URL url = getClass().getResource("logo.jpg");
        ImageIcon imageicon = new ImageIcon(url);

        logoLabel = new JLabel( imageicon ); 
        
        // Create the Panels
        makeSelectionPanel();
        makeInsertionPanel();
        makeFunctionPanel();

    }
    /**
     * Makes the Selection Panel
     */
    public void makeSelectionPanel()
    {
        selectionPanel = new JPanel(new GridLayout(5, 1));
        
        selectTeaButton = new JButton("Tea");
        selectTeaButton.setActionCommand("tea");
        selectCoffeeButton = new JButton("Coffee");
        selectCoffeeButton.setActionCommand("coffee");
        selectWaterButton = new JButton("Water");
        selectWaterButton.setActionCommand("water");
        selectColaButton = new JButton("Cola");
        selectColaButton.setActionCommand("cola");
        selectChocoButton = new JButton("Choco");
        selectChocoButton.setActionCommand("chocolate");

        ActionListener drinkButtonListener = new ActionListener()
            {

                public void actionPerformed(ActionEvent evt)
                {
                    String cmd = evt.getActionCommand();
                    if(cmd.equals("tea"))
                    {
                        output = machine.makeSelection("tea");
                    }
                    else if(cmd.equals("coffee"))
                    {
                        output = machine.makeSelection("coffee");
                    }
                    else if(cmd.equals("water"))
                    {
                        output = machine.makeSelection("water");
                    }
                    else if(cmd.equals("cola"))
                    {
                        output = machine.makeSelection("cola");
                    }
                    else if(cmd.equals("chocolate"))
                    {
                        output = machine.makeSelection("chocolate");
                    }
                    else
                    {
                        output = null;
                    }

                    outputLabel.setText(output);
                    disableAllButtons();
                }
            };

        selectTeaButton.addActionListener(drinkButtonListener);
        selectCoffeeButton.addActionListener(drinkButtonListener);
        selectWaterButton.addActionListener(drinkButtonListener);
        selectColaButton.addActionListener(drinkButtonListener);
        selectChocoButton.addActionListener(drinkButtonListener);

        selectionPanel.add(selectTeaButton);
        selectionPanel.add(selectCoffeeButton);
        selectionPanel.add(selectWaterButton);
        selectionPanel.add(selectColaButton);
        selectionPanel.add(selectChocoButton);
    }
    /**
     * Makes the Function Panel
     */
    public void makeFunctionPanel()
    {
        functionPanel = new JPanel(new GridLayout(1, 2));
        
        takeAwayButton = new JButton("TakeAway");
        takeAwayButton.setEnabled(false);
        // When the drink is taken away it enables all the buttons and disables itself
        takeAwayButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent evt){
                    output = machine.takeAway();
                    outputLabel.setText(output);

                    takeAwayButton.setEnabled(false);
                    refundButton.setEnabled(true);
                    selectTeaButton.setEnabled(true);
                    selectCoffeeButton.setEnabled(true);
                    selectWaterButton.setEnabled(true);
                    selectColaButton.setEnabled(true);
                    selectChocoButton.setEnabled(true);
                    insert1dkkButton.setEnabled(true);
                    insert2dkkButton.setEnabled(true);
                    insert5dkkButton.setEnabled(true);
                    insert10dkkButton.setEnabled(true);
                    insert20dkkButton.setEnabled(true);
                }
            }
        );

        refundButton = new JButton("Refund");
        refundButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent evt){
                    output = machine.refund();
                    outputLabel.setText(output);
                }
            }
            );
        
        
        functionPanel.add(takeAwayButton);
        functionPanel.add(refundButton);
    }
    /**
     * Makes the Insertion Panel
     */
    public void makeInsertionPanel()
    {
        insertionPanel = new JPanel(new GridLayout(5, 1));
        
        insert1dkkButton = new JButton("1dkk");
        insert1dkkButton.setActionCommand("1");
        insert2dkkButton = new JButton("2dkk");
        insert2dkkButton.setActionCommand("2");
        insert5dkkButton = new JButton("5dkk");
        insert5dkkButton.setActionCommand("5");
        insert10dkkButton = new JButton("10dkk");
        insert10dkkButton.setActionCommand("10");
        insert20dkkButton = new  JButton("20dkk");
        insert20dkkButton.setActionCommand("20");

        ActionListener insertButtonListener = new ActionListener()
            {
                public void actionPerformed(ActionEvent evt)
                {
                    String cmd = evt.getActionCommand();

                    if(cmd.equals("1"))
                    {
                        output = machine.insertMoney(1);
                    }
                    else if(cmd.equals("2"))
                    {
                        output = machine.insertMoney(2);
                    }
                    else if(cmd.equals("5"))
                    {
                        output = machine.insertMoney(5);
                    }
                    else if(cmd.equals("10"))
                    {
                        output = machine.insertMoney(10);
                    }
                    else if(cmd.equals("20"))
                    {
                        output = machine.insertMoney(20);
                    }
                    else
                    {
                        output = null;
                    }

                    outputLabel.setText(output);
                    disableAllButtons();
                }
            };

        insert1dkkButton.addActionListener(insertButtonListener);
        insert2dkkButton.addActionListener(insertButtonListener);
        insert5dkkButton.addActionListener(insertButtonListener);
        insert10dkkButton.addActionListener(insertButtonListener);
        insert20dkkButton.addActionListener(insertButtonListener);

        insertionPanel.add(insert1dkkButton);
        insertionPanel.add(insert2dkkButton);
        insertionPanel.add(insert5dkkButton);
        insertionPanel.add(insert10dkkButton);
        insertionPanel.add(insert20dkkButton);
    }
    /**
     * It disables all the buttons if the state changes into the Detection State
     * until the process time of the drink ends and it only enables the Take Away Button
     */
    public void disableAllButtons()
    {
        if(machine.getState().getName().equals("DetectionState"))
        {
            refundButton.setEnabled(false);
            selectTeaButton.setEnabled(false);
            selectCoffeeButton.setEnabled(false);
            selectWaterButton.setEnabled(false);
            selectColaButton.setEnabled(false);
            selectChocoButton.setEnabled(false);
            insert1dkkButton.setEnabled(false);
            insert2dkkButton.setEnabled(false);
            insert5dkkButton.setEnabled(false);
            insert10dkkButton.setEnabled(false);
            insert20dkkButton.setEnabled(false);

            Timer timer = new Timer();
            try{
                timer.schedule(new TimerTask(){
                        public void run(){
                            takeAwayButton.setEnabled(true);
                            refundButton.setEnabled(false);
                            selectTeaButton.setEnabled(false);
                            selectCoffeeButton.setEnabled(false);
                            selectWaterButton.setEnabled(false);
                            selectColaButton.setEnabled(false);
                            selectChocoButton.setEnabled(false);
                            insert1dkkButton.setEnabled(false);
                            insert2dkkButton.setEnabled(false);
                            insert5dkkButton.setEnabled(false);
                            insert10dkkButton.setEnabled(false);
                            insert20dkkButton.setEnabled(false);
                        }
                    },machine.getDrink().getTime()*1000);
            }
            catch (Exception ex)
            {}
        }
    }
}
