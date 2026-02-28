package _04Stack.Questions;

import java.util.Stack;

public class _15PalindromeLinkedList
{

    static class ListNode
    {
        int val;
        ListNode next;

        ListNode(int val)
        {
            this.val = val;
        }
    }

    public static boolean isPalindrome(ListNode head)
    {
        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;

        // Step 1: Push all values into the stack
        while (temp != null)
        {
            stack.push(temp.val);
            temp = temp.next;
        }

        // Step 2: Traverse again and compare values with stack
        temp = head;
        while (temp != null)
        {
            if (temp.val != stack.pop())
            {
                return false;
            }
            temp = temp.next;
        }

        return true;
    }

    public static void main(String[] args)
    {
        // ✅ Test Case 1: Palindrome → 1 -> 2 -> 2 -> 1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(1);

        System.out.println("Is Palindrome (Expected: true): " + isPalindrome(head1));

        // ❌ Test Case 2: Not a palindrome → 1 -> 2 -> 3
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);

        System.out.println("Is Palindrome (Expected: false): " + isPalindrome(head2));
    }

}

/*
🧠 PALINDROME LINKED LIST USING STACK

🔍 Problem:
Check if a singly linked list reads the same forward and backward.

🛠️ Approach:
1. Traverse the entire list and push each value into a stack.
2. Traverse again from the head and compare each node’s value with stack.pop().
3. If all values match, it's a palindrome.

📦 Example 1 (true): 1 → 2 → 2 → 1
📦 Example 2 (false): 1 → 2 → 3

🧮 Time Complexity: O(n)
🧠 Space Complexity: O(n) — due to stack

✅ Easy to implement
❗ Does not modify the original list
*/
