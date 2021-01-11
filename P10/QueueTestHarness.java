import java.util.*;
/*********************************************
 * obtained from www.geeksforgeeks.org/queue-interface-java/
 **********************************************/
public class QueueTestHarness
{
    public static void main(String[] args)
    {
        Queue<Integer> queue = new LinkedList<>();
        
        //adds elements 0 - 5 into queue
        for(int i = 0; i <5; i++)
        {
            queue.add(i);
        }
        
        System.out.println("Elements of queue- "+queue);
        
        //removes first of queue
        int removedele = queue.remove();
        System.out.println("removed element-" + removedele);

        System.out.println(queue);

        //display first of queue
        int head = queue.peek();
        System.out.println("head of queue-" + head);

        //displays queue size
        int size = queue.size();
        System.out.println("Size of queue-" + size);
    }
}
