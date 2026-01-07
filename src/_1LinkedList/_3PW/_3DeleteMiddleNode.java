package _1LinkedList._3PW;

public class _3DeleteMiddleNode
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

    // Delete the middle node
    public void deleteMiddle()
    {
        if (head == null)
        {
            System.out.println("List is empty.");
            return;
        }

        if (head.next == null)
        {
            // Only one node, deleting head
            head = null;
            return;
        }

        Node slow = head;
        Node fast = head;
        Node prev = null;  // To track node before slow

        // Move fast pointer two steps and slow one step until fast reaches end
        while (fast != null && fast.next != null)
        {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }

        // Now slow is pointing to middle node, prev is node before it
        // Delete middle node
        prev.next = slow.next;
    }

    public static void main(String[] args)
    {
        _3DeleteMiddleNode list = new _3DeleteMiddleNode();

        // Create list
        list.add("add1");
        list.add("add2");
        list.add("add3");
        list.add("add4");
        list.add("add5");

        System.out.print("Original list: ");
        list.printList();

        list.deleteMiddle();

        System.out.print("After deleting middle node: ");
        list.printList();
    }
}
