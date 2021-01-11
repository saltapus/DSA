import java.util.*;

public class HeapTestHarness
{
    public static void main(String[]args)
    {
      //  int[] priority = {9, 8, 5, 2, 3, 6, 0};
      //  String[] value = {"cat", "Doggo", "bleh", "boop", "snoot", "crab", "yeet"};
        int[] priority = {5, 4, 2, 3, 1};
        String[] value = {"cat", "Doggo", "bleh", "boop", "snoot"};
        Object item;
        int iNumTests = 0;
        int iNumPassed = 0;
        DSAHeap heap = new DSAHeap(priority.length);

        for(int i = 0; i < value.length; i++)
        {
            System.out.print("priority: "+priority[i]+" ");
            System.out.println("value: "+value[i]);
            heap.add(priority[i], value[i]);
        }
        //test remove order
        try
        {
            iNumTests++;
            System.out.println("=============================================");
            System.out.println("insert Order :");
            heap.display();
            System.out.println("=============================================");
            System.out.println("expected result :");
            System.out.println("cat, doggo, boop, bleh, snoot");
            System.out.println("=============================================");
            System.out.println("Actual Result :");
            for(int i = 0; i < value.length; i++)
            {
                item = heap.remove();
                System.out.print(item + " ");
            }
            System.out.println();
            System.out.println("passed");
            iNumPassed++;
        }
        catch (Exception e)
        {
            System.out.println("FAILED");
        }
        
        System.out.println("=============================================");
        System.out.println("number of Tests passed "+ iNumPassed+" out of "+iNumTests);

        /*item = heap.remove();
        System.out.print("removed :"+item + " ");
        heap.display();
        item = null;
        System.out.println();

        System.out.println("expected result:");
        System.out.println("boop, bleh, snoot");
        
        System.out.println("Actual Result");
        item = heap.remove();
        System.out.print("removed :"+item + " ");
        heap.display();
        System.out.println();
*/
    }
}  
