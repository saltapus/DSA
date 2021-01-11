/****************************
 * Author: Anthony Cameron  *
 * Program: UserInterface   *
 * Date Created: 03/03/2019 *
 * Date Modified:           *
 * **************************/

import java.util.*;
public class UserInterface
{
    public static void menu()
    {
        Scanner sc = new Scanner(System.in);
        int choice;
        String file, fileName;
        StockExchange stocks = null;
        SerialiseStock share = null;

        choice = 0;
        do
        {
            try
            {
                System.out.println("1 = Read csv file \n"
                                   + "2 = Read serialised file #not yet implemented\n"
                                   + "3 = Display Data \n"
                                   + "4 = save csv file \n"
                                   + "5 = save serialised file #not yet impl\n"
                                   + "6 = exit");
                choice = sc.nextInt();
                switch(choice)
                {
                    case 1:
                        try
                        {
                            if (stocks == null)
                            {
                                stocks = readFile(stocks);
                            }
                            else
                            {
                                System.out.println("File has been already read");
                                System.out.println("do you wish to overwrite? y//n");
                                choice = sc.next().charAt(0);
                                if ((choice == 'y') || (choice == 'Y'))
                                {
                                    stocks = null;
                                }
                                else if ((choice == 'n') || (choice == 'N'))
                                {
                                    System.out.println("returning");
                                }
                                else
                                {
                                    System.out.println("Invalid input");
                                }
                            }
                        }
                        catch (NullPointerException e)
                        {
                            System.out.println("Error: Invalid file processing");
                        }
                        catch (InputMismatchException e)
                        {
                            sc.nextLine();
                            System.out.println("Invalid Input -case1" + e.getMessage());
                        //    choice = 1 -1;
                        }
                        break;
                    case 2:
                       // SerialiseStock.load();
                        try
                        {
                            if (share == null)
                            {
                                stocks = readSerial(stocks);
                                System.out.println("File has been Read");
                            }
                            else
                            {
                                System.out.println("File has been already read");
                                System.out.println("do you wish to overwrite? y//n");
                                choice = sc.next().charAt(0);
                                if ((choice == 'y') || (choice == 'Y'))
                                {
                                    share = null;
                                }
                                else if ((choice == 'n') || (choice == 'N'))
                                {
                                    System.out.println("returning");
                                }
                                else
                                {
                                    System.out.println("Invalid input");
                                }
                            }
                        }
                        catch (NullPointerException e)
                        {
                            System.out.println("Error: Invalid file processing");
                        }
                        catch (InputMismatchException e)
                        {
                            sc.nextLine();
                            System.out.println("Invalid Input -case1" + e.getMessage());
                        //    choice = 1 -1;
                        } 
                        break;
                    case 3:
                        stocks.displayAll(stocks);
                        break;
                    case 4:
                        file = stringInput("Save file as?");
                        stocks.writeFile(stocks, file);
                        break;
                    case 5:
                        file = stringInput("Save file as?");
                       // share.save(share, file);
                        stocks.save(stocks, file);
                        System.out.println("not yet implemented");
                        break;
                    case 6:
                        System.out.println("goooood byeeee");
                        break;
                    default:
                        System.out.println("Invalid input try 1-6");
                }            
            }
            catch (InputMismatchException e)
            {
                sc.nextLine();
                System.out.println("Invalid Input" + e.getMessage());
                choice = 1 -1;
            }
            catch (NullPointerException e)
            {
                System.out.println("Error: storage does no exist -SB MENU" 
                                        + e.getMessage());
            }
                
        }    
        while (choice != 6);
    }

    public static StockExchange readFile(StockExchange stocks)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter file name *20190218");
        String file = sc.next();
        int num = 1;
        stocks = new StockExchange(file, num);
        return stocks;
    }

    public static StockExchange readSerial(StockExchange stocks)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter file name *20190218");
        String file = sc.next();
        //share = new SerialiseStock(file);
        int num = 2;
        stocks = new StockExchange(file, num);
        return stocks;
    
    } 

    public static String stringInput(String prompt)
    {
        String StringInput;
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        StringInput = sc.nextLine();
        return StringInput;
    }
}

