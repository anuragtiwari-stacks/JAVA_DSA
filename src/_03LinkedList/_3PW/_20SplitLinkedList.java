package _03LinkedList._3PW;

public class _20SplitLinkedList
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

    public static Node[] splitListToParts(Node head, int k)
    {
        Node[] result = new Node[k];

        // Step 1: Count total length
        int length = 0;
        Node temp = head;

        while (temp != null)
        {
            length++;
            temp = temp.next;
        }

        // Step 2: Base size and extras
        int baseSize = length / k;
        int extras = length % k;

        Node current = head;

        for (int i = 0; i < k; i++)
        {
            Node partHead = current;
            int currentSize = baseSize;

            if (extras > 0)
            {
                currentSize++;
                extras--;
            }

            // Traverse this part
            for (int j = 1; j < currentSize; j++)
            {
                if (current != null)
                {
                    current = current.next;
                }
            }

            // Break the list if needed
            if (current != null)
            {
                Node next = current.next;
                current.next = null;
                current = next;
            }

            result[i] = partHead;
        }

        return result;
    }

    // Create list from array
    public static Node createList(int[] arr)
    {
        Node head = new Node(arr[0]);
        Node temp = head;

        for (int i = 1; i < arr.length; i++)
        {
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }

        return head;
    }

    // Print all parts
    public static void printParts(Node[] parts)
    {
        for (int i = 0; i < parts.length; i++)
        {
            Node temp = parts[i];

            while (temp != null)
            {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }

            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        Node head = createList(arr);
        int k = 3;

        Node[] parts = splitListToParts(head, k);

        System.out.println("Split parts:");
        printParts(parts);
    }
}


/*
==================== DRY RUN ====================

Input:
Linked List = 1 → 2 → 3 → 4 → 5 → 6 → 7 → 8 → 9 → 10
k = 3

------------------------------------------------
Step 1: Count total length
------------------------------------------------
Traverse list:
1 → 2 → 3 → 4 → 5 → 6 → 7 → 8 → 9 → 10

length = 10

------------------------------------------------
Step 2: Calculate baseSize and extras
------------------------------------------------
baseSize = length / k = 10 / 3 = 3
extras   = length % k = 10 % 3 = 1

Meaning:
- First 1 part will have (baseSize + 1) = 4 nodes
- Remaining parts will have baseSize = 3 nodes

------------------------------------------------
Step 3: Split into k parts
------------------------------------------------

current initially points to head (1)

------------------------------------------------
Part 0 (i = 0)
------------------------------------------------
extras > 0 → currentSize = 4, extras = 0
partHead = 1

Traverse currentSize - 1 = 3 nodes:
current = 2
current = 3
current = 4

Break link:
next = 5
current.next = null

Part 0:
1 → 2 → 3 → 4 → null

current now points to 5

------------------------------------------------
Part 1 (i = 1)
------------------------------------------------
extras = 0 → currentSize = 3
partHead = 5

Traverse currentSize - 1 = 2 nodes:
current = 6
current = 7

Break link:
next = 8
current.next = null

Part 1:
5 → 6 → 7 → null

current now points to 8

------------------------------------------------
Part 2 (i = 2)
------------------------------------------------
extras = 0 → currentSize = 3
partHead = 8

Traverse currentSize - 1 = 2 nodes:
current = 9
current = 10

Break link:
next = null
current.next = null

Part 2:
8 → 9 → 10 → null

------------------------------------------------
Final Output Parts
------------------------------------------------
Part 0: 1 2 3 4
Part 1: 5 6 7
Part 2: 8 9 10

================================================
Key Points:
- First (length % k) parts get one extra node
- Order of nodes is preserved
- No new nodes are created, only links are changed
================================================
*/
