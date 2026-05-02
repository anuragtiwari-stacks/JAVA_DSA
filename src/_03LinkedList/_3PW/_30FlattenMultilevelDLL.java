package _03LinkedList._3PW;

public class _30FlattenMultilevelDLL
{
    static class Node
    {
        int val;
        Node prev;
        Node next;
        Node child;

        Node(int val)
        {
            this.val = val;
        }
    }

    public static Node flatten(Node head)
    {
        Node temp = head;

        while (temp != null)
        {
            Node n = temp.next;

            if (temp.child != null)
            {
                // flatten the child list
                Node c = flatten(temp.child);

                // find tail of flattened child
                Node d = c;
                while (d.next != null)
                {
                    d = d.next;
                }

                // connect temp -> child
                temp.next = c;
                c.prev = temp;

                // connect child tail -> next
                if (n != null)
                {
                    d.next = n;
                    n.prev = d;
                }

                // IMPORTANT
                temp.child = null;
            }

            temp = temp.next;
        }

        return head;
    }

    // Print flattened list
    public static void printList(Node head)
    {
        while (head != null)
        {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    // Driver
    public static void main(String[] args)
    {
        /*
        1 - 2 - 3 - 4 - 5 - 6
                  |
                  7 - 8 - 11 - 12
                          |
                          9 - 10
        */

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);

        n1.next = n2; n2.prev = n1;
        n2.next = n3; n3.prev = n2;
        n3.next = n4; n4.prev = n3;
        n4.next = n5; n5.prev = n4;
        n5.next = n6; n6.prev = n5;

        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n11 = new Node(11);
        Node n12 = new Node(12);

        n7.next = n8; n8.prev = n7;
        n8.next = n11; n11.prev = n8;
        n11.next = n12; n12.prev = n11;

        Node n9 = new Node(9);
        Node n10 = new Node(10);

        n9.next = n10; n10.prev = n9;

        n3.child = n7;
        n11.child = n9;

        flatten(n1);

        System.out.print("Flattened List: ");
        printList(n1);
    }
}
