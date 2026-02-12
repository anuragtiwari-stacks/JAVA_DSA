package _1Array;

/*
LeetCode 3379 - Transformed Array
*/

import java.util.ArrayList;

public class _15TransformedArray
{
    public static int[] constructTransformedArray(int[] nums)
    {
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++)
        {
            if (nums[i] == 0)
            {
                list.add(0);
            }
            else if (nums[i] > 0)
            {
                int newIndex = (i + nums[i]) % n;
                list.add(nums[newIndex]);
            }
            else
            {
                int newIndex = (i - Math.abs(nums[i])) % n;
                if (newIndex < 0)
                {
                    newIndex += n;
                }
                list.add(nums[newIndex]);
            }
        }

        int[] result = new int[n];

        for (int i = 0; i < n; i++)
        {
            result[i] = list.get(i);
        }

        return result;
    }

    public static void main(String[] args)
    {
        int[] nums = {3, -2, 1, 1};
        int[] ans = constructTransformedArray(nums);

        for (int x : ans)
        {
            System.out.print(x + " ");
        }
    }
}

/*
Dry Run:
Input: nums = [3, -2, 1, 1]

i = 0
nums[0] = 3 > 0
newIndex = (0 + 3) % 4 = 3
result[0] = nums[3] = 1

i = 1
nums[1] = -2 < 0
newIndex = (1 - 2) % 4 = -1 -> +4 = 3
result[1] = nums[3] = 1

i = 2
nums[2] = 1 > 0
newIndex = (2 + 1) % 4 = 3
result[2] = nums[3] = 1

i = 3
nums[3] = 1 > 0
newIndex = (3 + 1) % 4 = 0
result[3] = nums[0] = 3

Final Output:
[1, 1, 1, 3]
*/
