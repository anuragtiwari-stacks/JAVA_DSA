package _5Heap.Questions;

import java.util.*;

public class _7MinimumCostToConnectRopes
{

    public static int minCost(int[] ropes)
    {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int rope : ropes)
        {
            minHeap.add(rope);
        }

        int totalCost = 0;

        while (minHeap.size() > 1)
        {
            int first = minHeap.remove();
            int second = minHeap.remove();

            int cost = first + second;
            totalCost += cost;

            minHeap.add(cost);
        }

        return totalCost;
    }

    public static void main(String[] args)
    {
        int[] ropes = { 4, 3, 2, 6 };

        System.out.println(minCost(ropes));
    }
}

/*
========================
QUESTION: Minimum Cost to Connect Ropes
========================

You are given an array of integers where each integer represents
the length of a rope.

You need to connect all the ropes into one rope.
The cost of connecting two ropes is equal to the sum of their lengths.

Find the minimum total cost required to connect all the ropes.

Rule:
- At every step, you can connect any two ropes.
- The optimal strategy is to always connect the two shortest ropes first.

Example:
Input:  [4, 3, 2, 6]
Output: 29

========================
END QUESTION
========================
*/

/*
========================
DRY RUN
========================

ropes = [4, 3, 2, 6]

Step 1: Add all ropes to Min Heap
Heap = [2, 3, 4, 6]

Step 2:
remove → 2
remove → 3
cost = 5
totalCost = 5
add 5
Heap = [4, 5, 6]

Step 3:
remove → 4
remove → 5
cost = 9
totalCost = 14
add 9
Heap = [6, 9]

Step 4:
remove → 6
remove → 9
cost = 15
totalCost = 29
add 15
Heap = [15]

Only one rope left → STOP

OUTPUT:
29

========================
TIME COMPLEXITY:
O(n log n)

SPACE COMPLEXITY:
O(n)

========================
END
========================
*/
