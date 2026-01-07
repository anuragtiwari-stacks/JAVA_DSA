package _1LinkedList._3PW;

public class _5SwapKthNode
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

    // Helper method to swap kth node from beginning and end
    public static ListNode swapNodes(ListNode head, int k)
    {
        int length = 0;
        ListNode temp = head;

        // Step 1: Find length of the list
        while (temp != null)
        {
            length++;
            temp = temp.next;
        }

        // Step 2: Find kth node from beginning and end
        ListNode firstK = head;
        for (int i = 1; i < k; i++)
        {
            firstK = firstK.next;
        }

        ListNode secondK = head;
        for (int i = 1; i < length - k + 1; i++)
        {
            secondK = secondK.next;
        }

        // Step 3: Swap values
        int t = firstK.val;
        firstK.val = secondK.val;
        secondK.val = t;

        return head;
    }

    // Helper method to print the linked list
    public static void printList(ListNode head)
    {
        ListNode temp = head;
        while (temp != null)
        {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // Helper method to create a linked list from array
    public static ListNode createList(int[] arr)
    {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        for (int i = 1; i < arr.length; i++)
        {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }

        return head;
    }

    public static void main(String[] args)
    {
        int[] input1 = {1, 2, 3, 4, 5};
        int k1 = 2;
        ListNode head1 = createList(input1);
        System.out.print("Original List 1: ");
        printList(head1);
        head1 = swapNodes(head1, k1);
        System.out.print("After swapping k=" + k1 + ": ");
        printList(head1);

        System.out.println();

        int[] input2 = {7, 9, 6, 6, 7, 8, 3, 0, 9, 5};
        int k2 = 5;
        ListNode head2 = createList(input2);
        System.out.print("Original List 2: ");
        printList(head2);
        head2 = swapNodes(head2, k2);
        System.out.print("After swapping k=" + k2 + ": ");
        printList(head2);
    }
}
