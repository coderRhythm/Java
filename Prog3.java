import java.util.*;
public class Prog3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // int x = sc.nextInt();
        // if(x%2==0)
        // {
        //     System.out.println("Even");
        // }
        // else{
        //     System.out.println("odd");
        // }


        int button = sc.nextInt();

        if(button==1)
        {
            System.out.println("hello");
        }
        else if(button==2)
        {
            System.out.println("Namaste");
        }
        else if(button==3)
        {
            System.out.println("Bonjour");
        }
        else{
            System.out.println("Invalid");
        }
    }
}
