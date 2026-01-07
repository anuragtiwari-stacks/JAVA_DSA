package _7PrefixSum;

public class _2RangeSumQueryImmutable
{

    private int[] prefix;

    // Constructor to build prefix sum array
    public _2RangeSumQueryImmutable(int[] nums)
    {
        int n = nums.length;

        prefix = new int[n];

        if (n == 0)
        {
            return;
        }

        // First element
        prefix[0] = nums[0];

        // Build prefix sum
        for (int i = 1; i < n; i++)
        {
            prefix[i] = prefix[i - 1] + nums[i];
        }
    }

    // Method to return sum of range [left, right]
    public int sumRange(int left, int right)
    {
        if (left == 0)
        {
            return prefix[right];
        }

        return prefix[right] - prefix[left - 1];
    }

    public static void main(String[] args)
    {
        int[] nums = { -2, 0, 3, -5, 2, -1 };

        _2RangeSumQueryImmutable obj = new _2RangeSumQueryImmutable(nums);

        System.out.println(obj.sumRange(0, 2));
        System.out.println(obj.sumRange(2, 5));
        System.out.println(obj.sumRange(0, 5));
    }
}

/*
=====================
DRY RUN
=====================

nums = { -2, 0, 3, -5, 2, -1 }

Building prefix sum:

prefix[0] = -2
prefix[1] = -2 + 0  = -2
prefix[2] = -2 + 3  = 1
prefix[3] = 1 + (-5) = -4
prefix[4] = -4 + 2  = -2
prefix[5] = -2 + (-1) = -3

prefix = { -2, -2, 1, -4, -2, -3 }

Query 1: sumRange(0, 2)
→ prefix[2] = 1

Query 2: sumRange(2, 5)
→ prefix[5] - prefix[1]
→ -3 - (-2) = -1

Query 3: sumRange(0, 5)
→ prefix[5] = -3
*/
