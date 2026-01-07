package _11Sorting._2QUESTIONS;

public class _2MissingNumberBruteForce
{
    public static int missingNumber(int[] arr)
    {
        int n = arr.length;

        for (int i = 0; i <= n; i++)
        {
            boolean found = false;

            for (int j = 0; j < n; j++)
            {
                if (arr[j] == i)
                {
                    found = true;
                    break;
                }
            }

            if (!found)
            {
                return i;
            }
        }

        return -1; // Should never reach here if input is valid
    }

    public static void main(String[] args)
    {
        int[] arr = {3, 0, 1};
        int missing = missingNumber(arr);
        System.out.println("Missing number is: " + missing);
    }

    /*
        🔍 Dry Run (Input: arr = {3, 0, 1})

        n = 3

        i = 0
        → Check if 0 is in arr → YES ✅ → found = true

        i = 1
        → Check if 1 is in arr → YES ✅ → found = true

        i = 2
        → Check if 2 is in arr → NO ❌ → found = false
        → return 2

        ✅ Output: Missing number is: 2
    */
}
