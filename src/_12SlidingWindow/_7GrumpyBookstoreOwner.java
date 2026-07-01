package _12SlidingWindow;

public class _7GrumpyBookstoreOwner
{
    public static int maxSatisfied(int[] arr, int[] grumpy, int k)
    {
        int n = arr.length;

        // Step 1: already satisfied customers
        int base = 0;
        for (int i = 0; i < n; i++)
        {
            if (grumpy[i] == 0)
            {
                base = base + arr[i];
            }
        }

        // Step 2: sliding window for extra satisfied
        int i = 0;
        int j = k - 1;
        int windowSum = 0;

        // first window
        for (int x = i; x <= j; x++)
        {
            if (grumpy[x] == 1)
            {
                windowSum = windowSum + arr[x];
            }
        }

        int maxSum = windowSum;

        i++;
        j++;

        // slide window
        while (j < n)
        {
            if (grumpy[j] == 1)
            {
                windowSum = windowSum + arr[j];
            }

            if (grumpy[i - 1] == 1)
            {
                windowSum = windowSum - arr[i - 1];
            }

            maxSum = Math.max(maxSum, windowSum);

            i++;
            j++;
        }

        return base + maxSum;
    }

    public static void main(String[] args)
    {
        int[] customers = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy    = {0, 1, 0, 1, 0, 1, 0, 1};
        int k = 3;

        int result = maxSatisfied(customers, grumpy, k);

        System.out.println("Maximum satisfied customers = " + result);
    }
}