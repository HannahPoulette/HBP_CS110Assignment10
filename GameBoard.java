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
      NorthBuilder nBuild = new NorthBuilder();
      north = nBuild.getPanel(); 
      add(north, BorderLayout.NORTH); 
      
      SouthBuilder sBuild = new SouthBuilder();
      south = sBuild.getPanel();
      add(south, BorderLayout.SOUTH);
      
      EastBuilder eBuild = new EastBuilder();
      east = eBuild.getPanel();
      add(east, BorderLayout.EAST);

      WestBuilder wBuild = new WestBuilder();
      west = wBuild.getPanel(); 
      add(west, BorderLayout.WEST);
    
       
      CenterBuilder cBuild = new CenterBuilder();
      center = cBuild.getPanel();
      add(center, BorderLayout.CENTER); 
  
      pack(); 
      setVisible(true); //display the window
      
   }
      

   public static void main(String[] args)
   {
      GameBoard aGame = new GameBoard(); 
      
   }
}    
         
   
     
   
      
      
      