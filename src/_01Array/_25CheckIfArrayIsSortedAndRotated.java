package _01Array;

import java.util.Arrays;

// LeetCode 1752 - Check if Array Is Sorted and Rotated

public class _25CheckIfArrayIsSortedAndRotated
{
    public static boolean check(int[] nums)
    {
        int n = nums.length;

        int count = 0;

        for (int i = 0; i < n; i++)
        {
            if (nums[i] > nums[(i + 1) % n])
            {
                count++;
            }
        }

        return count <= 1;
    }

    public static void main(String[] args)
    {
        int[] nums = {3, 4, 5, 1, 2};

        System.out.println(check(nums));
    }
}