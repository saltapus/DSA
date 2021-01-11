/****************************
 * Program: BinaraySearchTree *
 * Author: Anthony Cameron  *
 * Date Created: 05/04/2019 *
 ****************************/
import java.util.*;
import java.io.*;
import java.lang.Math;



public class BinarySearchTree implements Serializable  
{
    /**************************************************
    * Obtained from Anthony C
    * used in practical
    * 17/05/2019
    * *************************************************/
    private class TreeNode implements Serializable  
    {
        private String key;
        private Object value;
        private TreeNode left_child;
        private TreeNode right_child;
        public TreeNode(String inKey, Object inVal)
        {
            if (inKey == null)
            {
                throw new IllegalArgumentException("Key cannot be null");
            }
            key = inKey;
            value = inVal;
            right_child = null; //null is valid and repesents that no child exists
            left_child = null;
        }
        
        //ACCESSORS
        public String getKey()
        {
            return key;
        }

        public Object getValue()
        {
            return value;
        }

        public TreeNode getLeft()
        {
            return left_child;
        }

        public TreeNode getRight()
        {
            return right_child;
        }
    
        //MUTATORS
        public void setLeft(TreeNode newLeft)
        {
            left_child = newLeft;//Assigns new left as left child
        }

        public void setRight(TreeNode newRight)
        {
            right_child = newRight;
        }
    }

    //CLASSFIELDS
    private TreeNode root;
    private int count;
    private int lCount;
    private int rCount;

    //starts an empty tree
    public BinarySearchTree()
    {
        root = null;
        count = 0;
        lCount = 0;
        rCount = 0;
    }

    public BinarySearchTree(String filename)
    {
        root = null;
        count = 0;
        lCount = 0;
        rCount = 0;
        fileInput(filename);
    }


    private void fileInput(String inFileName)                                   
    {                                                                           
        FileInputStream fileStrm = null;                                        
        InputStreamReader rdr;                                                  
        BufferedReader bufRdr;                                                  
        Scanner sc = new Scanner(System.in);                                    
        String line;                                                            
        try                                                                     
        {                                                                       
            fileStrm = new FileInputStream(inFileName);                         
            rdr = new InputStreamReader(fileStrm);                              
            bufRdr = new BufferedReader(rdr);                                   
                                                                                
            //Input line from the file                                          
            line = bufRdr.readLine();                                           
                                                                                
            while(line != null)                                                 
            {                                                                   
                try                                                             
                {                                                               
                    processStock(line);                                        
                }                                                               
                catch (StringIndexOutOfBoundsException e)                       
                {                                                               
                    System.out.println("Error: String index out of bounds"      
                                       + e.getMessage());                       
                }                                                               
                catch (ArrayIndexOutOfBoundsException e)                        
                {                                                               
                    System.out.println("Error: Array size is full"              
                                        + e.getMessage());                      
                }                                                               
                catch (IllegalArgumentException e)                              
                {                                                               
    //                System.out.println("Illegal argument -fileInput SB: " + e.getMessage());
                }                                                               
                line = bufRdr.readLine();                                       
            }                                                                   
            fileStrm.close();                                                   
            System.out.println("File has been Read");   
        }                        
        catch (IOException e)                                                   
        {                                                                       
            if (fileStrm != null)                                               
            {                                                                   
                try                                                             
                {                                                               
                    fileStrm.close();                                           
                }                                                               
                catch(IOException ex2)                                          
                {                                                               
                }                                                               
            }                                                                   
            System.out.println("Error in file processing: " + e.getMessage());  
        }                                                                       
    }    

    public void processStock(String line)
    {
        String tick;
        int date, vol;
        double open, high, low, close;
        String [] lineArray = line.split(",");
        tick = lineArray[0];
        date = Integer.parseInt(lineArray[1]);                                  
        open = Double.parseDouble(lineArray[2]);                                
        high = Double.parseDouble(lineArray[3]);                                
        low = Double.parseDouble(lineArray[4]);                                 
        close = Double.parseDouble(lineArray[5]);                               
        vol = Integer.parseInt(lineArray[6]);                                
                                                                                
        StocksClass stocks = new StocksClass(tick, date, open, high, low, close, 
                                            vol);                            
        insert(tick, stocks);
    }

 

    //Below are wrapper methods that call a resursion of a private method
    //=======================================================================
    // FIND NODE
    //======================================================================

    public Object find(String key)
    {
        return findRecursive(key, root);
    }

    private Object findRecursive(String key, TreeNode currNode)
    {
        Object val = null;

        if (currNode == null)
        {
            throw new NoSuchElementException("Key " + key + " not fount");//base case not found
        }

        else if (key.equals(currNode.getKey()))//in the tree base is found
        {
            val = currNode.getValue();
        }

        else if (key.compareTo(currNode.getKey()) < 0) //left side is resursed
        {
            val = findRecursive(key, currNode.getLeft());
        }

        else
        {
            val = findRecursive(key, currNode.getRight());//right side is recursed
        }
        return val;
    }

    //=======================================================================
    // INSERT NODE
    //======================================================================

    public void insert(String key, Object value)
    {
        count++;
        root = insertRec(key, value, root);
    }

    private TreeNode insertRec(String key, Object value, TreeNode currNode)
    {
        TreeNode updateNode = currNode;
        if (currNode == null) //base case fouund
        {
            TreeNode newNode = new TreeNode(key, value);//inserts point
            updateNode = newNode;
        }
        else if(key.equals(currNode.getKey()))//in tree
        {
            throw new IllegalArgumentException("invalid: ");
        }
        else if(key.compareTo(currNode.getKey()) < 0)//recurse right and 
        {//update current
            currNode.setLeft(insertRec(key, value, currNode.getLeft()));
            lCount++;
        }
        else//recurses right and updates
        {
            currNode.setRight(insertRec(key, value, currNode.getRight()));
            rCount++;
        }

        return updateNode;
    }

    //=======================================================================

    //======================================================================

    public void delete(String key)
    {
        root = deleteRec(key, root);//sets root to be return node
    }

    private TreeNode deleteRec(String key, TreeNode currNode)
    {
        TreeNode updateNode = currNode;
        if (currNode == null)
        {//checks if base exists
            throw new IllegalArgumentException("Key " + key + " ount");
        }
        else if (key.equals(currNode.getKey()))
        {//finds base
            updateNode = deleteNode(key, currNode);
        }
        else if (key.compareTo(currNode.getKey()) < 0)
        {//resurse left
            currNode.setLeft(deleteRec(key, currNode.getLeft()));
        }
        else
        {//rescurse right
            currNode.setRight(deleteRec(key, currNode.getRight()));
        }
        return updateNode;
    }

    private TreeNode deleteNode(String key, TreeNode delNode)
    {
        TreeNode updateNode = null;
        
        if ((delNode.getLeft() == null) && (delNode.getRight() == null))
        {
            updateNode = null;//sets node null if children don't exist
        }
        else if ((delNode.getLeft() == null) && (delNode.getRight() != null))
        {
            updateNode = delNode.getLeft();//if one child exists on left
        }
        else if ((delNode.getLeft() == null) && (delNode.getRight() != null))
        {
            updateNode = delNode.getRight();//if one child existis on right
        }
        else//for 2 children
        {
            updateNode = promoteSuccessor(delNode.getRight());//promotes next value
            if (updateNode != delNode.getRight())
            {
                updateNode.setRight(delNode.getRight());// for no cycles update right
            }
            updateNode.setLeft(delNode.getLeft());//and left
        }
        return updateNode;
    }

    //METHOD PROMOTES LEFT MOST CHILD OF RIGHT TREE
    private TreeNode promoteSuccessor(TreeNode currNode)
    {
        TreeNode successor = currNode;//sets current nod to be successor
        
        if (currNode.getLeft() != null)
        {
            successor = promoteSuccessor(currNode.getLeft());
            if (successor == currNode.getLeft())//parent of successor needs to 
            {//adopt right child
                currNode.setLeft(successor.getRight());
            }
        }
        return successor;
    }
    
    //=======================================================================
    // HEIGHT NODE
    //======================================================================

    public int height()
    {
        return heightRec(root, 0);
    }
        
    private int heightRec (TreeNode startNode, int htSoFar)
    {
        int leftHt, rightHt;

        if (startNode == null)
        {
            htSoFar = -1;//no more base cases on this branch
        }
        else
        {//calc left and right methods
            leftHt = heightRec(startNode.getLeft(), htSoFar + 1);
            rightHt = heightRec(startNode.getRight(), htSoFar +1);
            
            //gets highest number of left vs right branches
            if (leftHt > rightHt)
            {
                htSoFar = leftHt + 1;
            }
            else
            {
                htSoFar = rightHt + 1;
            }
        }
        return htSoFar;
    }
    
    public int size()
    {
        return count;
    }

    //=======================================================================
    // TRAVERSETREE
    //======================================================================

    //PREORDER
    
    public void preOrder()
    {
        DSAQueue queue = new DSAQueue(count);
        //return 
        recPreOrder(root, queue);   
    } 

    private DSAQueue recPreOrder(TreeNode currNode, DSAQueue queue)
    {
        if (currNode != null)
        {
            System.out.print(currNode.getValue() +" \n");
            queue.enqueue(currNode.getValue());//visits current node
            recPreOrder(currNode.getLeft(), queue);//recurse left and right
            recPreOrder(currNode.getRight(), queue);
        }
        return queue;
    }
    
    //POSTORDER
    public void postOrder()
    {
        DSAQueue queue = new DSAQueue(count);
        //return 
        recPostOrder(root, queue);    
    }

    private DSAQueue recPostOrder(TreeNode currNode, DSAQueue queue)
    {
        if (currNode != null)
        {
            recPostOrder(currNode.getLeft(), queue);//recurse left and right first
            recPostOrder(currNode.getRight(), queue);
            queue.enqueue(currNode.getValue());//visits current node
            System.out.print(currNode.getValue() +" \n");
           // queue.enqueue(currNode.getKey());//visits current node last
        }
        return queue;
    }
    
    //INORDER
    public void inOrder()
    {
        DSAQueue queue = new DSAQueue(count);
        //return 
        recInOrder(root, queue);    
    }

    private DSAQueue recInOrder(TreeNode currNode, DSAQueue queue)
    {
        if (currNode != null)
        {

            recInOrder(currNode.getLeft(), queue);//recurse the find current and recurse other side
            queue.enqueue(currNode.getValue());//visits current node
            //queue.enqueue(currNode.getKey());
            System.out.print(currNode.getValue() +" \n");
            recInOrder(currNode.getRight(), queue);
        }
        return queue;
    }
    //INORDER
    public DSAQueue store()
    {
        DSAQueue queue = new DSAQueue(count);
        //return 
        return recStore(root, queue);    
    }

    private DSAQueue recStore(TreeNode currNode, DSAQueue queue)
    {
        if (currNode != null)
        {

            recInOrder(currNode.getLeft(), queue);//recurse the find current and recurse other side
            queue.enqueue(currNode.getValue());//visits current node
            recInOrder(currNode.getRight(), queue);
        }
        return queue;
    }

    //=======================================================================
    // MIN
    //======================================================================

    public TreeNode min()
    {
        return minRec(root);
    }

    private TreeNode minRec(TreeNode startNode)
    {
        TreeNode minNode = null;
        if (startNode.getLeft() != null)
        {//find the smallest node which is the far left branch
            minNode = minRec(startNode.getLeft());
        }
        return minNode;
    }

    public int balance()
    {
        int avg = ((lCount+rCount)/2);
        int dif = Math.abs(lCount-rCount);
        return  (dif/avg)*100;   
    }
}
