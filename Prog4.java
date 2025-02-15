import java.util.*;

public class Prog4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        int n = sc.nextInt();

        /*
         * Pattern 1: Solid rectangle
         ******
         ******
         ******
         */
        // for(int i=0; i<n; i++)
        // {
        // for(int j=0; j<n; j++){
        // System.out.print("* ");
        // }
        // System.out.println("");
        // }

        /*
         * Hollow rectangle:
         *******
         * *
         * *
         * *
         *******
         */

        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         System.out.print(i == 0 || i == (n - 1) ? "*" : j == 0 || j == (n - 1) ? "*" : " ");
        //     }
        //     System.out.println("");
        // }



        /*
            *
            ** 
            ***
            ****
            *****
         */
            // for(int i=0; i<n; i++)
            // {
            //     for(int j=0;j<=i; j++)
            //     {
            //         System.out.print("*");
            //     }
            //     System.out.println("");
            // }

        /*
         ******
         *****
         ***
         **
         *
         */
            // for(int i=(n-1); i>=0; i--)
            // {
            //     for(int j=0; j<=i; j++)
            //     {
            //         System.out.print("*");
            //     }
            //     System.out.println("");
            // }


        /*
            Inverted half pyramid 
            (rotated by 180deg)
                 *
                **
               ***
              ****
             *****
         */

         /**/
        // for(int i=0; i<n; i++)
        // {
        //     // printing the space
        //     for(int j=0; j<(n-i); j++)
        //     {
        //         System.out.print(" ");
        //     }

        //     // printing the *
        //     for(int j=0; j<=i; j++)
        //     {
        //         System.out.print("*");
        //     }

        //     System.out.println("");
        // }



         /*

            1
            1 2 
            1 2 3
            1 2 3 4 
            1 2 3 4 5

          */
        //   for(int i=1; i<=n; i++){
        //     for(int j=1; j<=i; j++)
        //     {   
        //         System.out.print(j+" ");

        //     }
        //     System.out.println("");
        //   }


        /*
         * floyds triangle 
         * 1
         * 2 3
         * 4 5 6
         * 7 8 9 10
         * 11 12 13 14 15
         */

        int cnt = 1;
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=i; j++)
            {
                System.out.print(cnt++);
                
                System.out.print(" ");
            }
            System.out.println("");
        }

    }
}
