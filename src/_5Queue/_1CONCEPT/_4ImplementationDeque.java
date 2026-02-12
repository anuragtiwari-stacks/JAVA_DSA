package _5Queue._1CONCEPT;

import java.util.Scanner;

public class _4ImplementationDeque
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

    public _4ImplementationDeque()
    {
        front = null;
    }

    public void insertFront(int value)
    {
        Node newNode = new Node(value);
        newNode.next = front;
        front = newNode;
    }

    public void insertRear(int value)
    {
        Node newNode = new Node(value);

        if (front == null)
        {
            front = newNode;
        }
        else
        {
            Node temp = front;

            while (temp.next != null)
            {
                temp = temp.next;
            }

            temp.next = newNode;
        }
    }

    public void deleteFront()
    {
        if (front == null)
        {
            System.out.println("Deque is empty.");
        }
        else
        {
            System.out.println("Deleted from front: " + front.data);
            front = front.next;
        }
    }

    public void deleteRear()
    {
        if (front == null)
        {
            System.out.println("Deque is empty.");
        }
        else if (front.next == null)
        {
            System.out.println("Deleted from rear: " + front.data);
            front = null;
        }
        else
        {
            Node temp = front;

            while (temp.next.next != null)
            {
                temp = temp.next;
            }

            System.out.println("Deleted from rear: " + temp.next.data);
            temp.next = null;
        }
    }

    public void peekFront()
    {
        if (front == null)
        {
            System.out.println("Deque is empty.");
        }
        else
        {
            System.out.println("Front element: " + front.data);
        }
    }

    public void peekRear()
    {
        if (front == null)
        {
            System.out.println("Deque is empty.");
        }
        else
        {
            Node temp = front;

            while (temp.next != null)
            {
                temp = temp.next;
            }

            System.out.println("Rear element: " + temp.data);
        }
    }

    public void display()
    {
        if (front == null)
        {
            System.out.println("Deque is empty.");
        }
        else
        {
            System.out.print("Deque: ");
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

        _4ImplementationDeque dq = new _4ImplementationDeque();

        int choice = 0;

        while (choice != 7)
        {
            System.out.println("\n1. Insert Front");
            System.out.println("2. Insert Rear");
            System.out.println("3. Delete Front");
            System.out.println("4. Delete Rear");
            System.out.println("5. Peek Front");
            System.out.println("6. Peek Rear");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            if (choice == 1)
            {
                System.out.print("Enter value: ");
                int val = sc.nextInt();
                dq.insertFront(val);
            }
            else if (choice == 2)
            {
                System.out.print("Enter value: ");
                int val = sc.nextInt();
                dq.insertRear(val);
            }
            else if (choice == 3)
            {
                dq.deleteFront();
            }
            else if (choice == 4)
            {
                dq.deleteRear();
            }
            else if (choice == 5)
            {
                dq.peekFront();
            }
            else if (choice == 6)
            {
                dq.peekRear();
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
