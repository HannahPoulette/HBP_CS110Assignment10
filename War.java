
/**
   This class defines the  game play for the war game
*/

public class War 
{
   public static final int P1 = 1;
   public static final int P2 = 2; 
   private int numPlayers = 1; 
   private Deck dealer, dw, de; 
   private Deck warPile;
   private GameBoard board;
   private boolean gameOver;   
 
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
      
   }
   
   public Card getTopCard(int i)
   {
      Card thisCard = null; 
      if( i == P1)
      {
          thisCard = dw.dequeue();
      }
      if(i == P2)
      {
         thisCard = de.dequeue();
      }
      
      return thisCard; 
    }
    
    public void pushCards(Card c, Card d, int i)
    {
      if( i == P1)
      {
         dw.enqueue(d);
         dw.enqueue(c);
      }
      else if (i == P2)
      {
         de.enqueue(d);
         de.enqueue(c); 
      }
   }
   
   public void pushCards(Card c, Card d)
   {
      warPile.enqueue(c);
      warPile.enqueue(d); 
   }
   
   public void pushCards(int j)
   {
      for( int i = 0; i < warPile.getSize(); i++)
      {
         Card addMe = warPile.dequeue(); 
         
         if(j == P1)
            dw.enqueue(addMe);
         if(j == P2)
            de.enqueue(addMe); 
            
      }
   }
   
   public boolean hasAnyoneLost()
   {
      gameOver = false;
      if(dw.isEmpty() || de.isEmpty())
         gameOver = true;
      
      return gameOver;
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
    

      
}
   
   
   