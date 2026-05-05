package _08Heap.Questions;

import java.util.*;

public class _5TopKFrequentElement
{
    static class Pair
    {
        int num;
        int freq;

        Pair(int num, int freq)
        {
            this.num = num;
            this.freq = freq;
        }
    }

    public static List<Integer> topKFrequent(int[] nums, int k)
    {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Frequency count (without getOrDefault)
        for (int num : nums)
        {
            if (map.containsKey(num))
            {
                map.put(num, map.get(num) + 1);
            }
            else
            {
                map.put(num, 1);
            }
        }

        // Max Heap
        PriorityQueue<Pair> maxHeap =
                new PriorityQueue<>((a, b) -> Integer.compare(b.freq, a.freq));

        for (int key : map.keySet())
        {
            maxHeap.add(new Pair(key, map.get(key)));
        }

        // Extract top k
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < k; i++)
        {
            result.add(maxHeap.poll().num);
        }

        return result;
    }

    public static void main(String[] args)
    {
        int[] nums = { 1, 2, 1, 3, 1, 3, 3, 3, 2, 3, 2, 3, 4, 5, 4 };
        int k = 3;

        System.out.println(topKFrequent(nums, k));
    }
}