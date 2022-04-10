public class IDLSearch extends LimitedDepthFirstSearch
{
    /**
    Repeats the depth-limited search until the program returns that it has found the correct combination.
    **/
    public static long[] iterativeDepthSearch(TheLock lock)
    {
        /**
        This array is used to directly track various performance facts. It was added to an attempt to chase down the measurement
        issues I was having with this algorithm, but in the end it seems to be the best way to move data around.
        **/
        long[] dataRecord = new long[3];
        long[] output = new long[4]; // the 4th position is a sentry for finding the correct combo.
        int i = 1;
        while (output[3] != 1)
        {            
            output = limitedDepthFirst(lock, i);
            
            //adds data from the last iteration to the running total.
            for (int j = 0; j < 3; j++)
            {
                dataRecord[j] = dataRecord[j] + output[j];
            }

            i++;
        }
        
        System.out.println("Nodes visited: " + dataRecord[0]);
        System.out.println("Size of Stack: " + dataRecord[1]);
        
        return dataRecord;
    }

}