package _19BackTracking;

// LeetCode 78: Subsets
import java.util.ArrayList;
import java.util.List;

public class _2Subsets
{
    public List<List<Integer>> subsets(int[] nums)
    {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(0, nums, new ArrayList<>(), result);

        return result;
    }

    public void backtrack(int start, int[] nums, List<Integer> curr, List<List<Integer>> result)
    {
        // Every subset is a valid answer
        result.add(new ArrayList<>(curr));

        for (int i = start; i < nums.length; i++)
        {
            curr.add(nums[i]);

            backtrack(i + 1, nums, curr, result);

            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args)
    {
        _2Subsets obj = new _2Subsets();

        int[] nums = {1, 2, 3};

        System.out.println(obj.subsets(nums));
    }
}

/*
---------------- DRY RUN ----------------

Input:
nums = [1,2,3]

curr = []

Store []

Pick 1
curr = [1]
Store [1]

Pick 2
curr = [1,2]
Store [1,2]

Pick 3
curr = [1,2,3]
Store [1,2,3]

Backtrack
curr = [1,2]

Backtrack
curr = [1]

Pick 3
curr = [1,3]
Store [1,3]

Backtrack
curr = [1]

Backtrack
curr = []

Pick 2
curr = [2]
Store [2]

Pick 3
curr = [2,3]
Store [2,3]

Backtrack
curr = [2]

Backtrack
curr = []

Pick 3
curr = [3]
Store [3]

Backtrack
curr = []

Output:
[]
[1]
[1,2]
[1,2,3]
[1,3]
[2]
[2,3]
[3]

----------------------------------------
*/