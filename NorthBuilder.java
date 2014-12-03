import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;  

public class NorthBuilder extends PanelBuild
{
      
      private JTextField win1, win2; //read only textfields that hold #wins
      private JTextField p1n, p2n; //read onlytextfields for names of player
      private JLabel cardMessage1,cardMessage2, winMessage1, winMessage2; 
      private JTextField eastCard, westCard; 
      
      public NorthBuilder()
      {
         super(); 
                  
         buildScore(); 
         buildName();
         buildCount(); 
         
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
         super.add(northWest);
         super.add(northEast);
      
      }
         
      private void buildScore()
      {
                 
         win1 = new JTextField(3);
         win2 = new JTextField(3);

         win1.setEditable(false); 
         win2.setEditable(false); 

         win1.setText("0"); 
         win2.setText("0");
      }
      
      public JTextField addWin(JTextField winner)
      {
        
         int score = 1 + Integer.parseInt(winner.getText());
         String sScore = Integer.toString(score); 
         winner.setText(sScore); 
         return winner; 
      }
      
      public JTextField getWin(int i)
      {
         if (i == 1)
            return win1;
         else if (i == 2)
            return win2;
         else
            throw new IllegalArgumentException("No such player"); 
      }
      
      private void buildName()
      {
         p1n = new JTextField(10);  
         p2n = new JTextField(10); 
     
         p1n.setEditable(false); 
         p2n.setEditable(false); 
         
         p1n.setText("Player 1");   
         p2n.setText("Computer");
      }
      
      public void setName(String name, int i)
      {
         if (i == 1)
            p1n.setText(name);
         else if (i ==2)
            p2n.setText(name); 
         else
            throw new IllegalArgumentException("No such player"); 
      }
      
      private void buildCount()
      {
           
         westCard = new JTextField(3); 
         eastCard = new JTextField(3); 
        
         westCard.setEditable(false); 
         eastCard.setEditable(false); 
        
         westCard.setText("26");
         eastCard.setText("26"); 
      
      }
      
}
       
       
         