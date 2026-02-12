package _3LinkedList._3PW;

public class _18ReorderList {

    static class Node {
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

    public void reorderList(Node head)
    {
        if (head == null || head.next == null)
        {
            return;
        }

        // Step 1: Find middle of the list
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half
        Node second = reverse(slow.next);
        slow.next = null;

        // Step 3: Merge both halves
        Node first = head;

        while (second != null)
        {
            Node temp1 = first.next;
            Node temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }

    private Node reverse(Node head)
    {
        Node prev = null;

        while (head != null)
        {
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
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
        _18ReorderList list = new _18ReorderList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.print("Original List: ");
        list.printList();

        list.reorderList(list.head);

        System.out.print("Reordered List: ");
        list.printList();
    }
}

/*
Reorder Linked List into L0 → Ln → L1 → Ln-1 → ...

1. Find the middle of the linked list using slow and fast pointers.

2. Reverse the second half of the list from the middle onward.

3. Merge the two halves alternately using pointer manipulation.

4. Ensure values are not modified, only links are changed.

5. Final result is reordered list with original node values.
*/

/*
==================== DRY RUN ====================
LeetCode 143 – Reorder List
Code used: slow-fast + reverse + merge

Input:
1 → 2 → 3 → 4 → 5

------------------------------------------------
Step 1: Find middle using slow & fast
------------------------------------------------
Initial:
slow = 1
fast = 1

Iteration 1:
slow = 2
fast = 3

Iteration 2:
slow = 3
fast = 5

fast.next == null → stop

Middle node:
slow = 3

Split list:
First half : 1 → 2 → 3 → null
Second half: 4 → 5

------------------------------------------------
Step 2: Reverse second half
------------------------------------------------
Reverse:
4 → 5

After reverse:
5 → 4

Now:
First half : 1 → 2 → 3
Second half: 5 → 4

------------------------------------------------
Step 3: Merge both halves alternately
------------------------------------------------
first  = 1
second = 5

Iteration 1:
temp1 = first.next  → 2
temp2 = second.next → 4

first.next = second → 1 → 5
second.next = temp1 → 5 → 2

Move pointers:
first = 2
second = 4

Current list:
1 → 5 → 2 → 3

-----------------------------------------------
Iteration 2:
temp1 = first.next  → 3
temp2 = second.next → null

first.next = second → 2 → 4
second.next = temp1 → 4 → 3

Move pointers:
first = 3
second = null → stop

------------------------------------------------
Final Reordered List
------------------------------------------------
1 → 5 → 2 → 4 → 3

================================================
Key Idea:
- Middle find
- Second half reverse
- One-by-one merge (first, last, second, second-last)
================================================
*/
