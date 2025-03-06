import java.util.*;

public class BasicSorting {
    public static void main(String[] args)
    {
        int[] arr = {4,3,2,5,1};
        int n = 5;
        for(int i=0; i<n-1; i++)
        {
            for(int j=0; j<n-i-1; j++)
            {
                if(arr[j]>arr[j+1])
                {
                    // swap logic
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        for(int i=0; i<n; i++)
        {
            System.out.println(arr[i]);
        }
    }
}
