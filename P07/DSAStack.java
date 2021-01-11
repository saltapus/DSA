import java.util.*;

public class DSAStack
{

    //CLASSFILED
    private DSALinkedList list = new DSALinkedList();
    

    //CHECKS IF EMPTY AND RETURNS T/F
    public boolean isEmpty()
    {
        return list.isEmpty();
    }

    public int getCount()
    {
        return list.getCount();
    }
    
    //ADDS OBJECT TO STACK ARRAY AND VALIDATES FULL
    public void push(Object value)
    {
        list.insertLast(value);
    }
    
    //RETURNS TOPVAL AND REMOVES 1 FROM COUNT
    public Object pop()
    {
        return list.removeLast();
    }

    //CHECKS IF EMPTY AND LOOKS AT TOPVAL RETURNS OBJ
    public Object top()
    {
        return list.peekLast();
    }
}

