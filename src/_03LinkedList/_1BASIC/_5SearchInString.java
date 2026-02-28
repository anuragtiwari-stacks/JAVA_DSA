package _03LinkedList._1BASIC;

import java.util.Scanner;

public class _5SearchInString
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
            System.out.print("Enter string data for node " + (i + 1) + ": ");
            String data = sc.nextLine();
            head = insertAtEnd(head, data);
        }

        System.out.print("Enter string to search: ");
        String key = sc.nextLine();

        searchInString(head, key);
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

    public static void searchInString(Node head, String key)
    {
        Node temp = head;
        int pos = 1;
        boolean found = false;

        while (temp != null)
        {
            if (temp.data.equals(key))
            {
                System.out.println("Found \"" + key + "\" at position " + pos);
                found = true;
                break;
            }
            temp = temp.next;
            pos++;
        }

        if (!found)
        {
            System.out.println("\"" + key + "\" not found in the list.");
        }
    }
}
