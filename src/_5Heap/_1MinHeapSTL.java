package _5Heap;

import java.util.PriorityQueue;

public class _1MinHeapSTL
{

    public static void main(String[] args)
    {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        minHeap.add(20);
        minHeap.add(5);
        minHeap.add(15);
        minHeap.add(3);
        minHeap.add(12);

        System.out.println("Initial Heap:");
        System.out.println(minHeap);

        while (!minHeap.isEmpty())
        {

            // Show the top element without removing
            System.out.println("Peek: " + minHeap.peek());

            // Remove the top element
            int removed = minHeap.remove();
            System.out.println("Removed: " + removed);

            // Show current heap
            System.out.println("Heap now: " + minHeap);
            System.out.println();

        }

    }

}
