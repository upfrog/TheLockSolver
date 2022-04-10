import java.util.concurrent.TimeUnit;


public class Driver
{
    public static void main(String[] args)
    {
        final int MAXDEPTH = 9;
        final String SEPERATOR = "\n===========================================\n";
        
        /**
        Each of these loops consists of printing some blank space, some identifying information,
        and then repeating a test run.
        **/

        System.out.println("Limited depth-first: ");
        for (int trial = 1; trial <= MAXDEPTH; trial++)
        {
            System.out.println();
            System.out.println("For a lock of length " + trial);
            testDepth(new TheLock("Stephen Rout" + trial, trial), trial);
        }
        
        System.out.println(SEPERATOR);
        System.out.println("Iterative limited depth-first: ");
        for (int trial = 1; trial <= MAXDEPTH; trial++)
        {
            System.out.println();
            System.out.println("For a lock of length " + trial);
            testItDepth(new TheLock("Stephen Rout" + trial, trial));
        }
        
        System.out.println(SEPERATOR);
        System.out.println("Breadth first:");
        //NOTE: This does not complete if MAXDEPTH is greater than 13 due to a heap overflow.
        for (int trial = 1; trial <= MAXDEPTH; trial++)
        {
            System.out.println();
            System.out.println("For a lock of length " + trial);
            testBreadth(new TheLock("Stephen Rout" + trial, trial));
        }

        System.out.println(SEPERATOR);
        System.out.println("Iterative deepening, of unknown size: ");  
        //I know this way of handling iterative depth is hackish. Oh well, it's what I've got right now.
        testItDepth(new TheLock("Stephen Rout"+MAXDEPTH));

        System.out.println(SEPERATOR);
        //NOTE: This may not complete due to heap overflow.
        System.out.println("Breadth first, of unknown size: ");  
        testBreadth(new TheLock("Stephen Rout")); 
        
        
        System.out.println("All tests done!");
    }
    
    /**
    These are the methods that handle timing and information printing for the various tests.
    **/
    public static void testBreadth(TheLock lock)
    {
        long start = System.nanoTime();
        long nodesVisited;
        System.out.println("Unlock pattern: " + BreadthFirstSearch.breadthFirst(lock));
        
        long end = System.nanoTime();
        long diff = end - start;
        System.out.println("Runtime (milliseconds): " + TimeUnit.NANOSECONDS.toMillis(diff));   
    }
    
    
    public static void testDepth(TheLock lock, int maxDepth)
    {
        long start = System.nanoTime();
        long nodesVisited;

        long[] dataRecord = new long[3];
        dataRecord = LimitedDepthFirstSearch.limitedDepthFirst(lock, maxDepth);
        
   
        System.out.println("Nodes visited: " + dataRecord[0]);
        System.out.println("Size of Stack: " + dataRecord[1]);

        long end = System.nanoTime();
        long diff = end - start;
        System.out.println("Runtime (milliseconds): " + TimeUnit.NANOSECONDS.toMillis(diff));  
    }

    
    public static void testItDepth(TheLock lock)
    {
        long start = System.nanoTime();
        long nodesVisited;
        
        long[] dataRecord = new long[3];
        dataRecord = IDLSearch.iterativeDepthSearch(lock);
        
        long end = System.nanoTime();
        long diff = end - start;
        System.out.println("Runtime (milliseconds): " + TimeUnit.NANOSECONDS.toMillis(diff));       
    }
}