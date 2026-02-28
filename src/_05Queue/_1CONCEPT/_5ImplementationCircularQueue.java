package _05Queue._1CONCEPT;

import java.util.Scanner;

public class _5ImplementationCircularQueue
{

    int[] queue;
    int size;
    int front;
    int rear;

    public _5ImplementationCircularQueue(int size)
    {
        this.size = size;
        queue = new int[size];
        front = -1;
        rear = -1;
    }

    public boolean isFull()
    {
        return (front == 0 && rear == size - 1) || (rear + 1) % size == front;
    }

    public boolean isEmpty()
    {
        return front == -1;
    }

    public void enqueue(int value)
    {
        if (isFull())
        {
            System.out.println("Queue is full.");
        }
        else
        {
            if (isEmpty())
            {
                front = rear = 0;
            }
            else
            {
                rear = (rear + 1) % size;
            }

            queue[rear] = value;
        }
    }

    public void dequeue()
    {
        if (isEmpty())
        {
            System.out.println("Queue is empty.");
        }
        else
        {
            System.out.println("Deleted: " + queue[front]);

            if (front == rear)
            {
                front = rear = -1;
            }
            else
            {
                front = (front + 1) % size;
            }
        }
    }

    public void peek()
    {
        if (isEmpty())
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
        if (isEmpty())
        {
            System.out.println("Queue is empty.");
        }
        else
        {
            System.out.print("Queue: ");
            int i = front;

            while (true)
            {
                System.out.print(queue[i] + " ");

                if (i == rear)
                {
                    break;
                }

                i = (i + 1) % size;
            }

            System.out.println();
        }
    }

    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of the queue: ");
        int n = sc.nextInt();

        _5ImplementationCircularQueue cq = new _5ImplementationCircularQueue(n);

        int choice = 0;

        while (choice != 6)
        {
            System.out.println("\n1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Is Empty / Is Full");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            if (choice == 1)
            {
                System.out.print("Enter value: ");
                int val = sc.nextInt();
                cq.enqueue(val);
            }
            else if (choice == 2)
            {
                cq.dequeue();
            }
            else if (choice == 3)
            {
                cq.peek();
            }
            else if (choice == 4)
            {
                cq.display();
            }
            else if (choice == 5)
            {
                System.out.println("Is Empty: " + cq.isEmpty());
                System.out.println("Is Full: " + cq.isFull());
            }
            else if (choice == 6)
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
