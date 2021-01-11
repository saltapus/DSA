import java.util.*;

public class StackQueueTestHarness
{
    public static void main(String[] args)
    {
        int iNumPassed = 0;
        int iNumTests = 0;
        int count = 0;

        DSAQueue queue = new DSAQueue();
        DSAStack stack = new DSAStack();
        
        //constructor test
        System.out.println("Constructoris tests: ");                         
        


        for(int i = 0; i < 100; i++)                              
        {
            stack.push(i);
            queue.enqueue(i);
        }
        System.out.println("```````````````````````````````````````````````````");
        System.out.println("TESTING STORAGE FULL");
        System.out.println("```````````````````````````````````````````````````");
    
        System.out.println("Storage is full: " +stack.getCount());
        System.out.println("storage is full: " +queue.getCount());
    
        System.out.println("```````````````````````````````````````````````````");
        System.out.println("TESTING POP FUNC");
        System.out.println("```````````````````````````````````````````````````");
    
        stack.pop();
        queue.dequeue();
    
        System.out.println("STORAGE: " + stack.getCount());
        System.out.println("STORAGE: " + queue.getCount());
    
    
        System.out.println("STORAGE: " + stack.top());
        System.out.println("STORAGE: " + queue.peek());
    }
}
        //Tests count
