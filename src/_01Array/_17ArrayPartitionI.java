package _01Array;

import java.util.Arrays;

// LeetCode 561
public class _17ArrayPartitionI
{

    public static void main(String[] args)
    {
        _17ArrayPartitionI obj = new _17ArrayPartitionI();

        int[] nums = {1, 4, 3, 2};

        int result = obj.arrayPairSum(nums);

        System.out.println(result);
    }

    public int arrayPairSum(int[] nums)
    {
        Arrays.sort(nums);

        int sum = 0;

        for (int i = 0; i < nums.length; i = i + 2)
        {
            sum = sum + nums[i];
        }

        return sum;
    }
}

/*
Dry Run:

Input: [1, 4, 3, 2]

Step 1: Sort array
Sorted: [1, 2, 3, 4]

Step 2: Loop with i = i + 2

i = 0 → sum = 0 + 1 = 1
i = 2 → sum = 1 + 3 = 4

Return 4

Output: 4
*/
