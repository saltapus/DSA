/********************************
 * Author: Anthony C
 * Program: TreeProfiler
 * Date Created: 06/05/2019
 * Date Modified: --/--/----
 * ******************************/

import java.util.*;
import java.text.*;

public class TreeProfiler
{
    /***************************************************
     * obtained from curtin slides
     * SortsTestHarness.java
     * Date Accessed(23/05/2019)
     * **************************************************/
    private static final int REPEATS = 4;
    public static void main(String [] args)
    {
        char treeType;
        if(args.length <1)//chekcs if the cmd arguments are valid if not prints instructions
            usage();
        else if(args[0].equals("-i"))
        {
            treeType = args[1].charAt(1);
            double runningTotal = 0;
    
            long startTime = System.nanoTime();
            switch(treeType)
            {
                case 's' :
                    System.out.println("you have selected BinarySearchTree");
                    UI.bST();
                    break;
                case 'b' :
                    System.out.println("you have selected BTree");
                    UI.BT();
                    break;
                case 'f' :
                    System.out.println("you have selected 2-3-4 Tree");
                    UI.TFT();
                    break;
                default :
                    System.err.println("Unsupported tree type " +treeType);
            }
            long endTime = System.nanoTime();
            runningTotal += (int)((double)(endTime - startTime)/100);  
            System.out.println(" " + (runningTotal/(REPEATS-1)));



        }
        else if(args[0].equals("-p"))
        {
            DecimalFormat dp2 = new DecimalFormat("#0.00");
            treeType = args[1].charAt(1);
            double runningTotal = 0;
            long startTime = System.nanoTime();
            int size = Integer.valueOf(args[2]);
            String file = args[3];

            
            switch(treeType)
            {
                //each tree calls the stats data and prints the runtime in nanoseconds
                case 's' :
                    System.out.println("you have selected BinarySearchTree");
                    BinarySearchTree tree1 = new BinarySearchTree(file);
                    int height1 = tree1.height();
                    int size1 = tree1.size();
                    double balance1 = tree1.balance();
                    System.out.println("height :"+height1);
                    System.out.println("size :"+size1);
                    System.out.println("balance :"+dp2.format(balance1)+"%");
                    break;
                case 'b' :
                    System.out.println("you have selected BTree");
                    BTree tree2 = new BTree(file, size);
                    int height2 = tree2.height();
                    int size2 = tree2.size();
                    double balance2 = tree2.balance();
                    System.out.println("height :"+height2);
                    System.out.println("size :"+size2);
                    System.out.println("balance :"+dp2.format(balance2)+"%");
                    break;
                case 'f' :
                    System.out.println("you have selected 2-3-4 Tree");
                    TwoFourTree tree3 = new TwoFourTree(file);
                    int height3 = tree3.height();
                    int size3 = tree3.size();
                    double balance3 = tree3.balance();

                    System.out.println("height :"+height3);
                    System.out.println("size :"+size3);
                    System.out.println("balance :"+dp2.format(balance3)+"%");
                    break;
                default :
                    System.err.println("Unsupported tree type " +treeType);
                    break;
            }
            long endTime = System.nanoTime();
            runningTotal += (int)((double)(endTime - startTime)/100);  
            System.out.println("speed: " + (runningTotal/(REPEATS-1)));
        }
    }
    private static void usage()
    {
        System.out.println(" Usage: java TreeProfiler -n -y ");
        System.out.println("        where");
        System.out.println("        n is -i :interactive testing environment");
        System.out.println("          or -p: profiling mode ");
        System.out.println("        where y = Tree Type ");
        System.out.println("          or -s: BinarySearchTree ");
        System.out.println("          or -b: BTree ");
        System.out.println("          or -f: 234Tree ");
        System.out.println(" ");
        System.out.println("while in profiler mode");
        System.out.println(" Usage: java TreeProfiler -n -y s [FILE.txt]");
        System.out.println("        where s: size ");

        
    
    }
}
