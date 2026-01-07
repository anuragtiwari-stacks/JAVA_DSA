package _7PrefixSum;

public class _1BuildPrefixSum
{

    // Method to build prefix sum array
    public static int[] buildPrefixSum(int[] arr)
    {
        int n = arr.length;

        // Prefix sum array
        int[] prefix = new int[n];

        // First element is same as original array
        prefix[0] = arr[0];

        // Build prefix sum array
        for (int i = 1; i < n; i++)
        {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        return prefix;
    }

    public static void main(String[] args)
    {
        // Original array
        int[] arr = { 3, 5, 2, 7, 4 };

        // Build prefix sum
        int[] prefix = buildPrefixSum(arr);

        // Print prefix sum array
        for (int i = 0; i < prefix.length; i++)
        {
            System.out.print(prefix[i] + " ");
        }
    }
}

/*
=====================
DRY RUN
=====================

Input Array:
arr = {3, 5, 2, 7, 4}

Step 1:
prefix[0] = arr[0] = 3

Step 2:
prefix[1] = prefix[0] + arr[1]
          = 3 + 5
          = 8

prefix[2] = prefix[1] + arr[2]
          = 8 + 2
          = 10

prefix[3] = prefix[2] + arr[3]
          = 10 + 7
          = 17

prefix[4] = prefix[3] + arr[4]
          = 17 + 4
          = 21

Final Prefix Sum Array:
{3, 8, 10, 17, 21}
*/
