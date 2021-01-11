import java.io.*;
import java.util.*;

public class TreeIo implements Serializable 
{
    /***************************************************
    * obtained from curtin slides
    * File IO lecture 1
    * Date Accessed(23/05/2019)
    * **************************************************/
    /**************************************************************************
    * WRITE STUFF
    * *************************************************************************/ 
    public static void writeBST(BinarySearchTree tree, String filename)
    {
        StocksClass stock = null;
        FileOutputStream fileStrm = null;
        PrintWriter pW;
        DSAQueue queue = tree.store();
        try 
        {
            fileStrm = new FileOutputStream(filename);
            pW = new PrintWriter(fileStrm);
            while (!queue.isEmpty())
            {
                stock = (StocksClass)queue.dequeue(); 
                pW.println("===================================================");
                pW.println("NODE");
                pW.println("===================================================");
                pW.print(stock.getCST() + " ");
                pW.print(stock.getDate() + " ");
                pW.print(stock.getOpen() + " ");
                pW.print(stock.getHigh() + " ");
                pW.print(stock.getLow() + " ");
                pW.print(stock.getClose() + " ");
                pW.println(stock.getVolume() + " ");           

            }
            pW.close();
        }
        catch (IOException e)
        { 
            if (fileStrm != null) 
            { 
                try 
                { 
                    fileStrm.close();
                }
                catch (IOException ex2) 
                {
                } 
            }
            System.out.println("Error in file processing: " + e.getMessage());
        }
    } 
    
    public static void writeBT(BTree tree, String filename)
    {
        StocksClass stock = null;
        FileOutputStream fileStrm = null;
        PrintWriter pW;
        DSAQueue queue = tree.store();
        try 
        {
            fileStrm = new FileOutputStream(filename);
            pW = new PrintWriter(fileStrm);
            while (!queue.isEmpty())
            {
                stock = (StocksClass)queue.dequeue(); 
                pW.println("===================================================");
                pW.println("NODE");
                pW.println("===================================================");
                pW.print(stock.getCST() + " ");
                pW.print(stock.getDate() + " ");
                pW.print(stock.getOpen() + " ");
                pW.print(stock.getHigh() + " ");
                pW.print(stock.getLow() + " ");
                pW.print(stock.getClose() + " ");
                pW.println(stock.getVolume() + " ");           

            }
            pW.close();
        }
        catch (IOException e)
        { 
            if (fileStrm != null) 
            { 
                try 
                { 
                    fileStrm.close();
                }
                catch (IOException ex2) 
                {
                } 
            }
            System.out.println("Error in file processing: " + e.getMessage());
        }
    } 
    
    public static void writeTFT(TwoFourTree tree, String filename)
    {
        StocksClass stock = null;
        FileOutputStream fileStrm = null;
        PrintWriter pW;
        DSAQueue queue = tree.store();
        try 
        {
            fileStrm = new FileOutputStream(filename);
            pW = new PrintWriter(fileStrm);
            while (!queue.isEmpty())
            {
                stock = (StocksClass)queue.dequeue(); 
                pW.println("===================================================");
                pW.println("NODE");
                pW.println("===================================================");
                pW.print(stock.getCST() + " ");
                pW.print(stock.getDate() + " ");
                pW.print(stock.getOpen() + " ");
                pW.print(stock.getHigh() + " ");
                pW.print(stock.getLow() + " ");
                pW.print(stock.getClose() + " ");
                pW.println(stock.getVolume() + " ");           

            }
            pW.close();
        }
        catch (IOException e)
        { 
            if (fileStrm != null) 
            { 
                try 
                { 
                    fileStrm.close();
                }
                catch (IOException ex2) 
                {
                } 
            }
            System.out.println("Error in file processing: " + e.getMessage());
        }
    } 
    


    /**************************************************************************
    * BINARY READ
    * *************************************************************************/ 
    public static void open(String filename)
    {
        FileInputStream fileStrm = null;
        DataInputStream dataStrm = null;
        try 
        {
            fileStrm = new FileInputStream(filename);
            dataStrm = new DataInputStream(fileStrm);
            String ticker = dataStrm.readUTF(); 
            int date = dataStrm.readInt();
            double open = dataStrm.readDouble();
            double high = dataStrm.readDouble();
            double low = dataStrm.readDouble();
            double close = dataStrm.readDouble();
            int volume = dataStrm.readInt();
            fileStrm.close();
        }
        catch (IOException e)
        { 
            if (fileStrm != null) 
            { 
                try 
                { 
                    fileStrm.close();
                }
                catch (IOException ex2) 
                {
                } 
            }
            System.out.println("Error in file processing: " + e.getMessage());
        }
    } 
    
    /**************************************************************************
    * BINARY write
    * *************************************************************************/ 
    public static void saveBST(BinarySearchTree tree, String filename)
    {
        StocksClass stock = null;
        FileOutputStream fileStrm = null;
        DataOutputStream dataStrm = null;
        DSAQueue queue = tree.store();

        try 
        {
            fileStrm = new FileOutputStream(filename);
            dataStrm = new DataOutputStream(fileStrm);
            
            while (!queue.isEmpty())
            {
                stock = (StocksClass)queue.dequeue(); 
                dataStrm.writeUTF(stock.getCST());
                dataStrm.writeInt(stock.getDate());
                dataStrm.writeDouble(stock.getOpen());
                dataStrm.writeDouble(stock.getHigh());
                dataStrm.writeDouble(stock.getLow());
                dataStrm.writeDouble(stock.getClose());
                dataStrm.writeInt(stock.getVolume());           
            }
            fileStrm.close();
        }
        catch (IOException e)
        { 
            if (fileStrm != null) 
            { 
                try 
                { 
                    fileStrm.close();
                }
                catch (IOException ex2) 
                {
                }
            }
            System.out.println("Error in file processing: " + e.getMessage()); 
        }
    } 
    
    public static void saveBT(BTree tree, String filename)
    {
        StocksClass stock = null;
        FileOutputStream fileStrm = null;
        DataOutputStream dataStrm = null;
        DSAQueue queue = tree.store();

        try 
        {
            fileStrm = new FileOutputStream(filename);
            dataStrm = new DataOutputStream(fileStrm);
            
            while (!queue.isEmpty())
            {
                stock = (StocksClass)queue.dequeue(); 
                dataStrm.writeUTF(stock.getCST());
                dataStrm.writeInt(stock.getDate());
                dataStrm.writeDouble(stock.getOpen());
                dataStrm.writeDouble(stock.getHigh());
                dataStrm.writeDouble(stock.getLow());
                dataStrm.writeDouble(stock.getClose());
                dataStrm.writeInt(stock.getVolume());           
            }
            fileStrm.close();
        }
        catch (IOException e)
        { 
            if (fileStrm != null) 
            { 
                try 
                { 
                    fileStrm.close();
                }
                catch (IOException ex2) 
                {
                }
            }
            System.out.println("Error in file processing: " + e.getMessage()); 
        }
    } 
    
    public static void saveTFT(TwoFourTree tree, String filename)
    {
        StocksClass stock = null;
        FileOutputStream fileStrm = null;
        DataOutputStream dataStrm = null;
        DSAQueue queue = tree.store();

        try 
        {
            fileStrm = new FileOutputStream(filename);
            dataStrm = new DataOutputStream(fileStrm);
            
            while (!queue.isEmpty())
            {
                stock = (StocksClass)queue.dequeue(); 
                dataStrm.writeUTF(stock.getCST());
                dataStrm.writeInt(stock.getDate());
                dataStrm.writeDouble(stock.getOpen());
                dataStrm.writeDouble(stock.getHigh());
                dataStrm.writeDouble(stock.getLow());
                dataStrm.writeDouble(stock.getClose());
                dataStrm.writeInt(stock.getVolume());           
            }
            fileStrm.close();
        }
        catch (IOException e)
        { 
            if (fileStrm != null) 
            { 
                try 
                { 
                    fileStrm.close();
                }
                catch (IOException ex2) 
                {
                }
            }
            System.out.println("Error in file processing: " + e.getMessage()); 
        }
    } 
    
    /**************************************************************************
    * SERIALISE READ
    * *************************************************************************/ 
    public static BinarySearchTree loadBST(String inFilename) throws IllegalArgumentException 
    {                                                                           
        FileInputStream fileStrm = null;                                               
        ObjectInputStream objStrm = null;                                              
        BinarySearchTree inObj = null;                                               
        try                                                                     
        {                                                                       
            fileStrm = new FileInputStream(inFilename);                         
            objStrm = new ObjectInputStream(fileStrm);                          
            inObj = (BinarySearchTree)objStrm.readObject();                          
            objStrm.close();                                                    
        }                                                                       
        catch (ClassNotFoundException e)                                        
        {                                                                       
            System.out.println("Class ShareC;ass not found" + e.getMessage());  
        }                                                                       
        catch (Exception e)                                                     
        {                                                                       
            throw new IllegalArgumentException("Unable to load object from file");
        }                                                                       
                                                                                
        return inObj;                                                           
    } 
    
    public static BTree loadBT(String inFilename) throws IllegalArgumentException 
    {                                                                           
        FileInputStream fileStrm = null;                                               
        ObjectInputStream objStrm = null;                                              
        BTree inObj = null;                                               
        try                                                                     
        {                                                                       
            fileStrm = new FileInputStream(inFilename);                         
            objStrm = new ObjectInputStream(fileStrm);                          
            inObj = (BTree)objStrm.readObject();                          
            objStrm.close();                                                    
        }                                                                       
        catch (ClassNotFoundException e)                                        
        {                                                                       
            System.out.println("Class ShareC;ass not found" + e.getMessage());  
        }                                                                       
        catch (Exception e)                                                     
        {                                                                       
            throw new IllegalArgumentException("Unable to load object from file");
        }                                                                       
                                                                                
        return inObj;                                                           
    } 
    
    public static TwoFourTree loadTFT(String inFilename) throws IllegalArgumentException 
    {                                                                           
        FileInputStream fileStrm = null;                                               
        ObjectInputStream objStrm = null;                                              
        TwoFourTree inObj = null;                                               
        try                                                                     
        {                                                                       
            fileStrm = new FileInputStream(inFilename);                         
            objStrm = new ObjectInputStream(fileStrm);                          
            inObj = (TwoFourTree)objStrm.readObject();                          
            objStrm.close();                                                    
        }                                                                       
        catch (ClassNotFoundException e)                                        
        {                                                                       
            System.out.println("Class ShareC;ass not found" + e.getMessage());  
        }                                                                       
        catch (Exception e)                                                     
        {                                                                       
            throw new IllegalArgumentException("Unable to load object from file");
        }                                                                       
                                                                                
        return inObj;                                                           
    } 



    /**************************************************************************
    * SERIALISE save
    * *************************************************************************/ 

    public static void saveSerBST(BinarySearchTree objToSave, String filename)
    {
        FileOutputStream fileStrm = null;
        ObjectOutputStream objStrm = null;
        try 
        {
            fileStrm = new FileOutputStream(filename);
            objStrm = new ObjectOutputStream(fileStrm);
            objStrm.writeObject(objToSave);
            objStrm.close(); 
        }
        catch (Exception e) 
        {
            throw new IllegalArgumentException("Unable to save object to file");
        }
    }
    
    public static void saveSerBT(BTree objToSave, String filename)
    {
        FileOutputStream fileStrm = null;
        ObjectOutputStream objStrm = null;
        try 
        {
            fileStrm = new FileOutputStream(filename);
            objStrm = new ObjectOutputStream(fileStrm);
            objStrm.writeObject(objToSave);
            objStrm.close(); 
        }
        catch (Exception e) 
        {
            throw new IllegalArgumentException("Unable to save object to file");
        }
    }
    
    public static void saveSerTFT(TwoFourTree objToSave, String filename)
    {
        FileOutputStream fileStrm = null;
        ObjectOutputStream objStrm = null;
        try 
        {
            fileStrm = new FileOutputStream(filename);
            objStrm = new ObjectOutputStream(fileStrm);
            objStrm.writeObject(objToSave);
            objStrm.close(); 
        }
        catch (Exception e) 
        {
            throw new IllegalArgumentException("Unable to save object to file");
        }
    }
} 

