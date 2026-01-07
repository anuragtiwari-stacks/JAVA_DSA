package _1LinkedList._3PW;

public class _13GroupByOddEven
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

    // Group nodes by EVEN values first, then ODD values
    public void groupByEvenOddValue()
    {
        if (head == null || head.next == null)
        {
            return;
        }

        Node evenDummy = new Node(0);
        Node oddDummy = new Node(0);

        Node even = evenDummy;
        Node odd = oddDummy;
        Node current = head;

        while (current != null)
        {
            if (current.data % 2 == 0)
            {
                even.next = current;
                even = even.next;
            }
            else
            {
                odd.next = current;
                odd = odd.next;
            }
            current = current.next;
        }

        odd.next = null;              // terminate odd list
        even.next = oddDummy.next;    // connect even -> odd

        head = evenDummy.next;        // ✅ update head
    }

    public void printList()
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        _13GroupByOddEven list = new _13GroupByOddEven();

        list.add(2);
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(6);
        list.add(4);
        list.add(7);

        System.out.print("Original List: ");
        list.printList();

        list.groupByEvenOddValue();

        System.out.print("Grouped List (Even first): ");
        list.printList();
    }
}
