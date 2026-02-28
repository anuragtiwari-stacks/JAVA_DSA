package _08Heap.Questions;

import java.util.PriorityQueue;

public class _2KthLargestElement_MinHeap
{

    public static int findKthLargest(int[] arr, int k)
    {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : arr)
        {
            minHeap.add(num);

            if (minHeap.size() > k)
            {
                minHeap.remove();
            }
        }

        return minHeap.peek();
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

Min Heap (size ≤ k)

Add 3
Heap = [3]

Add 2
Heap = [2, 3]

Add 1
Heap = [1, 3, 2]
Size > k → remove()
Heap = [2, 3]

Add 5
Heap = [2, 3, 5]
Size > k → remove()
Heap = [3, 5]

Add 6
Heap = [3, 5, 6]
Size > k → remove()
Heap = [5, 6]

Add 4
Heap = [4, 6, 5]
Size > k → remove()
Heap = [5, 6]

Top of Heap = 5

OUTPUT:
Kth Largest Element = 5

========================
TIME COMPLEXITY: O(n log k)
SPACE COMPLEXITY: O(k)
========================
END
========================
*/
