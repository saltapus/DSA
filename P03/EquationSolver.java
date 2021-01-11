import java.util.*;
import java.io.*;
import java.lang.*;

public class EquationSolver
{
    //passes equation into parseinfix and returns post
    // which then passes into evaluate returning result
    public double solve(String equation)
    {
        double result;
        System.out.println("the Equation is" +equation);
        DSAQueue post =  parseInfixToPostfix(equation);
        result = evaluatePostfix(post);
        return result;
    }
    
  /*  //parses equation and returns postfix
    private DSAQueue parseInfixToPostfix(String equation)
    {
        String[] infix;
        String term;
        DSAStack opStack = new DSAStack();
        DSAQueue postfix = new DSAQueue();
        
        //splits equation by spaces
        infix = equation.split(" ");
        
        //prints out values to check if process is correct
        System.out.println(infix);
        System.out.println("queue count: " +postfix.getCount());
        System.out.println("stack count: " +opStack.getCount());
        for (int i = 0; i < infix.length;i++)
        {
            term = infix[i];
            System.out.println("queue count: " +postfix.getCount());
            System.out.println("stack count: " +opStack.getCount());

            char ch =term.charAt(0);
            System.out.println(term);
            switch(ch)
            {
                case ' ':
                    break;
                case '(':
                    opStack.push(new Character('('));
                    break;
                case ')':
                    while (((Character)opStack.top()).charValue() !=('('))
                    {
                       // postfix.enqueue((String.valueOf(opStack.pop())).charAt(0));
                        postfix.enqueue(((Character)opStack.pop()).charValue());
                       
                    }
                    opStack.pop();
                    break;
                case '+': case '-': case '/': case '*':
                    while (!opStack.isEmpty() && ((Character)opStack.top()).charValue() !=('(') &&
                            (precedenceOf(((Character)opStack.top()))) 
                                >= precedenceOf(ch))
                    {
                        postfix.enqueue(((Character)opStack.pop()).charValue());
                    }
                    opStack.push(new Character(ch));
                    break;
                default:
                    postfix.enqueue(new Double(Double.valueOf(term)));
                    break;
            }
   
        }  
        
        while (!opStack.isEmpty())                                              
        {                                                                       
            postfix.enqueue(((Character)opStack.pop()).charValue());
        }
        //checks values if they are being pushed correctly
        /*int count = postfix.getCount();
        for (int i = 0; i < count; i++)
        {
            System.out.println(postfix.dequeue());
        }   
        return postfix;
    } */


    
    //parses equation and returns postfix
    private DSAQueue parseInfixToPostfix(String equation)
    {
        String[] infix;
        String term;
        DSAStack opStack = new DSAStack();
        DSAQueue postfix = new DSAQueue();
        
        //splits equation by spaces
        infix = equation.split(" ");
        
        //prints out values to check if process is correct
        System.out.println(infix);
        System.out.println("queue count: " +postfix.getCount());
        System.out.println("stack count: " +opStack.getCount());
        for (int i = 0; i < infix.length;i++)
        {
            term = infix[i];
            System.out.println("queue count: " +postfix.getCount());
            System.out.println("stack count: " +opStack.getCount());

            char ch =term.charAt(0);
            System.out.println(term);
            switch(ch)
            {
                case ' ':
                    break;
                case '(':
                    opStack.push("(");
                    break;
                case ')':
                    while ((opStack.top()).equals("("))
                    {
                       // postfix.enqueue((String.valueOf(opStack.pop())).charAt(0));
                        postfix.enqueue(((String)opStack.pop()).charAt(0));
                       
                    }
                    opStack.pop();
                    break;
                case '+': case '-': case '/': case '*':
                    while (!opStack.isEmpty() && opStack.top() !=(")") &&
                            (precedenceOf(((String)opStack.top()).charAt(0))) 
                                >= precedenceOf(term.charAt(0)))
                    {
                        postfix.enqueue(((String)opStack.pop()).charAt(0));
                    }
                    opStack.push(term);
                    break;
                default:
                    postfix.enqueue(new Double(Double.valueOf(term)));
                    break;
            }
   
        }  
        
        while (!opStack.isEmpty())                                              
        {                                                                       
            postfix.enqueue(((String)opStack.pop()));
        }
        //checks values if they are being pushed correctly
        /*int count = postfix.getCount();
        for (int i = 0; i < count; i++)
        {
            System.out.println(postfix.dequeue());
        } */  
        return postfix;
    } 
    
    

    //EVALUTAE METHOD RETURNS RESULT AND IMPORTS OBJ OF POSTFIX
    private double evaluatePostfix(DSAQueue postfixQueue)
    {
        double op1, op2, result; 
        char op = '+';
        op1 = 0;
        op2 = 0;
        result = 0;
        int count = postfixQueue.getCount();

        DSAStack opStack = new DSAStack();
        for (int i = 0; i < count;i++)
        {
            Object term = postfixQueue.dequeue();
            if (term instanceof Double)
            {
                opStack.push(term);
            }
            else if (term instanceof Character)
            {
                op = ((Character)term).charValue();;
                op1 = (((Double)opStack.pop()).doubleValue());
                op2 = (((Double)opStack.pop()).doubleValue());
                
                result = executeOperation(op, op1, op2);
                opStack.push(new Double(result));
                System.out.println(op);
            }


        }
        result = (((Double)opStack.pop()).doubleValue());
        
        return result;
    }
    
    //RETURNS OPERAND PRECEDENCE - OPERAND THAT IS HIGHER OR LOWER
    //IMPORTS CHAR
    private int precedenceOf(char theOperator)
    {
        int operand = 0;
        if ((theOperator == '-')||(theOperator =='+'))
        {
            operand = 1;
        }
        else if ((theOperator == '/')||(theOperator == '*'))
        {
            operand = 2;
        }
        System.out.println(operand);
        return operand;
    }

    //CALCULATES VALUE AND RETURNS RESULT
    private double executeOperation(char op, double op1, double op2)
    {
        double result = 0;
        System.out.println("exe char "+op);
        System.out.println("val: "+op1);
        System.out.println(op2);
        switch(op)
        {
            case '+':
                result = op1 + op2;
                break;
            case '-':
                result = op2 - op1;
                break;
            case '/':
                result = op2 / op1;
                break;
            case '*':
                result = op1 * op2;
                break;
            default:
                System.out.println("this is invalid");
                break;
        }
        
        System.out.println("executing:.."+ result);
        return result;
    }
}
