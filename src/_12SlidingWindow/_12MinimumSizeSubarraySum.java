package _12SlidingWindow;

public class _12MinimumSizeSubarraySum
{
    public static void main(String[] args)
    {
        int[] arr = {2, 3, 1, 2, 4, 3};
        int target = 7;

        System.out.println(minSubArrayLen(arr, target));
    }

    public static int minSubArrayLen(int[] arr, int target)
    {
        int min = Integer.MAX_VALUE;

        int n = arr.length;
        for(int i=0;i<n;i++)
        {
            int sum = 0;
            for(int j=i;j<n;j++)
            {
                sum = sum + arr[j];

                if(sum>target)
                {
                    break;
                }

                if(sum == target)
                {
                    int len = j-i+1;
                    min = Math.min(len,min);
                }
            }
        }
        return min;
    }
}