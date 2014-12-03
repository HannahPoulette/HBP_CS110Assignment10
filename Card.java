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
   
   /**
   Constructor sets the card to a rank and suit
   @param s    suit int
   @param r    rank int
   */
   
   public Card ()
   {
      suit = 0;
      rank = 0; 
   }
   
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
   
   public Card (Card c)
   {
      suit = c.getSuit();
      rank = c.getRank();
   }
   
   public int getSuit()
   {
      return suit;
   }
   
   public int getRank()
   {
      return rank;
   }
   
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
   
   
   public String getFileName()
   {
      String suitN = null; 
      String rankN, fileName; 
      
      rankN = Integer.toString(rank); 
      
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
            
      fileName = rankN + "of" + suitN + ".jpg"; 
      return fileName; 
   
   }
   
   public Card battle(Card c) 
   {
      if (c.getRank() == rank)
      {
         throw new IllegalArgumentException("Cards should be in war");
      }
      else 
      {
         if(c.getRank() > rank)
            return c; 
         else
            return (new Card(rank, suit));
      }
   }
     
      
            
      
            
}  
      
            
   
      
