package _1LinkedList._3PW;

/*
LeetCode 2 – Add Two Numbers (Using My Pattern)

Pattern Used:
1) Convert linked list → number
2) Add numbers
3) Convert number → linked list (reverse order as required)

⚠️ Note:
This is a concept-based approach.
LeetCode prefers digit-by-digit addition to avoid overflow.
*/

public class _26AddTwoNumbers
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

    // Convert linked list to number
    public static long linkedListToNumber(ListNode head)
    {
        long num = 0;
        long place = 1;

        while (head != null)
        {
            num = num + head.val * place;
            place = place * 10;
            head = head.next;
        }

        return num;
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

    // Convert number to linked list (reverse order)
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

        return numberToLinkedList(sum);
    }

    // Driver code
    public static void main(String[] args)
    {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3); // represents 342

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4); // represents 465

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
l1 = 2 -> 4 -> 3   (342)
l2 = 5 -> 6 -> 4   (465)

Step 1: Convert LL to number
linkedListToNumber(l1):
2*1 + 4*10 + 3*100 = 342

linkedListToNumber(l2):
5*1 + 6*10 + 4*100 = 465

Step 2: Add
sum = 342 + 465 = 807

Step 3: Convert number to LL
807 % 10 = 7  → 7
80  % 10 = 0  → 7 -> 0
8   % 10 = 8  → 7 -> 0 -> 8

Final Output:
7 -> 0 -> 8 -> NULL
---------------------------------------
*/
