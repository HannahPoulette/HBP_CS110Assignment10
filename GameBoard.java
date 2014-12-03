import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;  

/**
   This class defines the main game board for the war game
*/


public class GameBoard extends JFrame
{
   final int WINDOW_WIDTH = 1000; //width in pixels
   final int WINDOW_HEIGHT = 600; //length in pixels
   private JPanel north, south, east, west, center; //reference for the panels
   
   public GameBoard()
   {
      setTitle("War"); //set the title
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT); //set size
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //set close function
      setLayout(new BorderLayout()); //set layout manager for content pane
      
      //create and add the panels
      buildNorthPanel();
      add(north, BorderLayout.NORTH); 
      
      buildSouthPanel();
      add(south, BorderLayout.SOUTH);

      buildEastPanel();
      add(east, BorderLayout.EAST);
      
      buildWestPanel();
      add(west, BorderLayout.WEST);
      
      buildCenterPanel();
      add(center, BorderLayout.CENTER); 
  
      
      pack(); 
      setVisible(true); //display the window
      
   }
      
      
   /** builds the north panel */
    
   private void buildNorthPanel()
   {
      //North Panel
       north = new JPanel();
        
      //read only textFields for the scores
      JLabel win1M = new JLabel("Wins:"); 
      JTextField win1 = new JTextField(3);
      win1.setEditable(false); 
      win1.setText("0"); //initialize to zero
     
      JLabel win2M = new JLabel("Wins:"); 
      JTextField win2 = new JTextField(3);
      win2.setEditable(false); 
      win2.setText("0");
      
      //read only textfields for the names
      JTextField p1n = new JTextField(10);
      p1n.setEditable(false); 
      p1n.setText("Player 1");
      
      JTextField p2n = new JTextField(10); 
      p2n.setEditable(false); 
      p2n.setText("Player 2");
      
      //Card # keepers
      JLabel westCardMessage = new JLabel("Cards:"); 
      JTextField westCard = new JTextField(3); 
      westCard.setEditable(false); 
      westCard.setText("26"); 
      
      JLabel eastCardMessage = new JLabel("Cards:"); 
      JTextField eastCard = new JTextField(3); 
      eastCard.setEditable(false); 
      eastCard.setText("26"); 
      
      //group card counters, wins, and name labels
      JPanel northWest = new JPanel();
      JPanel northEast = new JPanel(); 
      northWest.setLayout(new GridLayout(3,2)); 
      northEast.setLayout(new GridLayout(3,2)); 
            
      northWest.add(new JLabel(""));
      northWest.add(p1n);
      northWest.add(westCardMessage);
      northWest.add(westCard);
      northWest.add(win1M);
      northWest.add(win1); 
      
      northEast.add(new JLabel(""));
      northEast.add(p2n);
      northEast.add(eastCardMessage); 
      northEast.add(eastCard); 
      northEast.add(win2M);
      northEast.add(win2); 
      
      //Add to the north panel
      north.add(northWest);
      north.add(northEast);
      
   }
   
      
   private void buildSouthPanel()
   {
       //create panel
       south = new JPanel(); 
       
       //Create buttons.
       JButton newButton = new JButton("New Game");
       JButton helpButton = new JButton("Help");
       JButton aboutButton = new JButton("About"); 
       
       //add buttons to panel
       south.add(newButton);
       south.add(helpButton);
       south.add(aboutButton); 
   }
   
   private void buildEastPanel()
   {
       east = new JPanel();
       
       //create the top deck image
       ImageIcon b = new ImageIcon("back.jpg");
       JLabel back = new JLabel(b); 
       
       //Empty spot where card in play will go
       JLabel inPlay = new JLabel(); 
       
       //Add the labels to the pane
       east.add(inPlay); 
       east.add(back);
       
 
   }
     
   private void buildWestPanel()
   {
       west = new JPanel();
       
       //create the top deck image
       ImageIcon b = new ImageIcon("back.jpg");
       JLabel back = new JLabel(b); 
       
       //Empty spot where card in play will go
       JLabel inPlay = new JLabel(); 
       
       //Add the labels to the pane
       west.add(back);
       west.add(inPlay); 
    
   }
      
   private void buildCenterPanel()
   {
       center = new JPanel();
       
      //Create the play buttoms
      JButton battle = new JButton("Battle");
           
      JButton warTime = new JButton("War!");
      //warTime.setVisible(false); //not visible until a war situation occurs
      
      JPanel battleP = new JPanel();
      battleP.setLayout(new GridLayout(2,1)); 
      battleP.add(battle); 
      battleP.add(warTime); 

      
      //add to panel
      center.add(battleP);
      

   }

   public static void main(String[] args)
   {
      GameBoard aGame = new GameBoard(); 
      
   }
}    
         
   
     
   
      
      
      