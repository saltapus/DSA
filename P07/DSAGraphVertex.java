/************************************
 * Author: Anthony C                *
 * Program: DSAGraphVertex          *
 ************************************/

import java.util.*;

public class DSAGraphVertex
{
    private String label;
    private DSALinkedList links;
    private boolean visited;

    public DSAGraphVertex(String inLabel)
    {
        label = inLabel;
        //value
        links = new DSALinkedList(); 
        visited = false;
    }

    //ACCESSORS
    public String getLabel()
    {
        return label;
    }
    
    public DSALinkedList getAdjacent()
    {
        return links;
    }
    
    public boolean getVisited()
    {
        return visited;
    }


    public String toString()
    {
        String str = String.format("%-7s|",label);
        for(Object v : links)
        {
            str += String.format("%s", ((DSAGraphVertex)v).label);
        }
        return str;
    }

    public boolean equals(DSAGraphVertex inVertex)
    {
//        if (inObj instanceof DSAGraphVertex)
  /*          DSAGraphVertex inVertex = (DSAGraphVertex)inObj;
            isEquals = label.equals(inVertex.getLabel());    
    */
 
        return inVertex.getLabel().equals(label);
    }
    //MUTATOR
    public void addEdge(DSAGraphVertex vertex)
    {
        if(equals(vertex))
        {
            links.insertLast(vertex);
        }
        else
            throw new IllegalArgumentException("invalid");
    }


    public void setVisited(boolean visited)
    {
        visited = true;   
    }

    public void clearVisited(boolean visited)
    {
        visited = false;   
    }
}
