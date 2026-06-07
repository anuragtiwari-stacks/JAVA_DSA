package _19BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Leetcode - 47
public class _1Permutations_2
{
    public List<List<Integer>> permuteUnique(int[] nums)
    {
        Set<List<Integer>> result = new HashSet<>();
        boolean[] used = new boolean[nums.length];

        backtrack(nums, used, new ArrayList<>(), result);

        return new ArrayList<>(result);
    }

    public void backtrack(int[] nums, boolean[] used, List<Integer> curr, Set<List<Integer>> result)
    {
        if(curr.size() == nums.length)
        {
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0; i < nums.length; i++)
        {
            if(!used[i])
            {
                used[i] = true;
                curr.add(nums[i]);

                backtrack(nums, used, curr, result);

                curr.remove(curr.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args)
    {
        _1Permutations_2 obj = new _1Permutations_2();

        int[] nums = {1,1,2};

        System.out.println(obj.permuteUnique(nums));
    }
}