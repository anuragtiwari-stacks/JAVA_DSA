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

    // Find the middle node data
    public int findMiddle()
    {
        if (head == null)
        {
            throw new IllegalStateException("List is empty");
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow.data;
    }

    public static void main(String[] args)
    {
        _2FindMiddleLinkedList list = new _2FindMiddleLinkedList();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        System.out.println("Middle element is: " + list.findMiddle());
    }
}
