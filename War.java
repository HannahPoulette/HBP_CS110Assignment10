
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
   
   /**Consturctor creates 3 decks. 
   It fills the master deck with the fill deck method,
   shuffles it and then deals*/ 
   
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
   
   /**getTopCard returns the top card of
   either deck. The argument determine the deck
   it it pulled from
   @param i the deck specifier
   @return thisCard
   */
   
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
    
    /**pileSize method returns the size of the warPile
    @return int the pile size*/
    public int pileSize()
    {
      return warPile.getSize();
    }
    
    /**pushCards puts two cards into
    the deck specified by the arguement
    @param c a card
    @param d a card
    @param i the deck specificer
    */
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
   
   /**pushCards is overloead to add cards
   to the warpile
   @param c, d the cards*/
   public void pushCards(Card c, Card d)
   {
      warPile.enqueue(c);
      warPile.enqueue(d); 
   }
   
   /**pushcards is overloaded to add
   the cards in the warPile to a deck
   specified by the arugement
   @param j the deck specifier*/
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
   
   /**hasAnyoneLost returns a boolean 
   representng if either deck is empty
   @boolean gameOver    is the game is over
   */
   public boolean hasAnyoneLost()
   {
      gameOver = false;
      if(dw.isEmpty() || de.isEmpty())
         gameOver = true;
      
      return gameOver;
   }
      
  
   /**fillDeck adds every card to the dealer's deck*/
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
       
   /**deal sorts the cards into two decks*/
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
   
   
   