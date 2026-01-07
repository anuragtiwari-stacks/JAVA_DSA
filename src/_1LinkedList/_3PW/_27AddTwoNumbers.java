package _1LinkedList._3PW;

/*
LeetCode 445 – Add Two Numbers II (Using My Exact Concept)

Concept:
1) Linked list digits are in NORMAL order.
   Example: 7 -> 2 -> 4 -> 3 = 7243
2) Convert both linked lists into numbers.
3) Add the two numbers.
4) Reverse the sum.
5) Convert the reversed sum into a linked list
   by adding digits normally (at end).

Note:
This approach is for concept clarity.
LeetCode optimal solution avoids number conversion due to overflow risk.
*/

public class _27AddTwoNumbers
{
    static class ListNode
    {
        int val;
        ListNode next;

        ListNode(int val)
        {
            this.val = val;
            this.next = null;
        }
    }

    // Step 1: Linked List -> Number
    public static long linkedListToNumber(ListNode head)
    {
        long num = 0;

        while (head != null)
        {
            num = num * 10 + head.val;
            head = head.next;
        }

        return num;
    }

    // Step 4: Reverse number
    public static long reverseNumber(long num)
    {
        long rev = 0;

        while (num > 0)
        {
            rev = rev * 10 + (num % 10);
            num = num / 10;
        }

        return rev;
    }

    // Add node at end
    public static ListNode add(ListNode head, int data)
    {
        ListNode newNode = new ListNode(data);

        if (head == null)
        {
            return newNode;
        }

        ListNode temp = head;

        while (temp.next != null)
        {
            temp = temp.next;
        }

        temp.next = newNode;
        return head;
    }

    // Step 5: Number -> Linked List
    public static ListNode numberToLinkedList(long num)
    {
        if (num == 0)
        {
            return new ListNode(0);
        }

        ListNode head = null;

        while (num > 0)
        {
            int digit = (int)(num % 10);
            head = add(head, digit);
            num = num / 10;
        }

        return head;
    }

    // Main logic
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        long n1 = linkedListToNumber(l1);
        long n2 = linkedListToNumber(l2);

        long sum = n1 + n2;

        long reversedSum = reverseNumber(sum);

        return numberToLinkedList(reversedSum);
    }

    // For local testing
    public static void main(String[] args)
    {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3); // 7243

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4); // 564

        ListNode result = addTwoNumbers(l1, l2);

        while (result != null)
        {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
        System.out.println("NULL");
    }
}

/*
---------------- DRY RUN ----------------

Input:
l1 = 7 -> 2 -> 4 -> 3   (7243)
l2 = 5 -> 6 -> 4        (564)

Step 1: Convert LL to number
n1 = 7243
n2 = 564

Step 2: Add numbers
sum = 7243 + 564 = 7807

Step 3: Reverse sum
reverse(7807) = 7087

Step 4: Convert reversed sum to LL
7087 % 10 = 7 → add → 7
7087 / 10 = 708
708 % 10  = 8 → add → 7 -> 8
70 % 10   = 0 → add → 7 -> 8 -> 0
7 % 10    = 7 → add → 7 -> 8 -> 0 -> 7

Final Output:
7 -> 8 -> 0 -> 7 -> NULL
---------------------------------------
*/
