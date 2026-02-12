package _5Queue.BASIC;

import java.util.Deque;
import java.util.ArrayDeque;

public class _2Deque_Array
{
    public static void main(String[] args)
    {
        Deque<Integer> deque = new ArrayDeque<>();

        // Add elements to the front
        deque.addFirst(10);
        deque.addFirst(20);

        // Add elements to the rear
        deque.addLast(30);
        deque.addLast(40);

        // Print the deque
        System.out.println("Deque: " + deque); // Output: [20, 10, 30, 40]

        // Remove from front
        System.out.println("Removed from front: " + deque.removeFirst()); // 20

        // Remove from rear
        System.out.println("Removed from rear: " + deque.removeLast()); // 40

        // Peek elements
        System.out.println("Front: " + deque.peekFirst()); // 10
        System.out.println("Rear: " + deque.peekLast()); // 30

        // Final deque state
        System.out.println("Deque after operations: " + deque); // [10, 30]
    }
}
