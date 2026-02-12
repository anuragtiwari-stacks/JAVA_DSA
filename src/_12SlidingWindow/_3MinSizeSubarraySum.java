package _12SlidingWindow;

public class _3MinSizeSubarraySum
{

    public int minSubArrayLen(int target, int[] nums)
    {
        int n = nums.length;
        int i = 0;
        int windowSum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++)
        {
            windowSum = windowSum + nums[j];

            while (windowSum >= target)
            {
                int currentLength = j - i + 1;
                if (currentLength < minLength)
                {
                    minLength = currentLength;
                }

                windowSum = windowSum - nums[i];
                i++;
            }
        }

        if (minLength == Integer.MAX_VALUE)
        {
            return 0;
        }

        return minLength;
    }

    public static void main(String[] args)
    {
        _3MinSizeSubarraySum solver = new _3MinSizeSubarraySum();

        int[] nums = { 2, 3, 1, 2, 4, 3 };
        int target = 7;

        int result = solver.minSubArrayLen(target, nums);
        System.out.println("Minimal subarray length: " + result);
    }
}

/*
==================== DRY RUN ====================

nums = [2, 3, 1, 2, 4, 3]
target = 7

i = 0
windowSum = 0
minLength = INF

j = 0 → windowSum = 2
j = 1 → windowSum = 5
j = 2 → windowSum = 6
j = 3 → windowSum = 8 (>=7)

currentLength = 4
minLength = 4
windowSum = 8 - 2 = 6
i = 1

j = 4 → windowSum = 10 (>=7)
currentLength = 4
minLength = 4
windowSum = 10 - 3 = 7
i = 2

currentLength = 3
minLength = 3
windowSum = 7 - 1 = 6
i = 3

j = 5 → windowSum = 9 (>=7)
currentLength = 3
minLength = 3
windowSum = 9 - 2 = 7
i = 4

currentLength = 2
minLength = 2
windowSum = 7 - 4 = 3
i = 5

Loop ends

Final Answer = 2
===============================================
*/
