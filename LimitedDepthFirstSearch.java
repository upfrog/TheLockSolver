import java.util.concurrent.TimeUnit;
import java.io.*;
import java.util.*;

public class LimitedDepthFirstSearch
{
    public static long[] limitedDepthFirst(TheLock lock, int depthLimit)
    {

        long start = System.nanoTime();
        Stack DS = new Stack();
        int nodesVisited = 0;
        long[] data = new long[4]; //4th position is a flag for finding the correct lock
        
        //pushes an initial set of nodes onto the stack, and assigns them depths of 1.
        for (int i = 4; i > 0; i--)
        {
            DS.push(i);
            DS.topNode.depth = 1;
        }
        
        /**
        The core loop. I'mma be straight, this isn't very well put together. Some things to note:
        The null check on current is generally what catches when the depth has been reached; depth is
        limited through the creation of new nodes more than anything else.
        **/
        while (!lock.isUnlocked())
        {
            DLNode current = DS.pop();
            
           // System.out.println("Nodes visited: " +data[0]);
            if (current == null)
                return data;
            data[0]++;
            
            tryUnlock(current, lock);
            if (lock.isUnlocked())
            {   
                data[1] = DS.size();
                System.out.println(genAnswerString(current));
                
                long end = System.nanoTime();
                long diff = end - start;
                data[2] = TimeUnit.NANOSECONDS.toMillis(diff);  
                data[3] = 1;
                return data;
            }
               
            else if (current.depth < depthLimit)
            {   
                for (int i = 4; i > 0; i--)
                {
                    DS.push(i);
                    DS.topNode.parentNode = current;
                    DS.topNode.depth = DS.topNode.parentNode.depth + 1;
                }
            }
        }
        //This statement isn't reached in normal use
        return data;
    }

    public static String genAnswerString(DLNode curr)
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


    public static String tryUnlock(DLNode attempt, TheLock lock)
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