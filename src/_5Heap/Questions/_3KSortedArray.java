package _5Heap.Questions;

import java.util.PriorityQueue;

public class _3KSortedArray
{

    public static void sort(int[] arr, int k)
    {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int idx = 0;

        for (int i = 0; i < arr.length; i++)
        {
            minHeap.add(arr[i]);

            if (minHeap.size() > k)
            {
                arr[idx++] = minHeap.remove();
            }
        }

        while (!minHeap.isEmpty())
        {
            arr[idx++] = minHeap.remove();
        }
    }

    public static void main(String[] args)
    {
        int[] arr = { 6, 5, 3, 2, 8, 10, 9 };
        int k = 3;

        sort(arr, k);

        for (int x : arr)
        {
            System.out.print(x + " ");
        }
    }
}

/*
========================
DRY RUN
========================

Array = [6, 5, 3, 2, 8, 10, 9]
k = 3

Min Heap

Add 6  → [6]
Add 5  → [5, 6]
Add 3  → [3, 6, 5]
Add 2  → [2, 3, 5, 6]
Size > k → remove 2 → arr[0] = 2

Add 8  → [3, 6, 5, 8]
remove 3 → arr[1] = 3

Add 10 → [5, 6, 8, 10]
remove 5 → arr[2] = 5

Add 9  → [6, 9, 8, 10]
remove 6 → arr[3] = 6

Remove remaining:
8 → arr[4]
9 → arr[5]
10 → arr[6]

Final Array:
[2, 3, 5, 6, 8, 9, 10]

========================
END
========================
*/
