package _1LinkedList._1BASIC;

import java.util.Scanner;

public class _7ReverseLinkedList
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Node head = null;

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++)
        {
            System.out.print("Enter data for node " + (i + 1) + ": ");
            String data = sc.nextLine();
            head = insertAtEnd(head, data);
        }

        System.out.println("Original List:");
        printList(head);

        head = reverseList(head);

        System.out.println("Reversed List:");
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

    public static Node reverseList(Node head)
    {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
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
