package _3LinkedList._1BASIC;

import java.util.Scanner;

class IntNode
{
    int data;
    IntNode next;

    IntNode(int data)
    {
        this.data = data;
        this.next = null;
    }
}

public class _1InsertAtBeginning
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        IntNode head = null, temp = null;

        System.out.print("Enter the number of nodes: ");
        int n = sc.nextInt();

        // Creating the linked list
        for (int i = 0; i < n; i++)
        {
            System.out.print("Enter data for node " + (i + 1) + ": ");
            int data = sc.nextInt();

            IntNode newNode = new IntNode(data);

            if (head == null)
            {
                head = temp = newNode;
            }
            else
            {
                temp.next = newNode;
                temp = newNode;
            }
        }

        // Insert a new node at the beginning
        System.out.print("Enter data for the new node to insert at the beginning: ");
        int newData = sc.nextInt();

        IntNode newNode = new IntNode(newData);
        newNode.next = head;
        head = newNode;

        // Print the linked list
        System.out.print("Linked List: ");
        temp = head;

        while (temp != null)
        {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("NULL");

        sc.close();
    }
}
