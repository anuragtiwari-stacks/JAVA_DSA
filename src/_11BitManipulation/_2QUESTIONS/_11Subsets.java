package _11BitManipulation._2QUESTIONS;

import java.util.ArrayList;
import java.util.List;

public class _11Subsets
{

    public static List<List<Integer>> subsets(int[] nums)
    {
        List<List<Integer>> result = new ArrayList<>();

        int n = nums.length;
        int total = 1 << n;

        for (int mask = 0; mask < total; mask++)
        {

            List<Integer> current = new ArrayList<>();

            for (int i = 0; i < n; i++)
            {
                if ((mask & (1 << i)) != 0)
                {
                    current.add(nums[i]);
                }
            }

            result.add(current);
        }

        return result;
    }

    public static void main(String[] args)
    {

        int[] nums = {1, 2, 3};

        List<List<Integer>> ans = subsets(nums);

        System.out.println(ans);
    }

    /*
     Dry Run

     nums = [1, 2, 3]
     n = 3

     total = 1 << 3 = 8

     mask = 0 -> 000
     subset = []

     mask = 1 -> 001
     include nums[0]
     subset = [1]

     mask = 2 -> 010
     include nums[1]
     subset = [2]

     mask = 3 -> 011
     include nums[0], nums[1]
     subset = [1, 2]

     mask = 4 -> 100
     include nums[2]
     subset = [3]

     mask = 5 -> 101
     include nums[0], nums[2]
     subset = [1, 3]

     mask = 6 -> 110
     include nums[1], nums[2]
     subset = [2, 3]

     mask = 7 -> 111
     include nums[0], nums[1], nums[2]
     subset = [1, 2, 3]

     Final Result
     [[], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3]]
    */
}
