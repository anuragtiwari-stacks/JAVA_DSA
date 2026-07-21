package OA.Infosys;

import java.util.*;
class Main8
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

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args)
    {
        System.out.println("Enter size of listA: ");
        int n1 = sc.nextInt();
        ListNode headA = createList(n1);

        System.out.println("Enter size of ListB: ");
        int n2 = sc.nextInt();
        ListNode headB = createList(n2);

        ListNode result = getIntersection(headA,headB);

        if(result == null)
        {
            System.out.println(-1);
        }
        else
        {
            System.out.println(result.val);
        }

    }

    public static ListNode createList(int n)
    {
        ListNode head = new ListNode(sc.nextInt());
        ListNode tail = head;

        for(int i=1;i<n;i++)
        {
            tail.next = new ListNode(sc.nextInt());
            tail= tail.next;
        }
        return head;
    }

    public static ListNode getIntersection(ListNode headA,ListNode headB)
    {
        int length1 = getLength(headA);
        int length2 = getLength(headB);

        while(length2 > length1)
        {
            headB = headB.next;
            length2--;
        }

        while(length2 < length1)
        {
            headA = headA.next;
            length1--;
        }

        while(headA!=null &&  headB!=null)
        {
            if(headA == headB)
            {
                return headA;
            }
            headA=headA.next;
            headB=headB.next;
        }
        return null;
    }

    public static int getLength(ListNode head)
    {
        ListNode temp = head;
        int count = 0;

        while(temp!=null)
        {
            temp = temp.next;
            count++;
        }
        return count;
    }

}
