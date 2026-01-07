package _3Queue._1CONCEPT;

import java.util.Scanner;

public class _3ImplementationDequeArray
{
    int size;
    int front;
    int rear;
    int[] deque;

    public _3ImplementationDequeArray(int size)
    {
        this.size = size;
        deque = new int[size];
        front = -1;
        rear = -1;
    }

    public boolean isFull()
    {
        return (front == 0 && rear == size - 1) || (front == rear + 1);
    }

    public boolean isEmpty()
    {
        return front == -1;
    }

    public void insertFront(int value)
    {
        if (isFull())
        {
            System.out.println("Deque is full.");
        }
        else
        {
            if (isEmpty())
            {
                front = rear = 0;
            }
            else if (front == 0)
            {
                front = size - 1;
            }
            else
            {
                front--;
            }

            deque[front] = value;
        }
    }

    public void insertRear(int value)
    {
        if (isFull())
        {
            System.out.println("Deque is full.");
        }
        else
        {
            if (isEmpty())
            {
                front = rear = 0;
            }
            else if (rear == size - 1)
            {
                rear = 0;
            }
            else
            {
                rear++;
            }

            deque[rear] = value;
        }
    }

    public void deleteFront()
    {
        if (isEmpty())
        {
            System.out.println("Deque is empty.");
        }
        else
        {
            System.out.println("Deleted from front: " + deque[front]);

            if (front == rear)
            {
                front = rear = -1;
            }
            else if (front == size - 1)
            {
                front = 0;
            }
            else
            {
                front++;
            }
        }
    }

    public void deleteRear()
    {
        if (isEmpty())
        {
            System.out.println("Deque is empty.");
        }
        else
        {
            System.out.println("Deleted from rear: " + deque[rear]);

            if (front == rear)
            {
                front = rear = -1;
            }
            else if (rear == 0)
            {
                rear = size - 1;
            }
            else
            {
                rear--;
            }
        }
    }

    public void peekFront()
    {
        if (isEmpty())
        {
            System.out.println("Deque is empty.");
        }
        else
        {
            System.out.println("Front element: " + deque[front]);
        }
    }

    public void peekRear()
    {
        if (isEmpty())
        {
            System.out.println("Deque is empty.");
        }
        else
        {
            System.out.println("Rear element: " + deque[rear]);
        }
    }

    public void display()
    {
        if (isEmpty())
        {
            System.out.println("Deque is empty.");
        }
        else
        {
            System.out.print("Deque: ");

            int i = front;

            while (true)
            {
                System.out.print(deque[i] + " ");

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

        System.out.print("Enter size of the deque: ");
        int n = sc.nextInt();

        _3ImplementationDequeArray dq = new _3ImplementationDequeArray(n);

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
