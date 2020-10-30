import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JLabel nLabel;
  JLabel factorialLabel;

  JTextField nInput;
  JTextField factorialOutput;

  JButton calculateButton;

  JPanel mainPanel;
  

  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Factorial Calculator");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);
 
    //creates main panel and shows it
    mainPanel = new JPanel();
    mainPanel.setLayout(null);
    frame.add(mainPanel);

    //creates labels
    nLabel = new JLabel("n");
    nLabel.setBounds(165, 200, 35, 25);
    factorialLabel = new JLabel("factorial(n)");
    factorialLabel.setBounds(315, 200, 100, 25);

    //shows labels
    mainPanel.add(nLabel);
    mainPanel.add(factorialLabel);

    //creates textfields and sets setBounds
    nInput = new JTextField();
    nInput.setBounds(205, 200, 80, 25);
    factorialOutput = new JTextField();
    factorialOutput.setBounds(420, 200, 80, 25);

    //shows text fields
    mainPanel.add(nInput);
    mainPanel.add(factorialOutput);

    //creates button
    calculateButton = new JButton("CALC");
    calculateButton.setBounds(520, 200, 80, 25);

    //sets button as action command
    calculateButton.setActionCommand("Calculate");

    //add action ActionListener
    calculateButton.addActionListener(this);

    //makes button setVisible
    mainPanel.add(calculateButton);

  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();
    

    //for loop for calulating factuorials
    if(command.equals("Calculate")){
 
      //product
      int product = 1;
    
      //makes users number into an integer
      String nText = nInput.getText();
      int n = Integer.parseInt(nText);

      //for loop to calutlate factorial
      for(int i = n - (1); i >= 1; i--){
        //calculates for first time
        if(i == n - (1)){
          product = n * i;
        //calculates for the remaining numbers
        }else{
          product = product * i;
        }
      }
      //sets product to String
      String printedAnswer = "" + product;
      //prints answer
      factorialOutput.setText(printedAnswer);
    }

  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
