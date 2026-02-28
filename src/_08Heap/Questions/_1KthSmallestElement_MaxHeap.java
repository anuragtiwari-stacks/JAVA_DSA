package _08Heap.Questions;

import java.util.PriorityQueue;
import java.util.Collections;

public class _1KthSmallestElement_MaxHeap
{

    public static int findKthSmallest(int[] arr, int k)
    {
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        for (int num : arr)
        {
            maxHeap.add(num);

            if (maxHeap.size() > k)
            {
                maxHeap.remove();
            }
        }

        return maxHeap.peek();
    }

    public static void main(String[] args)
    {
        int[] arr = { 7, 10, 4, 3, 20, 15 };
        int k = 3;

        int result = findKthSmallest(arr, k);

        System.out.println("Kth Smallest Element: " + result);
    }
}

/*
========================
DRY RUN
========================

Array = [7, 10, 4, 3, 20, 15]
k = 3

Max Heap (size ≤ k)

Add 7
Heap = [7]

Add 10
Heap = [10, 7]

Add 4
Heap = [10, 7, 4]

Add 3
Heap = [10, 7, 4, 3]
Size > k → remove()
Heap = [7, 4, 3]

Add 20
Heap = [20, 7, 4, 3]
Size > k → remove()
Heap = [7, 4, 3]

Add 15
Heap = [15, 7, 4, 3]
Size > k → remove()
Heap = [7, 4, 3]

Top of Heap = 7

OUTPUT:
Kth Smallest Element = 7

========================
END
========================
*/
