package _05Queue._1CONCEPT;

import java.util.Scanner;

public class _1QueueImplementationArray
{
    int size;
    int front;
    int rear;
    int[] queue;

    public _1QueueImplementationArray(int size)
    {
        this.size = size;
        queue = new int[size];
        front = -1;
        rear = -1;
    }

    public void enqueue(int value)
    {
        if (rear == size - 1)
        {
            System.out.println("Queue is full.");
        }
        else
        {
            if (front == -1)
            {
                front = 0;
            }

            rear++;
            queue[rear] = value;
        }
    }

    public void dequeue()
    {
        if (front == -1 || front > rear)
        {
            System.out.println("Queue is empty.");
        }
        else
        {
            System.out.println("Dequeued: " + queue[front]);
            front++;

            if (front > rear)
            {
                front = -1;
                rear = -1;
            }
        }
    }

    public void peek()
    {
        if (front == -1 || front > rear)
        {
            System.out.println("Queue is empty.");
        }
        else
        {
            System.out.println("Front element: " + queue[front]);
        }
    }

    public void display()
    {
        if (front == -1 || front > rear)
        {
            System.out.println("Queue is empty.");
        }
        else
        {
            System.out.print("Queue: ");
            for (int i = front; i <= rear; i++)
            {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of the queue: ");
        int n = sc.nextInt();

        _1QueueImplementationArray q = new _1QueueImplementationArray(n);

        int choice = 0;

        while (choice != 5)
        {
            System.out.println("\n1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Peek");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            if (choice == 1)
            {
                System.out.print("Enter value to enqueue: ");
                int val = sc.nextInt();
                q.enqueue(val);
            }
            else if (choice == 2)
            {
                q.dequeue();
            }
            else if (choice == 3)
            {
                q.display();
            }
            else if (choice == 4)
            {
                q.peek();
            }
            else if (choice == 5)
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
