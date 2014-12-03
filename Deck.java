import java.util.Random; 

public class Deck extends QueueReferenceBased
{
   public static final int NUM_CARDS = 52; 
   private int size; //size of the deck
   private int max; //maximum size of deck
   
   public Deck()
   {
      super();
      max = NUM_CARDS; 
      size = 0; 
   }
   
   public void setMax(int m)
   {
      max = m;
   }
   
   public void enqueue(Card c)
   {
      if (size < max)
      {
         super.enqueue(c); 
         size++;
      }
      else 
      {
         throw new IllegalArgumentException("Deck is Full");
      }
 
   }
   
   public Card peek()
   {
      return (((Card)super.peek())); 
   }
   
   public Card dequeue()
   {
      return (((Card)super.dequeue())); 
   }
      
   public void shuffle()
   {
      Card[] shuffling = new Card[size-1]; 
      Random rand = new Random(); 
      
      for(int i = 0; i < size; i++)
      {
         shuffling[i] = ((Card)super.dequeue()); 
      }
      
      
      for(int i = 0; i < size; i++)
      {
         int r = rand.nextInt(53) + 1;
         Card randomCard = shuffling[r];
         shuffling[r] = shuffling[i];
         shuffling[i] = randomCard; 
      }
 
      
   }
   
   
        
}
      
      
   