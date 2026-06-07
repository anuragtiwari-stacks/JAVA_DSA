package _19BackTracking;

// LeetCode 46: Permutations
import java.util.ArrayList;
import java.util.List;

public class _1Permutations
{
    public List<List<Integer>> permute(int[] nums)
    {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        backtrack(nums, used, new ArrayList<>(), result);

        return result;
    }

    public void backtrack(int[] nums, boolean[] used, List<Integer> curr, List<List<Integer>> result)
    {
        if (curr.size() == nums.length)
        {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++)
        {
            if (!used[i])
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
        _1Permutations obj = new _1Permutations();

        int[] nums = {1, 2, 3};

        System.out.println(obj.permute(nums));
    }
}

/*
---------------- DRY RUN ----------------

Input:
nums = [1, 2, 3]

curr = []
used = [false, false, false]

Pick 1 → curr = [1]
Pick 2 → curr = [1,2]
Pick 3 → curr = [1,2,3] → store

Backtrack
Pick 3 → curr = [1,3]
Pick 2 → curr = [1,3,2] → store

Similarly:
[2,1,3], [2,3,1], [3,1,2], [3,2,1]

----------------------------------------
*/
