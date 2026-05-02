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

    // Function to reverse nodes in k group
    public static Node reverseKGroup(Node head, int k)
    {
        if (head == null || k == 1)
        {
            return head;
        }

        // 🔹 Step 1: Check if k nodes exist
        Node temp = head;
        int count = 0;

        while (temp != null && count < k)
        {
            temp = temp.next;
            count++;
        }

        // If less than k nodes, return as it is
        if (count < k)
        {
            return head;
        }

        // 🔹 Step 2: Reverse k nodes
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

        // 🔹 Step 3: Recursively reverse remaining list
        head.next = reverseKGroup(current, k);

        // 🔹 Step 4: Return new head
        return prev;
    }

    // Utility function to print list
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

        int k = 2;

        head = reverseKGroup(head, k);

        System.out.print("After reversing in groups of " + k + ": ");
        printList(head);
    }
}