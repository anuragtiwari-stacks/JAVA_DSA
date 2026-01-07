package _5Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class _2MaxHeapSTL
{

    public static void main(String[] args)
    {

        // Max-heap using reverse order comparator
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        maxHeap.add(10);
        maxHeap.add(25);
        maxHeap.add(5);
        maxHeap.add(30);
        maxHeap.add(15);

        System.out.println("Initial Max-Heap:");
        System.out.println(maxHeap);

        while (!maxHeap.isEmpty())
        {

            // Show the largest element
            System.out.println("Peek: " + maxHeap.peek());

            // Remove the largest element
            int removed = maxHeap.remove();
            System.out.println("Removed: " + removed);

            // Show remaining heap
            System.out.println("Heap now: " + maxHeap);
            System.out.println();

        }

    }

}
