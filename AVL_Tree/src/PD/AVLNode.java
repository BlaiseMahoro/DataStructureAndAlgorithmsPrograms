package PD;

class AVLNode
{    
    AVLNode left, right;
    String data;
    int height;
    int key;

    public AVLNode()
    {
        left = null;
        right = null;
        data = null;
        height = 0;
        key = 0;
    }
    public AVLNode(String n, int key)
    {
        left = null;
        right = null;
        data = n;
        height = 0;
       this.key = key;
    }     
}