package _08Heap.Questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _9FindAllDuplicates
{
    public List<Integer> findDuplicates(int[] nums)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

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

        for (int key : map.keySet())
        {
            if (map.get(key) > 1)
            {
                result.add(key);
            }
        }

        return result;
    }

    public static void main(String[] args)
    {
        _9FindAllDuplicates obj = new _9FindAllDuplicates();

        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};

        List<Integer> ans = obj.findDuplicates(nums);

        System.out.println(ans);
    }
}

/*
Input:
[4, 3, 2, 7, 8, 2, 3, 1]

Step 1: Build frequency map
4 -> 1
3 -> 2
2 -> 2
7 -> 1
8 -> 1
1 -> 1

Step 2: Collect elements with count > 1
Duplicates = [2, 3]

Output:
[2, 3]
*/
