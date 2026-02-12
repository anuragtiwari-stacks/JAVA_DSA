package _8Heap.Questions;

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

        // Step 1: Frequency count
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

        // Step 2: MAX HEAP using lambda
        PriorityQueue<Pair> maxHeap =
                new PriorityQueue<>((a, b) -> b.freq - a.freq);

        for (int key : map.keySet())
        {
            maxHeap.add(new Pair(key, map.get(key)));
        }

        // Step 3: Remove top k elements
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < k; i++)
        {
            result.add(maxHeap.remove().num);
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

/*
========================
DRY RUN
========================

nums = [1,2,1,3,1,3,3,3,2,3,2,3,4,5,4]
k = 3

Step 1: Frequency Map
1 → 3
2 → 3
3 → 6
4 → 2
5 → 1

Step 2: Build MAX HEAP (higher freq → higher priority)

Heap elements:
(1,3), (2,3), (3,6), (4,2), (5,1)

Heap Top:
(3,6)

Step 3: Remove k times
remove → 3
remove → 1
remove → 2

(Result order of 1 and 2 may vary because freq same)

Final Answer:
[3, 1, 2]  OR  [3, 2, 1]

========================
TIME COMPLEXITY:
O(n log n)

SPACE COMPLEXITY:
O(n)

========================
END
========================
*/
