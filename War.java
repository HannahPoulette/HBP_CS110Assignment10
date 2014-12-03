
/**
   This class defines the  game play for the war game
*/


public class War 
{

   private int numPlayers = 1; 
   private Deck dealer; 
   private Deck d1; 
   private Deck d2; 
   
   public War()
   {
      //start with an empty card at the 2 of clubs
      Card c = new Card(); 
      int s = c.CLUB;
      int r = c.MIN_RANK;
      
      //Add the cards to the dealer's pile
      while (s <= c.SPADE)
      {
         c.setSuit(s); 
      
         while (r <= c.ACE)
         {
            c.setRank(r);
            dealer.enqueue(c); 
            r++; 
         }
         
         s++; 
      }
      
      //shuffle the dealer's deck
      dealer.shuffle();
      
      //deal the piles
      deal();
      
   }
   
   private void deal()
   { 
      for(int i = 1; i <= dealer.NUM_CARDS; i++)
      {
         d1.enqueue(((Card)dealer.dequeue())); 
         i++;
         d2.enqueue(((Card)dealer.dequeue())); 
         i++;
      }
   }
      

      
}
   
   
   