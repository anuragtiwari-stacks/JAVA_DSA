/*
What is the dummy node and why do we use it?
The dummy node is a temporary, fake node we create at the start of the merged linked list.
It doesn’t hold any meaningful data (we set it to 0 here just as a placeholder).
We use it to simplify the code by avoiding special cases when adding the first node to the merged list.
Instead of checking if the merged list is empty every time, we always attach nodes after this dummy node.
After merging, the actual head of the merged list is dummy.next (because dummy itself is just a placeholder).
*/

package _03LinkedList._3PW;

public class _11MergeTwoSortedLists
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

    public static Node mergeLists(Node l1, Node l2)
    {
        Node dummy = new Node(0);
        Node tail = dummy;

        while (l1 != null && l2 != null)
        {
            if (l1.data < l2.data)
            {
                tail.next = l1;
                l1 = l1.next;
            }
            else
            {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        if (l1 != null)
        {
            tail.next = l1;
        }
        else
        {
            tail.next = l2;
        }

        return dummy.next;
    }

    public static void printList(Node head)
    {
        while (head != null)
        {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("NULL");
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
        Node list1 = null;
        Node list2 = null;

        list1 = add(list1, 1);
        list1 = add(list1, 3);
        list1 = add(list1, 5);

        list2 = add(list2, 2);
        list2 = add(list2, 4);
        list2 = add(list2, 6);

        System.out.print("List 1: ");
        printList(list1);

        System.out.print("List 2: ");
        printList(list2);

        Node merged = mergeLists(list1, list2);

        System.out.print("Merged List: ");
        printList(merged);
    }
}

/*
Why is the dummy node value (0) not visible in the output?

We create a dummy node with value 0 only as a temporary helper node.
This dummy node helps us simplify the merging logic by avoiding special
cases when initializing the merged linked list.

During the merge process, all real nodes (from list1 and list2) are attached
after the dummy node, like this:

dummy(0) -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null

However, at the end of the merge, we do NOT return the dummy node itself.
Instead, we return dummy.next:

return dummy.next;

This means the merged list starts from the first real data node (1),
and the dummy node (0) is skipped.

That is why the output is:
1 -> 2 -> 3 -> 4 -> 5 -> 6 -> NULL

The dummy node exists only to make coding easier and is never part of
the final linked list.
*/
