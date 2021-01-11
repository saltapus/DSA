import java.util.*;
import java.io.*;
/**************************
* AUTHOR: Anthony Cameron *
* PROGRAM: Stocks         *
* DATE: 27/02/2019        *
***************************/

public class StocksClass implements Serializable  

{
    //CONSTANTS
    public static final int MIN_INT = 0;
    public static final double MIN_REAL = 0.0;

    //private classfields
    private String cST; //Comma separated ticker
    private int date, volume;
    private double open, high, low, close;

    //CONSTRUCTORS                                                              
    /***************************************************************************
    * DEFAULT CONSTRUCTOR                                                       
    * IMPORT: none                                                              
    * EXPORT: address of new StockClass object                                  
    * ASSERTION: sets appropriate data                      
    ****************************************************************************/
    
    public StocksClass()
    {
        cST = "ABS";
        date = 0;
        open = 0.0;
        high = 0.0;
        low = 0.0;
        close = 0.0;
        volume = 1;
    }
    /***************************************************************************
     * ALTERNATE CONSTRUCTOR                                                     
     * IMPORT: (String) inCST, (integer) inDate, (REAL) inOpen, (REAL) inHigh,
     *               (REAL) inLow, (REAL) inClose, (integer) inVolume
     * EXPORT: address of new Stock object                                  
     * ASSERTION: Creates the object if the imports are valid and FAILS otherwise
     * **************************************************************************/

    public StocksClass( String inCST, int inDate, double inOpen, double inHigh,
                        double inLow, double inClose, int inVolume)
    {
        setCST(inCST);
        setDate(inDate);
        setOpen(inOpen);
        setHigh(inHigh);
        setLow(inLow);
        setClose(inClose);
        setVolume(inVolume);
    }

//COPY CONSTRUCTOR    
    public StocksClass(StocksClass inStock)
    {
        cST = inStock.getCST();
        date = inStock.getDate();
        open = inStock.getOpen();
        high = inStock.getHigh();
        low = inStock.getLow();
        close = inStock.getClose();
        volume = inStock.getVolume();
    }
//MUTATORS
    /***************************************************************************
    * SUBMODULE: setCST                                                        
    * IMPORT: inCST (String)                                                   
    * EXPORT: none                                                              
    * ASSERTION: sets name to inCST                                            
    * **************************************************************************/    
    public void setCST(String inCST)
    {
        if (validateCST(inCST))
        {
            cST = inCST;
        }
        else
        {
            throw new IllegalArgumentException("Error: Invalid Ticker");
        }
    }    
//SET DATE    
    public void setDate(int inDate)
    {
        if (validateDate(inDate))
        {
            date = inDate;
        }
        else
        {
            throw new IllegalArgumentException("Error: Invalid Date");
        }
    }    

//SET OPEN
    public void setOpen(double inOpen)
    {
        if (validateOpen(inOpen))
        {
            open = inOpen;
        }
        else
        {
            throw new IllegalArgumentException("Error: Invalid Open");
        }
    }

//SET HIGH
    public void setHigh(double inHigh)
    {
        if (validateHigh(inHigh))
        {
            high = inHigh;
        }
        else
        {
            throw new IllegalArgumentException("Error: Invalid High");
        }
    }
    
//SET LOW
    public void setLow(double inLow)
    {
        if (validateLow(inLow))
        {
            low = inLow;
        }
        else
        {
            throw new IllegalArgumentException("Error: Invalid Low");
        }
    }

//SET CLOSE
    public void setClose(double inClose)
    {
        if (validateClose(inClose))
        {
            close = inClose;
        }
        else
        {
            throw new IllegalArgumentException("Error: Invalid Close");
        }
    }

//SET VOLUME    
    public void setVolume(int inVolume)
    {
        if (validateVolume(inVolume))
        {
            volume = inVolume;
        }
        else
        {
            throw new IllegalArgumentException("Error: Invalid Volume");
        }
    }

//ACCESSORS
    public String getCST()
    {
        return cST;
    }
    
    public int getDate()
    {
        return date;
    }
    
    public double getOpen()
    {
        return open;
    }

    public double getHigh()
    {
        return high;
    }

    public double getLow()
    {
        return low;
    }
    
    public double getClose()
    {
        return close;
    }

    public int getVolume()
    {
        return volume;
    }

//EQUALS
    /***************************************************************************
     * SUBMODULE: isEquals                                                       
     * IMPORT: inObj(object)                                                     
     * EXPORT: isEquals                                                          
     * ASSERTION: two Stocks are interchangable if they have the same values     
     * **************************************************************************/
    public boolean equals(Object inObj)
    {
        boolean isEquals = false;
        if (inObj instanceof StocksClass)
        {
            StocksClass inStockClass = (StocksClass)inObj;
            isEquals = cST.equals(inStockClass.getCST()) &&
                    date == (inStockClass.getDate()) &&
                    open == (inStockClass.getOpen()) &&
                    high == (inStockClass.getHigh()) &&
                    low == (inStockClass.getLow()) &&
                    close == (inStockClass.getClose()) &&
                    volume == (inStockClass.getVolume());
        }
        return isEquals;
    }
//TO STRING
    public String toString()
    {
        return ("TICKER:" + cST + " date: " + date + "open: " + open + "high: "
                + high + "low: " + low + "close: " + close + "volume: " + volume);
    }
//CLONE METHOD
    public StocksClass clone()
    {
        StocksClass cloneStocks;
        cloneStocks = new StocksClass(this);
        
        return cloneStocks;
    }
//PRIVATE METHODS
    private boolean validateCST(String inCST)
    {
        boolean valid = true;
        int cST = inCST.length();
        if (inCST.equals(null)||("".equals(inCST)||(cST != 3)))
        {
            valid = false;
        }
        return valid;
    }   
    
    private boolean validateDate(int inDate)
    {
        boolean valid = true;
        int y = inDate/10000;
        int m = ((inDate/100)%100);
        int d = inDate%100;

        if ((y <= 1900) && (m <= 0) && (m > 12) &&//HEY FIX UP YOUR DAYS include
                                                //feb = 28 etc
           (d <=0) && (d > 31));
        {
            valid = true;
        }
        return valid;
    }   
        
    private boolean validateOpen(double inOpen)
    {
        return (inOpen >= MIN_REAL);
    }
   
    private boolean validateHigh(double inHigh)
    {
        return ((inHigh >= MIN_REAL) && (inHigh > getLow()));
    }   

    private boolean validateLow(double inLow)
    {
        return ((inLow >= MIN_REAL) && (inLow < getHigh()));
    }
   
    private boolean validateClose(double inClose)
    {
        return (inClose >= MIN_REAL);
    }
   
    private boolean validateVolume(int inVolume)
    {
        return (inVolume >= MIN_INT );
    }   
}
