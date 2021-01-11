/****************************
 * Program: ShareMarket     *
 * Author: Anthony Cameron  *
 * Date Created: 03/03/2019 *
 * Date Modified:           *
 * **************************/

import java.util.*;
import java.io.*;
public class ShareMarket
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        try
        {
            UserInterface.menu();
        }
        catch (IllegalArgumentException e)
        {
            sc.nextLine();
            System.out.println("Error in imports" + e.getMessage());
            System.out.println("returning to menu");
            UserInterface.menu();
        }
    }
}
