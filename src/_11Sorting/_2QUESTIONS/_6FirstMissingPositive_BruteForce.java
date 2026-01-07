package _11Sorting._2QUESTIONS;

public class _6FirstMissingPositive_BruteForce
{

    public static int firstMissingPositive(int[] nums)
    {
        for (int i = 1; i <= nums.length + 1; i++)
        {
            boolean found = false;

            for (int j = 0; j < nums.length; j++)
            {
                if (nums[j] == i)
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

        return -1; // fallback
    }

    public static void main(String[] args)
    {
        int[] arr = {3, 4, -1, 1};
        int result = firstMissingPositive(arr);
        System.out.println("First missing positive: " + result);
    }

    /*
        🔍 Dry Run: arr = {3, 4, -1, 1}

        Try i = 1 → found ✅
        Try i = 2 → not found ❌ → return 2

        ✅ Output: 2
    */
}
