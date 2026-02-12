package _19BackTracking;

// LeetCode 377: Combination Sum IV

public class _10CombinationSumIV
{
    int[] dp;

    public int combinationSum4(int[] nums, int target)
    {
        dp = new int[target + 1];

        for (int i = 0; i <= target; i++)
        {
            dp[i] = -1;
        }

        return solve(0, nums, target);
    }

    public int solve(int idx, int[] nums, int target)
    {
        if (target == 0)
        {
            return 1;
        }

        if (target < 0 || idx >= nums.length)
        {
            return 0;
        }

        if (dp[target] != -1)
        {
            return dp[target];
        }

        // TAKE: same index reset (order matters)
        int take = solve(0, nums, target - nums[idx]);

        // REJECT: move to next index
        int reject = solve(idx + 1, nums, target);

        dp[target] = take + reject;
        return dp[target];
    }

    public static void main(String[] args)
    {
        _10CombinationSumIV obj = new _10CombinationSumIV();

        int[] nums = {1, 2, 3};
        int target = 4;

        System.out.println(obj.combinationSum4(nums, target));
    }
}

/*
---------------- DRY RUN ----------------

nums = [1,2,3], target = 4

solve(0,4):
 take 1 → solve(0,3)
   take 1 → solve(0,2)
     take 1 → solve(0,1)
       take 1 → solve(0,0) = 1
       reject → solve(1,1) = 0
     dp[1] = 1
     reject → solve(1,2)
       take 2 → solve(0,0) = 1
     dp[2] = 2
   dp[3] = 4
 reject → solve(1,4)
 dp[4] = 7

Final Answer:
7

----------------------------------------
*/
