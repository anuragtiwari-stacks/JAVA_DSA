package _3LinkedList._3PW;

public class _12PartitionList
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

    // Add method
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

    // Partition function
    public Node partition(int x)
    {
        Node beforeDummy = new Node(0);
        Node afterDummy = new Node(0);

        Node before = beforeDummy;
        Node after = afterDummy;
        Node current = head;

        while (current != null)
        {
            if (current.data < x)
            {
                before.next = current;
                before = before.next;
            }
            else
            {
                after.next = current;
                after = after.next;
            }

            current = current.next;
        }

        after.next = null;
        before.next = afterDummy.next;

        return beforeDummy.next;
    }

    // Print method
    public void printList(Node node)
    {
        while (node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }

        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args)
    {
        _12PartitionList list = new _12PartitionList();

        list.add(1);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(2);

        int x = 3;

        System.out.print("Original List: ");
        list.printList(list.head);

        Node partitionedHead = list.partition(x);

        System.out.print("Partitioned List (x = " + x + "): ");
        list.printList(partitionedHead);
    }

}

/*
Partition List – Concept (Simple & Direct):

We want to rearrange the linked list such that:
- All nodes with value less than x come first
- All nodes with value greater than or equal to x come after
- The original relative order of nodes is preserved

Concept used:
1) Create two separate lists using dummy nodes:
   - before list  → stores nodes with value < x
   - after list   → stores nodes with value >= x

2) Traverse the original list once:
   - If current.data < x → attach node to before list
   - Else → attach node to after list

3) After traversal:
   - End the after list by setting after.next = null
   - Connect before list to after list

4) Return beforeDummy.next as the new head
   (dummy nodes are only helpers and not part of final list)

Why dummy nodes?
- They simplify handling of empty lists
- Avoid special cases for the first insertion
- Keep the code clean and readable

Time Complexity: O(n)
Space Complexity: O(1)
(Only pointer rearrangement, no extra nodes created)
*/
