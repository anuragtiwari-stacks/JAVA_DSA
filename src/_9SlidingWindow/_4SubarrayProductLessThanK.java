package _9SlidingWindow;

public class _4SubarrayProductLessThanK
{
    public int numSubarrayProductLessThanK(int[] nums, int k)
    {
        if (k <= 1)
        {
            return 0;
        }

        int i = 0;
        int product = 1;
        int count = 0;

        for (int j = 0; j < nums.length; j++)
        {
            product = product * nums[j];

            while (product >= k)
            {
                product = product / nums[i];
                i++;
            }

            count = count + (j - i + 1);
        }

        return count;
    }

    public static void main(String[] args)
    {
        _4SubarrayProductLessThanK solver = new _4SubarrayProductLessThanK();

        int[] nums = { 10, 5, 2, 6 };
        int k = 100;

        int result = solver.numSubarrayProductLessThanK(nums, k);
        System.out.println("Total subarrays: " + result);
    }
}

/*
==================== DRY RUN ====================

nums = [10, 5, 2, 6]
k = 100

i = 0
product = 1
count = 0

j = 0:
product = 1 * 10 = 10 (<100)
count += (0 - 0 + 1) = 1
Subarrays: [10]

j = 1:
product = 10 * 5 = 50 (<100)
count += (1 - 0 + 1) = 2
Subarrays: [10,5], [5]
count = 3

j = 2:
product = 50 * 2 = 100 (>=100)
Shrink:
product = 100 / 10 = 10
i = 1

count += (2 - 1 + 1) = 2
Subarrays: [5,2], [2]
count = 5

j = 3:
product = 10 * 6 = 60 (<100)
count += (3 - 1 + 1) = 3
Subarrays: [5,2,6], [2,6], [6]
count = 8

Final Answer = 8
===============================================
*/
