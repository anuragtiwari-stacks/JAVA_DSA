package _05Queue._2QUESTIONS;

import java.util.*;

/*
LOGIC:
1. We are given a queue and a value k.
2. Our task is to reverse the first k elements of the queue.
3. Steps:
   a) Remove first k elements from the queue and push them into a stack.
      - Stack reverses the order (LIFO).
   b) Pop all elements from the stack and add them back to the queue.
      - Now first k elements are reversed but placed at the end.
   c) Rotate the remaining (n - k) elements to the back of the queue
      to maintain their original order.
*/

public class _1ReverseFirstK
{

    public static void reverseFirstK(Queue<Integer> queue, int k)
    {
        if (queue == null || k <= 0 || k > queue.size())
        {
            System.out.println("Invalid value of k");
            return;
        }

        Stack<Integer> stack = new Stack<>();

        // Step 1: Push first k elements into stack
        for (int i = 0; i < k; i++)
        {
            stack.push(queue.remove());
        }

        // Step 2: Pop stack elements back into queue
        while (!stack.isEmpty())
        {
            queue.add(stack.pop());
        }

        // Step 3: Move remaining elements to the back
        int size = queue.size();

        for (int i = 0; i < size - k; i++)
        {
            queue.add(queue.remove());
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        Queue<Integer> queue = new LinkedList<>();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter queue elements:");
        for (int i = 0; i < n; i++)
        {
            queue.add(sc.nextInt());
        }

        System.out.print("Enter value of k: ");
        int k = sc.nextInt();

        System.out.println("Original Queue: " + queue);

        reverseFirstK(queue, k);

        System.out.println("Queue after reversing first " + k + " elements: " + queue);

        sc.close();
    }
}

/*
========================
DRY RUN
========================

Input:
Queue = [1, 2, 3, 4, 5]
k = 3

Step 1: Push first k elements into stack
---------------------------------------
Remove 1 → Stack = [1]        Queue = [2, 3, 4, 5]
Remove 2 → Stack = [1, 2]     Queue = [3, 4, 5]
Remove 3 → Stack = [1, 2, 3]  Queue = [4, 5]

Step 2: Pop stack back into queue
---------------------------------
Pop 3 → Queue = [4, 5, 3]
Pop 2 → Queue = [4, 5, 3, 2]
Pop 1 → Queue = [4, 5, 3, 2, 1]

Step 3: Rotate remaining (n - k = 2) elements
----------------------------------------------
Remove 4 → Queue = [5, 3, 2, 1, 4]
Remove 5 → Queue = [3, 2, 1, 4, 5]

Final Output:
-------------
Queue = [3, 2, 1, 4, 5]

========================
END
========================
*/
