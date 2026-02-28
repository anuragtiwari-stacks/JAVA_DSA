package _03LinkedList._3PW;

public class _17ReverseBetweenPositions
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
            head = newNode;
        else
        {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newNode;
        }
    }

    public Node reverseBetween(Node head, int left, int right)
    {
        if (head == null || left == right)
            return head;

        Node dummy = new Node(0); // dummy node to simplify edge cases
        dummy.next = head;

        Node prev = dummy;

        // Step 1: Move prev to node before "left"
        for (int i = 1; i < left; i++)
        {
            prev = prev.next;
        }

        // Start reversing
        Node curr = prev.next;
        Node next = null;
        Node prevSub = null;

        // Step 2: Reverse from left to right
        for (int i = left; i <= right; i++)
        {
            next = curr.next;
            curr.next = prevSub;
            prevSub = curr;
            curr = next;
        }

        // Step 3: Connect reversed sublist back
        prev.next.next = curr;
        prev.next = prevSub;

        return dummy.next;
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
        _17ReverseBetweenPositions list = new _17ReverseBetweenPositions();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.print("Original list: ");
        list.printList();

        list.head = list.reverseBetween(list.head, 2, 4);

        System.out.print("Reversed list from 2 to 4: ");
        list.printList();
    }
}

/*
Reverse Linked List from position left to right

1. Use a dummy node pointing to head to handle edge cases easily.

2. Move a pointer `prev` to the node just before position `left`.

3. Reverse the sublist from `left` to `right` by changing pointers.

4. Connect the reversed sublist back to the main list.

5. Return the updated list starting from dummy.next.
*/
