import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame
{
  // a formality
  private static final long serialVersionUID = 1L;
  private static final int HEIGHT = 120; // size of the 
  private static final int WIDTH = 360;  // window
  private JTextField myText; // a text field for input
  private JTextArea myLabel;    // a static field for output

  public GUI()
  {
    // boilerplate operations
    this.setTitle("Last Lab");
    this.setSize(WIDTH, HEIGHT); 
    //this.setLayout(new FlowLayout());
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.createContents(); // this ones ours
    // Set the frame to the center of the screen
    this.setLocationRelativeTo(null);
    this.setVisible(true);
  }
  

  public void createContents()
  {
    // create and add everything you want in the JFrame ...
    myText = new JTextField("Enter your age here.");
    myLabel = new JTextArea();
    myLabel.setLineWrap(true);
    myLabel.setWrapStyleWord(true);
    add(myText, BorderLayout.PAGE_START);
    add(myLabel, BorderLayout.CENTER);
    myText.addActionListener(new MyListener());
  }
  
  
  // nested private class
  private class MyListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
        try{
            int value = Integer.parseInt(myText.getText());
            // Quick edge case to make sure value was positive between (0-200]
            if(value <= 0 || value > 200){ throw new NumberFormatException(); }
            if( value < 36 ){
                myLabel.setText("\"The duty of youth is to challenge corruption.\" " +
                        "\n -Kurt Cobain");
            }
            else if(value < 46){
                myLabel.setText("\"The really frightening thing about middle age is " +
                        "the knowledge you'll grow out of it.\" \n-Doris Day");
            }
            else{
                myLabel.setText("\"Old age is just a record of one's whole life.\" \n" +
                        "-Muhammad Ali");
            }

        }catch(NumberFormatException e){
            myLabel.setText("Invalid entry, I need a positive integer value." +
                    "\nBetween 0 and 200");
        }
    }
  }
  // nested private class
  
  
  
  public static void main(String[] args)
  {
    new GUI();
  }
}

