package _12SlidingWindow;

import java.util.HashMap;

public class _8FruitIntoBaskets
{
    public int totalFruit(int[] fruits)
    {
        int n = fruits.length;
        int i = 0, j = 0;
        int maxLen = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        while (j < n)
        {
            // add right element
            if (map.containsKey(fruits[j]))
            {
                map.put(fruits[j], map.get(fruits[j]) + 1);
            }
            else
            {
                map.put(fruits[j], 1);
            }

            // valid window
            if (map.size() <= 2)
            {
                maxLen = Math.max(maxLen, j - i + 1);
                j++;
            }
            // invalid window → shrink from left
            else
            {
                map.put(fruits[i], map.get(fruits[i]) - 1);
                if (map.get(fruits[i]) == 0)
                {
                    map.remove(fruits[i]);
                }
                i++;
            }
        }

        return maxLen;
    }

    public static void main(String[] args)
    {
        _8FruitIntoBaskets sol = new _8FruitIntoBaskets();

        int[] fruits = {1, 2, 1, 2, 3, 2, 2};
        System.out.println(sol.totalFruit(fruits)); // Expected: 4
    }
}

/*
======================== DRY RUN ========================

fruits = [1,2,1,2,3,2,2]

i=0, j=0, map={}

j=0 → add 1 → map={1=1} → size<=2
window=[0..0], len=1, maxLen=1

j=1 → add 2 → map={1=1,2=1}
window=[0..1], len=2, maxLen=2

j=2 → add 1 → map={1=2,2=1}
window=[0..2], len=3, maxLen=3

j=3 → add 2 → map={1=2,2=2}
window=[0..3], len=4, maxLen=4 ✅

j=4 → add 3 → map={1=2,2=2,3=1} (>2)

shrink:
i=0 → remove 1 → map={1=1,2=2,3=1}
i=1 → remove 2 → map={1=1,2=1,3=1}
i=2 → remove 1 → map={2=1,3=1}

i=3

j=5 → add 2 → map={2=2,3=1}
window=[3..5], len=3

j=6 → add 2 → map={2=3,3=1}
window=[3..6], len=4

Final Answer = 4
========================================================
*/
