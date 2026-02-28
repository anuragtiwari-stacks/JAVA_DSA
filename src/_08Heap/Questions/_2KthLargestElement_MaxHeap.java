package _08Heap.Questions;

import java.util.PriorityQueue;
import java.util.Collections;

public class _2KthLargestElement_MaxHeap
{

    public static int findKthLargest(int[] arr, int k)
    {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Step 1: add all elements to max heap
        for (int num : arr)
        {
            maxHeap.add(num);
        }

        // Step 2: remove top k-1 elements
        for (int i = 1; i < k; i++)
        {
            maxHeap.remove();
        }

        // Step 3: kth largest element
        return maxHeap.peek();
    }

    public static void main(String[] args)
    {
        int[] arr = { 3, 2, 1, 5, 6, 4 };
        int k = 2;

        int result = findKthLargest(arr, k);

        System.out.println("Kth Largest Element: " + result);
    }
}

/*
========================
DRY RUN
========================

Array = [3, 2, 1, 5, 6, 4]
k = 2

Step 1: Build Max Heap
Add 3 → [3]
Add 2 → [3, 2]
Add 1 → [3, 2, 1]
Add 5 → [5, 3, 1, 2]
Add 6 → [6, 5, 3, 2, 1]
Add 4 → [6, 5, 4, 2, 1, 3]

Step 2: Remove k-1 = 1 element
remove() → removes 6
Heap = [5, 3, 4, 2, 1]

Step 3: Peek
Top = 5

OUTPUT:
Kth Largest Element = 5

========================
TIME COMPLEXITY: O(n + k log n)
SPACE COMPLEXITY: O(n)
========================
END
========================
*/
