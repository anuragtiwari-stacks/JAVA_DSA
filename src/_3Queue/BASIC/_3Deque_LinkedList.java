package _3Queue.BASIC;

import java.util.Deque;
import java.util.LinkedList;

public class _3Deque_LinkedList
{
    public static void main(String[] args)
    {
        Deque<Integer> deque = new LinkedList<>();

        // Add elements to the front
        deque.addFirst(100);
        deque.addFirst(200);

        // Add elements to the rear
        deque.addLast(300);
        deque.addLast(400);

        // Print the deque
        System.out.println("Deque: " + deque); // Output: [200, 100, 300, 400]

        // Remove elements from front and rear
        System.out.println("Removed from front: " + deque.removeFirst()); // 200
        System.out.println("Removed from rear: " + deque.removeLast());   // 400

        // Peek at front and rear
        System.out.println("Front: " + deque.peekFirst()); // 100
        System.out.println("Rear: " + deque.peekLast());   // 300

        // Final state of deque
        System.out.println("Deque after operations: " + deque); // [100, 300]
    }
}
