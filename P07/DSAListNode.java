import java.util.*;

public class DSAListNode
{
    //CLASSFIELDS
    private Object value;
    private DSAListNode next, prev;

    //CONSTRUCTOR
    public DSAListNode(Object inValue)
    {
        value = inValue;
        next = null;
        prev = null;
    }

    //ACCESSORS
    public Object getValue()
    {
        return value;
    }

    public DSAListNode getNext()
    {
        return next;
    }

    public DSAListNode getPrev()
    {
        return prev;
    }

    //MUTATORS
    public void setValue(Object inValue)
    {
        value = inValue;
    }

    public void setNext(DSAListNode newNext)
    {
        next = newNext;
    }

    public void setPrev(DSAListNode newPrev)
    {
        prev = newPrev;
    }
}
