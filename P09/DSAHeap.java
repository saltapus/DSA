/****************************
 * Author: Anthony Cameron
 * Program: Heap Sort
 ****************************/
import java.util.*;
public class DSAHeap
{
    //private inner class
    private class DSAHeapEntry
    {
        int priority;
        Object value;
        public DSAHeapEntry(int inPriority, Object inValue)
        {
            priority = inPriority;
            value = inValue;
        }
    }

    private DSAHeapEntry[] entry;
    private int count;
    private int max;

    public DSAHeap(int maxSize)
    {
        entry = new DSAHeapEntry[maxSize];   
        count = 0;
        max = maxSize; 
    }
    
    //inserts object into array
    public void add(int priority, Object value)
    {
        if(count == entry.length)
        {
            throw new IllegalArgumentException("heap is full");
        }
        DSAHeapEntry heap = new DSAHeapEntry(priority, value);
        entry[count++] = heap;
        trickleUp(entry, count-1);

    }
    
    //pushes up value until parent is greater then new entry
    public void trickleUp(DSAHeapEntry[] entry, int currIdx)
    {
        int parentIdx = (currIdx-1)/2;
        if(currIdx > 0)
        {
            if (entry[currIdx].priority > entry[parentIdx].priority)
            {
                System.out.println("Swappped");
                DSAHeapEntry temp = entry[parentIdx];
                entry[parentIdx] = entry[currIdx];
                entry[currIdx] = temp;
                trickleUp(entry, parentIdx);

            }
        }
    }

    //swaps item and pushes down lowest priority
    public void heapSort(DSAHeapEntry[] list, int numItems)
    {
        heapify(list, numItems);
        for(int ii = numItems -1; ii > 0; ii--)
        {
            swap(entry, 0 , ii);
            trickleDown(entry, 0, ii);
        }
    }

    //removes highest priority and trickles down
    public Object remove()
    {
        DSAHeapEntry temp;
        if(count < 0)
        {
            throw new IllegalArgumentException("heap is empty");
        }
        temp = entry[0];
        entry[0] = entry[count - 1];
        trickleDown(entry, 0, count);
        
        return temp.value;
    }


    
    public void swap(DSAHeapEntry[] list, int minIdx, int currIdx)
    //public void swap(DSAHeapEntry[] list, int currIdx, int minIdx)
    {
        DSAHeapEntry temp = list[minIdx];
        list[minIdx] = list[currIdx];
        list[currIdx] = temp;
    }

    public void heapify(DSAHeapEntry[] entry, int numItems)
    {
        for(int ii = (numItems/2) - 1; ii > 0; ii--)
        {
            trickleDown(entry, ii, numItems);
        }
    }

    //pushes value down
    public void trickleDown(DSAHeapEntry[] entry, int currIdx, int numItems)
    {
        int lChildIdx = currIdx * 2 + 1;
        int rChildIdx = lChildIdx + 1;
        int largeIdx = 0;
        if( lChildIdx < numItems)
        {
            largeIdx = lChildIdx;
            if( rChildIdx < numItems)
            {
                if( entry[lChildIdx].priority < entry[rChildIdx].priority)
                {
                    largeIdx = rChildIdx;
                }
            }
            if (entry[largeIdx].priority > entry[currIdx].priority)
            {
                swap(entry, largeIdx, currIdx);
                trickleDown(entry, largeIdx, numItems);
            }
        }
    }
    
    public void display()
    {
        for(int i = 0; i < entry.length; i++)
        {
            System.out.println(entry[i].priority + " " + entry[i].value + " ");
        }
    }
}
