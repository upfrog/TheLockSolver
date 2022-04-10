/**
This is the node class used by my stack, and therefor, the limited and iterated depth 
algorithms. It is seperate from the more vanilla Node class by having it's own internal
record of depth. Given the resource-intensive nature of this project, I did not want 
nodes to have unnecesary variable decelarations.
**/
public class DLNode
{
    protected int depth;
    DLNode nextNode;
    DLNode parentNode;
    int action;
    
    public DLNode(int val)
    {
        this.action = val;
    }
    
    public DLNode(){}
}