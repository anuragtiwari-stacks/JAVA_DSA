package _8Heap.Questions;

import java.util.PriorityQueue;

public class _10KthLargestInStream
{
    PriorityQueue<Integer> minHeap;
    int k;

    public _10KthLargestInStream(int k, int[] nums)
    {
        this.k = k;
        minHeap = new PriorityQueue<>();

        for (int num : nums)
        {
            add(num);
        }
    }

    public int add(int val)
    {
        minHeap.add(val);

        if (minHeap.size() > k)
        {
            minHeap.poll();
        }

        return minHeap.peek();
    }

    public static void main(String[] args)
    {
        int k = 3;
        int[] nums = {4, 5, 8, 2};

        _10KthLargestInStream obj = new _10KthLargestInStream(k, nums);

        System.out.println(obj.add(3));
        System.out.println(obj.add(5));
        System.out.println(obj.add(10));
        System.out.println(obj.add(9));
        System.out.println(obj.add(4));
    }
}

/*
Problem:
Kth Largest Element in a Stream

Initial nums = [4, 5, 8, 2]
k = 3

Step-by-step:

Insert 4 → heap = [4]
Insert 5 → heap = [4, 5]
Insert 8 → heap = [4, 5, 8]
Insert 2 → heap = [2, 4, 8, 5] → size > k → remove 2
Heap = [4, 5, 8]

Now stream starts:

add(3)
heap = [3, 4, 8, 5] → remove 3
peek = 4

add(5)
heap = [4, 5, 8, 5] → remove 4
peek = 5

add(10)
heap = [5, 5, 8, 10] → remove 5
peek = 5

add(9)
heap = [5, 9, 8, 10] → remove 5
peek = 8

add(4)
heap = [4, 8, 9, 10] → remove 4
peek = 8

Output:
4
5
5
8
8
*/
