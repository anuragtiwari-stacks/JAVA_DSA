package _12SlidingWindow;

public class _10FirstNegativeNumber
{
    public static void main(String[] args)
    {
        int[] nums = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;

        firstNegative(nums, k);
    }

    public static void firstNegative(int[] arr, int k)
    {
        for(int i=0;i<=arr.length-k;i++)
        {
            int count = 0;

            for(int j=i;j<i+k;j++)
            {
                if(arr[j]<0)
                {
                    count++;
                    System.out.println(arr[j]);
                    break;
                }
            }

            if(count == 0)
            {
                System.out.println(0);
            }
        }
    }
}