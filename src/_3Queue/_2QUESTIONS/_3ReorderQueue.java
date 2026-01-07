package _3Queue._2QUESTIONS;

import java.util.*;

/*
QUESTION:
Reorder Queue

Given a queue with even number of elements,
reorder it as:
first, last, second, second-last, ...

Example:
Input  : 1 2 3 4 5 6 7 8
Output : 1 8 2 7 3 6 4 5

LOGIC (SIMPLE):
1. Split queue into two halves.
2. Reverse second half using stack.
3. Interleave first half and reversed second half.
*/

public class _3ReorderQueue
{

    public static void reorder(Queue<Integer> q)
    {
        int n = q.size();

        Queue<Integer> firstHalf = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        // Step 1: move first half to firstHalf queue
        for (int i = 0; i < n / 2; i++)
        {
            firstHalf.offer(q.poll());
        }

        // Step 2: push second half into stack
        while (!q.isEmpty())
        {
            stack.push(q.poll());
        }

        // Step 3: interleave
        while (!firstHalf.isEmpty())
        {
            q.offer(firstHalf.poll());
            q.offer(stack.pop());
        }
    }

    public static void display(Queue<Integer> q)
    {
        for (int val : q)
        {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        Queue<Integer> q = new LinkedList<>();

        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        q.offer(5);
        q.offer(6);
        q.offer(7);
        q.offer(8);

        System.out.print("Original Queue: ");
        display(q);

        reorder(q);

        System.out.print("Reordered Queue: ");
        display(q);
    }
}

/*
========================
DRY RUN
========================

Initial Queue:
[1, 2, 3, 4, 5, 6, 7, 8]
n = 8

Step 1: Split first half
firstHalf = [1, 2, 3, 4]
Queue     = [5, 6, 7, 8]

Step 2: Push second half into stack
stack = [5, 6, 7, 8]   (top = 8)
Queue = []

Step 3: Interleave
--------------------------------
Take 1 from firstHalf, 8 from stack
Queue = [1, 8]

Take 2 from firstHalf, 7 from stack
Queue = [1, 8, 2, 7]

Take 3 from firstHalf, 6 from stack
Queue = [1, 8, 2, 7, 3, 6]

Take 4 from firstHalf, 5 from stack
Queue = [1, 8, 2, 7, 3, 6, 4, 5]

Final Queue:
[1, 8, 2, 7, 3, 6, 4, 5]

========================
TIME COMPLEXITY: O(n)
SPACE COMPLEXITY: O(n)
========================
END
========================
*/
