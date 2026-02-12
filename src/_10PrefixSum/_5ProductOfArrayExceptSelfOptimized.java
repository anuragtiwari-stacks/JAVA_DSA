package _10PrefixSum;

public class _5ProductOfArrayExceptSelfOptimized
{

    // Optimized method using prefix and suffix products
    public static int[] productExceptSelf(int[] nums)
    {
        int n = nums.length;

        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] answer = new int[n];

        // Build prefix product array
        prefix[0] = 1;

        for (int i = 1; i < n; i++)
        {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        // Build suffix product array
        suffix[n - 1] = 1;

        for (int i = n - 2; i >= 0; i--)
        {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        // Build answer array
        for (int i = 0; i < n; i++)
        {
            answer[i] = prefix[i] * suffix[i];
        }

        return answer;
    }

    public static void main(String[] args)
    {
        int[] nums = { 1, 2, 3, 4 };

        int[] result = productExceptSelf(nums);

        for (int i = 0; i < result.length; i++)
        {
            System.out.print(result[i] + " ");
        }
    }
}

/*
=====================
DRY RUN
=====================

nums = { 1, 2, 3, 4 }

Prefix:
prefix[0] = 1
prefix[1] = 1 * 1 = 1
prefix[2] = 1 * 2 = 2
prefix[3] = 2 * 3 = 6

prefix = { 1, 1, 2, 6 }

Suffix:
suffix[3] = 1
suffix[2] = 1 * 4 = 4
suffix[1] = 4 * 3 = 12
suffix[0] = 12 * 2 = 24

suffix = { 24, 12, 4, 1 }

Answer:
answer[0] = 1 * 24 = 24
answer[1] = 1 * 12 = 12
answer[2] = 2 * 4 = 8
answer[3] = 6 * 1 = 6

Final Answer:
{ 24, 12, 8, 6 }
*/
