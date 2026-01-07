package _3Queue._1CONCEPT;

import java.util.*;

public class _6QueueUsingStacks
{

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    final int MAX_SIZE = 10;

    public void enqueue(int x)
    {
        if (isFull())
        {
            System.out.println("Queue is full.");
            return;
        }

        s1.push(x);
    }

    public int dequeue()
    {
        if (isEmpty())
        {
            return -1;
        }

        if (s2.isEmpty())
        {
            while (!s1.isEmpty())
            {
                s2.push(s1.pop());
            }
        }

        return s2.pop();
    }

    public int peek()
    {
        if (isEmpty())
        {
            return -1;
        }

        if (s2.isEmpty())
        {
            while (!s1.isEmpty())
            {
                s2.push(s1.pop());
            }
        }

        return s2.peek();
    }

    public boolean isEmpty()
    {
        return s1.isEmpty() && s2.isEmpty();
    }

    public boolean isFull()
    {
        return (s1.size() + s2.size()) == MAX_SIZE;
    }

    public void display()
    {
        Stack<Integer> temp = new Stack<>();

        // First print elements in s2 (already reversed)
        for (int i = s2.size() - 1; i >= 0; i--)
        {
            System.out.print(s2.get(i) + " ");
        }

        // To maintain FIFO, we need to reverse s1 before printing
        for (int i = s1.size() - 1; i >= 0; i--)
        {
            System.out.print(s1.get(i) + " ");
        }

        System.out.println();
    }


    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);

        _6QueueUsingStacks q = new _6QueueUsingStacks();

        int choice = 0;

        while (choice != 7)
        {
            System.out.println("\n1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. IsEmpty");
            System.out.println("5. IsFull");
            System.out.println("6. Display");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            if (choice == 1)
            {
                System.out.print("Enter value: ");
                int val = sc.nextInt();
                q.enqueue(val);
            }
            else if (choice == 2)
            {
                int val = q.dequeue();
                if (val == -1)
                {
                    System.out.println("Queue is empty.");
                }
                else
                {
                    System.out.println("Dequeued: " + val);
                }
            }
            else if (choice == 3)
            {
                int val = q.peek();
                if (val == -1)
                {
                    System.out.println("Queue is empty.");
                }
                else
                {
                    System.out.println("Front element: " + val);
                }
            }
            else if (choice == 4)
            {
                System.out.println("IsEmpty: " + q.isEmpty());
            }
            else if (choice == 5)
            {
                System.out.println("IsFull: " + q.isFull());
            }
            else if (choice == 6)
            {
                System.out.print("Queue: ");
                if (q.isEmpty())
                {
                    System.out.println("Queue is empty.");
                }
                else
                {
                    q.display();
                }
            }
            else if (choice == 7)
            {
                System.out.println("Exiting...");
            }
            else
            {
                System.out.println("Invalid choice.");
            }
        }

        sc.close();

    }

}

/*
Logic:
1. Queue is implemented using two stacks (s1 and s2).
2. Enqueue always pushes to s1.
3. Dequeue or peek moves elements from s1 to s2 only when s2 is empty.
4. This ensures FIFO order.
5. isEmpty returns true if both stacks are empty.
6. isFull uses a MAX_SIZE limit and checks combined size of s1 and s2.
7. display prints elements in FIFO order by combining s2 (reversed) and s1 (normal order).
*/
