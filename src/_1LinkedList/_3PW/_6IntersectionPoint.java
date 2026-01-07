package _1LinkedList._3PW;

public class _6IntersectionPoint
{
    static class Node
    {
        int data;
        Node next;

        Node(int data)
        {
            this.data = data;
        }
    }

    // Function to get length of a list
    public static int getLength(Node head)
    {
        int len = 0;
        while (head != null)
        {
            len++;
            head = head.next;
        }
        return len;
    }

    // Function to find intersection node
    public static Node getIntersectionNode(Node headA, Node headB)
    {
        int lenA = getLength(headA);
        int lenB = getLength(headB);

        // Move the longer list's head forward by the length difference
        while (lenA > lenB)
        {
            headA = headA.next;
            lenA--;
        }

        while (lenB > lenA)
        {
            headB = headB.next;
            lenB--;
        }

        // Now move both heads together until they meet
        while (headA != headB)
        {
            headA = headA.next;
            headB = headB.next;
        }

        return headA; // Will be null if no intersection
    }

    // Helper to print list from a node
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
        // Shared part
        Node common = new Node(6);
        common.next = new Node(7);

        // List A: 1 -> 2 -> 3 -> 6 -> 7
        Node headA = new Node(1);
        headA.next = new Node(2);
        headA.next.next = new Node(3);
        headA.next.next.next = common;

        // List B: 4 -> 5 -> 6 -> 7
        Node headB = new Node(4);
        headB.next = new Node(5);
        headB.next.next = common;

        System.out.print("List A: ");
        printList(headA);
        System.out.print("List B: ");
        printList(headB);

        Node intersection = getIntersectionNode(headA, headB);

        if (intersection != null)
        {
            System.out.println("Intersection at node with data: " + intersection.data);
        }
        else
        {
            System.out.println("No intersection.");
        }
    }
}
