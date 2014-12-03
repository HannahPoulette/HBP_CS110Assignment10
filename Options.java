import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;  

public class Options extends JFrame
{

   private static final int WINDOW_WIDTH = 500; //width in pixels
   private static final int WINDOW_HEIGHT = 450; //length in pixels
   
   private JPanel optionPanel; 
   private int[] players;
   private JComboBox playerBox; 
   private Jabel p1nLabel, p2nLabel; 
   private JTextField p1n, p2n; 
  
  

   public Options()
   {
      //set title, size, close operation
      setTitle("Set Game Preferences"); 
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT); 
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
            
   private void build()
   {  
      
      //Create and format the panel
      optionPanel = new JPanel(); 
      optionPanel.setLayout(new GridLayout(3,1))
      
      //Create the player# drop down box
      players  = {1, 2}; 
      playerBox = new JComboBox(players); 
      
      //Create the name box 
      p1nLabe1 = ("Player 1 Name:");  
      p1n = newJTextField("Enter Name Here"); 

      
      
      

  
  
   public static void main(String[] args)
   {
      new Options();   
   }
}    
