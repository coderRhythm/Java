import java.util.*;

public class Prog5_functions {

    /*
    public static void printMyName(String name)
    {
        System.out.println(name);
    }
    */

    // avg of three numbers
    public static double avgOfThress(double a , double b, double c)
    {
        return (a+b+c)/3;

    }



    public static void main(String[] args) {
        System.out.println("function calling");
        //   printMyName("Rhythm Sethiya");
        System.out.println(avgOfThress(1.1,1.1,1.1));
    }
}
