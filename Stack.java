/**
A DLNode stack, with standard features like push(), pop(), isEmpty(), and size(). Also contains non-destructive top() method.
**/

public class Stack
{ 
   protected DLNode topNode = null; 
   protected int numElements;  
   
   public Stack()
   {}
   
   //note that ints are pushed to the stack
   public void push(int val)
   {
      DLNode newNode = new DLNode(val); 
      newNode.nextNode = topNode;
      topNode = newNode;
      numElements++;
   }


   public DLNode top() throws StackUnderflowException
   {
      if (isEmpty())
      {
         throw new StackUnderflowException("Stack underflow!");
      }
         
	   return topNode;
   }
   

   public DLNode pop()
   {
      if (isEmpty())
      {
         return null;
      }
      
      numElements--;
      DLNode temp = topNode;
      topNode = topNode.nextNode;
      return temp; 
      
   }
   
   
   public boolean isEmpty()
   {
       return (topNode == null);
   }
   
   
   public int size()
   {
        return numElements;
   }
}
