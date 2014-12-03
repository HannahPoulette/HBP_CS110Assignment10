import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;  

public class WestBuilder extends PanelBuild
{
   private ImageIcon b, ip; 
   private JLabel back, inPlay; 
   
   public WestBuilder()
   {
       super(); 
       
       //create the top deck image
       b = new ImageIcon("back.jpg");
       ip = new ImageIcon("EmptyDeck.jpg");

       back = new JLabel(b);
       inPlay = new JLabel(ip); 
       
       //Add the labels to the pane
       super.add(back); 
       super.add(inPlay);
       
   }
         
      
}
