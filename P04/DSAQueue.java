import java.util.*;

public class DSAQueue
{
    //CLASSFIELDS

    private DSALinkedList list = new DSALinkedList();
    
    //DEFAULT CON
    public DSAQueue()
    {
    }

    public int getCount()
    {
        return list.getCount();
    }

    //CHECKS IF EMPTY RETURNS T/F
    public boolean isEmpty()
    {
        return list.isEmpty();
    }

    //IMPORTS OBJECT VAL AND ASSIGNS TO QUEUE
    //MUTATOR
    public void enqueue(Object value)
    {
        list.insertLast(value);
    }
    
    //RETURNS OBJECT AND REMOVES 1 FROM QUEUE
    public Object dequeue()
    {
        return list.removeFirst();
    }

    //RETURNS OBJECY AND GETS TOP VAL
    public Object peek()
    {
        return list.peekFirst();
    }
}

