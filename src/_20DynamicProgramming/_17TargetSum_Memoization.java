package _20DynamicProgramming;

public class _17TargetSum_Memoization
{
    public static int solve(int[] nums, int target, int i, int currSum ,int totalSum, int [][]dp)
    {
        if (i == nums.length)
        {
            if (currSum == target)
            {
                return 1;
            }

            return 0;
        }

        if(dp[i][currSum+totalSum]!=-1)
        {
            return dp[i][currSum+totalSum];
        }

        // + sign
        int plus = solve(nums, target, i + 1, currSum + nums[i],totalSum, dp);

        // - sign
        int minus = solve(nums, target, i + 1, currSum - nums[i],totalSum, dp);

        dp[i][currSum+totalSum] = plus + minus;
        return dp[i][currSum+totalSum];
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;

        int totalSum = 0;
        for(int x: nums)
        {
            totalSum=totalSum+x;
        }

        int r = nums.length;
        int c = 2*totalSum+1;
        int [][]dp = new int[r][c];

        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                dp[i][j]=-1;
            }
        }
        int ans = solve(nums, target, 0, 0, totalSum, dp);

        System.out.println(ans);
    }
}

/*
currSum       DP column index

  -5     →    -5 + 5 = 0
  -4     →    -4 + 5 = 1
  -3     →    -3 + 5 = 2
  -2     →    -2 + 5 = 3
  -1     →    -1 + 5 = 4
   0     →     0 + 5 = 5
   1     →     1 + 5 = 6
   2     →     2 + 5 = 7
   3     →     3 + 5 = 8
   4     →     4 + 5 = 9
   5     →     5 + 5 = 10
*/
