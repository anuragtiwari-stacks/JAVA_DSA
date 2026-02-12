package _3LinkedList._3PW;

public class _7DetectCycle
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

    // Detect cycle using Floyd’s Tortoise and Hare Algorithm
    public static boolean hasCycle(Node head)
    {
        if (head == null || head.next == null)
        {
            return false;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
            {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args)
    {
        // Create list: 3 -> 2 -> 0 -> -4
        Node head = new Node(3);
        Node second = new Node(2);
        Node third = new Node(0);
        Node fourth = new Node(-4);

        head.next = second;
        second.next = third;
        third.next = fourth;

        // Create a cycle: tail connects to second node (index 1)
        fourth.next = second;

        boolean result = hasCycle(head);

        System.out.println("Cycle detected? " + result);
    }
}
