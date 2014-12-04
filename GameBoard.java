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
   private War game; 
   private Card wPlay, ePlay; 
  
   
   //for the north panel
      
      private JTextField p1n, p2n; //read onlytextfields for names of player
      private JLabel cardMessage1,cardMessage2; 
      private JTextField eastCard, westCard; //number of cards in deck
      
   //for south panel
      private JButton help, about; //two info buttons 
   
   //for east panel
      private ImageIcon bE, ipE; 
      private JLabel backE, inPlayE;
      
      
   //for west panel
      private ImageIcon bW, ipW; 
      private JLabel backW, inPlayW;
   
   //for center panel
      private JButton battle, warTime, startGame, battleAgain; 
      private JPanel battleP; 
      private boolean clicked; 
      private JTextField wWin, eWin, over; 
      private int winner; 


   /**Constructor creates a new Fram and panels in all 5 directions. 
   Also starts a new 
   instance of the war class.*/
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
      
      startGame(); 
  
      pack(); 
      setVisible(true); //display the window
      
   }
   
   /**Starts a new game of war*/
   public void startGame()
   {
      game = new War(); 
   } 
    
   /**builds the north panel*/
   private void NorthBuilder()
   {     
         north = new JPanel(); 
         
        
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
        
         cardMessage2 = new JLabel("Cards:");
                 
         //group components
         JPanel northWest = new JPanel();
         JPanel northEast = new JPanel(); 
         
         northWest.setLayout(new GridLayout(2,2)); 
         northEast.setLayout(new GridLayout(2,2)); 
               
         northWest.add(new JLabel(""));
         northWest.add(p1n);
         northWest.add(cardMessage1);
         northWest.add(westCard);
               
         northEast.add(new JLabel(""));
         northEast.add(p2n);
         northEast.add(cardMessage2); 
         northEast.add(eastCard); 
        
                 //Add to the north panel
         north.add(northWest);
         north.add(northEast);
    }
    
     
      /**addCardEast method substracts a card from the westcard number
      and adds one to the eastcard number*/
      public void addCardEast()
      {
         int newScoreE = Integer.parseInt(eastCard.getText()) + 1;
         eastCard.setText(Integer.toString(newScoreE));
         
         int newScoreW = Integer.parseInt(westCard.getText()) - 1; 
         westCard.setText(Integer.toString(newScoreW)); 
      }
       
       /**addCardWest method substracts a card from the eastcard number
      and adds one to the west number*/
      public void addCardWest()
      {
         int newScoreE = Integer.parseInt(eastCard.getText()) - 1;
         eastCard.setText(Integer.toString(newScoreE));
         
         int newScoreW = Integer.parseInt(westCard.getText()) + 1; 
         westCard.setText(Integer.toString(newScoreW)); 
      }

      
          
      /**SouthBuilder builds the south panel*/
      public void SouthBuilder()
      {
         south = new JPanel(); 
      
         //Create buttons.
                 help = new JButton("Help");
         about = new JButton("About"); 
      
         //add action listeners to buttons 
       ; 
         help.addActionListener(new helpListener()); 
         about.addActionListener(new aboutListener()); 
      
         //add buttons to panel
         south.add(help);
         south.add(about); 
      }
      
      /**helpListener is an action handler for the help button
      it displays instructions*/
      private class helpListener implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            JOptionPane.showMessageDialog(null, "To play, click the Battle button. "  +
                                    "This will play the top card of both decks.\n" +
                                    "Whoever has the higher ranking card wins and adds both carda" +
                                    "To the bottom of their pile. \n\n" +
                                    "If the cards are equal, a war is started! \n" +
                                    "Cards are flipped until one wins,"+
                                    "and the winner takes all the cards in the war. \n\n " +
                                    "Good Luck!"); 
         }
      }
      /**aboutListener is an action handler for the about button
      it displays information about the program and is mostly 
      just there to take up space*/ 
      private class aboutListener implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            JOptionPane.showMessageDialog(null, "Developed 2014 by Hannah Poulette.\n" +
                                          "CS 110: JavaScript.\n" +
                                          "Professor: Jackie Horton"); 
         }
      }
   
      /**EastBuilder builds the east panel*/ 
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
       
       
       /**setEast accepts a card as an argument 
      and sets the image in it's panel
      to the image of that card
      @param c the card*/
      public void setEast(Card c)
      {
         String fileName = c.getFileName(); 
         ImageIcon icon = new ImageIcon(fileName);
         inPlayE.setIcon(icon);
      }
            
      /**WestBuilder builds the west Panel*/
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
       
       
      /**setWest accepts a card as an argument 
      and sets the image in it's panel
      to the image of that card
      @param c the card*/
      public void setWest(Card c)
      { 
         String fileName = c.getFileName(); 
         ImageIcon icon = new ImageIcon(fileName);
         inPlayW.setIcon(icon);
      }
      
  
      /**Center Builder creates the center panel*/
      private void CenterBuilder()
      {
         center = new JPanel(); 
         
         startGame = new JButton("Begin Game"); 
         startGame.addActionListener(new startListener()); 
         
         battle = new JButton("Battle");
         battle.setVisible(false); 
         battle.addActionListener(new battleListener()); 
         
         battleAgain = new JButton("Try Again");
         battleAgain.setVisible(false); 
         battleAgain.addActionListener(new againListener()); 
        
         warTime = new JButton("War!");
         warTime.setVisible(false); 
         warTime.addActionListener(new warListener()); 
         
         over = new JTextField("Game Over"); 
         over.setVisible(false); 
         
         wWin = new JTextField(p1n.getText() + " Wins this round!");
         wWin.setVisible(false);
        
         eWin = new JTextField(p2n.getText() + " Wins this round!");
         eWin.setVisible(false); 
            
         battleP = new JPanel();
         battleP.setLayout(new GridLayout(7,1)); 
         battleP.add(startGame); 
         battleP.add(battle); 
         battleP.add(battleAgain); 
         battleP.add(warTime); 
         battleP.add(eWin);
         battleP.add(wWin); 

         center.add(battleP);
      }
      
      /**The startListener class is an event handler for the startGame button*/
      private class startListener implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            battle.setVisible(true);
            startGame.setVisible(false);
            
         }
      }
      /**The battlListener class is an event handler for the battle button*/
      private class battleListener implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            battle.setVisible(false);
            
            if(game.hasAnyoneLost() == true)
            {
               over.setVisible(true);
            }
               
            
            if(game.hasAnyoneLost() != true)
            { 
            wPlay = game.getTopCard(1);
            ePlay = game.getTopCard(2); 
            setEast(ePlay);
            setWest(wPlay); 
  
            if(wPlay.getRank() > ePlay.getRank())
            {
               displayWinner(1); 
               battleAgain.setVisible(true); 
               game.pushCards(wPlay, ePlay, 1); 
               addCardWest(); 
            }
            else if (wPlay.getRank() < ePlay.getRank())
            {
               displayWinner(2); 
               battleAgain.setVisible(true); 
               game.pushCards(wPlay, ePlay, 2); 
               addCardEast();
            }
               
            else if (wPlay.getRank() == ePlay.getRank())
            {
                warTime.setVisible(true);
                game.pushCards(wPlay, ePlay); 
            }
            }
               
            
         }
      }
      /**The againListener class is an event handler for the battleAgain button*/
      private class againListener implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
         
            hideWinner();
            battle.setVisible(true); 
            battleAgain.setVisible(false); 
             
            
         }
      }

      /**The warListener class is an event handler for the war button*/
      private class warListener implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            warTime.setVisible(false); 
            
            wPlay = game.getTopCard(1);
            ePlay = game.getTopCard(2); 
            setEast(ePlay);
            setWest(wPlay);
            
             if(wPlay.getRank() > ePlay.getRank())
            {
               displayWinner(1); 
               battleAgain.setVisible(true); 
               game.pushCards(wPlay, ePlay, 1); 
               addCardWest();
               game.pushCards(1);
               for (int i = 0; i < game.pileSize(); i++)
                  addCardWest();
                  
            }
            else if (wPlay.getRank() < ePlay.getRank())
            {
               displayWinner(2); 
               battleAgain.setVisible(true); 
               game.pushCards(wPlay, ePlay, 2); 
               addCardEast();
               game.pushCards(2);
               for (int i = 0; i < game.pileSize(); i++)
                  addCardEast();
 
            }
               
            else if (wPlay.getRank() == ePlay.getRank())
            {
                warTime.setVisible(true);
                game.pushCards(wPlay, ePlay); 
            }

            
             
         }
      }
  
   
      /**hudeWar makes war button invisible*/
      public void hideWar()
      {
         warTime.setVisible(false);
      }
      
      /**displayWinner makes the winner label visible
      depending on the argument specifier
      @param i the winner specificer*/
      public void displayWinner(int i)
      {
         if(i == 1)
         {
            wWin.setVisible(true); 
         }
            
         if(i == 2)
         {
            eWin.setVisible(true);
         }
      }
      
      /**hideWinner makes both winner labels invisible*/
      public void hideWinner()
      {
         wWin.setVisible(false);
         eWin.setVisible(false); 
      }
      
     
                             
      
   /**Main creates instance of game board*/
   public static void main(String[] args)
   {
      GameBoard aGame = new GameBoard(); 
      
   }
}    
         
   
     
   
      
      
      