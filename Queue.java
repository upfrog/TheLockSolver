/**
A Node stack, with standard features like push(), pop(), isEmpty(), and size().
**/
public class Queue
{
   protected Node frontNode;
   protected Node rearNode;
   protected int numElements;
   
   
   public Queue()
   {
      frontNode = null;
      rearNode = null;
      numElements = 0;
   }
   

   //note that ints are pushed to the queue, not action strings.
   public void push(int val)
   {
      Node newNode = new Node(val);
      
      if (numElements == 0)
      {
         frontNode = newNode;
         rearNode = newNode;
         numElements++;
      }
      
      else
      {
         rearNode.nextNode = newNode;
         rearNode = newNode;
         numElements++;
      }
   }


   public Node pop() throws QueueUnderflowException
   {
      if (this.numElements == 0)
      {
            throw new QueueUnderflowException("Queue underflow!");
      }   
      
      else if (numElements == 1)
      {
         Node tempNode = frontNode;
         frontNode = null;
         rearNode = null;
         numElements--;
         return tempNode;
      }
      
      else
      {
         Node tempNode = frontNode;
         frontNode = frontNode.nextNode;
         numElements--;
         return tempNode;
      }
       
      
   }    


   public boolean isEmpty()
   {
       return numElements == 0;
   }

    public int size()
    {
        return numElements;
    }


}


