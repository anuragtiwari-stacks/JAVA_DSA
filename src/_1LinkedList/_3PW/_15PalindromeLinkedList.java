package _1LinkedList._3PW;

public class _15PalindromeLinkedList
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

    // find last node before stop
    public static Node getLast(Node head, Node stop)
    {
        Node temp = head;

        while (temp.next != stop)
        {
            temp = temp.next;
        }

        return temp;
    }

    public static boolean isPalindrome(Node head)
    {
        if (head == null || head.next == null)
        {
            return true;
        }

        Node start = head;
        Node end = null;

        while (start != end)
        {
            Node last = getLast(head, end);

            if (start.data != last.data)
            {
                return false;
            }

            start = start.next;
            end = last;
        }

        return true;
    }

    public static Node add(Node head, int data)
    {
        Node newNode = new Node(data);

        if (head == null)
        {
            return newNode;
        }

        Node temp = head;

        while (temp.next != null)
        {
            temp = temp.next;
        }

        temp.next = newNode;
        return head;
    }

    public static void main(String[] args)
    {
        Node head = null;

        head = add(head, 1);
        head = add(head, 2);
        head = add(head, 3);
        head = add(head, 2);
        head = add(head, 1);

        System.out.println(isPalindrome(head));
    }
}

/*
Palindrome Linked List – Concept (Start & End Comparison):

We check whether the linked list reads the same from left to right
and right to left.

Concept used:
- One pointer (start) begins from the head of the list.
- Another pointer (end) represents the last node of the list.

Steps:
1) Compare data of start (head) and end (last node).
2) If values are not equal → list is NOT a palindrome.
3) If values are equal:
   - Move start forward (start = start.next)
   - Move end backward logically.
     (In a singly linked list, we find the previous node of end
      by traversing from head again.)
4) Repeat this process until start meets end.

Important Note:
- In singly linked lists, we cannot directly do end--.
- So we find the last node before the current end each time.

Complexity:
- Time Complexity: O(n²)
  (Because finding the last node repeatedly takes O(n))
- Space Complexity: O(1)

This approach follows the same idea as checking palindrome in an array:
compare first and last, then move inward.
*/
