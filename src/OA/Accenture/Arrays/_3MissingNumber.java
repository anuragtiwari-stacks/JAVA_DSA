package OA.Accenture.Arrays;

// Question: Find the missing number in an array containing numbers from 1 to N

public class _3MissingNumber
{
    public static void main(String[] args)
    {
        int[] arr = {1, 2, 4, 5, 6};

        System.out.println(findMissingNumber(arr));
    }

    static int findMissingNumber(int[] arr)
    {
        int n = arr.length + 1;

        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for(int i = 0; i < arr.length; i++)
        {
            actualSum += arr[i];
        }

        return expectedSum - actualSum;
    }
}