package _1Array;

/*
 LeetCode 3637
 Trionic Array I
 File Name: TrionicArrayI.java
*/

public class _14TrionicArrayI
{
    public boolean isTrionic(int[] nums)
    {
        int n = nums.length;

        if (n < 3)
        {
            return false;
        }

        int i;

        // Phase 1: Strictly Increasing
        for (i = 0; i < n - 1; i++)
        {
            if (nums[i] >= nums[i + 1])
            {
                break;
            }
        }

        if (i == 0)
        {
            return false;
        }

        // Phase 2: Strictly Decreasing
        int decStart = i;

        for (i = decStart; i < n - 1; i++)
        {
            if (nums[i] <= nums[i + 1])
            {
                break;
            }
        }

        if (i == decStart)
        {
            return false;
        }

        // Phase 3: Strictly Increasing again
        int incStart = i;

        for (i = incStart; i < n - 1; i++)
        {
            if (nums[i] >= nums[i + 1])
            {
                return false;
            }
        }

        if (i == incStart)
        {
            return false;
        }

        return true;
    }

    public static void main(String[] args)
    {
        _14TrionicArrayI obj = new _14TrionicArrayI();

        int[] nums = {1, 3, 5, 4, 2, 6, 7};

        boolean result = obj.isTrionic(nums);

        System.out.println(result);
    }
}

/*
Dry Run:

Input:
nums = [1, 3, 5, 4, 2, 6, 7]

n = 7

Phase 1 (Increasing):
1 < 3 < 5  → stop at index i = 2

Phase 2 (Decreasing):
5 > 4 > 2  → stop at index i = 4

Phase 3 (Increasing):
2 < 6 < 7  → reach end

All three phases valid
Return true
*/
