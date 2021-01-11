
import java.util.*;
import java.io.*;
import java.text.*;

public class SerialiseStock implements Serializable
{

    //CONSTANTS
    public static final int MIN_SIZE = 0;
    public static final int MAX_SIZE = 10000000;

    //CLASSFILEDS
    private StocksClass stocks;
    private String cST;
    private double open, close, high, low;
    private int date, volume, numStocks;

    //CONSTRUCTOR
    public SerialiseStock(String file)
    {
        numStocks = 0;
        stocks = new StocksClass();//[MAX_SIZE];
        stocks = load(file);
    }

    
    private StocksClass load(String inFilename) throws IllegalArgumentException
    {
        System.out.println("tttttttttttttttttttt");
        FileInputStream fileStrm;
        ObjectInputStream objStrm;
        StocksClass inObj = null;
        try
        {
            fileStrm = new FileInputStream(inFilename);
            System.out.println("tttttttttttttttttttt");
            objStrm = new ObjectInputStream(fileStrm);
            System.out.println("tttttttttttttttttttt");
            inObj = (StocksClass)objStrm.readObject();
            System.out.println("tttttttttttttttttttt");
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
 
        System.out.println("tttttttttttttttttttt");
        return inObj;
    }

    public void save(SerialiseStock stocks, String inFilename)
    {
    //    String inFilename ="breadseed";
        FileOutputStream fileStrm;
        ObjectOutputStream objStrm;
        
        try
        {
            fileStrm = new FileOutputStream(inFilename);
            System.out.println("tttttttttttttttttttt");
            objStrm = new ObjectOutputStream(fileStrm);
            objStrm.writeObject(stocks);

            System.out.println("tttttttttttttttttttt");
            objStrm.close();
        }
        catch (Exception e)
        {
            throw new IllegalArgumentException("Unable to save object to file");
        }
    }
}
    
