package _1LinkedList._3PW;

public class _25NumberToLinkedList
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

    // reverse the number
    public static long reverseNumber(long num)
    {
        long rev = 0;

        while (num > 0)
        {
            rev = rev * 10 + (num % 10);
            num = num / 10;
        }

        return rev;
    }

    // add at end
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

    public static Node numberToLinkedList(long number)
    {
        long rev = reverseNumber(number);

        Node head = null;

        while (rev > 0)
        {
            int digit = (int)(rev % 10);
            head = add(head, digit);
            rev = rev / 10;
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

    public static void main(String[] args)
    {
        long number = 1234;

        Node head = numberToLinkedList(number);

        System.out.print("Linked List: ");
        printList(head);
    }
}

/*
Number → Linked List

Steps:
1) Reverse the given number.
2) Traverse reversed number digit by digit.
3) Each digit ko linked list ke END me add karo.

Example:
Number = 1234
Reverse = 4321

Add normally:
4 -> 3 -> 2 -> 1 -> NULL
*/
