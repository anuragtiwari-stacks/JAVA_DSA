package _03LinkedList._3PW;

public class _9RemoveDuplicatesSortedList
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
            return;
        }
        Node temp = head;
        while (temp.next != null)
        {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Remove duplicates from sorted linked list
    public void removeDuplicates()
    {
        if (head == null)
        {
            return;
        }

        Node current = head;
        while (current.next != null)
        {
            if (current.data == current.next.data)
            {
                // Skip the duplicate node
                current.next = current.next.next;
            }
            else

            {
                current = current.next;
            }
        }
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

    public static void main(String[] args)
    {
        _9RemoveDuplicatesSortedList list = new _9RemoveDuplicatesSortedList();

        list.add(1);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);

        System.out.print("Original list: ");
        list.printList();

        list.removeDuplicates();

        System.out.print("After removing duplicates: ");
        list.printList();
    }
}
