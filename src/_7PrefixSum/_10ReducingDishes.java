package _7PrefixSum;

import java.util.Arrays;

public class _10ReducingDishes
{

    // Method to find maximum like-time coefficient
    public static int maxSatisfaction(int[] satisfaction)
    {
        int n = satisfaction.length;

        // Step 1: Sort the array
        Arrays.sort(satisfaction);

        int prefixSum = 0;
        int total = 0;

        // Step 2: Traverse from right to left
        for (int i = n - 1; i >= 0; i--)
        {
            prefixSum = prefixSum + satisfaction[i];

            // If prefix sum becomes negative, stop
            if (prefixSum < 0)
            {
                break;
            }

            total = total + prefixSum;
        }

        return total;
    }

    public static void main(String[] args)
    {
        int[] satisfaction = { -1, -8, 0, 5, -9 };

        int result = maxSatisfaction(satisfaction);

        System.out.println("Maximum Like-Time Coefficient = " + result);
    }
}

/*
=====================
DRY RUN
=====================

satisfaction = { -1, -8, 0, 5, -9 }

Step 1: Sort
satisfaction = { -9, -8, -1, 0, 5 }

Initialize:
prefixSum = 0
total = 0

i = 4 (value = 5):
prefixSum = 0 + 5 = 5
total = 0 + 5 = 5

i = 3 (value = 0):
prefixSum = 5 + 0 = 5
total = 5 + 5 = 10

i = 2 (value = -1):
prefixSum = 5 + (-1) = 4
total = 10 + 4 = 14

i = 1 (value = -8):
prefixSum = 4 + (-8) = -4 ❌ stop

Final Answer:
14
*/

// satisfaction = [ -1, -8, 0, 5, -9 ]
// After Sorting = [ -9, -8, -1, 0, 5 ]

/*
| Step | Dish Added | prefixSum | total  | Note                |
| ---- | ---------- | --------- | ------ | ------------------- |
| 1    | 5          | 5         | 5      | positive → continue |
| 2    | 0          | 5         | 10     | continue            |
| 3    | -1         | 4         | 14     | continue            |
| 4    | -8         | -4        | ❌ stop | prefixSum < 0       |
*/