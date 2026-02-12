package _19BackTracking;

// LeetCode 2597: The Number of Beautiful Subsets
import java.util.*;

public class _12BeautifulSubsets
{
    public int beautifulSubsets(int[] nums, int k)
    {
        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> allSubsets = new ArrayList<>();

        backtrack(0, nums, k, subset, allSubsets);

        return allSubsets.size();
    }

    public void backtrack(int index, int[] nums, int k, List<Integer> subset, List<List<Integer>> allSubsets)
    {
        for (int i = index; i < nums.length; i++)
        {
            if (canAdd(subset, nums[i], k))
            {
                // choose
                subset.add(nums[i]);

                // explore
                backtrack(i + 1, nums, k, subset, allSubsets);

                // unchoose
                subset.remove(subset.size() - 1);
            }
        }

        if (subset.size() > 0)
        {
            allSubsets.add(new ArrayList<>(subset));
        }
    }

    public boolean canAdd(List<Integer> subset, int val, int k)
    {
        for (int x : subset)
        {
            if (Math.abs(x - val) == k)
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        _12BeautifulSubsets obj = new _12BeautifulSubsets();

        int[] nums = {2, 4, 6};
        int k = 2;

        System.out.println(obj.beautifulSubsets(nums, k));
    }
}

/*
---------------- DRY RUN ----------------

nums = [2,4,6], k = 2

Start:
subset = []

Pick 2 → [2]
Pick 4 → not allowed (|2-4| = 2)
Pick 6 → allowed → [2,6] → store

Backtrack to []
Pick 4 → [4]
Pick 6 → not allowed (|4-6| = 2)

Pick 6 → [6]

All stored subsets:
[2], [2,6], [4], [6]

Total beautiful subsets = 4

----------------------------------------
*/
