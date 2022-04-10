public class BreadthFirstSearch
{
    public static String breadthFirst(TheLock lock)
    {
        int nodesVisited = 0;
        Queue BQ = new Queue(); //breadth queue

        //pushing some initial values on.
        for (int i = 1; i < 5; i++)
        {
            BQ.push(i);
        }
        
        while (!BQ.isEmpty() && !lock.isUnlocked())
        {
            //gets the next node to examine, and checks to see if it represents 
            //the correct sequence of actions.
            Node current = BQ.pop();
            nodesVisited++;
            tryUnlock(current, lock);
            
            /**
            Having applied the action the lock, there are two opportunities: Either
            the lock is open, in which case we can return our answer, or it is shut,
            in which case we add the current node's children to the queue, and repeat.
            **/
            if (lock.isUnlocked())
            {
                System.out.println("Nodes visisted: " + nodesVisited);
                System.out.println("Size of Queue:  " + BQ.size());
                return genAnswerString(current);
            }
            else
            {            
                for (int i = 1; i < 5; i++)
                {
                    BQ.push(i);
                    BQ.rearNode.parentNode = current;
                }
            }
        }
        
        
        
        return "";
    }
    
    /**
    Given a node, this method traces back to it's furthest ancestor, and with the help of
    getActionName() in the CommonActions class, it turns these integer-represented actions
    into a string, and then builds that string. This method is only called when a correct
    answer has been confirmed.
    **/
    public static String genAnswerString(Node curr)
    {
        String answer = "";
        String newComponent;
        int size = 0;
        
        while (curr != null)
        {
            newComponent = Helpers.getActionName(curr.action);
            answer = answer + newComponent + "  ";
            curr = curr.parentNode;
            size++;
        }
        
         return "Answer size: " + size + ". Answer sequence: " + answer;

    }

    /**
    Similarly to genAnswerString, this method takes a node, and then traces up to that node's 
    furthest ancestor. It also takes the lock, and passes both of these tryUnlockHelper() in
    CommonActions. Unless the attempt is sucessful, the lock is reset.
    **/
    public static String tryUnlock(Node attempt, TheLock lock)
    {
        while (attempt != null)
        {
           Helpers.tryUnlockHelper(attempt.action, lock);
           attempt = attempt.parentNode;
        }
        
        if ( lock.isUnlocked())
        {
            return "";
        }
        else
        {
            lock.resetLock();
        }
            
        return "";
    }
} 