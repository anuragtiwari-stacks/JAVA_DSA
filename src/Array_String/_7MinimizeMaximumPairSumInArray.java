package Array_String;

// LeetCode 1877: Minimize Maximum Pair Sum in Array
import java.util.Arrays;

public class _7MinimizeMaximumPairSumInArray
{
    public int minPairSum(int[] nums)
    {
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;
        int maxSum = 0;

        while (left < right)
        {
            int pairSum = nums[left] + nums[right];
            maxSum = Math.max(maxSum, pairSum);

            left++;
            right--;
        }

        return maxSum;
    }

    public static void main(String[] args)
    {
        int[] nums = {3, 5, 2, 3};

        _7MinimizeMaximumPairSumInArray obj = new _7MinimizeMaximumPairSumInArray();

        System.out.println(obj.minPairSum(nums));
    }
}

/*
---------------- DRY RUN (Example) ----------------

Input:
nums = [3, 5, 2, 3]

After sorting:
[2, 3, 3, 5]

Initialize:
left = 0
right = 3
maxSum = 0

Iteration 1:
pairSum = nums[0] + nums[3] = 2 + 5 = 7
maxSum = max(0, 7) = 7
left = 1
right = 2

Iteration 2:
pairSum = nums[1] + nums[2] = 3 + 3 = 6
maxSum = max(7, 6) = 7
left = 2
right = 1 (loop ends)

Final Answer:
7

---------------------------------------------------
*/
