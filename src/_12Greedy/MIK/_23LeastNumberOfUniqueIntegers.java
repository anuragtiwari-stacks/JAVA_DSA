// LeetCode 1481 - Least Number of Unique Integers After K Removals

package _12Greedy.MIK;

import java.util.*;

public class _23LeastNumberOfUniqueIntegers
{
    public int findLeastNumOfUniqueInts(int[] arr, int k)
    {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : arr)
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

        List<Integer> freq = new ArrayList<>(map.values());
        Collections.sort(freq);

        for(int i = 0; i < freq.size(); i++)
        {
            if(k >= freq.get(i))
            {
                k -= freq.get(i);
                freq.set(i, 0);
            }
            else
            {
                break;
            }
        }

        int count = 0;
        for(int f : freq)
        {
            if(f > 0) count++;
        }

        return count;
    }

    public static void main(String[] args)
    {
        _23LeastNumberOfUniqueIntegers obj = new _23LeastNumberOfUniqueIntegers();
        int[] arr = {4,3,1,1,3,3,2};
        int k = 3;
        int result = obj.findLeastNumOfUniqueInts(arr, k);
        System.out.println(result);
    }
}

/*
==================== DRY RUN ====================

Input:
arr = [4,3,1,1,3,3,2]
k = 3

Step-1: freq map build
4 -> 1
3 -> 3
1 -> 2
2 -> 1

Step-2: collect freq list
freq = [1,3,2,1]

Step-3: sort freq
freq = [1,1,2,3]

Step-4: remove using k

i=0: freq=1, k=3 >=1 → remove -> k=2, freq=[0,1,2,3]
i=1: freq=1, k=2 >=1 → remove -> k=1, freq=[0,0,2,3]
i=2: freq=2, k=1 <2  → stop

Step-5: count non-zero freq
Remaining: [2,3] → count = 2

Output:
2

Console:
2

=================================================
*/
