package _3LinkedList._3PW;

public class _24LinkedListToNumber
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

    public static long convertToNumber(Node head)
    {
        long number = 0;
        Node temp = head;

        while (temp != null)
        {
            number = number * 10 + temp.data;
            temp = temp.next;
        }

        return number;
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

        long result = convertToNumber(head);
        System.out.println("Number = " + result);
    }
}

