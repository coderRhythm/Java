public class InsertionSort {
    public static void main(String[] args)
    {
        int arr[] = {7,8,3,1,2};
        int n = arr.length;
        for(int i=1; i<n; i++)
        {
            
            int curr = arr[i];

            int j = i-1;
            // traversing in unsorted array
            while(j>=0 && curr<arr[j])
            {
                arr[j+1]=arr[j];
                j--;
            }

            // placement
            arr[j+1]=curr;
        }

        for(int i=0; i<n; i++)
        {
            System.out.println(arr[i]);
        }


    }
}
