import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;  

public class SouthBuilder extends PanelBuild
{
   JButton newGame, help, about; 
   
   public SouthBuilder()
   { 
   
      //Create buttons.
      newGame = new JButton("New Game");
      help = new JButton("Help");
      about = new JButton("About"); 
      
      //add action listeners to buttons 
      //newGame.addActionListener(new newGameListener()); 
      help.addActionListener(new helpListener()); 
      about.addActionListener(new aboutListener()); 
      
      //add buttons to panel
      super.add(newGame);
      super.add(help);
      super.add(about); 
      
   }
   
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
// 
// 
   
   
 }
