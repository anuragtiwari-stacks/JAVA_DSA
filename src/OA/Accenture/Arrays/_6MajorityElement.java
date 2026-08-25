package OA.Accenture.Arrays;

// Question: Find the majority element in an array (appears more than n/2 times)

import java.util.HashMap;

public class _6MajorityElement
{
    public static void main(String[] args)
    {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};

        System.out.println(findMajorityElement(arr));
    }

    static int findMajorityElement(int[] arr)
    {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++)
        {
            if(map.containsKey(arr[i]))
            {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
            else
            {
                map.put(arr[i], 1);
            }
        }

        int max = Integer.MIN_VALUE;
        int majorityElement = -1;

        for(int key : map.keySet())
        {
            if(map.get(key) > max)
            {
                max = map.get(key);
                majorityElement = key;
            }
        }

        if(max == Integer.MIN_VALUE)
        {
            return -1;
        }
        else
        {
            return majorityElement;
        }
    }
}