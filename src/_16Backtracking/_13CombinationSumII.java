package _16Backtracking;

// LeetCode 40: Combination Sum II
import java.util.*;

public class _13CombinationSumII
{
    public List<List<Integer>> combinationSum2(int[] candidates, int target)
    {
        Arrays.sort(candidates);

        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        backtrack(0, candidates, target, subset, result);

        return result;
    }

    public void backtrack(int index, int[] candidates, int target, List<Integer> subset, List<List<Integer>> result)
    {
        if (target == 0)
        {
            result.add(new ArrayList<>(subset));
            return;
        }

        if (target < 0)
        {
            return;
        }

        for (int i = index; i < candidates.length; i++)
        {
            if (i > index && candidates[i] == candidates[i - 1])
            {
                continue;   // skip duplicates
            }

            if (candidates[i] > target)
            {
                break;      // pruning
            }

            subset.add(candidates[i]);                  // choose
            backtrack(i + 1, candidates, target - candidates[i], subset, result); // explore
            subset.remove(subset.size() - 1);           // unchoose
        }
    }

    public static void main(String[] args)
    {
        _13CombinationSumII obj = new _13CombinationSumII();

        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        System.out.println(obj.combinationSum2(candidates, target));
    }
}

/*
---------------- DRY RUN ----------------

candidates = [1,1,2,5,6,7,10], target = 8

Start:
subset = []

Pick 1 → [1]
Pick 1 → [1,1]
Pick 6 → [1,1,6] → store

Backtrack to [1]
Pick 2 → [1,2]
Pick 5 → [1,2,5] → store

Backtrack
Pick 7 → [1,7] → store

Pick 2 → [2]
Pick 6 → [2,6] → store

Final Output:
[
 [1,1,6],
 [1,2,5],
 [1,7],
 [2,6]
]

----------------------------------------
*/
