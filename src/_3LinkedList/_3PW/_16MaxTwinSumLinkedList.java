package _3LinkedList._3PW;

public class _16MaxTwinSumLinkedList
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

    Node head;

    public void add(int data)
    {
        Node newNode = new Node(data);
        if (head == null)
            head = newNode;
        else
        {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newNode;
        }
    }

    // Reverse linked list and return new head
    private Node reverse(Node head)
    {
        Node prev = null;
        Node curr = head;
        while (curr != null)
        {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Calculate max twin sum
    public int maxTwinSum()
    {
        if (head == null)
            return 0;

        // Find middle (slow & fast)
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        Node secondHalf = reverse(slow);

        Node firstHalf = head;
        int maxSum = 0;

        // Calculate max twin sum by traversing both halves
        while (secondHalf != null)
        {
            int sum = firstHalf.data + secondHalf.data;
            if (sum > maxSum)
                maxSum = sum;

            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        // Optional: restore original list
        // reverse again (not mandatory here)

        return maxSum;
    }

    // Print list for debugging
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

    // Test
    public static void main(String[] args)
    {
        _16MaxTwinSumLinkedList list = new _16MaxTwinSumLinkedList();

        // Example 1
        list.add(5);
        list.add(4);
        list.add(2);
        list.add(1);
        System.out.print("List: ");
        list.printList();
        System.out.println("Max Twin Sum: " + list.maxTwinSum());  // Output: 6

        // Example 2
        _16MaxTwinSumLinkedList list2 = new _16MaxTwinSumLinkedList();
        list2.add(4);
        list2.add(2);
        list2.add(2);
        list2.add(3);
        System.out.print("List: ");
        list2.printList();
        System.out.println("Max Twin Sum: " + list2.maxTwinSum());  // Output: 7

        // Example 3
        _16MaxTwinSumLinkedList list3 = new _16MaxTwinSumLinkedList();
        list3.add(1);
        list3.add(100000);
        System.out.print("List: ");
        list3.printList();
        System.out.println("Max Twin Sum: " + list3.maxTwinSum());  // Output: 100001
    }
}


/*
Maximum Twin Sum Concept:

1. Find the middle of the linked list using slow and fast pointers.

2. Reverse the second half of the linked list starting from the middle.

3. Traverse both halves simultaneously and calculate the twin sums.

4. Keep track of the maximum twin sum found during traversal.

5. (Optional) Restore the reversed second half back to original (if needed).
*/

