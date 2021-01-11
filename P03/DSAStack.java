import java.util.*;

public class DSAStack
{
    //CONSTANTS
    public static final int DEFAULT_CAPACITY = 100;

    //CLASSFILED
    private Object[] stack;
    private int count;
    
    //DEFAULT CON
    public DSAStack()
    {
        stack = new Object[DEFAULT_CAPACITY];
        count = 0;
    }

    //ALT CON    
    public DSAStack(int maxCapacity)
    {
        stack = new Object[maxCapacity];
        count = 0;
    }

    //ACCESSOR
    public int getCount()
    {
        return count;
    }

    //CHECKS IF EMPTY AND RETURNS T/F
    public boolean isEmpty()
    {
        boolean empty;
        return empty = (count == 0);
    }
    
    //CHECKS IF FULL AND RETURN T/F
    public boolean isFull()
    {
        boolean full;
        return full = (count == stack.length);
    }

    //ADDS OBJECT TO STACK ARRAY AND VALIDATES FULL
    public void push(Object value)
    {
        if (isFull())
        {
            throw new IllegalArgumentException("stk is full");
        }
        else
        {
            stack[count] = value;
            count++;
        }
    }
    
    //RETURNS TOPVAL AND REMOVES 1 FROM COUNT
    public Object pop()
    {
        Object topVal = top();
        count--;
        return topVal;
    }

    //CHECKS IF EMPTY AND LOOKS AT TOPVAL RETURNS OBJ
    public Object top()
    {
        Object topVal;
        if (isEmpty())
        {
            throw new IllegalArgumentException("stk is empty");
        }
        else
        {
            topVal = stack[count - 1];
        }
        return topVal;
    }
}

