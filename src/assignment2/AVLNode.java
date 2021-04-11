package assignment2;

public class AVLNode
{    
    public AVLNode left, right,parent;
    public int data;
    public int height;

   
    public AVLNode()
    {
        left = null;
        right = null;
        parent = null;
        data = 0;
        height = 0;
    }

    public AVLNode(int n)
    {
        left = null;
        right = null;
        parent = null;
        data = n;
        height = 0;
    }     

}
