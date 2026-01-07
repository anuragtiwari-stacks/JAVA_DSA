package _1LinkedList._3PW;

public class _1LinkedListLength
{
    // Inner class Node
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

    public int length(Node node)
    {
        int count = 0;
        Node temp = node;

        while (temp != null)
        {
            count++;
            temp = temp.next;
        }

        return count;
    }


    public static void main(String[] args)
    {
        _1LinkedListLength list = new _1LinkedListLength();

        list.add(5);
        list.add(15);
        list.add(25);
        list.add(35);

        int len = list.length(list.head);

        System.out.println("Length of the linked list (recursive): " + len);
    }
}
