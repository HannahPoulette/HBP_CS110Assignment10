import java.util.Random; 

/**The deck class is a queue of cards*/

public class Deck extends QueueReferenceBased
{
   public static final int NUM_CARDS = 52; 
   private int size; //size of the deck
   private int max; //maximum size of deck
   
   /**No arg constructor sets everything to null/zero*/
   public Deck()
   {
      super();
      max = NUM_CARDS; 
      size = 0; 
   }
   
   /**setMac sets integer argument as max
   @param m the max
   */
   
   public void setMax(int m)
   {
      max = m;
   }
   
   /**deck inherits super enqueue method
   and also increments size
   @param c the adding card*/
   public void enqueue(Card c)
   {
         super.enqueue(c); 
         size++;
       
   }
   /**deck inherits peek method, 
   but returns object as a Card
   @param Card
   */
   public Card peek()
   {
      return (((Card)super.peek())); 
   }
   
    /**deck inherits dequeu method, 
   but returns object as a Card
   @param Card
   */
   public Card dequeue()
   {
      return (((Card)super.dequeue())); 
   }
   
   /**getSize returns the integer size value
   @return size
   */
   public int getSize()
   {
      return size;
   }
   
   /**Shuffle method reorders the cards*/
   public void shuffle()
   {
      Card[] shuffling = new Card[size]; 
      Random rand = new Random(); 
      
      //put all cards into an array
      int i = 0; 
      while(i < size)
      {
         shuffling[i] = ((Card)super.dequeue()); 
         i++;
      }
      
      
      
      //shuffle the array
      for(i = 0; i < size-1; i++)
      {
         int r = rand.nextInt(52) + 0;
         Card randomCard = shuffling[r];
         shuffling[r] = shuffling[i];
         shuffling[i] = randomCard; 
      }
      
      //reload shuffled deck
      for(i = 0; i< size-1; i++)
         super.enqueue(shuffling[i]); 
      
   }
   
   
        
}
      
      
   