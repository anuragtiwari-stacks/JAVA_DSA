package _03LinkedList._1BASIC;

import java.util.Scanner;

class Node
{
    String data;
    Node next;

    Node(String data)
    {
        this.data = data;
        this.next = null;
    }
}

public class _2InsertAtEnd
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Node head = null;

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < n; i++)
        {
            System.out.print("Enter data for node " + (i + 1) + ": ");
            String data = sc.nextLine();
            head = insertAtEnd(head, data);
        }

        printList(head);
        sc.close();
    }

    public static Node insertAtEnd(Node head, String data)
    {
        Node newNode = new Node(data);

        if (head == null)
        {
            return newNode;
        }

        Node temp = head;
        while (temp.next != null)
        {
            temp = temp.next;
        }

        temp.next = newNode;
        return head;
    }

    public static void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}
