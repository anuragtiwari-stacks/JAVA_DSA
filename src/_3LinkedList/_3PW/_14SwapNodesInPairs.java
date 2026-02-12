package _3LinkedList._3PW;

public class _14SwapNodesInPairs
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

    public static Node swapPairs(Node head)
    {
        Node temp = head;

        while (temp != null && temp.next != null)
        {
            // swap data
            int t = temp.data;
            temp.data = temp.next.data;
            temp.next.data = t;

            // move to next pair
            temp = temp.next.next;
        }

        return head;
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

    public static Node add(Node head, int data)
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

    public static void main(String[] args)
    {
        Node head = null;

        head = add(head, 1);
        head = add(head, 2);
        head = add(head, 3);
        head = add(head, 4);
        head = add(head, 5);

        System.out.print("Original List: ");
        printList(head);

        head = swapPairs(head);

        System.out.print("After Swap in Pairs: ");
        printList(head);
    }
}

