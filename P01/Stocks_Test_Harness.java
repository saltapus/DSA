import java.util.*;

public class Stocks_Test_Harness
{
    public static void main(String[]args)
    {
        try
        {
            StocksClass[] stocks = new StocksClass[4];
            
            //object creation
            stocks[0] = new StocksClass();
            stocks[1] = new StocksClass("14d", 20190218, 0.37, 0.38, 0.365,
                                        0.365, 401600);
            stocks[2] = new StocksClass(stocks[1]);
            stocks[3] = stocks[1].clone();
        
            //print out created objs
            System.out.println("Constructors tests: ");
            for(int i = 0; i < stocks.length; i++)
            {
                System.out.println("stock[" + i + "] " + stocks[i].toString());
            }
            
            //equal
            System.out.println("\nEQUALS METHOD TESTS:");
            System.out.println("Equals (object) expected TRUE: " + stocks[1].equals(stocks[3]));
            System.out.println("Equals (object) expected FALSE: " + stocks[0].equals(stocks[3]));

            //getters and setter
            System.out.println("\n Getter and setter:");
            stocks[0].setCST(stocks[1].getCST());
            System.out.println(stocks[0].getCST() + " = " + stocks[1].getCST());
            
            stocks[0].setDate(stocks[1].getDate());
            System.out.println(stocks[0].getDate() + " = " + stocks[1].getDate());

            stocks[0].setOpen(stocks[1].getOpen());
            System.out.println(stocks[0].getOpen() + " = " + stocks[1].getOpen());

            stocks[0].setHigh(stocks[1].getHigh());
            System.out.println(stocks[0].getHigh() + " = " + stocks[1].getHigh());
        
            stocks[0].setLow(stocks[1].getLow());
            System.out.println(stocks[0].getLow() + " = " + stocks[1].getLow());
        
            stocks[0].setClose(stocks[1].getClose());
            System.out.println(stocks[0].getClose() + " = " + stocks[1].getClose());

            stocks[0].setVolume(stocks[1].getVolume());
            System.out.println(stocks[0].getVolume() + " = " + stocks[1].getVolume());
        }
        catch(IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
    }
}

