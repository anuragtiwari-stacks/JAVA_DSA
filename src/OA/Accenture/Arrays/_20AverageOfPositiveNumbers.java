package OA.Accenture.Arrays;

// Question: Compute the average of only the positive numbers in an array

public class _20AverageOfPositiveNumbers
{
    public static void main(String[] args)
    {
        int[] arr = {-2, 5, 7, -1, 10, -4};

        System.out.println(findAverage(arr));
    }

    static double findAverage(int[] arr)
    {
        int sum = 0;
        int count = 0;

        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] > 0)
            {
                sum += arr[i];
                count++;
            }
        }

        if(count == 0)
        {
            return 0;
        }

        return (double) sum / count;
    }
}