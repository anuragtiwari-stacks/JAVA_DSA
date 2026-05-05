package _08Heap.Questions;

import java.util.*;

public class _4KClosestPointsToOrigin_MinHeap
{
    public static List<int[]> kClosest(int[][] points, int k)
    {
        // Min Heap with inline distance calculation
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(
                        a[0]*a[0] + a[1]*a[1],
                        b[0]*b[0] + b[1]*b[1]
                )
        );

        // Add all points
        for (int[] p : points)
        {
            minHeap.add(p);
        }

        // Extract k closest
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < k; i++)
        {
            result.add(minHeap.poll());
        }

        return result;
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