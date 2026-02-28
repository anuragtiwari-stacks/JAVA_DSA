package _03LinkedList._3PW;

public class _19ReverseNodesInKGroup
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

    public static Node reverseKGroup(Node head, int k)
    {
        if (head == null || k == 1)
        {
            return head;
        }

        // Step 1: Check k nodes exist
        Node temp = head;
        int count = 0;

        while (temp != null && count < k)
        {
            temp = temp.next;
            count++;
        }

        if (count < k)
        {
            return head; // less than k nodes
        }

        // Step 2: Reverse k nodes
        Node prev = null;
        Node current = head;
        Node next = null;
        count = 0;

        while (current != null && count < k)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        // Step 3: Recursive call for remaining list
        head.next = reverseKGroup(current, k);

        // prev is new head of reversed group
        return prev;
    }

    public static void printList(Node head)
    {
        while (head != null)
        {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args)
    {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.print("Original: ");
        printList(head);

        head = reverseKGroup(head, 2);

        System.out.print("After Reverse in k-Group: ");
        printList(head);
    }
}
