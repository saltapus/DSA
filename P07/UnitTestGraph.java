import java.util.*;

public class UnitTestGraph
{
    public static void main(String []args)
    {
        System.out.println("testing default");
        DSAGraph graph1 = new DSAGraph();
        System.out.println("testing prac6_1.al");
        DSAGraph graph2 = new DSAGraph("prac6_1.al");
        System.out.println(graph2.displayList());
        System.out.println("testing prac6_2.al");
        DSAGraph graph3 = new DSAGraph("prac6_2.al");
        System.out.println(graph2.displayList());
    }
}
