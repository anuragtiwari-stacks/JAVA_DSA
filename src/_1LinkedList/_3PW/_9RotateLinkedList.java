package _1LinkedList._3PW;

public class _9RotateLinkedList
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

    public static ListNode rotateList(ListNode head, int k)
    {
        if (head == null || head.next == null || k == 0)
        {
            return head;
        }

        // Step 1: Find length
        int length = 0;
        ListNode temp = head;

        while (temp != null)
        {
            length++;
            temp = temp.next;
        }

        k = k % length;

        if (k == 0)
        {
            return head;
        }

        // Step 2: Reverse whole list
        head = reverse(head);

        // Step 3: Reverse first k nodes
        ListNode curr = head;
        ListNode prev = null;
        int count = k;

        while (count > 0)
        {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count--;
        }

        // Step 4: Reverse remaining n-k nodes
        head.next = reverse(curr);

        return prev;
    }

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

    public static void main(String[] args)
    {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("Original List: ");
        printList(head);

        int k = 2;
        head = rotateList(head, k);

        System.out.print("Rotated List: ");
        printList(head);
    }
}
