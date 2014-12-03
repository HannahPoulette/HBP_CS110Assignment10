//Hannah Poulette
//CS 110
//Assignment 9

public class ListReferenceBased implements ListInterface
{

   private Node head;
   private int numNodes; 
   
  
   /** 
   No-arg constructor creates an empty 
   reference based list, sets head to 
   null and numNodes to zero
   */
   public ListReferenceBased()
   {
      head = null;
      numNodes = 0;
   }
   
   /**
   The isEmpty method retuurns a boolean
   value depending on if the size of 
   the list is zero
   @return boolean for numNodes ==0
   */
   public boolean isEmpty()
   {
      return numNodes == 0;
   }
   
   /** 
   the size method returns the value
   stored in numNodes
   @return numNodes
   */
   public int size()
   {
      return numNodes; 
   }
   
    
   /** the get method accepts an integer 
   as an argument and returns the node 
   object at that position in the list
   Throws an exception if no node of such index exists
   @return thisNode  the node at the specified value
   */
   public Object get(int index) 
                  throws ListIndexOutOfBoundsException
   {
      try
      {
         Node curr = traverse(index); 
         return curr.getItem();
 
      }
     
      catch (IndexOutOfBoundsException e)
      {
       throw new ListIndexOutOfBoundsException(
                "List index out of bounds");
      }           
   }              

   
   /**
   the add method receives an int as
   an arguement and inserts the inputted
   object at that node. If the int is out of
   bounds an exception is thrown
   @param index      the index
   @param item       the inserted object
   */
   public void add(int index, Object item) 
                  throws ListIndexOutOfBoundsException
   {
         try        
         {
            
            //if the index is one, add the item 
            //to the beginning of the list
            if (index == 1)
            {
               Node newNode = new Node(item, head);
               head = newNode; 
            }
     
            //insert at the end if index is at the end
            else if(index > numNodes)
            {
               Node curr = traverse(index-1);
               Node newNode = new Node(item,curr.getNext()); 
               curr.setNext(newNode);              
            }   
            //insert inbetween if the index is somewhere 
            //in the middle
            else if (index > 1 && index <= numNodes)
            {
               Node prev = traverse(index-1);
               Node curr = traverse(index); 
               Node newNode = new Node(item, curr);
               prev.setNext(newNode);
            }
            numNodes++; 
            
         }

         catch (IndexOutOfBoundsException e)
         {
             throw new ListIndexOutOfBoundsException(
                "List index out of bounds");
         }  
      }
    
                       
   
   /**
   the remove method recevies an integer as
   an arguement and removes the node at that
   index. If no node exists at that index, 
   it throws an exception
   @param index      the index
   */
   public void remove(int index) 
                  throws ListIndexOutOfBoundsException
   {
      try 
      {
         //if int = 1, remove the head
         if(index == 1)
         {
            head = head.getNext(); 
         
         }
         //if not, remove the specified node
         else 
         {
            Node curr = traverse(index); //locate the node you want to delete
            Node prev = traverse(index-1); //locate the node before it
            prev.setNext(curr.getNext()); //disconnect the node, stitch the system back togethr
         }
         numNodes = numNodes - 1; 
       }
       
      catch(IndexOutOfBoundsException e)
      {
         throw new ListIndexOutOfBoundsException(
                "List index out of bounds on get");
      }  
   }
      
   /**
   the remove all sets the
   head to null and the numNodes field
   to zero
   */ 
   public void removeAll()
   {
      head = null;
      numNodes = 0;
   }
   
    /**
   the traverse method moves across the 
   list and searches for a node at a 
   given index
   @return curr      the node at the given index
   */
   private Node traverse(int index)
   {
      //start at the head and move to the position at
      //the specified index
      
      int i = 1; 
      Node curr = head; 
      
      while (i < index && i < numNodes)
      {
         curr = curr.getNext(); 
         i++;
      }
       
      return curr; 
   } 


}