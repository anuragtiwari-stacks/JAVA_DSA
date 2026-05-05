package _08Heap.Questions;

import java.util.PriorityQueue;

public class _1KthSmallestElement_MinHeap
{
    public static int findKthSmallest(int[] arr, int k)
    {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : arr)
        {
            minHeap.add(num);
        }

        int result = -1;

        for (int i = 1; i < k; i++)
        {
            minHeap.remove();
        }

        return minHeap.peek();

    }

    public static void main(String[] args)
    {

        int[] arr = { 7, 10, 4, 3, 20, 15 };
        int k = 3;

        int kth = findKthSmallest(arr, k);

        System.out.println(k + "rd smallest element is: " + kth);

    }

}
