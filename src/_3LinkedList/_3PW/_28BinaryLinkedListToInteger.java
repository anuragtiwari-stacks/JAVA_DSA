package _3LinkedList._3PW;

/*
LeetCode 1290 – Convert Binary Number in a Linked List to Integer

Concept (As required):
1) Linked list ke digits ko pehle ek binary number jaisa build karte hain.
   Example: 1 -> 0 -> 1  =>  binary = 101
2) Us binary number ko decimal me convert karte hain using formula:
   decimal = decimal + digit * (2 ^ power)
*/

public class _28BinaryLinkedListToInteger
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

    // Step 1: Linked List -> Binary Number
    public static int linkedListToBinaryNumber(ListNode head)
    {
        int binary = 0;

        while (head != null)
        {
            binary = binary * 10 + head.val;
            head = head.next;
        }

        return binary;
    }

    // Step 2: Binary Number -> Decimal Number
    public static int binaryToDecimal(int binary)
    {
        int decimal = 0;
        int power = 0;

        while (binary > 0)
        {
            int digit = binary % 10;

            decimal = decimal + digit * (int)Math.pow(2, power);

            power++;
            binary = binary / 10;
        }

        return decimal;
    }

    public static int getDecimalValue(ListNode head)
    {
        int binary = linkedListToBinaryNumber(head);
        return binaryToDecimal(binary);
    }

    // For testing
    public static void main(String[] args)
    {
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);

        int result = getDecimalValue(head);
        System.out.println(result);
    }
}

/*
---------------- DRY RUN ----------------

Input Linked List:
1 -> 0 -> 1

Step 1: Linked List -> Binary Number
binary = 0
binary = 0 * 10 + 1 = 1
binary = 1 * 10 + 0 = 10
binary = 10 * 10 + 1 = 101

Step 2: Binary -> Decimal Conversion

binary = 101
decimal = 0, power = 0

digit = 1
decimal = decimal + 1 * (2^0)
decimal = 0 + 1 = 1

digit = 0
decimal = decimal + 0 * (2^1)
decimal = 1 + 0 = 1

digit = 1
decimal = decimal + 1 * (2^2)
decimal = 1 + 4 = 5

Final Output:
5
---------------------------------------
*/
