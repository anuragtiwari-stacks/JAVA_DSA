package _7PrefixSum;

public class _5ProductOfArrayExceptSelfBrute
{

    public static int[] productExceptSelf(int[] nums)
    {
        int n = nums.length;

        int[] ans = new int[n];

        // For each index i
        for (int i = 0; i < n; i++)
        {
            int product = 1;

            // Multiply all elements except nums[i]
            for (int j = 0; j < n; j++)
            {
                if (i == j)
                {
                    continue;
                }

                product = product * nums[j];
            }

            ans[i] = product;
        }

        return ans;
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

i = 0:
skip j = 0
product = 2 * 3 * 4 = 24
ans[0] = 24

i = 1:
skip j = 1
product = 1 * 3 * 4 = 12
ans[1] = 12

i = 2:
skip j = 2
product = 1 * 2 * 4 = 8
ans[2] = 8

i = 3:
skip j = 3
product = 1 * 2 * 3 = 6
ans[3] = 6

Final Answer:
{ 24, 12, 8, 6 }
*/
