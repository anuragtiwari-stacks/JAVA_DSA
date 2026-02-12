package _8Heap.Questions;

import java.util.*;

public class _4KClosestPointsToOrigin
{

    public static List<int[]> kClosest(int[][] points, int k)
    {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> distance(b) - distance(a));

        for (int[] p : points)
        {
            maxHeap.add(p);

            if (maxHeap.size() > k)
            {
                maxHeap.remove();
            }
        }

        return new ArrayList<>(maxHeap);
    }

    private static int distance(int[] p)
    {
        return p[0] * p[0] + p[1] * p[1];
    }

    public static void main(String[] args)
    {
        int[][] points = {
                {1, 3},
                {-2, 2},
                {5, 8},
                {0, 1},
                {2, 2}
        };

        int k = 3;

        List<int[]> result = kClosest(points, k);

        for (int[] p : result)
        {
            System.out.println("(" + p[0] + ", " + p[1] + ")");
        }
    }
}

/*
========================
DRY RUN
========================

Points:
(1,3)  -> dist = 10
(-2,2) -> dist = 8
(5,8)  -> dist = 89
(0,1)  -> dist = 1
(2,2)  -> dist = 8

k = 3

Add (1,3)   Heap = [(1,3)]
Add (-2,2)  Heap = [(1,3),(-2,2)]
Add (5,8)   Heap = [(5,8),(1,3),(-2,2)]

Add (0,1)
Heap = [(5,8),(1,3),(-2,2),(0,1)]
Size > k → remove (5,8)
Heap = [(1,3),(-2,2),(0,1)]

Add (2,2)
Heap = [(1,3),(-2,2),(0,1),(2,2)]
Size > k → remove (1,3)
Heap = [(-2,2),(2,2),(0,1)]

Final k closest points:
(-2,2), (2,2), (0,1)

========================
TIME COMPLEXITY:
O(n log k)

SPACE COMPLEXITY:
O(k)

========================
END
========================
*/
