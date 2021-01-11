import java.util.*;

public class EquationSolverTestHarness
{
    public static void main(String[] args)
    {
        EquationSolver solve = new EquationSolver();
        int choice = 0;
        String equation = "";
        Scanner sc = new Scanner(System.in);
        

        equation =  "( 10.3 * ( 14 + 3.2 ) ) / ( 5 + 2 - 4 * 3 )";
        
        // equation =  "( 10.3 * 2 )";
        System.out.println(equation);
        double result = solve.solve(equation);
        System.out.println("result test" +result);
        
    }
}
        //Tests count
