package _15Greedy.MIK;
// LeetCode 624: Maximum Distance in Arrays

import java.util.*;

public class _28MaximumDistanceInArrays
{
    public int maxDistance(List<List<Integer>> arrays)
    {
        int MIN = arrays.get(0).get(0);
        int MAX = arrays.get(0).get(arrays.get(0).size() - 1);

        int result = 0;

        for (int i = 1; i < arrays.size(); i++)
        {
            int currMin = arrays.get(i).get(0);
            int currMax = arrays.get(i).get(arrays.get(i).size() - 1);

            result = Math.max(result, Math.abs(currMin - MAX));
            result = Math.max(result, Math.abs(currMax - MIN));

            MAX = Math.max(MAX, currMax);
            MIN = Math.min(MIN, currMin);
        }

        return result;
    }

    public static void main(String[] args)
    {
        _28MaximumDistanceInArrays obj = new _28MaximumDistanceInArrays();

        List<List<Integer>> arrays = new ArrayList<>();
        arrays.add(Arrays.asList(1, 2, 3));
        arrays.add(Arrays.asList(4, 5));
        arrays.add(Arrays.asList(1, 2, 3, 10));

        System.out.println("Output: " + obj.maxDistance(arrays));
    }
}


/*
===================== DRY RUN =====================

Input:
[
  [1,2,3],
  [4,5],
  [1,2,3,10]
]

Step-1:
MIN = 1
MAX = 3
result = 0

i = 1:
currMin = 4
currMax = 5

option1 = |currMin - MAX| = |4 - 3| = 1
option2 = |currMax - MIN| = |5 - 1| = 4

result = max(0, 1, 4) = 4

Update:
MAX = max(3, 5) = 5
MIN = min(1, 4) = 1

i = 2:
currMin = 1
currMax = 10

option1 = |currMin - MAX| = |1 - 5| = 4
option2 = |currMax - MIN| = |10 - 1| = 9

result = max(4, 4, 9) = 9

Update:
MAX = max(5, 10) = 10
MIN = min(1, 1) = 1

Final result = 9

===================================================
*/
