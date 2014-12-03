import javax.swing.*; 
import java.awt.*; 

/**
   This class defines the main game board for the war game
*/


public class War extends JFrame
{
   final int WINDOW_WIDTH = 1000; //width in pixels
   final int WINDOW_HEIGHT = 600; //length in pixels
   private JPanel north, south, east, west, center; //reference for the panels
   
   public War()
   {
      setTitle("War"); //set the title
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT); //set size
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //set close function
      setLayout(new BorderLayout()); //set layout manager for content pane
      
      //create 5 panels
      buildNorthPanel();
      buildSouthPanel();
      buildEastPanel();
      buildWestPanel();
      buildCenterPanel();
      
      //add panels
      add(north, BorderLayout.NORTH); 
      add(south, BorderLayout.SOUTH);
      add(east, BorderLayout.EAST); 
      add(west, BorderLayout.WEST);
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
            
      northWest.add(p1n);
      northWest.add(new JLabel(""));
      northWest.add(westCardMessage);
      northWest.add(westCard);
      northWest.add(win1M);
      northWest.add(win1); 
      
      northEast.add(p2n);
      northEast.add(new JLabel(""));
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
       south = new JPanel(); 
   }
   
   private void buildEastPanel()
   {
       east = new JPanel();
   }
     
   private void buildWestPanel()
   {
       west = new JPanel();
   }
      
   private void buildCenterPanel()
   {
       center = new JPanel();
   }
      
         
   
   /**
      main method creates an instance 
      of the game board so it is displayed
   */ 
   
   public static void main(String[] args)
   {
      War aGame = new War(); 
   }
   
}
   
      
      
      