/****************************
 * Program: TreeTestHarness *
 * Author: Anthony Cameron  *
 * Date Created: 17/05/2019 *
 ****************************/
import java.util.*;
import java.io.*;

public class TwoFourTest
{
    private static final int REPEATS = 4;

    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        TwoFourTree tree = new TwoFourTree("20190218.txt");

        int iNumPassed = 0;//increments when test start and passed
        int iNumTests = 0;
        int i;
        Object nodeValue = null;
    
        /***************************************************
        * obtained from curtin slides
        * SortsTestHarness.java
        * Date Accessed(23/05/2019)
        * **************************************************/
        //TEST 1 read file()
        try
        {

            iNumTests++;
            System.out.println("==========================================");
            System.out.println("display");
            System.out.println("==========================================");
            System.out.println("1 = print keys, 2 = print values");
            int choice = sc.nextInt();

            double runningTotal = 0;
            long startTime = System.nanoTime();

            if(choice == 1)
            {
                tree.display();
            }
            else
            {
                tree.displayVal();
            }

            System.out.println("testing file 20190218.txt");
            System.out.println("Passed");
            iNumPassed++;

            long endTime = System.nanoTime();
            runningTotal += (int)((double)(endTime - startTime)/100);
            System.out.println(" " + (runningTotal/(REPEATS-1)));

        }
        catch(Exception e)
        {
            System.out.println("FAILED");
            e.printStackTrace();
        }
        //Test 2 stats
        try
        {
            double runningTotal = 0;
            long startTime = System.nanoTime();

            iNumTests++;
            System.out.println("==========================================");
            System.out.println("stats");
            System.out.println("==========================================");
            int height = tree.height();
            int size = tree.size();
            int balance = tree.balance();

            System.out.println("Tree height :"+ height);
            System.out.println("Tree size :"+ size);
            System.out.println("Tree balance :"+ balance +"%");
            System.out.println("Passed");
            iNumPassed++;

            long endTime = System.nanoTime();
            runningTotal += (int)((double)(endTime - startTime)/100);
            System.out.println(" " + (runningTotal/(REPEATS-1)));
            iNumPassed++;
        }
        catch(Exception e)
        {
            System.out.println("FAILED");
            e.printStackTrace();
        }
        //Test 3 find
        try
        {
            iNumTests++;
            System.out.println("==========================================");
            System.out.println("Find");
            System.out.println("==========================================");
            System.out.println("Enter key");
            String key = sc.next();

            double runningTotal = 0;
            long startTime = System.nanoTime();
            Object value = tree.search(key);

            System.out.println("Tree :"+ value.toString());
            System.out.println("Passed");
            iNumPassed++;
            
            long endTime = System.nanoTime();
            runningTotal += (int)((double)(endTime - startTime)/100);
            System.out.println(" " + (runningTotal/(REPEATS-1)));

        }
        catch(Exception e)
        {
            System.out.println("FAILED");
            e.printStackTrace();
        }
        //Test 3 delete
        try
        {
            System.out.println("==========================================");
            System.out.println("delete");
            System.out.println("==========================================");
            iNumTests++;
            System.out.println("Enter key");
            String key = sc.next();
         
            double runningTotal = 0;
            long startTime = System.nanoTime();
            tree.delete(key);
            tree.displayVal();
            System.out.println("Passed");
            iNumPassed++;
            
            long endTime = System.nanoTime();
            runningTotal += (int)((double)(endTime - startTime)/100);
            System.out.println(" " + (runningTotal/(REPEATS-1)));

        }
        catch(Exception e)
        {
            System.out.println("FAILED");
            e.printStackTrace();
        }
        //Test 4 insert
        try
        {
            iNumTests++;
            System.out.println("==========================================");
            System.out.println("insert");
            System.out.println("==========================================");
            System.out.println("Enter key");
            String key = sc.next();
            Object value = create(key);
            
            double runningTotal = 0;
            long startTime = System.nanoTime();
            tree.insert(key, value);
            tree.display();

            System.out.println("inserted :"+ value.toString());
            System.out.println("Passed");
            iNumPassed++;

            long endTime = System.nanoTime();
            runningTotal += (int)((double)(endTime - startTime)/100);
            System.out.println(" " + (runningTotal/(REPEATS-1)));
        }
        catch(Exception e)
        {
            System.out.println("FAILED");
            e.printStackTrace();
        }
        System.out.println("number of tests passed: "+iNumPassed+ " out of " +iNumTests);
    
    }
    public static Object create(String key)
    {
        Scanner sc = new Scanner(System.in);
        int date, vol;
        double open, high, low, close;
        System.out.println("Enter date");
        date = sc.nextInt();
        System.out.println("Enter open");
        open = sc.nextDouble();
        System.out.println("Enter high");
        high = sc.nextDouble();
        System.out.println("Enter low");
        low = sc.nextDouble();
        System.out.println("Enter close");
        close = sc.nextDouble();
        System.out.println("Enter vol");
        vol = sc.nextInt();

        StocksClass stocks = new StocksClass(key, date, open, high, low, close,
                                            vol);
        return stocks;
    }

        
}
