package Array_String;

// LeetCode 3507: Minimum Pair Removal to Sort Array I (Array Version)
public class _6MinimumPairRemovalToSortArray
{
    public int minimumPairRemoval(int[] nums)
    {
        int n = nums.length;
        int operations = 0;

        while (!isSorted(nums, n))
        {
            int minSum = Integer.MAX_VALUE;
            int idx = 0;

            for (int i = 0; i < n - 1; i++)
            {
                int sum = nums[i] + nums[i + 1];

                if (sum < minSum)
                {
                    minSum = sum;
                    idx = i;
                }
            }

            nums[idx] = minSum;

            for (int i = idx + 1; i < n - 1; i++)
            {
                nums[i] = nums[i + 1];
            }

            n--;
            operations++;
        }

        return operations;
    }

    private boolean isSorted(int[] nums, int n)
    {
        for (int i = 1; i < n; i++)
        {
            if (nums[i] < nums[i - 1])
            {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args)
    {
        int[] nums = {5, 2, 3, 1};

        _6MinimumPairRemovalToSortArray obj = new _6MinimumPairRemovalToSortArray();

        System.out.println(obj.minimumPairRemoval(nums));
    }
}


/*
---------------- DRY RUN (Example) ----------------

Input:
nums = [5, 2, 3, 1]

n = 4

Iteration 1:
Adjacent sums:
(5,2)=7 , (2,3)=5 , (3,1)=4
minSum = 4, idx = 2

Merge:
nums[2] = 4
Array becomes (logical size 3):
[5, 2, 4]

operations = 1

Iteration 2:
Adjacent sums:
(5,2)=7 , (2,4)=6
minSum = 6, idx = 1

Merge:
nums[1] = 6
Array becomes (logical size 2):
[5, 6]

operations = 2

Array is non-decreasing.
Loop stops.

Output: 2

---------------------------------------------------
*/
