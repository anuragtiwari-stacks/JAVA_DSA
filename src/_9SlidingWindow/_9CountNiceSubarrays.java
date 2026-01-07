package _9SlidingWindow;

public class _9CountNiceSubarrays
{
    public int numberOfSubarrays(int[] nums, int k)
    {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k)
    {
        int i = 0;
        int count = 0;

        for (int j = 0; j < nums.length; j++)
        {
            // include nums[j]
            if (nums[j] % 2 != 0)
            {
                k--;
            }

            // shrink window if odd count > k
            while (k < 0)
            {
                if (nums[i] % 2 != 0)
                {
                    k++;
                }
                i++;
            }

            // all subarrays ending at j are valid
            count += (j - i + 1);
        }

        return count;
    }

    public static void main(String[] args)
    {
        _9CountNiceSubarrays solver =
                new _9CountNiceSubarrays();

        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;

        int result = solver.numberOfSubarrays(nums, k);
        System.out.println("Nice subarrays count: " + result); // Expected: 2
    }
}

/*
====================== DRY RUN ======================

nums = [1, 1, 2, 1, 1]

----------------------------------------------------
Step 1: atMost(3)
----------------------------------------------------

Initial:
i = 0, k = 3, count = 0

j = 0 -> nums[0] = 1 (odd)
k = 2
window = [0..0]
count += (0 - 0 + 1) = 1
count = 1

j = 1 -> nums[1] = 1 (odd)
k = 1
window = [0..1]
count += 2
count = 3

j = 2 -> nums[2] = 2 (even)
k = 1
window = [0..2]
count += 3
count = 6

j = 3 -> nums[3] = 1 (odd)
k = 0
window = [0..3]
count += 4
count = 10

j = 4 -> nums[4] = 1 (odd)
k = -1  ❌

Shrink window:
nums[i]=1 (odd) -> k = 0
i = 1

window = [1..4]
count += (4 - 1 + 1) = 4
count = 14

atMost(3) = 14

----------------------------------------------------
Step 2: atMost(2)
----------------------------------------------------

Initial:
i = 0, k = 2, count = 0

j = 0 -> odd -> k = 1
count += 1  -> 1

j = 1 -> odd -> k = 0
count += 2  -> 3

j = 2 -> even
count += 3  -> 6

j = 3 -> odd -> k = -1 ❌

Shrink:
nums[i]=1 (odd) -> k = 0
i = 1

count += (3 - 1 + 1) = 3
count = 9

j = 4 -> odd -> k = -1 ❌

Shrink:
nums[i]=1 (odd) -> k = 0
i = 2

count += (4 - 2 + 1) = 3
count = 12

atMost(2) = 12

----------------------------------------------------
Final Calculation:
Exactly 3 odds = atMost(3) - atMost(2)
               = 14 - 12
               = 2  ✅
====================================================
*/
