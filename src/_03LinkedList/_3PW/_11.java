package _03LinkedList._3PW;

public class _11
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

    public static int length(Node head)
    {
        int count = 0;

        while (head != null)
        {
            count++;
            head = head.next;
        }

        return count;
    }

    // add node at end
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

    public static Node mergeLists(Node l1, Node l2)
    {
        int len1 = length(l1);
        int len2 = length(l2);
        int totalLength = len1 + len2;

        Node head = null;

        for (int i = 1; i <= totalLength; i++)
        {
            if (l1 == null)
            {
                head = add(head, l2.data);
                l2 = l2.next;
            }
            else if (l2 == null)
            {
                head = add(head, l1.data);
                l1 = l1.next;
            }
            else if (l1.data <= l2.data)
            {
                head = add(head, l1.data);
                l1 = l1.next;
            }
            else
            {
                head = add(head, l2.data);
                l2 = l2.next;
            }
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
        Node list1 = null;
        Node list2 = null;

        list1 = add(list1, 1);
        list1 = add(list1, 3);
        list1 = add(list1, 5);

        list2 = add(list2, 2);
        list2 = add(list2, 4);
        list2 = add(list2, 6);

        System.out.print("List 1: ");
        printList(list1);

        System.out.print("List 2: ");
        printList(list2);

        Node merged = mergeLists(list1, list2);

        System.out.print("Merged List: ");
        printList(merged);
    }
}
