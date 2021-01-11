import java.util.*;

public class DSAQueue
{
    //.CONSTANTS
    public static final int DEFAULT_CAPACITY = 100;

    //CLASSFIELDS
    private Object[] queue;
    private int count;
    
    //DEFAULT CON
    public DSAQueue()
    {
        queue = new Object[DEFAULT_CAPACITY];
        count = 0;
    }
    
    //ALTERNATE CON
    public DSAQueue(int maxCapacity)
    {
        queue = new Object[maxCapacity];
        count = 0;
    }

    //ACCESSORS
    public int getCount()
    {
        return count;
    }
    
    //CHECKS IF EMPTY RETURNS T/F
    public boolean isEmpty()
    {
        boolean empty;
        return empty = (count == 0);
    }
    
    //CHECKS IF FULL RETURNS T/F
    public boolean isFull()
    {
        boolean full;
        return full = (count == queue.length);
    }

    //IMPORTS OBJECT VAL AND ASSIGNS TO QUEUE
    //MUTATOR
    public void enqueue(Object value)
    {
        if (isFull())
        {
            throw new IllegalArgumentException("stk is full");
        }
        else
        {
            queue[count] = value;
            count++;
        }
    }
    
    //RETURNS OBJECT AND REMOVES 1 FROM QUEUE
    public Object dequeue()
    {
        Object peekVal = peek();
        for (int i  = 1; i < count; i++)
        {
            queue[i - 1] = queue[i];
        }
        count--;
        return peekVal;
    }

    //RETURNS OBJECY AND GETS TOP VAL
    public Object peek()
    {
        Object peekVal;
        if (isEmpty())
        {
            throw new IllegalArgumentException("que is empty");
        }
        else
        {
            peekVal = queue[0];
        }
        return peekVal;
    }
}

