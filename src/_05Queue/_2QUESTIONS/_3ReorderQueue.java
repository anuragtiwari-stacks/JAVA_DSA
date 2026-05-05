package _05Queue._2QUESTIONS;

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

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        Stack<Integer> rev1 = new Stack<>();
        Stack<Integer> rev2 = new Stack<>();

        // Step 1: split
        for (int i = 0; i < n / 2; i++)
        {
            s1.push(q.poll());
        }

        for (int i = n / 2; i < n; i++)
        {
            s2.push(q.poll());
        }

        // reverse
        while (!s1.isEmpty())
        {
            rev1.push(s1.pop());
        }

        while (!s2.isEmpty())
        {
            rev2.push(s2.pop());
        }

        // interleave
        while (!rev1.isEmpty() && !rev2.isEmpty())
        {
            q.offer(rev1.pop());
            q.offer(rev2.pop());
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
