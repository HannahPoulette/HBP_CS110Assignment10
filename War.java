
/**
   This class defines the  game play for the war game
*/


public class War 
{

   private int numPlayers = 1; 
   private Deck dealer, dw, de; 
   private Deck warPile;
   private GameBoard board;  
 
   public War()
   {
      //Create the decks
      dealer = new Deck(); 
      dw = new Deck();
      de = new Deck(); 
      warPile = new Deck(); 
      
            
      fillDeck(); //Add the cards to the dealer's pile    
      dealer.shuffle();//shuffle the dealer's deck
      deal(); //deal the piles
      
      //Opening preferences
      
      board = new GameBoard(); //open game board
      
      //if no one has lost
      while(dw.isEmpty() != true && de.isEmpty() != true)
      {
         if(board.isClicked())
         {
      
            board.hideWinner();
            Card cw = dw.dequeue();
            Card ce = de.dequeue();
        
            //pass them to the gameboard to display the images
            board.setWPicture(cw.getFileName());
            board.setEPicture(ce.getFileName()); 
        
            //compare the cards
         
            //not in war
            if (cw.getRank()!= ce.getRank())
            {
               board.hideWar();
               if (cw.getRank() > ce.getRank())
               {
                  dw.enqueue(cw);
                  dw.enqueue(ce);
                  while(warPile.isEmpty() != true)
                     dw.enqueue(warPile.dequeue()); 
                  board.displayWinner(1);    
                     
                }
               
               else if (cw.getRank() < ce.getRank())
               {
                  de.enqueue(cw);
                  de.enqueue(ce);
                  while(warPile.isEmpty() != true)
                     de.enqueue(warPile.dequeue()); 
                  board.displayWinner(2); 
               }
                 
             }
            //in war
            else if(cw.getRank() == ce.getRank())
            {
               board.viewWar(); 
               warPile.enqueue(cw);
               warPile.enqueue(ce);
            }
            
            board.setClicked(false);
         }
         
         
       }
   }
   
   
   public void fillDeck()
   {
      //start with an empty card at the 2 of clubs
      Card c = new Card(); 
      int s = c.CLUB;
      int r = c.MIN_RANK;

      while (s <= c.SPADE)
      {
         while (r <= c.ACE)
         {
            Card dealing = new Card(s, r); 
            dealer.enqueue(dealing); 
            r++; 
         }
         
         s++; 
         r = c.MIN_RANK; 
      }
   }
       
    
   private void deal()
   { 
      for(int i = 1; i <= dealer.NUM_CARDS; i++)
      {
         dw.enqueue(((Card)dealer.dequeue())); 
         i++;
         de.enqueue(((Card)dealer.dequeue())); 
         i++;
      }
   }
   
   public static void main(String[] args)
   {
       War playWar = new War(); 
   }

      

      
}
   
   
   