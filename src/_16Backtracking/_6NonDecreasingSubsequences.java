package _16Backtracking;

// LeetCode 491: Non-decreasing Subsequences
import java.util.*;

public class _6NonDecreasingSubsequences
{
    public List<List<Integer>> findSubsequences(int[] nums)
    {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    public void backtrack(int[] nums, int index, List<Integer> current, List<List<Integer>> result)
    {
        if (current.size() >= 2)
        {
            result.add(new ArrayList<>(current));
        }

        HashSet<Integer> used = new HashSet<>();

        for (int i = index; i < nums.length; i++)
        {
            if (used.contains(nums[i]))
            {
                continue;
            }

            if (current.size() == 0 || nums[i] >= current.get(current.size() - 1))
            {
                used.add(nums[i]);

                current.add(nums[i]);                 // choose
                backtrack(nums, i + 1, current, result); // explore
                current.remove(current.size() - 1);   // unchoose
            }
        }
    }

    public static void main(String[] args)
    {
        _6NonDecreasingSubsequences obj = new _6NonDecreasingSubsequences();

        int[] nums = {4, 6, 7, 7};

        System.out.println(obj.findSubsequences(nums));
    }
}

/*
---------------- DRY RUN ----------------

nums = [4, 6, 7, 7]

current = []

Pick 4 → [4]
Pick 6 → [4,6] → store
Pick 7 → [4,6,7] → store
Pick 7 → [4,6,7,7] → store

Backtrack to [4]
Pick 7 → [4,7] → store

Pick 6 → [6]
Pick 7 → [6,7] → store
Pick 7 → [6,7,7] → store

Pick 7 → [7]
Pick 7 → [7,7] → store

Final Output:
[
 [4,6],
 [4,6,7],
 [4,6,7,7],
 [4,7],
 [6,7],
 [6,7,7],
 [7,7]
]

----------------------------------------
*/
