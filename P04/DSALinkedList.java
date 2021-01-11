import java.util.*;

//ITERABLE ALLOWS FOR EACH LOOP TO WORK
public class DSALinkedList implements Iterable
{
    //CLASSFIELDS
    private DSAListNode head;
    private DSAListNode tail;
    private int count;

    //CONSTRUCTOR
    public DSALinkedList()
    {
        head = null;
        tail = null;
        count = 0;
    }

    //IMPORTS OBJECT AND CREATES A NEW NODE WITH VALUE
    public void insertFirst(Object newValue)
    {
        DSAListNode newNd = new DSAListNode(newValue);
        if (isEmpty())//CHECKS IF EMPTY AND IF SO SETS H/T AS NEW NODE
        {
            head = newNd;
            tail = newNd;
        }
        else
        {
            newNd.setNext(head);//IF NODE EXISTS IT SETS NEXT NODE
            head = newNd;
        }
        count++;
    }

    //IMPORTS VALUE AND SETS IT AS LAST
    public void insertLast(Object newValue)
    {
        DSAListNode newNd = new DSAListNode(newValue);
        DSAListNode currNd;
        if (isEmpty())
        {
            tail = newNd;
            head = newNd;
        }
        else
        {
            currNd = tail;//CREATES CURRENT NODE WITH VALUE OF TAIL AND HAS PREV
                          // AND NEXT FUNCTIONS
            newNd.setPrev(currNd);
            currNd.setNext(newNd);

        }
        tail = newNd;//SETS TAIL TO WHATEVER THE LAST NODE IS
        count++;

    }
    
    public boolean isEmpty()
    {
        return (count == 0);
    }


    public Object peekFirst()
    {
        Object nodeValue = null;
        if (isEmpty())
        {
            throw new IllegalArgumentException("empty");
        }
        else
        {
            nodeValue = head.getValue();
        }
        return nodeValue;
    }

    public Object peekLast()
    {
        DSAListNode currNd;
        Object nodeValue;
        if (isEmpty())
        {
            throw new IllegalArgumentException("empty");
        }
        else
        {
            currNd = head;
            while (currNd.getNext() != null)
            {
                currNd = currNd.getNext();
            }
            nodeValue = currNd.getValue();
        }
        return nodeValue;
            
    }

    //CHECKS IF NODE IS EMPTY OR IF THERE IS AN EXISTING NODE
    public Object removeFirst()
    {
        Object nodeValue;
        if (isEmpty())
        {
            throw new IllegalArgumentException("empty");
        }
        else if (count == 1 )//IF REMOVING LAST NODE THE HEAD AND TAIL BECOMES NULL
        {
            nodeValue = head.getValue();//OBTAINS VALUE OF HEAD AND SETS AS NODEVAL
            head = null;
            tail = null;
        }
        else
        {
            nodeValue = head.getValue();//REMOVES HEAD NODE AND SETS VALUE AS NODEVAL
            head = head.getNext();
        }
        count--;
        return nodeValue;
    }

    public int getCount()
    {
        return count;
    }
    
    //SAME AS REMOVE FIRST BUT APPLIES IT TO TAIL
    public Object removeLast()
    {
        DSAListNode currNd;
        Object nodeValue;
        DSAListNode prevNd;
        if (isEmpty())
        {
            throw new IllegalArgumentException("empty");
        }
        else if (count == 1 )
        {
            nodeValue = head.getValue();
            head = null;
            tail = null;
        }
        else
        {
            nodeValue = tail.getValue();
            
            prevNd = tail.getPrev();
            tail = prevNd;

            prevNd.setNext(null);
        }            
        count--;

        return nodeValue;
    }
    
    public Iterator iterator()
    {
        return new LinkedListIterator(this);
    }
        

    //
    private class LinkedListIterator implements Iterator
    {
        private DSAListNode iterNext;

        public LinkedListIterator(DSALinkedList theList)
        {
            iterNext = theList.head;
        }
        
        //CHECKS IF THERE IS ANYTHING LEFT IN LIST
        public boolean hasNext()
        {
            return (iterNext != null);
        }
        
        //MOVES ONTO THE NEXT ITEM IN LIST
        public Object next()
        {
            Object value;
            if (iterNext == null)//IF THERE IS NOTHING LEFT SETS VALUE TO NULL
            {
                value = null;
            }
            else
            {
                value = iterNext.getValue();//GETS THE NEXT ITEMS VALUE AND SETS IT
                iterNext = iterNext.getNext();//AS VALUE THEN GETS NEXT
            }
            return value;
        }
        
        //REMOVES CURRENT ITEM
        public void remove()
        {
            throw new UnsupportedOperationException("Not supported");
        }
    }

}
