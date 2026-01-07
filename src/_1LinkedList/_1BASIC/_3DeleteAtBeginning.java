package _1LinkedList._1BASIC;

public class _3DeleteAtBeginning
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

    // Delete node at beginning
    public void deleteAtBeginning()
    {
        if (head == null)
        {
            System.out.println("List is empty.");
            return;
        }
        head = head.next;
    }

    // Print the list
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
        _3DeleteAtBeginning list = new _3DeleteAtBeginning();

        // Directly creating list by adding fixed nodes
        list.add("add1");
        list.add("add2");
        list.add("add3");
        list.add("add4");
        list.add("add5");

        System.out.print("Original list: ");
        list.printList();

        list.deleteAtBeginning();

        System.out.print("After deleting at beginning: ");
        list.printList();
    }
}
