package _10Searching;

public class _10SmallestDivisorBruteForce
{
    public static int smallestDivisor(int[] arr, int threshold)
    {
        int max = getMax(arr);

        // Try every possible divisor from 1 to max
        for (int divisor = 1; divisor <= max; divisor++)
        {
            int sum = getSum(arr, divisor);

            if (sum <= threshold)
            {
                return divisor;
            }
        }

        return -1;
    }

    // Helper method to compute sum of ceil(arr[i] / divisor)
    private static int getSum(int[] arr, int divisor)
    {
        int sum = 0;

        for (int i = 0; i < arr.length; i++)
        {
            int value = arr[i];

            if (value % divisor == 0)
                sum += value / divisor;
            else
                sum += (value / divisor) + 1;
        }

        return sum;
    }

    // Helper method to get maximum element
    private static int getMax(int[] arr)
    {
        int max = arr[0];

        for (int i = 1; i < arr.length; i++)
        {
            if (arr[i] > max)
                max = arr[i];
        }

        return max;
    }

    public static void main(String[] args)
    {
        int[] arr1 = {1, 2, 5, 9};
        int threshold1 = 6;
        System.out.println("Smallest divisor: " + smallestDivisor(arr1, threshold1));

        int[] arr2 = {44, 22, 33, 11, 1};
        int threshold2 = 5;
        System.out.println("Smallest divisor: " + smallestDivisor(arr2, threshold2));
    }
}

/*
====================== DRY RUN ======================

Example 1:
arr = {1, 2, 5, 9}
threshold = 6

Step 1: Find max(arr)
max = 9

Now try divisors from 1 to 9

----------------------------------------------------
Divisor = 1
ceil(1/1) = 1
ceil(2/1) = 2
ceil(5/1) = 5
ceil(9/1) = 9
Sum = 1 + 2 + 5 + 9 = 17  (> 6 ❌)

----------------------------------------------------
Divisor = 2
ceil(1/2) = 1
ceil(2/2) = 1
ceil(5/2) = 3
ceil(9/2) = 5
Sum = 1 + 1 + 3 + 5 = 10  (> 6 ❌)

----------------------------------------------------
Divisor = 3
ceil(1/3) = 1
ceil(2/3) = 1
ceil(5/3) = 2
ceil(9/3) = 3
Sum = 1 + 1 + 2 + 3 = 7  (> 6 ❌)

----------------------------------------------------
Divisor = 4
ceil(1/4) = 1
ceil(2/4) = 1
ceil(5/4) = 2
ceil(9/4) = 3
Sum = 1 + 1 + 2 + 3 = 7  (> 6 ❌)

----------------------------------------------------
Divisor = 5
ceil(1/5) = 1
ceil(2/5) = 1
ceil(5/5) = 1
ceil(9/5) = 2
Sum = 1 + 1 + 1 + 2 = 5  (≤ 6 ✅)

→ First divisor satisfying condition = 5

----------------------------------------------------
Answer: 5

====================================================

Example 2:
arr = {44, 22, 33, 11, 1}
threshold = 5

Divisor = 44
ceil(44/44) = 1
ceil(22/44) = 1
ceil(33/44) = 1
ceil(11/44) = 1
ceil(1/44)  = 1
Sum = 5 (≤ 5 ✅)

→ Answer: 44

====================================================
*/
