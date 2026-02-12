/*
========================
QUESTION: Last Stone Weight
========================

You are given an array of integers called stones, where each integer
represents the weight of a stone.

You repeatedly perform the following operation until there is
at most one stone left:

1. Pick the two heaviest stones.
2. Smash them together:
   - If both stones have the same weight, both are destroyed.
   - If the stones have different weights, the smaller stone is destroyed
     and the larger stone’s weight becomes (larger − smaller).
     The new stone is added back to the collection.

Return the weight of the last remaining stone.
If there are no stones left, return 0.

Example:
Input:  stones = [2, 7, 4, 1, 8, 1]
Output: 1

Explanation:
- Smash 8 and 7 → new stone = 1
- Smash 4 and 2 → new stone = 2
- Smash 2 and 1 → new stone = 1
- Smash 1 and 1 → both destroyed
- One stone remains with weight 1

========================
END QUESTION
========================
*/

package _8Heap.Questions;

import java.util.PriorityQueue;
import java.util.Collections;

public class _6LastStoneWeight_MaxHeap
{

    public static int lastStoneWeight(int[] stones)
    {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Step 1: add all stones to max heap
        for (int stone : stones)
        {
            maxHeap.add(stone);
        }

        // Step 2: smash stones until one or none left
        while (maxHeap.size() > 1)
        {
            int y = maxHeap.remove(); // heaviest
            int x = maxHeap.remove(); // second heaviest

            if (y != x)
            {
                maxHeap.add(y - x);
            }
        }

        // Step 3: return result
        if (maxHeap.isEmpty())
        {
            return 0;
        }
        else
        {
            return maxHeap.remove();
        }
    }

    public static void main(String[] args)
    {
        int[] stones = { 2, 7, 4, 1, 8, 1 };

        System.out.println(lastStoneWeight(stones));
    }
}

/*
========================
DRY RUN
========================

stones = [2, 7, 4, 1, 8, 1]

Step 1: Build MAX HEAP
Add 2 → [2]
Add 7 → [7,2]
Add 4 → [7,2,4]
Add 1 → [7,2,4,1]
Add 8 → [8,7,4,1,2]
Add 1 → [8,7,4,1,2,1]

Step 2: Smash stones

remove → 8
remove → 7
8 != 7 → add (1)
Heap = [4,2,1,1,1]

remove → 4
remove → 2
4 != 2 → add (2)
Heap = [2,1,1,1]

remove → 2
remove → 1
2 != 1 → add (1)
Heap = [1,1,1]

remove → 1
remove → 1
equal → nothing added
Heap = [1]

Step 3:
Only one stone left → 1

OUTPUT:
1

========================
TIME COMPLEXITY:
O(n log n)

SPACE COMPLEXITY:
O(n)

========================
END
========================
*/
