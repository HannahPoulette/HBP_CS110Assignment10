import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;  

public class CenterBuilder extends PanelBuild
{
      private JButton battle, warTime; 
      private JPanel battleP; 
      
      public CenterBuilder()
      {
         super(); 
         
         battle = new JButton("Battle");
         warTime = new JButton("War!");
         warTime.setVisible(false); 
            
         battleP = new JPanel();
         battleP.setLayout(new GridLayout(2,1)); 
         battleP.add(battle); 
         battleP.add(warTime); 

         super.add(battleP);
      }
}