package _10Searching;

import java.util.*;

public class _9KthClosestElement
{
    public static List<Integer> findClosestElements(int[] arr, int k, int x)
    {
        // Convert array to list
        List<Integer> list = new ArrayList<>();
        for (int num : arr)
        {
            list.add(num);
        }

        // Sort by closeness to x
        list.sort((a, b) -> {
            int diff1 = Math.abs(a - x);
            int diff2 = Math.abs(b - x);

            if (diff1 == diff2)
            {
                return Integer.compare(a, b); // smaller value first
            }
            return Integer.compare(diff1, diff2);  // closer to x first
        });

        // Take first k elements
        List<Integer> result = list.subList(0, k);

        // Sort result in ascending order
        Collections.sort(result);

        return result;
    }

    public static void main(String[] args)
    {
        int[] arr1 = {1, 2, 3, 4, 5};
        int k1 = 4;
        int x1 = 3;
        System.out.println(findClosestElements(arr1, k1, x1));

        int[] arr2 = {1, 1, 2, 3, 4, 5};
        int k2 = 4;
        int x2 = -1;
        System.out.println(findClosestElements(arr2, k2, x2));
    }
}

/*
====================== DRY RUN ======================

Example 1:
arr = {1, 2, 3, 4, 5}
k = 4
x = 3

Step 1: Convert to list
list = [1, 2, 3, 4, 5]

Step 2: Sort by |value - x|
Value   |value - 3|
1       |2
2       |1
3       |0
4       |1
5       |2

After sorting by difference (tie → smaller value first):
list = [3, 2, 4, 1, 5]

Step 3: Take first k = 4 elements
result = [3, 2, 4, 1]

Step 4: Sort result in ascending order
result = [1, 2, 3, 4]

Final Answer:
[1, 2, 3, 4]

----------------------------------------------------

Example 2:
arr = {1, 1, 2, 3, 4, 5}
k = 4
x = -1

Step 1: Convert to list
list = [1, 1, 2, 3, 4, 5]

Step 2: Compute differences from x = -1
Value   |value + 1|
1       |2
1       |2
2       |3
3       |4
4       |5
5       |6

Already sorted by difference:
list = [1, 1, 2, 3, 4, 5]

Step 3: Take first k = 4 elements
result = [1, 1, 2, 3]

Step 4: Sort result
result = [1, 1, 2, 3]

Final Answer:
[1, 1, 2, 3]

====================================================
*/
