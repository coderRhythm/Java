public class SelectionSort {
    public static void main(String[] args)
    {
        int[] arr = {4,2,1,5,3};
        int n = 5;
        int smallest = 0;
        // selection sort
        for(int i=0; i<n-1; i++)
        {
            smallest = i;
            // finding the smallest element
            for(int j=i+1; j<n; j++)
            {
                if(arr[smallest]>arr[j])
                {
                    smallest = j;
                }
            }
            // swapping First number with smallest number 
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;

        }

        for(int i=0; i<n; i++)
        {
            System.out.println(arr[i]);
        }

    }
}
