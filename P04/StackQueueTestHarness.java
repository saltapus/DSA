import java.util.*;

public class StackQueueTestHarness
{
    public static void main(String[] args)
    {
        int iNumPassed = 0;
        int iNumTests = 0;
        int count = 0;

        DSAQueue queue = null;
        DSAStack stack = null;

        DSALinkedList ll = null;

        // TEST 1 : CONSTRUCTOR
        System.out.println("```````````````````````````````````````````````````");
        System.out.println("TESTING CONSTRUCTOR");
        System.out.println("```````````````````````````````````````````````````");
        try
        {
            ll = new DSALinkedList();
            stack = new DSAStack();
            queue = new DSAQueue();
            System.out.print("Testing creation of DSALinkedList (isEmpty()): ");
            if ((stack.isEmpty() == false) &&(ll.isEmpty() == false)&&
                (queue.isEmpty() == false))
            {
                throw new IllegalArgumentException("Head must be null.");
            }
            System.out.println("passed");
        }
        catch(Exception e)
        {
            System.out.println("FAILED");
        }
 

        System.out.println("```````````````````````````````````````````````````");
        System.out.println("TESTING STACK");
        System.out.println("```````````````````````````````````````````````````");

        //CREATES 100 ITEMS AND PUSHES IT INTO LINKLIST 
        for(int i = 0; i < 100; i++)                              
        {
            System.out.println("Storing["+i+"]");
            stack.push(i);
            queue.enqueue(i);
        }
    
        //COUNTS HOW MANY ELEMENTS ARE STORED
        System.out.println("stack Stored: " +stack.getCount());
        System.out.println("queue stored: " +queue.getCount());
        
        //not yet implemented
        try
        {

            for (Object s : ll)
            {
                System.out.println("["+s+"]");
            }
            System.out.println("passed");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage() +"Failed");
        }
    
        System.out.println("```````````````````````````````````````````````````");
        System.out.println("TESTING POP FUNC");
        System.out.println("```````````````````````````````````````````````````");
    
        // TEST 4 : REMOVING FROM STACK / QUEUE   
        try
        {
            System.out.println("STORAGE TESTING STACK POP: " + stack.pop());
            System.out.println("STORAGE TESTING QUEUE DEQUEUE: " + queue.dequeue());
        }
        catch(NullPointerException e)
        {
            System.out.println("storage is empty: " + e.getMessage());
        }
        
        System.out.println("```````````````````````````````````````````````````");
        System.out.println("TESTING TOP FUNC");
        System.out.println("```````````````````````````````````````````````````");
    
    
        System.out.println("STORAGE TESTING STACK TOP: " + stack.top());
        System.out.println("STORAGE TESTING QUEUE PEEK: " + queue.peek());

        // TEST 5 : IS EMPTY
        System.out.println("```````````````````````````````````````````````````");
        System.out.println("TESTING EMPTY");
        System.out.println("```````````````````````````````````````````````````");
        try
        {
            DSAStack sEmpt = new DSAStack();
            DSAQueue qEmpt = new DSAQueue();
            System.out.print("Testing isEmpty(): ");
            System.out.println("STORAGE TESTING STACK EMPTY: " + sEmpt.pop());
            System.out.println("STORAGE TESTING QUEUE EMPTY: " + qEmpt.dequeue());
            System.out.println("FAILED");
        }
        catch(Exception e)
        {
            System.out.println("passed");
        }

    }
}
        //Tests count
