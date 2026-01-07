package _3Queue.BASIC;

import java.util.LinkedList;
import java.util.Queue;

public class _1ImplementationQueue_LL
{
    public static void main(String[] args)
    {
        // Create a queue using LinkedList
        Queue<String> queue = new LinkedList<>();

        // Add elements (enqueue)
        queue.offer("A");
        queue.offer("B");
        queue.offer("C");

        // Display the queue
        System.out.println("Queue: " + queue); // Output: [A, B, C]

        // Peek at the head of the queue
        System.out.println("Peek: " + queue.peek()); // Output: A

        // Remove elements (dequeue)
        System.out.println("Removed: " + queue.poll()); // Output: A
        System.out.println("Queue after poll: " + queue); // Output: [B, C]

        // Check if queue is empty
        System.out.println("Is empty? " + queue.isEmpty()); // Output: false

        // Size of the queue
        System.out.println("Size: " + queue.size()); // Output: 2
    }
}
