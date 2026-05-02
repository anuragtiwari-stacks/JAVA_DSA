package _03LinkedList._3PW;

public class _10SortLinkedList
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

    // Bubble Sort
    public static Node sortList(Node head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }

        Node end = null;

        while (end != head)
        {
            Node current = head;

            while (current.next != end)
            {
                if (current.data > current.next.data)
                {
                    // swap adjacent nodes data
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                }
                current = current.next;
            }

            end = current; // last node sorted ho gaya
        }

        return head;
    }

    // Print Linked List
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

    // Driver Code
    public static void main(String[] args)
    {
        Node head = new Node(4);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(3);

        System.out.print("Original List: ");
        printList(head);

        head = sortList(head);

        System.out.print("Sorted List: ");
        printList(head);
    }
}