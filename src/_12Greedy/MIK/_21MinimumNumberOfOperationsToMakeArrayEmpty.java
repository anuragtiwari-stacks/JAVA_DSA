// LeetCode 2870 - Minimum Number of Operations to Make Array Empty

package _12Greedy.MIK;

import java.util.HashMap;

public class _21MinimumNumberOfOperationsToMakeArrayEmpty
{
    public int minOperations(int[] nums)
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int x : nums)
        {
            if(map.containsKey(x))
            {
                map.put(x, map.get(x) + 1);
            }
            else
            {
                map.put(x, 1);
            }
        }
        int ops = 0;
        for(int f : map.values())
        {
            if(f == 1)
            {
                return -1;
            }
            ops += (int)Math.ceil((double)f / 3.0);
        }
        return ops;
    }

    public static void main(String[] args)
    {
        _21MinimumNumberOfOperationsToMakeArrayEmpty obj = new _21MinimumNumberOfOperationsToMakeArrayEmpty();
        int[] nums = {2,3,3,2,2,4,4,4,4};
        int result = obj.minOperations(nums);
        System.out.println(result);
    }
}

/*
==================== DRY RUN ====================

Input:
nums = [2,3,3,2,2,4,4,4,4]

Frequency map build:
2 -> 1
3 -> 1
3 -> 2
2 -> 2
2 -> 3
4 -> 1
4 -> 2
4 -> 3
4 -> 4

Final freq:
2 = 3
3 = 2
4 = 4

Compute ops:

freq = 3
ceil(3/3) = ceil(1.0) = 1
ops = 1

freq = 2
ceil(2/3) = ceil(0.66) = 1
ops = 2

freq = 4
ceil(4/3) = ceil(1.33) = 2
ops = 4

Final ops = 4

Console Output:
4

=================================================
*/
