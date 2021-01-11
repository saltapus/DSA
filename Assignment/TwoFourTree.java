import java.io.*;
import java.util.*;

public class TwoFourTree {
    
    //private inner class
    /*************************************************************************
    * Obtained from adderllyer,
    * https://gist.github.com/adderllyer/3bfa2d04200386b5664c
    * (Accessed on 8th May 2019)
    * ***********************************************************************/
    private class BNode 
    {
        int size;
        String key[]; //array of string -used to store id of object
        Object data[]; //array of objects -stores stocks
        BNode child[]; //contains references of keys and data
        boolean leaf; //variable saying if there is a leaf or not

        public BNode(int t) 
        {
            this.key = new String[2*t-1]; //allocates max num of keys and child references
            this.data = new Object[2*t-1];
            this.child = new BNode[2*t];
            this.leaf = true; //sets node to have a leaf
        }
    }

    private BNode root;
    private int t = 4; //degrees
    private int count = 0; //variable count
    private int height = 0; //height of tree

    //CONSTRUCTORS
    public TwoFourTree() 
    {
        root = new BNode(t);
        root.leaf = true; //root becomes a leaf
        root.size = 0;
        root.key[0] = null; //intialised with null
        root.data[0] = null;
    }
    
    public TwoFourTree(String fileName) 
    {
        root = new BNode(t);
        root.leaf = true;
        root.size = 0;
        root.key[0] = null;
        root.data[0] = null;
        fileInput(fileName);
    }


    //FILE IO Used in prac 1
    // obtained from anthony C
    // date Accessed 21/05/2019
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
               //     System.out.println("Illegal argument -fileInput SB: " + e.getMessage());
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

    //processes line and constructs objects of stock
    private void processStock(String line)                                       
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


    /**************************************************************************
    * Obtained from Kevin Ponek
    * https://github.com/kponek/AP-Computer-Science/blob/
    * 21df64e475fc2260bfb55b3a1ccb78677f098956/Desktop/COC/CS/
    * All282project2/New%20folder/Morada/src/BTree.java
    * (Accessed on 20/05/2019) 
    ***************************************************************************
    * Obtained from LEPROFESSEUR,
    * https://www.youtube.com/watch?v=KMWb6K1EC5o&feature=youtu.be
    *(Accessed on 8th May 2019) 
    * Used In (search, insert and insertNonFull)
    ***************************************************************************
    * Obtained from Abdulrhman Alkhodiry, Ahmed Alsalama,
    * https://searchcode.com/codesearch/view/29922786/
    * (Accessed on 8th May 2019)
    * Used In Split
    ***************************************************************************
    * Obtained from Navjinder Virdee,
    * https://github.com/navjindervirdee/data-structures/blob/master/
    * B-Tree/B-Tree%20Insert/BTree.java
    * (Accessed on 11th May 2019)
    ***************************************************************************/
    
    public void insert(String key, Object data)
    {
        BNode r = root;
        count++;
        //checks when node is full
        if (r.size == t) 
        {
            BNode parent = new BNode(t);
            root = parent;//after split becomes new root
            parent.size = 0;//intialises new root to be size of 0
            parent.leaf = false;//has no leaf
            parent.child[0] = r;
            splitChild(parent, 1, r);//splits node when full
            insertNonfull(parent, key, data);//inserts values into nonfull node
            height++; //height increases after node is full
        } 
        else //node is not full and has space for new values
        {
            insertNonfull(r, key, data);
        }
    }
    
    private void insertNonfull(BNode node, String value, Object data) 
    {
        int i = node.size -1 ; //initialses index
        if (node.leaf)//if this is a leaf insert node
        {
            //finds location of new key to be inserted
            //inserts data into node
            while (i >= 0 && value.compareTo(node.key[i])<0) 
            {
                node.key[i+1] = node.key[i];
                node.data[i+1] = node.data[i];
                i--;
            }
            //inserts key at found location
            node.key[i+1] = value;
            node.data[i+1] = data;
            node.size++;
        }
        else //node is not a leaf
        {
            //finds child to have new key
            while (i >= 0 && value.compareTo(node.key[i])<0) 
            {
                i--;
            }
            i++;
            if (node.child[i].size == t) //checks if full
            {
                splitChild(node, i+1, node.child[i]);//splits full into 2 nodes
                //after split, finds correct child to descend into
                if (value.compareTo(node.key[i])>0) 
                {
                    i++;
                }
            }
            //recurses
            insertNonfull(node.child[i], value, data);
        }
    }

    //splits node into 2 nodes, newchild must be full when called
    private void splitChild(BNode parent, int childIndex, BNode inChild) 
    {
        // creates node which is going to store t-1
        BNode z = new BNode(t);
        z.leaf = inChild.leaf;
        z.size = 1; 
        z.key[0] = inChild.key[2];
        z.data[0] = inChild.data[2];

        if (inChild.leaf == false)//copies values over to z
        {
            int j = t;
            for(int i = 1; i >= 0; i--)
            {
                z.child[i] = inChild.child[j];
                j--;
            }
        }
        inChild.size = 1;
        
        //find location of new key and shuffles into ascending
        for (int j = parent.size; j >= childIndex; j--) 
        {
            parent.child[j + 1] = parent.child[j];
            parent.key[j] = parent.key[j - 1];
            parent.data[j] = parent.data[j - 1];
        }
        //assigns reference of z to child of parent 
        parent.child[childIndex] = z;
        parent.key[childIndex - 1] = inChild.key[1];
        parent.data[childIndex - 1] = inChild.data[1];
        parent.size++;

    }
    
    //wrapper method
    public Object search(String key) 
    {
        return searchRec(root, key);
    }

    //recurces through keys until it detects, otherwise returns false
    private Object searchRec(BNode currNode, String value) 
    {
        int i = 0;
        Object found = "not found";
        //finds first key >= to value
        while (i <= currNode.size -1 && value.compareTo(currNode.key[i])>0) 
        {
            i++;
        }
        // checks if value is equal to key
        if (value.equals(currNode.key[i])) 
        {
            found =  currNode.data[i];
        }
        // if x is a leaf return nothing
        else if (currNode.leaf == true) 
        {
            found =  "null";
        }
        else
        {
            //recurses until child is found
            found = searchRec(currNode.child[i], value);
        }
        return found;
    }
    
    public void delete(String key) 
    {
        throw new IllegalArgumentException("not yet implimented");
    }
    
    public void display()
    {
        recDisplay(root, 0);
    }

    private void recDisplay(BNode node, int lvl)
    {
        if (node != null)
        {
            System.out.println("==================================================");
            System.out.println("NODE level:"+lvl);
            System.out.println("==================================================");

            for(int i = 0; i < node.size; i++)
            {
                System.out.println(node.key[i] + " ");

            }
            System.out.println();
            if(!node.leaf)
            {
                for(int i = 0; i < node.size+1; i++)
                {
                    recDisplay(node.child[i], lvl + 1);

                }    
            }
        }
    }

    public void displayVal()
    {
        recDisplayVal(root, 0);
    }

    private void recDisplayVal(BNode node, int lvl)
    {
        if (node != null)
        {
            System.out.println("==================================================");
            System.out.println("NODE level:"+lvl);
            System.out.println("==================================================");

            for(int i = 0; i < node.size; i++)
            {
                System.out.println(node.data[i] + " ");

            }

            System.out.println();
            if(!node.leaf)
            {
                for(int i = 0; i < node.size+1; i++)
                {
                    recDisplayVal(node.child[i], lvl + 1);

                }    
            }
        }
    }
    
    public DSAQueue store()
    {
        DSAQueue queue = new DSAQueue(count);
        return recStore(root, queue);
    }

    private DSAQueue recStore(BNode node, DSAQueue queue)
    {
        if (node!=null)
        {
            for(int i = 0; i< node.size; i++)
            {
                queue.enqueue(node.data[i]);
            }
            if(!node.leaf)
            {
                for(int i = 0; i < node.size+1; i++)
                {
                    recStore(node.child[i], queue);

                }    
            }
        }
        return queue;
    }
    
    
    public int height()
    {
        return height;
    }
    
    public int size()
    {
        return count;
    }
    
    public int balance()
    {
        return 100;
    }
}
