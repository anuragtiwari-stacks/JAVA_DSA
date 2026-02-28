package _01Array;

// LeetCode 485
public class _19MaxConsecutiveOnes
{

    public static void main(String[] args)
    {
        _19MaxConsecutiveOnes obj = new _19MaxConsecutiveOnes();

        int[] nums = {1, 1, 0, 1, 1, 1};

        int result = obj.findMaxConsecutiveOnes(nums);

        System.out.println(result);
    }

    public int findMaxConsecutiveOnes(int[] nums)
    {
        int count = 0;
        int max = 0;

        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] == 1)
            {
                count = count + 1;
            }
            else
            {
                count = 0;
            }

            max = Math.max(max, count);
        }

        return max;
    }
}

/*
Dry Run:

Input:
nums = {1, 1, 0, 1, 1, 1}

i = 0 → 1 → count = 1 → max = 1
i = 1 → 1 → count = 2 → max = 2
i = 2 → 0 → count = 0 → max = 2
i = 3 → 1 → count = 1 → max = 2
i = 4 → 1 → count = 2 → max = 2
i = 5 → 1 → count = 3 → max = 3

Return 3

Output: 3
*/
