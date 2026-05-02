package _03LinkedList._3PW;

public class _11MergeLinkedList
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

    // Merge two sorted linked lists
    public static Node merge(Node l1, Node l2)
    {
        Node dummy = new Node(-1);
        Node temp = dummy;

        while (l1 != null && l2 != null)
        {
            if (l1.data <= l2.data)
            {
                temp.next = l1;
                l1 = l1.next;
            }
            else
            {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }

        // attach remaining
        if (l1 != null)
        {
            temp.next = l1;
        }
        else
        {
            temp.next = l2;
        }

        return dummy.next;
    }

    // Print list
    public static void print(Node head)
    {
        Node temp = head;

        while (temp != null)
        {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("NULL");
    }

    public static void main(String[] args)
    {
        Node l1 = new Node(1);
        l1.next = new Node(3);
        l1.next.next = new Node(5);

        Node l2 = new Node(2);
        l2.next = new Node(4);
        l2.next.next = new Node(6);

        Node merged = merge(l1, l2);

        print(merged);
    }
}