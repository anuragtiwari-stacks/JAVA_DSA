package _03LinkedList._3PW;

public class _4RemoveNthFromEnd
{
    static class Node
    {
        String data;
        Node next;

        Node(String data)
        {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;

    // Add node at end
    public void add(String data)
    {
        Node newNode = new Node(data);
        if (head == null)
        {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null)
        {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Print list
    public void printList()
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // Count length
    public int getLength()
    {
        int count = 0;
        Node temp = head;
        while (temp != null)
        {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // Remove Nth node from end (brute force)
    public void removeNthFromEnd(int n)
    {
        int length = getLength();
        int posFromStart = length - n;

        if (posFromStart < 0)
        {
            System.out.println("Invalid position.");
            return;
        }

        if (posFromStart == 0)
        {
            // Remove head
            head = head.next;
            return;
        }

        Node temp = head;
        for (int i = 0; i < posFromStart - 1; i++)
        {
            temp = temp.next;
        }

        // temp is node before the one to remove
        if (temp != null && temp.next != null)
        {
            temp.next = temp.next.next;
        }
    }

    public static void main(String[] args)
    {
        _4RemoveNthFromEnd list = new _4RemoveNthFromEnd();

        list.add("add1");
        list.add("add2");
        list.add("add3");
        list.add("add4");
        list.add("add5");

        System.out.print("Original list: ");
        list.printList();

        int n = 3; // Remove 3rd node from end → "add3"
        list.removeNthFromEnd(n);

        System.out.print("After removing " + n + "th node from end: ");
        list.printList();
    }
}
