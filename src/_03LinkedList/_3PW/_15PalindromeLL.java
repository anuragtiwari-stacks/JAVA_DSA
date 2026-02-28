package _03LinkedList._3PW;

/*
LeetCode 234 – Palindrome Linked List (Using Number Concept)

Concept:
1) Linked list ke data ko ek number me convert karo.
   Example: 1 -> 2 -> 3 -> 2 -> 1  =>  number = 12321
2) Us number ko reverse karo.
3) Agar original number == reversed number
   to linked list palindrome hai.

Note:
- Ye concept-based solution hai.
- Large linked list ke liye number overflow ho sakta hai.
- LeetCode optimal solution slow-fast pointer use karta hai.
*/

public class _15PalindromeLL
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

    // Step 2: Reverse Number
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

    public static boolean isPalindrome(ListNode head)
    {
        long number = linkedListToNumber(head);
        long reversed = reverseNumber(number);

        return number == reversed;
    }

    // For testing
    public static void main(String[] args)
    {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        System.out.println(isPalindrome(head));
    }
}

/*
---------------- DRY RUN ----------------

Input Linked List:
1 -> 2 -> 3 -> 2 -> 1

Step 1: Linked List -> Number
num = 0
num = 0 * 10 + 1 = 1
num = 1 * 10 + 2 = 12
num = 12 * 10 + 3 = 123
num = 123 * 10 + 2 = 1232
num = 1232 * 10 + 1 = 12321

Step 2: Reverse Number
rev = 0
rev = 0 * 10 + 1 = 1
rev = 1 * 10 + 2 = 12
rev = 12 * 10 + 3 = 123
rev = 123 * 10 + 2 = 1232
rev = 1232 * 10 + 1 = 12321

Step 3: Compare
12321 == 12321 → TRUE

Output:
true
---------------------------------------
*/
