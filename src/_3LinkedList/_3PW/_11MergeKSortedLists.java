package _3LinkedList._3PW;

import java.util.ArrayList;
import java.util.List;

public class _11MergeKSortedLists
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

    // merge two sorted lists
    public static Node mergeTwoLists(Node l1, Node l2)
    {
        if (l1 == null)
        {
            return l2;
        }

        if (l2 == null)
        {
            return l1;
        }

        Node head;

        if (l1.data <= l2.data)
        {
            head = l1;
            l1 = l1.next;
        }
        else
        {
            head = l2;
            l2 = l2.next;
        }

        Node tail = head;

        while (l1 != null && l2 != null)
        {
            if (l1.data <= l2.data)
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

        return head;
    }

    // merge k lists using your concept
    public static Node mergeKLists(List<Node> lists)
    {
        if (lists == null || lists.size() == 0)
        {
            return null;
        }

        while (lists.size() > 1)
        {
            Node last = lists.remove(lists.size() - 1);
            Node secondLast = lists.remove(lists.size() - 1);

            Node merged = mergeTwoLists(secondLast, last);
            lists.add(merged);
        }

        return lists.get(0);
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
        Node l1 = null;
        Node l2 = null;
        Node l3 = null;
        Node l4 = null;

        l1 = add(l1, 1);
        l1 = add(l1, 4);
        l1 = add(l1, 7);

        l2 = add(l2, 2);
        l2 = add(l2, 5);
        l2 = add(l2, 8);

        l3 = add(l3, 3);
        l3 = add(l3, 6);

        l4 = add(l4, 9);
        l4 = add(l4, 10);

        List<Node> lists = new ArrayList<>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        lists.add(l4);

        Node result = mergeKLists(lists);

        System.out.print("Merged List: ");
        printList(result);
    }
}

/*
lists = { l1, l2, l3, l4 }

step 1: merge(l3, l4)  → l34
        lists = { l1, l2, l34 }

step 2: merge(l2, l34) → l234
        lists = { l1, l234 }

step 3: merge(l1, l234)→ l1234
*/