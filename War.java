
/**
   This class defines the  game play for the war game
*/


public class War 
{

   private int numPlayers = 1; 
   private Deck dealer, d1, d2; 
 
   public War()
   {
      //Create the decks
      dealer = new Deck(); 
      d1 = new Deck();
      d2 = new Deck(); 
      
      //start with an empty card at the 2 of clubs
      Card c = new Card(); 
      int s = c.CLUB;
      int r = c.MIN_RANK;
      
      //Add the cards to the dealer's pile
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
       
      
      //shuffle the dealer's deck
      dealer.shuffle();
      
      //deal the piles
      deal();
      
      //Opening preferences
      
      //Open game board
      GameBoard aGame = new GameBoard();
      
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
   
   public static void main(String[] args)
   {
       War playWar = new War(); 
   }

      

      
}
   
   
   