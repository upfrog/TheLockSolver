public class Helpers
{
    public static String getActionName(int action)
    {
        if (action == 1)
            return "twist it";
        else if (action == 2)
            return "poke it";
        else if (action == 3)
            return "pull it";
        else
            return "shake it";

    }
    
    public static void tryUnlockHelper(int attempt, TheLock lock)
    {
        if (attempt == 1)
            lock.twistIt();
        else if (attempt == 2)
            lock.pokeIt();
        else if (attempt == 3)
            lock.pullIt();
        else 
            lock.shakeIt();
    }

}