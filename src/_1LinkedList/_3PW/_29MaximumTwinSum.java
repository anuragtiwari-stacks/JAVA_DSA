package _1LinkedList._3PW;

/*
LeetCode 2130 – Maximum Twin Sum of a Linked List

Concept:
1) Linked list ki length even hoti hai.
2) Har node ka "twin" hota hai:
   - 1st node ka twin = last node
   - 2nd node ka twin = second last node
3) Maximum (node.data + twin.data) nikalna hota hai.

Approach:
1) Slow–Fast pointer se middle find karo.
2) Second half ko reverse karo.
3) First half aur reversed second half ko saath traverse karo.
4) Har step par twin sum calculate karo aur maximum store karo.
*/

public class _29MaximumTwinSum
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

    // Reverse linked list
    public static ListNode reverse(ListNode head)
    {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null)
        {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static int pairSum(ListNode head)
    {
        // Step 1: Find middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        ListNode secondHalf = reverse(slow);

        // Step 3: Calculate twin sums
        int maxSum = 0;
        ListNode firstHalf = head;

        while (secondHalf != null)
        {
            int twinSum = firstHalf.val + secondHalf.val;
            maxSum = Math.max(maxSum, twinSum);

            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return maxSum;
    }

    // For testing
    public static void main(String[] args)
    {
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println(pairSum(head));
    }
}

/*
---------------- DRY RUN ----------------

Input:
5 -> 4 -> 2 -> 1

Step 1: Find middle
slow = 2

Step 2: Reverse second half
2 -> 1  becomes  1 -> 2

Now:
First half : 5 -> 4
Second half: 1 -> 2

Step 3: Twin sum calculation
5 + 1 = 6  → max = 6
4 + 2 = 6  → max = 6

Final Answer:
6
---------------------------------------
*/
