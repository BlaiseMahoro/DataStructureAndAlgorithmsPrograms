package PD;



public class AVLTree
{
    private AVLNode root;     

    public AVLTree()
    {
        root = null;
    }
    public boolean isEmpty()
    {
        return root == null;
    }
    public void makeEmpty()
    {
        root = null;
    }
    
    
    
    
    
    
    
    public void insert(String data, int Key)
    {
        root = insert(data, Key, root);
    }
    private int height(AVLNode t )
    {
        return t == null ? -1 : t.height;
    }
    private int max(int lhs, int rhs)
    {
        return lhs > rhs ? lhs : rhs;
    }
    private AVLNode insert(String x, int y, AVLNode t)
    {
        if (t == null) // If no previous node t becomes root
            t = new AVLNode(x, y);
        else if (y < t.key) // if y less t new node from t left side
        {
            t.left = insert( x, y, t.left );
            if( height( t.left ) - height( t.right ) == 2 ) //balance checking
                if(y < t.left.key)
                    t = rotateWithLeftChild( t );
                else
                    t = doubleWithLeftChild( t ); //left unbalanced right heavy
        }
        else if (y > t.key)
        {
            t.right = insert( x, y, t.right );
            if( height( t.right ) - height( t.left ) == 2 )
                if(y > t.right.key)
                    t = rotateWithRightChild( t );
                else
                    t = doubleWithRightChild( t );
        }
        else
          ; 
        t.height = max( height( t.left ), height( t.right ) ) + 1;
        return t;
    }
    private AVLNode rotateWithLeftChild(AVLNode k2)
    {
        AVLNode k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = max( height( k2.left ), height( k2.right ) ) + 1;
        k1.height = max( height( k1.left ), k2.height ) + 1;
        return k1;
    }

    private AVLNode rotateWithRightChild(AVLNode k1)
    {
        AVLNode k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = max( height( k1.left ), height( k1.right ) ) + 1;
        k2.height = max( height( k2.right ), k1.height ) + 1;
        return k2;
    }

    private AVLNode doubleWithLeftChild(AVLNode k1)
    {
        k1.left = rotateWithRightChild( k1.left ); //balances right heavy subtree
        return rotateWithLeftChild( k1 ); //now rotate left can be performed
    }
     
    private AVLNode doubleWithRightChild(AVLNode k1)
    {
        k1.right = rotateWithLeftChild( k1.right );
        return rotateWithRightChild( k1 );
    }    
    public int countNodes()
    {
        return countNodes(root);
    }
    private int countNodes(AVLNode r)
    {
        if (r == null)
            return 0;
        else
        {
            int x = 1;
            x += countNodes(r.left); // recursive call
            x += countNodes(r.right);
            return x;
        }
    }
    public String search(int key)
    {
        return search(root, key);
    }
    private String search(AVLNode r, int val)
    {
        boolean found = false;
        String returnValue = null;
        while ((r != null) && !found)
        {
            int rval = r.key;

            if (val < rval){
            	r = r.left;
            }
            else if (val > rval){
            	r = r.right;
            }
            else
            {
                found = true;
                returnValue = r.data;
                break;
            }
            returnValue = search(r, val);
        }
        return returnValue;
    }
    public void inorder()
    {
        inorder(root);
    }
    private void inorder(AVLNode r)
    {
        if (r != null)
        {
            inorder(r.left); //recursive calls
            System.out.print(r.data +" ");
            inorder(r.right);
        }
    }
    public void preorder()
    {
        preorder(root);
    }
    private void preorder(AVLNode r)
    {
        if (r != null)
        {
            System.out.print(r.data +" ");
            preorder(r.left);             
            preorder(r.right);
        }
    }
    public void postorder()
    {
        postorder(root);
    }
    private void postorder(AVLNode r)
    {
        if (r != null)
        {
            postorder(r.left);             
            postorder(r.right);
            System.out.print(r.data +" ");
        }
    }     
}