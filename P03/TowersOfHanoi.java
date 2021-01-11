import java.util.*;

//MAIN METHOD
public class TowersOfHanoi
{
    public static void main(String[] args)
    {
        int n, src, dest;
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(args[0]);
        src = Integer.parseInt(args[1]);
        dest = Integer.parseInt(args[2]);
        towers(n, src, dest);
        
    }
//work out tab spaces
//TOWERS METHOD IMPORTS n src and dest and returns void
    public static void towers(int n, int src, int dest)
    {
        int temp;

        if (n == 1)
        {
            moveDisk(src, dest);
        }
        else
        {
            temp = 6 - src - dest;
            towers(n-1, src, temp);
        //    System.out.println(temp);

            moveDisk(src, dest);
            towers (n-1, temp, dest);
        }
    }

    //MOVEDISK METHOD, IMPORTS src and dest RETURNS void
    public static void moveDisk(int src, int dest)
    {
        String s = ("Moving top disk from  peg" +src+ " to peg " +dest); 
        String tab = " ";

     /*   for (int i = 0; i <= n; i++) 
        {
            System.out.println(tab + s);
            tab += " ";
        }
        System.out.println();*/
        //System.out.println("src " + src + " dest "+ dest);
        System.out.println(s);
   

 
    
    }
}
