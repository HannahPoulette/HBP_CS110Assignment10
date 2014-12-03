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
   
   //for the north panel
      private JTextField win1, win2; //read only textfields that hold #wins
      private JTextField p1n, p2n; //read onlytextfields for names of player
      private JLabel cardMessage1,cardMessage2, winMessage1, winMessage2; //messages for card and win#'s
      private JTextField eastCard, westCard; //number of cards in deck
      
   //for south panel
      private JButton newGame, help, about; //two info buttons and a restart button
   
   //for east panel
      private ImageIcon bE, ipE; 
      private JLabel backE, inPlayE;
      
   //for west panel
      private ImageIcon bW, ipW; 
      private JLabel backW, inPlayW;

   //for center panel
      private JButton battle, warTime; 
      private JPanel battleP; 
      private boolean clicked; 
      private JTextField wWin, eWin; 


   
   public GameBoard()
   {
      setTitle("War"); //set the title
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT); //set size
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //set close function
      setLayout(new BorderLayout()); //set layout manager for content pane
      
      //create and add the panels
      NorthBuilder();  
      add(north, BorderLayout.NORTH); 
      
      SouthBuilder();
      add(south, BorderLayout.SOUTH);
      
      EastBuilder();
      add(east, BorderLayout.EAST);

      WestBuilder(); 
      add(west, BorderLayout.WEST);
 
      CenterBuilder();
      add(center, BorderLayout.CENTER); 
  
      pack(); 
      setVisible(true); //display the window
      
   }
   
   
   private void NorthBuilder()
   {     
         north = new JPanel(); 
         
         //number of wins
         win1 = new JTextField(3);
         win2 = new JTextField(3);

         win1.setEditable(false); 
         win2.setEditable(false); 

         win1.setText("0"); 
         win2.setText("0");
 
         //name boxes
         p1n = new JTextField(10);  
         p2n = new JTextField(10); 
     
         p1n.setEditable(false); 
         p2n.setEditable(false); 
         
         p1n.setText("Player 1");   
         p2n.setText("Computer");
 
     
         //display of number of cards in deck 
         westCard = new JTextField(3); 
         eastCard = new JTextField(3); 
        
         westCard.setEditable(false); 
         eastCard.setEditable(false); 
        
         westCard.setText("26");
         eastCard.setText("26"); 
        
         //Messages
         cardMessage1 = new JLabel("Cards:");
         winMessage1 = new JLabel("Wins:"); 
         cardMessage2 = new JLabel("Cards:");
         winMessage2 = new JLabel("Wins:"); 
         
         //group components
         JPanel northWest = new JPanel();
         JPanel northEast = new JPanel(); 
         
         northWest.setLayout(new GridLayout(3,2)); 
         northEast.setLayout(new GridLayout(3,2)); 
               
         northWest.add(new JLabel(""));
         northWest.add(p1n);
         northWest.add(cardMessage1);
         northWest.add(westCard);
         northWest.add(winMessage1);
         northWest.add(win1); 
      
         northEast.add(new JLabel(""));
         northEast.add(p2n);
         northEast.add(cardMessage2); 
         northEast.add(eastCard); 
         northEast.add(winMessage2);
         northEast.add(win2); 
      
         //Add to the north panel
         north.add(northWest);
         north.add(northEast);
    }
    
      //North Methods
      public void setName(String name, int i)
      {
         if (i == 1)
            p1n.setText(name);
         else if (i ==2)
            p2n.setText(name); 
         else
            throw new IllegalArgumentException("No such player"); 
      }
      
      
      
      public JTextField addWin(JTextField winner)
      {
        
         int score = 1 + Integer.parseInt(winner.getText());
         String sScore = Integer.toString(score); 
         winner.setText(sScore); 
         return winner; 
      }
      
      //southBuilder
      public void SouthBuilder()
      {
         south = new JPanel(); 
      
         //Create buttons.
         newGame = new JButton("New Game");
         help = new JButton("Help");
         about = new JButton("About"); 
      
         //add action listeners to buttons 
         //newGame.addActionListener(new newGameListener()); 
         help.addActionListener(new helpListener()); 
         about.addActionListener(new aboutListener()); 
      
         //add buttons to panel
         south.add(newGame);
         south.add(help);
         south.add(about); 
      }
      
      //south actionListeners
      private class helpListener implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            JOptionPane.showMessageDialog(null, "To play, click the Battle button."  +
                                    "This will play the top card of both decks\n." +
                                    "Whoever has the higher ranking card wins and adds both carda" +
                                    "To the bottom of their pile. \n\n" +
                                    "If the cards are equal, a war is started! \n" +
                                    "Cards are flipped until one wins,"+
                                    "and the winner takes all the cards in the war. \n\n " +
                                    "Good Luck!"); 
         }
      }
   
      private class aboutListener implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            JOptionPane.showMessageDialog(null, "Developed 2014 by Hannah Poulette.\n" +
                                          "CS 110: JavaScript.\n" +
                                          "Professor: Jackie Horton"); 
         }
      }
   
   
  //  private class newGameListener implements ActionListener
//    {
//       public void actionPerformed(ActionEvent e)
//       {
//       }
//    }
      
      //EastBuilder
      public void EastBuilder()
      {
         east = new JPanel(); 
        
         //create the top deck image
         bE = new ImageIcon("back.jpg");
         ipE = new ImageIcon("EmptyDeck.jpg");
 
         backE = new JLabel(bE); 
         inPlayE = new JLabel(ipE); 
       
         //Add the labels to the pane
         east.add(inPlayE); 
         east.add(backE);
       
       }
       
       
       //East methods
      public void setEPicture(String fileName)
      {
         ImageIcon icon = new ImageIcon(fileName);
         inPlayE.setIcon(icon);
      }
      
      //WestBuilder
      private void WestBuilder()
      {
         west = new JPanel(); 
        
         //create the top deck image
         bW = new ImageIcon("back.jpg");
         ipW = new ImageIcon("EmptyDeck.jpg");
 
         backW = new JLabel(bW); 
         inPlayW = new JLabel(ipW); 
       
         //Add the labels to the pane
         west.add(backW);
         west.add(inPlayW);
       
       }
       
       
       //West methods
      public void setWPicture(String fileName)
      {
         ImageIcon icon = new ImageIcon(fileName);
         inPlayW.setIcon(icon);
      }


      //Center Builder
      private void CenterBuilder()
      {
         center = new JPanel(); 
         
         clicked = false;
                 
         battle = new JButton("Battle");
         battle.addActionListener(new battleListener()); 
        
         warTime = new JButton("War!");
         warTime.setVisible(false); 
         
         wWin = new JTextField(p1n.getText() + "Wins this round!");
         wWin.setVisible(false);
         eWin = new JTextField(p2n.getText() + "Wins this round!");
         eWin.setVisible(false); 
            
         battleP = new JPanel();
         battleP.setLayout(new GridLayout(4,1)); 
         battleP.add(battle); 
         battleP.add(warTime); 
         battleP.add(eWin);
         battleP.add(wWin); 

         center.add(battleP);
      }
      
      //Center action handlers
      private class battleListener implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            setClicked(true);
            
         }
      }
      
      private class warListener implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            setClicked(true); 
         }
      }

      //Center Methods
      public boolean isClicked()
      {
         return clicked;   
      } 
      
       public void setClicked(boolean c)
      {
         clicked = c;
      }
           
      public void viewWar()
      {
         warTime.setVisible(true);
      }
      
      public void hideWar()
      {
         warTime.setVisible(false);
      }
      
      public void displayWinner(int i)
      {
         if(i == 1);
            wWin.setVisible(true); 
         if(i == 2);
            eWin.setVisible(true);
      }
      
      public void hideWinner()
      {
         wWin.setVisible(false);
         eWin.setVisible(false); 
      }
                                
      

   public static void main(String[] args)
   {
      GameBoard aGame = new GameBoard(); 
      
   }
}    
         
   
     
   
      
      
      