package _3LinkedList._1BASIC;

import java.util.Scanner;

public class _6SearchInInteger
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Node head = null;

        System.out.print("Enter number of integer nodes: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++)
        {
            System.out.print("Enter integer for node " + (i + 1) + ": ");
            int data = sc.nextInt();
            head = insertAtEnd(head, String.valueOf(data));
        }

        System.out.print("Enter integer to search: ");
        int key = sc.nextInt();

        searchInInteger(head, key);
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

    public static void searchInInteger(Node head, int key)
    {
        String strKey = String.valueOf(key);
        Node temp = head;
        int pos = 1;
        boolean found = false;

        while (temp != null)
        {
            if (temp.data.equals(strKey))
            {
                System.out.println("Found " + key + " at position " + pos);
                found = true;
                break;
            }
            temp = temp.next;
            pos++;
        }

        if (!found)
        {
            System.out.println(key + " not found in the list.");
        }
    }
}
