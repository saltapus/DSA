/****************************
 * Program: Stock_Exchange  *
 * Author: Anthony Cameron  *
 * Date Created: 02/03/2019 *
 * Date Modified: 
 * **************************/

import java.util.*;
import java.io.*;
import java.text.*;

public class StockExchange implements Serializable
{

    //CONSTANTS
    public static final int MIN_SIZE = 0;
    public static final int MAX_SIZE = 10000000;

    //CLASSFILEDS
    private StocksClass[] stocks;
    private String cST;
    private double open, close, high, low;
    private int date, volume, numStocks;

    //CONSTRUCTOR
    public StockExchange(String file, int num)
    {
        numStocks = 0;
        stocks = new StocksClass[MAX_SIZE];
        if (num == 1)
        {
            fileInput(file);
        }
        else
        {
            load(file);
        }   
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
                    addStock(processStock(line));
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

    public void save(StockExchange stocks, String inFilename)
    {
    //    String inFilename ="breadseed";
        FileOutputStream fileStrm;
        ObjectOutputStream objStrm;
        
        try
        {
            fileStrm = new FileOutputStream(inFilename);
            System.out.println("tttttttttttttttttttt");
            objStrm = new ObjectOutputStream(fileStrm);
            System.out.println("tttttttttttttttttttt");
            objStrm.writeObject(stocks);

            System.out.println("tttttttttttttttttttt");
            objStrm.close();
        }
        catch (Exception e)
        {
            throw new IllegalArgumentException("Unable to save object to file");
        }
    }
    
    //Proccess methods
    public StocksClass processStock(String line)
    {
        String [] lineArray = line.split(",");
        cST = lineArray[0];
        date = Integer.parseInt(lineArray[1]);
        open = Double.parseDouble(lineArray[2]);
        high = Double.parseDouble(lineArray[3]);
        low = Double.parseDouble(lineArray[4]);
        close = Double.parseDouble(lineArray[5]);
        volume = Integer.parseInt(lineArray[6]);
    
        StocksClass stocks = new StocksClass(cST, date, open, high, low, close,
                                            volume);
        System.out.println("Processing your stuff " + stocks.toString());
        return stocks;
    }

    public void displayAll(StockExchange inStocks)
    {
        int i;
        for (i = 0; i < numStocks; i++)
        {
            try
            {
                System.out.println(stocks[i]);
            }
            catch (ArrayIndexOutOfBoundsException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }

    public void writeFile(StockExchange inStocks, String newFile)
    {
        FileOutputStream fileStrm = null;
        PrintWriter pW;
        Scanner sc = new Scanner(System.in);
        try
        {
            fileStrm = new FileOutputStream(newFile);
            pW = new PrintWriter(fileStrm);
            int i;
            for (i = 0; i < numStocks; i++)
            {
                try
                {
                    pW.println(stocks[i]);
                }
                catch (ArrayIndexOutOfBoundsException e)
                {
                    System.out.println(e.getMessage());
                }
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
            System.out.println("Error: file in processing, " + e.getMessage());
        }
    }
    
    public StocksClass[] getStocks()
    {
        return stocks;
    }

//Stores object into array
    public void addStock(StocksClass inStocks)
    {
        try
        {
            stocks[numStocks] = inStocks;
            numStocks++;
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Size Capacity reached" + e.getMessage());
        }
    }
}
