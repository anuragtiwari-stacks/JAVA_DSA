package _10PrefixSum;

import java.util.HashMap;

public class _8SubarraySumEquals_K
{
    // Method to count subarrays whose sum equals k
    public static int subarraySum(int[] nums, int k)
    {
        HashMap<Integer, Integer> map = new HashMap<>();

        int prefixSum = 0;
        int count = 0;

        // Base case
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++)
        {
            prefixSum = prefixSum + nums[i];

            // Check if prefixSum - k exists
            if (map.containsKey(prefixSum - k))
            {
                count = count + map.get(prefixSum - k);
            }

            // Update map manually
            if (map.containsKey(prefixSum))
            {
                map.put(prefixSum, map.get(prefixSum) + 1);
            }
            else
            {
                map.put(prefixSum, 1);
            }
        }

        return count;
    }

    public static void main(String[] args)
    {
        int[] nums = { 1, 1, 1 };
        int k = 2;

        int result = subarraySum(nums, k);

        System.out.println("Count = " + result);
    }
}

/*
=====================
DRY RUN
=====================

nums = { 1, 1, 1 }
k = 2

map = { 0 : 1 }
prefixSum = 0
count = 0

i = 0:
prefixSum = 1
prefixSum - k = -1 (not found)
map = { 0:1, 1:1 }

i = 1:
prefixSum = 2
prefixSum - k = 0 (found → freq = 1)
count = 1
map = { 0:1, 1:1, 2:1 }

i = 2:
prefixSum = 3
prefixSum - k = 1 (found → freq = 1)
count = 2
map = { 0:1, 1:1, 2:1, 3:1 }

Final Answer:
Count = 2
*/
