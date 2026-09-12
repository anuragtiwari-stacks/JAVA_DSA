package _12SlidingWindow;

public class _11MaximumElement
{
    public static void main(String[] args)
    {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        maxElement(arr, k);
    }

    public static void maxElement(int[] arr, int k)
    {
        for(int i=0;i<=arr.length-k;i++)
        {
            int max = arr[i];

            for(int j=i;j<i+k;j++)
            {
                if(arr[j]>max)
                {
                    max = arr[j];
                }
            }

            System.out.println(max);
        }
    }
}