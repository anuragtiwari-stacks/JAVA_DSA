package _03LinkedList._3PW;

public class _2FindMiddleLinkedList
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

    Node head;

    // Add node at the end
    public void add(int data)
    {
        Node newNode = new Node(data);

        if (head == null)
        {
            head = newNode;
        }
        else
        {
            Node temp = head;

            while (temp.next != null)
            {
                temp = temp.next;
            }

            temp.next = newNode;
        }
    }

    // Odd -> Middle
    // Even -> First Middle
    public int findFirstMiddle()
    {
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }

    // Odd -> Middle
    // Even -> Second Middle
    public int findSecondMiddle()
    {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }


    public static void main(String[] args)
    {
        // Example 1 : Odd Linked List
        _2FindMiddleLinkedList oddList = new _2FindMiddleLinkedList();

        oddList.add(10);
        oddList.add(20);
        oddList.add(30);
        oddList.add(40);
        oddList.add(50);

        System.out.println("Example 1 (Odd):");
        System.out.println("Middle = " + oddList.findFirstMiddle());
        System.out.println("Middle = " + oddList.findSecondMiddle());
        System.out.println();


        // Example 2 : Even Linked List (First Middle)
        _2FindMiddleLinkedList evenList1 = new _2FindMiddleLinkedList();

        evenList1.add(10);
        evenList1.add(20);
        evenList1.add(30);
        evenList1.add(40);
        evenList1.add(50);
        evenList1.add(60);

        System.out.println("Example 2 (Even):");
        System.out.println("First Middle = " + evenList1.findFirstMiddle());
        System.out.println();


        // Example 3 : Even Linked List (Second Middle)
        _2FindMiddleLinkedList evenList2 = new _2FindMiddleLinkedList();

        evenList2.add(10);
        evenList2.add(20);
        evenList2.add(30);
        evenList2.add(40);
        evenList2.add(50);
        evenList2.add(60);

        System.out.println("Example 3 (Even):");
        System.out.println("Second Middle = " + evenList2.findSecondMiddle());
    }
}