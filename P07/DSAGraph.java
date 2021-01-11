/**********************************
 AUTHOR: Anthony C
 Program: DSAGraph
 Date Created: 17/04/19
***********************************/

import java.util.*;
import java.io.*;

public class DSAGraph
{
    private DSALinkedList vertices;
    private int vCount, eCount;
    
    public DSAGraph()
    {
        vertices = new DSALinkedList();
        vCount = 0;
        eCount = 0;
    }

    public DSAGraph(String filename)
    {
        vertices = new DSALinkedList();
        vCount = 0;
        eCount = 0;
        fileInput(filename);
    }

    private void fileInput(String inFileName)
    {
        FileInputStream fileStrm = null;                                        
        InputStreamReader rdr;                                                  
        BufferedReader bufRdr;                                                  
        Scanner sc = new Scanner(System.in);                                    
        String line;                                                            
        try                                                                     
        {                                                                       
            fileStrm = new FileInputStream(inFileName);                         
            rdr = new InputStreamReader(fileStrm);                              
            bufRdr = new BufferedReader(rdr);                                   
                                                                                
            //Input line from the file                                          
            line = bufRdr.readLine();                                           
                                                                                
            while(line != null)                                                 
            {                                                                   
                try                                                             
                {                                                               
                    processVertex(line);                               
                }                                                               
                catch (StringIndexOutOfBoundsException e)                       
                {                                                               
                    System.out.println("Error: String index out of bounds"      
                                       + e.getMessage());                       
                }                                                               
                catch (ArrayIndexOutOfBoundsException e)                        
                {                                                               
                    System.out.println("Error: Array size is full"              
                                        + e.getMessage());                      
                }                                                               
                catch (IllegalArgumentException e)                              
                {                                                               
                    System.out.println("Illegal argument -fileInput SB: " + e.getMessage());
                }                                                               
                line = bufRdr.readLine();                                       
            }                                                                   
            fileStrm.close();                                                   
            System.out.println("File has been Read");                           
        }
        catch (IOException e)                                                   
        {                                                                       
            if (fileStrm != null)                                               
            {                                                                   
                try                                                             
                {                                                               
                    fileStrm.close();                                           
                }                                                               
                catch(IOException ex2)                                          
                {                                                               
                }                                                               
            }                                                                   
            System.out.println("Error in file processing: " + e.getMessage());  
        }                                                                       
    }    


    public void processVertex(String line)
    {
        String v1, v2;
        String [] lineArray = line.split(" ");
        v1 = lineArray[0];
        v2 = lineArray[1];
        if(!findVertex(v1))
        {
            addVertex(v1);
        }
        if(!findVertex(v2))
        {
            addVertex(v2);
        }
        addEdge(v1, v2);
        
    }

    public void addVertex(String label)
    {
        DSAGraphVertex vertex;
        if(findVertex(label))
        {
            throw new IllegalArgumentException("no vertex");
        }
        else
        {
            vertex = new DSAGraphVertex(label);
            vertices.insertLast(vertex);
            vCount++;
        }
    }
    public void addEdge(String vertex1, String vertex2)
    {
        DSAGraphVertex v1, v2;
        if(findVertex(vertex1) && (findVertex(vertex2)))
        {
            v1 = conStrucVertex(vertex1);
            v2 = conStrucVertex(vertex2);
            v1.addEdge(v2);
        }
        eCount++;
    }
    public DSAGraphVertex conStrucVertex(String vertex)
    {
        DSAGraphVertex tempVertex = null;
        boolean exists = false;
        Iterator iter = vertices.iterator();
        if(vertex != null)
        {
            while(iter.hasNext() && !exists)
            {
                tempVertex = (DSAGraphVertex)(iter.next());
                if(tempVertex.equals(vertex))
                {
                    exists = true;
                }
            }
        }
        return tempVertex; 
    }
    public boolean findVertex(String vertex)
    {
        boolean found = false;
        DSAGraphVertex tempVertex = null;
        Iterator iter = vertices.iterator();
        while(iter.hasNext())
        {
            tempVertex = (DSAGraphVertex)(iter.next());
            if(tempVertex.equals(vertex))
            {
                found = true;
            }
        }
        return found; 
    }
    //ACCESSORS
    public int getVertexCount()
    {
        return vCount;
    }

    public int getEdgeCount()
    {
        return eCount;
    }
    
    //add more stufsafasd
    public DSAGraphVertex getVertex(String label)
    {
        DSAGraphVertex newVertex = null;
        DSAGraphVertex tempVertex = null;
    
        Iterator iter = vertices.iterator();
        while(iter.hasNext())
        {
            newVertex = (DSAGraphVertex)(iter.next());
            if(newVertex.getLabel().equals(label))
            {
                tempVertex = newVertex;
            }
        }
        return tempVertex;
    }
    
    public DSALinkedList getAdjacent(DSAGraphVertex vertex)
    {
        return vertex.getAdjacent();
    }

    public boolean isAdjacent(DSAGraphVertex vertex1, DSAGraphVertex vertex2)
    {
        boolean boolVertex = false;
        DSAGraphVertex tempVertex = null;
        Iterator iter = vertices.iterator();
        while(iter.hasNext())
        {
            tempVertex = (DSAGraphVertex)(iter.next());
            if(vertex1.equals(vertex2))
            {
                  boolVertex = true; 
            }
        }
        return boolVertex;
    }
    
    public String displayList()
    {
        String list = "";
        for(Object v : vertices)
        {
            list += ((DSAGraphVertex)v).toString()+"\n";
        }
        return list;
    }

    public void displayMatrix()
    {
        int[][] matrix;
        Iterator iter = vertices.iterator();
        for(Object v : vertices)
        {
            
        }
            
            
    }

    public void depthFirstSearch()
    {


    }
    public void breadthFirstSearch()
    {
    }

}
