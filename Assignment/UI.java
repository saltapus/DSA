import java.util.*;
import java.io.*;

public class UI implements Serializable  
{
    /**************************************
    * obtained from Anthony Cameron
    * Used in prac 01
    * Date Accessed 23/05/2019
    * *************************************/
    public static void bST()
    {
        BinarySearchTree searchTree = null;
        int choice;
        String file, fileName, key;
        BinarySearchTree bST = null;
        TreeIo tree = null;       
        Scanner sc = new Scanner(System.in);
        System.out.println("MENU");

        choice = 0;
        try
        {
            do
            {
                System.out.println("1 = Load new data \n"
                                    +"2 = Tree find \n"
                                    +"3 = Tree insert \n"
                                    +"4 = Tree delete  \n"
                                    +"5 = Tree statistics\n"
                                    +"6 = display Tree\n"
                                    +"7 = Save tree\n"
                                    +"0 = Exit");
                choice = sc.nextInt();
                switch(choice)
                {
                    case 1:
                        try
                        {
                            System.out.println("choice 1 = read as file, 2 = read as serilised"
                                                + " 3 = load binary");
                            int option = sc.nextInt();
                            if(option == 1)
                            {
                                if(bST == null)
                                {
                                    bST = readFileBST();
                                }
                                else                                                
                                {                                                   
                                    System.out.println("File has been already read");
                                    System.out.println("do you wish to overwrite? y//n");
                                    choice = sc.next().charAt(0);                   
                                    if ((choice == 'y') || (choice == 'Y'))         
                                    {                                               
                                        bST = null;                              
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
                            else if(option ==2)
                            {
                                if(bST == null)
                                {
                                    file = inputString("fileName");            
                                    tree.loadBST(file);
                                }
                                else                                                
                                {                                                   
                                    System.out.println("File has been already read");
                                    System.out.println("do you wish to overwrite? y//n");
                                    choice = sc.next().charAt(0);                   
                                    if ((choice == 'y') || (choice == 'Y'))         
                                    {                                               
                                        bST = null;                              
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
                            else if(option ==3)
                            {
                                if(bST == null)
                                {
                                    file = inputString("fileName");            
                                    tree.open(file);
                                }
                                else                                                
                                {                                                   
                                    System.out.println("File has been already read");
                                    System.out.println("do you wish to overwrite? y//n");
                                    choice = sc.next().charAt(0);                   
                                    if ((choice == 'y') || (choice == 'Y'))         
                                    {                                               
                                        bST = null;                              
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
                        file = inputString("Ticker ID");            
                        Object item = bST.find(file);   
                        System.out.println(item);                
                        break;
                    case 3:
                        key = inputString("ticker value must be unique");
                        StocksClass stock = createStock(key);
                        bST.insert(key, stock);                   
                        break;
                    case 4:
                        key = inputString("ticker value to delete");
                        bST.delete(key);                   
                        break;
                    case 5:
                        int height = bST.height();
                        int size = bST.size();
                        double balance = bST.balance();
                        System.out.println("height :" +height);
                        System.out.println("size: " + size);
                        System.out.println("balance: "+balance);
                        break;
                    case 6:
                        System.out.println("Displaying");
                        bST.inOrder();
                        break;
                    case 7:
                        System.out.println("choice 1 = save as txt, 2 = save as serial"
                                            + " 3 = save as binary");
                        int option = sc.nextInt();
                        if(option == 1)
                        {
                            fileName = inputString("filename");
                            tree.writeBST(bST, fileName);
                        }
                        else if(option ==2)
                        {
                            fileName = inputString("filename");
                            tree.saveSerBST(bST, fileName);
                        }
                        else if(option ==3)
                        {
                            fileName = inputString("filename");
                            tree.saveBST(bST, fileName);
                        }
                        break;

                    default:
                        break;
                }
            }while (choice != 0);
        }
        catch(Exception e)
        {
            System.out.println("invalid input " + e.getMessage());
        }
    }
    
    public static void BT()
    {
        BinarySearchTree searchTree = null;
        int choice;
        String file, fileName, key;
        BTree bT = null;
        TreeIo tree = null;       
        Scanner sc = new Scanner(System.in);
        System.out.println("MENU");

        choice = 0;
        try
        {
            do
            {
                System.out.println("1 = Load new data \n"
                                    +"2 = Tree find \n"
                                    +"3 = Tree insert \n"
                                    +"4 = Tree delete  \n"
                                    +"5 = Tree statistics\n"
                                    +"6 = display Tree\n"
                                    +"7 = Save tree\n"
                                    +"0 = Exit");
                choice = sc.nextInt();
                switch(choice)
                {
                    case 1:
                        try
                        {
                            System.out.println("choice 1 = read as file, 2 = read as serilised"
                                                + " 3 = load binary");
                            int option = sc.nextInt();
                            if(option == 1)
                            {
                                if(bT == null)
                                {
                                    bT = readFileBT();
                                }
                                else                                                
                                {                                                   
                                    System.out.println("File has been already read");
                                    System.out.println("do you wish to overwrite? y//n");
                                    choice = sc.next().charAt(0);                   
                                    if ((choice == 'y') || (choice == 'Y'))         
                                    {                                               
                                        bT = null;                              
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
                            else if(option ==2)
                            {
                                if(bT == null)
                                {
                                    file = inputString("fileName");            
                                    tree.loadBT(file);
                                }
                                else                                                
                                {                                                   
                                    System.out.println("File has been already read");
                                    System.out.println("do you wish to overwrite? y//n");
                                    choice = sc.next().charAt(0);                   
                                    if ((choice == 'y') || (choice == 'Y'))         
                                    {                                               
                                        bT = null;                              
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
                            else if(option ==3)
                            {
                                if(bT == null)
                                {
                                    file = inputString("fileName");            
                                    tree.open(file);
                                }
                                else                                                
                                {                                                   
                                    System.out.println("File has been already read");
                                    System.out.println("do you wish to overwrite? y//n");
                                    choice = sc.next().charAt(0);                   
                                    if ((choice == 'y') || (choice == 'Y'))         
                                    {                                               
                                        bT = null;                              
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
                        file = inputString("Ticker ID");            
                        Object item = bT.search(file);   
                        System.out.println(item);                
                        break;
                    case 3:
                        key = inputString("ticker value must be unique");
                        StocksClass stock = createStock(key);
                        bT.insert(key, stock);                   
                        break;
                    case 4:
                        key = inputString("ticker value to delete");
                        bT.delete(key);                   
                        break;
                    case 5:
                        int height = bT.height();
                        int size = bT.size();
                        double balance = bT.balance();
                        System.out.println("height :" +height);
                        System.out.println("size: " + size);
                        System.out.println("balance: "+balance);
                        break;
                    case 6:
                        System.out.println("Displaying");
                        bT.displayVal();
                        break;
                    case 7:
                        System.out.println("choice 1 = save as txt, 2 = save as serial"
                                            + " 3 = save as binary");
                        int option = sc.nextInt();
                        if(option == 1)
                        {
                            fileName = inputString("filename");
                            tree.writeBT(bT, fileName);
                        }
                        else if(option ==2)
                        {
                            fileName = inputString("filename");
                            tree.saveSerBT(bT, fileName);
                        }
                        else if(option ==3)
                        {
                            fileName = inputString("filename");
                            tree.saveBT(bT, fileName);
                        }
                        break;

                    default:
                        break;
                }
            }while (choice != 0);
        }
        catch(Exception e)
        {
            System.out.println("invalid input " + e.getMessage());
        }
    }

    public static void TFT()
    {
        BinarySearchTree searchTree = null;
        int choice;
        String file, fileName, key;
        TwoFourTree tFT = null;
        TreeIo tree = null;       
        Scanner sc = new Scanner(System.in);
        System.out.println("MENU");

        choice = 0;
        try
        {
            do
            {
                System.out.println("1 = Load new data \n"
                                    +"2 = Tree find \n"
                                    +"3 = Tree insert \n"
                                    +"4 = Tree delete  \n"
                                    +"5 = Tree statistics\n"
                                    +"6 = display Tree\n"
                                    +"7 = Save tree\n"
                                    +"0 = Exit");
                choice = sc.nextInt();
                switch(choice)
                {
                    case 1:
                        try
                        {
                            System.out.println("choice 1 = read as file, 2 = read as serilised"
                                                + " 3 = load binary");
                            int option = sc.nextInt();
                            if(option == 1)
                            {
                                if(tFT == null)
                                {
                                    tFT = readFileTFT();
                                }
                                else                                                
                                {                                                   
                                    System.out.println("File has been already read");
                                    System.out.println("do you wish to overwrite? y//n");
                                    choice = sc.next().charAt(0);                   
                                    if ((choice == 'y') || (choice == 'Y'))         
                                    {                                               
                                        tFT = null;                              
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
                            else if(option ==2)
                            {
                                if(tFT == null)
                                {
                                    file = inputString("fileName");            
                                    tree.loadTFT(file);
                                }
                                else                                                
                                {                                                   
                                    System.out.println("File has been already read");
                                    System.out.println("do you wish to overwrite? y//n");
                                    choice = sc.next().charAt(0);                   
                                    if ((choice == 'y') || (choice == 'Y'))         
                                    {                                               
                                        tFT = null;                              
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
                            else if(option ==3)
                            {
                                if(tFT == null)
                                {
                                    file = inputString("fileName");            
                                    tree.open(file);
                                }
                                else                                                
                                {                                                   
                                    System.out.println("File has been already read");
                                    System.out.println("do you wish to overwrite? y//n");
                                    choice = sc.next().charAt(0);                   
                                    if ((choice == 'y') || (choice == 'Y'))         
                                    {                                               
                                        tFT = null;                              
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
                        file = inputString("Ticker ID");            
                        Object item = tFT.search(file);   
                        System.out.println(item);                
                        break;
                    case 3:
                        key = inputString("ticker value must be unique");
                        StocksClass stock = createStock(key);
                        tFT.insert(key, stock);                   
                        break;
                    case 4:
                        key = inputString("ticker value to delete");
                        tFT.delete(key);                   
                        break;
                    case 5:
                        int height = tFT.height();
                        int size = tFT.size();
                        double balance = tFT.balance();
                        System.out.println("height :" +height);
                        System.out.println("size: " + size);
                        System.out.println("balance: "+balance);
                        break;
                    case 6:
                        System.out.println("Displaying");
                        tFT.displayVal();
                        break;
                    case 7:
                        System.out.println("choice 1 = save as txt, 2 = save as serial"
                                            + " 3 = save as binary");
                        int option = sc.nextInt();
                        if(option == 1)
                        {
                            fileName = inputString("filename");
                            tree.writeTFT(tFT, fileName);
                        }
                        else if(option ==2)
                        {
                            fileName = inputString("filename");
                            tree.saveSerTFT(tFT, fileName);
                        }
                        else if(option ==3)
                        {
                            fileName = inputString("filename");
                            tree.saveTFT(tFT, fileName);
                        }
                        break;

                    default:
                        break;
                }
            }while (choice != 0);
        }
        catch(Exception e)
        {
            System.out.println("invalid input " + e.getMessage());
        }
    }


    //input String method   
    public static String inputString(String prompt)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter " + prompt);
        String value = sc.next();
        return value;
    }
    
    public static int inputInt(String prompt)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter " + prompt);
        int value = sc.nextInt();
        return value;
    }
    
    public static double inputReal(String prompt)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter " + prompt);
        double value = sc.nextDouble();
        return value;
    }
    
    public static StocksClass createStock(String tick)
    {

        int date = inputInt("Enter Date");            
        double open = inputReal("Enter open");            
        double high = inputReal("Enter high");            
        double low = inputReal("Enter low");            
        double close = inputReal("Enter close");            
        int vol = inputInt("Enter Volume");
        System.out.println("Constructing stock");
        StocksClass stocks = new StocksClass(tick, date, open, high, low, close,
                                                vol);
        return stocks;
    }
    //creates an object of tree and passes it into tree_io importing file name  
    public static TwoFourTree readFileTFT()
    {
        String prompt = (" CSV file  Name ");
        String file = inputString(prompt);            
        TwoFourTree tree = new TwoFourTree(file);
        return tree;
    }
    //creates an object of tree and passes it into tree_io importing file name  
    public static BTree readFileBT()
    {
        String prompt = (" CSV file  Name ");
        String file = inputString(prompt);            
        int deg = inputInt(" Enter degrees ");
        BTree tree = new BTree(file, deg);
        return tree;
    }

    //creates an object of tree and passes it into tree_io importing file name  
    public static BinarySearchTree readFileBST()
    {
        String prompt = (" CSV file  Name ");
        String file = inputString(prompt);            
        BinarySearchTree tree = new BinarySearchTree(file);
        return tree;
    }
}

