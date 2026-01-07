package _1LinkedList._1BASIC;

public class _4DeleteAtEnd
{
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

    // Delete node at end
    public void deleteAtEnd()
    {
        if (head == null)
        {
            System.out.println("List is empty.");
            return;
        }

        if (head.next == null)  // Only one node
        {
            head = null;
            return;
        }

        Node temp = head;
        Node prev = null;

        while (temp.next != null)
        {
            prev = temp;
            temp = temp.next;
        }

        prev.next = null;
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
        _4DeleteAtEnd list = new _4DeleteAtEnd();

        list.add("add1");
        list.add("add2");
        list.add("add3");
        list.add("add4");
        list.add("add5");

        System.out.print("Original list: ");
        list.printList();

        list.deleteAtEnd();

        System.out.print("After deleting at end: ");
        list.printList();
    }
}
