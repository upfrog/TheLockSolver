/**
This is the node class used for the queue. Unfortunately, using the same nodes for all
my algorithms became impractical.
**/
public class Node
{
    protected int action;
    Node nextNode;
    Node parentNode;
    
    public Node(int val)
    {
        this.action = val;
    }
    
    public Node(){}
}