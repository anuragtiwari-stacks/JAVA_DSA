package _03LinkedList._1BASIC;

import java.util.Scanner;

public class _8MenuDrivenLinkedList
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Node head = null;

        int choice = -1;  // initialize with a non-zero value

        while (choice != 0)
        {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Insert at Position");
            System.out.println("2. Delete at Position");
            System.out.println("3. Search");
            System.out.println("4. Display List");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice)
            {
                case 1:
                    System.out.print("Enter data to insert: ");
                    String insertData = sc.nextLine();

                    System.out.print("Enter position to insert at (1-based): ");
                    int insertPos = sc.nextInt();
                    sc.nextLine();

                    head = insertAtPosition(head, insertData, insertPos);
                    break;

                case 2:
                    System.out.print("Enter position to delete from (1-based): ");
                    int deletePos = sc.nextInt();
                    sc.nextLine();

                    head = deleteAtPosition(head, deletePos);
                    break;

                case 3:
                    System.out.print("Enter data to search: ");
                    String searchKey = sc.nextLine();
                    searchInList(head, searchKey);
                    break;

                case 4:
                    printList(head);
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        sc.close();
    }

    public static Node insertAtPosition(Node head, String data, int position)
    {
        Node newNode = new Node(data);

        if (position <= 0)
        {
            System.out.println("Invalid position.");
            return head;
        }

        if (position == 1)
        {
            newNode.next = head;
            return newNode;
        }

        Node temp = head;
        for (int i = 1; temp != null && i < position - 1; i++)
        {
            temp = temp.next;
        }

        if (temp == null)
        {
            System.out.println("Position exceeds list length.");
            return head;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        return head;
    }

    public static Node deleteAtPosition(Node head, int position)
    {
        if (head == null)
        {
            System.out.println("List is empty.");
            return null;
        }

        if (position <= 0)
        {
            System.out.println("Invalid position.");
            return head;
        }

        if (position == 1)
        {
            System.out.println("Deleted: " + head.data);
            return head.next;
        }

        Node temp = head;
        for (int i = 1; temp.next != null && i < position - 1; i++)
        {
            temp = temp.next;
        }

        if (temp.next == null)
        {
            System.out.println("Position exceeds list length.");
            return head;
        }

        System.out.println("Deleted: " + temp.next.data);
        temp.next = temp.next.next;

        return head;
    }

    public static void searchInList(Node head, String key)
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

    public static void printList(Node head)
    {
        if (head == null)
        {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}
