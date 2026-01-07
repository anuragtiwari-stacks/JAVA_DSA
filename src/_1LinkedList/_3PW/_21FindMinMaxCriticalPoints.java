package _1LinkedList._3PW;

import java.util.*;

public class _21FindMinMaxCriticalPoints
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

    public static int[] nodesBetweenCriticalPoints(ListNode head)
    {
        List<Integer> positions = new ArrayList<>();

        if (head == null || head.next == null || head.next.next == null)
        {
            return new int[]{-1, -1};
        }

        ListNode prev = head;
        ListNode curr = head.next;
        int index = 1; // position of curr

        while (curr.next != null)
        {
            ListNode next = curr.next;

            // check critical point
            if ((curr.val > prev.val && curr.val > next.val) ||
                    (curr.val < prev.val && curr.val < next.val))
            {
                positions.add(index);
            }

            prev = curr;
            curr = next;
            index++;
        }

        if (positions.size() < 2)
        {
            return new int[]{-1, -1};
        }

        int minDist = Integer.MAX_VALUE;

        for (int i = 1; i < positions.size(); i++)
        {
            minDist = Math.min(minDist, positions.get(i) - positions.get(i - 1));
        }

        int maxDist = positions.get(positions.size() - 1) - positions.get(0);

        return new int[]{minDist, maxDist};
    }

    // For testing
    public static void main(String[] args)
    {
        ListNode head = new ListNode(5);
        head.next = new ListNode(3);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next = new ListNode(2);

        int[] ans = nodesBetweenCriticalPoints(head);
        System.out.println(Arrays.toString(ans));
    }
}

/*
Input:
5 → 3 → 1 → 2 → 5 → 1 → 2

Indexing (0-based):
0   1   2   3   4   5   6
5   3   1   2   5   1   2

Check critical points:

Index 2 (value 1):
prev=3 , next=2
3 > 1 < 2 → local minima ✔

Index 4 (value 5):
prev=2 , next=1
2 < 5 > 1 → local maxima ✔

Index 5 (value 1):
prev=5 , next=2
5 > 1 < 2 → local minima ✔

Critical point positions:
[2, 4, 5]

Minimum distance:
min(4-2=2 , 5-4=1) = 1

Maximum distance:
5 - 2 = 3

Output:
[1, 3]
*/
