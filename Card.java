/**
The Card class reprsents a playing card object 
*/

public class Card
{
   //static parameters for card and suit values
   public static final int ACE = 14; 
   public static final int KING = 13; 
   public static final int QUEEN = 12; 
   public static final int JACK = 11; 
   public static final int MIN_RANK = 2;
   
   public static final int CLUB = 1;
   public static final int DIAMOND = 2;
   public static final int HEART = 3;
   public static final int SPADE = 4; 

   private int suit; //int representing the suit
   private int rank; //int representing the rank
   private String photoFile; //String holding the name of the photofile
   
   /**No arg constructor sets suit and rank to zero*/
   public Card ()
   {
      suit = 0;
      rank = 0; 
   }
   
   /**
   Constructor sets the card to a rank and suit
   @param s    suit int
   @param r    rank int
   */
   
  
   public Card (int s, int r) 
   {
      if (r <= ACE || r >= MIN_RANK)
      {
         rank = r;
      }
      
      else
      {
         throw new IllegalArgumentException("Rank is out of bounds");
      }
      
      if (s <= SPADE || s>= CLUB)
      {
         suit = s;
      }
      else
      {
         throw new IllegalArgumentException("Rank is out of bounds");
      }
      
   }
   
   /**Constructor accepts another card as
   the argument and copies it parameters into
   a new card
   @param c the card
   */
   public Card (Card c)
   {
      suit = c.getSuit();
      rank = c.getRank();
   }
   
   /**getSuit methods returns suit
   @return suit the suit
   */
   public int getSuit()
   {
      return suit;
   }
   
   /**getRank Method returns the rank
   @param rank the rank*/
   public int getRank()
   {
      return rank;
   }
   
   /**set Suit method sets integer argument as suit
   @param s the suit*/
   public void setSuit(int s)
   {
      if (s <= SPADE || s>= CLUB)
         {
            suit = s;
         }
      else
         {
            throw new IllegalArgumentException("Rank is out of bounds");
         }
   }
   
   /**setRank metho sets integer argument as rank
   @param r the rank*/
   public void setRank(int r)
   {
      if (r <= ACE || r >= MIN_RANK)
      {
         rank = r;
      }
      
      else
      {
         throw new IllegalArgumentException("Rank is out of bounds");
      }

   }
   
   /**getFileName returns a string representing the
   fileName which holds a .jpg image of the card
   @return fileName
   */
   public String getFileName()
   {
      String suitN = null; 
      String rankN = null;
      
      
      if (rank <= 10)
         rankN = Integer.toString(rank); 
     else if(rank == JACK)
         rankN = "Jack";
     else if(rank == QUEEN)
         rankN = "Queen";
     else if(rank == KING)
         rankN = "King";
     else if(rank == ACE)
         rankN = "Ace"; 
      
      switch (suit) {
         case 1: 
            suitN = "Clubs"; 
         case 2:
            suitN = "Diamonds";
         case 3: 
            suitN = "Hearts";
         case 4:
            suitN = "Spades"; 
            break;}
            
      String fileName = rankN + "of" + suitN + ".jpg"; 
      return fileName; 
      
      
   
   }
   
            
}  
      
            
   
      
