package _03LinkedList._3PW;

public class _16MaxTwinSumLinkedList
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

    public static Node getLast(Node head, Node stop)
    {
        Node temp = head;

        while (temp.next != stop)
        {
            temp = temp.next;
        }

        return temp;
    }

    // Max Twin Sum using head + getLast
    public int maxTwinSum()
    {
        Node start = head;
        Node end = null;

        int max = 0;

        while (start != end && start.next != end)
        {
            Node last = getLast(head, end);

            int sum = start.data + last.data;

            max = Math.max(max, sum); // using Math.max

            start = start.next;
            end = last;
        }

        return max;
    }

    // Print list
    public void print()
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
        _16MaxTwinSumLinkedList list = new _16MaxTwinSumLinkedList();

        list.add(5);
        list.add(4);
        list.add(1);
        list.add(2);

        System.out.print("List: ");
        list.print();

        System.out.println("Max Twin Sum: " + list.maxTwinSum());
    }
}