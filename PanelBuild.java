import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;  

public class PanelBuild
{
   private JPanel panel;
   
   public PanelBuild()
   {
     panel = new JPanel(); 
   }
   
   public void add(Component c)
   {
      panel.add(c); 
   }
   
   public JPanel getPanel()
   {
      return panel; 
   }
}

