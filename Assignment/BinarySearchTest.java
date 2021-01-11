/****************************
 * Program: TreeTestHarness *
 * Author: Anthony Cameron  *
 * Date Created: 17/05/2019 *
 ****************************/
import java.util.*;
import java.io.*;

public class BinarySearchTest
{
    public static void main(String [] args)
    {
        BinarySearchTree tree = new BinarySearchTree();
        BinarySearchTree tree2 = new BinarySearchTree("20190218.txt");

        int iNumPassed = 0;//increments when test start and passed
        int iNumTests = 0;
        int i;
        Object nodeValue = null;
        /***************************************************
        * obtained from curtin slides
        * SortsTestHarness.java
        * Date Accessed(23/05/2019)
        * **************************************************/
    
      //TEST 1 insert()
        try
        {
            iNumTests++;
            System.out.println("Testing insertFirst() ");
            for (i = 0; i < 50; i++)
            {
                tree.insert(String.valueOf(i), i);

            }
            System.out.println("Passed");
            iNumPassed++;
        }
        catch(Exception e)
        {
            System.out.println("FAILED");
            e.printStackTrace();
        }

        //TEST 2 delete()
        try
        {
            iNumTests++;
            tree.delete( "20");
            System.out.println("Passed");
            iNumPassed++;
        }
        catch(Exception e)
        {
            System.out.println("FAILED");
            e.printStackTrace();
        }

        //TEST 3 Traversal()
        try
        {
            iNumTests++;
            System.out.println("==========================================");
            System.out.println("PreOrder");
            System.out.println("==========================================");
            //DSAQueue preOrder = 
            tree.preOrder();
           // System.out.println(Arrays.asList(preOrder.getArray()));//outputs the list of treenode keys
            System.out.println("passed");
            iNumPassed++;

            iNumTests++;
            System.out.println("==========================================");
            System.out.println("inOrder");
            System.out.println("==========================================");
            //DSAQueue inOrder = 
            tree.inOrder();

           // System.out.println(Arrays.asList(inOrder.getArray()));//same as above for inOrder
            System.out.println("passed");
            iNumPassed++;
            
            iNumTests++;
            System.out.println("==========================================");
            System.out.println("postOrder");
            System.out.println("==========================================");
            //DSAQueue postOrder = 
            tree.postOrder();
            //System.out.println(Arrays.asList(postOrder.getArray()));//same as above for posOrder
            System.out.println("passed");
            iNumPassed++;
        }
        catch(Exception e)
        {
            System.out.println("FAILED");   
        }
        try
        {
            iNumTests++;
            System.out.println("==========================================");
            System.out.println("Testing file");
            System.out.println("==========================================");
            System.out.println("using default file 20190218.txt");

            tree2.inOrder();
            iNumPassed++;
        }
        catch(Exception e)
        {
            System.out.println("FAILED");
        }
        try
        {
            iNumTests++;
            System.out.println("==========================================");
            System.out.println("PreOrder");
            System.out.println("==========================================");
            tree2.preOrder();
            System.out.println("passed");
            iNumPassed++;

            iNumTests++;
            System.out.println("==========================================");
            System.out.println("inOrder");
            System.out.println("==========================================");
            tree2.inOrder();

            System.out.println("passed");
            iNumPassed++;
            
            iNumTests++;
            System.out.println("==========================================");
            System.out.println("postOrder");
            System.out.println("==========================================");
            tree2.postOrder();
            System.out.println("passed");
            iNumPassed++;
        }
        catch(Exception e)
        {
            System.out.println("FAILED");   
        }
        //TEST 4 find()
        try
        {
            iNumTests++;
            System.out.println("==========================================");
            System.out.println("find");
            System.out.println("==========================================");
            Object item = tree2.find( "AAA");
            System.out.println(item);
            System.out.println("Passed");
            iNumPassed++;
        }
        catch(Exception e)
        {
            System.out.println("FAILED");
            e.printStackTrace();
        }
        //TEST 5 stats()
        try
        {
            iNumTests++;
            System.out.println("==========================================");
            System.out.println("height");
            System.out.println("==========================================");
            int item = tree2.height();
            int item2 = tree2.size();
            int balance = tree2.balance();
            System.out.println("height :"+item);
            System.out.println("size :"+item2);
            System.out.println("balance :"+balance+"%");
            System.out.println("Passed");
            iNumPassed++;
        }
        catch(Exception e)
        {
            System.out.println("FAILED");
            e.printStackTrace();
        }
        //TEST 6 min()
        try
        {
            iNumTests++;
            System.out.println("==========================================");
            System.out.println("Min");
            System.out.println("==========================================");
            System.out.println(tree2.min());
            System.out.println("Passed");
            iNumPassed++;
        }
        catch(Exception e)
        {
            System.out.println("FAILED");
            e.printStackTrace();
        }
        System.out.println("number of tests passed: "+iNumPassed+ " out of " +iNumTests);
    }
}
