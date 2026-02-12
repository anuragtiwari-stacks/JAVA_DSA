package _5Queue._1CONCEPT;

import java.util.Scanner;

public class _2QueueImplementationLinkedList
{
    static class Node
    {
        int data;
        Node next;

        Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }

    Node front;
    Node rear;

    public _2QueueImplementationLinkedList()
    {
        front = null;
        rear = null;
    }

    public void enqueue(int value)
    {
        Node newNode = new Node(value);

        if (rear == null)
        {
            front = newNode;
            rear = newNode;
        }
        else
        {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public void dequeue()
    {
        if (front == null)
        {
            System.out.println("Queue is empty.");
        }
        else
        {
            System.out.println("Dequeued: " + front.data);
            front = front.next;

            if (front == null)
            {
                rear = null;
            }
        }
    }

    public void peek()
    {
        if (front == null)
        {
            System.out.println("Queue is empty.");
        }
        else
        {
            System.out.println("Front element: " + front.data);
        }
    }

    public void display()
    {
        if (front == null)
        {
            System.out.println("Queue is empty.");
        }
        else
        {
            System.out.print("Queue: ");
            Node temp = front;

            while (temp != null)
            {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }

            System.out.println();
        }
    }

    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);

        _2QueueImplementationLinkedList q = new _2QueueImplementationLinkedList();

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
