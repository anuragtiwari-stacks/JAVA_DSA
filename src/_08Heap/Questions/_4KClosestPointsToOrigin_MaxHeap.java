package _08Heap.Questions;

import java.util.*;

public class _4KClosestPointsToOrigin_MaxHeap
{
    public static List<int[]> kClosest(int[][] points, int k)
    {
        // Max Heap (largest distance on top)
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(
                        b[0]*b[0] + b[1]*b[1],
                        a[0]*a[0] + a[1]*a[1]
                )
        );

        for (int[] p : points)
        {
            maxHeap.offer(p);

            // keep only k closest
            if (maxHeap.size() > k)
            {
                maxHeap.poll();
            }
        }

        return new ArrayList<>(maxHeap);
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